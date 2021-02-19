const makeGuess = function () {
    var guess = document.getElementById("guess").value;
    let allGuessDisplays = document.getElementsByClassName("guess-display");
    let firstNumberToGuess = Math.trunc(numberToGuess / 1000);
    let secondNumberToGuess = Math.trunc((numberToGuess - (1000 * firstNumberToGuess)) / 100);
    let thirdNumberToGuess = Math.trunc((numberToGuess - (1000 * firstNumberToGuess) - (100 * secondNumberToGuess)) / 10);
    let fourthNumberToGuess = Math.trunc(numberToGuess - (1000 * firstNumberToGuess) - (100 * secondNumberToGuess) - (10 * thirdNumberToGuess));

    let answers = [];
    answers.push(firstNumberToGuess);
    answers.push(secondNumberToGuess);
    answers.push(thirdNumberToGuess);
    answers.push(fourthNumberToGuess);
    console.log(answers);

    let firstGuessSubmitted = Math.trunc(guess / 1000);
    let secondGuessSubmitted = Math.trunc((guess - (1000 * firstGuessSubmitted)) / 100);
    let thirdGuessSubmitted = Math.trunc((guess - (1000 * firstGuessSubmitted) - (100 * secondGuessSubmitted)) / 10);
    let fourthGuessSubmitted = Math.trunc(guess - (1000 * firstGuessSubmitted) - (100 * secondGuessSubmitted) - (10 * thirdGuessSubmitted));

    let guesses = [];
    guesses.push(firstGuessSubmitted);
    guesses.push(secondGuessSubmitted);
    guesses.push(thirdGuessSubmitted);
    guesses.push(fourthGuessSubmitted);
    console.log(guesses);

    let greenCount = 0;
    for (let i = 0; i < 4; i++) {
        allGuessDisplays[i].innerHTML = guesses[i];
        if (answers[i] === guesses[i]) {
            allGuessDisplays[i].style.backgroundColor = "green";
            greenCount++;
        } else if (guesses[i] === answers[0] || guesses[i] === answers[1] || guesses[i] === answers[2] || guesses[i] === answers[3]) {
            allGuessDisplays[i].style.backgroundColor = "yellow";
        } else {
            allGuessDisplays[i].style.backgroundColor = "red";
        }
    }

    if (greenCount === 4) {
        document.getElementById("message").innerHTML = "You won!";
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
    console.log(answer);
    return answer;
}

const reset = function () {
    numberToGuess = betterGGGen();
    let allGuessDisplays = document.getElementsByClassName("guess-display");
    for (let i = 0; i < 4; i++) {
        allGuessDisplays[i].innerHTML = "";
        allGuessDisplays[i].style.backgroundColor = "white";
    }

}

let numberToGuess = betterGGGen();
