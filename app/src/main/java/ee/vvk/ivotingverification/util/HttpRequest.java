package ee.vvk.ivotingverification.util;

import org.apache.http.conn.ssl.StrictHostnameVerifier;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

@SuppressWarnings("deprecation")
public class HttpRequest {
	private static final String TAG = "HttpRequest";

	private final SSLSocketFactory sslFactory;

	public HttpRequest() throws Exception {
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
		tmf.init((KeyStore) null);
		this.sslFactory = new TLSv13SocketFactory(null, tmf.getTrustManagers(), null);
	}

	public String get(String url) throws IOException {
		URL request = new URL(url);
		if (!"https".equals(request.getProtocol())) {
			throw new MalformedURLException(url);
		}
		HttpsURLConnection urlConnection = (HttpsURLConnection) request.openConnection();
		try {
			System.setProperty("http.keepAlive", "false");
			urlConnection.setHostnameVerifier(new StrictHostnameVerifier());
			urlConnection.setSSLSocketFactory(sslFactory);
			urlConnection.setConnectTimeout(15000);

			if (Util.DEBUGGABLE) {
				urlConnection.connect(); // Explicit connect necessary for getHeaderFields.
				printResponseHeader(urlConnection);
			}
			return Util.readLines(urlConnection.getInputStream(), Util.ENCODING);
		} finally {
			urlConnection.disconnect();
		}
	}

	private void printResponseHeader(URLConnection urlConnection) {
		Util.logDebug(TAG, "Response header:");
		for (Map.Entry<String, List<String>> entry : urlConnection.getHeaderFields().entrySet()) {
			Util.logDebug(TAG, entry.getKey() + ": " + entry.getValue());
		}
	}

	/**
	 * TLSv12SocketFactory wraps a "TLSv1.3" SSLContext's SSLSocketFactory to only enable TLS v1.3.
	 */
	private class TLSv13SocketFactory extends SSLSocketFactory {
		private final SSLSocketFactory factory;

		TLSv13SocketFactory(KeyManager[] km, TrustManager[] tm, SecureRandom random)
				throws NoSuchAlgorithmException, KeyManagementException {
			SSLContext sslcontext = SSLContext.getInstance("TLSv1.3");
			sslcontext.init(km, tm, random);
			factory = sslcontext.getSocketFactory();
		}

		@Override
		public String[] getDefaultCipherSuites() {
			return factory.getDefaultCipherSuites();
		}

		@Override
		public String[] getSupportedCipherSuites() {
			return factory.getSupportedCipherSuites();
		}

		@Override
		public Socket createSocket(Socket s, String host, int port, boolean autoClose)
				throws IOException {
			return tlsv13(factory.createSocket(s, host, port, autoClose));
		}

		@Override
		public Socket createSocket(String host, int port) throws IOException {
			return tlsv13(factory.createSocket(host, port));
		}

		@Override
		public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
				throws IOException {
			return tlsv13(factory.createSocket(host, port, localHost, localPort));
		}

		@Override
		public Socket createSocket(InetAddress host, int port) throws IOException {
			return tlsv13(factory.createSocket(host, port));
		}

		@Override
		public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort)
				throws IOException {
			return tlsv13(factory.createSocket(address, port, localAddress, localPort));
		}

		private Socket tlsv13(Socket socket) {
			if (socket instanceof SSLSocket) {
				((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.3"});
			}
			return socket;
		}
	}
}
