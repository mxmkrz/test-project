DO
$$
    BEGIN
        IF NOT EXISTS(SELECT 1
                      FROM pg_type t
                               LEFT JOIN pg_namespace n ON t.typnamespace = n.oid
                      WHERE t.typname = 'search_profile'
                        AND n.nspname = 'public')
        THEN
            CREATE TYPE search_profile AS ENUM ('HIGH', 'LOW_AND_MEDIUM');
        END IF;
    END
$$;
