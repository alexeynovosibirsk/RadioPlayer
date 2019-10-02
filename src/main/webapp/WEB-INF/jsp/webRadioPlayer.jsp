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
</table>

</div>
<style>
    /* GENERAL STYLES */

    body {
        text-align: center;
        background: black;
    }

    p {
        color: #ddd;
        font-family: Helvetica;
        font-size: 20px;
        margin: 20px 0 0 0;
    }

    button {
        color: #000;
        text-decoration: none;
        text-transform: uppercase;
        font-family: Helvetica;
    }

    button,
    span {
        font-size: 20px;
    }

    .double button {
        color: blue;
    }

    .double .button {
        display: inline-block;
        width: 130px;
        height: 40px;
        line-height: 40px;
        margin: 20px;
        position: relative;
        overflow: hidden;
        border: 2px solid blue;
        transition: color .5s;
    }

    .double .button:before {
        content: "";
        position: absolute;
        z-index: -1;
        background: blue;
        height: 150px;
        width: 200px;
        border-radius: 50%;
    }

    .double .button:hover {
        color: #fff;
    }

    .double .button:nth-child(1):before {
        left: -30px;
        bottom: 100%;
        transition: all .5s;
    }

    .double .button:nth-child(1):hover:before {
        bottom: -50px;
    }

    .double .button:nth-child(2):before {
        left: -30px;
        bottom: 100%;
        transition: all .7s;
    }

    .double .button:nth-child(2):hover:before {
        bottom: -50px;
    }

    .double .button:nth-child(3):before {
        top: 0;
        left: -200%;
        transition: all .7s;
    }


</style>

</body>
</html>