
angular.module('categorias', ['config','subcategorias'])
.controller('CategoriaCtrl', function($scope, Categoria, Subcategoria) {

	console.log("init categoria");

	$scope.editar = false;

	$scope.salvarCategoria = function() {

		Categoria.inserir($scope.categoria, function(response) {

			$scope.categoria = response.data;
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
		});

	}

	$scope.novaCategoria = function() {

		delete $scope.categoria;
		
		$scope.categoria = {
				nome: null,
				subcategorias: new Array(),
		}
		
	}

	$scope.inserirSubcategoria = function(subcategoria) {
		
		if(subcategoria)
		Subcategoria.inserir(subcategoria, function(response) {
			
			$scope.categoria.subcategorias.push(response.data);
			
			console.log($scope.categoria.subcategorias);
			
			setTimeout(function() {
				$scope.salvarCategoria();

			}, 500);

			delete $scope.subcategoria;
		}, function(data) {
			console.log(response);
		});

	}

	$scope.editarCategoria = function(categoria) {
		$scope.categoria = categoria;
	}

	$scope.editarSubcategoria = function() {
		$scope.editar = true;
	}
	
	$scope.atualizarSubcategoria = function(subcategoria) {
		
		console.log(subcategoria);
		
		Subcategoria.inserir(subcategoria, function(response) {
			$scope.salvarCategoria();

			$scope.editar = false;

		}, function(data) {
			console.log(response);
		});

	}

	$scope.buscaDeCategoriasPorPalavraChave = function(nome) {

		Categoria.consultar(nome, function(response) {
			console.log(response);

			$scope.categoria = response.data;
			delete $scope.nome;
		}, function(response) {
			console.log(response);
		})

	}

	$scope.removerSubcategoria = function(sub) {

		for(var i = 0; i < $scope.categoria.subcategorias.length; i++){

			if($scope.categoria.subcategorias[i].id === sub.id){
				$scope.categoria.subcategorias.splice(i, 1);
			}

		}

		setTimeout(function() {

			console.log($scope.categoria);

			$scope.salvarCategoria();

		}, 500);

	}
	
	$scope.init = function() {
		
		$scope.listarCategorias();
		
		$scope.novaCategoria();
	}

	$scope.init();

})
.factory('Categoria', function($http, Config) {

	return {
		inserir : function(obj, callbackSucesso, callbackErro) {

			$http({
				method : "POST",
				url : Config.baseUrl+"/categorias",
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
				url : Config.baseUrl+"/categorias/"+nome,
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});

		},
		listar : function(callbackSucesso, callbackErro) {

			$http({
				method : "GET",
				url : Config.baseUrl+"/categorias",
			}).then(function success(response) {
				callbackSucesso(response);
			}, function error(response) {
				callbackErro(response);
			});
		}
	}

})