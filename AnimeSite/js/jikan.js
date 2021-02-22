const getAnime = function () {

    const animeSearch = $("#search").val();

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/anime?q=${animeSearch}&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);

            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const mostPopularAnime = function () {

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/anime?q=&order_by=members&sort=desc&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);

            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const topRatedAnime = function () {

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/anime?q=&order_by=score&sort=desc&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);

            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const newestAnime = function () {

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/anime?q=&order_by=start_date&sort=desc&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);

            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}


const getManga = function () {

    const mangaSearch = $("#search").val();

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/manga?q=${mangaSearch}&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);

            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const mostPopularManga = function () {

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/manga?q=&order_by=members&sort=desc&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const topRatedManga = function () {

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/manga?q=&order_by=score&sort=desc&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const newestManga = function () {

    clearResults();

    $.get(
        `https://api.jikan.moe/v3/search/manga?q=&order_by=start_date&sort=desc&page=1`,
        function (data, textStatus, jqXHR) {

            populateResults(data);
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}

const populateResults = function (allData) {
    let results = document.getElementById("results")

    for (let data of allData.results) {
        let dataBox = document.createElement("div");
        dataBox.className = "box";
        dataBox.style.width = "196.563px";
        let dataInnerBox = document.createElement("div");
        dataInnerBox.className = "inner";
        let dataTitle = document.createElement("h3");
        dataTitle.innerHTML = data.title;
        dataTitle.style.color = "#00FFFF";
        let dataReleaseYear = document.createElement("h1");
        dataReleaseYear.innerHTML = "Released: " + data.start_date.substring(0, 4);
        let dataSynopsis = document.createElement("p");
        dataSynopsis.innerHTML = data.synopsis;
        let dataImg = document.createElement("img");
        dataImg.href = data.url;
        dataImg.src = data.image_url;
        dataImg.className = "image fit";
        dataImg.style.width = "157.25px";
        dataImg.style.height = "217px";
        let dataDetails = document.createElement("a");
        dataDetails.className = "button fit";
        dataDetails.innerHTML = "Full Details";
        dataDetails.innerHTML.color = "#000000";
        dataDetails.href = data.url;
        dataDetails.target = "_blank";

        dataBox.appendChild(dataInnerBox);
        dataInnerBox.appendChild(dataTitle);
        dataInnerBox.appendChild(dataReleaseYear);
        dataInnerBox.appendChild(dataImg);
        dataInnerBox.appendChild(document.createElement("br"));
        dataInnerBox.appendChild(dataDetails);
        results.appendChild(dataBox);
    }

}

const clearResults = function () {

    let results = document.getElementById("results");

    let children = results.childNodes;

    let allChildren = [...children];

    for (let child of allChildren) {
        child.remove();
    }
}

