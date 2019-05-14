package Musique;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class Test {
    public static void main(String[] args){
        Son player=new Son("img/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
        InputStream stream = new ByteArrayInputStream(player.getSamples());
        player.play(stream);
    }
}
