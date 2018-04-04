
window.onload = function() {loadingFun()};

function loadingFun() {

  var submitBut = document.querySelector("button#initLines");

  submitBut.addEventListener('click', initLines);

}

function initLines() {

  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        var jason = JSON.parse(this.responseText);

        var ul = document.querySelector("ul#stations");
        while (ul.firstChild) {
          ul.removeChild(ul.firstChild);
        }

        for (let line of jason.lines.line) {

          var li = document.createElement("li");
          li.id = line.id;
          li.addEventListener('click', arretsLigne);
          li.appendChild(document.createTextNode(line.shortName + " - " + line.name));
          li.style.color = line.bgXmlColor;

          ul.appendChild(li);

        }

      }
  };
  xmlhttp.open("GET", "https://api.tisseo.fr/v1/lines.json?key=a3732a1074e2403ce364ad6e71eb998cb", true);
  xmlhttp.send();

}

function arretsLigne() {

  var select = this;

  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        var jason = JSON.parse(this.responseText);

        //var markers = {"color" : select.style.color};
        var markers = {"color" : "#ff0000"};
        var stops = [];

        var h2 = document.querySelector("h2#station");
        while (h2.firstChild) {
          h2.removeChild(h2.firstChild);
        }
        h2.appendChild(document.createTextNode(select.firstChild.nodeValue));
        h2.style.color = select.style.color;

        var ul = document.querySelector("ul#station");
        while (ul.firstChild) {
          ul.removeChild(ul.firstChild);
        }

        for (let stop of jason.physicalStops.physicalStop) {

          var li = document.createElement("li");
          li.appendChild(document.createTextNode(stop.name + "(" + stop.x + " - " + stop.y + ")"));

          ul.appendChild(li);

          stops.push({"lat" : stop.y, "long" : stop.x, "name" : stop.name});

        }

        markers.stops = stops;

        init_map("map", markers);

      }
  };
  xmlhttp.open("GET", "https://api.tisseo.fr/v1/stop_points.json?key=a3732a1074e2403ce364ad6e71eb998cb&displayCoordXY=1&lineId=" + this.id, true);
  xmlhttp.send();

}
