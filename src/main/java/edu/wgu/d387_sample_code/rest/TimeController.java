package edu.wgu.d387_sample_code.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeController {

    final private String startTime = "07:00PM EST";
    final private String dateTimeFormat = "hh:mma z";
    final private String[] timeZones = new String[]{"EST", "MST", "UTC"};
    private SimpleDateFormat timeFormat = new SimpleDateFormat(dateTimeFormat);

    @GetMapping("/presentation")
    public ResponseEntity<List<String>> getPresentationTime() {
        List<String> presentationTime = new ArrayList<String>();

        try {
            Date date = timeFormat.parse(startTime);

            for (String time : timeZones) {
                TimeZone timeZone = TimeZone.getTimeZone(time);
                timeFormat.setTimeZone(timeZone);;
                String dateEnd = timeFormat.format(date);
                presentationTime.add(dateEnd);
            }
            TimeZone timeZoneEST = TimeZone.getTimeZone("EST");
            TimeZone timeZoneMST = TimeZone.getTimeZone("MST");
            TimeZone timeZoneUTC = TimeZone.getTimeZone("UST");
        } catch (Exception e) {
            System.out.println(e.toString());
            presentationTime.add(e.toString());
        }
        return ResponseEntity.ok(presentationTime);
    }
}
