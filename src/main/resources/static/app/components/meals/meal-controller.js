(function (angular) {
    'use strict';

// Controllers
    angular.module('repeat.modules.meals.controllers', [])
        .controller('MealCreateController',
            ['$scope', 'MealService',
            function ($scope, MealService) {
                $scope.resetForm = function () {
                    $scope.meal = null;
                };

                $scope.create = function (customer) {
                    MealService.create(customer).then(
                        function (data) {
                            console.log('Success on create Category!!!')
                        }, function (err) {
                            console.log('Error on create Category')}
                    );
                };
            }])

        .controller('MealEditController',
            ['$scope', '$stateParams', 'MealService',
            function ($scope, $stateParams, MealService) {
                var id = $stateParams.productId;

                MealService.findOne(id).then(
                    function (result) {
                        $scope.meal = result.data;
                        console.log($scope.meal);
                    }, function (err) {
                        console.log(err);
                    });

                $scope.resetForm = function () {
                    $scope.product.name = null;
                    $scope.product.price = null
                };

                $scope.edit = function (productForm) {
                    MealService.update($scope.product).then(
                        function (data) {
                            console.log("Success on update Product!!!")
                        }, function (err) {
                            console.log("Error on update Product!!!")
                        });
                };
            }])

        .controller('MealListController',
            ['$scope', 'MealService',
                function ($scope, MealService) {
                    MealService.find().then(function (data) {
                        $scope.mealList = data.data;
                    }, function (err) {
                        console.log(err);
                    });
                }]).

        controller('MealDetailController',
            ['$scope', 'MealService',
                function ($scope, MealService) {
                    $scope.findOne = function (id) {
                        MealService.findOne(id).then(function (data) {
                            $scope.product = data;
                        }, function (err) {
                            console.log(err);
                        });
                    };

                }]);
})(angular);


