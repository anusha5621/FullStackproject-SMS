import { School } from "./School";

export class Student{
    studentRollNo : number=0;
    studentName : string = "";
    studentMobile : number=0;
    location : string = "";
    qualification : string = "";
    schoolName : string = "";
    studentMarks : number=0;
    isSecondaryStudent : boolean=false;
    selectedSchoolsIds:number;
   
    school():School{
        throw new Error('Method not implemented.');
      }
}