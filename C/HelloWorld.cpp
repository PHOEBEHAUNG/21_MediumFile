#include <stdlib.h>
#include <stdio.h>

int carSpeed = 100;

int calculatePositionWithSpeed(int carPosition, int carDriveSecond, int carSpeed)
{
  return carPosition + (carSpeed * carDriveSecond);
}

int calculatePosition(int carPosition, int carDriveSecond)
{
  return carPosition + (carSpeed * carDriveSecond);
}

int main(int argc, char *grav[])
{
  int carDriveSecond = 10;
  int carPosition = 0;

  printf("Hello Phoebe's coding world.\n");
  printf("In this world, your car will only drive in %d km/hr.\n", carDriveSecond);

  carPosition = carPosition + (carSpeed * carDriveSecond);
  printf("Car's final position : %d.\n", carPosition);

  return 0;
}



