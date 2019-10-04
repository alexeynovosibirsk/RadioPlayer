
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebRadioPlayer</title>
    <link rel="stylesheet" href="css">
</head>

<body>
<div align="center">
<table>
    <tr><td>
    <img src="banner.jpg">
    </td></tr>
</table>
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
                <button class="button" type="submit" name="action" value="">VOID</button>
            </div>
            <div class="mute">
                <button class="button" type="submit" name="action" value="Mute">Mute</button>
            </div>
            <div class="shutdown">
                <button class="button" type="submit" name="action" value="Shutdown">Shutdown</button>
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