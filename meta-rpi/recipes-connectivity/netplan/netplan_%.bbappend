SUMMARY = "Add a dhcp auto configuration for eth0"

FILESEXTRAPATHS:append := "${THISDIR}/files:"

SYSTEMD_AUTO_ENABLE = "enable"

SRC_URI:append = " \
    file://99-config.yaml \
    "

do_install:append() {
    install -m 0664 ${WORKDIR}/99-config.yaml ${D}${sysconfdir}/netplan/
}