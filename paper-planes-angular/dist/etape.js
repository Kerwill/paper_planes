"use strict";
var Etape = (function () {
    function Etape(json) {
        this.json = json;
        if (json !== undefined) {
            this.ordre = json.ordre;
            this.descriptif = json.descriptif;
            this.image = json.image;
            this.video = json.video;
            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }
    Etape.prototype.getOrdre = function () {
        return this.ordre;
    };
    Etape.prototype.getDescriptif = function () {
        return this.descriptif;
    };
    Etape.prototype.getImage = function () {
        return this.image;
    };
    Etape.prototype.getVideo = function () {
        return this.video;
    };
    Etape.prototype.getHref = function () {
        return this.href;
    };
    return Etape;
}());
exports.Etape = Etape;
//# sourceMappingURL=etape.js.map