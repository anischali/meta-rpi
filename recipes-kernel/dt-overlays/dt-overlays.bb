SUMMARY = "Deploy sevral dt-overlays on the target platform."
AUTHOR = "Anis CHALI"
LICENSE = "CLOSED"
HOMEPAGE = "exfo.com"

SECTION = "BSP"

PV = "1.0"

inherit devicetree

SRC_PLATFORM_PATH ?= ""
FILESEXTRAPATHS:prepend := "${THISDIR}/5.15:"

SRC_URI = "\
    file://${SRC_PLATFORM_PATH}/gpio-rfkill.dts \
"

DT_FILES_PATH:append: = "/${SRC_PLATFORM_PATH}"


COMPATIBLE_MACHINE = "(pcb281-generic)"