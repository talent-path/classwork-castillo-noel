let boardElements = [];

let populatePage = function() {
    //document.getElementById()
    //document.getElementByClassName()
    //document.getElementByTagName()

    let allBodyTags = document.getElementsByTagName("body");

    console.log( allBodyTags[0]);

    let bodyTag = allBodyTags[0];

    let gameDivTag = document.createElement("div");

    bodyTag.appendChild(gameDivTag);

    gameDivTag.style.height = "600px";
    gameDivTag.style.width = "700px";
    gameDivTag.style.border= "7px solid #141BB4";
    gameDivTag.style.lineHeight = "0";

    let darkSquare = true;
    for(let col = 0; col < 7; col++){
        boardElements.push( [] );
        for(let row = 0; row < 6; row++){
            boardElements[col].push(document.createElement("div"));
       
            boardElements[col][row].style.height = "80px";
            boardElements[col][row].style.width = "80px";    
            boardElements[col][row].style.display = "inline-block";

            boardElements[col][row].style.border = "10px solid #000000";
            boardElements[col][row].style.borderRadius = "40px";
            boardElements[col][row].style.backgroundColor = darkSquare ? "#AFAFAF" : "#FFFFFF";   
            darkSquare = !darkSquare;
         }
         darkSquare = !darkSquare;
    }

    for(let row = 0; row < 6; row++){
        for(let col = 0; col < 7; col++){
            gameDivTag.appendChild(boardElements[col][row]);
        }
        gameDivTag.appendChild(document.createElement("br"));
    }

    bodyTag.appendChild( gameDivTag );

    for( let col = 0; col < 7; col++){
        let columnButton = document.createElement("button");
       columnButton.style.height = "100px";
       columnButton.style.width = "100px";
        
       if( col === 0){
        columnButton.style.marginLeft = "7px";
       }
       bodyTag.appendChild(columnButton);
    }

}

let reset = function(){
    let allBodyTags = document.getElementsByTagName("body");
    let bodyTag = allBodyTags[0];  
    let children = bodyTag.childNodes;

    for( let child of children){
        bodyTag.removeChild( child );
    }

    boardElements = [];

    populatePage();
}

let makeMove = function(col){

    for(let row = 0; row < 6; row++){
        if(
            row === 5 ||
            board[col][row]
        )
    }
}

populatePage();