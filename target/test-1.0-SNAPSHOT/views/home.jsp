<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yerch
  Date: 21.01.2022
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Crypto</title>
</head>
<body>
<script>
    function min() {
        let a = document.getElementById('carrency').value;
        if (a == '') {
            alert('choose carrency!');
        } else document.location.href = "/cryptocurrencies/minpricename=" + a;
    }

    function max() {
        let a = document.getElementById('carrency').value;
        if (a == '') {
            alert('choose carrency!');
        } else document.location.href = "/cryptocurrencies/maxpricename=" + a;
    }

    function onChange() {
        let a = document.getElementById('carrency').value;
        let x = document.getElementById("myDIV");
        let p = document.getElementById("page");
        let s = document.getElementById("size").value;
        p.options.length = 0;
        if (a == '') {
            x.style.display = "none";
        }
        if (a == "Bitcoin") {
            x.style.display = "block";
            let j = ${Bitcoin};
            for (i = 0; i < (j / s); i++) {
                p.options[p.options.length] = new Option(i, i);
            }
        }
        if (a == "Ethereum") {
            x.style.display = "block";
            let j = ${Ethereum};
            for (i = 0; i < (j / s); i++) {
                p.options[p.options.length] = new Option(i, i);
            }
        }
        if (a == "XRP") {
            x.style.display = "block";
            let j = ${XRP};
            for (i = 0; i < (j / s); i++) {
                p.options[p.options.length] = new Option(i, i);
            }
        }
    }

    function changeSize() {
        let a = document.getElementById('carrency').value;
        let p = document.getElementById("page");
        let s = document.getElementById("size").value;
        p.options.length = 0;
        if (a == "Bitcoin") {
            let j = ${Bitcoin};
            for (i = 0; i < (j / s); i++) {
                p.options[p.options.length] = new Option(i, i);
            }
        }
        if (a == "Ethereum") {
            let j = ${Ethereum};
            for (i = 0; i < (j / s); i++) {
                p.options[p.options.length] = new Option(i, i);
            }
        }
        if (a == "XRP") {
            let j = ${XRP};
            for (i = 0; i < (j / s); i++) {
                p.options[p.options.length] = new Option(i, i);
            }
        }
    }

    function prices() {
        let a = document.getElementById('carrency').value;
        let p = document.getElementById("page").value;
        let s = document.getElementById("size").value;
        document.location.href = "/cryptocurrencies/name=" + a + "&page=" + p + "&size=" + s;
    }


</script>
<h1>Choose crypto currency</h1>
<select name="carrency" id="carrency" onchange="onChange()">
    <option value=""></option>
    <c:forEach var="carrencies" items="${carrencies}">
        <option value="${carrencies}">${carrencies}</option>
    </c:forEach>
</select>
<h2></h2>
<button onclick=min()>min price</button>
<button onclick=max()>max price</button>
<h2></h2>
<div id="myDIV" style="display: none">
    <h4>select size and page</h4>
    <select id="size" onchange=changeSize()>
        <option value=10>10</option>
        <option value=25>25</option>
        <option value=50>50</option>
    </select>
    <select id="page">
        <option value=0>0</option>
    </select>
    <h4></h4>
    <button onclick=prices()>prices</button>
</div>
</body>
</html>
