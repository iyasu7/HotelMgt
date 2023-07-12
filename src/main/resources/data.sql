
-- Create the role
INSERT INTO role (role_name) VALUES ('guest'), ('admin'), ('HR'), ('hotel manager'), ('front desk');

-- Assign permissions to the role
INSERT INTO role_permission (role_id, permission) VALUES
  ((SELECT id FROM role WHERE role_name = 'guest'), 'BOOKING_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'BOOKING_READ'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'BOOKING_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'BOOKING_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'HOTEL_READ'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'RATING_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'RATING_READ'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'RATING_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'RATING_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'REVIEW_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'REVIEW_READ'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'REVIEW_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'REVIEW_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'guest'), 'SERVICE_READ');

-- Assign permissions to the role
INSERT INTO role_permission (role_id, permission) VALUES
  ((SELECT id FROM role WHERE role_name = 'admin'), 'BOOKING_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'BOOKING_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'BOOKING_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'BOOKING_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOM_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOM_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOM_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOM_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOMTYPE_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOMTYPE_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOMTYPE_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ROOMTYPE_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ADDRESS_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ADDRESS_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ADDRESS_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'ADDRESS_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'CITY_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'CITY_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'CITY_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'CITY_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'COUNTRY_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'COUNTRY_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'COUNTRY_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'COUNTRY_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'DISTRICT_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'DISTRICT_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'DISTRICT_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'DISTRICT_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REGION_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REGION_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REGION_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REGION_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SUB_CITY_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SUB_CITY_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SUB_CITY_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SUB_CITY_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTEL_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTEL_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTEL_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTEL_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTELTYPE_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTELTYPE_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTELTYPE_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'HOTELTYPE_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICETYPE_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICETYPE_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICETYPE_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICETYPE_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'RATING_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'RATING_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'RATING_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'RATING_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REVIEW_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REVIEW_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REVIEW_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'REVIEW_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICE_READ'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICE_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICE_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'admin'), 'SERVICE_DELETE');


