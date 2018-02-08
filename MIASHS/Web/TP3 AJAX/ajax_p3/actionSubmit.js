
window.onload = function() {loadingFun()};

function loadingFun() {

  var submitBut = document.querySelector("input[type=submit]");

  submitBut.addEventListener('click', submitStuff);

  //

  writeListOfBlocks();

}

function submitStuff(event) {
  event.preventDefault();

  var ques = document.querySelectorAll("div.listOfBlocks section.block div.que");

  var objectsOfQue = {};

  for (let que of ques) {

    var arrayOfRep = [];

    for (let rep of que.parentNode.querySelectorAll(".rep input[type=checkbox]")) {

      if (rep.checked) {

        arrayOfRep.push(rep.id);

      }

    }

    objectsOfQue[que.id] = arrayOfRep;

  }

  var xmlhttpAllRep = new XMLHttpRequest();
  xmlhttpAllRep.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        var jason = JSON.parse(this.responseText);

        for (let idQue in jason) {

          if (jason[idQue] == "JUSTE") {

            document.querySelector("#" + idQue).parentNode.style.background = "GreenYellow";

          } else if (jason[idQue] == "FAUX") {

            document.querySelector("#" + idQue).parentNode.style.background = "LightSalmon";

          } else {

            document.querySelector("#" + idQue).parentNode.style.background = "DarkGoldenRod";

          }

        }


      }
  };
  xmlhttpAllRep.open("POST", "http://mass-cara2.univ-tlse2.fr/~Nathalie.Hernandez/getLesReponses.php", true);
  xmlhttpAllRep.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xmlhttpAllRep.send("Reponses=" + JSON.stringify(objectsOfQue));


}
