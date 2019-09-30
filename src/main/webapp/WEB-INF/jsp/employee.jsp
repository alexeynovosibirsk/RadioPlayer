
<html>
<head>
    <title>Spring MVC - Employee</title>
</head>
<body>
<h2>Employee Details</h2>
<form:form method="post" commandName="employee">

    <table>
        <tr>
            <td><form:label path="firstName">First Name :</form:label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name :</form:label></td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td><form:label path="gender">gender :</form:label></td>
            <td>
                <form:radiobutton path="gender" value="male"/>Male
                <form:radiobutton path="gender" value="female"/>Female
            </td>
        </tr>

        <tr>
            <td><form:label path="paymentMode">Payment Modes :</form:label></td>
            <td><form:radiobuttons path="paymentMode" items="${paymentModes}" /></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
    </table>

</form:form>
</body>
</html>