-- Assign permissions to the role
INSERT INTO role_permission (role_id, permission) VALUES
  ((SELECT id FROM role WHERE role_name = 'HR'), 'USER_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'HR'), 'USER_READ'),
  ((SELECT id FROM role WHERE role_name = 'HR'), 'USER_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'HR'), 'USER_DELETE');

-- Assign permissions to the role
INSERT INTO role_permission (role_id, permission) VALUES
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ADDRESS_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ADDRESS_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ADDRESS_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ADDRESS_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'CITY_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'CITY_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'CITY_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'CITY_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'COUNTRY_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'COUNTRY_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'COUNTRY_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'COUNTRY_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'DISTRICT_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'DISTRICT_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'DISTRICT_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'DISTRICT_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'REGION_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'REGION_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'REGION_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'REGION_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SUB_CITY_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SUB_CITY_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SUB_CITY_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SUB_CITY_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICETYPE_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICETYPE_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICETYPE_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICETYPE_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICE_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICE_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICE_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'SERVICE_DELETE');

-- Assign permissions to the role
INSERT INTO role_permission (role_id, permission) VALUES
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'BOOKING_DELETE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_CREATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_READ'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_UPDATE'),
  ((SELECT id FROM role WHERE role_name = 'hotel manager'), 'ROOM_DELETE');

-- Insert sample data into Country table
INSERT INTO country (country_name)
VALUES ('USA'), ('UK'), ('France'), ('Canada'), ('Russia');

-- Insert sample data into Region table
INSERT INTO region (region_name, country_id)
VALUES
  ('California', 1),
  ('New York', 1),
  ('Texas', 1),
  ('London', 2),
  ('Yorkshire', 2),
  ('Paris', 3),
  ('Bordeaux', 3),
  ('Ontario', 4),
  ('Quebec', 4),
  ('Moscow', 5),
  ('Saint Petersburg', 5);

-- Insert sample data into City table
INSERT INTO city (city_name, region_id)
VALUES
  ('Los Angeles', 1),
  ('San Francisco', 1),
  ('New York City', 2),
  ('London', 4),
  ('Leeds', 5),
  ('Paris', 6),
  ('Bordeaux', 7),
  ('Toronto', 8),
  ('Montreal', 9),
  ('Moscow', 10),
  ('Saint Petersburg', 11);

-- Insert sample data into SubCity table
INSERT INTO sub_city (sub_city_name, city_id)
VALUES
  ('Downtown', 1),
  ('Hollywood', 1),
  ('Financial District', 3),
  ('Westminster', 4),
  ('City Center', 5),
  ('Montmartre', 6),
  ('Saint-Michel', 6),
  ('Downtown', 8),
  ('Old Montreal', 9),
  ('City Center', 10),
  ('Nevsky Prospekt', 11);

-- Insert sample data into District table
INSERT INTO district (district_name, sub_city_id)
VALUES
  ('District 1', 1),
  ('District 2', 1),
  ('District 3', 2),
  ('District 4', 2),
  ('District 5', 3),
  ('Westminster', 4),
  ('City Center', 5),
  ('Montmartre', 6),
  ('Saint-Michel', 7),
  ('District 1', 8),
  ('District 2', 8),
  ('Old Montreal', 9),
  ('District 1', 10),
  ('District 2', 10),
  ('Nevsky Prospekt', 11);

-- Insert sample data into Address table
INSERT INTO address (street, district_id)
VALUES
  ('123 Main St', 1),
  ('456 Elm St', 2),
  ('789 Oak St', 3),
  ('321 Pine St', 4),
  ('555 Broadway', 5),
  ('10 Downing Street', 6),
  ('1 The Calls', 7),
  ('20 Rue de Rivoli', 8),
  ('25 Quai des Grands Augustins', 9);

INSERT INTO room_type (number_of_rooms, number_of_available_rooms, number_of_beds, does_contain_private_bathroom, hastv, has_balcony, has_room_service, room_type_name, description)
VALUES (1, 10, 1, 1, 1, 0, 1, 'Single', 'Single room'),
       (2, 10, 2, 1, 1, 0, 1, 'Double', 'Double room'),
       (1, 10, 2, 1, 1, 0, 1, 'Twin', 'Twin beds'),
       (3, 10, 3, 1, 1, 1, 1, 'Triple', 'Triple room'),
       (5, 10, 4, 1, 1, 1, 1, 'Suite', 'Suite room');

INSERT INTO hotel_type (hotel_type_name, description)
VALUES  ('Luxury', 'Luxurious hotels with top-notch amenities'),
        ('Budget', 'Affordable hotels with basic amenities'),
        ('Resort', 'Hotels with recreational facilities and scenic surroundings'),
        ('Boutique', 'Unique and stylish hotels with personalized service'),
        ('Business', 'Hotels catering to business travelers with conference facilities');


INSERT INTO hotel (hotel_name, description, star, booking_expiration_time_in_hours, hotel_type, district_id)
VALUES
        ('Hotel California', 'Description A', 5, 24, 1, 1),
        ('The Grand Hotel', 'Description B', 4, 48, 2, 2),
        ('Eiffel Tower Hotel', 'Description C', 3, 72, 3, 3),
        ('Lakeside Resort', 'Description D', 2, 96, 4, 4),
        ('Cozy Cottage Inn', 'Description E', 1, 120, 5, 5),
        ('Sunset Beach Resort', 'Description F', 3, 144, 1, 6),
        ('Mountain View Lodge', 'Description G', 0, 168, 2, 7),
        ('The Plaza Hotel', 'Description H', 4, 192, 3, 8);

-- Insert sample data into Room table
INSERT INTO room (room_number, floor_number, room_size, price, room_type_id, hotel_id)
VALUES
  ('101', 1, 20, 100, 1, 1),
  ('102', 1, 20, 100, 1, 1),
  ('201', 2, 25, 120, 2, 2),
  ('202', 2, 25, 120, 2, 2),
  ('301', 3, 30, 150, 3, 3),
  ('302', 3, 30, 150, 3, 3),
  ('401', 4, 35, 180, 4, 4),
  ('402', 4, 35, 180, 4, 4),
  ('501', 5, 40, 200, 5, 5),
  ('502', 5, 40, 200, 5, 5),
  ('601', 6, 45, 220, 1, 6),
  ('602', 6, 45, 220, 1, 6),
  ('701', 7, 50, 250, 2, 7),
  ('702', 7, 50, 250, 2, 7),
  ('801', 8, 55, 280, 3, 8),
  ('802', 8, 55, 280, 3, 8);

-- Insert sample ServiceType data
INSERT INTO service_type (service_type_name)
VALUES
  ('Room Service'),
  ('Spa Services'),
  ('Concierge'),
  ('Transportation');

-- Insert sample Service data
INSERT INTO service (service_name, service_description, price, service_type)
VALUES
  ('In-Room Dining', 'Enjoy delicious meals in the comfort of your room', 25.0, (SELECT id FROM service_type WHERE service_type_name = 'Room Service')),
  ('Massage Therapy', 'Relax and rejuvenate with professional massage treatments', 80.0, (SELECT id FROM service_type WHERE service_type_name = 'Spa Services')),
  ('Airport Transfer', 'Hassle-free transportation to and from the airport', 50.0, (SELECT id FROM service_type WHERE service_type_name = 'Transportation')),
  ('Concierge Assistance', 'Get personalized assistance for your travel and stay', 0.0, (SELECT id FROM service_type WHERE service_type_name = 'Concierge')),
  ('Laundry Service', 'Professional laundry and dry cleaning services', 15.0, (SELECT id FROM service_type WHERE service_type_name = 'Room Service')),
  ('Fitness Classes', 'Join group fitness classes for a healthy workout', 20.0, (SELECT id FROM service_type WHERE service_type_name = 'Spa Services')),
  ('Car Rental', 'Explore the city with a convenient car rental service', 70.0, (SELECT id FROM service_type WHERE service_type_name = 'Transportation'));


-- Insert sample data into HotelService table
INSERT INTO hotel_service (hotel_id, service_id)
VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 2),
  (2, 3),
  (2, 4),
  (3, 3),
  (3, 4),
  (3, 5),
  (4, 4),
  (4, 5),
  (4, 1),
  (5, 5),
  (5, 1),
  (5, 2),
  (6, 1),
  (6, 2),
  (6, 3),
  (7, 2),
  (7, 3),
  (7, 4),
  (8, 3),
  (8, 4),
  (8, 5);

