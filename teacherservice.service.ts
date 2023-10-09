import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Teacher} from './Teacher';
@Injectable({
  providedIn: 'root'
})
export class TeacherserviceService {
  private baseURL = "http://localhost:8080/studentmanagement.com";
  constructor(private httpClient: HttpClient) { }


  getTeacherById(id : number) : Observable<Teacher> {
    return this.httpClient.get<Teacher>(`${this.baseURL}/readTeacher/${id}`);

  }
  
  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteAllTeachers`);
  }
  getTeacherList(): Observable<Teacher[]>{
    return this.httpClient.get<Teacher[]>(`${this.baseURL}/fetchAllTeachers`);
  }
  deleteTeacher(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteTeacher/${id}`);

  }
  createTeacher(obj : Teacher): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveTeacher`, obj);
  }
  updateTeacher(id : number, teacherObj : Teacher) : Observable<Teacher> {
    return this.httpClient.put<Teacher>(`${this.baseURL}/updateTeacherDetails/${id}`, teacherObj);
}
}







  
 
 
 


