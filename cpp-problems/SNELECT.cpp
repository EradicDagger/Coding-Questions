#include <iostream>
#include <string>

using namespace std;

int main() {
  int test;
  cin >> test;
  while (test--) {
    string str;
    cin >> str;
    int length = str.length();

    for (int i = 0; i < length; i++) {
      if (i == 0) {
        if (str[i] == 'm') {

          if (str[i + 1] == 's') {
            str[i + 1] = 'e';
          }
        }
      } else {
        if (str[i] == 'm') {
          if (str[i - 1] == 's') {
            str[i - 1] = 'e';
          } else if (str[i + 1] == 's') {
            str[i + 1] = 'e';
          }
        }
      }
    }
    int count1 = 0, count2 = 0;
    for (int j = 0; j < length; j++) {
      if (str[j] == 'm') {
        count1++;
      }
      if (str[j] == 's') {
        count2++;
      }
    }
    if (count1 > count2) {
      cout << "mongooses" << endl;
    }
    if (count1 < count2) {
      cout << "snakes" << endl;
    }
    if (count1 == count2) {
      cout << "tie" << endl;
    }
  }
  return 0;
}
