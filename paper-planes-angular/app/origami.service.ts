import { Injectable } from '@angular/core';
import { Origami } from './origami';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable()
export class OrigamiService {
  private origamis: Array<Origami> = new Array<Origami>();
  private myOptions: RequestOptions;

  constructor(private http: Http, private appConfigService : AppConfigService) {
      this.http
           .get(this.appConfigService.getUrlApi() + "origamis")
           .subscribe(resp => {
               for (let o of resp.json()._embedded.origamis) {
                   this.origamis.push(new Origami(o));
               }
           });
  }

  public findAll() : Array<Origami>{
    return this.origamis;
  }

}
//
// public findAllByNom(nom: string) : Array<Produit> {
//
//   return this.produits.filter(p =>
//       p.nom
//           .toLowerCase()
//           .indexOf(nom.toLowerCase()) !== -1
//   )
// }
//
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
