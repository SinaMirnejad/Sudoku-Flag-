package sodoku;

import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;
import javax.swing.plaf.synth.SynthSplitPaneUI;

public class SoundAnalizer {
	public Mixer mixer;
	public Clip clip;
	
	public SoundAnalizer() {
		Info[] mixerInfo = AudioSystem.getMixerInfo();
		/*for(Info e: mixerInfo) {
			System.out.println(e);
		}*/
		mixer = AudioSystem.getMixer(mixerInfo[0]);
		
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try {
			clip = (Clip) mixer.getLine(dataInfo);
		}catch(LineUnavailableException e){
			
		}
		try {
			URL soundURL = WorldGenLoop.class.getResource("/sodoku/fever.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);
			//byte[] b = new byte[(int) audioStream.getFrameLength()];
			//audioStream.read(b);
			//for (int i = 0 ; i < audioStream.getFrameLength(); i++ )
			//System.out.println(audioStream.);
		}catch(Exception e) {
			System.out.println("Fuck My Face \n " + e);
		}
		
		clip.start();
	}
}
