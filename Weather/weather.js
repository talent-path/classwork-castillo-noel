const getWeather = function () {

    const zipcode = $("#zip").val();

    $.get(
        `http://api.openweathermap.org/data/2.5/weather?zip=${zipcode},US&appid=3fea99c98cb37573ea5e1473ec915284&units=imperial`,
        function (data, textStatus, jqXHR) {

            $("#reportHeader").text(`Weather Report for ${data.name}`);
            $("#weatherDesc").text(data.weather[0].description);
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    )
}