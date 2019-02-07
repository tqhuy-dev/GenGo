const QUERY_ERROR_MESSAGE = {
    statusCode: 404,
    message: "Query Fail"
}

function ResponseMessage(isError,message){
    return {
        statusCode:isError?402:200,
        message:message
    }
}

module.exports = {
    QUERY_ERROR_MESSAGE: QUERY_ERROR_MESSAGE,
    ResponseMessage: ResponseMessage
}