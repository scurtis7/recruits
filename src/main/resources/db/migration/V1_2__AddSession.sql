
CREATE TABLE session
(
    id INTEGER CONSTRAINT session_id_pk PRIMARY KEY,
    username VARCHAR,
    role INTEGER,
    created TIMESTAMP,
    expiration INTEGER,
    college VARCHAR
);
