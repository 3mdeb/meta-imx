# Copyright 2017-2022 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

require imx-mcore-demos.inc

LIC_FILES_CHKSUM:mx8mm-nxp-bsp = "file://COPYING;md5=5a0bf11f745e68024f37b4724a5364fe"
LIC_FILES_CHKSUM:mx8mq-nxp-bsp = "file://COPYING;md5=add2d392714d3096ed7e0f7e2190724b"
LIC_FILES_CHKSUM:mx7ulp-nxp-bsp = "file://COPYING;md5=add2d392714d3096ed7e0f7e2190724b"

SRC_URI[imx8mm.md5sum] = "c2261058127d67605910b048585d6b67"
SRC_URI[imx8mm.sha256sum] = "0150edef613130b8c09644356087185a370e4148bc6974eac47b8b01b2735b72"

SRC_URI[imx8mq.md5sum] = "2860266c99a4535c2bd14adb7ceaf6ba"
SRC_URI[imx8mq.sha256sum] = "cc13003b637d6912780dc70f37c78b60403a080c6edbb0bf3c7f9bf5a2f98971"

SRC_URI[imx7ulp.md5sum] = "5ca17160cfbac5ce84d9f0fa04cf9ecf"
SRC_URI[imx7ulp.sha256sum] = "eba89bcd1c162a5d81707abdba5bea2ef862acd8c5558bce2f3435e27c00ada9"

COMPATIBLE_MACHINE = "(mx7ulp-nxp-bsp|mx8mm-nxp-bsp|mx8mq-nxp-bsp)"