const FoodStoreCollection = require('../database/FoodStoreCollection');
class ApiResponse {
    ResponseWithData(data){
        var message = '';
        if(data.length > 0){
            message = data.length
        } else {
            message = "Data not found"
        }

        return {
            statusCode: 200,
            message: message,
            data: data
        }
    }

    ResponseQueryFail(errorQuery){
        return {
            statusCode:401,
            message: errorQuery
        }
    }
}
module.exports = ApiResponse;