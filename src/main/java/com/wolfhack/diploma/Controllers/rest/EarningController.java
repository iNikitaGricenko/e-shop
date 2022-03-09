package com.wolfhack.diploma.Controllers.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/earning")
@CrossOrigin(origins = "http://localhost:8080")
public class EarningController {

    @GetMapping
    public String[] getEarning() {
        return new String[] {"1200", "1090", "3000", "5400", "1220", "1510", "3600", "4890", "2127", "1321", "1054", "4521"};
    }

}

