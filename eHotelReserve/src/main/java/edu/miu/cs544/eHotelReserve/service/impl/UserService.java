package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.repository.IUserRepository;
import edu.miu.cs544.eHotelReserve.service.IUserService;

@Service("userService")
@Transactional
public class UserService implements IUserService {

	@Autowired
	RestHttpHeader restHelper;

	String baseUrl = "http://localhost:8000/MemberRest/hotel/user/users";/// hotel/user/users
	String baseUrlExtended = baseUrl + "/add/save";
	String baseUrlExtended1 = baseUrl + "/edit/{userId}";

	public List<User> findAll() {

		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<User> httpEntity = new HttpEntity<User>(restHelper.getHttpHeaders());
		ResponseEntity<User[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity,
				User[].class);
		List<User> userList = Arrays.asList(responseEntity.getBody());
		return userList;
	}

	public void save(User user) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<User> httpEntity = new HttpEntity<User>(user, restHelper.getHttpHeaders());
		user = restTemplate.postForObject(baseUrlExtended, httpEntity, User.class);
		return;
	}

	public User findById(Long index) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<User> responseEntity = restTemplate.exchange(baseUrlExtended1 + index, HttpMethod.GET,
				httpEntity, User.class);
		User user = responseEntity.getBody();
		return user;
	}

	public void partialUpdate(Long index, Map patch) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity<Map>(patch, restHelper.getHttpHeaders());
		restTemplate.exchange(baseUrlExtended + index, HttpMethod.PATCH, httpEntity, Map.class);

		return;
	}

}
