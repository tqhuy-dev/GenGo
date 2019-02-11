const mongoose = require('mongoose');

const FoodStoreSchema = mongoose.Schema({
    _id:mongoose.Schema.Types.ObjectId,
    storeName: String,
    Address: String,
    ratePoint: Number,
    status:Number,
    booking: Number,
    bookingOnWeek: Number,
    menu:[]
});

module.exports = mongoose.model('StoreFood' , FoodStoreSchema , 'StoreFood');