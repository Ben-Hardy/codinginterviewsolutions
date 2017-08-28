#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
1.3 Write a method to replace all spaces in a string with '%20'. You may assume
that the string has sufficient space at the end to hold the additional
characters, and that you are given the "true" length of the string. (Note: if
implementing in Java, please use a  character array so that you can perform this
operation in place)
*/

/* Not Java but still gonna do this in place. The complexity of this algorithm 
is O(M*N) where M is the number of characters, and N is the number of spaces
*/

char *urlify(char str[], int len) {
  int endIdx;
  endIdx = strlen(str) - 1;
  int cur = 0; // cursor for parsing string
  while (cur < endIdx) {
    if (str[cur] == ' ') {
      for (int i = len; i > cur; i--) {
        str[i + 2] = str[i];
      }
      len = len + 2;
      str[cur] = '%';
      str[cur + 1] = '2';
      str[cur + 2] = '0';
      cur = cur + 3;
    }
    cur++;
  }

  return str;
}

int main(int argc, char **argv) {
  char hello[] = "hello there  ";
  printf("%s\n", urlify(hello, 10));
  char bookExample[] = "Mr John Smith    ";
  printf("%s\n", urlify(bookExample, 13));
  return 0;
}
