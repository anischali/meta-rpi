SUMMARY = "Deploy sevral dt-overlays on the target platform."
AUTHOR = "Anis CHALI"
LICENSE = "CLOSED"

SECTION = "BSP"

PV = "1.0"


S = "${WORKDIR}"

RDEPENDS:${PN} = " \
    bash \
"

SRC_URI = "\
    file://power-switch \
"


do_install() {
    install -D ${D}${bindir}
    install -m 0755 ${S}/power-switch ${D}${bindir}
}

FILES:${PN} = " \
    ${bindir}/power-switch \
"