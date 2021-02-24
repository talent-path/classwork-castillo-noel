"use strict";
var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
exports.__esModule = true;
var Bishop_1 = require("./Pieces/Bishop");
var BlackPawn_1 = require("./Pieces/BlackPawn");
var King_1 = require("./Pieces/King");
var Knight_1 = require("./Pieces/Knight");
var Piece_1 = require("./Pieces/Piece");
var Queen_1 = require("./Pieces/Queen");
var Rook_1 = require("./Pieces/Rook");
var WhitePawn_1 = require("./Pieces/WhitePawn");
var ChessBoard = /** @class */ (function () {
    function ChessBoard(copyFrom) {
        var _this = this;
        this.makeMove = function (toMake) {
            //TODO: enpassant stuff
            //TODO: 50 move rule stuff
            var nextBoard = new ChessBoard(_this);
            var oldPiece = nextBoard.allSquares[toMake.from.row][toMake.from.col];
            // check enpassant
            if (oldPiece != null && oldPiece.kind === Piece_1.PieceType.Pawn && Math.abs(toMake.from.row - toMake.to.row) === 2) {
                if (oldPiece.isWhite) {
                    _this.enPassantCaptureLoc = { row: toMake.from.row + 1, col: toMake.from.col };
                }
                else {
                    _this.enPassantCaptureLoc = { row: toMake.from.row - 1, col: toMake.from.col };
                }
            }
            nextBoard.allSquares[toMake.from.row][toMake.from.col] = null;
            nextBoard.allSquares[toMake.to.row][toMake.to.col] = oldPiece;
            return nextBoard;
        };
        if (copyFrom) {
            this.buildFrom(copyFrom);
        }
        this.allSquares = [];
        for (var row = 0; row < 8; row++) {
            this.allSquares[row] = [];
            for (var col = 0; col < 8; col++) {
                if (row === 6) {
                    this.allSquares[row][col] = new BlackPawn_1.BlackPawn();
                }
                if (row === 1) {
                    this.allSquares[row][col] = new WhitePawn_1.WhitePawn();
                }
                // if( row === 1 || row === 6 ){
                //     this.allSquares[row][col] =  row === 1 ? new WhitePawn() : new BlackPawn();
                // }
                if ((row === 0 || row === 7) && (col === 0 || col === 7)) {
                    this.allSquares[row][col] = new Rook_1.Rook(row === 0);
                }
                if ((row === 0 || row === 7) && (col === 1 || col === 6)) {
                    this.allSquares[row][col] = new Knight_1.Knight(row === 0);
                }
                if ((row === 0 || row === 7) && (col === 2 || col === 5)) {
                    this.allSquares[row][col] = new Bishop_1.Bishop(row === 0);
                }
                if (col === 3 && (row === 0 || row === 7)) {
                    this.allSquares[row][col] = new Queen_1.Queen(row === 0);
                }
                if (col === 4 && (row === 0 || row === 7)) {
                    this.allSquares[row][col] = new King_1.King(row === 0);
                }
                if (!this.allSquares[row][col]) {
                    this.allSquares[row][col] = null;
                }
            }
        }
    }
    //  rnbqkbnr        7
    //  pppppppp        6
    //  ........        5
    //  ........        4
    //  ........        3
    //  ........        2
    //  PPPPPPPP        1
    //  RNBQKBNR        0
    //  01234567
    ChessBoard.prototype.pieceAt = function (loc) {
        return this.allSquares[loc.row][loc.col];
    };
    ChessBoard.prototype.buildFrom = function (toCopy) {
        // [a, b, c]
        // [[a, b, c]]
        this.allSquares = [];
        for (var i = 0; i < toCopy.allSquares.length; i++) {
            this.allSquares.push(__spreadArrays(toCopy.allSquares[i]));
        }
    };
    ChessBoard.prototype.kingInCheck = function (loc, whiteKing) {
        // horizontal and vertical
        var rookDirections = [];
        rookDirections.push({ row: 0, col: 1 });
        rookDirections.push({ row: 0, col: -1 });
        rookDirections.push({ row: -1, col: 0 });
        rookDirections.push({ row: 1, col: 0 });
        for (var _i = 0, rookDirections_1 = rookDirections; _i < rookDirections_1.length; _i++) {
            var rook = rookDirections_1[_i];
            var currentLoc = { row: loc.row + rook.row, col: loc.col + rook.col };
            while (Rook_1.Rook.isOnBoard(currentLoc) && this.pieceAt(currentLoc) === null) {
                currentLoc = { row: currentLoc.row + rook.row, col: currentLoc.col + rook.col };
            }
            if (Rook_1.Rook.isOnBoard(currentLoc)) {
                if (this.pieceAt(currentLoc).isWhite != whiteKing
                    && (this.pieceAt(currentLoc).kind === Piece_1.PieceType.Queen
                        || this.pieceAt(currentLoc).kind === Piece_1.PieceType.Rook)) {
                    return true;
                }
            }
        }
        // diagonal
        var bishopDirections = [];
        var diagOffset = 0;
        bishopDirections.push({ row: 1, col: 1 });
        bishopDirections.push({ row: -1, col: -1 });
        bishopDirections.push({ row: -1, col: 1 });
        bishopDirections.push({ row: 1, col: -1 });
        for (var _a = 0, bishopDirections_1 = bishopDirections; _a < bishopDirections_1.length; _a++) {
            var bishop = bishopDirections_1[_a];
            var currentLoc = { row: loc.row + bishop.row, col: loc.col + bishop.col };
            while (Rook_1.Rook.isOnBoard(currentLoc) && this.pieceAt(currentLoc) === null) {
                currentLoc = { row: currentLoc.row + bishop.row, col: currentLoc.col + bishop.col };
                diagOffset++;
            }
            if (Rook_1.Rook.isOnBoard(currentLoc)) {
                if (this.pieceAt(currentLoc).isWhite != whiteKing
                    && (this.pieceAt(currentLoc).kind === Piece_1.PieceType.Queen
                        || this.pieceAt(currentLoc).kind === Piece_1.PieceType.Bishop
                        || (this.pieceAt(currentLoc).kind === Piece_1.PieceType.Pawn && diagOffset === 1))) {
                    return true;
                }
            }
        }
        // knights
        var knightDirections = [];
        knightDirections.push({ row: 2, col: -1 });
        knightDirections.push({ row: 2, col: 1 });
        knightDirections.push({ row: -2, col: -1 });
        knightDirections.push({ row: -2, col: 1 });
        knightDirections.push({ row: -1, col: 2 });
        knightDirections.push({ row: 1, col: 2 });
        knightDirections.push({ row: -1, col: -2 });
        knightDirections.push({ row: 1, col: -2 });
        for (var _b = 0, knightDirections_1 = knightDirections; _b < knightDirections_1.length; _b++) {
            var direction = knightDirections_1[_b];
            var newLoc = { row: loc.row + direction.row, col: loc.col + direction.col };
            if (Knight_1.Knight.isOnBoard(newLoc)
                && this.allSquares[newLoc.row][newLoc.col] != null
                && this.allSquares[newLoc.row][newLoc.col].isWhite != whiteKing) {
                return true;
            }
            // let directionMoves: Move[] = Knight.slidePiece(moveOn, loc, direction, this.isWhite);
        }
        return false;
    };
    ChessBoard.prototype.generateMoves = function () {
        var allMoves = [];
        var kingMoves = [];
        var whiteKingLoc = null;
        var blackKingLoc = null;
        for (var row = 0; row < 8; row++) {
            for (var col = 0; col < 8; col++) {
                if (this.allSquares[row][col]) {
                    var pieceMoves = this.allSquares[row][col].generateMoves(this, { row: row, col: col });
                    if (this.allSquares[row][col].kind === Piece_1.PieceType.King) {
                        if (this.allSquares[row][col].isWhite) {
                            whiteKingLoc = { row: row, col: col };
                        }
                        else {
                            blackKingLoc = { row: row, col: col };
                        }
                        kingMoves.push.apply(kingMoves, pieceMoves);
                    }
                    else {
                        allMoves.push.apply(allMoves, pieceMoves);
                    }
                }
            }
        }
        for (var _i = 0, allMoves_1 = allMoves; _i < allMoves_1.length; _i++) {
            var pieceMove = allMoves_1[_i];
            var newBoard = new ChessBoard(this);
            var pieceIsWhite = this.allSquares[pieceMove.from.row][pieceMove.from.col].isWhite;
            newBoard.makeMove(pieceMove);
            var inCheck = newBoard.kingInCheck(pieceIsWhite ? whiteKingLoc : blackKingLoc, pieceIsWhite);
            if (inCheck) {
                allMoves.splice(allMoves.indexOf(pieceMove), 1);
            }
        }
        for (var _a = 0, kingMoves_1 = kingMoves; _a < kingMoves_1.length; _a++) {
            var kingMove = kingMoves_1[_a];
            var inCheck = false;
            inCheck = King_1.King.adjacentKing(this, kingMove.to, kingMove.from.col === whiteKingLoc.col && kingMove.from.row === whiteKingLoc.row);
            for (var j = 0; j < allMoves.length && !inCheck; j++) {
                if (kingMove.to === allMoves[j].to) {
                    inCheck = true;
                }
            }
            if (inCheck) {
                kingMoves.splice(kingMoves.indexOf(kingMove), 1);
            }
        }
        allMoves.push.apply(allMoves, kingMoves);
        return allMoves;
    };
    return ChessBoard;
}());
console.log("attempting to create a board");
var testBoard = new ChessBoard();
console.log("done creating a board:");
//console.log( testBoard );
// console.log(testBoard.generateMoves());
testBoard = testBoard.makeMove({ from: { row: 1, col: 4 }, to: { row: 2, col: 4 } });
testBoard = testBoard.makeMove({ from: { row: 1, col: 2 }, to: { row: 2, col: 2 } });
// console.log(testBoard.generateMoves());
console.log(testBoard.allSquares);
