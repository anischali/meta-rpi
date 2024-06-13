FILESEXTRAPATHS:prepend := "${THISDIR}/5.15:"

SRC_URI:append = " \
    file://${MACHINE}-kmeta;type=kmeta;name=${MACHINE}-kmeta;destsuffix=${MACHINE}-kmeta \
"

KERNEL_FEATURES:raspberry-pi0:append = " \
    cfg/usb-gadgets/usb-gadgets.cfg \
"


KERNEL_MODULE_AUTOLOAD:raspberry-pi0:append = " \
    ${@bb.utils.contains("MACHINE_FEATURES", "usbgadget", "g_ether", "", d)} \
"