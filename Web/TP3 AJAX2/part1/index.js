
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

        console.log(jason.lines);

        for (let line of jason.lines.line) {

          var ul = document.querySelector("ul");

          var li = document.createElement("li");
          li.appendChild(document.createTextNode(line.shortName + " - " + line.name));
          li.style.color = line.bgXmlColor;

          ul.appendChild(li);

        }

      }
  };
  xmlhttp.open("GET", "https://api.tisseo.fr/v1/lines.json?key=a3732a1074e2403ce364ad6e71eb998cb", true);
  xmlhttp.send();

}
