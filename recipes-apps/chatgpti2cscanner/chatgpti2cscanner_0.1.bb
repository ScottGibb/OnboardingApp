DESCRIPTION = "This is a chatgpt generated i2c scanner- uses a local source file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Compiling chatgpt i2c Scanner              *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

SRC_URI = "file://chatgpti2cscanner.c"

S = "${WORKDIR}"
TARGET_CC_ARCH += "${LDFLAGS}"


do_compile() {
	${CC} chatgpti2cscanner.c -o chatgpti2cscanner
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 chatgpti2cscanner ${D}${bindir}
}
ALLOW_EMPTY_${PN} = "1"