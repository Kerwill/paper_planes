import { Injectable } from '@angular/core';

@Injectable()
export class AppConfigService {

  private urlApi : string = "http://localhost:8080/api/";

  public getUrlApi(){
    return this.urlApi;
  }

}
