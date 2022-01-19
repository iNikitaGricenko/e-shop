package com.wolfhack.diploma.RestController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class StatisticsRest {

    @GetMapping("/TrafficData")
    public String[] getTraffic() {
        return new String[] {"1200","1900","3000"};
    }

    @GetMapping("/EarningData")
    public String[] getEarning() {
        return new String[] {"1200", "1090", "3000", "5400", "1220", "1510", "3600", "4890", "2127", "1321", "1054", "4521"};
    }

}
