import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
}
  /*constructor() { }
  authenticate(username : any, password : any){
    if(username=="keerthika" && password=="kiki123"){
      sessionStorage.setItem('username',username)
      return true;
    }else{
      return false;
    }
   }
}
isUserLoggedIn(){
  let user =sessionStorage.getItem('username')
  console.log(!(user === null))
  return !(user === null)
}
logOut() {
  sessionStorage.removeItem('username')
}
function isUserLoggedIn() {
  throw new Error('Function not implemented.');
}

function logOut() {
  throw new Error('Function not implemented.');
}
*/
