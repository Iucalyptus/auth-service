package com.iucalyptus.authservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class BasicController {

  @GetMapping(path = "/check")
  public String check() {
    return "All is ok";
  }

  @GetMapping(path = "/token")
  public String generateToken(@RequestParam String username, @RequestParam String password) {
    String encodedString = Base64.getEncoder().encodeToString(String.join(":", username, password).getBytes());
    return "Basic " + encodedString;
  }
}
