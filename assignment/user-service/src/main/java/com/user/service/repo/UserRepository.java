package com.user.service.repo;

import com.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmail(String email);

	Optional<User> findByMobileNumber(String mobileNumber);

	/*@Modifying
	@Query("update User u set u.isPartialSave=false where u.email = :email")
	void update(@Param(value = "email")  String email);*/
}
