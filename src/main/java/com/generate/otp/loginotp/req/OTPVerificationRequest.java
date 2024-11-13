package com.generate.otp.loginotp.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OTPVerificationRequest {
    private String phoneNumber;
    private String otp;
}
