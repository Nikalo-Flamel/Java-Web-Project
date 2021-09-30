alert = document.querySelector("#alert");
submit = document.querySelector("#submit");
form = document.querySelector("#form");
newPass1 = document.querySelector("#newPass1");
newPass2 = document.querySelector("#newPass2");

submit.addEventListener("click", function(event){
	if (newPass1.value == "") {
			alert.style.display = "none"
			return true
	} else {
		if(newPass1.value == newPass2.value) {
			alert.style.display = "none";
			return true;
		} else {
			alert.style.display = "block";
			event.preventDefault();
			return false;
		}
	}

});
