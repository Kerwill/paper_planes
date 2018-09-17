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
var etape_service_1 = require("./etape.service");
var origami_service_1 = require("./origami.service");
var router_1 = require("@angular/router");
var OrigamiDetailsComponent = (function () {
    function OrigamiDetailsComponent(etapeService, origamiService, route) {
        this.etapeService = etapeService;
        this.origamiService = origamiService;
        this.route = route;
    }
    OrigamiDetailsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params.subscribe(function (params) {
            _this.id = params['id'];
        });
    };
    OrigamiDetailsComponent.prototype.getOrigami = function () {
        return this.origamiService.findById(this.id);
    };
    OrigamiDetailsComponent.prototype.getEtapes = function () {
        return this.etapeService.findAllById(this.id);
        //   return this.etapes;
        // }
    };
    return OrigamiDetailsComponent;
}());
OrigamiDetailsComponent = __decorate([
    core_1.Component({
        templateUrl: 'app/origami-details.component.html',
        styleUrls: ['app/origami-details.component.css']
    }),
    __metadata("design:paramtypes", [etape_service_1.EtapeService, origami_service_1.OrigamiService, router_1.ActivatedRoute])
], OrigamiDetailsComponent);
exports.OrigamiDetailsComponent = OrigamiDetailsComponent;
//# sourceMappingURL=origami-details.component.js.map