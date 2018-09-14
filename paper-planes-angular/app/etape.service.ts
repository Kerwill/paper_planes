import { Injectable } from '@angular/core';
import { Etape } from './etape';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable()
export class EtapeService{
  private etapes: Array<Etape> = null;
  // private requestOptions: RequestOptions;

constructor(private http: Http, private appConfigService: AppConfigService) {

//   this.http
//        .get(this.appConfigService.getUrlApi() + "etapes")
//        .subscribe(resp => {
//            for (let e of resp.json()._embedded.etapes) {
//                this.etapes.push(new Etape(e))
//
//            }
// // let myHeaders: Headers = new Headers();
// // myHeaders.append('Authorization', this.appConfigService.getApiBasic());
// // this.requestOptions = new RequestOptions({ headers: myHeaders });
//
// });
}

ngOnInit() {
  // this.http
  //      .get(this.appConfigService.getUrlApi() + "etapes/search/by-origami-id?id="+id)
  //      .subscribe(resp => {
  //          for (let e of resp.json()._embedded.etapes) {
  //              this.etapes.push(new Etape(e))
  //
  //          }
  //   });
  }

public findAllById(id): Array <Etape> {
  if (this.etapes == null) {
    this.etapes = new Array<Etape>();
    this.http
         .get(this.appConfigService.getUrlApi() + "etapes/search/by-origami-id?id="+id)
         .subscribe(resp => {

           for (let e of resp.json()._embedded.etapes) {
              this.etapes.push(new Etape(e));
          }

  console.log(this.etapes);

             // for (let e of resp.json()._embedded.etapes) {
             //     this.etapes.push(new Etape(e))
             //
             // }
      });
    }
  return this.etapes;

}
}
