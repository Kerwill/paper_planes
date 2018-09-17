"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var platform_browser_1 = require("@angular/platform-browser");
var http_1 = require("@angular/http");
var forms_1 = require("@angular/forms");
var app_component_1 = require("./app.component");
var home_component_1 = require("./home.component");
var header_component_1 = require("./header.component");
var footer_component_1 = require("./footer.component");
var nav_component_1 = require("./nav.component");
var origami_component_1 = require("./origami.component");
var origami_details_component_1 = require("./origami-details.component");
var idee_component_1 = require("./idee.component");
var categorie_component_1 = require("./categorie.component");
var app_config_service_1 = require("./app-config.service");
var origami_service_1 = require("./origami.service");
var idee_service_1 = require("./idee.service");
var categorie_service_1 = require("./categorie.service");
var etape_service_1 = require("./etape.service");
//Configuration des routes
var routes = [
    { path: 'home', component: home_component_1.HomeComponent },
    { path: 'origami-list', component: origami_component_1.OrigamiComponent },
    { path: 'origami-details/:id', component: origami_details_component_1.OrigamiDetailsComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }
];
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            platform_browser_1.BrowserModule,
            http_1.HttpModule,
            router_1.RouterModule.forRoot(routes),
            forms_1.FormsModule
        ],
        providers: [
            app_config_service_1.AppConfigService,
            origami_service_1.OrigamiService,
            idee_service_1.IdeeService,
            categorie_service_1.CategorieService,
            etape_service_1.EtapeService
        ],
        declarations: [
            app_component_1.AppComponent,
            header_component_1.HeaderComponent,
            nav_component_1.NavComponent,
            origami_component_1.OrigamiComponent,
            footer_component_1.FooterComponent,
            idee_component_1.IdeeComponent,
            origami_details_component_1.OrigamiDetailsComponent,
            categorie_component_1.CategorieComponent,
            home_component_1.HomeComponent
        ],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map