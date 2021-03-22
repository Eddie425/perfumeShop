package com.shop.perfume.controller;

import com.shop.perfume.config.JwtTokenUtil;
import com.shop.perfume.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BasicController extends AspectController {

  String API_PERFUME_AUTH_LOGIN = API_PERFUME_AUTH + "/login"; //登入


  @PostMapping(value = API_PERFUME_AUTH_LOGIN)
  default ResponseEntity<?> createAuthenticationToken(
      @RequestBody JwtRequest authenticationRequest) throws Exception {
    return ResponseEntity.ok(new JwtResponse(""));
  }
}
