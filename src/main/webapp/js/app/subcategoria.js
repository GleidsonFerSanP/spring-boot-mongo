
angular.module('subcategorias', ['categorias','config'])
.controller('SubcategoriaCtrl', function($scope,Subcategoria, Categoria) {
	
	console.log("init subcategoria");
	
	$scope.subcategoria = {
			nome: null,
	}
	
	$scope.categoria = {};
	
	var subcategorias = new Array();
	
	$scope.selectCategoria = function(categoria) {
		console.log(categoria);
	}
	
	$scope.inserir = function(subcategoria, categoria) {
		
		//var categoria = obj.categoria;
		
		//subcategorias.push(obj);
		
		console.log(subcategoria);

		console.log(categoria);
	/*	
		categoria.subcategorias = subcategorias;
		
		console.log(categoria);*/
		
		/*Categoria.inserir(categoria, function(response) {
			
			delete $scope.subcategoria;
		}, function(response) {
			console.log(response);
		})*/
		
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
.factory('Subcategoria', function($http, Config) {
	
	return {
		inserir : function(obj, callbackSucesso, callbackErro) {
			
			$http({
				method : "POST",
				url : Config.baseUrl+"/subcategorias",
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
				url : Config.baseUrl+"/subcategorias/"+nome,
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
			
		},
	}
	
})