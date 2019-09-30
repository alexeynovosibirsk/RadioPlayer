


<html>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>User Information</h2>
<form:form method = "POST" action = "/addUser">
    <table>



                <form action="${pageContext.request.contextPath}/main" method="post">
                    <input type="submit" name="button1" value="button1" />
                    <input type="submit" name="button2" value="Button 2" />
                    <input type="submit" name="button3" value="Button 3" />
                </form>
                <form method="post" action="save">
                    <input type="hidden" name="accept" th:value="true" />
                    <button type="submit" name="accepted" id="modalAcceptTrigger"
                            class="btn btn-lg myBtn_accept" title="Auftrag annehmen">
                        Annehmen
                    </button>
                </form>

            </td>
        </tr>
    </table>
</form:form>
</body>
</html>