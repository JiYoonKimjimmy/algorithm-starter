package me.jimmyberg.naver2022;

import java.util.*;

public class Question02 {

    public static int solution(Tree T) {
        Queue<Tree> queue = new LinkedList<>();
        Set<Integer> set = new LinkedHashSet<>();

        queue.add(T);
        set.add(T.x);

        while (!queue.isEmpty()) {
            Tree root = queue.poll();
            Tree left = root.l;
            Tree right = root.r;
            if (left != null) {
                queue.add(left);
                if (root.x < left.x) {
                    set.add(left.x);
                }
            }
            if (right != null) {
                queue.add(right);
                if (root.x < right.x) {
                    set.add(right.x);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new Tree(
                5,
                new Tree(3, new Tree(20, null, null), new Tree(21, null, null)),
                new Tree(10, new Tree(1, null, null), null)
        )));
        System.out.println(solution(new Tree(
                8,
                new Tree(2, new Tree(8, null, null), new Tree(7, null, null)),
                new Tree(6, null, null)
        )));
    }

    static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }
    }
}


