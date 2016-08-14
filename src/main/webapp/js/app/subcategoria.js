
angular.module('subcategorias', ['categorias'])
.controller('SubcategoriaCtrl', function($scope,Subcategoria, Categoria) {
	
	console.log("init subcategoria");
	
	$scope.inserir = function(obj) {
		
		console.log(obj);
		
		Subcategoria.inserir(obj, function(response) {
			console.log(response);
			
			delete $scope.subcategoria;
		}, function(response) {
			console.log(response);
		})
		
	}
	
	$scope.buscar = function(nome) {
		
		Subcategoria.consultar(nome, function(response) {
			console.log(response);
			
			$scope.subcategoria = response.data;
			delete $scope.nome;
		}, function(response) {
			console.log(response);
		})
		
	}
	$scope.listarCategorias = function() {
		
		Categoria.listar(function(response) {
			console.log(response);
			
			$scope.categorias = response.data;
		}, function(response) {
			console.log(response);
		})
		
	}
	
})
.factory('Subcategoria', function($http) {
	
	return {
		inserir : function(obj, callbackSucesso, callbackErro) {
			
			$http({
				method : "POST",
				url : "http://45.55.134.116/servicos/subcategorias",
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
				url : "http://45.55.134.116/servicos/subcategorias/"+nome,
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		},
	}
	
})