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
    DetalleTicketComponent
    
    
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
