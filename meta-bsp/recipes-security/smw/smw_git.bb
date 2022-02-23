# Copyright 2020-21 NXP

SUMMARY = "NXP i.MX Security Middleware Library"
DESCRIPTION = "NXP i.MX Security Middleware Library"
SECTION = "base"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=8636bd68fc00cc6a3809b7b58b45f982"

DEPENDS = "json-c optee-os optee-client python3-pycryptodomex-native"
DEPENDS:append:mx8qxp-nxp-bsp = " imx-seco-libs"

SRCBRANCH = "master"
SMW_LIB_SRC ?= "git://source.codeaurora.org/external/imx/imx-smw.git;protocol=https"
SRC_URI = "${SMW_LIB_SRC};branch=${SRCBRANCH}"
SRCREV = "40a8857fbc3f72d091357de1b4cf2f4a5a7afbbc"

S = "${WORKDIR}/git"

inherit cmake python3native

OPTEE_OS_TA_EXPORT_DIR:aarch64 = "${STAGING_INCDIR}/optee/export-user_ta_arm64"
OPTEE_OS_TA_EXPORT_DIR:arm = "${STAGING_INCDIR}/optee/export-user_ta_arm32"

EXTRA_OECMAKE = " \
    -DTA_DEV_KIT_ROOT=${OPTEE_OS_TA_EXPORT_DIR} \
    -DTEEC_ROOT=${STAGING_DIR_HOST} \
    -DJSONC_ROOT="${COMPONENTS_DIR}/${TARGET_ARCH}/json-c/usr" \
"
EXTRA_OECMAKE:append:mx8qxp-nxp-bsp = " -DSECO_ROOT=${STAGING_INCDIR}"

OECMAKE_TARGET_COMPILE += "build_tests"
OECMAKE_TARGET_INSTALL += "install_tests"

PACKAGES =+ "${PN}-tests"

FILES:${PN} += "${base_libdir}/optee_armtz/*"

FILES:${PN}-tests = "${bindir}/* ${datadir}/${BPN}/*"

RDEPENDS:${PN}-tests += "bash cmake"

COMPATIBLE_MACHINE = "(imx-nxp-bsp)"
