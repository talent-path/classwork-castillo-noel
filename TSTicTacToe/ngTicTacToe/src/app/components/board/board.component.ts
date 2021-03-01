import { Component, OnInit } from '@angular/core';
import { Position } from 'src/app/models/Position';
import { TicTacToe } from 'src/app/models/TicTacToe';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {

  isXTurn: boolean = true;
  game: TicTacToe = new TicTacToe();

  constructor() {

  }

  ngOnInit(): void {

  }

  onSquareClicked(pos: Position): void {
    this.game.makeMove(pos);
  }



}
