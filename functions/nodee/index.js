const catalyst = require('zcatalyst-sdk-node');

module.exports = (context, basicIO) => {

	const catalystApp = catalyst.initialize(context);

	//Get Segment instance with segment ID (If no ID is given, Default segment is used)
	let data_store = catalystApp.datastore();
	let rowData = 
    { 
        intt: 1
    };
let table = data_store.table('rows300');
for(var i=0;i<24;i++){
    let insertPromise = table.insertRow(rowData);
}
}