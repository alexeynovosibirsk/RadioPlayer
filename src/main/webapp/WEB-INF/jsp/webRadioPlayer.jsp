<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebRadioPlayer</title>
    <link rel="stylesheet" href="/css/glassb.css">
</head>
<body>
<div align="center">
<table>
    <tr><td>
    <img src="banner.jpg">
    </td></tr>
        <form action="#" data-th-action="@{/action/edit}" data-th-object="${model}" method="post">

            <tr><td>
                <input class="button9" type="submit" name="action" value="Ambient">
                <input class="button4" type="submit" name="action" value="Jazz">
            </td></tr>
            <tr><td>
                <input class="button4" type="submit" name="action" value="Trance">
                <input class="button4" type="submit" name="action" value="Retro">
            </td></tr>
            <tr><td>
                <input class="button4" type="submit" name="action" value="Variable">
                <button class="button glass blue-b" type="submit" name="action" value="Volume_-">BLUE</button>
            </td></tr>
            <tr><td>
                <input class="button1" type="submit" name="action" value="Next_Station">
            </td></tr>
            <tr><td>
                <input class="button2" type="submit" name="action" value="Volume_+">
                <input class="button2" type="submit" name="action" value="Volume_-">

            </td></tr>
            <tr><td>

                <input class="button3" type="submit" name="action" value="Mute">
            </td></tr>
            <tr><td>
                <input class="button5" type="submit" name="action" value="Shutdown">
            </td></tr>

        </form>
