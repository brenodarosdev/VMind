package com.vmind.virtual_assistants.audioPlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Log4j2
@Component
public class JLayerPlayer implements AudioPlayer {
    @Override
    public void playAudio(InputStream audioStream) {
        log.debug("[start] JLayerPlayer - playAudio");
        try {
            Player player = new Player(audioStream);
            log.debug("[JLayerPlayer] Playing...");
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace(); //TODO Tratar exceções de reprodução
        }
        log.debug("[finish] JLayerPlayer - playAudio");
    }
}
