#include <iostream>
#include <math.h>

using namespace std;

int main() {
  int test;
  cin >> test;

  while (test--) {
    int n;
    cin >> n;

    long long int count = 1;

    if (n > 26) {
      count = n / 26;

      n = n % 26;

      if (n == 0) {
        count = pow(2, count - 1);
      } else {
        count = pow(2, count);
      }
    }

    if (n > 10 || n == 0) {
      cout << "0 0 " << count << endl;
    } else if (n > 2) {
      cout << "0 " << count << " 0" << endl;
    } else {
      cout << count << " 0 0" << endl;
    }
  }
}
