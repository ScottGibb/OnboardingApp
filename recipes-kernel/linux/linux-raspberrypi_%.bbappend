SUMMARY = "Raspberry Pi kernel tweaks - using a fragment file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Linux Raspberry Pi Kernel Config appending *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# the fragment extension must be .cfg. You can add as many fragment as you want
SRC_URI += " file://config-rt.cfg"
