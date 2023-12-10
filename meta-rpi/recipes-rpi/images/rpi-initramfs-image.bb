# initramfs image.
DESCRIPTION = "RPI initramfs image"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit core-image


SYSTEMD_DEFAULT_TARGET = "initrd.target"


PACKAGE_INSTALL += " \
    kernel-modules \
"

IMAGE_FSTYPES = "cpio.gz.u-boot"



