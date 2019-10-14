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
    <p>Если клавиатура не работает, нужно скачать файл</p>
    <p>конфигурации. Он должен лежать рядом с плеером.</p>
    <p>Образец файла можно получить нажав кнопку ниже:</p>
    <p></p>
    <form method = "GET" action = "/static/files/config.txt">
        <div class="next">
            <button class="button" type="submit">SHOW CONFIG OPTIONS</button>
        </div>
    </form>
    <form>
        <div class="next">
            <button class="button" type="submit" name="action" value="Get_config">GET CONFIG</button>
        </div>
    </form>
</div>
<p>

</body>
</html>

