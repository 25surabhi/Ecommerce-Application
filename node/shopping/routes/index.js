var express = require('express');
var router = express.Router();
var mongoose= require("mongoose");
var url = require('url');

/* GET home page. */
router.get('/', function(req, res) {
  res.render('shop', { title: 'Shop n Buy' });
});


//code for individual page car,tv n wireless page
router.get('/car', function(req, res) {

	var db = req.db;
	var collection= db.get('shop');
	
	collection.find({Category:"car"},function(e, documents)
	{

		res.render('car',{title: 'Vehicles: Car',"car":documents});

	});

});

router.get('/TV', function(req, res) {

   	var db = req.db;
	var collection= db.get('shop');
	collection.find({Category:"tv"},function(e, documents)
	{
		res.render('TV',{title: 'Appliances: Television',"tv":documents});

	});
});

router.get('/wirelessrouter', function(req, res) {

	var db = req.db;
	var collection= db.get('shop');
	
	collection.find({Category:"wirelessrouter"},function(e, documents)
	{

		res.render('wirelessrouter',{title: 'Routers: Wireless',"wirelessrouter":documents});

	});

});

//for individual detail pages
router.get('/TV1', function(req, res) {
	
   	var db = req.db;
	var collection= db.get('shop');
	var parts=url.parse(req.url,true);
	var temp=parts.query.a;
	collection.find({},{},function(e, documents)
	{
		res.render('TV'+temp,{title: 'Details: Appliances',"tv":documents,num:temp});

	});
});

router.get('/car1', function(req, res) {
	
   	var db = req.db;
	var collection= db.get('shop');
	var parts=url.parse(req.url,true);
	var temp=parts.query.a;
	collection.find({},{},function(e, documents)
	{
		res.render('car'+temp,{title: 'Details: Cars',"car":documents,num:temp});

	});
});

router.get('/wirelessrouter1', function(req, res) {
	
   	var db = req.db;
	var collection= db.get('shop');
	var parts=url.parse(req.url,true);
	var temp=parts.query.a;
	collection.find({},{},function(e, documents)
	{
		res.render('wirelessrouter'+temp,{title: 'Details: Wireless Routers',"wirelessrouter":documents,num:temp});

	});
});

module.exports = router;

