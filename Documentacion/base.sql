use Helpdesk_QA_preP;
/*
delimiter //
create  TRIGGER insertaZonaEstadoInicial
AFTER INSERTusuario_perfil
on  usuarios
FOR EACH ROW
update usuarios set  id_zona= 9L;
delimiter ;*/
/*
select *from estadosrepu;
delete FROM  zonaestados;
select *from zonaestados;
*/
SELECT *fROM zonaestados;
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
(9,'Sin asignacion','2022/01/01','2022/01/01');

select * from zonaestados;
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

/*
INSERT INTO usuarios (id_user,apellidom_user,apellidop_user,username,ext_user,fecha_modificacion,nombre_user,password,fecha_creacion,staus_user,tel_user,id_zona) 
VALUES (1,'Lima','Flores','ricardo_6_11@got.com',55621,'2022/02/01','ricardo','123456','2022/02/01','activo','5519360328',1),
(2,'Sanches','Ramirez','sandy@got.com',55621,'2022/02/01','sandy','123456','2022/02/01','activo','5555555555',2);

insert into usuario_perfil values  (1,1,1),(2,2,2);
*/


INSERT into usuarios (apellidom_user,apellidop_user,correo,ext_user,fecha_modificacion,username,password,fecha_creacion,staus_user,tel_user,id_zona,nombre_user, id_per) 
VALUES ('Lima','Flores','ricardo_6_111@got.com',55621,'2022/02/01','RicardoFL_admin','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','2022/02/01','activo','5519360328',1,'RicardoFL_admin',1),
 ('Lima','Flores','ricardo_6_1111@got.com',55621,'2022/02/01','RicardoFL_GG','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','2022/02/01','activo','5519360328',2,'RicardoFL_GG',2),
 ('Lima','Flores','ricardo_6_11111@got.com',55621,'2022/02/01','RicardoFL_CZ','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','2022/02/01','activo','5519360328',3,'RicardoFL_CZ',3),
 ('Lima','Flores','ricardo_6_111111@got.com',55621,'2022/02/01','RicardoFL_AMS','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','2022/02/01','activo','5519360328',4,'RicardoFL_AMS',4),
 ('Lima','Flores','ricardo_6_112222@got.com',55621,'2022/02/01','RicardoFL_TE','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','2022/02/01','activo','5519360328',5,'RicardoFL_TE',5),
 ('Lima','Flores','ricardo_6_1122@got.com',55621,'2022/02/01','RicardoFL_ALM','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','2022/02/01','activo','5519360328',6,'RicardoFL_ALM',6);

/*
insert into usuario_perfil values  (1,1,1);
insert into usuario_perfil values  (2,2,2);
insert into usuario_perfil values  (3,3,3);
insert into usuario_perfil values  (4,4,4);
insert into usuario_perfil values  (5,5,5);
insert into usuario_perfil values  (6,6,6);
*/
select *from status_ticket;
select *from usuarios;


select a.id_user,a.username,a.id_zona, ze.id_zon,ze.nombree 
from usuarios a,zonaestados ze where a.id_user= 1 and ze.id_zon = a.id_zona ;


/*
update usuario_perfil set id_per = 1 where id_user =7;
*/
select * from zonaestados;
select *from perfil;
select ze.id_zon,ze.nombree 
from zonaestados ze where ze.id_zon = 3;

insert into status_ticket (nom_status, descr_status, fecha_modificacion, fecha_creacion)values 
('Abierto','El estado inicial de un ticket tras crearlo','2022/02/01','2022/02/01'),
('Progreso','Algun colaborador ya se encuetra en labores de su atencion','2022/02/01','2022/02/01'),
('Pendiente','Hay una acci´on pendiente sobre este ticket','2022/02/01','2022/02/01'),
('Resuelto','Se ha recopilado informacion sobre la atencion del ticket y se a restaurado el servicio, dando una solucion provisional','2022/02/01','2022/02/01'),
('Cerrado','El ticket pasa a ser un registro historico, ultima fase del ciclo de vida del ticket','2022/02/01','2022/02/01');

select *from servicios;
INSERT into servicios (id_serv,nom_service, descr_ser, impa_ser,  sla, fecha_modificacion, fecha_creacion)
values (1,"Incidente - hardware", "Fallas o mantenientos a hardware","Alto",18, '2022/02/01','2022/02/01' ),
 (2,"Incidente - hardware", "Fallas o mantenientos a hardware","Medio",52, '2022/02/01','2022/02/01' ),
 (3,"Incidente - hardware", "Fallas o mantenientos a hardware","Bajo",168, '2022/02/01','2022/02/01' ),
 (4,"Incidente - software", "Fallas o mantenientos a hardware","Alto",18, '2022/02/01','2022/02/01' ),
 (5,"Incidente - software", "Fallas o mantenientos a hardware","Medio",52, '2022/02/01','2022/02/01' ),
 (6,"Incidente - software", "Fallas o mantenientos a hardware","Bajo",168, '2022/02/01','2022/02/01' ),
 (7,"Requerimientos", "Todo aquel servicio que no represente una falla","Alto",18, '2022/02/01','2022/02/01' ),
 (8,"Requerimientos", "Todo aquel servicio que no represente una falla","Medio",52, '2022/02/01','2022/02/01' ),
 (9,"Requerimientos", "Todo aquel servicio que no represente una falla","Bajo",168, '2022/02/01','2022/02/01' );
 