-- Insert sample data into user table
INSERT INTO user (first_name, last_name, username, password, user_type, role_id, hotel_id)
VALUES
  ('John', 'Doe', 'john', 'password', 'ADMIN', 2, null),
  ('Jane', 'Smith', 'Jane', 'password', 'EMPLOYEE', 3, null),
  ('John', 'Doe', 'johny', 'password', 'EMPLOYEE', 4, 1),
  ('John', 'Doe', 'johnjohn', 'password', 'EMPLOYEE', 4, 2),
  ('John', 'Doe', 'johnyjohny', 'password', 'EMPLOYEE', 4, 4),
  ('Jane', 'Smith', 'janey', 'password', 'EMPLOYEE', 5, 6),
  ('Iyasu', 'Josh', 'abush', 'password', 'GUEST', 1, null),
  ('Tesfa', 'texas', 'mita', 'password', 'GUEST', 1, null),
  ('Merry', 'Lidiya', 'merry', 'password', 'GUEST', 1, null),
  ('Mami', 'enate', 'andegna', 'password', 'GUEST', 1, null);

-- Insert sample data into Rating table
INSERT INTO rating (guest_id, hotel_id, rating)
VALUES
  (10, 1, 5),
  (7, 1, 4),
  (8, 2, 3),
  (9, 2, 2),
  (9, 3, 1),
  (8, 3, 5),
  (7, 4, 4),
  (8, 4, 3),
  (9, 5, 2),
  (10, 5, 1),
  (10, 6, 5),
  (10, 6, 4),
  (9, 7, 3),
  (8, 7, 2),
  (7, 8, 1),
  (10, 8, 5),
  (7, 1, 4),
  (8, 2, 3),
  (9, 3, 2),
  (10, 4, 1),
  (10, 5, 5),
  (8, 6, 4),
  (7, 7, 3),
  (9, 8, 2),
  (7, 1, 1);
-- Insert sample data into Review table
INSERT INTO review (hotel_review, guest_id, hotel_id)
VALUES
  ('Great hotel!', 10, 1),
  ('Good hotel!', 7, 1),
  ('Average hotel!', 8, 2),
  ('Not bad!', 9, 2),
  ('Poor hotel!', 8, 3),
  ('Terrible hotel!', 10, 3),
  ('Nice hotel!', 7, 4),
  ('Decent hotel!', 8, 4),
  ('OK hotel!', 9, 5),
  ('Could be better!', 10, 5),
  ('Amazing hotel!', 10, 6),
  ('Awesome hotel!', 10, 6),
  ('Fantastic hotel!', 10, 7),
  ('Good value for money!', 9, 7),
  ('Not worth the price!', 8, 8),
  ('Disappointing hotel!', 8, 8),
  ('Great hotel!', 7, 1),
  ('Good hotel!', 8, 2),
  ('Average hotel!', 9, 3),
  ('Not bad!', 10, 4),
  ('Poor hotel!', 7, 5),
  ('Terrible hotel!', 8, 6),
  ('Nice hotel!', 9, 7),
  ('Decent hotel!', 7, 8),
  ('OK hotel!', 10, 1);
