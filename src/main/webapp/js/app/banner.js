
angular.module('banners', ['config'])
.controller('BannerCtrl', function($scope, Banner) {
	
	console.log("init banner");
	
	$scope.inserir = function(banner) {
		
		console.log(banner);
		
		Banner.inserir(banner, function(response) {
			console.log(response);
			
			delete $scope.banner;
		}, function(response) {
			console.log(response);
		})
		
	}
	
})
.factory('Banner', function($http, Config) {
	
	return {
		inserir : function(banner, callbackSucesso, callbackErro) {
			
			$http({
				method : "POST",
				url : Config.baseUrl+"/banners",
				data: banner
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		}
	}
	
})