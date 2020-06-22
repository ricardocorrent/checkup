-- user
CREATE TABLE "user"
(
    id                      uuid primary key         NOT NULL,
    user_name               VARCHAR(255)             NOT NULL,
    full_name               VARCHAR(255)             NOT NULL,
    password                VARCHAR(255)             NOT NULL,
    account_non_expired     boolean DEFAULT NULL,
    account_non_locked      boolean DEFAULT NULL,
    credentials_non_expired boolean DEFAULT NULL,
    enabled                 boolean DEFAULT NULL,
    created_at              timestamp with time zone not NULL,
    updated_at              timestamp with time zone not NULL
);

-- user_information
CREATE TABLE user_information
(
    id          uuid primary key         NOT NULL,
    user_id     uuid                     NOT NULL,
    title       VARCHAR(100)             NOT NULL,
    description VARCHAR(150)             NOT NULL,
    created_at  timestamp with time zone not NULL,
    updated_at  timestamp with time zone not NULL
);


-- permission
CREATE table permission
(
    id          uuid primary key NOT NULL,
    description VARCHAR(255)
);

-- user_permission
CREATE TABLE user_permission
(
    user_id       uuid NOT NULL,
    permission_id uuid NOT NULL,
    PRIMARY KEY (user_id, permission_id)
);
