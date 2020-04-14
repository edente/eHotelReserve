package edu.miu.cs544.eHotelReserve.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.model.RoomType;


@Repository("roomTypeRepository")
public interface IRoomTypeRepository extends JpaRepository<RoomType, Long> {

}