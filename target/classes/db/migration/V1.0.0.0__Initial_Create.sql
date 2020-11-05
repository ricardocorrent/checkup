------------------------------ USER
CREATE TABLE "user"
(
    id                      UUID         NOT NULL,
    user_name               VARCHAR(255) NOT NULL,
    full_name               VARCHAR(255) NOT NULL,
    password                VARCHAR(255) NOT NULL,
    account_non_expired     BOOLEAN DEFAULT TRUE,
    account_non_locked      BOOLEAN DEFAULT TRUE,
    credentials_non_expired BOOLEAN DEFAULT TRUE,
    enabled                 BOOLEAN DEFAULT TRUE,
    created_at              TIMESTAMPTZ  NOT NULL,
    updated_at              TIMESTAMPTZ  NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ PERMISSION
CREATE TABLE permission
(
    id          UUID NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (id)
);

------------------------------ USER PERMISSION
CREATE TABLE user_permission
(
    user_id       UUID NOT NULL REFERENCES "user" (id),
    permission_id UUID NOT NULL REFERENCES permission (id),
    PRIMARY KEY (user_id, permission_id)
);

------------------------------ TARGET
CREATE TABLE target
(
    id         UUID         NOT NULL,
    name       VARCHAR(255) NOT NULL,
    active     BOOLEAN      NOT NULL DEFAULT TRUE,
    cloned     BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at TIMESTAMPTZ  NOT NULL,
    updated_at TIMESTAMPTZ  NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ RULE
CREATE TABLE rule
(
    id          UUID          NOT NULL,
    title       VARCHAR(100)  NOT NULL,
    description VARCHAR(4000) NOT NULL,
    active      BOOLEAN       NOT NULL DEFAULT TRUE,
    cloned      BOOLEAN       NOT NULL DEFAULT FALSE,
    created_at  TIMESTAMPTZ   NOT NULL,
    updated_at  TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ ITEM
CREATE TABLE item
(
    id             UUID          NOT NULL,
    rule_id        UUID          NOT NULL REFERENCES rule (id),
    title          VARCHAR(100)  NOT NULL,
    description    VARCHAR(4000) NOT NULL,
    position_index INTEGER       NOT NULL,
    active         BOOLEAN       NOT NULL DEFAULT TRUE,
    cloned         BOOLEAN       NOT NULL DEFAULT FALSE,
    created_at     TIMESTAMPTZ   NOT NULL,
    updated_at     TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ INSPECTION
CREATE TABLE inspection
(
    id              UUID         NOT NULL,
    user_id         UUID         NOT NULL REFERENCES "user" (id),
    target_id       UUID         NOT NULL REFERENCES target (id),
    title           VARCHAR(100) NOT NULL,
    description     VARCHAR(255),
    draft           BOOLEAN      NOT NULL DEFAULT TRUE,
    cloned          BOOLEAN      NOT NULL DEFAULT FALSE,
    sync_quantities INTEGER,
    note            VARCHAR(4000),
    allowed_to_sync BOOLEAN               DEFAULT FALSE,
    created_at      TIMESTAMPTZ  NOT NULL,
    updated_at      TIMESTAMPTZ  NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ TOPIC
CREATE TABLE topic
(
    id              UUID          NOT NULL,
    inspection_id   UUID          NOT NULL REFERENCES inspection (id),
    item_id         UUID          NOT NULL REFERENCES item (id),
    print_in_report BOOLEAN       NOT NULL DEFAULT TRUE,
    cloned          BOOLEAN       NOT NULL DEFAULT FALSE,
    position_index  INTEGER       NOT NULL,
    note            VARCHAR(4000) NULL,
    created_at      TIMESTAMPTZ   NOT NULL,
    updated_at      TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ ATTACHMENT
CREATE TABLE attachment
(
    id         UUID         NOT NULL,
    "data"     OID          NOT NULL,
    file_name  varchar(255) NOT NULL,
    file_type  varchar(255) NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL,
    updated_at TIMESTAMPTZ  NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ ATTACHMENT
CREATE TABLE file
(
    id             UUID          NOT NULL,
    topic_id       UUID          NOT NULL REFERENCES topic (id),
    attachment_id  UUID          NOT NULL REFERENCES attachment (id),
    active         BOOLEAN       NOT NULL DEFAULT TRUE,
    note           VARCHAR(4000) NULL,
    position_index INTEGER       NOT NULL,
    created_at     TIMESTAMPTZ   NULL,
    updated_at     TIMESTAMPTZ   NULL,
    PRIMARY KEY (id)
);

------------------------------ USER INFORMATION
CREATE TABLE user_information
(
    id             UUID          NOT NULL,
    user_id        UUID          NOT NULL REFERENCES "user" (id),
    title          VARCHAR(100)  NOT NULL,
    description    VARCHAR(4000) NOT NULL,
    position_index INTEGER       NOT NULL,
    active         BOOLEAN       NOT NULL DEFAULT TRUE,
    created_at     TIMESTAMPTZ   NOT NULL,
    updated_at     TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ TARGET INFORMATION
CREATE TABLE target_information
(
    id             UUID          NOT NULL,
    target_id      UUID          NOT NULL REFERENCES target (id),
    title          VARCHAR(100)  NOT NULL,
    description    VARCHAR(4000) NOT NULL,
    position_index INTEGER       NOT NULL,
    active         BOOLEAN       NOT NULL DEFAULT TRUE,
    created_at     TIMESTAMPTZ   NOT NULL,
    updated_at     TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ RULE INFORMATION
CREATE TABLE rule_information
(
    id             UUID          NOT NULL,
    rule_id        UUID          NOT NULL REFERENCES rule (id),
    title          VARCHAR(100)  NOT NULL,
    description    VARCHAR(4000) NOT NULL,
    position_index INTEGER       NOT NULL,
    active         BOOLEAN       NOT NULL DEFAULT TRUE,
    created_at     TIMESTAMPTZ   NOT NULL,
    updated_at     TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ ITEM INFORMATION
CREATE TABLE item_information
(
    id             UUID          NOT NULL,
    item_id        UUID          NOT NULL REFERENCES item (id),
    title          VARCHAR(100)  NOT NULL,
    description    VARCHAR(4000) NOT NULL,
    position_index INTEGER       NOT NULL,
    active         BOOLEAN       NOT NULL DEFAULT TRUE,
    created_at     TIMESTAMPTZ   NOT NULL,
    updated_at     TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);

------------------------------ INSPECTION INFORMATION
CREATE TABLE inspection_information
(
    id             UUID          NOT NULL,
    inspection_id  UUID          NOT NULL REFERENCES inspection (id),
    title          VARCHAR(100)  NOT NULL,
    description    VARCHAR(4000) NOT NULL,
    position_index INTEGER       NOT NULL,
    active         BOOLEAN       NOT NULL DEFAULT TRUE,
    created_at     TIMESTAMPTZ   NOT NULL,
    updated_at     TIMESTAMPTZ   NOT NULL,
    PRIMARY KEY (id)
);
