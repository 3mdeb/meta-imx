# Copyright (C) 2019-2021 NXP

SUMMARY = "Test program for v2x adaptation layer v2xhsm"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://BSD-3-Clause.txt;md5=664939843ae3416d811479b21978e8b4"

DEPENDS = "ecdsa-lib-imx v2xsehsm openssl"

SRCBRANCH = "version_0.4"
VTEST_SRC ?= "git://source.codeaurora.org/external/imx/vtest.git;protocol=ssh"
SRC_URI = "${VTEST_SRC};branch=${SRCBRANCH} \
    file://seco_nvm_daemon.service \
"
SRCREV = "440bf101c161e07771db220716f44d4321ebb917"

S = "${WORKDIR}/git"

inherit systemd cmake

SYSTEMD_SERVICE_${PN} = "seco_nvm_daemon.service"

EXTRA_OECMAKE += " \
    -DSECO_LIBS_DIR=${STAGING_DIR_TARGET}${libdir} \
    -DZLIB_DIR=${STAGING_DIR_TARGET}${libdir} \
    -DECC_SRC=${STAGING_DIR_TARGET}${libdir} \
    -DLTTNG_LIB=${STAGING_DIR_TARGET}${libdir}/liblttng-ust.so \
"

do_install_append() {
    install -d  ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/seco_nvm_daemon.service ${D}${systemd_system_unitdir}
}

COMPATIBLE_MACHINE = "(mx8dxl)"
