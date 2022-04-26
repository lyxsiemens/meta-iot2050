#!/bin/sh
set -e

signee=$1
signed=$2

usage(){
    echo "sign with custMpk key"
    echo "$0 signee signed"
    echo "signee: path to the image to be signed"
    echo "signed: path to store the signed image"
}


if [ -z "$signee" ] || [ -z "$signed" ]; then
    usage
    exit 1
fi

keydir=/usr/share/ebg-secure-boot-custmpk

sbsign --key ${keydir}/custMpk.pem --cert ${keydir}/custMpk.crt --output $signed $signee
