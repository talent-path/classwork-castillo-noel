const getAnime = function () {

    const animeSearch = $("#search").val();

    let results = document.getElementById("results");

    let children = results.childNodes;

    let allChildren = [...children];

    for (let child of allChildren) {
        child.remove();
    }

    $.get(
        `https://api.jikan.moe/v3/search/anime?q=${animeSearch}&page=1`,
        function (data, textStatus, jqXHR) {

            let animeResults = document.getElementById("results")

            for (let anime of data.results) {
                let animeBox = document.createElement("div");
                animeBox.className = "box";
                animeBox.style.width = "196.563px";
                // animeBox.style.height = "217px";
                let animeInnerBox = document.createElement("div");
                animeInnerBox.className = "inner";
                let animeTitle = document.createElement("h3");
                animeTitle.innerHTML = anime.title;
                animeTitle.style.color = "#00FFFF";
                let animeDetails = document.createElement("h1");
                animeDetails.innerHTML = "Released: " + anime.start_date.substring(0, 4);
                let animeSynopsis = document.createElement("p");
                animeSynopsis.innerHTML = anime.synopsis;
                let animeImg = document.createElement("img");
                animeImg.href = anime.url;
                animeImg.src = anime.image_url;
                animeImg.className = "image fit";
                animeImg.style.width = "157.25px";
                animeImg.style.height = "217px";
                let animeWatch = document.createElement("a");
                animeWatch.className = "button fit";
                animeWatch.innerHTML = "Full Details";
                animeWatch.innerHTML.color = "#000000";
                animeWatch.href = anime.url;
                animeWatch.target = "_blank";

                animeBox.appendChild(animeInnerBox);
                animeInnerBox.appendChild(animeTitle);
                animeInnerBox.appendChild(animeDetails);
                // animeInnerBox.appendChild(animeSynopsis);
                animeInnerBox.appendChild(animeImg);
                animeInnerBox.appendChild(document.createElement("br"));
                animeInnerBox.appendChild(animeWatch);
                animeResults.appendChild(animeBox);
            }

            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const getManga = function () {

    const mangaSearch = $("#search").val();

    let results = document.getElementById("results");

    let children = results.childNodes;

    let allChildren = [...children];

    for (let child of allChildren) {
        child.remove();
    }

    $.get(
        `https://api.jikan.moe/v3/search/manga?q=${mangaSearch}&page=1`,
        function (data, textStatus, jqXHR) {

            let mangaResults = document.getElementById("results")

            for (let manga of data.results) {
                let mangaBox = document.createElement("div");
                mangaBox.className = "box";
                mangaBox.style.width = "196.563px";
                // animeBox.style.height = "217px";
                let mangaInnerBox = document.createElement("div");
                mangaInnerBox.className = "inner";
                let mangaTitle = document.createElement("h3");
                mangaTitle.innerHTML = manga.title;
                mangaTitle.style.color = "#00FFFF";
                let mangaDetails = document.createElement("h1");
                mangaDetails.innerHTML = "Released: " + manga.start_date.substring(0, 4);
                let mangaSynopsis = document.createElement("p");
                mangaSynopsis.innerHTML = manga.synopsis;
                let mangaImg = document.createElement("img");
                mangaImg.href = manga.url;
                mangaImg.src = manga.image_url;
                mangaImg.className = "image fit";
                mangaImg.style.width = "157.25px";
                mangaImg.style.height = "217px";
                let mangaRead = document.createElement("a");
                mangaRead.className = "button fit";
                mangaRead.innerHTML = "Full Details";
                mangaRead.innerHTML.color = "#000000";
                mangaRead.href = manga.url;
                mangaRead.target = "_blank";

                mangaBox.appendChild(mangaInnerBox);
                mangaInnerBox.appendChild(mangaTitle);
                mangaInnerBox.appendChild(mangaDetails);
                // animeInnerBox.appendChild(mangaSynopsis);
                mangaInnerBox.appendChild(mangaImg);
                mangaInnerBox.appendChild(document.createElement("br"));
                mangaInnerBox.appendChild(mangaRead);
                mangaResults.appendChild(mangaBox);
            }

            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const populateGenres = function () {

    $.get(
        `https://api.jikan.moe/v3/search/anime?q=${animeSearch}&page=1`,
        function (data, textStatus, jqXHR) {
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

//sort by top rated