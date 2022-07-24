CREATE TABLE IF NOT EXISTS user_tb
(
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id        UUID NOT NULL,
    search_profile SEARCH_PROFILE,
    search_id      TEXT UNIQUE,
    search_ref     TEXT UNIQUE,
    is_monitored   BOOLEAN,
    version        INT,
    created_at     TIMESTAMPTZ,
    modified_at    TIMESTAMPTZ
);

