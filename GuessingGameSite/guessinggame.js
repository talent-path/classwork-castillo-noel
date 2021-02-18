let toGuess = 4769;

let makeGuess = function(){
    var guess = document.getElementById(guess).value;
}

let populateGuessNumber = function(){
    let allGuessDisplays = document.getElementsByClassName("guessDisplay");
    for(let guessDisplay of allGuessDisplays){
        guessDisplay.value = Math.random * 10;
        console.log(guessDisplay).value;
    }
}

populateGuessNumber();