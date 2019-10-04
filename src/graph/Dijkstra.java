package graph;

import java.util.*;

public class Dijkstra {

    static void dijkstraSearch(Node start, Node target) {
        Set<Node> uncheckedNodes = new HashSet<>();
        Set<Node> checkedNodes = new HashSet<>();

        start.distance = 0;
        uncheckedNodes.add(start);

        while (uncheckedNodes.size() > 0) {
            Node lowestNode = getLowestDistanceNode(uncheckedNodes);
            uncheckedNodes.remove(lowestNode);
            checkedNodes.add(lowestNode);

            lowestNode.adjacentNodes.keySet();

            for (Map.Entry<Node, Integer> adjacencyPair : lowestNode.adjacentNodes.entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer adjacentEdgeWeight = adjacencyPair.getValue();

                if (!checkedNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, adjacentEdgeWeight, lowestNode);
                    uncheckedNodes.add(adjacentNode);
                }
            }
        }
        if (target.distance == Integer.MAX_VALUE) {
            System.out.println("no way");
        } else {
            printPath(start, target);
        }
    }

    static Node getLowestDistanceNode(Set<Node> uncheckedNodes) {
        int minDistance = Integer.MAX_VALUE;
        Node lowestNode = null;
        for (Node node : uncheckedNodes) {
            if (node.distance < minDistance) lowestNode = node;
        }
        return lowestNode;
    }

    static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.distance;
        if (sourceDistance + edgeWeigh < evaluationNode.distance) {
            evaluationNode.distance = sourceDistance + edgeWeigh;
            evaluationNode.parent = sourceNode;
        }
    }

    private static void printPath(Node start, Node target) {
        ArrayList<String> toPrint = new ArrayList<>();
        toPrint.add(target.name);
        Node last = target;
        while (!last.name.equals(start.name)) {
            last = last.parent;
            toPrint.add(last.name);
        }
        Collections.reverse(toPrint);
        System.out.println(Arrays.toString(toPrint.toArray()));
    }

    static class Node {
        Node(String name) {
            this.name = name;
        }

        String name;
        Node parent;
        int distance = Integer.MAX_VALUE;
        Map<Node, Integer> adjacentNodes = new HashMap<>();
    }

    public static void main(String[] args) {
        Node start = new Node("start");
        Node nodeA = new Node("nodeA");
        Node nodeB = new Node("nodeB");
        Node end = new Node("end");

        start.adjacentNodes.put(nodeA, 3);
        start.adjacentNodes.put(nodeB, 6);
        nodeA.adjacentNodes.put(nodeB, 1);
        nodeB.adjacentNodes.put(end, 2);
        end.adjacentNodes.put(end, 2);

        dijkstraSearch(start, end);
        System.out.println(end.distance);
    }
}