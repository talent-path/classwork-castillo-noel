import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChessSquareComponent } from './components/chess-square/chess-square.component';
import { ChessBoardComponent } from './components/chess-board/chess-board.component';

@NgModule({
  declarations: [
    AppComponent,
    ChessSquareComponent,
    ChessBoardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
