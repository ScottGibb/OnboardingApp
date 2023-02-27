SUMMARY = "Get Light User Space Application "
DESCRIPTION = "Custom recipe to build getlight.c application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Get Light USer Space Application Recipe    *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

# Where to find source files
SRC_URI = "file://getlight.c"

# Where to keep downloaded source files (in tmp/work/...)
S = "${WORKDIR}"

#Pass arguments to linker
TARGET_CC_ARCH += "${LDFLAGS}"

# Cross-compile source code

do_compile() {
    ${CC} -o getlight getlight.c
}

# Create /usr/bin in rootfs and copy program to it
do_install() {
    install -d ${D}${bindir}
    install -m 0755 getlight ${D}${bindir}
}
ALLOW_EMPTY_${PN} = "1"