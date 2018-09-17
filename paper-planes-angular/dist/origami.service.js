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
var origami_1 = require("./origami");
var http_1 = require("@angular/http");
var app_config_service_1 = require("./app-config.service");
var OrigamiService = (function () {
    function OrigamiService(http, appConfigService) {
        var _this = this;
        this.http = http;
        this.appConfigService = appConfigService;
        this.origamis = new Array();
        this.filtre = "";
        this.http
            .get(this.appConfigService.getUrlApi() + "origamis")
            .subscribe(function (resp) {
            for (var _i = 0, _a = resp.json()._embedded.origamis; _i < _a.length; _i++) {
                var o = _a[_i];
                _this.origamis.push(new origami_1.Origami(o));
            }
        });
    }
    OrigamiService.prototype.findById = function (id) {
        var _this = this;
        if ((this.origami === null) || (this.id != id)) {
            this.id = id;
            this.origami = new origami_1.Origami();
            this.http
                .get(this.appConfigService.getUrlApi() + "origamis/" + id)
                .subscribe(function (resp) {
                _this.origami = resp.json();
            });
        }
        return this.origami;
    };
    OrigamiService.prototype.findAll = function () {
        return this.origamis;
    };
    OrigamiService.prototype.findByNomContaining = function (filtre) {
        var _this = this;
        if (filtre != this.filtre) {
            this.filtre = filtre;
            this.origamis = new Array();
            this.http
                .get(this.appConfigService.getUrlApi() + "origamis/search/by-nom-containing?nom=" + filtre)
                .subscribe(function (resp) {
                for (var _i = 0, _a = resp.json()._embedded.origamis; _i < _a.length; _i++) {
                    var o = _a[_i];
                    _this.origamis.push(new origami_1.Origami(o));
                }
            });
        }
        return this.origamis;
    };
    return OrigamiService;
}());
OrigamiService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http, app_config_service_1.AppConfigService])
], OrigamiService);
exports.OrigamiService = OrigamiService;
// public findAllByNom(nom: string) : Array<Origami> {
//   return this.origamis.filter(o =>
//     o.nom
//         .toLowerCase()
//         .indexOf(nom.toLowerCase()) !== -1
//   );
// }
// public save(produit){
// if (this.produits.indexOf(produit) === -1){
//   // this.produits.push(produit);
//
//   produit.gamme = this.apiConfigService.getUrlApi()+"gammes/1"
// this.http
//
//   .post(this.apiConfigService.getUrlApi()+"produits", produit, this.myOptions)
//   .subscribe(resp => this.produits.push(produit), err => alert("erreur dans le prix"));
// }
// else{
//   this.http
//       .put(produit.getHref(), produit, this.myOptions)
//     .subscribe(resp => alert("modif ok")/*this.produits.push(resp.json())*/, err => alert (err));
// }
// }
// public delete(produit){
// let myIndex: number = this.produits.indexOf(produit);
// this.http
//     .delete(produit.getHref(), this.myOptions)
//   .subscribe(resp => this.produits.splice(myIndex, 1));
//
// }
//# sourceMappingURL=origami.service.js.map