module.exports = (context, basicIO) => {
    
    let name = basicIO.getArgument("name"); // returns QUERY_PARAM[argument1] || BODY_JSON[argument1] (takes argument from query and body, first preference to query)
    
    context.log("Received Name : " + name); //writes logs to catalyst

    basicIO.write("Hello " + name);

    context.close(); //end of application
}