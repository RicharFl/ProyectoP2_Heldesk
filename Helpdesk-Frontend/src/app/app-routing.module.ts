import { ActulizaclienteComponent } from './pages/admin/clientes/actulizacliente/actulizacliente.component';
import { CreaClienteComponent } from './pages/admin/clientes/crea-cliente/crea-cliente.component';
import { ListaclientesComponent } from './pages/admin/clientes/listaclientes/listaclientes.component';
import { CreaCuentaDependenciaComponent } from './pages/admin/cuentasDependencias/crea-cuenta-dependencia/crea-cuenta-dependencia.component';
import { ListaCuentaDependenciaComponent } from './pages/admin/cuentasDependencias/lista-cuenta-dependencia/lista-cuenta-dependencia.component';
import { ActilizaRolesComponent } from './pages/admin/roles/actiliza-roles/actiliza-roles.component';
import { CreaRolesComponent } from './pages/admin/roles/crea-roles/crea-roles.component';
import { ListaRolesComponent } from './pages/admin/roles/lista-roles/lista-roles.component';
import { CreaEstadosRepubliComponent } from './pages/admin/Estodos-Republica/crea-estados-republi/crea-estados-republi.component';
import { ListaEstadosRepubliComponent } from './pages/admin/Estodos-Republica/lista-estados-republi/lista-estados-republi.component';
import { AsignarTicketComponent } from './pages/admin/asignar-ticket/asignar-ticket/asignar-ticket.component';
import { DocTicketComponent } from './pages/admin/doc-ticket/doc-ticket/doc-ticket.component';
import { CrearticketComponent } from './pages/admin/crearticket/crearticket/crearticket.component';
import { EditarTicketComponent } from './pages/admin/editarTicket/editar-ticket/editar-ticket.component';
import { TicketAdminComponent } from './pages/admin/ticket-admin/ticket-admin.component';
import { AgregarUserAdminComponent } from './pages/admin/agregar-user-admin/agregar-user-admin/agregar-user-admin.component';


