# Copyright (C) 2014,2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-multimedia/gstreamer/gst-fsl-plugin.inc

SRC_URI = "${FSL_MIRROR}/gst1.0-fsl-plugins-${PV}.tar.gz"
S = "${WORKDIR}/gst1.0-fsl-plugins-${PV}"

EXTRA_OECONF += " CROSS_ROOT=${PKG_CONFIG_SYSROOT_DIR}"

SRC_URI[md5sum] = "03b2b54e9344a7e1fbfcf4c8b693487c"
SRC_URI[sha256sum] = "912843d04850bcf081723e12eb2a2627f78e68f6ae3674fb06ea2ea664063a5f"

DEPENDS_append = " gstreamer1.0 gstreamer1.0-plugins-base"
DEPENDS_append_mx6ul = " imx-lib"
DEPENDS_append_mx7 = " imx-lib"
RDEPENDS_${PN} += "gstreamer1.0-plugins-good-id3demux"

PLATFORM_mx6ul= "MX6UL"
PLATFORM_mx7= "MX7D"

PACKAGECONFIG ?= ""
PACKAGECONFIG_mx6 = "overlaysink"
PACKAGECONFIG_mx6ul = ""

# FIXME: Add all features
# feature from excluded mm packages
PACKAGECONFIG[ac3] += ",,libfslac3codec,libfslac3codec"
# feature from special mm packages
PACKAGECONFIG[aacp] += ",,libfslaacpcodec,libfslaacpcodec"
MSDEPENDS = "libfslmsparser libfslmscodec"
PACKAGECONFIG[wma10dec] += ",,${MSDEPENDS},${MSDEPENDS}"
PACKAGECONFIG[wma8enc] += "--enable-wma8enc,--disable-wma8enc,${MSDEPENDS},${MSDEPENDS}"
OVDEPENDS = "virtual/libg2d"
PACKAGECONFIG[overlaysink] += "--enable-overlaysink,--disable-overlaysink, ${OVDEPENDS}"

# Add grecorder packages
PACKAGES += "${PN}-grecorder ${PN}-librecorder_engine"

FILES_${PN} = "${libdir}/gstreamer-1.0/*.so ${datadir}"
FILES_${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-1.0/*.la ${libdir}/pkgconfig/*.pc"
FILES_${PN}-staticdev += "${libdir}/gstreamer-1.0/*.a"
FILES_${PN}-gplay = "${bindir}/gplay-1.0"
FILES_${PN}-libgplaycore = "${libdir}/libgplaycore-1.0${SOLIBS}"
FILES_${PN}-libgstfsl = "${libdir}/libgstfsl-1.0${SOLIBS}"
FILES_${PN}-grecorder = "${bindir}/grecorder-1.0"
FILES_${PN}-librecorder_engine = "${libdir}/librecorder_engine-1.0${SOLIBS}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7)"
