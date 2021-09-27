<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
	var subjectObject = {
		"1st year" : {
			"1st SEM" : [ "Physics", "Maths", "Chemistry", "Economics" ],
			"2nd SEM" : [ "Physics", "Maths2", "Chemistry2", "machanics" ],
		},
		"2nd year" : {
			"3rd SEM" : [ "C++", "Core JAVA", "Python" ],
			"4th SEM" : [ "English", "Design patterns", "Data Structure" ]
		},

		"3rd year" : {
			"5th SEM" : [ "computer networks", "IOT", "Algorithms" ],
			"6th SEM" : [ "C++ advance", "JAVA advance", "Networking2" ]
		},

		"4th year" : {
			"7th SEM" : [ "Cloud computing", "Design patterns", "Cyber security" ],
			"8th SEM" : [ "Ethics", "Data structure", "Cyber security" ]
		}
	}
	window.onload = function() {
		var subjectSel = document.getElementById("Years");
		var topicSel = document.getElementById("topic");
		var chapterSel = document.getElementById("chapter");
		for ( var x in subjectObject) {
			subjectSel.options[subjectSel.options.length] = new Option(x, x);
		}
		
		subjectSel.onchange = function() {
			//empty Chapters- and Topics- dropdowns
			chapterSel.length = 1;
			topicSel.length = 1;
			//display correct values
			for ( var y in subjectObject[this.value]) {
				topicSel.options[topicSel.options.length] = new Option(y, y);
			}
		}
		
		topicSel.onchange = function() {
			//empty Chapters dropdown
			chapterSel.length = 1;
			//display correct values
			var z = subjectObject[subjectSel.value][this.value];
			for (var i = 0; i < z.length; i++) {
				chapterSel.options[chapterSel.options.length] = new Option(
						z[i], z[i]);
			}
		}
	}
</script>
</head>
<body>

	<h1>Cascading Dropdown Example</h1>

	<form name="form1" id="form1" action="/add-subject-post1">
		Subjects: <select name="subject" id="subject">
			<option value="" selected="selected">Select Years</option>
		</select> <br>
		<br> Topics: <select name="topic" id="topic">
			<option value="" selected="selected">Please select Semesters
				</option>
		</select> <br>
		<br> Chapters: <select name="chapter" id="chapter">
			<option value="" selected="selected">Please select Subjects
				</option>
		</select> <br>
		<br> <input type="submit" value="Submit">
	</form>


<!-- <!--  -->
	
	
	
<!--  -->

</body>
</html>

<!-- https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_cascading_dropdown -->
