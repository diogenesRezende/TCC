angular
		.module("univasApp")
		.controller(
				"univasAppController",
				function($scope, $http) {

					$scope.adicionarAluno = function(aluno) {
						console.info(aluno);
						$http
								.post(
										"http://localhost:8080/WebServiceRestUnivas/rest/alunos",
										aluno);

						$scope.limparForm();
					};
					$scope.limparForm = function() {
						console.info("foi");
						$scope.aluno.nome = "";
						$scope.aluno.email = "";
					};

				});