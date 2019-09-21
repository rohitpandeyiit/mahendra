function validate(frm)
{
	//set vflag to "yes" indicating client side validayion done
	frm.vflag.value="yes";
	//set styles to error message
	document.getElementById("nameErr").innerHtml="";
	document.getElementById("ageErr").innerHtml="";
	document.getElementById("nameErr").style="color:red";
	document.getElementById("ageErr").style="color:red";
	//read form data
	var name=frm.pname.value;
	var age=frm.page.value;
	//perform client side form validations
	if(name=="")//required rule
		{
		document.getElementById("nameErr").innerHtml="Person name is madatory";
		frm.pname.focus();
		return false;
		}
	if(age=="")
		{
		document.getElementById("ageErr").innerHtml="Person age is madatory";
		frm.page.focus();
		return false;
		}
	else
		{
		if(isNaN(age)){
			document.getElementById("nameErr").innerHtml="Person age must be numeric value";
			frm.page.focus();
			frm.page.value="";
			return false;
		}
			
		}
	return true;
	
	}