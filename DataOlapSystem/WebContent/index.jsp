<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/WEB-INF/jsp/head.jsp" />

<div class="container">
<div class="row">
<div class="col-lg-5">
	<form>
		<h2>Patient Numbers:</h2>
		<div class="form-inline">
			<label for="inputDiseaseDescription">Categoried By Disease Description</label>
			<select class="form-control disDescOptions">
				<option>--SELECT--</option>
			</select>
		</div>
		<div class="form-inline">
			<label for="result">Number of Patients:</label>
			<label class="resultDiseaseDescription"></label>
		</div>
		<button type="button" class="btn btn-default" onclick="getCntByDiseaseDesp()">Query</button>
		<div class="line"></div>
		<div class="form-inline">
			<label for="inputDiseaseType">Categoried By Disease Type</label>
			<select class="form-control disTypeOptions">
				<option>--SELECT--</option>
			</select>
		</div>
		<div class="form-inline">
			<label for="result">Number of Patients:</label>
			<label class="resultDiseaseType"></label>
		</div>
		<button type="button" class="btn btn-default" onclick="getCntByDiseaseType()">Query</button>
		<div class="line"></div>
		<div class="form-inline">
			<label for="inputDiseaseName">Categoried By Disease Name</label>
			<select class="form-control disNameOptions">
				<option>--SELECT--</option>
			</select>
		</div>
		<div class="form-inline">
			<label for="result">Number of Patients:</label>
			<label class="resultDiseaseName"></label>
		</div>
		<button type="button" class="btn btn-default" onclick="getCntByDiseaseName()">Query</button>
	</form>
	</div></div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		  dataType: "json",
		  url: "/DataOlapSystem/getAllDiseaseDesc.do"
		}).done(function( data ) {
			for(var i=0; i<data.length; i++){
				$('.disDescOptions').append('<option>'+data[i].DESCRIPTION+'</option>');
			}
		});
	$.ajax({
		  dataType: "json",
		  url: "/DataOlapSystem/getAllDiseaseType.do"
		}).done(function( data ) {
			for(var i=0; i<data.length; i++){
				$('.disTypeOptions').append('<option>'+data[i].TYPE+'</option>');
			}
		});
	$.ajax({
		  dataType: "json",
		  url: "/DataOlapSystem/getAllDiseaseName.do"
		}).done(function( data ) {
			for(var i=0; i<data.length; i++){
				$('.disNameOptions').append('<option>'+data[i].NAME+'</option>');
			}
		});
});
function getCntByDiseaseDesp(){
	$.ajax({
	  url: "/DataOlapSystem/getCntByDiseaseDesp.do",
	  data: {disDesc:$('.disDescOptions option:selected').val()}
	}).done(function( data ) {
	    $('.resultDiseaseDescription').html(data);
	});
}
function getCntByDiseaseType(){
	$.ajax({
	  url: "/DataOlapSystem/getCntByDiseaseType.do",
	  data: {disType:$('.disTypeOptions option:selected').val()}
	}).done(function( data ) {
	    $('.resultDiseaseType').html(data);
	});
}
function getCntByDiseaseName(){
	$.ajax({
	  url: "/DataOlapSystem/getCntByDiseaseName.do",
	  data: {disName:$('.disNameOptions option:selected').val()}
	}).done(function( data ) {
	    $('.resultDiseaseName').html(data);
	});
}
</script>

<style>
.resultDiseaseDescription {
	color: red;
}
.resultDiseaseName {
	color: red;
}
.resultDiseaseType {
	color: red;
}
.line {
	border-top: solid 1px rgb(148, 255, 233);
	margin: 10px 10px;
}
</style>
