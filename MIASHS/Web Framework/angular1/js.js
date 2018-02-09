
var 

angular.module('marmotte', [])
  .controller('marmotteListController' ,function() {

    var marmotteList = this;



  });


window.onload = function(){

  let cards = document.querySelectorAll(".card");
  for (let card of cards) {
    card.appendChild(get_back_side());
  }

}

function get_back_side() {

  let back = document.createElement("div");
  back.classList.add("back");
  back.classList.add("position-absolute");
  back.classList.add("border");
  back.classList.add("rounded");
    let backImg = document.createElement("img");
    backImg.classList.add("card-img-top");
    backImg.src = "https://cdn.vox-cdn.com/thumbor/O_m3r1bT2CtzOHY-9cwDcL4lCgQ=/0x0:1920x1080/1200x800/filters:focal(807x387:1113x693)/cdn.vox-cdn.com/uploads/chorus_image/image/53872699/battle_net.0.jpg";
  back.appendChild(backImg);
    let backDiv = document.createElement("div");
    backDiv.classList.add("card-footer");
      let backDivH = document.createElement("h5");
      backDivH.classList.add("card-title");
      backDivH.appendChild(document.createTextNode("???"));
    backDiv.appendChild(backDivH);
  back.appendChild(backDiv);
  return back;

}
