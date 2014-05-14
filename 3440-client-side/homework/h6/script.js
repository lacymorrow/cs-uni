function calc(a) {
	var t1 = document.getElementById("t" + a).value,
		d1 = document.getElementById("t" + a).getAttribute("rel");
	for (var i = 0; i < 5; i++){
		//Riegel
		var d2 = document.getElementById("t" + i).getAttribute("rel"),
			t2 = (t1 * Math.pow((d2/d1),1.06));
		document.getElementById("t" + i).value = t2.toFixed(1);
		document.getElementsByTagName("tr")[i+1].children[2].innerHTML = (t2/60).toFixed(2);
		//Cameron
		var a = (13.49681 - (0.048865*d1) + 2.438936/(Math.pow(d1,0.7905))),
			b = (13.49681 - (0.048865*d2) + 2.438936/(Math.pow(d2,0.7905)));
		t2 = ((t1/d1) * (a/b) * d2);
		document.getElementsByTagName("tr")[i+1].children[3].innerHTML = t2.toFixed(1);
		document.getElementsByTagName("tr")[i+1].children[4].innerHTML = (t2/60).toFixed(2);
	}           
}
