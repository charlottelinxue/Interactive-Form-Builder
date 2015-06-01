/*
* Author: Qianwen Li
* Date: 5/28/2015
*/

$(document).ready(function() {

	// date
	var d = new Date();
	var month = d.getMonth()+1;
	var day = d.getDate();

	var rev_date = "Rev. " + (month<10 ? '0' : '') + month + '/' +
    (day<10 ? '0' : '') + day + '/' + d.getFullYear(); 
    $("p#rev_date").text(rev_date);

	// institute
	if (localStorage.getItem('institute')) {
    	var institute = localStorage.getItem('institute');
    	console.log("institute = " + institute);
    	$("h2#institute-name").text(institute);
    	$("th#rating").text(institute + " Rating");
    	$("h3#whatdoque").text("What does " + institute +  " do with your Personal Information?");
    	$("div#how").text("All financial companies need to share customers personal information to run their everyday business. In the next section, we list the reasons  why  financial companies can share their customers personal information; the reasons "+ institute + " chooses to share; and whether you can limit this sharing.");
    	$("th#shareque").text("Does "+ institute + " Share?");
    	$("p#footerp").append(institute + " " + d.getFullYear());
    	document.title = institute + " | U.S. Consumer Privacy Notice";
   

    }

    // whatinfo
    if (localStorage.getItem('whatinfo')) {
    	var whatinfo = localStorage.getItem('whatinfo');
    	console.log("wahtinfoarr = " + whatinfo);

    	$("ul#whatinfocheck").html("<li>" + whatinfo + "</li>");

    }

    var rating2 = "";
    // sharing2
    if (localStorage.getItem('sharing2')) {
    	var sharing2 = localStorage.getItem('sharing2');
    	rating2 += sharing2 + ",";
    	$("td#sharing2").append(sharing2);
    }
    // optout2
    var optout2 = "";
    if (localStorage.getItem('optout2')) {
    	optout2 = localStorage.getItem('optout2');
    	rating2 += optout2;
    	$("td#optout2").append(optout2);
    	
    }
    $("td#rating2").text(rating2);


    var rating3 = "";
    // sharing3
    if (localStorage.getItem('sharing3')) {
    	var sharing3 = localStorage.getItem('sharing3');
    	rating3 += sharing3 + ",";
    	$("td#sharing3").append(sharing3);
    }
    // optout3
    var optout3 = ""; 
    if (localStorage.getItem('optout3')) {
    	optout3 = localStorage.getItem('optout3');
    	rating3 += optout3;
    	$("td#optout3").append(optout3);
    	
    }
    $("td#rating3").text(rating3);

    var rating4 = "";
    // sharing4
    if (localStorage.getItem('sharing4')) {
    	var sharing4 = localStorage.getItem('sharing4');
    	rating4 += sharing4 + ",";
    	$("td#sharing4").append(sharing4);
    }
    // optout4
    var optout4 = ""; 
    if (localStorage.getItem('optout4')) {
    	optout4 = localStorage.getItem('optout4');
    	rating4 += optout4;
    	$("td#optout4").append(optout4);
    	
    }
    $("td#rating4").text(rating4);

    // sharing5
    if (localStorage.getItem('sharing5')) {
    	var sharing5 = localStorage.getItem('sharing5');
    	$("td#sharing5").append(sharing5);
    }
    // optout5
    var optout5 = "";
    if (localStorage.getItem('optout5')) {
    	optout5 = localStorage.getItem('optout5');
    	$("td#optout5").append(optout5);
    	
    }

    var rating6 = "";
	// sharing6
    if (localStorage.getItem('sharing6')) {
    	var sharing6 = localStorage.getItem('sharing6');
    	rating6 += sharing6 + ",";
    	$("td#sharing6").append(sharing6);
    }
    // optout6
    var optout6 = "";
    if (localStorage.getItem('optout6')) {
    	optout6 = localStorage.getItem('optout6');
    	rating6 += optout6;
    	$("td#optout6").append(optout6);
    	
    }
    $("td#rating6").text(rating6);

    var rating7 = "";
    // sharing7
    if (localStorage.getItem('sharing7')) {
    	var sharing7 = localStorage.getItem('sharing7');
    	rating7 += sharing7 + ",";
    	$("td#sharing7").append(sharing7);
    }
    // optout7
    var optout7 = "";
    if (localStorage.getItem('optout7')) {
    	optout7 = localStorage.getItem('optout7');
    	rating7 += optout7;
    	$("td#optout7").append(optout7);
    	
    }
    $("td#rating7").text(rating7);


    // set the sharing link or disable
    if (optout2 == "Yes" || optout3 == "Yes" || optout4 == "Yes" || optout5 == "Yes" ||
    	optout6 == "Yes" || optout7 == "Yes") {
    	$("button#send_sharing").prop("disabled",false);
    	// apply
    	if (localStorage.getItem('apply')) {
    	var apply = localStorage.getItem('apply');
    	$("td#accountorpolicy").html(apply);
    }

    } else {
    	$("button#send_sharing").prop("disabled",true);
    	$("td#accountorpolicy").html("No optout options available!");
    	$("")
    	$("a#send_link").click(function(){
    		return false;
		});
    }


    // phone
    if (localStorage.getItem('phone')) {
    	var phone = localStorage.getItem('phone');
    	$("li#sharephone").text("Call toll free " + phone + " - Our menu will promt you through your choices, or");
    	$("p#otherphone").text(phone);

    }

    // web
    if (localStorage.getItem('web')) {
    	var web = localStorage.getItem('web');
    	$("a#shareweb").attr('href', web);
    	$("a#shareweb").html(web);
    	$("a#otherweb").attr('href', web);
    	$("a#otherweb").html(web);
    }

    // othermethods
    if (localStorage.getItem('othermethods')) {
    	var othermethods = localStorage.getItem('othermethods');
    	$("li#othermethods").html(othermethods);
    } else {
    	$("li#othermethods").css("style", "display: none");
    }

    // direct contact
    if (localStorage.getItem('direct_contact')) {
    	var direct_contact = localStorage.getItem('direct_contact');
    	$("li#direct_contact").text(direct_contact);
    }

    // email
    if (localStorage.getItem('email')) {
    	var email = localStorage.getItem('email');
    	$("li#email").html("Email: <a href='mailto:"+ email + "'>" + email + "</a>");
  
    }

    // address
    if (localStorage.getItem('address')) {
    	var address = localStorage.getItem('address');
    	$("li#mailladd").text("Mailing address: " + address);
    }

    // legal entity name -- legalname
    if (localStorage.getItem('legalname')) {
    	var legalname = localStorage.getItem('legalname');
    	$("td#legalname").append(legalname);
    	$("td#protectQue").text("How does " + legalname + " protect your personal information? ");
    	$("td#collectQue").text("How does " + legalname + " collect your personal information? ");
    }

    // measures
    if (localStorage.getItem('measures')) {
    	var measures = localStorage.getItem('measures');
    	$("ul#measures").append("<li>" + measures + "</li>");
    }

    // how
    if (localStorage.getItem('how')) {
    	var how = localStorage.getItem('how');
    	console.log("how = " + how);

    	$("ul#howColl").html("<li>" + how + "</li>");

    }

    // affiliate
    if (localStorage.getItem('affiliate')) {
    	var affiliate = localStorage.getItem('affiliate');
    	$("li#affiliate").append("<i>" + affiliate + "</i>");

    }

    // naffiliate
    if (localStorage.getItem('naffiliate')) {
    	var naffiliate = localStorage.getItem('naffiliate');
    	$("li#naffiliate").append("<i>" + naffiliate + "</i>");
    }

    // nonaffiliates
    if (localStorage.getItem('nonaffiliates')) {
    	var nonaffiliates = localStorage.getItem('nonaffiliates');
    	$("li#nonaffiliatesjoin").append("<i>" + nonaffiliates + "</i>");

    }

    // receipt
    if (localStorage.getItem('receipt')) {
    	var receipt = localStorage.getItem('receipt');
    	$("a#receiptlink").attr('href', receipt);
    }

    // business
    if (localStorage.getItem('business')) {
    	var business = localStorage.getItem('business');

    }

    // states and law
    if (localStorage.getItem('states')) {
    	var states = localStorage.getItem('states');
    	$("td#stateslaw").append(states);
    	$("p#referother").html("State laws and individual companies may give you additional rights to limit sharing. See <a href=\"#Other\">Other Important Information</a> for more on your rights under state law.");

    } else {
    	$("td#stateslaw").append("No other state and/or foreign regulations");
    }

    // collection
    if (localStorage.getItem('collection')) {
    	var collection = localStorage.getItem('collection');
    	$("li#collection").text(collection);
    }

    // expireday
    if(localStorage.getItem('expireday')) {
    	var expireday = localStorage.getItem('expireday');
    	$("p#expireday").text(expireday);
    }
    
    // mailin
    if (localStorage.getItem('mailin')) {
    	var mailin = localStorage.getItem('mailin');
    	console.log("mailin = " + mailin);
	    	if (mailin == "Yes") {
	    		console.log("mailin YES!");
	    		$("<li>Mail in a <a id=\"send_link\" href=\"mailin.html\">form</a>.</li>").insertAfter("li#visitus");
	    	}
    }
});


