FILESEXTRAPATHS:prepend := "${THISDIR}/linux-raspberrypi:"

KMETA = "kernel-meta"

SRC_URI = " \
    git://github.com/raspberrypi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH} \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    file://rpi-kmeta;type=kmeta;name=rpi-kmeta;destsuffix=rpi-kmeta \ 
    "
SRC_URI:remove = "file://rpi-kernel-misc.cfg"

require linux-raspberrypi.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_EXTRA_ARGS:append:rpi = " DTC_FLAGS='-@ -H epapr'"


#KERNEL_FEATURES:raspberrypi0-wifi += " \"