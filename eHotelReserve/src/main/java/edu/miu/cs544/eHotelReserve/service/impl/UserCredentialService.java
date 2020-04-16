package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.model.UserCredential;
import edu.miu.cs544.eHotelReserve.repository.IUserCredentialRepository;
import edu.miu.cs544.eHotelReserve.service.IUserCredentialService;





@Service("userCredentialService")
public class UserCredentialService implements IUserCredentialService{
	
	@Autowired
	RestHttpHeader restHelper;

	String baseUrl = "http://localhost:8000/MemberRest/userCredentials";
	String baseUrlExtended = baseUrl + "/";

	private UserCredential userCredentials  = new UserCredential();	
 
	public UserCredential getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredential userCredentials) {
		this.userCredentials = userCredentials;
	}
	
	
	public List<UserCredential> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity <UserCredential>httpEntity = new HttpEntity<UserCredential>(restHelper.getHttpHeaders());
		ResponseEntity<UserCredential[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, UserCredential[].class);	
 		List<UserCredential> userList = Arrays.asList(responseEntity.getBody());
		return userList;
	}

	

	public void save(UserCredential userCredentials) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<UserCredential> httpEntity = new HttpEntity<UserCredential>(userCredentials, restHelper.getHttpHeaders());
		userCredentials = restTemplate.postForObject(baseUrl, httpEntity, UserCredential.class);
		return;
	}

	

	@Override
	public UserCredential findByUserName(String userName) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<UserCredential> httpEntity = new HttpEntity<UserCredential>(restHelper.getHttpHeaders());
		ResponseEntity<UserCredential> responseEntity = restTemplate.exchange(baseUrlExtended + userName, HttpMethod.GET, httpEntity, UserCredential.class);	
		UserCredential userCrsdential = responseEntity.getBody();
 		return userCrsdential;
	}

	

	

}
	
