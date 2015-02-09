var express = require('express');
var router = express.Router();
var mongoose= require("mongoose");



router.get('/', function(req, res) {

   	var db = req.db;
	var collection= db.get('productcollection');
	collection.find({},{},function(e, documents)
	{
		res.render('TV',{title: 'TV page',"tv":documents});

	});
});

router.get('/TV1', function(req, res) {
	
   	var db = req.db;
	var collection= db.get('productcollection');
	collection.find({},{},function(e, documents)
	{
		res.render('TV1',{title: 'TV page',"tv":documents});

	});
});

