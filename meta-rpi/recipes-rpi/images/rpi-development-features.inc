SUMMARY = "This include file is used to add developpement tools"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

# Include modules in rootfs
IMAGE_INSTALL += " \
    kernel-modules \
    rpm \
    screen \
    net-tools \
    lsof \
    util-linux-lsblk \
    usbutils \
"


IMAGE_FEATURES += " \
    debug-tweaks \
    ssh-server-openssh \
    tools-debug \
"
