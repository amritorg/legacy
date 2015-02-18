
// Example to populate the database tables

var db;

function populatedb () {
	
	// Wait for application to load
	
	 document.addEventListener("deviceready", onDeviceReady, false);
    function onDeviceReady() {
    db = window.openDatabase("PersonalTimeManagementDB", "1.0", "PTM POC", 200000);
    db.transaction(populateTables, errorCB, successCB);
    }
}

// // Pupulate database tables


function populateTables(tx) {

var sql1 = "INSERT INTO location (id,locationName,lat,lng,radius ) VALUES (0,'Work','49.277140','-123.118022','20')";

tx.executeSql(sql1);	

var sql2 = 	"INSERT INTO visit (id,locid,start_time,duration) VALUES (0,1,'2013-04-11 14:26:00','1hr')";

tx.executeSql(sql2);
		
}

// Transaction error callback
    
    function errorCB(err) {
        console.log("Error processing SQL: "+err);
    }

    // Transaction success callback
    
    function successCB() {
        console.log("success populatedb");
    }





