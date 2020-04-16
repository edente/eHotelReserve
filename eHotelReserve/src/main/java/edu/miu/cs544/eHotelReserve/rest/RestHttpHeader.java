package edu.miu.cs544.eHotelReserve.rest;

import java.nio.charset.Charset;
import java.util.Collections;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.model.UserCredential;
import edu.miu.cs544.eHotelReserve.service.IUserCredentialService;
import edu.miu.cs544.eHotelReserve.service.impl.UserCredentialService;




@Component
public class RestHttpHeader {
	protected RestTemplate restTemplate;

	@Autowired
	IUserCredentialService userCredentialService;
	
	public RestHttpHeader() {
		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/*
	*		Set up authentication header
	*		PLUS JSON Accept header
	*/
	public HttpHeaders getHttpHeaders() {

		// KLUDGE to get Credentials...
		UserCredential userCredential = 
				((UserCredentialService)
				userCredentialService).getUserCredentials();
		
		String username = userCredential.getUsername();
		String password = userCredential.getPassword();
		
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64( 
           auth.getBytes(Charset.forName("US-ASCII")) );
        String authHeader = "Basic " + new String( encodedAuth );
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.set("Authorization", authHeader);
		return requestHeaders;
	}

	public HttpEntity<?> getHttpEntity() {
		return new HttpEntity(getHttpHeaders());
	}

}

