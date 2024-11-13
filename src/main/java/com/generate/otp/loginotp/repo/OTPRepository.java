package com.generate.otp.loginotp.repo;

import com.generate.otp.loginotp.model.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {
    OTP findByPhoneNumber(String phoneNumber);
}
