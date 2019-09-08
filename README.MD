Install to CentOS 7:
1. install minimum system
2. yum install alsa-utils
3. yum groupinstall "X Window System"

1. remove the original getty@tty1.service symlink:
CODE: SELECT ALL

# rm /etc/systemd/system/getty.target.wants/getty@tty1.service
2. make a copy of the getty@.service file and call it getty@tty1.service
CODE: SELECT ALL

# cp /lib/systemd/system/getty@.service /etc/systemd/system/getty@tty1.service
3. edit this file (the last line, must be ADDED):
CODE: SELECT ALL

[Service]
...
ExecStart=-/sbin/agetty --autologin root --noclear %I
...
[Install]
...
;Alias=getty@tty1.service
4. make a symlink in getty.target.wants
CODE: SELECT ALL

# ln -s /etc/systemd/system/getty@tty1.service /etc/systemd/system/getty.target.wants/getty@tty1.service
5. Reboot. It everything went fine you will be logged in as root.
