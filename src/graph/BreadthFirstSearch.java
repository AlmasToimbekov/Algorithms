package graph;

import java.util.*;

public class BreadthFirstSearch {

    static String[] breadthFirstSearch(HashMap<String, String[]> graph, String value, String target) {

        Queue<String> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        Map<String, String> parentsTable = new HashMap<>();

        queue.add(value);

        while (queue.size() > 0) {
            String first = queue.remove();
            if (first.equals(target)) {
                return buildWay(parentsTable, value, target);
            }
            if (!checked.contains(first)) {
                String[] list = graph.get(first);
                for (String item : list) {
                    parentsTable.put(item, first);
                    queue.add(item);
                }
            }
            checked.add(first);
        }
        return new String[]{"no way"};
    }

    static String[] buildWay(Map<String, String> parentsTable, String value, String target) {
        List<String> result = new LinkedList<>();
        result.add(target);
        String temp = target;
        while (!temp.equals(value)) {
            result.add(parentsTable.get(temp));
            temp = result.get(result.size() - 1);
        }
        Collections.reverse(result);
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();
        graph.put("you", new String[]{"alice", "bob", "claire"});
        graph.put("bob", new String[]{"anuj", "peggy"});
        graph.put("alice", new String[]{"peggy"});
        graph.put("claire", new String[]{"thom", "johny"});
        graph.put("anuj", new String[0]);
        graph.put("peggy", new String[]{"bob"});
        graph.put("thom", new String[0]);
        graph.put("johny", new String[0]);

        String[] list = breadthFirstSearch(graph, "you", "thom");
        System.out.println(Arrays.toString(list));
    }
}
