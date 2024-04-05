CREATE TABLE IF NOT EXISTS `workcards` (
`work_card_id` int auto_increment primary key,
`work_card_description` varchar(100) not null,
`work_card_number` varchar(100) not null,
`communication_switch` boolean,
`created_at` date not null,
`created_by` varchar(100) not null,
`updated_at` date default null,
`updated_by` varchar(100) default null
);

create table if not exists `taskcards` (
`task_card_id` int auto_increment primary key,
`task_card_description` varchar(100) not null,
`task_card_number` varchar(100) not null,
`created_at` date not null,
`created_by` varchar(100) not null,
`updated_at` date default null,
`updated_by` varchar(100) default null
)
