import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Assurance {
  private backendHost = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  public getClients(): Observable<any> {
    return this.http.get(this.backendHost + "/clients");
  }

}
