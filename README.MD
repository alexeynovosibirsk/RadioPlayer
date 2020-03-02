git clone --single-branch --branch raspberry git@github.com:nixoved/RadioPlayer.git

Install to Debian 10:

1. install minimum system
2. apt install xserver-xorg-video-all xserver-xorg-input-all xserver-xorg-core xinit x11-xserver-utils openssh-server alsa-utils nodm wicd openjdk-11-jre-headless
3. vi .bashrc
java -jar ...
4. Reduce time waiting bootloader:
- vi /etc/default/grub
- update-grub

--------
install wifi driver: 

- sudo apt-get install git dkms git make build-essential
- cd /usr/src
- sudo git clone https://github.com/lwfinger/rtl8188eu.git
- sudo dkms add ./rtl8188eu
- sudo dkms build 8188eu/1.0
- sudo dkms install 8188eu/1.0
- sudo modprobe 8188eu