select *from cuenta;
insert into cuenta (id_cuen, nombre_cuen,  alcan_cuen, desc_cuen, repre_cuen, fecha_modificacion, fecha_creacion)
values (1,"ISSSTE","Nacional","Renta y Soporte Tecnico a equipo de computo","Maria del Carmen Hernandez Juarez",'2022/02/01','2022/02/01'),
	   (2,"FOVISSTE","Nacional","Renta y Soporte Tecnico a equipo de computo","Carlos Alarcon Mons",'2022/02/01','2022/02/01'),
       (3,"PEMEX","Nacional","Renta y Soporte Tecnico a equipo de Servidores","Maria del Carmen Hernandez Juarez",'2022/02/01','2022/02/01'),
       (4,"SEMARNAT","Nacional","Renta y Soporte Tecnico a equipo de Servidores","Saulo Victoriano Castro",'2022/02/01','2022/02/01'),
       (5,"CONANP","Nacional","Renta y Soporte Tecnico a equipo de Servidores","Roman Cen",'2022/02/01','2022/02/01');
       
select *from sla_ticket;
       insert into sla_ticket (id_sla, descripcion, fecha_modificacion, nivel, fecha_creacion, tiempo_sla) values
       (1,"Nivel de SLA Alto",'2022/02/01',"Alto",'2022/02/01',18),
       (2,"Nivel de SLA Medio",'2022/02/01',"Alto",'2022/02/01',52),
       (3,"Nivel de SLA Bajo",'2022/02/01',"Alto",'2022/02/01',168);
       
       select *from cliente;
insert into cliente (id_cliente,apellidop_cli,apellidom_cli,nombre_cli,adscrp_cli, area_cli,tel_cli, ext_cli, correo_cli,id_cuen, fecha_modificacion, fecha_creacion)
values  (1,"GALLEGOS","AGUILAR","JESSICA","Sistemas","Base de datos ","6064698489","552879","GAL.JES@hotmail.com",4,'2022/02/01','2022/02/01'),
(2,"NARVAEZ","MORALES","FERNANDO MOISES","Operaciones ","Direccion","5548898518","967559","NAR.FER@hotmail.com",4,'2022/02/01','2022/02/01'),
(3,"JIMENEZ","COBA","JUAN CARLOS","Sistemas","Base de datos ","8913277493","334891","JIM.JUA@hotmail.com",3,'2022/02/01','2022/02/01');
select *from ticket;
insert into ticket 
(id_ticket, des_error, fecha_modificacion, fecha_creacion, sla_status, id_serv, id_cliente, id_est_repu, id_status_ticket, id_user)
values ( 1,"error en imagen",'2022/02/01','2022/02/01',"En tiempo",1,1,2,1,1);

select *from almacen;
insert into almacen (id_almacen, descripcion, fecha_modificacion, marca, modelo, fecha_creacion, stoc) values
(1,"Equipo de computo",'2022/02/01',"HP","L590",'2022/02/01',60),
(2,"Equipo de ",'2022/02/01',"DELL","DESPOTP-695",'2022/02/01',20); 

select *from sol_alm;

INSERT INTO sol_alm (id_solalm, cantidad, fec_inicio, guia, sla_status_hist, comtario, id_user, fecha_modificacion, fecha_creacion, id_almacen, id_ticket)
VALUES (1,1,'2022/02/01',"206143645AH",30,"Todo esta bien","2",'2022/02/01','2022/02/01',1,1);

select *from his_asigancion;

insert into his_asigancion (id_his_asignacion, comentarios, id_user_final, id_user_inicio, fecha_modificacion, fecha_creacion, status_sla, id_ticket)
values (1,"asignado a juan perez para su atencion a las 10", 2,1,'2022/02/01','2022/02/01',36,1);

SELECT *from his_ticket;

insert into his_ticket (id_histori, comentario, fec_inicio, id_user, fecha_modificacion, fecha_creacion, sla_status_hist, id_sla, id_ticket)
 values  (1,"Se realizo la primer llamada con el  cliente",'2022/02/01',1,'2022/02/01','2022/02/01',20,1,1);