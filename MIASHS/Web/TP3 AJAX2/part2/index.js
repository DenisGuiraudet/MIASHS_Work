
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

        for (let machin of jason.physicalStops.physicalStop) {

          var li = document.createElement("li");
          li.appendChild(document.createTextNode(machin.name + "(" + machin.x + " - " + machin.y + ")"));

          ul.appendChild(li);

        }

      }
  };
  xmlhttp.open("GET", "https://api.tisseo.fr/v1/stop_points.json?key=a3732a1074e2403ce364ad6e71eb998cb&displayCoordXY=1&lineId=" + this.id, true);
  xmlhttp.send();

}
