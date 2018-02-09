
var maMarmotte = {
  id1: {
    name: "OW",
    img: null,
    help: "shooter"
  },
  id2: {
    name: "WoW",
    img: null,
    help: "meuporg"
  }
}

angular.module('marmotte', [])
  .controller('marmotteListController', function($scope) {

    $scope.marmotteList = maMarmotte;

  });
