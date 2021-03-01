import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Position } from 'src/app/models/Position';

@Component({
  selector: 'app-square',
  templateUrl: './square.component.html',
  styleUrls: ['./square.component.css']
})
export class SquareComponent implements OnInit {

  @Input() value: number = 0;
  @Input() isXTurn: boolean;
  imageSrc: string = " ";

  @Output() squareClickedEvent: EventEmitter<Position> = new EventEmitter<Position>();
  @Input() row: number;
  @Input() col: number;


  constructor() { }

  ngOnInit(): void {
    if (this.value === 1) {
      this.imageSrc = "../../assets/images/x.png";
    } else if (this.value === -1) {
      this.imageSrc = "../../assets/images/o.jpg";
    }
  }

  squareClicked(): void {
    this.squareClickedEvent.emit(
      {
        row: this.row,
        col: this.col
      }
    );
  }



}
