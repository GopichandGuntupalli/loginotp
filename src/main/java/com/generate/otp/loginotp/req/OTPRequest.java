package com.generate.otp.loginotp.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTPRequest {
    private String route;
    private String message;
    private String numbers;  // Phone number as string
    private String flash;
}


