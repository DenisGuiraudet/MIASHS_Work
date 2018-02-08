
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

  for (let que of ques) {

    let listOfRep = "";

    for (let rep of que.parentNode.querySelectorAll(".rep input[type=checkbox]")) {

      if (rep.checked) {

        listOfRep = listOfRep + rep.id + ",";

      }

    }
    isRepGuud(que.id, listOfRep.slice(0, -1));

  }

}
