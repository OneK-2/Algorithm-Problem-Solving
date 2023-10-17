import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //국가 수
        int k = Integer.parseInt(st.nextToken()); //등수 알고 싶은 국가
        List<Country> countries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            countries.add(new Country(idx, g, s, b, 0));
        }
        Collections.sort(countries);

        int ans = 0;
        countries.get(0).rate = 1;
        for (int i = 1; i < countries.size(); i++) {
            int tmp_g = countries.get(i - 1).gold;
            int tmp_s = countries.get(i - 1).silver;
            int tmp_b = countries.get(i - 1).bronze;
            Country cur = countries.get(i);
            if (countries.get(i).idx == k) {
                ans = i;
            }
            if (cur.gold == tmp_g && cur.silver == tmp_s && cur.bronze == tmp_b) {
                countries.get(i).rate = countries.get(i - 1).rate;
            } else {
                countries.get(i).rate = i + 1;
            }
        }
        System.out.println(countries.get(ans).rate);
    }
}

class Country implements Comparable<Country> {
    int idx, gold, silver, bronze, rate;

    public Country(int idx, int gold, int silver, int bronze, int rate) {
        this.idx = idx;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rate = rate;
    }

    @Override
    public int compareTo(Country o) {
        if (this.gold == o.gold) {
            if (this.silver == o.silver) {
                return o.bronze - this.bronze;
            } else {
                return o.silver - this.silver;
            }
        }
        return o.gold - this.gold;
    }
}
