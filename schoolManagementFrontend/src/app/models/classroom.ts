import {Course} from "./course";
import {Room} from "./room";

export interface Classroom extends Room {

  ability: number;
  available: boolean;
  courses: Array<Course>;

}
