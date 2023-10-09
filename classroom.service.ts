import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClassRoom } from './ClassRoom';

@Injectable({
  providedIn: 'root'
})
export class ClassroomService {
 private baseURL = "http://localhost:8080/studentmanagement.com";
  constructor(private httpClient: HttpClient) { }


  getClassRoomById(id : number) : Observable<ClassRoom> {
    return this.httpClient.get<ClassRoom>(`${this.baseURL}/readClassRoom/${id}`);

  }
  
  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteAllClassRooms`);
  }
  getClassRoomList(): Observable<ClassRoom[]>{
    return this.httpClient.get<ClassRoom[]>(`${this.baseURL}/fetchAllClassRooms`);
  }
  deleteClassRoom(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteClassRoom/${id}`);

  }
  createClassRoom(obj : ClassRoom,teacherId:number): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveClassRoom/${teacherId}`, obj);
  }
  updateClassRoom(id : number, classRoomObj : ClassRoom) : Observable<ClassRoom> {
    return this.httpClient.put<ClassRoom>(`${this.baseURL}/updateClassRoomDetails/${id}`, classRoomObj);
}
}