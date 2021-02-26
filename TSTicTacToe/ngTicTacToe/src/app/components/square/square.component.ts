import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-square',
  templateUrl: './square.component.html',
  styleUrls: ['./square.component.css']
})
export class SquareComponent implements OnInit {

  xImg: string = "../../assets/images/x.png";
  oImg: string = "../../assets/images/o.jpg";
  imageSrc: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  squareClicked(): void {

  }

}
