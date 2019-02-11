const express = require('express');
const router = express.Router();
const FoodStoreDatabase = require('../database/FoodStoreCollection');
const constant = require('../common/constant');
const ApiResponse = require('../business/ApiResponse');

const foodStoreDB = new FoodStoreDatabase();
const apiResponse = new ApiResponse();

router.get('/', (req , res , next) =>{
    foodStoreDB.getAllData().then((result) =>{
        res.status(200).json(apiResponse.ResponseWithData(result));
    }).catch((error) =>{
        res.status(401).json(apiResponse.ResponseQueryFail(error));
    })


})

module.exports = router;