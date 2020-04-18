package edu.miu.cs544.eHotelReserve.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.miu.cs544.eHotelReserve.model.Group;


public interface IGenericDao<T> {
	/**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     * @param params
     *  sql parameters
     * @return the number of records meeting the criteria
     */
    void save(T t);

    void delete(Long id);

    T findOne(Long id);

    T update(T t);   
    
    List<T> findAll();

	public List<T> findAll(String s, Object  hint );

}
