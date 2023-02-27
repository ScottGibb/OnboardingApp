DESCRIPTION = "This is a simple Hello World recipe - uses a local source file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Compiling Hello World Example              *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

SRC_URI = "file://helloworld.c"

S = "${WORKDIR}"
TARGET_CC_ARCH += "${LDFLAGS}"


do_compile() {
	${CC} helloworld.c -o helloworld
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 helloworld ${D}${bindir}
}
ALLOW_EMPTY_${PN} = "1"