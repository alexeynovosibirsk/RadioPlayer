Install to Debian 10:

1. install minimum system
2. apt install openbox nodm openssh-server openjdk-11-jre-headless wicd
3. make autostart app:
- mkdir .config/openbox
- vi .config/openbox/autostart :
  mlterm -e java -jar /root/webRadio.jar
4. Reduce time waiting bootloader:
- vi /etc/default/grub
- update-grub

--------
install wifi driver: 

sudo apt-get install git dkms git make build-essential
cd /usr/src
sudo git clone https://github.com/lwfinger/rtl8188eu.git
sudo dkms add ./rtl8188eu
sudo dkms build 8188eu/1.0
sudo dkms install 8188eu/1.0
sudo modprobe 8188eu
