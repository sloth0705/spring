<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>annotation::param</title>
</head>
<body>
	<h3>@RequestParam Annotation 결과</h3>
	<a href="/Ch04/index">index</a>
	<h4>param1 결과</h4>
	<p>
		uid : ${uid }
	</p>
	<h4>param2 결과</h4>
	<p>
		uid : ${uid }<br>
		name : ${name }
	</p>
	<h4>param3 결과</h4>
	<p>
		uid : ${uid }<br>
		name : ${name }<br>
		hp : ${hp }<br>
		age : ${age }
	</p>
</body>
</html>