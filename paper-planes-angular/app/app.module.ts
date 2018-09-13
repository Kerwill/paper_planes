import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header.component';
import { NavComponent } from './nav.component';
import { OrigamiViewComponent } from './origami-view.component';

import { FooterComponent } from './footer.component';
import { IdeeComponent } from './idee.component';
import { EtapeViewComponent } from './etape-view.component';
import { CategorieComponent } from './categorie.component';

import { AppConfigService } from './app-config.service';
import { OrigamiService } from './origami.service';
import { IdeeService } from './idee.service';
import { CategorieService } from './categorie.service';

//Configuration des routes
const routes: Routes = [
{ path: 'home', component: AppComponent },
{ path: 'origami-view', component: OrigamiViewComponent },
{ path: 'origami-details', component: OrigamiDetailsComponent },

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
      CategorieService

    ],

    declarations: [
        AppComponent,
        HeaderComponent,
        NavComponent,
        OrigamiViewComponent,
        OrigamiComponent,
        FooterComponent,
        IdeeComponent,
        EtapeViewComponent,
        CategorieComponent
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }
