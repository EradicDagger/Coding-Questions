#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int test;
  cin >> test;
  while (test--) {
    int n;
    cin >> n;
    int p[n] = {0};
    for (int i = 0; i < n; i++) {
      cin >> p[i];
    }

    for (int i = 0; i < n - 1; i++) {
      if (i % 2 == 0) {
        if (p[i] > p[i + 1]) {
          swap(p[i], p[i + 1]);
        }
      } else {
        if (p[i] < p[i + 1]) {
          swap(p[i], p[i + 1]);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      cout << p[i] << " ";
    }
    cout << endl;
  }
}
