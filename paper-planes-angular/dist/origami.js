"use strict";
var Origami = (function () {
    function Origami(json) {
        this.json = json;
        if (json !== undefined) {
            this.nom = json.nom;
            this.temps = json.temps;
            this.note = json.note;
            this.niveau = json.niveau;
            this.id = json.id;
            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }
    Origami.prototype.getNom = function () {
        return this.nom;
    };
    Origami.prototype.getTemps = function () {
        return this.temps;
    };
    Origami.prototype.getNote = function () {
        return this.note;
    };
    Origami.prototype.getNiveau = function () {
        return this.niveau;
    };
    Origami.prototype.getHref = function () {
        return this.href;
    };
    return Origami;
}());
exports.Origami = Origami;
//# sourceMappingURL=origami.js.map