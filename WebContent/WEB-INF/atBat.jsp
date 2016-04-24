<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.BatResult" %>
    <%@ page import="model.Situation" %>
    <%
   	BatResult res = (BatResult)session.getAttribute("result");
   	Situation sit = (Situation)session.getAttribute("situation");
   	String runner="";
   	if(sit.getR1()){
   		runner += "一塁";
   	}
   	if(sit.getR2()){
   		runner += "二塁";
   	}
   	if(sit.getR3()){
   		if(runner.length() > 3){
   			runner = "満塁";
   		}
   		else{
   			runner += "三塁";
   		}
   	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打った！</title>
</head>
<body>
結果：<%= res.getResult() %><br />
<%= sit.getOut() %>アウト<br />
<%= runner %>
<form action="/baseball/BaseballGame">
<input type="hidden" name="action" value="atbat">
<input type="submit" value="続ける">
</form>
<form action="/baseball/BaseballGame?action=end">
<input type="hidden" name="action" value="end">
<input type="submit" value="終了">
</form>
</body>
</html>