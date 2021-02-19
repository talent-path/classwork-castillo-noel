
let isXTurn = true;
let board = [0, 0, 0, 0, 0, 0, 0, 0, 0];

function handleClick(buttonId) {
    console.log(buttonId);

    const xImg = document.createElement("img");
    xImg.setAttribute("src", "https://cdn.pixabay.com/photo/2012/04/12/20/12/x-30465_1280.png");
    xImg.classList.add("button-image");

    const oImg = document.createElement("img");
    oImg.setAttribute("src", "https://assets.ltkcontent.com/images/20093/3747.LetterO_0066f46bde.jpg");
    oImg.classList.add("button-image");

    let toDisable = document.getElementById('Button' + buttonId);
    toDisable.disabled = true;
    if (isXTurn) {
        toDisable.appendChild(xImg);
        board[buttonId - 1] = 1;

    } else {
        toDisable.appendChild(oImg);
        board[buttonId - 1] = -1;
    }
    console.log(board);
    console.log(checkWin());
    let n = checkWin();

    //Update to not use alerts
    if (n === 1) {
        alert(`${isXTurn ? "X Won!" : "O Won!"}`);

    } else if (n === 0) {
        alert("Draw!");
    }
    isXTurn = !isXTurn;
}

function checkWin() {

    let status = -1;
    let product = 1;

    //Draw Check
    for (let i = 0; i < 9; i++) {
        product *= board[i];
    }
    if (product !== 0) {
        status = 0;
    }

    //Win Check
    //Rows
    for (let row = 0; row < 3; row++) {
        let rowSum = board[row * 3 + 0] + board[row * 3 + 1] + board[row * 3 + 2];
        if (rowSum * rowSum == 9) status = 1;
    }

    //Columns
    for (let col = 0; col < 3; col++) {
        let colSum = board[3 * 0 + col] + board[3 * 1 + col] + board[3 * 2 + col];
        if (colSum * colSum == 9) status = 1;
    }

    //Diagonal
    let d1Sum = board[0] + board[4] + board[8];
    let d2Sum = board[6] + board[4] + board[2];

    if (d1Sum * d1Sum == 9 || d2Sum * d2Sum == 9) {
        status = 1;
    }
    return status;
}