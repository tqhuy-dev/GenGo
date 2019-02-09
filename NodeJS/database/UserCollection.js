const User = require('../model/UserModel');
const Constant = require('../common/constant');
const Promise = require('bluebird');
const mongoose = require('mongoose');
const UUID = require('uuid');

class UserCollection {

    getAllData() {
        return new Promise((resolve, reject) => {
            User.find({}, (error, result) => {
                if (error) {
                    reject(error);
                } else {
                    resolve(result);
                }
            })
        })
    }

    async signin(req) {
        var account = req.body.account;
        var password = req.body.password;
        var firstName = req.body.firstName;
        var lastName = req.body.lastName;

        const isExistence = await this.checkExistAccount(account, password);

        const newUser = new User({
            _id: new mongoose.Types.ObjectId,
            account: account,
            password: password,
            firstName: firstName,
            lastName: lastName,
            point: 0,
            pointWeek: 0,
            history: [],
            friendList: []
        });

        return new Promise((resolve, reject) => {
            if (!isExistence) {
                User.create(newUser, (error, result) => {
                    if (error) {
                        reject(Constant.QUERY_ERROR_MESSAGE)
                    } else {
                        resolve(Constant.ResponseMessage(false, 'Signin success'))
                    }
                })
            } else {
                resolve(Constant.ResponseMessage(true, 'Account is exist'))
            }
        })
    }

    checkExistAccount(account, password) {
        //true = Exist , false = not Exist
        return new Promise((resolve, reject) => {
            User.findOne({
                account: account,
                password: password
            }, (error, result) => {
                if (error) {
                    reject(Constant.QUERY_ERROR_MESSAGE);
                } else {
                    if (result == null) {
                        resolve(false);
                    } else {
                        resolve(true);
                    }
                }
            })
        })
    }

    login(req) {
        var account = req.body.account;
        var password = req.body.password;

        return new Promise((resolve, reject) => {
            User.findOne({
                account: account,
                password: password
            }, (error, result) => {
                if (error) {
                    reject(Constant.QUERY_ERROR_MESSAGE);
                } else {
                    if (result != null) {
                        resolve(Constant.ResponseMessage(false, UUID()));
                    } else {
                        resolve(Constant.ResponseMessage(true, 'Login fail'))
                    }
                }
            })
        })
    }

    getAccountTransactionList(account) {
        return new Promise((resolve, reject) => {
            User.findOne({
                account: account
            }, (error, result) => {
                if (error) {
                    reject(Constant.QUERY_ERROR_MESSAGE);
                } else  {
                    resolve(result.history)
                }
            });
        })

    }
}

module.exports = UserCollection;