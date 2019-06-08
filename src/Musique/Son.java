package Musique;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

public class Son {
    private AudioFormat format;
    private byte[] samples;
    private Clip clip= null;
    /**
     *
     * @param filename le lien vers le fichier song (URL ou absolute path)
     */
    public Son(String filename){
        try{
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filename));
            format = stream.getFormat();
            samples = getSamples(stream);
            //recuperation du son que l'on va stoquer dans un oblet de type clip
            DataLine.Info info = new DataLine.Info(
                    Clip.class, stream.getFormat(),
                    ((int) stream.getFrameLength() * format.getFrameSize()));
            //recuperation d'une instance de type Clip
           // clip = (Clip) AudioSystem.getLine(info);
        }
        catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public byte[] getSamples(){
        return samples;
    }
    public byte[] getSamples(AudioInputStream stream){
        int length = (int)(stream.getFrameLength() * format.getFrameSize());
        byte[] samples = new byte[length];
        DataInputStream in = new DataInputStream(stream);

        try{
            in.readFully(samples);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return samples;
    }
    public void play(InputStream source) {
        int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
        byte[] buffer = new byte[bufferSize];
        SourceDataLine line;
        try{
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open(format, bufferSize);
        }
        catch (LineUnavailableException e){
            e.printStackTrace();
            return;
        }
        line.start();
        try{
            int numBytesRead = 0;
            while (numBytesRead != -1){
                numBytesRead = source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1)
                    line.write(buffer, 0, numBytesRead);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        line.drain();
        line.close();
    }public void stop(InputStream source){
        int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
        byte[] buffer = new byte[bufferSize];
        SourceDataLine line;
        try{
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open(format, bufferSize);
        }
        catch (LineUnavailableException e){
            e.printStackTrace();
            return;
        }
        line.stop();
        try{
            int numBytesRead = 0;
            while (numBytesRead != -1){
                numBytesRead = source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1)
                    line.write(buffer, 0, numBytesRead);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        line.drain();
        line.close();
    }
}
