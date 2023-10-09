import { Teacher } from "./Teacher";
export class ClassRoom{
    classRoomNo:number=0;
    className:string="";
    description:string="";
    
    teacher():Teacher{
        throw new Error('Method not implemented.');
      }
}

