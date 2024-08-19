const catalyst = require('zcatalyst-sdk-node');

module.exports = (context, basicIO) => {

	const catalystApp = catalyst.initialize(context);

	let name = basicIO.getArgument("name");
	if(typeof name === 'undefined'){
		name = 'DefaultName';
	}

	//Get Segment instance with segment ID (If no ID is given, Default segment is used)
	let segment = catalystApp.cache().segment(1926000006929756);
	//Insert Cache using put by passing the key-value pair.
	segment.put("Name", name, 1)
		.then((cache) => {
			context.log("\nInserted Cache : " + JSON.stringify(cache));
			segment.get("Name").then((result) => {
                context.log("Got value : " + result);
				basicIO.write(JSON.stringify(result));
				context.close();
            });
		})
		.catch((err) => {
			context.log(err);
			basicIO.write(err.toString());
			context.close();
		});

}