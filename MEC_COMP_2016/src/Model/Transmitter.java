package Model;
import com.sun.speech.freetts.*;

public class Transmitter {
	public final int range = 500;
	private static final String VOICENAME = "kevin16";
	
	public static string printRain {
		if 
	}
	
	void mySpeak()
	{
	Voice voice;
	VoiceManager vm = VoiceManager.getInstance();
	voice = vm.getVoice(VOICENAME);
	voice.allocate();
	try{
	voice.speak("Hi Mr Gaur Welcome to VITS. Thanks To choose Us");
	}catch(Exception e){}
	} 
}
