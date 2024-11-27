
# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb
require rpi-development-features.inc
inherit extrausers

CREDENTIAL_ROOT_PASSWD ?= "new_pass"
# The clear password with -P is not supported anymore.
PASSWD = "$(openssl passwd -6 ${CREDENTIAL_ROOT_PASSWD})"
# Sets a password for the root user
EXTRA_USERS_PARAMS = "\
    usermod -p ${PASSWD} root; \
"

SUMMARY = "Standard development image" 
DESCRIPTION = "Standard development image for raspberry pi"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"


IMAGE_INSTALL += " \
    ffmpeg \
    wpa-supplicant \
    netplan \
    v4l-utils \
    iw \
    gstreamer1.0 \
    gstreamer1.0-plugins-good \
    vstreamer \
    linux-firmware-bcm43430 \
    hostapd \
    dnsmasq \
    user-session \
    iptables \
    host-ctl \
    lite-p2p \
"