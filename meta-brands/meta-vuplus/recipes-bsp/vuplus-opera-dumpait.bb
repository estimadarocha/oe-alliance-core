SUMMARY = "dumpait"
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=5ed852a46d22220a8b07a68e564d84c7"

inherit autotools-brokensep pkgconfig gitpkgv

SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r11"

DEPENDS = "libdvbsi++"

SRC_URI = "git://code.vuplus.com/git/dumpait.git;protocol=http"

S = "${WORKDIR}/git"
DESTDIR = "enigma2/python/Plugins/Extensions/HbbTV"

do_install() {
    install -d ${D}${libdir}/${DESTDIR}
    install -m 0755 ${S}/src/dumpait ${D}${libdir}/${DESTDIR}
}

FILES:${PN} = "${libdir}/${DESTDIR}/dumpait"
FILES:${PN}-dbg = "${libdir}/${DESTDIR}/.debug"
FILES:${PN}-src = "/usr/src"
