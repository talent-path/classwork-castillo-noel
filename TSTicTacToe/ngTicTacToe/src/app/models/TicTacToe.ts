import { Position } from "./Position";

export class TicTacToe {

    isXTurn: boolean;
    board: number[][];
    status: number;

    constructor() {
        this.board = [];
        for (let i = 0; i < 3; i++) {
            this.board[i] = [];
            for (let j = 0; j < 3; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    makeMove(pos: Position): void {

        if (this.isXTurn) {
            this.board[pos.row][pos.col] = 1;
        }
        else {
            this.board[pos.row][pos.col] = -1;
        }

        this.status = this.checkWin();

        //Update to not use alerts
        if (this.status == 1) {
            alert(`${this.isXTurn ? "X Won!" : "O Won!"}`);

        } else if (this.status === 0) {
            alert("Draw!");
        }

        this.isXTurn = !this.isXTurn;

    }

    checkWin(): number {

        let status = -1;
        let product = 1;

        //Draw Check
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                product *= this.board[i][j];
            }
        }
        if (product !== 0) {
            status = 0;
        }

        //Win Check
        //Rows
        for (let i = 0; i < 3; i++) {
            let rowSum = this.board[i * 3][0] + this.board[i * 3][1] + this.board[i * 3][2];
            if (rowSum * rowSum == 9) status = 1;
        }


        //Columns
        for (let i = 0; i < 3; i++) {
            let rowSum = this.board[0][i * 3] + this.board[1][i * 3] + this.board[2][i * 3];
            if (rowSum * rowSum == 9) status = 1;
        }

        //Diagonal
        let d1Sum = this.board[0][0] + this.board[1][2] + this.board[2][2];
        let d2Sum = this.board[0][2] + this.board[1][2] + this.board[0][2];

        if (d1Sum * d1Sum == 9 || d2Sum * d2Sum == 9) {
            status = 1;
        }
        return status;
    }
}