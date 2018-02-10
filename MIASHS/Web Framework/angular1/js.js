
angular.module('marmotte', [])
  .controller('marmotteListController', function($scope) {

    $scope.marmotteList = [];

    db.collection("data").get().then((querySnapshot) => {
        querySnapshot.forEach((doc) => {
          $scope.marmotteList.push(doc.data(), doc.data());
          $scope.marmotteList.sort(function() { return 0.5 - Math.random() });
          $scope.$apply();
        });
    });

    $scope.flipFront = function($event) {
      $event.currentTarget.style.transform = "rotateY(180deg)";
      $event.currentTarget.parentElement.querySelector(".back").style.transform = "none";

    }

    $scope.flipBack = function($event) {
      $event.currentTarget.style.transform = "rotateY(180deg)";
      $event.currentTarget.parentElement.querySelector(".front").style.transform = "rotateY(360deg)";

    }

  });
