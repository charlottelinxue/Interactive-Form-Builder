/**
 * Author: Qianwen Li
 * Date: 5/28/2015
 * 
 */

 $(document).ready(function() {

	// institute
	if (localStorage.getItem('institute')) {
		var insitute_name = localStorage.getItem('institute');
		console.log("insitute_name = " + insitute_name);
		$("h3#institute").text(insitute_name);
	}

	// email
	if (localStorage.getItem('email')) {
		var email = localStorage.getItem('email');
		$("input#company_email").val(email);
		console.log("email = " + $("input#company_email").val());
	}

    // optout2
    if (localStorage.getItem('optout2') == "Yes") {
    	console.log("i'm in optout2");
    	$("tbody#opt_form").append("<tr><td></span>For our Marketing Purposes</td><input type=\"hidden\" name=\"opt2\" value=\"For our Marketing Purposess\"><td><select name=\"select2\" class=\"form-control\" required><option></option><option>Yes</option><option>No</option></td></tr>");
    }

    // optout3
    if (localStorage.getItem('optout3') == "Yes") {
    	console.log("i'm in optout3");
    	$("tbody#opt_form").append("<tr><td></span>For joint marketing with other financial companies</td><input type=\"hidden\" name=\"opt3\" value=\"For joint marketing with other financial companies\"><td><select name=\"select3\" class=\"form-control\" required><option></option><option>Yes</option><option>No</option></td></tr>");
    }

    // optout4
    if (localStorage.getItem('optout4') == "Yes") {
    	console.log("i'm in optout4");
    	$("tbody#opt_form").append("<tr><td></span>For our affiliates everyday business purposes - Transactions and experiences</td><input type=\"hidden\" name=\"opt4\" value=\"For our affiliates everyday business purposes - Transactions and experiences\"><td><select name=\"select4\" class=\"form-control\" required><option></option><option>Yes</option><option>No</option></td></tr>");
    }

    // optout5
    if (localStorage.getItem('optout5') == "Yes") {
    	console.log("i'm in optout5");
    	$("tbody#opt_form").append("<tr><td></span>For our affiliates everyday business purposes - Creditworthiness</td><input type=\"hidden\" name=\"opt5\" value=\"For our affiliates everyday business purposes - Creditworthiness\"><td><select name=\"select5\" class=\"form-control\" required><option></option><option>Yes</option><option>No</option></td></tr>");
    }

    // optout6
    if (localStorage.getItem('optout6') == "Yes") {
    	console.log("i'm in optout6");
    	$("tbody#opt_form").append("<tr><td></span>Apply changes to Joint Accounts (If applicable)</td><input type=\"hidden\" name=\"opt6\" value=\"Apply changes to Joint Accounts (If applicable)\"><td><select name=\"select6\" class=\"form-control\" required><option></option><option>To everyone</option><option>Only me</option><option>Does not Apply</option></td></tr>");
    }

    // optout7
    if (localStorage.getItem('optout7') == "Yes") {
    	console.log("i'm in optout7");
    	$("tbody#opt_form").append("<tr><td></span>For our affiliates to market to you</td><input type=\"hidden\" name=\"opt7\" value=\"For our affiliates to market to you\"><td><select name=\"select7\" class=\"form-control\" required><option></option><option>Yes</option><option>No</option></td></tr>");
    }

});


