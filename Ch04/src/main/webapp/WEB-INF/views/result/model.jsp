<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>annotation::model</title>
</head>
<body>
	<h3>@ModelAttribute Annotation 결과</h3>
	<a href="/Ch04/index">index</a>
	<h4>model1 결과</h4>
	<p>
		uid : ${modelDTO.uid }
	</p>
	<h4>model2 결과</h4>
	<p>
		uid : ${user.uid }<br>
		name : ${user.name }
	</p>
	<h4>model3 결과</h4>
	<p>
		uid : ${modelDTO.uid }<br>
		name : ${modelDTO.name }<br>
		hp : ${modelDTO.hp }<br>
		age : ${modelDTO.age }
	</p>
</body>
</html>