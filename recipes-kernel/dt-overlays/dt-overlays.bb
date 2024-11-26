SUMMARY = "Deploy sevral dt-overlays on the target platform."
AUTHOR = "Anis CHALI"
LICENSE = "CLOSED"

SECTION = "BSP"

PV = "1.0"

inherit devicetree

SRC_PLATFORM_PATH ?= ""
FILESEXTRAPATHS:prepend := "${THISDIR}/5.15:"

#SRC_URI = ""

DT_FILES_PATH:append: = "/${SRC_PLATFORM_PATH}"


COMPATIBLE_MACHINE = "(raspberry-pi0|raspberry-pi3b)"
