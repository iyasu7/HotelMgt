
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
