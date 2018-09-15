import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './home.component';
import { HeaderComponent } from './header.component';
import { FooterComponent } from './footer.component';
import { NavComponent } from './nav.component';
import { OrigamiComponent } from './origami.component';
import { OrigamiDetailsComponent } from './origami-details.component';
import { IdeeComponent } from './idee.component';
import { CategorieComponent } from './categorie.component';

import { AppConfigService } from './app-config.service';
import { OrigamiService } from './origami.service';
import { IdeeService } from './idee.service';
import { CategorieService } from './categorie.service';
import { EtapeService } from './etape.service';

//Configuration des routes
const routes: Routes = [
{ path: 'home', component: HomeComponent },
{ path: 'origami-list', component: OrigamiComponent },
{ path: 'origami-details/:id', component: OrigamiDetailsComponent },

{ path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        RouterModule.forRoot(routes),
        FormsModule
    ],

    providers: [
      AppConfigService,
      OrigamiService,
      IdeeService,
      CategorieService,
      EtapeService

    ],

    declarations: [
        AppComponent,
        HeaderComponent,
        NavComponent,
        OrigamiComponent,
        FooterComponent,
        IdeeComponent,
        OrigamiDetailsComponent,
        CategorieComponent,
        HomeComponent
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }