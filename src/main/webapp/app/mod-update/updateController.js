/**
 * Created by hasith on 8/5/2017.
 */
(function(){
    angular.module('UpdateModule', [])

        .controller('UpdateController', function($scope, UpdateFactory, $routeParams){

            $scope._data = {};
            $scope._data.id = $routeParams.studentId;
            UpdateFactory.studentById($routeParams.studentId).then(function(response){
                $scope._data.name = response.data.name;
                $scope._data.age = parseInt(response.data.age);
                $scope._data.address = response.data.address;
            });

            $scope.updateUser = function(){
                console.log("clicked....");
                UpdateFactory.onUpdateStudent(JSON.stringify($scope._data)).then(function(response){
                    console.log("Successfully Updated." +response);
                    window.location = '#/search';
                });
            };
        })

        .factory('UpdateFactory', function($http){
            return {
                onUpdateStudent : function(data){
                    return $http({
                        method: 'PUT',
                        url:'rest/students',
                        data: data,
                        accept: 'application/json'
                    }).then(function(response){
                        return response;
                    });
                },
                studentById : function(id){
                    return $http({
                        method: 'GET',
                        url:'rest/students/'+id
                    }).then(function(response){
                        return response;
                    });
                }
            }
        })
}());