drop database if exists PT1_MESA;
create database PT1_MESA;
use PT1_MESA;

DROP TABLE IF EXISTS  ZonaEstados;    
	create table ZonaEstados(
		IDZonEsta int AUTO_INCREMENT,
		Nombre varchar(20) not null,
		primary key(IDZonEsta)
        );
        
 DROP TABLE IF EXISTS  EstadosRepu;    
	create table EstadosRepu(
		IDEstadosRepu int AUTO_INCREMENT ,
		NombreEstado varchar(20) not null,
        IDZonEstaEs int not null,
		primary key(IDEstadosRepu),
  foreign key(IDZonEstaEs) references ZonaEstados(IDZonEsta) on delete cascade on update cascade		
        );

DROP TABLE IF EXISTS  perfil;
create table perfil(
		id_per  int AUTO_INCREMENT ,
		Nom_per varchar(20) not null,
        desc_per varchar(15) not null,
        Niv_perm_per varchar(10) not null, 
		primary key(id_per)
        );


DROP TABLE IF EXISTS  Usuarios;
	create table Usuarios(
		Id_user  int AUTO_INCREMENT ,
		Nombre_user varchar(20) not null,
        ApellidoM_user varchar(15) not null,
		ApellidoP_user varchar(15) not null,
        correo_user varchar(30) not null,
        tel_user int(10) not null,
        ext_user int(6) not null,
        staus_user varchar(10) not null,
        id_per int not null, 
        id_zona int not null, 
         foreign key(id_per) references perfil(id_per) on delete cascade on update cascade	,
         foreign key(id_zona) references ZonaEstados(IDZonEsta) on delete cascade on update cascade	,
		primary key(Id_user)
        );
        
        
         DROP TABLE IF EXISTS  StatusTiket;             
create table StatusTiket(
		IDStatusTiket int AUTO_INCREMENT ,
		TipoStatus varchar(20) not null,
		primary key(IDStatusTiket)
        );
        
      DROP TABLE IF EXISTS  Servicio;             
create table Servicio(
		id_serv int AUTO_INCREMENT ,
		Nom_ser varchar(20) not null,
        Descr_ser varchar(50) not null,
        Impa_ser varchar(50) not null,
		SLA int(3) not null,
		primary key(id_serv)
        );
    
    DROP TABLE IF EXISTS  Cuenta;             
create table Cuenta(
		Id_cuen  int AUTO_INCREMENT ,
		Nombre_cuen varchar(50) not null,
        Descripcion_cuen varchar(75) not null,
        Repr_cuen varchar(30) not null,
        Alcan_cuen varchar(30) not null,
       primary key(Id_cuen)
        );
    
DROP TABLE IF EXISTS  Cliente;             
create table Cliente(
		Id_cli  int AUTO_INCREMENT ,
        id_cuen int not null,
		Nombre_cli varchar(20) not null,
        ApellidoM_cli varchar(15) not null,
		ApellidoP_cli varchar(15) not null,
        correo_cli varchar(30) not null,
        tel_cli int(10) not null,
        ext_cli int(6) not null,
        Adscrp_clie varchar(30) not null,
        area_cli varchar(30) not null,
           foreign key(id_cuen) references Cuenta(Id_cuen) on delete cascade on update cascade	,
       primary key(Id_cli)
        );

DROP TABLE IF EXISTS  Ticket;
	create table Ticket(
		Id_ticket  int AUTO_INCREMENT ,
		Id_serv int not null,
        id_clien int  not null,
        id_user int  not null,
        id_status int  not null,
		Id_Estado int not null,
        des_error TEXT null,
		date_inic datetime not null ,
        date_cierre datetime ,
        SLA_status varchar (10),
        
		 foreign key(Id_serv) references Servicio(id_serv) on delete cascade on update cascade	,
         foreign key(id_clien) references Cliente(Id_cli) on delete cascade on update cascade	,
         foreign key(id_user) references Usuarios(Id_user) on delete cascade on update cascade	,
         foreign key(Id_Estado) references EstadosRepu(IDEstadosRepu) on delete cascade on update cascade	,
         foreign key(id_status) references StatusTiket(IDStatusTiket) on delete cascade on update cascade	,
		primary key(Id_ticket)
        );
                
DROP TABLE IF EXISTS  HisTicket;
	create table HisTicket(
		Id_histori  int AUTO_INCREMENT,
        Id_ticket int  not null,
        id_user int  not null,
        comentario text  not null,
		date_inic datetime not null ,
        SLA_status_His varchar (10),
        foreign key(Id_ticket) references Ticket(Id_ticket) on delete cascade on update cascade	,
		primary key(Id_histori)
        );

        
	DROP TABLE IF EXISTS  Asig_his;
		create table Asig_his(
		id_asig int AUTO_INCREMENT,
        id_ticket int  not null,
        id_user_ini int  not null,
        id_user_fin int  not null,        
        comentario text  not null,
		date_inic datetime not null,
        SLA_status_asi varchar (10),
        foreign key(id_ticket) references Ticket(Id_ticket) on delete cascade on update cascade,
		primary key(id_asig)
        );
        
	  DROP TABLE IF EXISTS  Refacciones;
		create table Refacciones(
		id_ref int AUTO_INCREMENT,
        id_ticket_ref int not null,
        Marca varchar (10),
		Modelo varchar (10),
        Descrip varchar (10),
        foreign key(id_ticket_ref) references Ticket(Id_ticket) on delete cascade on update cascade,
		primary key(id_ref)
        );
        
        
        
        
        
DROP TABLE IF EXISTS  Sol_alm;
		create table Sol_alm(
		id_Solalm int AUTO_INCREMENT,
        id_ticket int not null,
        id_user int  not null,
        id_refa int  not null,
        comentario text  not null,
        cantidad  int not null,
		date_inic datetime not null ,
        SLA_status_asi varchar (10),
        foreign key(id_ticket) references Ticket(Id_ticket) on delete cascade on update cascade,
		primary key(id_Solalm)
        );
                

     
