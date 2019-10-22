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

        <form action="#" data-th-action="@{/action/edit}" data-th-object="${model}" method="post">
            <div class="volume">
                <button class="button" type="submit" name="action" value="Volume_up">Volume +</button>
                <button class="button" type="submit" name="action" value="Volume_dn">Volume -</button>
            </div>
            <div class="next">
                <button class="button" type="submit" name="action" value="Next_Station">Next Station</button>
            </div>
            <div class="genre">
                <button class="button" type="submit" name="action" value="Ambient">Ambient</button>
                <button class="button" type="submit" name="action" value="Jazz">Jazz</button>
            </div>
            <div class="genre">
                <button class="button" type="submit" name="action" value="Trance">Trance</button>
                <button class="button" type="submit" name="action" value="Retro">Retro</button>
            </div>
            <div class="genre">
                <button class="button" type="submit" name="action" value="Variable">Variable</button>
                <button class="button" type="submit" name="action" value="Dance">Dance</button>
            </div>
            <div class="mute">
                <button class="button" type="submit" name="action" value="Mute">Mute</button>
            </div>
            <div class="shutdown">
                <button class="button" type="submit" name="action" value="Shutdown">Shutdown</button>
            </div>
            <div class="shutdown">
                <button class="button" type="submit" name="action" value="Sleep_Mode_15">Sleep Mode 15</button>
            </div>
        </form>
        <form method = "GET" action = "/help">
            <div class="mute">
                <button class="button" type="submit" name="/help" value="help">Help</button>
            </div>
        </form>
</div>
</body>
</html>