<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $.ajax({
			url: "https://gateway.watsonplatform.net/tone-analyzer/api/v3/tone?version=2016-05-19",
			beforeSend: function(xhr) { 
			  xhr.setRequestHeader("Authorization", "Basic " + btoa("username:password")); 
			},
			type: 'POST',
			dataType: 'json',
			contentType: 'application/json',
			processData: false,
			data: '{"text": "A word is dead when it is said, some say. Emily Dickinson"}',
			success: function (data) {
			  alert(JSON.stringify(data));
			},
			error: function(){
			  alert("Cannot get data");
			}
		});

    });
});
</script>
</head>
<body>

<div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>

<button>Get External Content</button>

</body>
</html>
