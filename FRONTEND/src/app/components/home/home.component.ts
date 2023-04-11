import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { NotificationType } from 'src/app/enums/notification-type.enum';
import { Category } from 'src/app/models/category';
import { Event } from 'src/app/models/event';
import { Hotel } from 'src/app/models/hotel';
import { Room } from 'src/app/models/room';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CategoryService } from 'src/app/services/category.service';
import { EventService } from 'src/app/services/event.service';
import { HotelService } from 'src/app/services/hotel.service';
import { NotificationService } from 'src/app/services/notification.service';
import { RoomService } from 'src/app/services/room.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit{

    public categories: Category[] = [];
    public events: Event[] = [];
    public hotels: Hotel[] = [];
    public rooms: Room[] = [];
    private subscriptions: Subscription[] = [];
    public loggedInUser: any;
    public isUserLoggedIn = false;
    public selectedEvent = new Event();

    constructor(
      private authenticationService: AuthenticationService, 
      private categoryService: CategoryService,
      private eventService: EventService,      
      private roomService: RoomService, 
      private hotelService: HotelService,
      private router: Router,
      private notificationService: NotificationService
      ) {}

    ngOnInit(): void { 
      this.loggedInUser = this.authenticationService.getUserFromLocalStorage();
      if(this.loggedInUser != null){ this.isUserLoggedIn = true}
      this.getCategories();
      this.getEvents();
    }

    public getCategories(): void{
      this.subscriptions.push(
        this.categoryService.getCategories().subscribe(
          (response: Category[]) => {
            this.categories = response;
          },
          (httpErrorResponse: HttpErrorResponse) => {
            console.log(httpErrorResponse.error.message)
          }
        )
      )
    }

    public getEvents(): void{
      this.subscriptions.push(
        this.eventService.getEvents().subscribe(
          (response: Event []) => {
            this.events = response;
          },
          (httpErrorResponse: HttpErrorResponse) => {
            console.log(httpErrorResponse.error.message)
          }
        )
      )
    }

    public onBooking(roomId:any){
      document.getElementById("hide-room-details-btn")?.click();
      this.router.navigateByUrl(`/reservation/${roomId}`);
    }

    public onSelectEvent(selectedEvent: Event){
      this.selectedEvent  = selectedEvent;
      document.getElementById("openRoomInfo")?.click();
    }

    public onLogout(){
      this.authenticationService.logout();
      this.isUserLoggedIn = false;
      this.router.navigateByUrl('/login');
      this.notificationService.notify(NotificationType.SUCCESS, "You've been successfully logged out !!.")
    }

}
