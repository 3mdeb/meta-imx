# Copyright 2020-2021 NXP
DESCRIPTION = "TensorFlow Lite VX Delegate"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7d6260e4f3f6f85de05af9c8f87e6fb5"

DEPENDS = "tensorflow-lite tim-vx"

require tensorflow-lite-${PV}.inc

#TODO check when CAF repository is created
TENSORFLOW_LITE_VX_DELEGATE_SRC ?= "git://source.codeaurora.org/external/imx/tflite-vx-delegate-imx.git;protocol=https" 
SRCBRANCH_vx = "imx-v2.6.0"
SRCREV_vx = "d243dc12aac05183865879a5f1a467c7d2c88a5b"

SRCREV_FORMAT = "vx_tf"
SRC_URI = "${TENSORFLOW_LITE_VX_DELEGATE_SRC};branch=${SRCBRANCH_vx};name=vx \
           ${TENSORFLOW_LITE_SRC};branch=${SRCBRANCH_tf};name=tf;destsuffix=tfgit \
           file://0001-CMakeLists.txt-Fix-TIM_VX-library-path.patch \
"

S = "${WORKDIR}/git"

inherit python3native cmake

EXTRA_OECMAKE = "-DCMAKE_SYSROOT=${PKG_CONFIG_SYSROOT_DIR}"
EXTRA_OECMAKE += " \
     -DTIM_VX_INSTALL=${STAGING_DIR_HOST}/usr \
     -DFETCHCONTENT_SOURCE_DIR_TENSORFLOW=${WORKDIR}/tfgit \
     -DVX_DELEGATE_USE_TFLITE_LIB_FROM_SDK=on \
     ${S} \
"

CXXFLAGS += "-fPIC"

do_configure:prepend() {
    export HTTP_PROXY=${http_proxy}
    export HTTPS_PROXY=${https_proxy}
    export http_proxy=${http_proxy}
    export https_proxy=${https_proxy}
}

do_install() {
    # install libraries
    install -d ${D}${libdir}
    for lib in ${B}/lib*.so*
    do
        cp --no-preserve=ownership -d $lib ${D}${libdir}
    done

    # install header files
    install -d ${D}${includedir}/tensorflow-lite-vx-delegate
    cd ${S}
    cp --parents \
        $(find . -name "*.h*") \
        ${D}${includedir}/tensorflow-lite-vx-delegate

}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# Output library is unversioned
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

COMPATIBLE_MACHINE          = "(^$)"
COMPATIBLE_MACHINE:imxgpu3d = "(mx8)"
COMPATIBLE_MACHINE:mx8mm    = "(^$)"
