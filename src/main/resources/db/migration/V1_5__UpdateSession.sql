
ALTER TABLE session
    RENAME COLUMN createdate TO created;

ALTER TABLE session
    RENAME COLUMN expireminutes TO expiration;
