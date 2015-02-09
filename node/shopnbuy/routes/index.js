var express = require('express');
var router = express.Router();
var mongoose= require("mongoose");
//var routes1 = require('TV');
var url = require('url');




/* GET home page. */
router.get('/', function(req, res) {
  res.render('shopnbuy', { title: 'Shop n Buy' });
});

router.get('/car', function(req, res) {

	var db = req.db;
	var collection= db.get('shopcart');
	//res.render('car', {  });
	collection.find({category:"car"},function(e, documents)
	{

		res.render('car',{title: 'car page',"car":documents});

	});

});





router.get('/TV', function(req, res) {

   	var db = req.db;
	var collection= db.get('shopcart');
	collection.find({category:"tv"},function(e, documents)
	{
		res.render('TV',{title: 'TV page',"tv":documents});

	});
});


router.get('/TV1', function(req, res) {
	
   	var db = req.db;
	var collection= db.get('shopcart');
	var parts=url.parse(req.url,true);
	var temp=parts.query.a;
	collection.find({},{},function(e, documents)
	{
		res.render('TV'+temp,{title: 'TV1 page',"tv":documents,num:temp});

	});
});

router.get('/WirelessRouters', function(req, res) {
   	var db = req.db;
	var collection= db.get('productcollection');
	//res.render('car', {  });
	collection.find({category:"routers"},function(e, documents)
	{

		res.render('WirelessRouters',{title: 'Wireless Routers',"routers":documents});

	});
});






module.exports = router;
