
CREATE TABLE site_user
(
    id serial CONSTRAINT site_user_id_pk PRIMARY KEY,
    fullname VARCHAR,
    username VARCHAR CONSTRAINT unique_username UNIQUE,
    password VARCHAR,
    role INTEGER,
    college VARCHAR
);
