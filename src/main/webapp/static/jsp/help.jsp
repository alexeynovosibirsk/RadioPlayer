<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebRadioPlayer</title>
    <link rel="stylesheet" href="/static/css/buttons.css">

</head>

<body>
<div align="center">
    <table>
        <tr><td>
            <img src="/static/images/banner.png">
        </td></tr>
    </table>
    <form method = "GET" action = "/">
        <div class="mute">
            <button class="button" type="submit">BACK</button>
        </div>
    </form>
    <p>If keyboard won't work check config file:</p>
    <p></p>
    <form method = "GET" action = "/config">
        <div class="next">
            <button class="button" type="submit">SHOW CONFIG </button>
        </div>
    </form>
    <p>If configfile/config.txt is absent - pull the file:</p>
    <p></p>
    <form action="#" data-th-action="@{/action/edit}" data-th-object="${model}" method="post">
        <div class="next">
            <button class="button" type="submit" name="action" value="Get_config">GET CONFIG</button>
        </div>
    </form>
</div>
<p>
</body>
</html>

