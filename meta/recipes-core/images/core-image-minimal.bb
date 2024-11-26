SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

inherit extrausers
EXTRA_USERS_PARAMS = " useradd user1; \
                       usermod  -p '\$1\$jxYAhslC\$eRGkDsjuO3bQKpTNH5dkI1' user1; \
                       usermod  -a -G sudo user1; \ 
                       "