
CREATE TABLE session
(
    id serial CONSTRAINT session_id_pk PRIMARY KEY,
    createDate timestamp,
    expireMinutes integer
);
