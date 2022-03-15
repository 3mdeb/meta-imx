DESCRIPTION = "A library to retrieve i.MX GPU performance data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=be5ff43682ed6c57dfcbeb97651c2829"

SRC_URI[arm-fb.md5sum] = "990f65d1bb7c37b2a6a7e9311fe69d57"
SRC_URI[arm-fb.sha256sum] = "7c74e017490855ad5e7fbe62d4d7e4b898b542976ca647d0e5f1108cdc873355"

SRC_URI[arm-wayland.md5sum] = "4993a6e924c3a0239b1595808b9003d1"
SRC_URI[arm-wayland.sha256sum] = "ebb1f64b9ce2f27b7e2c2042bf9c402f79d36088b208e63edbc4f2c58944dc18"

SRC_URI[arm-x11.md5sum] = "62788042779d29e9f69931f607c79826"
SRC_URI[arm-x11.sha256sum] = "35fb8d4fb54e0a64d783ee0d602c42b5bc1511f0c8dd4a0946a287cf6247f80b"

SRC_URI[aarch64-fb.md5sum] = "87163a5e983e9016c5c4811ecfc190fb"
SRC_URI[aarch64-fb.sha256sum] = "9ef818398077493551185925974fced3b81aff5bf15e77942a232557229c881e"

SRC_URI[aarch64-wayland.md5sum] = "29b3c472c3e509853ced72a6a1a9ceac"
SRC_URI[aarch64-wayland.sha256sum] = "bef1e9859c495e14a4402aaa5b87adaa50e0889fb674c25bc35dd40bb50995a7"

SRC_URI[aarch64-x11.md5sum] = "bb862e55b8ee79ee5a83b0119618cd07"
SRC_URI[aarch64-x11.sha256sum] = "85c1b51d33e5939600af311d509191387b864db2e0b55e11347b93831e662228"

inherit fsl-eula-unpack2 fsl-eula-graphics

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

RDEPENDS_${PN} = "imx-gpu-viv"

# Compatible only with i.MX with GPU
COMPATIBLE_MACHINE        = "(^$)"
COMPATIBLE_MACHINE_imxgpu = "${MACHINE}"
