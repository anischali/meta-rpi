SUMMARY = "A small video stream server using ffmpeg"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SRC_URI = " \
    file://vstreamer.sh \
    file://vstreamer.service \
    "

RDEPENDS:${PN} += " \
    gstreamer1.0-plugins-good \
    vstreamer \
    ffmpeg \
    bash \
    "

S = "${WORKDIR}"

inherit systemd


do_install() {
	install -dm 0755 ${D}/dev
	install -dm 0755 ${D}/bin
	install -m 0755 ${S}/vstreamer.sh ${D}/bin//vstreamer.sh
    
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${S}/vstreamer.service ${D}${systemd_system_unitdir}/vstreamer.service
    fi
}

SYSTEMD_SERVICE:${PN} = "vstreamer.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} += " ${systemd_system_unitdir}/vstreamer.service /dev /bin/vstreamer.sh "