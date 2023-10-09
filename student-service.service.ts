import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Student } from './Student';


@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
  
  private baseURL = "http://localhost:8080/studentmanagement.com";

  constructor(private httpClient: HttpClient) { }
  
 
  getStudentById(id : number) : Observable<Student> {
    return this.httpClient.get<Student>(`${this.baseURL}/fetchStudentByStudentId/${id}`);

  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteAllStudents`);
  }

  getStudentList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}/fetchAllStudents`);
  }

  deleteStudent(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteStudentById/${id}`);

  }

  findBySecondary(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(`${this.baseURL}/isSecondary`);
  }

  findByNotSecondary(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(`${this.baseURL}/isNotSecondary`);
}
findByGrade(grade:string):Observable<Student[]>{
  return this.httpClient.get<Student[]>(`${this.baseURL}/readAllStudentsByGrade?qualification=${grade}`);
}
findByLocation(location:string):Observable<Student[]>{
  return this.httpClient.get<Student[]>(`${this.baseURL}/readAllStudentsBylocation?location=${location}`);
}

  createStudent(obj : Student,schoolCode:number): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveStudent/${schoolCode}`, obj);
  }
  updateStudent(id : number, studentObj : Student) : Observable<Student> {
    return this.httpClient.put<Student>(`${this.baseURL}/updateStudentDetails/${id}`, studentObj);
}
sortByMarks(direction:string,field:string):Observable<Student[]>{
  console.log(direction)
  return this.httpClient.get<Student[]>(`${this.baseURL}/sortByMarks/${direction}?fieldName=${field}`);

}
sortByStudentName(direction:string,field:string):Observable<Student[]>{
  console.log(direction)
  return this.httpClient.get<Student[]>(`${this.baseURL}/sortByStudentName/${direction}?fieldName=${field}`);

}

signin(email:any, password:any):Observable<any>
{

  const params=new HttpParams().set('email',email).set('password',password);
  console.log(params);
  return this.httpClient.get(`${this.baseURL}/login`,{params});

}
feedback(name:string,email:string,message:string){
  
}
}





 