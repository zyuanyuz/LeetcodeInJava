package basic.structure;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    private UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
    }

    public static UnionFind init(int size) {
        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            unionFind.parent[i] = i;
            unionFind.rank[i] = 0;
        }
        return unionFind;
    }

    public void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return;
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y])
                rank[x]++;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return (parent[x] = find(parent[x]));
        }
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }
}