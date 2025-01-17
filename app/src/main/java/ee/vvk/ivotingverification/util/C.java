package ee.vvk.ivotingverification.util;

import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Configurations from server.
 * 
 * @version 28.05.2013
 */
public class C {

	public static int expectedVersion = 0;

	public static String[] verificationUrlArray = new String[0];

	public static String[] verificationTlsArray = new String[0];

	public static String verificationSNI = "verification.ivxv.invalid";

	public static String configURL = "";

	public static String[] ocspServiceCertArray = new String[0];

	public static String tspregServiceCert = "";

	public static String tspregClientCert = "";

	public static String helpURL = "https://www.valimised.ee/";

	public final static String trustStorePass = "";

	public static Typeface typeFace = Typeface.DEFAULT;

	public static String welcomeMessage = "Hääle kontollimiseks suunake nutiseadme kaamera arvuti ekraanil kuvatavale QR-koodile";

	public static String loading = "Laadib...";

	public static String loadingWindow = "#33B5E5";

	public static String loadingWindowForeground = "#FFFFFF";

	public static String frameBackground = "#AA444444";

	public static String errorWindow = "#FF0000";

	public static String errorWindowShadow = "#770000";

	public static String errorWindowForeground = "#FFFFFF";

	public static String mainWindow = "#33B5E5";

	public static String mainWindowShadow = "#005777";

	public static String mainWindowForeground = "#FFFFFF";

	public static String btnMore = "Abiinfo";

	public static String btnNext = "Edasi";

	public static String btnOk = "Ok";

	public static String btnPacketData = "Andmeside";

	public static String btnWifi = "Wifi";

	public static String btnUpdate = "Värskenda";

	public static String btnVerify = "Kontrolli";

	public static String noChoice = "Valikut ei tehtud";

	public static String btnVerifyForeground = "#FFFFFF";

	public static String btnVerifyBackgroundStart = "#30B4E5";

	public static String btnVerifyBackgroundCenter = "#1AABE1";

	public static String btnVerifyBackgroundEnd = "#00A1DC";

	public static String btnBackground = "#F0F0F0";

	public static String btnForeground = "#727272";

	public static String lblVote = "Hääle kontrollimine";

	public static String lblVoteTxt = "Teie QR-koodile vastav hääl on talletatud valimiste serveris";

	public static String lblVoteSigner = "Hääle allkirjastaja: ";

	public static String lblChoice = "Tuvastatud valik";

	public static String lblCloseTimeout = "Rakendus sulgub XX sekundi pärast!";

	public static String lblBackground = "#33B5E5";

	public static String lblForeground = "#FFFFFF";

	public static String lblShadow = "#008EC2";

	public static String lblOuterContainerBackground = "#EAEAEA";

	public static String lblOuterContainerForeground = "#878686";

	public static String lblInnerContainerBackground = "#FFFFFF";

	public static String lblInnerContainerForeground = "#878686";

	public static String lblOuterInnerContainerDivider = "#E9E9E9";

	public static String lblCloseTimeoutForeground = "#454444";

	public static String lblCloseTimeoutBackgroundStart = "#FEEC00";

	public static String lblCloseTimeoutBackgroundCenter = "#F9D303";

	public static String lblCloseTimeoutBackgroundEnd = "#F7C804";

	public static String lblCloseTimeoutShadow = "#C6A002";

	public static int closeTimeout = 30000;

	public static int closeInterval = 1000;

	public static int connectionTimeout1 = 3000;

	public static int connectionTimeout2 = 15000;

	public static String publicKey = "";

	public static String noNetworkMessage = "Veenduge, et nutiseadme andmeside on võimaldatud";

	public static String getConfigMessage = "Valimiste seadistuse laadimine ebaõnnestus";

	public static String badConfigMessage = "Valimiste seadistuse viga";

	public static String badVersionMessage = "Rakendusest on olemas uuem versioon";

	public static String problemQrCodeMessage = "QR koodi ei õnnestunud tuvastada";

	public static String sendServerRequestMessage = "Valimiste süsteemiga ühendamine ebaõnnestus";

	public static String badServerResponseMessage = "Tehniline viga, palun teavitage valimiste läbiviijat";

	public static String badDeviceMessage = "Selle seadmega ei ole võimalik verifitseerimist läbi viia";

	public static String cameraPermissionRequired = "Rakenduse kasutamiseks peab olema kaamera kasutamine lubatud";

	public static List<String> languages = new ArrayList<>();

	public static HashMap<String, String> elections = new HashMap<>();

	public static ArrayList<String> candidateList = new ArrayList<>();
}
