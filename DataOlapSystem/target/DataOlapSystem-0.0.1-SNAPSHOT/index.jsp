<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/WEB-INF/jsp/head.jsp" />

<div class="container">
	<form>
		<div class="form-inline">
		<h2>Patient Numbers:</h2>
			<label for="inputDiseaseDescription">Categoried By Disease Description</label>
			<select class="form-control disDescOptions">
				<option>1</option>
				<option>2</option>
				<option>tumor</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
		<div class="form-inline">
			<label for="result">Number of Patients:</label>
			<label class="resultDiseaseDescription"></label>
		</div>
		<button type="button" class="btn btn-default" onclick="getCntByDiseaseDesp()">Query</button>
	</form>
</div>

<script type="text/javascript">
function getCntByDiseaseDesp(){
	$.ajax({
	  url: "/DataOlapSystem/getCntByDiseaseDesp.do",
	  data: {disDesc:$('.disDescOptions option:selected').val()}
	}).done(function( data ) {
	    $('.resultDiseaseDescription').html(data);
	});
}
</script>
