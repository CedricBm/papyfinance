$(function() {
  $('.button-collapse').sideNav();
  $('select').material_select();
});

$(document).ready(function() {
$('#champsDate').hide(); 

$('select[name="onegociationMode"]').change(function() {
var valeur = $(this).val(); 
 
    if(valeur != '') { 
        if(valeur == '2') { 
            $('#champsDate').show();
        } else {
            $('#champsDate').hide();           
        }
    }
});

});