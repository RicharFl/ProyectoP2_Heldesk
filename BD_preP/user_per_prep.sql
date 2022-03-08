use MYSQL;
SELECT *FROM user;
/* PERMISOS A USUARIO ADMINISTRADOR*/
DROP user if exists'admin_heldes'@'localhost';
CREATE USER 'admin_heldes'@'localhost' identified by 'Usuario_admin_2022Q@';
GRANT ALL PRIVILEGES ON helpdesk_qa_prep. * TO 'admin_heldes'@'localhost';
show grants for "admin_heldes"@'localhost';


/* PERMISOS A USUARIO SoporteN2*/

DROP user if exists'soporte_n2'@'localhost';
CREATE USER 'soporte_n2'@'localhost' identified by 'Usuario_Soporte_2022Q@';
GRANT SELECT on helpdesk_qa_prep.usuarios TO 'soporte_n2'@'localhost';
GRANT SELECT on helpdesk_qa_prep.sol_alm TO 'soporte_n2'@'localhost';
GRANT SELECT on helpdesk_qa_prep.ticket TO 'soporte_n2'@'localhost';
GRANT SELECT on helpdesk_qa_prep.cliente TO 'soporte_n2'@'localhost';

GRANT UPDATE on helpdesk_qa_prep.usuarios TO 'soporte_n2'@'localhost';
GRANT UPDATE on helpdesk_qa_prep.sol_alm TO 'soporte_n2'@'localhost';
GRANT UPDATE on helpdesk_qa_prep.cliente TO 'soporte_n2'@'localhost';
GRANT UPDATE on helpdesk_qa_prep.ticket TO 'soporte_n2'@'localhost';

GRANT delete on helpdesk_qa_prep.cliente TO 'soporte_n2'@'localhost';

/* PERMISOS A USUARIO Almancen*/

DROP user if exists'almacen_n1'@'localhost';
CREATE USER 'almacen_n1'@'localhost' identified by 'Usuario_almacen_2022Q@';
GRANT SELECT on helpdesk_qa_prep.usuarios TO 'almacen_n1'@'localhost';
GRANT SELECT on helpdesk_qa_prep.sol_alm TO 'almacen_n1'@'localhost';
GRANT SELECT on helpdesk_qa_prep.ticket TO 'almacen_n1'@'localhost';

GRANT UPDATE on helpdesk_qa_prep.usuarios TO 'almacen_n1'@'localhost';
GRANT UPDATE on helpdesk_qa_prep.sol_alm TO 'almacen_n1'@'localhost';
GRANT UPDATE on helpdesk_qa_prep.ticket TO 'almacen_n1'@'localhost';


SHOW GRANTS FOR 'admin_heldes'@'localhost';
