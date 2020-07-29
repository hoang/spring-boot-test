CREATE TABLE tbl_activity
  (
     id UUID NOT NULL,
     user_id UUID,
     action TEXT,
     created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
     PRIMARY KEY (id)
  );