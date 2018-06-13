angular
.module('itesoft-showcase').controller('HomeCtrl',['$scope','Person', function($scope,Person) {
      $scope.person = {};


      $scope.changeurl = function () {
          var url = prompt('new url ');
          localStorage.setItem('DEMO_BACK_URL',url)
          location.reload();
      };

      $scope.submit = function(form){
        console.log($scope.person);
         Person.save($scope.person).$promise.then(function(){
         Person.query().$promise.then(function(data){
           $scope.persons = data;
           $scope.person = {};
         })
         },function(){
           console.log('error');
         });
      }
}]).factory('Person',['$resource',function($resource){
    var URL = localStorage.getItem('DEMO_BACK_URL');
return $resource(URL  ? URL  +'/rest/persons/:id' : 'http://localhost/rest/persons/:id', null,
    {
        'update': { method:'PUT' }
    });
}])