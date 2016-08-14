
angular.module('categorias', [])
.controller('CategoriaCtrl', function($scope, Categoria) {
	
	console.log("init categoria");
	
	$scope.inserir = function(obj) {
		
		console.log(obj);
		
		Categoria.inserir(obj, function(response) {
			console.log(response);
			
			delete $scope.categoria;
		}, function(response) {
			console.log(response);
		})
		
	}
	
	$scope.buscar = function(nome) {
		
		Categoria.consultar(nome, function(response) {
			console.log(response);
			
			$scope.categoria = response.data;
			delete $scope.nome;
		}, function(response) {
			console.log(response);
		})
		
	}
	
})
.factory('Categoria', function($http) {
	
	return {
		inserir : function(obj, callbackSucesso, callbackErro) {
			
			$http({
				method : "POST",
				url : "http://45.55.134.116/servicos/categorias",
				data: obj
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		},
		consultar: function(nome, callbackSucesso, callbackErro) {
			
			$http({
				method : "GET",
				url : "http://45.55.134.116/servicos/categorias/"+nome,
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		},
		listar : function(callbackSucesso, callbackErro) {
			
			$http({
				method : "GET",
				url : "http://45.55.134.116/servicos/categorias/",
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
		}
	}
	
})