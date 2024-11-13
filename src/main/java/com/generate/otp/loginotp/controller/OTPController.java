package com.generate.otp.loginotp.controller;

import com.generate.otp.loginotp.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
public class OTPController {

    private final OTPService otpService;

    @Autowired
    public OTPController(OTPService otpService) {
        this.otpService = otpService;
    }

    // Endpoint to send OTP to the provided phone number
//    @GetMapping("/sendOtp")
//    public String sendOtp(@RequestBody  String phoneNumber) {
//        // Call the OTPService to generate and send the OTP
//        return otpService.sendOtp(phoneNumber);
//    }
    @PostMapping("/sendOtp")
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {
        try {
            // Send OTP and get the response
            String response = otpService.sendOtp(phoneNumber);
            System.out.println(response+"response");
            return ResponseEntity.ok(response); // Return success response
        } catch (Exception e) {
            // In case of any error, return a 400 Bad Request with error message
            return ResponseEntity.badRequest().body("Failed to send OTP: " + e.getMessage());
        }
}}
