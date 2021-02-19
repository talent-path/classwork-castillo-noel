const getAnime = function () {

    const animeSearch = $("#anime").val();

    $.get(
        `https://api.jikan.moe/v3/search/anime?q=${animeSearch}&page=1`,
        function (data, textStatus, jqXHR) {

            let animeResults = document.getElementById("animeResults")
            let animeList = document.createElement("ul");
            animeList.className = "items";
            for (let anime of data.results) {
                let animeListItem = document.createElement("li");

                let animeImgDiv = document.createElement("div");

                let animeSrc = document.createElement("a");
                animeSrc.href = anime.url;
                animeSrc.title = anime.title;

                let animeImg = document.createElement("img");
                animeImg.src = anime.image_url;

                animeListItem.appendChild(animeImgDiv);
                animeImgDiv.appendChild(animeSrc);
                animeSrc.appendChild(animeImg);
                animeList.appendChild(animeListItem);
            }

            animeResults.appendChild(animeList);

            $("#animeTitle").text(`${data.results[0].title}`);
            $("#animeSynopsis").text("Synopsis: " + data.results[0].synopsis);

            let imageUrl = data.results[0].image_url;

            $("#animeImg").attr("src", imageUrl);

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