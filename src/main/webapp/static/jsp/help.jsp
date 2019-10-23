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
    <form method = "GET" action = "/">
        <div class="mute">
            <button class="button" type="submit">RETURN TO MAIN MENU</button>
        </div>
    </form>
    <p>If keyboard won't work check config file:</p>
    <p></p>
    <form method = "GET" action = "/config">
        <div class="next">
            <button class="button" type="submit">SHOW CONFIG</button>
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

