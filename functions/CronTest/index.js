const catalyst = require('zcatalyst-sdk-node');

module.exports = (cronDetails, context) => {

    let cronParams = cronDetails.getCronParam("name");
	if(typeof cronParams === 'undefined'){
		cronParams = 'DefaultName';
	}

    const catalystApp = catalyst.initialize(context);

	//Get Segment instance with segment ID (If no ID is given, Default segment is used)
	let segment = catalystApp.cache().segment();
	//Insert Cache using put by passing the key-value pair.
	segment.put("Name", cronParams.toString())
		.then((cache) => {
			console.log("\nInserted Cache : " + JSON.stringify(cache));
			segment.get("Name").then((result) => {
                console.log("Got value : " + result);
                context.closeWithSuccess();
            });
		})
		.catch((err) => {
			console.log(err);
			context.closeWithFailure();
		});

}