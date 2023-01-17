/*drop database if exists helpdesk_qa_prep;
create database Helpdesk_QA_preP;
*/
use Helpdesk_QA_preP;

delimiter //
create  TRIGGER insertaZonaEstadoInicial
AFTER INSERT
on  usuarios
FOR EACH ROW
update usuarios set  id_zona= 9L;
delimiter ;
/*
select *from estadosrepu;
delete FROM  zonaestados;
select *from zonaestados;
*/

delete From zonaestados;
insert into zonaestados (id_zon,nombree,register_date,last_update_date) values
(1,'Noroeste','2022/01/01','2022/01/01'),
(2,'Noreste','2022/01/01','2022/01/01'),
(3,'Oeste','2022/01/01','2022/01/01'),
(4,'Oriente','2022/01/01','2022/01/01'),
(5,'Centronorte','2022/01/01','2022/01/01'),
(6,'Centrosur','2022/01/01','2022/01/01'),
(7,'Suroeste','2022/01/01','2022/01/01'),
(8,'Sureste ','2022/01/01','2022/01/01'),
(9,'Sin asignacion','2022/01/01','2022/01/01')
;

insert into estadosrepu (id_est_repu,nombre_esatdo,descripcion,register_date,last_update_date,id_zon) values
(1, 'Aguascalientes','estado','2022/01/01','2022/01/01',5),
(2, 'Baja California','estado','2022/01/01','2022/01/01',1),
(3, 'Baja California Sur','estado','2022/01/01','2022/01/01',1),
(4, 'Campeche','estado','2022/01/01','2022/01/01',8),
(5, 'Coahuila de Zaragoza','estado','2022/01/01','2022/01/01',2),
(6, 'Colima','estado','2022/01/01','2022/01/01',3),
(7, 'Chiapas','estado','2022/01/01','2022/01/01',7),
(8, 'Chihuahua','estado','2022/01/01','2022/01/01',1),
(9, 'Distrito Federal','estado','2022/01/01','2022/01/01',6),
(10, 'Durango','estado','2022/01/01','2022/01/01',1),
(11, 'Guanajuato','estado','2022/01/01','2022/01/01',5),
(12, 'Guerrero','estado','2022/01/01','2022/01/01',7),
(13, 'Hidalgo','estado','2022/01/01','2022/01/01',4),
(14, 'Jalisco','estado','2022/01/01','2022/01/01',3),
(15, 'México','estado','2022/01/01','2022/01/01',6),
(16, 'Michoacan','estado','2022/01/01','2022/01/01',3),
(17, 'Morelos','estado','2022/01/01','2022/01/01',6),
(18, 'Nayarit','estado','2022/01/01','2022/01/01',3),
(19, 'Nuevo Leon','estado','2022/01/01','2022/01/01',2),
(20, 'Oaxaca de Juárez','estado','2022/01/01','2022/01/01',7),
(21, 'Puebla','estado','2022/01/01','2022/01/01',4),
(22, 'Queretaro','estado','2022/01/01','2022/01/01',5),
(23, 'Quintana Roo','estado','2022/01/01','2022/01/01',8),
(24, 'San Luis Potosí','estado','2022/01/01','2022/01/01',5),
(25, 'Sinaloa','estado','2022/01/01','2022/01/01',1),
(26, 'Sonora','estado','2022/01/01','2022/01/01',1),
(27, 'Tabasco','estado','2022/01/01','2022/01/01',8),
(28, 'Tamaulipas','estado','2022/01/01','2022/01/01',2),
(29, 'Tlaxcala','estado','2022/01/01','2022/01/01',4),
(30, 'Veracruz','estado','2022/01/01','2022/01/01',4),
(31, 'Yucatan','estado','2022/01/01','2022/01/01',8),
(32, 'Zacatecas','estado','2022/01/01','2022/01/01',5);


select *from perfil;
delete from perfil ;
insert into perfil values 
(1,'Admistrador General del sistema','2022/01/01','Administrador','Administrdor General','2022/01/01'),
(2,'Gerente general','2022/01/01','Gerente','Gerente','2022/01/01'),
(3,'Coordinador de Zona','2022/01/01','Operativo2','Operativo Nivel 2','2022/01/01'),
(4,'Agentes de la mesa de servicio','2022/01/01','Operativo1','Operativo Nivel 1','2022/01/01'),
(5,'Tecnicos especialista','2022/01/01','Tecnicos especialista 2','Tecnicos especialista 2','2022/01/01'),
(6,'Almacen','2022/01/01','Almacen','Operativo Nivel 1','2022/01/01'),
 (7,'Invitado','2022/01/01','invitado','invitado','2022/01/01');

select  * from usuarios;
select * From usuario_perfil;
/*
INSERT INTO usuarios (id_user,apellidom_user,apellidop_user,correo,ext_user,fecha_modificacion,nombre_user,password,fecha_creacion,staus_user,tel_user,id_zona) 
VALUES (1,'Lima','Flores','ricardo_6_11@got.com',55621,'2022/02/01','ricardo','123456','2022/02/01','activo','5519360328',4),
(2,'Sanches','Ramirez','sandy@got.com',55621,'2022/02/01','sandy','123456','2022/02/01','activo','5555555555',4);
*/
select *from almacen;

insert into almacen  (descripcion, fecha_modificacion, marca, modelo, fecha_creacion, stoc) values ("Monitor azul", '2022/02/01', "Dell", "Monitor",'2022/02/01', 50)