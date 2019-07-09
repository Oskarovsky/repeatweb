(function (angular) {
    'use strict';

    // Services
    angular.module('repeat.services',
        [
            'repeat.modules.category.services',
            'repeat.modules.user.services',
            'repeat.modules.meal.services'
        ]);
})(angular);
