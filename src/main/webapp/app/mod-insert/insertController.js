/**
 * Created by hasith on 8/5/2017.
 */

(function(){
    angular.module('InsertModule', [])

        .controller('InsertController', function($scope, InsertFactory){

            $scope.insertUser = function(){
                InsertFactory.onInsertStudent(JSON.stringify($scope._data)).then(function(response){
                    console.log("Successfully Inserted." +response);
                    window.location = '#/search';
                });
            };
        })

        .factory('InsertFactory', function($http){
            return {
                onInsertStudent : function(data){
                    return $http({
                        method: 'POST',
                        url:'rest/students',
                        data: data,
                        accept: 'application/json'
                        //contentType: "application/json"
                    }).then(function(response){
                        return response;
                    });
                }
            }
        })
}());