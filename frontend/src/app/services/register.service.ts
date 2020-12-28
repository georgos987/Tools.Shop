import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Customer } from 'src/app/modules/customer';
import { Ip } from '../modules/ip';



@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  public loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  private ip = Ip.IP;
  private baseUrl = `${this.ip}:8080/customers`;
  private addressesUrl = `${this.ip}:8080/addresses`;

  constructor(private httpCients: HttpClient) { }

  saveCustomer(customer: Customer): Observable<any> {
    return this.httpCients.post(this.baseUrl, customer);
  }

  login(){
    this.loggedIn.next(true);
  }
  logout(){
    this.loggedIn.next(false);
  }

}

