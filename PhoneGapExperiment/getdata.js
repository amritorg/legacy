
// Example to get the data


var db;

function getdata () {
	
	// Wait for application to load
	
	document.addEventListener("deviceready", onDeviceReady, false);
    function onDeviceReady() {
    db = window.openDatabase("PersonalTimeManagementDB", "1.0", "PTM POC", 200000);
    db.transaction(queryDB, errorCB, successCB);
    }
}

 // Query the database      

        function queryDB(tx) {

            tx.executeSql("SELECT * FROM location", [], querySuccess, errorCB);

}


// Query success callback       

        function querySuccess(tx, results) {

            var len = results.rows.length;

            console.log("Location table: " + len + " rows found.");

           for (var i = 0; i < len; i++) {

              console.log("Row = " + i + " ID = " + results.rows.item(i).id + " LocationName =  " + results.rows.item(i).locationName +  " Latitude =  " + results.rows.item(i).lat + " Longtitude =  " + results.rows.item(i).lng + " Radius= " + results.rows.item(i).radius);

            }

        }


 // Transaction error callback

        function errorCB(err) {

            console.log("Error processing SQL: " + err.code);

        }

function successCB() {
        console.log("success");
    }







