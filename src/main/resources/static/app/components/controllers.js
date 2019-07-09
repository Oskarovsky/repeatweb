(function (angular) {
    'use strict';

    // Controllers
    angular.module('repeat.controllers',
        [
            'repeat.modules.category.controllers',
            'repeat.modules.user.controllers',
            'repeat.modules.meal.controllers'
        ]);
})(angular);
