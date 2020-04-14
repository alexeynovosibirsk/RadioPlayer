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
    <div class="header">
        <label class="label">Operations</label>

    </div>
    <form method = "GET" action = "/">
        <div class="mute">
            <button class="button" type="submit">Cancel</button>
        </div>
    </form>
    <form action="#" data-th-action="@{/action/edit}" data-th-object="${model}" method="post">
        <div class="shutdown">
            <button class="button" type="submit" name="action" value="Shutdown">Shutdown</button>
        </div>
        <div class="shutdown">
            <button class="button" type="submit" name="action" value="Sleep_Mode_30">Sleep Mode 30</button>
        </div>
        <div class="shutdown">
            <button class="button" type="submit" name="action" value="Sleep_Mode_60">Sleep Mode 60</button>
        </div>
    </form>
    <form method = "GET" action = "/">
        <div class="mute">
            <button class="button" type="submit">Cancel</button>
        </div>
    </form>
</div>
</body>
