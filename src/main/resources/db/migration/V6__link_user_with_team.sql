alter table tbl_user add column team_id UUID;
alter table tbl_user add constraint fk_tbl_team
	foreign key (team_id) references tbl_team(id);