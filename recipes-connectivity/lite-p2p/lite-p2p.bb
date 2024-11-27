SUMMARY = "A lite peer to peer library"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI = "git://github.com/anischali/lite-p2p.git;branch=main;protocol=https"
SRC_URI[sha256sum] = "0e0d2807af2a0040d26d7160be1057eef8267f59d24a99ad4142a2f7c0169596"

PV = "0.1"

BB_STRICT_CHECKSUM = "0"

SRCREV = "${AUTOREV}"

inherit cmake pkgconfig

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "lite-p2p utils"
PACKAGECONFIG[debug] = "-DCMAKE_BUILD_TYPE=Debug,-DCMAKE_BUILD_TYPE=Release,"
PACKAGECONFIG[utils] = "-DLITE_P2P_TEST_TOOLS=ON,-DLITE_P2P_TEST_TOOLS=OFF,"

PACKAGES += "${@bb.utils.contains('PACKAGECONFIG', 'utils', '${PN}-utils', '', d)}"
FILES:${PN}-utils += "${bindir}"
RDEPENDS:${PN}-utils += "${PN}"