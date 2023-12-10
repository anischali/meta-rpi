# Add this class to use an initramfs
inherit deploy


RPI_INITRAMFS_IMAGE ?= ""

def get_initramfs(d):
    img = d.getVar('RPI_INITRAMFS_IMAGE')
    if img is None or img.isspace() or not img: 
        return ""
    else:
        return "{0}:do_image_complete".format(img)


do_add_initramfs[depends] = "\
    ${@get_initramfs(d)} \
"

do_add_initramfs() {
    if [ -n "${RPI_INITRAMFS_IMAGE}" ]; then
        initramfs_name="$(basename ${DEPLOY_DIR_IMAGE}/*.cpio.gz.u-boot)"
        install -Dm 644 "${DEPLOY_DIR_IMAGE}/${initramfs_name}" "${IMAGE_ROOTFS}/boot/initramfs.cpio.gz.u-boot"
    fi
}


FILES:${PN}-image = "/boot/initramfs.cpio.gz.u-boot"
addtask do_add_initramfs after do_rootfs before do_image_qa