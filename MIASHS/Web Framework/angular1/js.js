
var maMarmotte = [
  {
    name: "OW",
    img: "null",
    help: "shooter"
  },
  {
    name: "WoW",
    img: "null",
    help: "meuporg"
  }
];

angular.module('marmotte', [])
  .controller('marmotteListController', function($scope) {

    $scope.marmotteList = maMarmotte;
    console.log($scope.marmotteList);

    db.collection("data").get().then((querySnapshot) => {
        querySnapshot.forEach((doc) => {
          console.log(doc.data());
          $scope.marmotteList.push(doc.data());
          console.log($scope.marmotteList);
        });
    });


  });
