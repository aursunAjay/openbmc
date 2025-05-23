SUMMARY = "A Library to Access SMI MIB Information"
HOMEPAGE = "https://www.ibr.cs.tu-bs.de/projects/libsmi"

LICENSE = "BSD-3-Clause & TCL"
LIC_FILES_CHKSUM = "file://COPYING;md5=3ad3076f9332343a21636cfd351f05b7"

SRC_URI = "https://www.ibr.cs.tu-bs.de/projects/${BPN}/download/${BP}.tar.gz \
           file://smi.conf \
           file://libsmi-fix-the-test-dump-files.patch \
           file://0001-Define-createIdentifierRef-prototype-in-yang-complex.patch \
           file://0001-parser-yang-Define-_DEFAULT_SOURCE.patch \
          "

SRC_URI[sha256sum] = "f21accdadb1bb328ea3f8a13fc34d715baac6e2db66065898346322c725754d3"

UPSTREAM_CHECK_URI = "https://repology.org/project/libsmi/information"
UPSTREAM_CHECK_REGEX = "${BPN}-(?P<pver>\d+(\.\d+)+)"

DEPENDS += "bison-native flex-native wget-native gawk-native"

inherit autotools-brokensep update-alternatives
ALTERNATIVE_PRIORITY = "50"
ALTERNATIVE:${PN}-yang = " ietf-interfaces ietf-netconf-acm ietf-netconf-with-defaults ietf-netconf"
ALTERNATIVE_LINK_NAME[ietf-interfaces] = "${datadir}/yang/ietf-interfaces.yang"
ALTERNATIVE_LINK_NAME[ietf-netconf-acm] = "${datadir}/yang/ietf-netconf-acm.yang"
ALTERNATIVE_LINK_NAME[ietf-netconf-with-defaults] = "${datadir}/yang/ietf-netconf-with-defaults.yang"
ALTERNATIVE_LINK_NAME[ietf-netconf] = "${datadir}/yang/ietf-netconf.yang"

EXTRA_OECONF:class-native = "ac_cv_path_SH=/bin/sh"
EXTRA_OECONF:class-target = "ac_cv_path_SH=/bin/sh ac_cv_path_WGET=${bindir}/wget ac_cv_path_AWK=${bindir}/awk"

do_install:append () {
    install -d ${D}${sysconfdir}
    install -m 0644 ${UNPACKDIR}/smi.conf ${D}${sysconfdir}/smi.conf
}

PACKAGES += "${PN}-mibs ${PN}-pibs ${PN}-yang"

FILES:${PN}-mibs += "${datadir}/mibs"
FILES:${PN}-pibs += "${datadir}/pibs"
FILES:${PN}-yang += "${datadir}/yang"

RRECOMMENDS:${PN} = "${BPN}-mibs"

BBCLASSEXTEND = "native nativesdk"
