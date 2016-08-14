
angular.module('banners', [])
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
.factory('Banner', function($http) {
	
	return {
		inserir : function(banner, callbackSucesso, callbackErro) {
			
			$http({
				method : "POST",
				url : "http://45.55.134.116/servicos/banners",
				//url : "http://localhost:8080/banners",
				data: banner
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		}
	}
	
})