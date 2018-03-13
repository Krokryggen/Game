/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music{
        Clip clip;
        
        public void setFile(String soundFileName){
            try{
        File file = new File(soundFileName);
        AudioInputStream sound = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(sound);
            }
            catch(Exception e){
            
            }
        }
        public void play(){
            clip.setFramePosition(0);
            clip.start();
        }
        
        public void loop(){
        
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        
        public void stop(){
        clip.stop();
        clip.close();
        }
    }