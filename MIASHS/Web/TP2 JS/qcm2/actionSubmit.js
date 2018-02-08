
window.onload = function() {loadingFun()};

function loadingFun() {

  var submitBut = document.querySelector("input[type=submit]");

  submitBut.addEventListener('click', submitStuff);

  //

  writeListOfBlocks();

}

function submitStuff(event) {
  event.preventDefault();

  let nbrAnswered = 0;

  var arrayRep = document.querySelectorAll(".block>.rep");

  for (let rep of arrayRep) {
    //console.log(rep);

    let gotAnswer = false;

    var arrayCheckbox = rep.querySelectorAll("input[type=checkbox]");

    for (let checkbox of arrayCheckbox) {
      //console.log(checkbox.name + "-" + checkbox.checked);

      gotAnswer = gotAnswer + checkbox.checked;

    }

    if (gotAnswer) nbrAnswered++;

  }

  alert(nbrAnswered + " question answered out of " + (arrayRep.length - 1) + " :p");

}
