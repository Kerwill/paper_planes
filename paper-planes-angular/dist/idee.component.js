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
var idee_service_1 = require("./idee.service");
var IdeeComponent = (function () {
    function IdeeComponent(ideeService) {
        this.ideeService = ideeService;
    }
    IdeeComponent.prototype.addIdee = function (idee) {
        this.ideeService.save(idee);
    };
    return IdeeComponent;
}());
IdeeComponent = __decorate([
    core_1.Component({
        templateUrl: 'app/idee.component.html',
        styleUrls: ['app/idee.component.css']
    }),
    __metadata("design:paramtypes", [idee_service_1.IdeeService])
], IdeeComponent);
exports.IdeeComponent = IdeeComponent;
//# sourceMappingURL=idee.component.js.map