import { NgModule , LOCALE_ID} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { registerLocaleData } from '@angular/common';
import locaeEsM from '@angular/common/locales/es-MX'
import { FormsModule } from '@angular/forms';
registerLocaleData(locaeEsM)

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatDialogModule } from '@angular/material/dialog';

import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { DashboarAdminComponent } from './pages/admin/dashboar-admin/dashboar-admin.component';

import { FlexLayoutModule } from '@angular/flex-layout';
import { MatSidenavModule } from '@angular/material/sidenav';
import { DdashboarGerenteGeneralComponent } from './pages/Gerente_general/dashboar-gerente_general/ddashboar-gerente-general/ddashboar-gerente-general.component';
import { CordinadorZonaComponent } from './pages/Cordinador_zona/dashboar-cordinador_zona/cordinador-zona/cordinador-zona.component';
import { AgenteZonaComponent } from './pages/Agente_mesa/dashboar-Agente_mesa/agente-zona/agente-zona.component';
import { TecnicoEspecComponent } from './pages/Tecnico_Espec/dashboar-tecnico_espec/tecnico-espec/tecnico-espec.component';
import { AlmacenComponent } from './pages/almacen/dashboar-almacen/almacen/almacen.component';
import {MatDividerModule} from '@angular/material/divider';
import { SiderAdminComponent } from './pages/admin/sidebar-admin/sider-admin/sider-admin.component';
import {MatListModule} from '@angular/material/list';
import { DatosPerfilComponent } from './pages/admin/datos_perfil/datos-perfil/datos-perfil.component';
import { ListaEmpleadosAdminComponent } from './pages/admin/lista-empleados-admin/lista-empleados-admin/lista-empleados-admin.component';
import { ActualizaEmpleadoAdminComponent } from './pages/admin/actuliza-empleado-admin/actualiza-empleado-admin/actualiza-empleado-admin.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { AgregarUserAdminComponent } from './pages/admin/agregar-user-admin/agregar-user-admin/agregar-user-admin.component';
import { TicketAdminComponent } from './pages/admin/ticket-admin/ticket-admin.component';
import {MatTableModule} from '@angular/material/table';
import { FilterPipe } from './pipes/filter.pipe';
import { FiltroRolPipe } from './pipes/filtro-rol.pipe';
import { DetalleTicketComponent } from './pages/admin/detaller-ticket/detalle-ticket/detalle-ticket.component';
import { EditarTicketComponent } from './pages/admin/editarTicket/editar-ticket/editar-ticket.component';
import { CrearticketComponent } from './pages/admin/crearticket/crearticket/crearticket.component';
import { DocTicketComponent } from './pages/admin/doc-ticket/doc-ticket/doc-ticket.component';
import { AsignarTicketComponent } from './pages/admin/asignar-ticket/asignar-ticket/asignar-ticket.component';
import { AsignadosAmiComponent } from './pages/admin/ticket_asignados_ami/asignados-ami/asignados-ami.component';
import { FilterTicketPipe } from './pipes/filter-ticket.pipe';
import { CambioContrasenaComponent } from './pages/admin/cambio-contrasena/cambio-contrasena.component';
import { ListaEstadosRepubliComponent } from './pages/admin/Estodos-Republica/lista-estados-republi/lista-estados-republi.component';
import { ActualizaEstadosRepubliComponent } from './pages/admin/Estodos-Republica/actualiza-estados-republi/actualiza-estados-republi.component';
import { CreaEstadosRepubliComponent } from './pages/admin/Estodos-Republica/crea-estados-republi/crea-estados-republi.component';
import { FilterEstadoRepuPipe } from './pipes/filter-estado-repu.pipe';
import { ListaZonaEstadosComponent } from './pages/admin/ZonaRegion/lista-zona-estados/lista-zona-estados.component';
import { CreaZonaEstadosComponent } from './pages/admin/ZonaRegion/crea-zona-estados/crea-zona-estados.component';
import { ActulizaZonaEstadosComponent } from './pages/admin/ZonaRegion/actuliza-zona-estados/actuliza-zona-estados.component';
import { FilterZonaEstadoPipe } from './pipes/filter-zona-estado.pipe';
import { ListaRolesComponent } from './pages/admin/roles/lista-roles/lista-roles.component';
import { ActilizaRolesComponent } from './pages/admin/roles/actiliza-roles/actiliza-roles.component';
import { CreaRolesComponent } from './pages/admin/roles/crea-roles/crea-roles.component';
import { CreaCuentaDependenciaComponent } from './pages/admin/cuentasDependencias/crea-cuenta-dependencia/crea-cuenta-dependencia.component';
import { ActualizaCuentaDependenciaComponent } from './pages/admin/cuentasDependencias/actualiza-cuenta-dependencia/actualiza-cuenta-dependencia.component';
import { ListaCuentaDependenciaComponent } from './pages/admin/cuentasDependencias/lista-cuenta-dependencia/lista-cuenta-dependencia.component';
import { FilterCuentaPipe } from './pipes/filter-cuenta.pipe';
import { FilterClientesPipe } from './pipes/filter-clientes.pipe';
import { FilterServiciosPipe } from './pipes/filter-servicios.pipe';
import { ListaclientesComponent } from './pages/admin/clientes/listaclientes/listaclientes.component';
import { ActulizaclienteComponent } from './pages/admin/clientes/actulizacliente/actulizacliente.component';
import { CreaClienteComponent } from './pages/admin/clientes/crea-cliente/crea-cliente.component';
import { ListaServiciosComponent } from './pages/admin/servicios/lista-servicios/lista-servicios.component';
import { CreaServicioComponent } from './pages/admin/servicios/crea-servicio/crea-servicio.component';
import { ActualizaServicioComponent } from './pages/admin/servicios/actualiza-servicio/actualiza-servicio.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DashboarAdminComponent,
    DdashboarGerenteGeneralComponent,
    CordinadorZonaComponent,
    AgenteZonaComponent,
    TecnicoEspecComponent,
    AlmacenComponent,
    SiderAdminComponent,
    DatosPerfilComponent,
    ListaEmpleadosAdminComponent,
    ActualizaEmpleadoAdminComponent,
    AgregarUserAdminComponent,
    TicketAdminComponent,
    FilterPipe,
    FiltroRolPipe,
    DetalleTicketComponent,
    EditarTicketComponent,
    CrearticketComponent,
    DocTicketComponent,
    AsignarTicketComponent,
    AsignadosAmiComponent,
    FilterTicketPipe,
    CambioContrasenaComponent,
    ListaEstadosRepubliComponent,
    ActualizaEstadosRepubliComponent,
    CreaEstadosRepubliComponent,
    FilterEstadoRepuPipe,
    ListaZonaEstadosComponent,
    CreaZonaEstadosComponent,
    ActulizaZonaEstadosComponent,
    FilterZonaEstadoPipe,
    ListaRolesComponent,
    ActilizaRolesComponent,
    CreaRolesComponent,
    CreaCuentaDependenciaComponent,
    ActualizaCuentaDependenciaComponent,
    ListaCuentaDependenciaComponent,
    FilterCuentaPipe,
    FilterClientesPipe,
    FilterServiciosPipe,
    ListaclientesComponent,
    ActulizaclienteComponent,
    CreaClienteComponent,
    ListaServiciosComponent,
    CreaServicioComponent,
    ActualizaServicioComponent
   
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatCardModule,
    MatInputModule,
    MatDialogModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatDividerModule,
    MatListModule,
    NgxPaginationModule,
    MatTableModule
    
    
  ],
  providers: [{
    provide: LOCALE_ID,
    useValue :'es-MX'
  }
  
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
