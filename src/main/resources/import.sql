INSERT INTO `spengerspital`.`greeting` (`id`, `content`) VALUES ('1', 'Content 1');
INSERT INTO `spengerspital`.`greeting` (`id`, `content`) VALUES ('2', 'Content 2');
INSERT INTO `spengerspital`.`greeting` (`id`, `content`) VALUES ('3', 'Content 3');
INSERT INTO `spengerspital`.`greeting` (`id`, `content`) VALUES ('4', 'Content 4');

INSERT INTO `spengerspital`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_deceaseddatetime`, `p_deceasedboolean`, `p_gender`) VALUES ('asdf',1, '2000-01-01', '2010-01-01', 1, 'male');
INSERT INTO `spengerspital`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('gjuerighirgh', 1, '2000-01-01','unknown', 1);
INSERT INTO `spengerspital`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('7439re', 0, '2001-04-05','male', 0);
INSERT INTO `spengerspital`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('frejifgreu89', 1, '2010-01-21','female', 1);
INSERT INTO `spengerspital`.`hn_humanname` (`id`, `hn_family`, `hn_given`,`pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_p_id`) VALUES ('n1','Mustermann', 'given', '2099-12-31', '2000-01-01', 'blabla', 'usual','7439re');
INSERT INTO `spengerspital`.`a_address` (`id`, `a_city`, `a_country`,`a_district`, `pp_end`, `pp_start`, `a_postalcode`, `a_state`, `a_p_id`)VALUES ('addr1', 'Orasje', 'BiH', 'Orase', '2099-12-31 16:36:34.000000','2020-04-27 16:36:49.000000', '1111', 'BiH', '7439re');
INSERT INTO `spengerspital`.`a_address` (`id`, `a_city`, `a_country`,`a_district`, `pp_end`, `pp_start`, `a_postalcode`, `a_state`, `a_p_id`)VALUES ('addr2', 'AT', 'BiH', 'Orase', '2099-12-31 16:36:34.000000','2020-04-27 16:36:49.000000', '1111', 'BiH', '7439re');

INSERT INTO `spengerspital`.`pro_procedure` (`id`, `pro_performed_age`, `pro_performed_range`, `pro_status`, `pro_status_why`, `dr_n_id`) VALUES ('igduieuidho', '12.1.2021', '6', 'preparation', 'irgendwas', 'djdwojd');
INSERT INTO `spengerspital`.`pro_procedure` (`id`, `pro_performed_age`, `pro_performed_range`, `pro_status`, `pro_status_why`, `dr_n_id`) VALUES ('hdhowjhqdio', '10.1.2021', '8', 'preperation', 'irgendwas2', 'jdddjdo');

//TODO: Practitioner einfügen
INSERT INTO `spengerspital`.`pr_practitioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`, `dr_n_id`) VALUES ('nfeuwfi', b'true', b'2000-01-01', b'male', b'jfiwj');
INSERT INTO `spengerspital`.`pr_practitioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`, `dr_n_id`) VALUES (b'jdwejd', b'false', b'2000-01-01', b'female', b'ksow');
