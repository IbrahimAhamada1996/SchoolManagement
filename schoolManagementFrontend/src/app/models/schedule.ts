import { Employee } from "./employee";
import {Student} from "./student";

export interface Schedule {
  id:number;
  startDate: string;
  endDate: string;
  employees: Array<Employee>;
  students: Array<Student>;
}
