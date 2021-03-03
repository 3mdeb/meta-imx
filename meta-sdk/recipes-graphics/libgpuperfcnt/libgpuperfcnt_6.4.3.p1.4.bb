DESCRIPTION = "A library to retrieve i.MX GPU performance data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=a632fefd1c359980434f9389833cab3a" 

SRC_URI[arm-fb.md5sum] = "d743b84421307d88140e05367db848d1"
SRC_URI[arm-fb.sha256sum] = "488558842ee12ed3c4eca9961c3a8fc4e52b20735089d36d986b77f3b35914ca"

SRC_URI[arm-wayland.md5sum] = "5b58c2f91a2b653fe89fde5259de41cb"
SRC_URI[arm-wayland.sha256sum] = "053373be57e529fe841b2041d33951ee84fdcb250147ec5a5b49e7bd5d9170d8"

SRC_URI[arm-x11.md5sum] = "d28439180e6cade50f0081fad6adb1ea"
SRC_URI[arm-x11.sha256sum] = "c0507abd84a1d9235fe32a35d6f9817e7122af523b9e62f4575feb1c389e9587"

SRC_URI[aarch64-fb.md5sum] = "dd5297ed480e142177edda857cf0f158"
SRC_URI[aarch64-fb.sha256sum] = "b4019a87750fc57adf5b7733e895b24e895bdb63d4428c9e77e8ff06c01b6b85"

SRC_URI[aarch64-wayland.md5sum] = "68de4094628ff4433c9f70a039a432f6"
SRC_URI[aarch64-wayland.sha256sum] = "12f6e094e16369abf4905ba4c402c324b5d4705228fea51fdb6872fa693bd760"

SRC_URI[aarch64-x11.md5sum] = "c6a7ea6ea5f4641d6c63e6f8e879ae2f"
SRC_URI[aarch64-x11.sha256sum] = "4296614e0525c55631ef867a8968bc2dd996377c8cf72f2f742d0368231ee1e1"

inherit fsl-eula-unpack2 fsl-eula-graphics

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

RDEPENDS_${PN} = "imx-gpu-viv"

# Compatible only with i.MX with GPU
COMPATIBLE_MACHINE        = "(^$)"
COMPATIBLE_MACHINE_imxgpu = "${MACHINE}"
