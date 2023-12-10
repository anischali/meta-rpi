SUMMARY = "Add an access point wlan configuration in dnsmasq"

FILESEXTRAPATHS:append := "${THISDIR}/files:"

SYSTEMD_AUTO_ENABLE = "enable"

SRC_URI:append = " \
    file://dnsmasq.conf \
    "

do_install:append() {
    install -m 644 ${WORKDIR}/dnsmasq.conf ${D}${sysconfdir}/
}