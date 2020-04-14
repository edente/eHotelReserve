package edu.miu.cs544.eHotelReserve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.model.UserCredential;


@Repository("credentialRepository")
public interface IUserCredentialRepository extends JpaRepository<UserCredential, Long> {

	
	@Query(value = "select * from credentials where user_name = ?1" , nativeQuery = true)
	public UserCredential findByUserName(String userName);
}
	
