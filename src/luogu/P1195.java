package luogu;

import java.util.Scanner;

import basic.structure.UnionFind;

public class P1195 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int p = scan.nextInt();
        UnionFind unionFind = UnionFind.init(n);
        for (int i = 0; i < m; i++) {
            unionFind.unite(scan.nextInt() - 1, scan.nextInt() - 1);
        }

        for (int i = 0; i < p; i++) {
            System.out.println(unionFind.same(scan.nextInt() - 1, scan.nextInt() - 1)?"yes":"no");
        }
        scan.close();
    }
}