</table>
</div>
<style>
    input.button1 {
        position: relative;
        display: inline-block;
        font-family: Arial,Helvetica,FreeSans,"Liberation Sans","Nimbus Sans L",sans-serif;
        width: 300px;
        font-size: 1.5em;
        font-weight: 700;
        color: rgb(245,245,245);
        text-shadow: 0 -1px rgba(0,0,0,.1);
        text-decoration: none;
        user-select: none;
        padding: .3em 1em;
        outline: none;
        border: none;
        border-radius: 3px;
        background: #9c9a11 linear-gradient(#c9d11b, #879c17);
        box-shadow: inset #b0de12 0 -1px 1px, inset 0 1px 1px #edff15, #aa970b 0 0 0 1px, rgba(0,0,0,.3) 0 2px 5px;
        -webkit-animation: pulsate 1.2s linear infinite;
        animation: pulsate 1.2s linear infinite;
    }
    input.button1:hover {
        -webkit-animation-play-state: paused;
        animation-play-state: paused;
        cursor: pointer;
    }
    input.button1:active {
        top: 1px;
        color: #fff;
        text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;
        box-shadow: 0 -1px 3px rgba(0,0,0,.3), 0 1px 1px #fff, inset 0 1px 2px rgba(0,0,0,.8), inset 0 -1px 0 rgba(0,0,0,.05);
    }
    @-webkit-keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }
    @keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }

     input.button2 {
         position: relative;
         display: inline-block;
         width: 150px;
         font-family: Arial,Helvetica,FreeSans,"Liberation Sans","Nimbus Sans L",sans-serif;
         font-size: 1.5em;
         font-weight: 700;
         color: rgb(245,245,245);
         text-shadow: 0 -1px rgba(0,0,0,.1);
         text-decoration: none;
         user-select: none;
         padding: .3em 1em;
         outline: none;
         border: none;
         border-radius: 3px;
         background: #083b9c linear-gradient(#7198d1, #3c229c);
         box-shadow: inset #2ab3de 0 -1px 1px, inset 0 1px 1px #aeb4ff, #5328aa 0 0 0 1px, rgba(0,0,0,.3) 0 2px 5px;
         -webkit-animation: pulsate 1.2s linear infinite;
         animation: pulsate 1.2s linear infinite;
     }
    input.button2:hover {
        -webkit-animation-play-state: paused;
        animation-play-state: paused;
        cursor: pointer;
    }
    input.button2:active {
        top: 1px;
        color: #fff;
        text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;
        box-shadow: 0 -1px 3px rgba(0,0,0,.3), 0 1px 1px #fff, inset 0 1px 2px rgba(0,0,0,.8), inset 0 -1px 0 rgba(0,0,0,.05);
    }
    @-webkit-keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }
    @keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }

     input.button3 {
         position: relative;
         display: inline-block;
         width: 300px;
         font-family: Arial,Helvetica,FreeSans,"Liberation Sans","Nimbus Sans L",sans-serif;
         font-size: 1.5em;
         font-weight: 700;
         color: rgb(245,245,245);
         text-shadow: 0 -1px rgba(0,0,0,.1);
         text-decoration: none;
         user-select: none;
         padding: .3em 1em;
         outline: none;
         border: none;
         border-radius: 3px;
         background: #5e9c90 linear-gradient(#cbc8d1, #589b9c);
         box-shadow: inset #94d4de 0 -1px 1px, inset 0 1px 1px #b7e0ff, #889faa 0 0 0 1px, rgba(0,0,0,.3) 0 2px 5px;
         -webkit-animation: pulsate 1.2s linear infinite;
         animation: pulsate 1.2s linear infinite;
     }
    input.button3:hover {
        -webkit-animation-play-state: paused;
        animation-play-state: paused;
        cursor: pointer;
    }
    input.button3:active {
        top: 1px;
        color: #fff;
        text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;
        box-shadow: 0 -1px 3px rgba(0,0,0,.3), 0 1px 1px #fff, inset 0 1px 2px rgba(0,0,0,.8), inset 0 -1px 0 rgba(0,0,0,.05);
    }
    @-webkit-keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }
    @keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }

    input.button4 {
        position: relative;
        display: inline-block;
        font-family: Arial,Helvetica,FreeSans,"Liberation Sans","Nimbus Sans L",sans-serif;
        width: 150px;
        font-size: 1.5em;
        font-weight: 700;
        color: rgb(245,245,245);
        text-shadow: 0 -1px rgba(0,0,0,.1);
        text-decoration: none;
        user-select: none;
        padding: .3em 1em;
        outline: none;
        border: none;
        border-radius: 3px;
        background: #0c9c0d linear-gradient(#82d18d, #0c9c0d);
        box-shadow: inset #72de26 0 -1px 1px, inset 0 1px 1px #98ff98, #3caa3c 0 0 0 1px, rgba(0,0,0,.3) 0 2px 5px;
        -webkit-animation: pulsate 1.2s linear infinite;
        animation: pulsate 1.2s linear infinite;
    }
    input.button4:hover {
        -webkit-animation-play-state: paused;
        animation-play-state: paused;
        cursor: pointer;
    }
    input.button4:active {
        top: 1px;
        color: #fff;
        text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;
        box-shadow: 0 -1px 3px rgba(0,0,0,.3), 0 1px 1px #fff, inset 0 1px 2px rgba(0,0,0,.8), inset 0 -1px 0 rgba(0,0,0,.05);
    }
    @-webkit-keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }
    @keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }

     input.button5 {
         position: relative;
         display: inline-block;
         width: 300px;
         font-family: Arial,Helvetica,FreeSans,"Liberation Sans","Nimbus Sans L",sans-serif;
         font-size: 1.5em;
         font-weight: 700;
         color: rgb(245,245,245);
         text-shadow: 0 -1px rgba(0,0,0,.1);
         text-decoration: none;
         user-select: none;
         padding: .3em 1em;
         outline: none;
         border: none;
         border-radius: 3px;
         background: #9c0700 linear-gradient(#d14a41, #9c1418);
         box-shadow: inset #de5441 0 -1px 1px, inset 0 1px 1px #ff5e0e, #aa563b 0 0 0 1px, rgba(0,0,0,.3) 0 2px 5px;
         -webkit-animation: pulsate 1.2s linear infinite;
         animation: pulsate 1.2s linear infinite;
     }
    input.button5:hover {
        -webkit-animation-play-state: paused;
        animation-play-state: paused;
        cursor: pointer;
    }
    input.button5:active {
        top: 1px;
        color: #fff;
        text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;
        box-shadow: 0 -1px 3px rgba(0,0,0,.3), 0 1px 1px #fff, inset 0 1px 2px rgba(0,0,0,.8), inset 0 -1px 0 rgba(0,0,0,.05);
    }
    @-webkit-keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }
    @keyframes pulsate {
        50% {color: #fff; text-shadow: 0 -1px rgba(0,0,0,.3), 0 0 5px #ffd, 0 0 8px #fff;}
    }

    input.button9 {
        position: relative;
        display: inline-block;
        color: #777674;
        font-weight: bold;
        text-decoration: none;
        text-shadow: rgba(255,255,255,.5) 1px 1px, rgba(100,100,100,.3) 3px 7px 3px;
        user-select: none;
        padding: 1em 2em;
        outline: none;
        border-radius: 3px / 100%;
        background-image:
                linear-gradient(45deg, rgba(255,255,255,.0) 30%, rgba(255,255,255,.8), rgba(255,255,255,.0) 70%),
                linear-gradient(to right, rgba(255,255,255,1), rgba(255,255,255,0) 20%, rgba(255,255,255,0) 90%, rgba(255,255,255,.3)),
                linear-gradient(to right, rgba(125,125,125,1), rgba(255,255,255,.9) 45%, rgba(125,125,125,.5)),
                linear-gradient(to right, rgba(125,125,125,1), rgba(255,255,255,.9) 45%, rgba(125,125,125,.5)),
                linear-gradient(to right, rgba(223,190,170,1), rgba(255,255,255,.9) 45%, rgba(223,190,170,.5)),
                linear-gradient(to right, rgba(223,190,170,1), rgba(255,255,255,.9) 45%, rgba(223,190,170,.5));
        background-repeat: no-repeat;
        background-size: 200% 100%, auto, 100% 2px, 100% 2px, 100% 1px, 100% 1px;
        background-position: 200% 0, 0 0, 0 0, 0 100%, 0 4px, 0 calc(100% - 4px);
        box-shadow: rgba(0,0,0,.5) 3px 10px 10px -10px;
    }
    input.button9:hover {
        transition: .5s linear;
        background-position: -200% 0, 0 0, 0 0, 0 100%, 0 4px, 0 calc(100% - 4px);
    }
    input.button9:active {
        top: 1px;
    }

</style>
</body>
</html>