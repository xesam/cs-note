#include "stdio.h"
int show_bytes(char* ptr, int len){
  for (size_t i = 0; i < len; i++) {
    printf("%x ", (int)(*(ptr + i)));
  }
  printf("\n");
}

int main(int argc, char const *argv[]) {
  int i = 0x1234;
  show_bytes((char*) &i, 4);
  return 0;
}
