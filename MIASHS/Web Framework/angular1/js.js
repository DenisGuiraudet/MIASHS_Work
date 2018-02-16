var tempCard = null;
var tempActu = null;
var waiting = false;
var nbFlip = 0;

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})
angular.module('marmotte', [])
  .controller('marmotteListController', function($scope) {

    $scope.marmotteList;
    $scope.score;
    $scope.scoreTot;

    $scope.loadData = function() {

      $scope.marmotteList = [];
      $scope.score = 0;
      db.collection("data").get().then((querySnapshot) => {
          querySnapshot.forEach((doc) => {
            $scope.marmotteList.push(doc.data(), doc.data());
            $scope.marmotteList.sort(function() { return 0.5 - Math.random() });
            $scope.$apply();
          });
      });


    };

    $scope.loadData();

    function checkSecondCard () {
      if (tempCard.parentElement.querySelector(".front h5.card-title").textContent == tempActu.parentElement.querySelector(".front h5.card-title").textContent) {
        tempCard = null;
        tempActu = null;
        waiting = false;
        nbFlip += 2;
        $scope.score += 10;
      }
      else{
        setTimeout(function () {
          var frontElement = tempCard.parentElement.querySelector(".front");
          var backElement = tempCard.parentElement.querySelector(".back");
          var frontActElement = tempActu.parentElement.querySelector(".front");
          var backActElement = tempActu.parentElement.querySelector(".back");
          frontElement.style.transform = "rotateY(180deg)";
          backElement.style.transform = "none";
          frontActElement.style.transform = "rotateY(180deg)";
          backActElement.style.transform = "none";
          tempCard = null;
          tempActu = null;
          waiting = false;
          $scope.score -= 2;
        }, 1000);
      }
    }

    $scope.calculateScoreTotal = function(length){
      return 10 * length/2 ;
    }

    $scope.flipBack = function($event) {
      if(waiting == true){
        return;
      }
      waiting = true;
      tempActu = $event.currentTarget;
      tempActu.style.transform = "rotateY(180deg)";
      tempActu.parentElement.querySelector(".front").style.transform = "rotateY(360deg)";
      if (tempCard == null) {
        tempCard = tempActu;
        waiting = false;
      }
      else{
        checkSecondCard();
      }
      if (nbFlip == $scope.marmotteList.length) {
        $scope.scoreTot = $scope.calculateScoreTotal($scope.marmotteList.length);
        document.querySelector(".alert").classList.remove("d-none");
        nbFlip = 0;
        tempActu = null;
        tempCard = null;
      }
    }

    $scope.ripley = function($event) {
      $scope.loadData();
      document.querySelector(".alert").classList.add("d-none");

    }
  });
