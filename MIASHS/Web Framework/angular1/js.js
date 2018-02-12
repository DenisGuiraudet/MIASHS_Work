var tempCard = null;
var tempActu = null;
var waiting = false;
var nbFlip = 0;

angular.module('marmotte', [])
  .controller('marmotteListController', function($scope) {

    $scope.marmotteList;

    $scope.loadData = function() {

      $scope.marmotteList = [];

      db.collection("data").get().then((querySnapshot) => {
          querySnapshot.forEach((doc) => {
            $scope.marmotteList.push(doc.data(), doc.data());
            $scope.marmotteList.sort(function() { return 0.5 - Math.random() });
            $scope.$apply();
          });
      });

    };

    $scope.loadData();

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
        if (tempCard.parentElement.querySelector(".front h5.card-title").textContent == tempActu.parentElement.querySelector(".front h5.card-title").textContent) {
          tempCard = null;
          tempActu = null;
          waiting = false;
          nbFlip += 2;
        }
        else{
          setTimeout(function () {
            tempCard.parentElement.querySelector(".front").style.transform = "rotateY(180deg)";
            tempCard.parentElement.querySelector(".back").style.transform = "none";
            tempActu.parentElement.querySelector(".front").style.transform = "rotateY(180deg)";
            tempActu.parentElement.querySelector(".back").style.transform = "none";
            tempCard = null;
            tempActu = null;
            waiting = false;
          }, 1000);
        }
      }
      if (nbFlip == $scope.marmotteList.length) {
        document.querySelector(".alert").classList.remove("d-none");

      }
    }

    $scope.ripley = function($event) {
      $scope.loadData();
      document.querySelector(".alert").classList.add("d-none");

    }

  });
