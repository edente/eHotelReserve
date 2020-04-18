INSERT INTO room_types(price, room_type_name) VALUES (300.0, 'king')
INSERT INTO room_types(price, room_type_name) VALUES (150.0, 'medium')
INSERT INTO room_types(price, room_type_name) VALUES (200.0, 'queen')
INSERT INTO room_types(price, room_type_name) VALUES (400.0, 'luxury')
INSERT INTO room_types(price, room_type_name) VALUES (400.0, 'King luxury')

INSERT INTO rooms(id,room_number, room_type_id) VALUES (1,'400', 1)
INSERT INTO rooms(id,room_number, room_type_id) VALUES (2,'500', 1)
INSERT INTO rooms(id,room_number, room_type_id) VALUES (3,'330', 2)

INSERT INTO rufta.bookings(id,booking_date, check_in_date,check_out_date, hotel_reserve_location, reference_number, total_price,room_id) VALUES(1,'2020-2-2', '2020-4-4','2020-5-5','lasVegas','65',800,1);
INSERT INTO rufta.bookings(id,booking_date, check_in_date,check_out_date, hotel_reserve_location, reference_number, total_price,room_id) VALUES(2,'2020-2-2', '2020-4-4','2020-5-5','lasVegas','65',800,2);


INSERT INTO users(user_id,first_name, last_name,email,username,address_id) VALUES (5,'bsrat','kidane','bsur@gamil.com', 'mihrekidane',1)
INSERT INTO users(user_id,first_name, last_name,email,username,address_id) VALUES (6,'mihreteab','kidane','mihre@gamil.com', 'mihrekidane',2)

