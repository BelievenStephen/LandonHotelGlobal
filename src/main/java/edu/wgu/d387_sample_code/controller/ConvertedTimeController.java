package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.TimeConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/times")
public class ConvertedTimeController {
    @GetMapping("/converted")
    public List<String> getTimes(){
        return TimeConversion.getConvertedTimes();
    }
}