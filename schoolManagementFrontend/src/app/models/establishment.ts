import {Room} from "./room";

export interface Establishment {
  id:number;
  name: string;
  ability: number;
  rooms: Array<Room>;
}
