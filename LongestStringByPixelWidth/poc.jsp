<%@ page language = "java" %>
<%@ page session  = "true" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
	<%   
   
    response.setCharacterEncoding("UTF-8");   
%> 

<!DOCTYPE HTML>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   

    <style>
      body {
        margin: 0px;
        padding: 0px;
      }
    </style>
 

 </head>
  <body>
    
	
	<canvas id="myCanvas" width="578" height="200"></canvas>
    <script>

var filelist = [
<%

String dir = "C:\\Test";
ArrayList<String>  jfilelist = new ArrayList<String>();
boolean flag = false; 
File f = null;

  try {
   f = new File(dir);
   flag = f.isDirectory();   
    
  } catch (Exception e) {
     out.println(dir+ " Not Found");
    }

	
   if (flag) {

     boolean begin = true;
	 String[] fs = f.list();
	 String filename = null;
	 
      for (int i = 0; i < fs.length; i++)   {
          File idir = new File(fs[i]);
		  if (idir.isDirectory()) {
             out.println("Change dir structure");
          }
          else{

            filename = idir.getName();  
            jfilelist.add(filename);			
         }

		if (begin) {

		  begin=false;
		
        } else {

        %>,<%
          }
         %>"<%=filename%>"<%		  
		 
      }
                

   }



%>
	];
	
console.log(filelist);
 
	
var result0 = [];
var result1 = [];
	
	
	
<%
	 for(int j =0; j < jfilelist.size(); j++) {

%>

	
var strings = [
<%
  
  
  
 //  String fileName = "/test_en.properties";
   String fileName = jfilelist.get(j);
   String fullName = application.getRealPath(fileName);
   BufferedReader reader = null;
   try {
     reader = new BufferedReader(new FileReader(fullName));
   } catch (Exception e) {
     out.println(fileName + " Not Found");
		}
			String line = null;
          boolean first = true;

            
			while ((line = reader.readLine()) != null) {
				
				if (line.startsWith ("#") || line.startsWith ("//"))
                continue;
				
				String[] arr2 = line.split ("=");
				String key = arr2[0].trim ();
				String value = arr2.length > 1 ? arr2[1].trim () : "";
				value = value.replace("\"", "");
				value = value.replaceAll("(\\r|\\n)", "");
             
				if (first) {
					first = false;
				} else {
				%>,<%
					//response.getWriter().write(",");
			}
				%>"<%=value%>"<%
				//response.getWriter().write(value);
   
             }
	
%>	
	];
			

			
//	console.log(strings);
	
	var result = [];
	
	for (var i = 0; i < strings.length; ++i) {
						
			result.push(strings[i]+","+strings[i].length+","+calwidth(strings[i]));									
		
	}

<% 

if( j == 0) {  
%>

result0 = result;
<%
}
%>
<% 
if( j == 1) {  
%>
result1 = result;
<%
}
%>	
	
<%
}
%>
	
console.log(result0.length);
console.log(result1.length);
	
console.log(result0);
console.log(result1);
	
// console.log(result);
//	return result;


	
	
function calwidth (text) {
     var canvas = document.getElementById('myCanvas');
     var context = canvas.getContext('2d');
     var x = canvas.width / 2;
    var y = canvas.height / 2 - 10;
 //   var text = 'Default Settings';
 //var text = document.getElementById('testa').value;

//      context.font = '30pt Calibri';
   context.font = '11px Tahoma,Arial,Helvetica,Clean,Sans-Serif';
    context.textAlign = 'center';
     context.fillStyle = 'blue';
      context.fillText(text, x, y);

      // get text metrics
      var metrics = context.measureText(text);
      var width = metrics.width;
    //  context.font = '10pt Calibri';
   //   context.textAlign = 'center';
    //  context.fillStyle = '#555';
   //   context.fillText('(' + width + 'px wide)' +  + text.length + 'char', x, y + 40);
	  context.clearRect(0, 0, canvas.width, canvas.height);
	//  return   width + 'px wide'  + text.length + 'char';
	return width;
	//return text;
}
	  
    
var array_max_count = maxofcount(result0,result1,result0.length);

var max_count_string = retrieve(array_max_count);
console.log(max_count_string);

var array_max_width = maxofwidth(result0,result1,result0.length);

var max_width_string = retrieve(array_max_width);

console.log(max_width_string);

render(max_count_string,max_width_string); 

function retrieve(foutput) {
var tmpstring = [];

for (var pos in foutput){
	var tmpcomma;
	// document.write ( "<br>");
		
	if (foutput[pos][1] == 0){
		tmpcomma = result0[pos].indexOf(",");
		tmpstring.push(result0[pos].substring(0, tmpcomma));
	}
	else if (foutput[pos][1] == 1){
		tmpcomma = result1[pos].indexOf(",");
		tmpstring.push(result1[pos].substring(0, tmpcomma));
	}
	
		
}

return tmpstring;

}


function render ( ta1, ta2) {


document.write("<h1>Compare longest string by character count and by pixel width</h1>");
document.write("<table border='0'>");

document.write("<tr><td style='width: 400px; color: red;'>Longest String based on character count</td>");
document.write("<td style='width: 50px; color: blue;text-align: middle;'> | </td>");
document.write("<td style='width: 400px; color: red; text-align: right;'>Longest String based on pixel width</td></tr>");
document.write("<tr><td style='width: 400px;'>---------------</td>");
document.write("<td style='width: 50px; text-align: middle;'>-----</td>");
document.write("<td style='width: 400px; text-align: right;'>---------------</td></tr>");

for ( var i=0; i< ta1.length ; i++) {

document.write("<tr><td style='width: 400px;'>" + ta1[i] + "</td>");
document.write("<td style='width: 50px; text-align: middle;'>" + "|" + "</td>");
document.write("<td style='width: 400px; text-align: right;'>" + ta2[i] + "</td></tr>");

}




}





function maxofcount(arr1,arr2,number) {

var res = new Array();

for (var i = 0; i < number; i++)
	{
		var tmparray = new Array(arr1[i], arr2[i]);
	    var secondvar = tmparray.map(function (x) {
			var firstcomma = x.indexOf(",");
			var secondcomma = x.indexOf(",", firstcomma + 1);
			return x.substring(firstcomma + 1, secondcomma);
		})
        var max_of_array = Math.max.apply(Math, secondvar);
		var index_of_max = secondvar.indexOf(max_of_array.toString())
	res[i] = new Array(max_of_array, index_of_max);
	console.log(res[i]);
		
	}	
 return res;

}

function maxofwidth(arr1,arr2,number) {

var res = new Array();

for (var i = 0; i < number; i++)
	{
		var tmparray = new Array(arr1[i], arr2[i]);
	    var secondvar = tmparray.map(function (x) {
			var lastcomma = x.lastIndexOf(",");
			return x.substring(lastcomma + 1);
		})
        var max_of_array = Math.max.apply(Math, secondvar);
		var index_of_max = secondvar.indexOf(max_of_array.toString())
	res[i] = new Array(max_of_array, index_of_max);
	console.log(res[i]);
		
	}	
 return res;

}
	
	
	
	
	</script>

  </body>
</html>







