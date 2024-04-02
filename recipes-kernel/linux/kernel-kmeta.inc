FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI:append = " \
    file://${MACHINE}-kmeta;type=kmeta;name=${MACHINE}-kmeta;destsuffix=${MACHINE}-kmeta \
"

KERNEL_FEATURES:append:raspberry-pi0 = " \
    cfg/usb-gadgets/usb-gadgets.cfg \
"


KERNEL_MODULE_AUTOLOAD:append:raspberry-pi0 = " \
    ${@bb.utils.contains("MACHINE_FEATURES", "usbgadget", "g_ether", "", d)} \
"