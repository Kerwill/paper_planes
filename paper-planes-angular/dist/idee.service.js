"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var app_config_service_1 = require("./app-config.service");
var IdeeService = (function () {
    function IdeeService(http, appConfigService) {
        this.http = http;
        this.appConfigService = appConfigService;
    }
    IdeeService.prototype.save = function (idee) {
        idee.setNom(this.appConfigService.getUrlApi() + "idees/this.nom");
        idee.setPrenom(this.appConfigService.getUrlApi() + "idees/this.prenom");
        idee.setEmail(this.appConfigService.getUrlApi() + "idees/this.mail");
        idee.setDescription(this.appConfigService.getUrlApi() + "idees/this.description");
        this.http
            .post(this.appConfigService.getUrlApi() + "idees", {
            idee: idee.getHref()
        })
            .subscribe(function (resp) { return alert("Message envoyé !"); });
    };
    return IdeeService;
}());
IdeeService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http, app_config_service_1.AppConfigService])
], IdeeService);
exports.IdeeService = IdeeService;
//# sourceMappingURL=idee.service.js.map