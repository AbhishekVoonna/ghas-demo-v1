package com.lab.ghas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.text.StringEscapeUtils;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    // Vulnerable to XSS
    @GetMapping("/greet")
    public String greetUser(@RequestParam String name) {
        String safeName = StringEscapeUtils.escapeHtml4(name);
        return "<h1>Hello, " + safeName + "!</h1>";
    }
}