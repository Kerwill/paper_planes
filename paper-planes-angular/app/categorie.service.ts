import { Injectable } from '@angular/core';
import { Categorie } from './categorie';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable()
export class CategorieService {
  private categories: Array<Categorie> = new Array<Categorie>();

  constructor(private http: Http, private appConfigService : AppConfigService) {
      this.http
           .get(this.appConfigService.getUrlApi() + "categories")
           .subscribe(resp => {

               for (let c of resp.json()._embedded.categories) {
                   this.categories.push(new Categorie(c));
             }
           }
           );
  }

  public findAll() : Array<Categorie>{
    return this.categories;
  }
}
