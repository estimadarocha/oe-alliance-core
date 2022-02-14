KV = "4.4.35"
SRCDATE = "20220208"

RDEPENDS:${PN} = "libjpeg-turbo pulseaudio-lib-rtp"
PROVIDES = "virtual/blindscan-dvbs"

require gfutures-dvb-modules.inc

SRC_URI:append = " file://suspend.sh"

SRC_URI[md5sum] = "7b61a1950d9e9846bf84925083ee6327"
SRC_URI[sha256sum] = "6cce2b4fa32dfe27aca78cbc4c0c6915723eace4f2adda0f62d7bb66fd552678"

INITSCRIPT_NAME = "suspend"
INITSCRIPT_PARAMS = "start 89 0 ."
inherit update-rc.d

do_install:append() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${bindir}
	install -m 0755 ${S}/suspend.sh ${D}${sysconfdir}/init.d/suspend
	install -m 0755 ${S}/turnoff_power ${D}${bindir}
}

do_package_qa() {
}

FILES:${PN} += " ${bindir} ${sysconfdir}/init.d"

INSANE_SKIP:${PN} += "already-stripped ldflags"
