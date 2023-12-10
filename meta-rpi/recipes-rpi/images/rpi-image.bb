
# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb
require rpi-development-features.inc

SUMMARY = "Standard development image" 
DESCRIPTION = "Standard development image for raspberry pi"

LICENSE = "GPLv2"
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
    "