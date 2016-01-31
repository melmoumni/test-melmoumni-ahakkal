#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ppmc(int x, int y){
  int p,mincm;
  if(x == y)
    return x;
  if(x==0 || y==0)
    return 0;
  p = x*y;
  while((p>=x)&&(p>=y)){
    if((p%x==0)&&(p%y==0)){
      mincm = p;
    }
    p = p-1;
  }
  return mincm;
}



int main (int argc, char *argv[]){

  if(argc >= 4){
    if(ppmc(atoi(argv[1]), atoi(argv[2])) == atoi(argv[3]))
      printf("PASSED\n");
    else
      printf("FAILED\n");
  }
  return 0;
}
