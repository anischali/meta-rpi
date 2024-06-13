
SRC_URI += " \
    file://iptables.rules \
    file://ip6tables.rules \
"

IPTABLES_RULES_DIR ?= "${sysconfdir}/${BPN}"

do_install:append() {
    install -d ${D}${IPTABLES_RULES_DIR}
    install -m 0644 ${WORKDIR}/iptables.rules ${D}${IPTABLES_RULES_DIR}
    install -m 0644 ${WORKDIR}/ip6tables.rules ${D}${IPTABLES_RULES_DIR}
}