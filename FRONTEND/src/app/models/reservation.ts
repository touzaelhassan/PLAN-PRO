import { User } from "./user";
import { Event } from "./event";

export class Reservation {

  public id: number | undefined;
  public attendee: User;
  public event: Event;
  public approved?:boolean;

  constructor() {
    this.approved = false;
    this.attendee = new User();
    this.event = new Event();
  }

}