/**
 * 
 */
function addViaAjax(){
	var name = $("#name").val();
	var age = $("#age").val();
	
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/addNew",
		data: {
			name: name,
			age: age
		},
		dataType: "json",
		success: function(jsonResponse){
			console.log("SUCCESS: ", jsonResponse);
			var result = "<h3> You just add new Person </h3>"
				+ "<strong>Name:</strong> " + jsonResponse.name + "<br>"
				+ "<strong>Age:</strong> " + jsonResponse.age+"<br>"
				+ "<strong>Role:</strong> " + jsonResponse.role;
			$("#ajax-response").html(result);
		},
		error: function(e){
			console.log("ERROR: ", e);
		}
	});
}
function searchViaAjax(){
	var name = $("#query").val();
	
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/search",
		data:{
			name: name
		},
		dataType: "json",
		success: function(jsonResponse){
			console.log("Sucess: "+jsonResponse);
			var result = "<h3> You just search Person with info: Name: "
				+ jsonResponse.name+" Age: "+jsonResponse.age + "</h3>";
			$("#ajax-response").html(result);
		},
		error: function(e){
			var result = "<h3 style='color:red'> No person found </h3>";
			$("#ajax-response").html(result);
		}
	});
}