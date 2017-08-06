/**
 * Created by hasith on 8/5/2017.
 */

(function(){
    angular.module('SearchModule', ['ngDialog'])

        .controller('SearchController', function($scope, SearchFactory, ngDialog){
            SearchFactory.onSearchStudent().then(function(response){
                $scope.students = response.data ? [].concat(response.data.student) : [];
            });

            $scope.deleteStudent = function(id, name) {
                var dialog = ngDialog.open({
                    template: 'templateRemove',
                    className: 'ngdialog-theme-default',
                    controller: function($scope) {
                        $scope.studentName = name;
                        $scope.confirm = function() {
                            console.log("conform");
                            SearchFactory.onDeleteStudent(id)
                                .then(function (response) {
                                });
                            window.location.reload();
                            dialog.close();
                        };

                        $scope.close = function() {
                            console.log("cancel");
                            dialog.close()
                        };

                    }
                });
            }

            /*$scope.deleteStudent = function(id) {
                ngDialog.openConfirm({
                    template: 'templateRemove',
                    className: 'ngdialog-theme-default'
                }).then(function (value) {
                        console.log("confirm");
                    }, function (reason) {
                        console.log('Modal promise rejected. Reason: ', reason);
                    });
            }*/
            /*$scope.deleteStudent = function(id) {
                SearchFactory.onDeleteStudent(id)
                    .then(function (response) {
                        window.location.reload();
                    });
            }*/

            /*$scope.deleteStudent = function(id) {
                ModalService.showModal({
                    templateUrl: 'modal.html',
                    controller: "ModalController"
                }).then(function(modal) {
                    modal.element.modal();
                    modal.close.then(function(result) {
                        if(result === 'Yes'){
                            SearchFactory.onDeleteStudent(id)
                                .then(function (response) {
                                    window.location.reload();
                                })
                        }
                    });
                });
            };*/
        })

        /*.controller('ModalController', function($scope, ngDialog) {
            $scope.confirm = function() {
                console.log("conform");
            };

            $scope.close = function() {
                console.log("cancel");
                ngDialog.close();
            };

        })*/

        .factory('SearchFactory', function($http){
            return {
                onSearchStudent : function(){
                    return $http.get('rest/students').then(function(response){
                        return response;
                    });
                },
                onDeleteStudent : function(id){
                    return $http({
                        method: 'DELETE',
                        url:'rest/students?id='+id
                    }).then(function(response){
                        return response;
                    });
                }
            }
        })
}());