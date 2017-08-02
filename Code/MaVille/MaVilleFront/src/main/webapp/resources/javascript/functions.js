/* jslint browser:true*/
/*global $, navigator, console, google*/
(function () {
    'use strict';

    function inverseGeocoding() {
        var latLng = new google.maps.latLng({lat: $(".lat").val(), lng: $(".lng").val() }),
            geocoder = new google.maps.Geocoder();
        geocoder.geocode({'location': latLng}, function (results, status) {
            if (status === 'OK') {
                if (results[0]) {
                    console.log(results.formatted_address);
                }
            }
        });
    }

    function showPosition(position) {
        $(".lat").val(position.coords.latitude);
        $(".lng").val(position.coords.longitude);
        inverseGeocoding();
    }

    function locate() {
        var loc = navigator.geolocation;
        if (loc) {
            loc.getCurrentPosition(showPosition);
        }
    }

    function geocoding() {
        var address = $(".address").val() + ", " + $(".postcode").val() + " " + $(".town").val(),
            geocoder = new google.maps.Geocoder();
        geocoder.geocode({'address': address}, function (results, status) {
            if (status === 'OK') {
                $(".lat").val(results[0].geometry.location.lat());
                $(".lng").val(results[0].geometry.location.lng());
            }
        });
    }

    $("document").ready(function () {
        $("body").on("click", "#pro_location", function (ev) {
            ev.preventDefault();
            locate();
            return false;
        });
        $("body").on("blur", ".town", function (ev) {
            ev.preventDefault();
            geocoding();
            return false;
        });
    });
}());
