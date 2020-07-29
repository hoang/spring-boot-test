alter table tbl_user add column created_at TIMESTAMPTZ DEFAULT NOW();
alter table tbl_user add column updated_at TIMESTAMPTZ DEFAULT NOW();