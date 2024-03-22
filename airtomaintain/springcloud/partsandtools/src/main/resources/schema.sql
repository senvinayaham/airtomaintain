CREATE TABLE IF NOT EXISTS `Parts` (
`parts_id` int auto_increment primary key,
`parts_oem` int not null,
`parts_name` varchar(100) not null,
`parts_number` varchar(100) not null,
`parts_mfn` varchar(100) not null,
`parts_qty` int not null,
`created_at` date not null,
`created_by` varchar(100) not null,
`updated_at` date default null,
`updated_by` varchar(100) default null
);

create table if not exists `Tools` (
`tools_id` int auto_increment primary key,
`tools_oem` int not null,
`tools_name` varchar(100) not null,
`tools_number` varchar(100) not null,
`tools_mfn` varchar(100) not null,
`tools_qty` int not null,
`created_at` date not null,
`created_by` varchar(100) not null,
`updated_at` date default null,
`updated_by` varchar(100) default null
)
