# Copyright 2017-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

require imx-mcore-demos-2.8.inc

LIC_FILES_CHKSUM_mx8dxl = "file://COPYING;md5=cf3f9b8d09bc3926b1004ea71f7a248a"
LIC_FILES_CHKSUM = "file://COPYING;md5=a632fefd1c359980434f9389833cab3a" 

SRC_URI[imx8dxl.md5sum] = "8850c04a8af91e2bd822cecd5ec56e12"
SRC_URI[imx8dxl.sha256sum] = "66ddba970712ed394de4034b362334a12caa5865a6afc1dfb5a897bb55b4fcf1"

SRC_URI[imx8mq.md5sum] = "4500e56895e06ccc58edd029d0a0612f"
SRC_URI[imx8mq.sha256sum] = "9f8df501a16ede9e06d7557e69db87cdfe055368090c52a52b5c6afec7829c87"

SRC_URI[imx8qm.md5sum] = "5912ca94847ee56a7e8b866b211b67d9"
SRC_URI[imx8qm.sha256sum] = "c695e72b0c7f609132f5990469cf950c03e137de887bd7e24d059c51a7b499be"

SRC_URI[imx8qx.md5sum] = "5bc15014f59b2b11c71299fac608be5d"
SRC_URI[imx8qx.sha256sum] = "bbb268a30a58a86e38966122191c8aa69f427c6c1d56b0ce81e518f4d652782a"

COMPATIBLE_MACHINE = "(mx8dxl|mx8mq|mx8qm|mx8qxp)"
