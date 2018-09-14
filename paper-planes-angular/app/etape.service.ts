import { Injectable } from '@angular/core';
import { Etape } from './etape';
import { Origami } from './origami';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable()
export class EtapeService{
  private etapes: Array<Etape> = new Array<Etape>();
  private origami: Origami;
  // private requestOptions: RequestOptions;

constructor(private http: Http, private appConfigService: AppConfigService) {
// let myHeaders: Headers = new Headers();
// myHeaders.append('Authorization', this.appConfigService.getApiBasic());
// this.requestOptions = new RequestOptions({ headers: myHeaders });
   this.http
        .get(this.appConfigService.getUrlApi() + "etapes/search/by-origami-id?id= " + this.origami.getHref() )
        .subscribe(resp => {
            for (let e of resp.json()._embedded.etapes) {
                this.etapes.push(new Etape(e));
            }
        });
}

public findAll(): Array<Etape> {
    return this.etapes;
}
}
