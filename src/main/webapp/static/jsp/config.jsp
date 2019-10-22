<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>webRadioPlayer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/buttons.css">
</head>
<body>
<div align="center">
    <img width="290" src="/static/images/banner.png">
    <br>
    <p>OKEY DOKEY</p>
    <p></p>
    <form method = "GET" action = "/help">
        <div class="genre">
            <button class="button" type="submit">OK</button>
        </div>
    </form>
    <form:form method="POST" commandName="customerForm">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <table>
            <tr>
                <td>Address :</td>
                <td><form:textarea path="address" rows="5" cols="30" /></td>
                <td><form:errors path="address" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" /></td>
            </tr>
        </table>
    </form:form>


</div>
<p>
</body>
</html>

