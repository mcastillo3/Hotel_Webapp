package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.locale.ReadResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/resources")
@CrossOrigin
public class DisplayMessageController {

    private Executor executor = Executors.newFixedThreadPool(2);

    @GetMapping("welcome")
    public ResponseEntity<List<String>>getWelcomeMessage() {
        List<String> message = new ArrayList<String>();

        // Read en_US
        executor.execute(() -> {
            ReadResource readEN = new ReadResource("en", "US");
            message.add(readEN.getWelcomeMessage());
            System.out.println("en_US Message Received");
        });

        executor.execute(() -> {
            ReadResource readFR = new ReadResource("fr", "CA");
            message.add(readFR.getWelcomeMessage());
            System.out.println("fr_CA Message Received!");
        });

        return ResponseEntity.ok(message);

    }

}
