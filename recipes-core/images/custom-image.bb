SUMMARY = "My Custom Linux Image from DigiKey Tutorial Part 4"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
inherit extrausers

# set rootfs to 200MiB by default

IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_ROOTFS_SIZE ?= "204800"


# change root password to "root"
EXTRA_USERS_PARAMS = "\
 usermod -P 'Witekio' root \
 "

# Add Kernel modules
# IMAGE_INSTALL_append += " kernel-modules-bh1750"
# KERNEL_MODULE_AUTOLOAD += "bh1750"



#Build and put into usr/lib folder (inside rootfs)
IMAGE_INSTALL:append = " libgpiod"
# can set i2ctools using menuconfig busybox
IMAGE_INSTALL:append = " i2c-tools"
#can set libiio using menuconfig virtual/kernel and sevedefconfig virtual/kernel
IMAGE_INSTALL:append = " libiio"

# Marvens Code
# RPI_KERNEL_DEVICETREE_OVERLAYS:append = " overlays/i2c-sensor.dtbo"
# KERNEL_MODULE_AUTOLOAD:rpi += " i2c-dev i2c-bcm2708 bh1750" 
# RPI_EXTRA_CONFIG += "\n dtoverlay=i2c-sensor,bh1750=0x23 \n"

# Add Custom applications
IMAGE_INSTALL:append += " getlight"
IMAGE_INSTALL:append += " helloworld"
IMAGE_INSTALL:append += " chatgpti2cscanner"