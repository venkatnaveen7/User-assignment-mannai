package com.user.service.repo;

import com.user.service.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP,String> {
	@Query("from OTP where email =?1 and isOtpUsed=false ")
	Optional<OTP> findByIdAndOTPStatus(String email);
}
