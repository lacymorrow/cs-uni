function resetArr(){
	var a = [];
	for(var x = 0; x < 3; x++){
		a[x] = [];
		for(var y = 0; y < 3; y++){
			a[x][y] = "-";
			$("#cell"+x+y).text(" ");
		}
	}
	return a;
}

$(function() {
	//generate blank board string
	var arr = [];
	var next = "X";
	arr = resetArr();
	$( "table#board" ).on( "click", "td", function(e) {
		e.preventDefault();
		//alert($(e.target).attr('id'));
		//extract char 4 & 5 of cell id
		var cell = $(e.target).attr('id');
		var cellx = cell.charAt(cell.length-2);
		var celly = cell.charAt(cell.length-1);
		if (arr[cellx][celly] == "-"){ //open square clicked
			//place x or o into board
			$(e.target).text(next);
			//place x or o into array
			arr[cellx][celly] = next;
			if(next == "X"){
				next = "O";
			} else {
				next = "X";
			}
			//generate board
			var state = "";
			for(var x = 0; x < 3; x++){
				for(var y = 0; y < 3; y++){
					state += arr[x][y];
				}
			}
			//make ajax call
			$.get( "http://student.cs.appstate.edu/crr/3440/tictactoe/tictactoejson.php", { board: state} )
			.done(function( data ) {
				var state = data.state;
				if(state == "continue"){ //continue
					
				} else if (state == "winner"){ //winner
					confirm("Game Over.\nPlayer "+data.player+" wins!");
					$("#"+data.player+"Wins").text(parseInt($("#"+data.player+"Wins").text())+1);
					arr  = resetArr();
				} else if (state == "tie"){ //tie=
					confirm("Tie game!");
					arr = resetArr();
				} else { //error
					alert( "Apologies, it appears you have encountered an error. Please refresh the page to try again." );
				}
			})
			.fail(function() {
				alert( "Apologies, it appears you have encountered an error. Please refresh the page to try again." );
			})
		}
	});
});