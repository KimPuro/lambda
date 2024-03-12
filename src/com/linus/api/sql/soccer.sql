-- soccer jap 버전
DEFAULT CHARSET=utf8;
create table stadium
(
    id   int auto_increment,
    stadium_name varchar(40),
    hometeam_id  varchar(10),
    seat_count   integer,
    address      varchar(60),
    ddd          varchar(10),
    tel          varchar(10),
    primary key(id)
);

create table team
(
    id int auto_increment,
    region_name varchar(10),
    team_name varchar(40),
    e_team_name varchar(50),
    orig_yyyy varchar(10),
    zip_code1  varchar(10),
    zip_code2  varchar(10),
    address    varchar(80),
    ddd        varchar(10),
    tel        varchar(10),
    fax        varchar(10),
    homepage varchar(50),
    owner varchar(10),
    stadium_id int,
    primary key(id),
    foreign key(stadium_id) references stadium(id)

);

create table schedule
(
    id int auto_increment,
    staduim_id int,
    gubun varchar(10),
    hometeam_id varchar(10),
    awayteam_id varchar(10),
    home_score integer,
    away_score integer,
    primary key (id),
    foreign key(staduim_id) references stadium(id)
)DEFAULT CHARSET=utf8;
create table player
(
    id int auto_increment,
    player_name varchar(20),
    e_player_name varchar(40),
    nickname varchar(30),
    join_yyyy varchar(10),
    position varchar(10),
    back_no integer,
    nation varchar(20),
    birth date,
    solar varchar(10),
    height integer,
    weight integer,
    team_id int,
    primary key(id),
    foreign key(team_id) references team(id)
)