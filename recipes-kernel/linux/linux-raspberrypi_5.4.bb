LINUX_VERSION ?= "5.4.72"
LINUX_RPI_BRANCH ?= "rpi-5.4.y"
LINUX_RPI_KMETA_BRANCH ?= "yocto-5.4"

SRCREV = "ec0dcf3064b8ba99f226438214407fcea9870f76"

require linux-raspberrypi_5.4.inc

SRC_URI += "file://0001-Revert-selftests-bpf-Skip-perf-hw-events-test-if-the.patch \
            file://0002-Revert-selftests-bpf-Fix-perf_buffer-test-on-systems.patch \
            file://powersave.cfg \
            file://android-drivers.cfg \
           "
