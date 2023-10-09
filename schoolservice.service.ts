import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { School } from './School';

@Injectable({
  providedIn: 'root'
})
export class SchoolserviceService {
 
  private baseURL = "http://localhost:8080/studentmanagement.com";
  constructor(private httpClient: HttpClient) { }

  getSchoolById(id : number) : Observable<School> {
    return this.httpClient.get<School>(`${this.baseURL}/readSchool/${id}`);

  }
  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteAllSchools`);
  }
  getSchoolList(): Observable<School[]>{
    return this.httpClient.get<School[]>(`${this.baseURL}/readAllSchools`);
  }
  deleteSchool(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteSchoolById/${id}`);

  }
  createSchool(obj : School): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveSchool`, obj);
  }
  updateSchool(id : number, schoolObj : School) : Observable<School> {
    return this.httpClient.put<School>(`${this.baseURL}/updateSchoolDetails/${id}`, schoolObj);
}

}
