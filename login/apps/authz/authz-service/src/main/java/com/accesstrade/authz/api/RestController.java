package com.accesstrade.authz.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Welcome to home page", HttpStatus.OK);
    }
}
