package com.vmind.virtual_assistants.audioPlayer;

import com.vmind.virtual_assistants.exception.APIException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Log4j2
@Component
public class JLayerPlayer implements AudioPlayer {
    @Override
    public void playAudio(InputStream audioStream) {
        log.debug("[start] JLayerPlayer - playAudio");
        try {
            log.debug("[JLayerPlayer] Playing...");
            new Player(audioStream).play();
        } catch (JavaLayerException e) {
            throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR,"Failed to play the audio: " + e.getMessage(), e);
        }
        log.debug("[finish] JLayerPlayer - playAudio");
    }
}
