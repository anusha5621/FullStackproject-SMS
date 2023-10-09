import { School } from "./School";
import{User} from "./User"
export class Feedback{
    school():School{
        throw new Error("method not implemented");
    }
    user():User{
        throw new Error("method not implemented");
    }
    feedBackId:number=0;
    comments:string="";
    schoolRating:number=0;
    overallRating:number=0;

    
}