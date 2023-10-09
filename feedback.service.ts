import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from './Feedback';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private baseURL = "http://localhost:8080/feedback";
constructor(private httpClient:HttpClient) { }

  addFeedback(Obj:Feedback,id:number,userid:number):any{
    return this.httpClient.post(`${this.baseURL}/add/${id}/${userid}`,Obj);

  }
  viewfeedback(id:number):Observable<Feedback>{
    return this.httpClient.get<Feedback>(`${this.baseURL}/getFeedbackById/${id}`);
  }
  viewAllFeedbacks():Observable<Feedback[]>{
    return this.httpClient.get<Feedback[]>(`${this.baseURL}/getAllFeedbacks`);
  }
  deleteFeedback(id:number):Observable<Object>{
    return this.httpClient.delete<Object>(`${this.baseURL}/deletefeedback/${id}`);
  }
  deleteAllFeedbacks():Observable<any>{
    return this.httpClient.delete(`${this.baseURL}/deleteAllFeedbacks`);
  }
  }
