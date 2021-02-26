import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {

  isXTurn: boolean;
  board: Array<any>;

  constructor() { }

  ngOnInit(): void {
    this.isXTurn = true;
    this.board = [0, 0, 0, 0, 0, 0, 0, 0, 0];
  }

  markIcon(buttonId: number): void {
    console.log(buttonId);

    const xImg = document.createElement("img");
    xImg.setAttribute("src", "../../assets/images/x.png");
    xImg.classList.add("button-image");

    const oImg = document.createElement("img");
    oImg.setAttribute("src", "../../assets/images/o.jpg");
    oImg.classList.add("button-image");

    let toDisable = document.getElementById('Button' + buttonId);
    (document.getElementById('Button' + buttonId) as HTMLInputElement).disabled = false;
    if (this.isXTurn) {
      toDisable.appendChild(xImg);
      this.board[buttonId - 1] = 1;

    } else {
      toDisable.appendChild(oImg);
      this.board[buttonId - 1] = -1;
    }

    let n = this.checkWin();

    //Update to not use alerts
    if (n === 1) {
      alert(`${this.isXTurn ? "X Won!" : "O Won!"}`);

    } else if (n === 0) {
      alert("Draw!");
    }
    this.isXTurn = !this.isXTurn;
  }

  checkWin(): number {

    let status = -1;
    let product = 1;

    //Draw Check
    for (let i = 0; i < 9; i++) {
      product *= this.board[i];
    }
    if (product !== 0) {
      status = 0;
    }

    //Win Check
    //Rows
    for (let row = 0; row < 3; row++) {
      let rowSum = this.board[row * 3 + 0] + this.board[row * 3 + 1] + this.board[row * 3 + 2];
      if (rowSum * rowSum == 9) status = 1;
    }

    //Columns
    for (let col = 0; col < 3; col++) {
      let colSum = this.board[3 * 0 + col] + this.board[3 * 1 + col] + this.board[3 * 2 + col];
      if (colSum * colSum == 9) status = 1;
    }

    //Diagonal
    let d1Sum = this.board[0] + this.board[4] + this.board[8];
    let d2Sum = this.board[6] + this.board[4] + this.board[2];

    if (d1Sum * d1Sum == 9 || d2Sum * d2Sum == 9) {
      status = 1;
    }
    return status;
  }

}
