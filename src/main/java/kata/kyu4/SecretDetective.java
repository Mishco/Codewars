package kata.kyu4;


import java.util.*;

/**
 * There is a secret string which is unknown to you.
 * Given a collection of random triplets from the string, recover the original string.
 * <p>
 * A triplet here is defined as a sequence of three letters such that each letter occurs
 * somewhere before the next in the given string. "whi" is a triplet for the string "whatisup".
 * <p>
 * As a simplification, you may assume that no letter occurs more than once in the secret string.
 * <p>
 * You can assume nothing about the triplets given to you other than that they are valid triplets
 * and that they contain sufficient information to deduce the original string.
 * In particular, this means that the secret string will never contain letters
 * that do not occur in one of the triplets given to you.
 */
public class SecretDetective {
    public String recoverSecret(char[][] triplets) {
        StringBuilder res = new StringBuilder();
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char[] triplet : triplets) {
            char a = triplet[0];
            char b = triplet[1];
            char c = triplet[2];

            graph.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(b, new HashSet<>());
            graph.putIfAbsent(c, new HashSet<>());

            if (graph.get(a).add(b)) {
                inDegree.put(b, inDegree.getOrDefault(b, 0) + 1);
            }
            if (graph.get(b).add(c)) {
                inDegree.put(c, inDegree.getOrDefault(c, 0) + 1);
            }

            inDegree.putIfAbsent(a, 0);
            inDegree.putIfAbsent(b, 0);
            inDegree.putIfAbsent(c, 0);
        }


        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            res.append(curr);

            for (char c : graph.getOrDefault(curr, Collections.emptySet())) {
                inDegree.put(c, inDegree.get(c) - 1);

                if (inDegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
        }
        return res.toString();
    }
}
