#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int mul(int a, int b){
  int m = 0;
  while(b>0){
    if(b%2 == 1){
      m = m + a;
      b = b - 1;
    }
    a = a * 2;
    b = b / 2;
  }
  return m;
}



int main (int argc, char *argv[]){

  if(argc >= 4){
    if(mul(atoi(argv[1]), atoi(argv[2])) == atoi(argv[3]))
      printf("PASSED\n");
    else
      printf("FAILED\n");
  }
  return 0;
}
