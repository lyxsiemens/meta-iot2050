#
# Copyright (c) Siemens AG, 2022
#
# Authors:
#  Jan Kiszka <jan.kiszka@siemens.com>
#
# This file is subject to the terms and conditions of the MIT License.  See
# COPYING.MIT file in the top-level directory.
#

inherit dpkg-raw

DESCRIPTION = "Add custMpk-based secrets to the buildchroot and the script to \
               sign an image with the given key"

SRC_URI = " \
    file://sign_secure_image.sh \
    file://custMpk.crt \
    file://custMpk.pem"

DEBIAN_DEPENDS = "sbsigntool"

do_install() {
    TARGET=${D}/usr/bin
    install -d ${TARGET}
    install -m 755 ${WORKDIR}/sign_secure_image.sh ${TARGET}/sign_secure_image.sh

    TARGET=${D}/usr/share/ebg-secure-boot-custmpk
    install -m 0700 -d ${TARGET}
    install -m 0700 ${WORKDIR}/custMpk.* ${TARGET}/
}
