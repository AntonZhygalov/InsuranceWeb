<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="jquery-1.11.0.js"></script>
<script type="text/javascript" src="chosen.jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  .custom-combobox {
    position: relative;
    display: inline-block;
  }
  .custom-combobox-toggle {
    position: absolute;
    top: 0;
    bottom: 0;
    margin-left: -1px;
    padding: 0;
  }
  .custom-combobox-input {
    margin: 0;
    padding: 5px 10px;
  }
  </style>
  <script>
  (function( $ ) {
    $.widget( "custom.combobox", {
      _create: function() {
        this.wrapper = $( "<span>" )
          .addClass( "custom-combobox" )
          .insertAfter( this.element );
 
        this.element.hide();
        this._createAutocomplete();
        this._createShowAllButton();
      },
 
      _createAutocomplete: function() {
        var selected = this.element.children( ":selected" ),
          value = selected.val() ? selected.text() : "";
 
        this.input = $( "<input>" )
          .appendTo( this.wrapper )
          .val( value )
          .attr( "title", "" )
          .addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
          .autocomplete({
            delay: 0,
            minLength: 0,
            source: $.proxy( this, "_source" )
          })
          .tooltip({
            tooltipClass: "ui-state-highlight"
          });
 
        this._on( this.input, {
          autocompleteselect: function( event, ui ) {
            ui.item.option.selected = true;
            this._trigger( "select", event, {
              item: ui.item.option
            });
          },
 
          autocompletechange: "_removeIfInvalid"
        });
      },
 
      _createShowAllButton: function() {
        var input = this.input,
          wasOpen = false;
 
        $( "<a>" )
          .attr( "tabIndex", -1 )
          .attr( "title", "Show All Items" )
          .tooltip()
          .appendTo( this.wrapper )
          .button({
            icons: {
              primary: "ui-icon-triangle-1-s"
            },
            text: false
          })
          .removeClass( "ui-corner-all" )
          .addClass( "custom-combobox-toggle ui-corner-right" )
          .mousedown(function() {
            wasOpen = input.autocomplete( "widget" ).is( ":visible" );
          })
          .click(function() {
            input.focus();
 
            // Close if already visible
            if ( wasOpen ) {
              return;
            }
 
            // Pass empty string as value to search for, displaying all results
            input.autocomplete( "search", "" );
          });
      },
 
      _source: function( request, response ) {
        var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
        response( this.element.children( "option" ).map(function() {
          var text = $( this ).text();
          if ( this.value && ( !request.term || matcher.test(text) ) )
            return {
              label: text,
              value: text,
              option: this
            };
        }) );
      },
 
      _removeIfInvalid: function( event, ui ) {
 
        // Selected an item, nothing to do
        if ( ui.item ) {
          return;
        }
 
        // Search for a match (case-insensitive)
        var value = this.input.val(),
          valueLowerCase = value.toLowerCase(),
          valid = false;
        this.element.children( "option" ).each(function() {
          if ( $( this ).text().toLowerCase() === valueLowerCase ) {
            this.selected = valid = true;
            return false;
          }
        });
 
        // Found a match, nothing to do
        if ( valid ) {
          return;
        }
 
        // Remove invalid value
        this.input
          .val( "" )
          .attr( "title", value + " didn't match any item" )
          .tooltip( "open" );
        this.element.val( "" );
        this._delay(function() {
          this.input.tooltip( "close" ).attr( "title", "" );
        }, 2500 );
        this.input.autocomplete( "instance" ).term = "";
      },
 
      _destroy: function() {
        this.wrapper.remove();
        this.element.show();
      }
    });
  })( jQuery );
 
  $(function() {
    $( "#combobox" ).combobox();
    $( "#toggle" ).click(function() {
      $( "#combobox" ).toggle();
    });
  });
  </script>
<script>

	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});

	});
</script>
<link rel="stylesheet" href="/resources/demos/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="z"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="h"%>
<style type="text/css">
body {
	background-color: #E0F2F7;
}

.dropdown {
	margin-bottom: 20px;
}
</style>
<body>
	<form action="insertTafiff" method="post">
		<h2>Input Data</h2>
		<div class="dropdown">
			<p>program</p>
			<select name="program" class="btn btn-default dropdown-toggle">
				<c:forEach var="program" items="${programs}">
					<option value="${program.id}">${program.program}</option>
				</c:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>franchise</p>
			<select name="franchise" class="btn btn-default dropdown-toggle">
				<a:forEach var="franchise" items="${franchises}">
					<option value="${franchise.id}">${franchise.sumFranchise}</option>
				</a:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>zone</p>
			<select name="zone" class="btn btn-default dropdown-toggle">
				<s:forEach var="zone" items="${zones}">
					<option value="${zone.id}">${zone.zone}</option>
				</s:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>additionalConditions</p>
			<select name="additionalConditions"
				class="btn btn-default dropdown-toggle">
				<z:forEach var="additionalConditions"
					items="${additionalConditions}">
					<option value="${additionalConditions.id}">${additionalConditions.additionalConditions}</option>
				</z:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>insuranceAmount</p>
			<select name="insuranceAmount"
				class="btn btn-default dropdown-toggle">
				<x:forEach var="insuranceAmount" items="${insuranceAmounts}">
					<option value="${insuranceAmount.id}">${insuranceAmount.sumInsurance}</option>
				</x:forEach>
			</select>
		</div>



		<!-- 		<div class="input"> -->
		<!-- 			<p>limitDay</p> -->
		<!-- 			<p> -->
		<!-- 				<input type="text" name="limitDay" required pattern="^[ 0-9]+$"> -->
		<!-- 			</p> -->
		<!-- 		</div> -->



		<div class="dropdown">
			<p>limitDay</p>
			<select name="limitDay" class="btn btn-default dropdown-toggle">

				<option value="5">5</option>
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="40">40 multy</option>
				<option value="60">60 multy</option>
				<option value="90">90 multy</option>
				<option value="120">120 multy</option>
				<option value="160">160 multy</option>
				<option value="180">180 multy</option>
				<option value="360">360 multy</option>

			</select>
		</div>





		<div class="input">
			<p>date :</p>
			<p>
				<input type="text" id="datepicker" name="date" required>
			</p>
		</div>
		
		<div class="ui-widget">
			<p>Persons</p>
	<select name="person"  id="combobox">
    <h:forEach var="person" items="${persons}">
					<option value="${person.id}">${person.fNamelName}</option>
				</h:forEach>
</select>
</div>
					<!-- 		<div class="input"> -->
					<!-- 			<p>person</p> -->
					<!-- 			<p> -->
					<!-- 				<input type="text" name="person" required pattern="^[ 0-9]+$"> -->
					<!-- 			</p> -->
					<!-- 		</div> -->
					
					<div class="input">
						<button type="submit">Submit</button>
					</div>
	</form>



</body>
</html>