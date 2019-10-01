<style>
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
        background: #9c0700 linear-gradient(#d14a41, #9c1418);
        box-shadow: inset #de5441 0 -1px 1px, inset 0 1px 1px #ff5e0e, #aa563b 0 0 0 1px, rgba(0,0,0,.3) 0 2px 5px;
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
</style>