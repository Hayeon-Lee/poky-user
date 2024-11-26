SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

inherit extrausers
EXTRA_USERS_PARAMS = " useradd customUser1; \
                       useradd customUser2; \
                       usermod  -p '\$1\$n8BAo.zu\$EXeUOcenBfplWYV5L4Juo0' customUser1; \
                       usermod  -p 'Password_2' customUser2; \
                       usermod  -a -G sudo customUser1; \
                       usermod  -a -G sudo customUser2;"