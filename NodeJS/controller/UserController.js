const express = require('express');
const router = express.Router();
const User = require('../database/UserCollection');

const user = new User();

router.post('/signin' , (req , res , next) =>{
    user.signin(req).then((result) =>{
        res.status(200).json(result);
    }).catch((error) =>{
        res.status(401).json(error);
    })
})

router.post('/login' , (req , res , next) =>{
    user.login(req).then((result) =>{
        res.status(200).json(result);
    }).catch((error) =>{
        res.status(401).json(error);
    })
})

router.get('test' , (req , res , next) =>{

})

module.exports = router;