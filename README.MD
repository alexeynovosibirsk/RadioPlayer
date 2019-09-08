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
