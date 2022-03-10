package com.wolfhack.diploma.Controllers.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/traffic")
@CrossOrigin(origins = "http://localhost:8088")
public class TrafficController {

    @GetMapping
    public String[] getTraffic() {
        return new String[] {"1200","1900","3000"};
    }

}
