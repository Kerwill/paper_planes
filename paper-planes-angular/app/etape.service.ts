import { Injectable } from '@angular/core';
import { Etape } from './etape';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable()
export class EtapeService{

  private etapes: Array<Etape> = null;
  private id: number = 0;

constructor(private http: Http, private appConfigService: AppConfigService) {

}



public findAllById(id): Array <Etape> {
  if ((this.etapes === null) || (this.id != id)) {
    this.id = id;
    this.etapes = new Array<Etape>();
    this.http
         .get(this.appConfigService.getUrlApi() + "etapes/search/by-origami-id?id="+id)
         .subscribe(resp => {

           for (let e of resp.json()._embedded.etapes) {
              this.etapes.push(new Etape(e));
          }



             // for (let e of resp.json()._embedded.etapes) {
             //     this.etapes.push(new Etape(e))
             //
             // }
      });
    }
  return this.etapes;

}
}
