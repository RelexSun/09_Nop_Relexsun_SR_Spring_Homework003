INSERT INTO attendees (attendees_name, email) VALUES
  ('John Smith', 'john.smith@example.com'),
  ('Emily Johnson', 'emily.j@example.com'),
  ('Michael Brown', 'michael.b@example.com'),
  ('Sarah Davis', 'sarah.d@example.com'),
  ('Robert Wilson', 'robert.w@example.com'),
  ('Jennifer Martinez', 'jennifer.m@example.com'),
  ('William Anderson', 'william.a@example.com'),
  ('Jessica Taylor', 'jessica.t@example.com'),
  ('David Thomas', 'david.t@example.com'),
  ('Lisa Garcia', 'lisa.g@example.com');

INSERT INTO venues (venue_name, location) VALUES
  ('Grand Ballroom', '123 Main Street, New York, NY'),
  ('Convention Center', '456 Oak Avenue, Chicago, IL'),
  ('Riverside Hall', '789 Pine Road, Los Angeles, CA'),
  ('Mountain View Plaza', '321 Elm Boulevard, Denver, CO'),
  ('Seaside Pavilion', '654 Beach Drive, Miami, FL'),
  ('Garden Terrace', '987 Park Lane, Austin, TX'),
  ('Skyline Tower', '147 High Street, Seattle, WA'),
  ('Heritage Museum', '258 History Way, Boston, MA'),
  ('Sunset Banquet Hall', '369 Horizon Drive, San Diego, CA'),
  ('Urban Loft', '741 Downtown Avenue, Portland, OR');

INSERT INTO events (event_name, event_date, venue_id) VALUES
  ('Tech Conference 2023', '2023-05-15', 1),
  ('Marketing Summit', '2023-06-20', 2),
  ('Annual Gala Dinner', '2023-07-04', 3),
  ('Startup Pitch Competition', '2023-08-12', 4),
  ('Art Exhibition Opening', '2023-09-05', 5),
  ('Music Festival', '2023-10-21', 6),
  ('Healthcare Symposium', '2023-11-03', 7),
  ('Educational Workshop', '2023-12-10', 8),
  ('New Year Celebration', '2024-01-01', 9),
  ('Product Launch Event', '2024-02-14', 10);

INSERT INTO event_attendee (event_id, attendees_id) VALUES
-- Tech Conference 2023 (event_id 1) has 5 attendees
(1, 1), (1, 3), (1, 5), (1, 7), (1, 9),

-- Marketing Summit (event_id 2) has 4 attendees
(2, 2), (2, 4), (2, 6), (2, 8),

-- Annual Gala Dinner (event_id 3) has 6 attendees
(3, 1), (3, 2), (3, 5), (3, 7), (3, 9), (3, 10),

-- Startup Pitch Competition (event_id 4) has 3 attendees
(4, 3), (4, 6), (4, 9),

-- Art Exhibition Opening (event_id 5) has 5 attendees
(5, 2), (5, 4), (5, 6), (5, 8), (5, 10),

-- Music Festival (event_id 6) has all 10 attendees
(6, 1), (6, 2), (6, 3), (6, 4), (6, 5),
(6, 6), (6, 7), (6, 8), (6, 9), (6, 10),

-- Healthcare Symposium (event_id 7) has 4 attendees
(7, 1), (7, 3), (7, 5), (7, 7),

-- Educational Workshop (event_id 8) has 3 attendees
(8, 2), (8, 4), (8, 6),

-- New Year Celebration (event_id 9) has 7 attendees
(9, 1), (9, 3), (9, 5), (9, 7), (9, 8), (9, 9), (9, 10),

-- Product Launch Event (event_id 10) has 5 attendees
(10, 2), (10, 4), (10, 6), (10, 8), (10, 10);
SELECT * FROM events;
SELECT * FROM attendees;
SELECT * FROM venues;

SELECT * FROM event_attendee ea INNER JOIN attendees a ON a.attendees_id = ea.attendees_id where event_id = 3;