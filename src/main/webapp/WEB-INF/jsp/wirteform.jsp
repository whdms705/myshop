<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>writeform</title>
</head>
<body>
<h1>writeform</h1>
<form method="post" action="boars">
    name: <input type="text" name="name"><br>
    title: <input type="text" name="title"><br>
    content:
    <textarea> name="content" cols=50 rows="6"></textarea>
    <input tpe="hidden" name="page" value="1">
    <br>
    <input type="submit">
</form>
</body>
</html>