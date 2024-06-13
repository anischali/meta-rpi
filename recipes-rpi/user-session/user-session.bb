SUMMARY = "A recipe to create a user"
LICENSE = "CLOSED"

inherit useradd

PV = "1.0"

S = "${WORKDIR}"

EXCLUDE_FROM_WORLD = "1"

CREDENTIAL_PASSWD ?= "user"
CREDENTIAL_USER ?= "user"
CREDENTIAL_USER_ID ?= "800"

PASSWD = "$(openssl passwd -6 ${CREDENTIAL_PASSWD})"

USERADD_PARAM:${PN} = "-p '${PASSWD}' -u ${CREDENTIAL_USER_ID} -d /home/users/${CREDENTIAL_USER} -r -s /bin/bash ${CREDENTIAL_USER}"

PACKAGES = "${PN}"

USERADD_PACKAGES = "${PN}"

GROUPADD_PARAM:${PN} = "\
 -r -f input; \
 -r -f power; \
 -r -f networking; \
 -r -f visibog \
 -r -f sudo \
"

RDEPENDS:${PN} += " \
    sudo-sudo \
    sudo-lib \
"

DEPENDS += "openssl-native"

ALLOW_EMPTY:${PN} = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

SRC_URI = "\
    file://99-sudo.conf \
"

FILES:{PN} += " \
    ${sysconfdir}/sudoers.d/99-sudo.conf \
"

do_install () {
    install -d ${D}${sysconfdir}/sudoers.d/
    install -m 0660 ${S}/99-sudo.conf ${D}${sysconfdir}/sudoers.d/
}

# rconflicts with linux firmware nxp89xx
RREPLACES:${PN} = "sudo"
RCONFLICTS:${PN} = "sudo"
RPROVIDES:${PN} = "sudo"

