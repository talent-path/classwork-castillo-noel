import { Component, Input, OnInit } from '@angular/core';
import { Bishop } from 'src/app/models/Bishop';
import { Piece, PieceType } from 'src/app/models/Piece';

@Component({
  selector: 'app-chess-square',
  templateUrl: './chess-square.component.html',
  styleUrls: ['./chess-square.component.css']
})
export class ChessSquareComponent implements OnInit {

  @Input() squarePiece: Piece = new Bishop(true);
  @Input() row: number = 0;
  @Input() col: number = 7;
  isLightSquare: boolean = true;
  imageSrc: string = "../../assets/images/";

  constructor() {

  }

  ngOnInit(): void {
    if (this.squarePiece == null) {
      this.imageSrc = " ";
    } else {

      this.imageSrc += this.squarePiece.isWhite ? "w" : "b";
      switch (this.squarePiece.kind) {
        case PieceType.King:
          this.imageSrc += "K";
          break;
        case PieceType.Queen:
          this.imageSrc += "Q";
          break;
        case PieceType.Bishop:
          this.imageSrc += "B";
          break;
        case PieceType.Rook:
          this.imageSrc += "R";
          break;
        case PieceType.Knight:
          this.imageSrc += "N";
          break;
        case PieceType.Pawn:
          this.imageSrc += "P";
          break;
        default:
      }
      this.imageSrc += ".png";
    }

    this.isLightSquare = ((this.row + this.col) % 2 === 0);
  }

}
