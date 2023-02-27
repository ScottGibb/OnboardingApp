#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/ioctl.h>
#include <linux/i2c-dev.h>

void main(int bus)
{
    char filename[20];
    int fd, i, j, address;

    snprintf(filename, 19, "/dev/i2c-%d", bus);

    if ((fd = open(filename, O_RDWR)) < 0) {
        perror("open");
        return;
    }

    printf("     ");
    for (i = 0; i < 16; i++) {
        printf("%02X ", i);
    }
    printf("\n");

    for (i = 0; i < 128; i += 16) {
        printf("%02X: ", i);
        for (j = 0; j < 16; j++) {
            address = i + j;
            if (ioctl(fd, I2C_SLAVE, address) < 0) {
                printf("UU ");
            } else {
                printf("%02X ", address);
            }
        }
        printf("\n");
    }

    close(fd);
}