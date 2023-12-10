SUMMARY = "Add an access point wlan configuration in hostapd"

FILESEXTRAPATHS:append := "${THISDIR}/files:"

SYSTEMD_AUTO_ENABLE = "enable"

SRC_URI:append = " \
    file://hostapd.conf \
    "

do_install:append() {
    install -m 0664 ${WORKDIR}/hostapd.conf ${D}${sysconfdir}/hostapd.conf
    install -m 0644 ${WORKDIR}/hostapd.service ${D}${systemd_unitdir}/system/
}