package nl.jiankai.year2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Day12 {
    static Map<String, Node> nodes = new HashMap<>();
    static List<String> paths = new ArrayList<>();

    public static void main(String[] args) {
        createGraph();
//        part1(nodes.get("start"), nodes.get("end"), new ArrayList<>());
//        List<String> p1 = new ArrayList<>(paths);
//        paths.clear();
        part2(nodes.get("start"), nodes.get("end"), new ArrayList<>(), false);
        List<String> p2 = new ArrayList<>(paths);

//        p1.removeAll(p2);
        System.out.println(paths.size());

    }

    public static void part1(Node currentNode, Node destination, List<Node> path) {
        if (!path.isEmpty() && path.get(path.size() - 1).equals(destination) && !paths.contains(path.toString())) {
            paths.add(path.toString());
            return;
        }
        path.add(currentNode);

        for (Node adjacentNode : currentNode.adjacentNodes) {
            if (!(adjacentNode.label.toLowerCase().equals(adjacentNode.label) && !path.get(path.size() - 1).equals(destination) && path.contains(adjacentNode))
                    || ((adjacentNode.label.equals("start") || adjacentNode.label.equals("end")) && !path.contains(adjacentNode))) {
                part1(adjacentNode, destination, new ArrayList<>(path));
            }
        }
    }


    public static void part2(Node currentNode, Node destination, List<Node> path, boolean doubleAdded) {
        if (currentNode.label.toLowerCase().equals(currentNode.label) && path.contains(currentNode)) {
            doubleAdded = true;
        }
        path.add(currentNode);

        if (path.get(path.size() - 1).equals(destination) && !paths.contains(path.toString())) {
            paths.add(path.toString());
            return;
        }

        for (Node adjacentNode : currentNode.adjacentNodes) {
            if (adjacentNode.label.equals("start")) continue;
            if (adjacentNode.label.toLowerCase().equals(adjacentNode.label) && path.contains(adjacentNode) && doubleAdded)
                continue;

            part2(adjacentNode, destination, new ArrayList<>(path), doubleAdded);
        }
    }

    private static void createGraph() {
        for (String edge : input) {
            String[] vertices = edge.split("-");
            Node n1 = nodes.computeIfAbsent(vertices[0], Node::new);
            Node n2 = nodes.computeIfAbsent(vertices[1], Node::new);
            n1.adjacentNodes.add(n2);
            n2.adjacentNodes.add(n1);
        }
    }

    private static class Node {
        private String label;
        private List<Node> adjacentNodes = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(label, node.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return label;
        }
    }

    static List<String> input = Arrays.asList(("rf-RL\n" +
            "rf-wz\n" +
            "wz-RL\n" +
            "AV-mh\n" +
            "end-wz\n" +
            "end-dm\n" +
            "wz-gy\n" +
            "wz-dm\n" +
            "cg-AV\n" +
            "rf-AV\n" +
            "rf-gy\n" +
            "end-mh\n" +
            "cg-gy\n" +
            "cg-RL\n" +
            "gy-RL\n" +
            "VI-gy\n" +
            "AV-gy\n" +
            "dm-rf\n" +
            "start-cg\n" +
            "start-RL\n" +
            "rf-mh\n" +
            "AV-start\n" +
            "qk-mh\n" +
            "wz-mh").split("\n"));
}
