package edu.miu.cs544.eHotelReserve.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IUserCredentialDao;
import edu.miu.cs544.eHotelReserve.model.UserCredential;


@Repository
public class UserCredentialDao extends GenericDao<UserCredential> implements IUserCredentialDao{
	
	public UserCredentialDao() {
		super.setDaoType(UserCredential.class );
		}

	public UserCredential findByUserName(String userName) {

		Query query = entityManager.createQuery("select u from userCredentials u  where u.username =:userName");
		return (UserCredential) query.setParameter("userName", userName).getSingleResult();

	}


}
