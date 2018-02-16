describe('service card',function(){
  it('Shoud return the totam result',function(){
    var result = $scope.calculateScoreTotal(10);
    var expected = 50;
    expect(result).toEqual(expected);
  });

});
