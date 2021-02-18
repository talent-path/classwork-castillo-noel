const makeGuess = function () {
    var guess = document.getElementById("guess").value;
    let toFilterGuess = 1000;
    let allGuessDisplays = document.getElementsByClassName("guess-display");
   
    for (let i = 0; i < 4; i++) {
        if (Math.trunc((numberToGuess/toFilterGuess)) === Math.trunc((guess / toFilterGuess))) {
            console.log("exact match! Green");
        } else if (Math.trunc((numberToGuess/toFilterGuess)) === Math.trunc((guess / 1000))
            || Math.trunc((numberToGuess/toFilterGuess)) === Math.trunc(((guess - (Math.trunc((guess / 1000))*1000)) / 100))
            || Math.trunc((numberToGuess/toFilterGuess)) === Math.trunc(((guess - (Math.trunc((guess / 100))*100)) / 10))
            || Math.trunc((numberToGuess/toFilterGuess)) === Math.trunc(((guess - (Math.trunc((guess / 10))*10)) / 1))) {
            console.log("partial match! Yellow");
            //partial match! Yellow
        } else {
            console.log("no match! Red");
            //no match! Red
        }
        toFilterGuess /= 10;
    }
}

const populateGuessNumber = function () {
    let allGuessDisplays = document.getElementsByClassName("guess-display");
    for (let guessDisplay of allGuessDisplays) {
        guessDisplay.innerHTML = Math.trunc(Math.random() * 10);
        console.log(guessDisplay.innerHTML);
    }
}

const betterGGGen = function () {

    const digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

    let answer = digits.splice(Math.trunc(Math.random() * (digits.length - 1) + 1), 1)[0];

    for (let i = 1; i < 4; i++) {

        let randomIndex = Math.trunc(Math.random() * digits.length);

        let digit = digits.splice(randomIndex, 1)[0];
        answer *= 10;
        answer += digit;
        //digits.splice(  )
    }
    return answer;
}

let numberToGuess = betterGGGen();
console.log(numberToGuess);