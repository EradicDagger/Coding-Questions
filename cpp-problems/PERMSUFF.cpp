#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int test;
  cin >> test;
  while (test--) {
    int n, k;
    cin >> n >> k;

    int p[n];

    for (int i = 0; i < n; i++) {
      cin >> p[i];
    }

    int aux[n] = {0};
    for (int i = 0; i < k; i++) {
      int start, end;
      cin >> start >> end;
      aux[start - 1]++;
      aux[end - 1]--;
    }

    int flag = 0;
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum += aux[i];
      if (sum == 0 && p[i] != i + 1) {
        flag = 1;
        break;
      } else if (sum != 0) {
        int s = i;
        while (sum != 0) {
          i++;
          sum += aux[i];
        }
        int e = i;
        sort(p + s, p + e + 1);

        for (int j = s; j <= e; j++) {
          if (p[j] != j + 1) {
            flag = 1;
            break;
          }
        }
      }
    }

    if (flag == 0) {
      cout << "Possible" << endl;
    } else {
      cout << "Impossible" << endl;
    }
  }

  return 0;
}
