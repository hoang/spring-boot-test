CREATE TABLE tbl_team
  (
     id UUID NOT NULL,
     name VARCHAR(255) NOT NULL,
     description TEXT,
     created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
     updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
     PRIMARY KEY (id)
  );