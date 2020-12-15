

ALTER TABLE site_user
    ADD CONSTRAINT unique_username UNIQUE (username);
