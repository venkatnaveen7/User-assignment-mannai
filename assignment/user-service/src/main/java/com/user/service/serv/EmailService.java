package com.user.service.serv;

import com.user.service.entity.OTP;
import com.user.service.repo.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private OTPRepository otpRepository;



	public void sendMail(String email) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Set<Runnable> runnableSet = new HashSet<>();
		String mailOTP = prepareOTP();
		Runnable mailTask = () -> {
			try {
				SimpleMailMessage message = new SimpleMailMessage();

				message.setTo("venkatnaveen7@gmail.com");
				message.setFrom("challadivyasri94@gmail.com");
				message.setText("Hello Sir");


				System.out.println("mailOTP = " + mailOTP);
				message.setSubject("Your OTP is " + mailOTP);
				mailSender.send(message);

				System.out.println("OTP Send Succesfully");
			} catch (Exception e) {
				System.out.println("Error in OTP Sending " + e.getMessage());
			}

		};

		executorService.execute(mailTask);

		Runnable saveOTPtoDBTask = () -> {
			OTP otp = new OTP();
			otp.setEmail(email);
			otp.setOtp(mailOTP);
			otpRepository.save(otp);
		};
		executorService.execute(saveOTPtoDBTask);

		executorService.shutdown();


	}

	private String prepareOTP() {
		int randomInt = new Random().nextInt(999999);
		return String.format("%06d", randomInt);
	}


	public boolean validateOTP(String email, String otp) {
		boolean isOTPValid = false;

		Optional<OTP> unusedOTPOptional = otpRepository.findByIdAndOTPStatus(email);
		if(unusedOTPOptional.isPresent()) {
			OTP unusedOTPRecord = unusedOTPOptional.get();
			String generatedOTP = unusedOTPRecord.getOtp();
			if (generatedOTP.equals(otp)) {
				isOTPValid = true;
				otpRepository.delete(unusedOTPRecord);
			}
		}
		return isOTPValid;
	}
}
