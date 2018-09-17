import { Injectable } from '@angular/core';
import { Origami } from './origami';
import { Categorie } from './categorie';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable()

export class OrigamiService {
  private origamis: Array<Origami> = new Array<Origami>();
  private origami : Origami;
  private id: number;


  private filtreRecherche: string = "";
  private isOccasionnel : boolean = false;
  private isNormal : boolean = false;
  private isAvance : boolean = false;
  private isExpert : boolean = false;
  private selectedCategorieId : number = 0;



  constructor(private http: Http, private appConfigService : AppConfigService) {
      this.http
           .get(this.appConfigService.getUrlApi() + "origamis")
           .subscribe(resp => {

               for (let o of resp.json()._embedded.origamis) {
                   this.origamis.push(new Origami(o));
             }
           }
           );
  }


  public findAll() : Array<Origami>{
    return this.origamis;
  }

  public findById(id) : Origami{
    if ((this.origami === null) || (this.id != id) ) {
      this.id = id;
      this.origami = new Origami();
      this.http
           .get(this.appConfigService.getUrlApi() + "origamis/"+id)
           .subscribe(resp => {
             this.origami = resp.json()});
            }
    return this.origami;
  }


//   public findByNomContaining(filtre: string): Array<Origami> {
//
// if (filtre != this.filtre){
//     this.filtre = filtre;
//     this.origamis = new Array<Origami>();
//
//       this.http
//            .get(this.appConfigService.getUrlApi() + "origamis/search/by-nom-containing?nom="+filtre)
//            .subscribe(resp => {
//                for (let o of resp.json()._embedded.origamis) {
//                    this.origamis.push(new Origami(o));
//              }
//            }
//            );
//   }
//     return this.origamis;
//
// }




public findAllFiltrated(filtreRecherche: string,  selectedCategorieId : number, isOccasionnel : boolean, isNormal : boolean, isAvance : boolean, isExpert : boolean): Array<Origami> {

if (filtreRecherche != this.filtreRecherche || selectedCategorieId != this.selectedCategorieId || isOccasionnel != this.isOccasionnel ||  isNormal != this.isNormal ||  isAvance != this.isAvance ||  isExpert != this.isExpert){
  this.filtreRecherche = filtreRecherche;
  this.selectedCategorieId = selectedCategorieId;
  this.isOccasionnel = isOccasionnel;
  this.isNormal = isNormal;
  this.isAvance = isAvance;
  this.isExpert = isExpert;


this.origamis = new Array<Origami>();

  this.http
       .get(this.appConfigService.getUrlApi() + "origamis/search/by-filtre?filtreRecherche="+filtreRecherche+"&selectedCategorieId="+selectedCategorieId+"&isOccasionnel="+isOccasionnel+"&isNormal="+isNormal+
       "&isAvance="+isAvance+"&isExpert="+isExpert)
       .subscribe(resp => {
           for (let o of resp.json()._embedded.origamis) {
               this.origamis.push(new Origami(o));
         }
       }
       );
}

return this.origamis;
}
}

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
