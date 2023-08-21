import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../models';

@Injectable({
  providedIn: 'root'
})
export class SubmissionService {

  constructor(private http: HttpClient) { }

  apiUrl: string = 'http://localhost:8080/api/create'

  postOrder(orders:Orders) : Observable<Orders> {
    const headers = new HttpHeaders()
    .set('Content-Type', 'text/html')

    return this.http.post<Orders>(this.apiUrl, orders, {headers : headers})
  }

}
