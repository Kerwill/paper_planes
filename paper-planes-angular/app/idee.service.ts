import { Injectable } from '@angular/core';
import { Idee } from './idee';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable()
export class IdeeService {
  private idee: Idee;

  constructor(private http: Http, private appConfigService: AppConfigService) {}

  public save(idee: Idee) {

    // idee.setNom(this.appConfigService.getUrlApi() + "idees/this.nom");
    // idee.setPrenom(this.appConfigService.getUrlApi() + "idees/this.prenom");
    // idee.setEmail(this.appConfigService.getUrlApi() + "idees/this.mail");
    // idee.setDescription(this.appConfigService.getUrlApi() + "idees/this.description");
      // idee.setIsArchive(this.appConfigService.getUrlApi() + "isArchive/false");
    this.http
      .post(this.appConfigService.getUrlApi() + "idees", idee)
      .subscribe(resp => alert("Message envoyé !"));
  }
  }
