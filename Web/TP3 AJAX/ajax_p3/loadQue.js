
function writeListOfBlocks() {

  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        var jason = JSON.parse(this.responseText);
        //console.log(jason);*

        for (let section of jason.lesquestions) writeBlock(section);

      }
  };
  xmlhttp.open("GET", "http://mass-cara2.univ-tlse2.fr/~Nathalie.Hernandez/getQCM.php", true);
  xmlhttp.send();

}

function writeBlock(section) {

  var listOfBlocks = document.querySelector("div.listOfBlocks");

  var block = document.createElement("section");
  block.classList.add('block');

  var que = document.createElement("div");
  //
  que.id = section.idQ;
  que.appendChild(document.createTextNode(section.intituleQ));
  //
  que.classList.add("que");
  block.appendChild(que);

  var rep = document.createElement("div");
  //
  for (var i = 0; i < section.reponses.length; i++) {
    let checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.id = section.reponses[i].idR;
    rep.appendChild(checkbox);
    rep.appendChild(document.createTextNode(" " + section.reponses[i].intituleR));
    rep.appendChild(document.createElement("br"));
  }
  //
  rep.classList.add("rep");
  block.appendChild(rep);

  listOfBlocks.appendChild(block);

}
