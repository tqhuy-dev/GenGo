const mongoose = require('mongoose');

const UserSchema = mongoose.Schema({
    _id:mongoose.Schema.Types.ObjectId,
    account:String,
    password: String,
    firstName: String,
    lastName: String,
    point: Number,
    pointWeek: Number,
    history:[
        {
            storeName:String,
            storeID: String,
            bookingDate: String,
            price:String,
            point:Number,
            menu:[
                {
                    foodName: String,
                    price:Number,
                    point: Number
                }
            ]
        }
    ],
    friendList:[
        {
            friendName:String,
            friendAccount: String
        }
    ]
},{versionKey:false})

module.exports = mongoose.model('User',UserSchema , 'User');