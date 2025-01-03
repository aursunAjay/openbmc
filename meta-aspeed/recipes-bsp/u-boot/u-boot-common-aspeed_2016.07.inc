HOMEPAGE = "https://github.com/openbmc/u-boot"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse

SRCREV = "9b3df1b776a2bc5a3b266ee66c6c680d77e3d892"

#UBRANCH = "v2016.07-aspeed-openbmc"

UBRANCH = "u-boot-krutrim"

SRC_URI = "git://git@github.com/aursunAjay/u-boot.git;branch=${UBRANCH};protocol=https"

S = "${WORKDIR}/git"

PV = "v0.1+git${SRCPV}"
