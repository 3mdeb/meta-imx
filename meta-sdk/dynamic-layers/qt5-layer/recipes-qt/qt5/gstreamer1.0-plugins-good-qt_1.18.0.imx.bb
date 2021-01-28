require recipes-multimedia/gstreamer/gstreamer1.0-plugins-common.inc

GST1.0-PLUGINS-GOOD_SRC ?= "gitsm://source.codeaurora.org/external/imx/gst-plugins-good.git;protocol=https"
SRCBRANCH = "imx-1.18.x"

SRC_URI = " \
    ${GST1.0-PLUGINS-GOOD_SRC};branch=${SRCBRANCH} \
"
SRCREV = "dfb3ded0e1dc4216c14f1ffc59f57de4e5a494f5"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"

LICENSE = "GPLv2+ & LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe"

DEPENDS += "gstreamer1.0-plugins-base virtual/kernel libcap zlib bzip2 \
            ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
"

# Make sure kernel sources are available
do_configure[depends] += "virtual/kernel:do_shared_workdir"

PACKAGECONFIG += "qt5"
PACKAGECONFIG[qt5] = '-Dqt5=enabled \
                     ,-Dqt5=disabled,qtbase qtdeclarative qtbase-native qtx11extras'

# remove the duplicate libs except qtsink
do_install_append() {
    rm -rf ${D}/usr
    if [ -e ${WORKDIR}/build/ext/qt/libgstqmlgl.so ]; then
        mkdir -p ${D}${libdir}/gstreamer-1.0/
        install -m 0755 ${WORKDIR}/build/ext/qt/libgstqmlgl.so ${D}${libdir}/gstreamer-1.0/
    fi
}


FILES_${PN}-equalizer += "${datadir}/gstreamer-1.0/presets/*.prs"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
