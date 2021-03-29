#include <math.h>
#include <stdlib.h>
#include <stdarg.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <sys/time.h>
#include <unistd.h>
#include <float.h>

#include <iostream>
#include <limits>

using namespace std;

template<typename T>
void showMinMax() {
   cout << "min: " << numeric_limits<T>::min() << endl;
   cout << "max: " << numeric_limits<T>::max() << endl;
   cout << endl;
}

void PRINTBGDEFAULT()
{ 
  printf("\033[49m");
}

void PRINTBGBLACK()
{ 
  printf("\033[40m");
}

void PRINTBGWHITE()
{ 
  printf("\033[41m"); /// red
  printf("\033[42m"); /// green
  printf("\033[43m"); /// yellow
  printf("\033[44m"); /// blue
  printf("\033[45m"); /// purple
  printf("\033[46m"); /// green blue
  printf("\033[48m"); /// green blue
  printf("\033[47m");
}

void PRINTBOLDRED(char *msg)
{
  printf("\033[1;31m");
  printf("%s", msg);
  printf("\033[0m");
}

void PRINTRED(char *msg)
{
  printf("\033[0;31m");
  printf("%s", msg);
  printf("\033[0m");
}

void PRINTBOLDGREEN(char *msg)
{
  printf("\033[1;31m");
  printf("%s", msg);
  printf("\033[0m");
}

void PRINTGREEN(char *msg)
{
  printf("\033[1;32m");
  printf("%s", msg);
  printf("\033[0m");
}

void PRINTBOLDYELLOW(char *msg)
{
  printf("\033[1;33m");
  printf("%s", msg);
  printf("\033[0m");
}

void PRINTYELLOW(char *msg)
{
  printf("\033[1;33m");
  printf("%s", msg);
  printf("\033[0m");
}

int main(int argc, char* argv[])
{
  bool boolVal = true;
  char charVal = 0;
  unsigned char unCharVal= 0;

  short shortVal = 0;
  unsigned short unShortVal = 0;
  int intVal = 0;
  unsigned int unIntVal = 0;
  long longVal = 0;
  unsigned long unLongVal = 0;

  float floatVal = 0;
  double doubleVal = 0;
  long double longDoubleVal = 0;

  printf("=====================================================================================\n|");
  printf("CHK bool           size : %lu| Max : %20d| Min : %20d|\n", sizeof(bool), numeric_limits<bool>::max(), numeric_limits<bool>::min());

  printf("=====================================================================================\n|");
  charVal = 0x7f; /// 十六進位
  printf("CHK char           size : %lu| Max : %20d| ", sizeof(char), (int)charVal);
  charVal = 0x80; /// 十六進位
  printf("Min : %20d|\n", (int)charVal);

  printf("=====================================================================================\n|");
  unCharVal = 0xff; /// 十六進位
  printf("CHK unsigned char  size : %lu| Max : %20d| ", sizeof(unsigned char), (int)unCharVal);
  unCharVal = 0x0; /// 十六進位
  printf("Min : %20d|\n", (int)unCharVal);

  printf("=====================================================================================\n|");
  shortVal = 0x7fff; /// 十六進位
  printf("CHK short          size : %lu| Max : %20hd| ", sizeof(short), shortVal);
  shortVal = 0x8000; /// 十六進位
  printf("Min : %20hd|\n", shortVal);

  printf("=====================================================================================\n|");
  unShortVal = 0xffff; /// 十六進位
  printf("CHK unsigned short size : %lu| Max : %20hu| ", sizeof(unsigned short), unShortVal);
  unShortVal = 0x0000; /// 十六進位
  printf("Min : %20hu|\n", unShortVal);

  printf("=====================================================================================\n|");
  intVal = 0x7fffffff; /// 十六進位
  printf("CHK int            size : %lu| Max : %20d| ", sizeof(int), intVal);
  intVal = 0x80000000; /// 十六進位
  printf("Min : %20d|\n", intVal);
  
  printf("=====================================================================================\n|");
  unIntVal = 0xffffffff; /// 十六進位
  printf("CHK unsigned int   size : %lu| Max : %20u| ", sizeof(unsigned int), unIntVal);
  unIntVal = 0x00000000; /// 十六進位
  printf("Min : %20u|\n", unIntVal);

  printf("=====================================================================================\n|");
  longVal = 0x7fffffffffffffff; /// 十六進位
  printf("CHK long           size : %lu| Max : %20ld| ", sizeof(long), longVal);
  longVal = 0x8000000000000000; /// 十六進位
  printf("Min : %20ld|\n", longVal);

  printf("=====================================================================================\n|");
  unLongVal = 0xffffffffffffffff; /// 十六進位
  printf("CHK unsigned long  size : %lu| Max : %20lu| ", sizeof(unsigned long), unLongVal);
  unLongVal = 0x0000000000000000; /// 十六進位
  printf("Min : %20lu|\n", unLongVal);

  printf("=====================================================================================\n|");
  printf("CHK float          size : %lu| Max : %20E| Min : %20E|\n", sizeof(float), FLT_MAX, FLT_MIN);
  printf("=====================================================================================\n|");
  printf("CHK double         size : %lu| Max : %20E| Min : %20E|\n", sizeof(double), DBL_MAX, DBL_MIN);
  printf("=====================================================================================\n|");
  printf("CHK long double    size :%lu| Max : %20LG| Min : %20LG|\n", sizeof(long double), numeric_limits<long double>::max(), numeric_limits<long double>::min());
  printf("=====================================================================================\n");
  return 0;
}
