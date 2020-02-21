<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>pustest2</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link href="css/webSock.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="img/index.ico">
    <script src="js/para.js" ></script>
</head>
<body>
<div id="showbigimg"></div>


<div id="content">
    <h5>message</h5>
    <h5>img</h5>
    <h1 id="progressBar"></h1>
    <div id="textArea">
        <div id="message" style="overflow:scroll; width:300px; height: 1000px;">
            <div id="firstdiv">以下消息双击可以删除,图片也可以</div>
        </div>
    </div>
    <div id="imgArea" style="overflow:scroll; width:705px; height: 1000px;"></div>
</div>

<script src="js/webSock.js"></script>

</body>

</html>