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
var origami_service_1 = require("./origami.service");
var categorie_service_1 = require("./categorie.service");
//import service si besoin
//import classe model si besoin
var OrigamiComponent = (function () {
    function OrigamiComponent(origamiService, categorieService) {
        this.origamiService = origamiService;
        this.categorieService = categorieService;
        this.origami = new origami_1.Origami();
        this.origamis = new Array();
        this.filtreRecherche = "";
        this.isOccasionnel = false;
        this.isNormal = false;
        this.isAvance = false;
        this.isExpert = false;
        this.filtreNiveau = "";
    }
    OrigamiComponent.prototype.Occasionnel = function () {
        if (this.isOccasionnel) {
            this.isOccasionnel = false;
        }
        else {
            this.isOccasionnel = true;
        }
        return this.isOccasionnel;
    };
    OrigamiComponent.prototype.Normal = function () {
        if (this.isNormal) {
            this.isNormal = false;
        }
        else {
            this.isNormal = true;
        }
        return this.isNormal;
    };
    OrigamiComponent.prototype.Avance = function () {
        if (this.isAvance) {
            this.isAvance = false;
        }
        else {
            this.isAvance = true;
        }
        return this.isAvance;
    };
    OrigamiComponent.prototype.Expert = function () {
        if (this.isExpert) {
            this.isExpert = false;
        }
        else {
            this.isExpert = true;
        }
        return this.isExpert;
    };
    OrigamiComponent.prototype.getOrigamis = function () {
        if (this.filtreRecherche !== null) {
            this.origamis = this.origamiService.findByNomContaining(this.filtreRecherche);
        }
        else {
            this.origamis = this.origamiService.findAll();
        }
        return this.origamis;
    };
    // public getOrigamisByNiveau() {
    //
    // }
    // click(ev){
    //    console.log(ev);
    // }
    OrigamiComponent.prototype.addOrigami = function () {
        this.origamis.push(this.origami);
        this.origami = new origami_1.Origami();
    };
    OrigamiComponent.prototype.filtrerOrigamis = function () {
        return null;
        // return this.origamis.filter(o =>
        //     o.getNom()
        //         .toLowerCase()
        //         .indexOf(this.filtre.toLowerCase()) !== -1
        // )
    };
    OrigamiComponent.prototype.getCategories = function () {
        return this.categorieService.findAll();
    };
    return OrigamiComponent;
}());
OrigamiComponent = __decorate([
    core_1.Component({
        selector: 'origamis',
        templateUrl: 'app/origami.component.html',
        styleUrls: ['app/origami.component.css']
    }),
    __metadata("design:paramtypes", [origami_service_1.OrigamiService, categorie_service_1.CategorieService])
], OrigamiComponent);
exports.OrigamiComponent = OrigamiComponent;
//# sourceMappingURL=origami.component.js.map