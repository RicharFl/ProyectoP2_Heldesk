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
        children: [
          ]
      },
      {
        path: 'ticket_admin',
        component: TicketAdminComponent,
        //title: 'hola perfil',
      },
      {
        path: 'deetalle_ticket/:idticket',
        component: DetalleTicketComponent,
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
