<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebRadioPlayer</title>
    <link rel="stylesheet" href="glassb.css">
</head>

<body background="bgr_blue">
<div align="center">
<table>
    <tr><td>
    <img src="banner.jpg">
    </td></tr>
        <form action="#" data-th-action="@{/action/edit}" data-th-object="${model}" method="post">

            <tr><td>
                <button class="button glass blue-b" type="submit" name="action" value="Volume_up">Volume +</button>
                <button class="button glass blue-b" type="submit" name="action" value="Volume_dn">Volume -</button>
            </td></tr>
            <tr><td>
                <button class="button glass green-b" type="submit" name="action" value="Ambient">Ambient</button>
                <button class="button glass green-b" type="submit" name="action" value="Jazz">Jazz</button>
            </td></tr>
            <tr><td>
                <button class="button glass green-b" type="submit" name="action" value="Trance">Trance</button>
                <button class="button glass green-b" type="submit" name="action" value="Retro">Retro</button>
            </td></tr>
            <tr><td>
                <button class="button glass green-b" type="submit" name="action" value="Variable">Variable</button>
                <button class="button glass green-b" type="submit" name="action" value="">No action</button>
            </td></tr>
            <tr><td>
                <input class="button1" type="submit" name="action" value="Next_Station">
            </td></tr>

            <tr><td>

                <input class="button3" type="submit" name="action" value="Mute">
            </td></tr>
            <tr><td>
                <button class="button glass red-b" type="submit" name="action" value="Shutdown">Shutdown</button>

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


    .button {
        color: rgba(255, 255, 255, 0.8);
        text-shadow: 0px 1px #000;
        font-size: 16px;
        text-decoration: none;
        padding: 0.5em 1.5em;
        margin: 0.5em;
        cursor: pointer;
        width: 200px;
        overflow: visible;
        border-radius: 3px;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        -webkit-transition: all 0.1s ease-in-out;
        -moz-transition: all 0.1s ease-in-out;
        -o-transition: all 0.1s ease-in-out;
        transition: all 0.1s ease-in-out;
        outline: 0;
    }

    .glass {
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzYwNjc2OCIgc3RvcC1vcGFjaXR5PSIwLjMiLz4KICAgIDxzdG9wIG9mZnNldD0iMyUiIHN0b3AtY29sb3I9IiNiYmJiYmIiIHN0b3Atb3BhY2l0eT0iMC4zIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjI3JSIgc3RvcC1jb2xvcj0iI2JiYmJiYiIgc3RvcC1vcGFjaXR5PSIwLjMiLz4KICAgIDxzdG9wIG9mZnNldD0iMjglIiBzdG9wLWNvbG9yPSIjMDAwMDAwIiBzdG9wLW9wYWNpdHk9IjAuMyIvPgogICAgPHN0b3Agb2Zmc2V0PSI3MyUiIHN0b3AtY29sb3I9IiMwMDAwMDAiIHN0b3Atb3BhY2l0eT0iMC4zIi8+CiAgICA8c3RvcCBvZmZzZXQ9Ijg4JSIgc3RvcC1jb2xvcj0iIzRiNTA1MSIgc3RvcC1vcGFjaXR5PSIwLjMiLz4KICAgIDxzdG9wIG9mZnNldD0iOTclIiBzdG9wLWNvbG9yPSIjMDAwMDAwIiBzdG9wLW9wYWNpdHk9IjAuMyIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjMDAwMDAwIiBzdG9wLW9wYWNpdHk9IjAuMyIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 3%, rgba(187, 187, 187, 0.3) 27%, rgba(0, 0, 0, 0.3) 28%, rgba(0, 0, 0, 0.3) 60%, rgba(0, 0, 0, 0.3) 73%, rgba(75, 80, 81, 0.3) 88%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(96, 103, 104, 0.3)), color-stop(3%, rgba(187, 187, 187, 0.3)), color-stop(27%, rgba(187, 187, 187, 0.3)), color-stop(28%, rgba(0, 0, 0, 0.3)), color-stop(60%, rgba(0, 0, 0, 0.3)), color-stop(73%, rgba(0, 0, 0, 0.3)), color-stop(88%, rgba(75, 80, 81, 0.3)), color-stop(97%, rgba(0, 0, 0, 0.3)), color-stop(100%, rgba(0, 0, 0, 0.3)));
        /* Chrome,Safari4+ */
        background: -webkit-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 3%, rgba(187, 187, 187, 0.3) 27%, rgba(0, 0, 0, 0.3) 28%, rgba(0, 0, 0, 0.3) 60%, rgba(0, 0, 0, 0.3) 73%, rgba(75, 80, 81, 0.3) 88%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 3%, rgba(187, 187, 187, 0.3) 27%, rgba(0, 0, 0, 0.3) 28%, rgba(0, 0, 0, 0.3) 60%, rgba(0, 0, 0, 0.3) 73%, rgba(75, 80, 81, 0.3) 88%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* Opera 11.10+ */
        background: -ms-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 3%, rgba(187, 187, 187, 0.3) 27%, rgba(0, 0, 0, 0.3) 28%, rgba(0, 0, 0, 0.3) 60%, rgba(0, 0, 0, 0.3) 73%, rgba(75, 80, 81, 0.3) 88%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* IE10+ */
        background: linear-gradient(to bottom, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 3%, rgba(187, 187, 187, 0.3) 27%, rgba(0, 0, 0, 0.3) 28%, rgba(0, 0, 0, 0.3) 60%, rgba(0, 0, 0, 0.3) 73%, rgba(75, 80, 81, 0.3) 88%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* W3C */
        border-color: rgba(0, 0, 0, 0.6);
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 2px 6px rgba(0, 0, 0, 0.5), 0 10px rgba(0, 0, 0, 0.05) inset;
    }

    .glass-sculpted {
        /* IE9 SVG, needs conditional override of 'filter' to 'none' */
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzYwNjc2OCIgc3RvcC1vcGFjaXR5PSIwLjMiLz4KICAgIDxzdG9wIG9mZnNldD0iMiUiIHN0b3AtY29sb3I9IiNiYmJiYmIiIHN0b3Atb3BhY2l0eT0iMC4zIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUlIiBzdG9wLWNvbG9yPSIjYmJiYmJiIiBzdG9wLW9wYWNpdHk9IjAuMyIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMCUiIHN0b3AtY29sb3I9IiMwMDAwMDAiIHN0b3Atb3BhY2l0eT0iMC4zIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjQ3JSIgc3RvcC1jb2xvcj0iIzAwMDAwMCIgc3RvcC1vcGFjaXR5PSIwLjMiLz4KICAgIDxzdG9wIG9mZnNldD0iODglIiBzdG9wLWNvbG9yPSIjYmJiYmJiIiBzdG9wLW9wYWNpdHk9IjAuMyIvPgogICAgPHN0b3Agb2Zmc2V0PSI5MiUiIHN0b3AtY29sb3I9IiM0YjUwNTEiIHN0b3Atb3BhY2l0eT0iMC4zIi8+CiAgICA8c3RvcCBvZmZzZXQ9Ijk3JSIgc3RvcC1jb2xvcj0iIzAwMDAwMCIgc3RvcC1vcGFjaXR5PSIwLjMiLz4KICAgIDxzdG9wIG9mZnNldD0iMTAwJSIgc3RvcC1jb2xvcj0iIzAwMDAwMCIgc3RvcC1vcGFjaXR5PSIwLjMiLz4KICA8L2xpbmVhckdyYWRpZW50PgogIDxyZWN0IHg9IjAiIHk9IjAiIHdpZHRoPSIxIiBoZWlnaHQ9IjEiIGZpbGw9InVybCgjZ3JhZC11Y2dnLWdlbmVyYXRlZCkiIC8+Cjwvc3ZnPg==);
        background: -moz-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 2%, rgba(187, 187, 187, 0.3) 5%, rgba(0, 0, 0, 0.3) 10%, rgba(0, 0, 0, 0.3) 47%, rgba(187, 187, 187, 0.3) 88%, rgba(75, 80, 81, 0.3) 92%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(96, 103, 104, 0.3)), color-stop(2%, rgba(187, 187, 187, 0.3)), color-stop(5%, rgba(187, 187, 187, 0.3)), color-stop(10%, rgba(0, 0, 0, 0.3)), color-stop(47%, rgba(0, 0, 0, 0.3)), color-stop(88%, rgba(187, 187, 187, 0.3)), color-stop(92%, rgba(75, 80, 81, 0.3)), color-stop(97%, rgba(0, 0, 0, 0.3)), color-stop(100%, rgba(0, 0, 0, 0.3)));
        /* Chrome,Safari4+ */
        background: -webkit-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 2%, rgba(187, 187, 187, 0.3) 5%, rgba(0, 0, 0, 0.3) 10%, rgba(0, 0, 0, 0.3) 47%, rgba(187, 187, 187, 0.3) 88%, rgba(75, 80, 81, 0.3) 92%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 2%, rgba(187, 187, 187, 0.3) 5%, rgba(0, 0, 0, 0.3) 10%, rgba(0, 0, 0, 0.3) 47%, rgba(187, 187, 187, 0.3) 88%, rgba(75, 80, 81, 0.3) 92%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* Opera 11.10+ */
        background: -ms-linear-gradient(top, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 2%, rgba(187, 187, 187, 0.3) 5%, rgba(0, 0, 0, 0.3) 10%, rgba(0, 0, 0, 0.3) 47%, rgba(187, 187, 187, 0.3) 88%, rgba(75, 80, 81, 0.3) 92%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* IE10+ */
        background: linear-gradient(to bottom, rgba(96, 103, 104, 0.3) 0%, rgba(187, 187, 187, 0.3) 2%, rgba(187, 187, 187, 0.3) 5%, rgba(0, 0, 0, 0.3) 10%, rgba(0, 0, 0, 0.3) 47%, rgba(187, 187, 187, 0.3) 88%, rgba(75, 80, 81, 0.3) 92%, rgba(0, 0, 0, 0.3) 97%, rgba(0, 0, 0, 0.3) 100%);
        /* W3C */
        filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#4d606768', endColorstr='#4d000000', GradientType=0);
        /* IE6-8 */
        border-color: rgba(0, 0, 0, 0.6);
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 2px 6px rgba(0, 0, 0, 0.5), 0 10px rgba(0, 0, 0, 0.05) inset;
    }

    button:active {
        margin-left: 2px;
        margin-right: -2px;
    }


    /**
     * Style A
     */

    button:active.clear-a,
    button:active.red-a,
    button:active.green-a,
    button:active.blue-a {
        -webkit-transition: none !important;
        -moz-transition: none !important;
        -o-transition: none !important;
        transition: none !important;
        */
    }

    button:hover.clear-a {
        color: rgba(255, 255, 255, 0.99);
        text-shadow: 0px 0px 2px rgba(255, 255, 255, 0.99), 0px 0px 4px rgba(255, 255, 255, 0.75);
        border-color: rgba(255, 255, 255, 0.4);
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 2px 6px rgba(0, 0, 0, 0.5), 0 10px rgba(0, 0, 0, 0.05) inset, 0 0 5px 2px rgba(255, 255, 255, 0.75), 0 0 10px 2px rgba(255, 255, 255, 0.75) inset;
    }

    button:active.clear-a {
        color: rgba(0, 0, 0, 1.0);
        border-color: rgba(255, 255, 255, 0.6) !important;
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 10px 0 0 rgba(255, 255, 255, 0.5) inset, 0 0 5px 2px rgba(255, 255, 255, 0.75), 0 0 10px 2px rgba(255, 255, 255, 0.75) inset !important;
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNmZmZmZmYiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjZmZmZmZmIiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(255, 255, 255, 1)), color-stop(100%, rgba(255, 255, 255, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* W3C */
    }

    .red-a,
    .red-b {
        color: rgba(255, 200, 200, 0.99);
        background-color: rgba(255, 120, 120, 0.25);
    }

    button:hover.red-a {
        color: rgba(255, 230, 230, 0.99);
        text-shadow: 0px 0px 2px rgba(255, 230, 230, 0.99), 0px 0px 4px rgba(255, 200, 200, 0.99);
        border-color: rgba(255, 120, 120, 0.4);
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 2px 6px rgba(0, 0, 0, 0.5), 0 10px rgba(0, 0, 0, 0.05) inset, 0 0 5px 2px rgba(255, 120, 120, 0.75), 0 0 10px 2px rgba(255, 120, 120, 0.75) inset;
    }

    button:active.red-a {
        color: rgba(255, 230, 230, 0.99);
        text-shadow: 0px 0px 2px rgba(255, 230, 230, 0.99), 0px 0px 4px rgba(255, 200, 200, 0.99);
        border-color: rgba(255, 180, 180, 0.6) !important;
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 120, 120, 0.4) inset, 0 10px 0 0 rgba(255, 120, 120, 0.5) inset, 0 0 5px 2px rgba(255, 120, 120, 0.75), 0 0 10px 2px rgba(255, 120, 120, 0.75) inset !important;
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNmZjc4NzgiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjZmY3ODc4IiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(255, 120, 120, 1)), color-stop(100%, rgba(255, 120, 120, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* W3C */
    }

    .green-a,
    .green-b {
        color: rgba(180, 255, 220, 0.99);
        background-color: rgba(110, 255, 185, 0.25);
    }

    button:hover.green-a {
        color: rgba(220, 255, 240, 0.99);
        text-shadow: 0px 0px 2px rgba(220, 255, 240, 0.99), 0px 0px 4px rgba(180, 255, 220, 0.99);
        border-color: rgba(110, 255, 185, 0.4);
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 2px 6px rgba(0, 0, 0, 0.5), 0 10px rgba(0, 0, 0, 0.05) inset, 0 0px 5px 2px rgba(110, 255, 185, 0.75), 0 0px 10px 2px rgba(110, 255, 185, 0.75) inset;
    }

    button:active.green-a {
        color: rgba(220, 255, 240, 0.99);
        text-shadow: 0px 0px 2px rgba(220, 255, 240, 0.99), 0px 0px 4px rgba(180, 255, 220, 0.99);
        border-color: rgba(110, 255, 185, 0.6) !important;
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(110, 255, 185, 0.4) inset, 0 10px 0 0 rgba(110, 255, 185, 0.5) inset, 0 0 5px 2px rgba(110, 255, 185, 0.75), 0 0 10px 2px rgba(110, 255, 185, 0.75) inset !important;
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiM2ZWZmYjkiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjNmVmZmI5IiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(110, 255, 185, 1)), color-stop(100%, rgba(110, 255, 185, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* W3C */
    }

    .blue-a,
    .blue-b {
        color: rgba(200, 230, 255, 0.99);
        background-color: rgba(120, 200, 255, 0.25);
    }

    button:hover.blue-a {
        color: rgba(230, 240, 255, 0.99);
        text-shadow: 0px 0px 2px rgba(230, 240, 255, 0.99), 0px 0px 4px rgba(200, 230, 255, 0.99);
        border-color: rgba(120, 200, 255, 0.4);
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 2px 6px rgba(0, 0, 0, 0.5), 0 10px rgba(0, 0, 0, 0.05) inset, 0 0px 5px 2px rgba(120, 200, 255, 0.75), 0 0px 10px 2px rgba(120, 200, 255, 0.75) inset;
    }

    button:active.blue-a {
        color: rgba(230, 240, 255, 0.99);
        text-shadow: 0px 0px 2px rgba(230, 240, 255, 0.99), 0px 0px 4px rgba(200, 230, 255, 0.99);
        border-color: rgba(120, 200, 255, 0.6) !important;
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(120, 200, 255, 0.4) inset, 0 10px 0 0 rgba(120, 200, 255, 0.5) inset, 0 0 5px 2px rgba(120, 200, 255, 0.75), 0 0 10px 2px rgba(120, 200, 255, 0.75) inset !important;
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiM3OGM4ZmYiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjNzhjOGZmIiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(120, 200, 255, 1)), color-stop(100%, rgba(120, 200, 255, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* W3C */
    }


    /**
     * Style B
     */

    .clear-b,
    .red-b,
    .green-b,
    .blue-b {
        -webkit-transition: none;
        -moz-transition: none;
        -o-transition: none;
        transition: none;
    }

    button:hover.clear-b {
        color: rgba(0, 0, 0, 1.0);
        text-shadow: none;
        border-color: rgba(0, 0, 0, 0.6);
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 10px rgba(255, 255, 255, 0.5) inset, 0 0 5px 2px rgba(255, 255, 255, 0.75);
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNmZmZmZmYiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjZmZmZmZmIiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(255, 255, 255, 1)), color-stop(100%, rgba(255, 255, 255, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%);
        /* W3C */
    }

    button:active.clear-b {
        border-color: rgba(255, 255, 255, 0.6) !important;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 10px 0 0 rgba(255, 255, 255, 0.5) inset, 0 0 5px 2px rgba(255, 255, 255, 0.75), 0 0 10px 2px rgba(255, 255, 255, 0.75) inset !important;
    }

    button:hover.red-b {
        text-shadow: 0px 0px 2px rgba(255, 160, 160, 0.99), 0px 0px 4px rgba(255, 130, 130, 0.99);
        border-color: rgba(0, 0, 0, 0.6);
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 10px rgba(255, 180, 180, 0.5) inset, 0 0 5px 2px rgba(255, 120, 120, 0.75), 0 0 10px 2px rgba(255, 120, 120, 0.75) inset;
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiNmZjc4NzgiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjZmY3ODc4IiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(255, 120, 120, 1)), color-stop(100%, rgba(255, 120, 120, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(255, 120, 120, 1) 0%, rgba(255, 120, 120, 0) 100%);
        /* W3C */
    }

    button:active.red-b {
        text-shadow: 0px 0px 2px rgba(255, 230, 230, 0.99), 0px 0px 4px rgba(255, 200, 200, 0.99);
        border-color: rgba(255, 180, 180, 0.6) !important;
        box-shadow: 0 1px 0 0 rgba(255, 120, 120, 0.4) inset, 0 10px 0 0 rgba(255, 180, 180, 0.5) inset, 0 0 5px 2px rgba(255, 120, 120, 0.75), 0 0 10px 2px rgba(255, 120, 120, 0.75) inset !important;
    }

    button:hover.green-b {
        text-shadow: 0px 0px 2px rgba(170, 255, 190, 0.99), 0px 0px 4px rgba(140, 255, 160, 0.99);
        border-color: rgba(0, 0, 0, 0.6);
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 10px rgba(110, 255, 185, 0.5) inset, 0 0 5px 2px rgba(110, 255, 185, 0.75), 0 0 10px 2px rgba(110, 255, 185, 0.75) inset;
        background: #992399(data: image/svg+xml;
        base64, PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiM2ZWZmYjkiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjNmVmZmI5IiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(110, 255, 185, 1)), color-stop(100%, rgba(110, 255, 185, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(110, 255, 185, 1) 0%, rgba(110, 255, 185, 0) 100%);
        /* W3C */
    }

    button:active.green-b {
        text-shadow: 0px 0px 2px rgba(220, 255, 240, 0.99), 0px 0px 4px rgba(190, 255, 210, 0.99);
        border-color: rgba(110, 255, 185, 0.6) !important;
        box-shadow: 0 1px 0 0 rgba(110, 255, 185, 0.4) inset, 0 10px 0 0 rgba(110, 255, 185, 0.5) inset, 0 0 5px 2px rgba(110, 255, 185, 0.75), 0 0 10px 2px rgba(110, 255, 185, 0.75) inset !important;
    }

    button:hover.blue-b {
        text-shadow: 0px 0px 2px rgba(170, 200, 255, 0.99), 0px 0px 4px rgba(140, 170, 255, 0.99);
        border-color: rgba(0, 0, 0, 0.6);
        border-image: none;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.4) inset, 0 10px rgba(120, 200, 255, 0.5) inset, 0 0 5px 2px rgba(120, 200, 255, 0.75), 0 0 10px 2px rgba(120, 200, 255, 0.75) inset;
        background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iMCUiIHN0b3AtY29sb3I9IiM3OGM4ZmYiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSIxMDAlIiBzdG9wLWNvbG9yPSIjNzhjOGZmIiBzdG9wLW9wYWNpdHk9IjAiLz4KICA8L3JhZGlhbEdyYWRpZW50PgogIDxyZWN0IHg9Ii01MCIgeT0iLTUwIiB3aWR0aD0iMTAxIiBoZWlnaHQ9IjEwMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
        background: -moz-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* FF3.6+ */
        background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(120, 200, 255, 1)), color-stop(100%, rgba(120, 200, 255, 0)));
        /* Chrome,Safari4+ */
        background: -webkit-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* Chrome10+,Safari5.1+ */
        background: -o-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* Opera 12+ */
        background: -ms-radial-gradient(center, ellipse cover, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* IE10+ */
        background: radial-gradient(ellipse at center, rgba(120, 200, 255, 1) 0%, rgba(120, 200, 255, 0) 100%);
        /* W3C */
    }

    button:active.blue-b {
        text-shadow: 0px 0px 2px rgba(230, 240, 255, 0.99), 0px 0px 4px rgba(200, 210, 255, 0.99);
        border-color: rgba(120, 200, 255, 0.6) !important;
        box-shadow: 0 1px 0 0 rgba(120, 200, 255, 0.4) inset, 0 10px 0 0 rgba(120, 200, 255, 0.5) inset, 0 0 5px 2px rgba(120, 200, 255, 0.75), 0 0 10px 2px rgba(120, 200, 255, 0.75) inset !important;
    }

    .bg-grad{
        position: fixed;
        z-index:-1;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        opacity: 0;
        -webkit-transition: opacity 5s linear;
        transition: opacity 5s linear;
    }



</style>

</body>
</html>