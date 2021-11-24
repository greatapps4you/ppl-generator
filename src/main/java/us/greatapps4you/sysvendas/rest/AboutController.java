package us.greatapps4you.sysvendas.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
public class AboutController {

    @GetMapping("/support")
    public String support() {
        return "support@greatapps4you.us";
    }

    @GetMapping("/donations")
    public String bitcoinWallet() {
        return "194U8i4oKP6pkZSwG1KgsUpFfnjUxbvCso";
    }

}


