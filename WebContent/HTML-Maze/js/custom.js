	var host = "http://localhost:8080/MazeWebProject/";
	
	function listPlayers() {  
			$.ajax({ 
				url : host + 'players',
				type : 'GET',
				 headers: {          
	                 Accept : 'application/json'   
	  			},    
				success : function(data) {

					$('#grid tr:gt(0)').remove();
					if ($.isArray(data.players.link)) {
					   for ( var i = 0; i < data.players.link.length; i++) {
					      var link = data.players.link[i]['@href'];
					      fallowPlayerLink(link);
					   }
					} else {
					   var link = data.players.link['@href'];
					   fallowPlayerLink(link);
					}
			
				},
				error: function(data) {
					alert("Erro na invocaÃ§Ã£o");
				}
			});
		}      
		
		
		function fallowPlayerLink(link) {
		   $.ajax({
		      url : host + link,
		      type : 'GET',
		      success : function(data) {
		         addNewPlayerToNewGrid(data.player);
		      },
		      error : function(data) {
		         alert("Ocorreu um erro");
		      }
		   });
		}
		
		function addNewPlayerToNewGrid(player) {



			 var data = "<tr onmouseover='verCerveja(\"" + cerveja.nome + "\")' >"
	  		      + "<td>" + cerveja.nome + "</td>"
	  		      + "<td>" + cerveja.cervejaria + "</td>"
	  		      + "<td>" + cerveja.descricao + "</td>"
	  		      + "<td>" + cerveja.tipo + "</td>"
	  		      + "<td><input type=\"button\" class=\"btn btn-danger\"  value=\"Apagar\" "
	  		      + "onclick=\"apagaCerveja('" + cerveja.nome + "');\" /> " 
	  		    + "<input type=\"button\" value=\"Editar\"  class=\"btn btn-primary\""
	  		      + "onclick=\"carregaCerveja('" + cerveja.nome + "');\" /></td>" 
	  		      + "</tr>";

	  		   $("#grid").append(data);
	  		}

		function addPlayer() {
			var data = $("#creattePlayerForm").serializeJSON();

  			if(data.id){
  				updatePLayer(data);
  	  		}else {
  	  			createPlayer(data);
  	  	  	}

  		    
  		}

  		function createPlayer(data){
  			 data = "{\"player\":" + JSON.stringify(data) + "}";
   			$.ajax({
   			   url : host + 'players',
   			   type : 'POST',
   			   contentType : 'application/json',
   			   data : data,
   			   success : function(data) {
   				  alert(" Sucess!");
   				  $("#creattePlayerForm")[0].reset();
   				  listPlayers();
   			   },
   			   error : function(data) {
   				 
 						console.log(data);
 						alert("Ocorreu um erro: " + data.status + " "
 								+ data.statusText);	
   			   }
   			 });
  		}


		function updatePLayer(data) {
			id = data.nickName;
  			data = "{\"player\":" + JSON.stringify(data) + "}";
  			$.ajax({
  			   url : host + 'players/'+id,
  			   type : 'PUT',
  			   contentType : 'application/json',
  			   data : data,
  			   success : function(data) {
  				  alert("Incluído com sucesso!");
  				  $("#creattePlayerForm")[0].reset();
  				  listPlayers();
  			   },
  			   error : function(data) {
						console.log(data);
						alert("Ocorreu um erro: " + data.status + " "+ data.statusText);
					
  			   }
  			 });
  		}

		function apagaCerveja(id) {
  			$.ajax({
  						url : host + 'cervejas/' + id,
  						type : 'DELETE',
  						success : function(data) {
  							listarCervejas();
  						},
  						error : function(data) {
  							console.log(data);
  							alert("Ocorreu um erro: " + data.status + " "
  									+ data.statusText);
  						}
  					});

  		}

		function carregaCerveja(id) {
					$.ajax({
						url : host + 'players/' + id,
						type : 'GET',
						success : function(data) {
							var frm =  $("#creattePlayerForm");
							 $.each(data.player, function(key, value){
								    $('[name='+key+']', frm).val(value);
							});
						},
						error : function(data) {
							console.log(data);
							alert("Ocorreu um erro: " + data.status + " "
									+ data.statusText);
						}
					});

		}
		/*
		function verCerveja(nickName) {
  			$('#images').html('Loading...');
			$.ajax({
				url: '/handson-20/services/cervejas/' + nome,
				method: 'GET',
				headers: {
					Accept: 'image/*'
				},
				processData: false,
				cache: false,
				success: function (data) {
					console.info(data);
					$('#images').html('<img width=300 height=500 src="data:image/png;base64,' + data + '" />');
				},
				failure: function (data) {
					console.info('ERRO');
					$('#images').html('');
				}
			});
 	  	}
		*/