
angular.module('marmotte', [])
  .controller('marmotteListController', function($scope) {

    $scope.marmotteList = [];

    db.collection("data").get().then((querySnapshot) => {
        querySnapshot.forEach((doc) => {
          $scope.marmotteList.push(doc.data());
          $scope.$apply();
        });
    });


  });
