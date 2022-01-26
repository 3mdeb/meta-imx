# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Multimedia VPU wrapper"
LICENSE = "Proprietary"
SECTION = "multimedia"
LIC_FILES_CHKSUM = "file://COPYING;md5=${FSL_EULA_FILE_MD5SUM}"

DEPENDS = "virtual/imxvpu"
DEPENDS:append:mx8mp = " imx-vpu-hantro-vc"

IMX_VPUWRAP_SRC ?= "git://github.com/NXP/imx-vpuwrap.git;protocol=https"
SRC_URI = "${IMX_VPUWRAP_SRC};branch=${SRCBRANCH}"

SRCBRANCH = "master"
SRCREV = "8c3e8001b2a761d3e9e67624d05753e14d3a4c3d"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_install:append() {
    # FIXME: Drop examples for now
    rm -r ${D}${datadir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(imxvpu)"
