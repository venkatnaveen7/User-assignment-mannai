package com.user.service.serv;

import com.user.service.dto.UserDTO;
import com.user.service.entity.User;
import com.user.service.repo.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public void saveUser(UserDTO userDTO) {
		if (!isUserExist(userDTO)) {
			User user = new User();
			BeanUtils.copyProperties(userDTO, user);
			userRepository.save(user);
		}
	}

	private boolean isUserExist(UserDTO userDTO) {
		Optional<User> userOptional = null;
		if (StringUtils.isNotEmpty(userDTO.getEmail())) {
			userOptional = userRepository.findByEmail(userDTO.getEmail());
		} else if (StringUtils.isNotEmpty(userDTO.getMobileNumber())) {
			userOptional = userRepository.findByMobileNumber(userDTO.getMobileNumber());
		}
		if (null != userOptional ){
			return userOptional.isPresent();
		}

		return false;
	}
}
