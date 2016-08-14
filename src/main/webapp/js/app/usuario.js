
angular.module('usuarios', [])
.controller('UsuarioCtrl', function($scope, Usuario) {
	
	console.log("init categoria");
	
	$scope.usuario = {};
	
	$scope.inserir = function(obj) {
		
		console.log(obj);
		
		Usuario.inserir(obj, function(response) {
			console.log(response);
			
			delete $scope.usuario;
		}, function(response) {
			console.log(response);
		})
		
	}

	$scope.buscar = function(login) {
		
		Usuario.consultar(login, function(response) {
			console.log("Usuario buscado");
			console.log(response);
			
			$scope.usuario = response.data;
			delete $scope.login;
		}, function(response) {
			console.log(response);
		})
		
	}
	
})
.factory('Usuario', function($http) {
	
	return {
		inserir : function(obj, callbackSucesso, callbackErro) {
			
			$http({
				method : "POST",
				url : "http://45.55.134.116/servicos/usuarios",
				data: obj
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		},
		consultar: function(login, callbackSucesso, callbackErro) {
			
			$http({
				method : "GET",
				url : "http://45.55.134.116/servicos/usuarios/"+login,
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		},
	}
	
})