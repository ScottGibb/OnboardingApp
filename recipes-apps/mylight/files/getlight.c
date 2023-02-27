#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <fcntl.h>
#include <unistd.h>
#include <linux/i2c-dev.h>
#include <sys/ioctl.h>

#define I2C_BUS "/dev/i2c-1" // I2C bus device file
#define I2C_ADDR 0x23        // I2C address of BH1750 sensor

int main(void) {
    int fd;
    uint8_t data[2];
    float lux;

    // Open the I2C bus
    if ((fd = open(I2C_BUS, O_RDWR)) < 0) {
        perror("Failed to open I2C bus");
        return 1;
    }

    // Set the I2C address of the BH1750 sensor
    if (ioctl(fd, I2C_SLAVE, I2C_ADDR) < 0) {
        perror("Failed to set I2C address");
        close(fd);
        return 1;
    }

    // Power on the sensor and set measurement mode
    data[0] = 0x01;
    data[1] = 0x10;
    if (write(fd, data, 2) != 2) {
        perror("Failed to set measurement mode");
        close(fd);
        return 1;
    }

    while (1) {
        // Read the sensor value
        if (read(fd, data, 2) != 2) {
            perror("Failed to read sensor data");
            close(fd);
            return 1;
        }
        lux = (data[0] << 8 | data[1]) / 1.2;
        printf("Lux: %.2f\n", lux);
        usleep(500000);
    }

    // Close the I2C bus
    close(fd);

    return 0;
}