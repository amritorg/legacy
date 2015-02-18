
// Create the local database and required tables 

var db;
var dbCreated = false;


//  Method will create a SQL Lite Databse if not exists and return a Database object


function createLocaldb() {
    
     // Wait for application to load
     
    document.addEventListener("deviceready", onDeviceReady, false);
    
    function onDeviceReady() {
    db = window.openDatabase("PersonalTimeManagementDB", "1.0", "PTM POC", 200000);
    db.transaction(createTables, errorCB, successCB);
    }

}


// Create the database tables


function createTables(tx) {

var sql1 = "CREATE TABLE IF NOT EXISTS location ( "+
		"id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
		"locationName VARCHAR(100), " +
		"lat FLOAT(10,6), " +
		"lng FLOAT(10,6), " +
		"radius FLOAT (10,3))";

tx.executeSql(sql1);	

var sql2 = 	"CREATE TABLE IF NOT EXISTS visit ( "+
		"id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
		"locid INTEGER, " +
		"start_time TIMESTAMP(8), " +
		"duration VARCHAR(20))";

tx.executeSql(sql2);
		
}

// Transaction error callback
    
    function errorCB(err) {
       console.log("Error processing SQL: "+err);
    }

    // Transaction success callback
    
    function successCB() {
   
        dbCreated = true;
        console.log("success create table");
        
    }





