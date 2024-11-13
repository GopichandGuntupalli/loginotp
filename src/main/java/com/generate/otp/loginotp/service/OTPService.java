package com.generate.otp.loginotp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class OTPService {

    @Value("${fast2sms.apiKey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public OTPService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to generate a 6-digit OTP
    public String generateOtp() {
        int otp = (int) (Math.random() * 900000) + 100000; // Generate a 6-digit OTP
        return String.valueOf(otp);
    }

    // Method to send OTP
//    public String sendOtp(String phoneNumber) {
//        // Generate OTP
//        String otpCode = generateOtp();
//
//        String apiUrl = "https://www.fast2sms.com/dev/bulkV2"; // Correct endpoint
//
//        String message = "Your OTP is " + otpCode;
//
//        // Encode the message and phone number
//        try {
//            String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8.toString());
//            String encodedPhoneNumber = URLEncoder.encode(phoneNumber, StandardCharsets.UTF_8.toString());
//
//            // Build the URL with query parameters
//            String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
//                    .queryParam("authorization", apiKey)
//                    .queryParam("route", "otp")
//                    .queryParam("message", message)  // Make sure it's URL-encoded if necessary
//                    .queryParam("numbers", "919000308335") // Phone number in string format
//                    .queryParam("flash", "0")
//                    .toUriString();
//
//
//            // Send the GET request to Fast2SMS API
//            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//            return "OTP Sent Successfully: " + response.getBody();
//        } catch (Exception e) {
//            return "Failed to send OTP: " + e.getMessage();
//        }
//    }
    public String sendOtp(String phoneNumber) {
        // Generate OTP
        String otpCode = generateOtp();

        // Define the API endpoint
        String apiUrl = "https://www.fast2sms.com/dev/bulkV2";

        // Build the GET URL with query parameters
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("authorization", apiKey)
                .queryParam("variables_values", otpCode)
                .queryParam("route", "otp")
                .queryParam("numbers", phoneNumber)
                .toUriString();

        // Set headers for the GET request
        HttpHeaders headers = new HttpHeaders();
        headers.set("cache-control", "no-cache");

        // Create the HTTP entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send the GET request to Fast2SMS API
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            return "OTP Sent Successfully: " + response.getBody();
        } catch (Exception e) {
            return "Failed to send OTP: " + e.getMessage();
        }
}}
