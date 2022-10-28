import {Student} from "./student";
import {User} from "./user";

export interface Parent extends User {
  job: string;
  students: Array<Student>
}
