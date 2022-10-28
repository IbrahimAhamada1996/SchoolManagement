import {Room} from "./room";

export interface OfficeRoom extends Room {
  owner: string;
}
