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
var etape_1 = require("./etape");
var http_1 = require("@angular/http");
var app_config_service_1 = require("./app-config.service");
var EtapeService = (function () {
    function EtapeService(http, appConfigService) {
        this.http = http;
        this.appConfigService = appConfigService;
        this.etapes = null;
        this.id = 0;
    }
    EtapeService.prototype.findAllById = function (id) {
        var _this = this;
        if ((this.etapes === null) || (this.id != id)) {
            this.id = id;
            this.etapes = new Array();
            this.http
                .get(this.appConfigService.getUrlApi() + "etapes/search/by-origami-id?id=" + id)
                .subscribe(function (resp) {
                for (var _i = 0, _a = resp.json()._embedded.etapes; _i < _a.length; _i++) {
                    var e = _a[_i];
                    _this.etapes.push(new etape_1.Etape(e));
                }
                // for (let e of resp.json()._embedded.etapes) {
                //     this.etapes.push(new Etape(e))
                //
                // }
            });
        }
        return this.etapes;
    };
    return EtapeService;
}());
EtapeService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http, app_config_service_1.AppConfigService])
], EtapeService);
exports.EtapeService = EtapeService;
//# sourceMappingURL=etape.service.js.map