#include <bits/stdc++.h>

using namespace std;

int fac[10];
vector<int> ans;

void init() {
    fac[0] = 1;
    for (int i = 1; i < 10; i++) {
        fac[i] = fac[i-1] * i;
    }
}
void solve(int a) {
    int aux = fac[a];
    vector<int> res;

    for (int i = 2; i < 10; i++) {
        if (aux % fac[i] == 0) {
            aux /= fac[i];
            res.push_back(i);
            if (aux == 1)
                break;

            i--;
            continue;
        }

        if (aux > fac[i])
            continue;

        aux *= fac[res[res.size()-1]];
        i = res[res.size()-1];
        res.pop_back();
        continue;

    }

    for (int i = 0; i < res.size(); i++) {
        ans.push_back(res[i]);
    }

}

int main() {
    int n;
    string a;
    cin >> n >> a;
    vector<int> aux;

    init();

    for (int i = 0; i < n; i++) {
        if (a[i]-'0' == 2 || a[i]-'0' == 3)
            ans.push_back(a[i]-'0');
        else if (a[i]-'0' != 1 && a[i]-'0' != 0)
            aux.push_back(a[i]-'0');
    }

    for(int i = 0; i < aux.size(); i++) {
        solve(aux[i]);
    }

    sort(ans.rbegin(), ans.rend());

    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i];
    }

    cout << endl;
    return 0;
}
