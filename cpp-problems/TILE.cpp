#include <iostream>
#define mo 1000000007

using namespace std;

void multiply(long long int f[2][2], long long int m[2][2]) {
  int x = ((f[0][0] * m[0][0]) % mo + (f[0][1] * m[1][0]) % mo) % mo;
  int y = ((f[0][0] * m[0][1]) % mo + (f[0][1] * m[1][1]) % mo) % mo;
  int z = ((f[1][0] * m[0][0]) % mo + (f[1][1] * m[1][0]) % mo) % mo;
  int w = ((f[1][0] * m[0][1]) % mo + (f[1][1] * m[1][1]) % mo) % mo;

  f[0][0] = x;
  f[0][1] = y;
  f[1][0] = z;
  f[1][1] = w;
}

void power(long long int f[2][2], long long int n) {
  if (n == 0 || n == 1)
    return;
  long long int m[2][2] = {{1, 1}, {1, 0}};

  power(f, n / 2);
  multiply(f, f);
  if (n % 2 != 0)
    multiply(f, m);
}

long long int no_of_tiles(long long int n) {
  long long int f[2][2] = {{1, 1}, {1, 0}};
  if (n == 0)
    return 0;
  power(f, n - 1);
  return f[0][0];
}

int main() {
  int test;
  cin >> test;

  while (test--) {
    long long int x;
    cin >> x;

    cout << no_of_tiles(x + 1) << endl;
  }
  return 0;
}