import { ActualizaEmpleadoAdminComponent } from './pages/admin/actuliza-empleado-admin/actualiza-empleado-admin/actualiza-empleado-admin.component';
import { ListaEmpleadosAdminComponent } from './pages/admin/lista-empleados-admin/lista-empleados-admin/lista-empleados-admin.component';
import { DatosPerfilComponent } from './pages/admin/datos_perfil/datos-perfil/datos-perfil.component';
import { AlmacenGuard } from './services/almacen.guard';
import { AlmacenComponent } from './pages/almacen/dashboar-almacen/almacen/almacen.component';
import { TecnicoEspecGuard } from './services/tecnico-espec.guard';
import { TecnicoEspecComponent } from './pages/Tecnico_Espec/dashboar-tecnico_espec/tecnico-espec/tecnico-espec.component';
import { AgenteZonaComponent } from './pages/Agente_mesa/dashboar-Agente_mesa/agente-zona/agente-zona.component';
import { CordinadorZonaGuard } from './services/cordinador-zona.guard';
import { GerenteGeneralGuard } from './services/gerente-general.guard';
import { CordinadorZonaComponent } from './pages/Cordinador_zona/dashboar-cordinador_zona/cordinador-zona/cordinador-zona.component';
import { DdashboarGerenteGeneralComponent } from './pages/Gerente_general/dashboar-gerente_general/ddashboar-gerente-general/ddashboar-gerente-general.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { HomeComponent } from './pages/home/home.component';
import { NgModule, Component } from '@angular/core';
import { ChildrenOutletContexts, RouterModule, Routes } from '@angular/router';
import { DashboarAdminComponent } from './pages/admin/dashboar-admin/dashboar-admin.component';
import { AdminGuard } from './services/admin.guard';
import { AgenteMesaGuard } from './services/agente-mesa.guard';
import { DetalleTicketComponent } from './pages/admin/detaller-ticket/detalle-ticket/detalle-ticket.component';
import { ContrasenaGuard } from './services/contrasena.guard';
import { CambioContrasenaComponent } from './pages/admin/cambio-contrasena/cambio-contrasena.component';
import { ActualizaEstadosRepubliComponent } from './pages/admin/Estodos-Republica/actualiza-estados-republi/actualiza-estados-republi.component';
import { ListaZonaEstadosComponent } from './pages/admin/ZonaRegion/lista-zona-estados/lista-zona-estados.component';
import { CreaZonaEstadosComponent } from './pages/admin/ZonaRegion/crea-zona-estados/crea-zona-estados.component';
import { ActulizaZonaEstadosComponent } from './pages/admin/ZonaRegion/actuliza-zona-estados/actuliza-zona-estados.component';
import { ActualizaCuentaDependenciaComponent } from './pages/admin/cuentasDependencias/actualiza-cuenta-dependencia/actualiza-cuenta-dependencia.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'registroUsuarios',
    component: SignupComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },

  /*{
    path:'datos_perfil/:username',
    component:DatosPerfilComponent
 
  },*/
  
  {
    path: 'admin',
    component: DashboarAdminComponent,
    // pathMatch: 'full',
    canActivate: [AdminGuard],
    children: [
      {
        path: 'datos_perfil',
        component: DatosPerfilComponent,
        //title: 'hola perfil',
      
      },
      {
        path: 'actualizar-contrasena',
        component: CambioContrasenaComponent,
       
    
      },
      {
        path: 'ticket_admin',
        component: TicketAdminComponent,
        //title: 'hola perfil',
      },
      {
        path: 'estados_republica',
        component: ListaEstadosRepubliComponent,
        //title: 'hola perfil',
      },

      
      {
        path: 'estados_republica/crear_estado',
        component: CreaEstadosRepubliComponent,
        //title: 'hola perfil',
      },
      {
        path: 'estados_republica/edita/:idEdo',
        component: ActualizaEstadosRepubliComponent,
        //title: 'hola perfil',
      },
      {
        path: 'zona_estados',
        component: ListaZonaEstadosComponent,
        //title: 'hola perfil',
      },
      {
        path: 'zona_estados/crear_estado',
        component: CreaZonaEstadosComponent,
        //title: 'hola perfil',
      },
      {
        path: 'zona_estados/edita/:idZonEdo',
        component: ActulizaZonaEstadosComponent,
        //title: 'hola perfil',
      }, 

      {
        path: 'clientes',
        component: ListaclientesComponent,
        //title: 'hola perfil',
      },
      {
        path: 'clientes/crear_cliente',
        component: CreaClienteComponent,
        //title: 'hola perfil',
      },
      {
        path: 'clientes/edita/:idcliente',  
        component: ActulizaclienteComponent,
        //title: 'hola perfil',
      }, 

      
      {
        path: 'cuentas_dependencia',
        component: ListaCuentaDependenciaComponent,
        //title: 'hola perfil',
      },
      {
        path: 'cuentas_dependencia/crear_cuenta',
        component: CreaCuentaDependenciaComponent,
        //title: 'hola perfil',
      },
      {
        path: 'cuentas_dependencia/edita/:idcuenta',
        component: ActualizaCuentaDependenciaComponent,
        //title: 'hola perfil',
      },
      {
        path: 'roles',
        component: ListaRolesComponent,
        //title: 'hola perfil',
      },
      {
        path: 'roles/crea_rol',
        component: CreaRolesComponent,
        //title: 'hola perfil',
      },
      {
        path: 'roles/edita/:idRol',
        component: ActilizaRolesComponent,
        //title: 'hola perfil',
      }, 
      {
        path: 'asignar_ticket/:idticket',
        component: AsignarTicketComponent,
        //title: 'hola perfil',
      },
      {
        path: 'crear_ticket',
        component: CrearticketComponent,
        //title: 'hola perfil',
      },
      {
        path: 'deetalle_ticket/:idticket',
        component: DetalleTicketComponent,
        //title: 'hola perfil',
      },
      {
        path: 'editar_ticket/:idticket',
        component: EditarTicketComponent,
        //title: 'hola perfil',
      },
      {
        path: 'documentar_ticket/:idticket',
        component: DocTicketComponent,
        //title: 'hola perfil',
      },
      {
        path: 'datos_perfil/:username',
        component: DatosPerfilComponent
      },

      {
        path: 'lista_usuarios',
        component: ListaEmpleadosAdminComponent
      },
      {
        path: 'actualiza_usuario/:username',
        component: ActualizaEmpleadoAdminComponent
      }
      ,
      {
        path: 'agregar-user',
        component: AgregarUserAdminComponent
      }
    ]

  },
  {
    path: 'gerente_general',
    component: DdashboarGerenteGeneralComponent,
    pathMatch: 'full',
    canActivate: [GerenteGeneralGuard]

  },
  {
    path: 'cordinador_zona',
    component: CordinadorZonaComponent,
    pathMatch: 'full',
    canActivate: [CordinadorZonaGuard]
  },
  {
    path: 'agente-mesa',
    component: AgenteZonaComponent,
    pathMatch: 'full',
    canActivate: [AgenteMesaGuard]
  },
  {
    path: 'tecnico_especialista',
    component: TecnicoEspecComponent,
    pathMatch: 'full',
    canActivate: [TecnicoEspecGuard]
  },
  {
    path: 'almacen',
    component: AlmacenComponent,
    pathMatch: 'full',
    canActivate: [AlmacenGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
