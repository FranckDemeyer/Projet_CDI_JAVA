#! usr/bin/env node
/*jslint node:true nomen:true*/
'use strict';
/** définition des inclusions */
var bodyParser = require('body-parser'),
    express = require('express'),
    app = express();
/** DEBUT DU CODE PRINCIPAL */
app
    .use(bodyParser.json())
    .use(bodyParser.urlencoded({extended: false}))
    .get('', function (req, res) {
        console.log(req + res);
    })
    .listen(8081, function () {console.log("Serveur connecté et en ecoute sur le port 8081"); });
