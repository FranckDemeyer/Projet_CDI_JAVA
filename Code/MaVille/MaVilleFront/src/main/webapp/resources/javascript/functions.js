/* jslint browser:true*/
/*global jQuery, navigator, console, alert, google*/
(function () {
    'use strict';

    var jq = jQuery.noConflict();

    function inverseGeocoding() {
        var latLng = new google.maps.LatLng({lat: parseFloat(jq(".lat").val()), lng: parseFloat(jq(".lng").val()) }),
            geocoder = new google.maps.Geocoder();
        geocoder.geocode({'location': latLng}, function (results, status) {
            if (status === 'OK') {
                if (results[0]) {
                    console.log(results[0].formatted_address);
                    var address = results[0].formatted_address.split(",");
                    jq(".address").val(address[0]);
                    jq(".postcode").val(address[1].split(" ")[1]);
                    jq(".town").val(address[1].split(" ")[2]);
                }
            }
        });
    }

    function showPosition(position) {
        jq(".lat").val(position.coords.latitude);
        jq(".lng").val(position.coords.longitude);
        inverseGeocoding();
    }

    function locate() {
        var loc = navigator.geolocation;
        if (loc) {
            loc.getCurrentPosition(showPosition);
        }
    }

    function geocoding() {
        var address = jq(".address").val() + ", " + jq(".postcode").val() + " " + jq(".town").val(),
            geocoder = new google.maps.Geocoder();
        geocoder.geocode({'address': address}, function (results, status) {
            if (status === 'OK') {
                jq(".lat").val(results[0].geometry.location.lat());
                jq(".lng").val(results[0].geometry.location.lng());
            }
        });
    }

    jq("document").ready(function () {
        jq("body")
            .on("click", ".pro_location", function (ev) {
                ev.preventDefault();
                locate();
                return false;
            })
            .on("blur", ".town", function (ev) {
                ev.preventDefault();
                geocoding();
                return false;
            })
            .on("blur", ".lng", function (ev) {
                ev.preventDefault();
                if (jq(".lat").val() !== "" && jq(".lng").val() !== "") {
                    inverseGeocoding();
                } else {
                    alert("Vous devez spécifié soit une adresse, soit des coordonnées GPS, vous pouvez cilquer sur Me localiser pour accéder à votre position.");
                }
            });
    });
}());
