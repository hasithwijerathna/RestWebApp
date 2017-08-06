(function(){
    angular.module('SampleApp', ['ngRoute', 'SearchModule', 'InsertModule', 'UpdateModule', 'ngDialog'])

    .config(function($routeProvider){
        $routeProvider.when("/search",{
            templateUrl:"app/mod-search/searchView.html",
            controller:"SearchController"
        }).when("/insert",{
            templateUrl:"app/mod-insert/insertView.html",
            controller:"InsertController"
        }).when("/update/:studentId",{
            templateUrl:"app/mod-update/updateView.html",
            controller:"UpdateController"
        }).otherwise({
            redirectTo:"/search"
        })
    })
}());