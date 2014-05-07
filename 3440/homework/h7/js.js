	function formReset()
	{
	document.getElementById("data").reset();
	}
	var training = new Array();
	function create(){
		var date, distance, time, effort, mhr, rhr, weight, sleep, notes;
		date = document.getElementById("date").value;
		distance = document.getElementById("distance").value;
		time = document.getElementById("time").value;
		effort = document.getElementById("effort").value;
		mhr = document.getElementById("mhr").value;
		rhr = document.getElementById("rhr").value;
		weight = document.getElementById("weight").value;
		sleep = document.getElementById("sleep").value;
		notes = document.getElementById("notes").value;
		var a = -1;
		for(var i = 0; i < training.length; i++){
			if(training[i].date == date){
				a = i;
			}
		}
		if(a >= 0){
			//edit existing
			training[a].date = date;
			training[a].distance = distance;
			training[a].time = time;
			training[a].effort = effort;
			training[a].mhr = mhr;
			training[a].rhr = rhr;
			training[a].weight = weight;
			training[a].sleep = sleep;
			training[a].notes = notes;
		} else {
			//create new
			var entry = new TrainingDay(date, distance, time, effort, mhr, rhr, weight, sleep, notes);
			training.push(entry);
		}

		training.sort(function(a, b){
			var keyA = new Date(a.date),
			keyB = new Date(b.date);
			// Compare the 2 dates
			if(keyA < keyB) return -1;
			if(keyA > keyB) return 1;
			return 0;
		});
		
		//print out array
		displayTable();
		//store to localstorage
		localStorage.training = JSON.stringify(training);
	}
	
	function displayTable(){
		var out = "<tr><td>Date</td><td>Run Distance</td><td>Run Time</td><td>Effort</td><td>Max Heart Rate</td><td>Testing Heart Rate</td><td>Weight</td><td>Sleep</td><td>Notes</td></tr>";
		for(var i = 0; i < training.length; i++){
			out = out + "<tr>";
			out = out + "<td>"+training[i].date+"</td>";
			out = out + "<td>"+training[i].distance+"</td>";
			out = out + "<td>"+training[i].time+"</td>";
			out = out + "<td>"+training[i].effort+"</td>";
			out = out + "<td>"+training[i].mhr+"</td>";
			out = out + "<td>"+training[i].rhr+"</td>";
			out = out + "<td>"+training[i].weight+"</td>";
			out = out + "<td>"+training[i].sleep+"</td>";
			out = out + "<td>"+training[i].notes+"</td>";
			out = out + "</tr>";
		}
		
		document.getElementById("training").innerHTML = out;
	}
	function TrainingDay(date, distance, time, effort, mhr, rhr, weight, sleep, notes) {
		this.date = date;
		this.distance = distance;
		this.time = time;
		this.effort = effort;
		this.mhr = mhr;
		this.rhr = rhr;
		this.weight = weight;
		this.sleep = sleep;
		this.notes = notes;
	}
	
	window.onload = function (){
		if(localStorage.training){
			training = JSON.parse(localStorage.training);
			displayTable();
		}
	}