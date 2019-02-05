const express = require('express');
const app = express();
const fs = require('fs');
const mongoose = require('mongoose')
const morgan = require('morgan')
const bodyParser = require('body-parser')
const cors = require('cors')
//connect mLab Database
// mongoose.connect('mongodb://tqhuy:Husky12345@ds153709.mlab.com:53709/database-test',{
//     useNewUrlParser :true
// })

//connect robo3T database 
// mongoose.connect(constant.BASE_URL_DATABASE + constant.DATABASE_NAME,{
//     useNewUrlParser :true
// })

// initialize morgan,cors and bodyParser
app.use(morgan('dev'))
app.use(cors());
app.use(bodyParser.urlencoded({ extended: false}))
app.use(bodyParser.json())

app.use((req, res, next) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header(
      "Access-Control-Allow-Headers",
      "Origin, X-Requested-With, Content-Type, Accept, Authorization"
    );
    if (req.method === "OPTIONS") {
      res.header("Access-Control-Allow-Methods", "PUT, POST, PATCH, DELETE, GET");
      return res.status(200).json({});
    }
    next();
  });

// test api active
app.get('/api/v1/data/gengo' , (req , res , next) =>{
    res.status(200).json({
        message:'api is working',
        status:'success'
    })
});

// set api router

// initialize handle error
app.use((req , res , next) => {
    next(constant.ERROR_MESSAGE_404)
})

app.use((error , req , res , next) =>{
    res.status(error.status || 404);
    res.json({
        message : error.message
    })
})

module.exports = app;