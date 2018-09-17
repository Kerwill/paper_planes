"use strict";
var Idee = (function () {
    function Idee(json) {
        this.json = json;
        if (json !== undefined) {
            this.nom = json.nom;
            this.prenom = json.prenom;
            this.mail = json.mail;
            this.description = json.description;
            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }
    Idee.prototype.getNom = function () {
        return this.nom;
    };
    Idee.prototype.getPrenom = function () {
        return this.prenom;
    };
    Idee.prototype.getMail = function () {
        return this.mail;
    };
    Idee.prototype.getDescription = function () {
        return this.description;
    };
    Idee.prototype.getHref = function () {
        return this.href;
    };
    return Idee;
}());
exports.Idee = Idee;
//# sourceMappingURL=idee.js.map