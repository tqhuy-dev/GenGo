const FoodStoreModel = require('../model/FoodStoreModel');
const Constant = require('../common/constant');
const Promise = require('bluebird');

class FoodStoreDatabase {
    getAllData(){
        var rejection = {
            menu:false
        }
        return new Promise((resolve , reject) =>{
            FoodStoreModel.find({} ,rejection, (error , result) =>{
                if(error){
                    reject(error);
                } else {
                    resolve(result)
                }
            })
        })
    }
}

module.exports = FoodStoreDatabase;