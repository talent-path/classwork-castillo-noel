import { Component, OnInit } from '@angular/core';
import { Board, ChessBoard} from 'src/app/models/Board';

@Component({
  selector: 'app-chess-board',
  templateUrl: './chess-board.component.html',
  styleUrls: ['./chess-board.component.css']
})
export class ChessBoardComponent implements OnInit {

  board: Board = new ChessBoard();
  constructor() { }

  ngOnInit(): void {
  }

}
