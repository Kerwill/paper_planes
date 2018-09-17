"use strict";
var Categorie = (function () {
    function Categorie(json) {
        this.json = json;
        if (json !== undefined) {
            this.nom = json.nom;
            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }
    Categorie.prototype.getNom = function () {
        return this.nom;
    };
    Categorie.prototype.getHref = function () {
        return this.href;
    };
    return Categorie;
}());
exports.Categorie = Categorie;
//# sourceMappingURL=categorie.js.map