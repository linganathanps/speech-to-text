package com.linga.ai;

import com.linga.ai.stream.Streaming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@RestController
@EnableWebSocket
public class Main {

    @Autowired
    private Streaming streaming;


    @PostMapping (value="/upload", produces= MediaType.APPLICATION_JSON_VALUE)
    public String upload(@RequestParam("audio")MultipartFile audio, @RequestParam("lang") String language) throws Exception {
        return Streaming.processAudioFile(audio.getBytes(), language);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
