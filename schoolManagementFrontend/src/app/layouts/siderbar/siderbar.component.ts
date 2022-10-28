import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-siderbar',
  templateUrl: './siderbar.component.html',
  styleUrls: ['./siderbar.component.css']
})
export class SiderbarComponent implements OnInit {
  public currentURL ='';
  constructor() {
    

  }

  ngOnInit(): void {
    this.currentURL = window.location.pathname;
  }

}
