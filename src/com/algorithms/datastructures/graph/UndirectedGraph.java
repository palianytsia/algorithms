package com.algorithms.datastructures.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class UndirectedGraph extends AbstractGraph {

    /**
     * Creates new <UndirectedGraph> instance based on its description stored in a plain text data file .
     * 
     * <p>
     * The data file should be in the following format:
     * <ul>
     * <li>The first line indicates the number of vertices and edges, respectively.</li>
     * <li>Each subsequent line describes an edge (the first two numbers are its tail and head, respectively) and its
     * length (the third number).</li>
     * <li>E.g. <br>
     * [number_of_nodes] [number_of_edges] <br>
     * [edge 1 node 1] [edge 1 node 2] [edge 1 cost] <br>
     * [edge 2 node 1] [edge 2 node 2] [edge 2 cost]</li>
     * <li>You don't need specify the edge twice, e.g. if there is an edge between A and B it is enough to specify [A B
     * cost] line, no need to add [B A cost], otherwise two edges will be added between those vertices.</li>
     * </ul>
     * </p>
     * 
     * @param filePath
     *            - path to the data files describing the graph to create.
     * 
     * @throws FileNotFoundException
     *             - if there is no graph data file at the specified path.
     */
    public static UndirectedGraph fromFile(String filePath) throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner scanner = new Scanner(dataFile);
        UndirectedGraph g = new UndirectedGraph();

        // number of vertices
        int n = scanner.nextInt();
        // number of edges
        int m = scanner.nextInt();

        g.addVertices(n);
        for (int i = 0; i < m; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int length = scanner.nextInt();
            g.addEdge(source, destination, length);
        }
        scanner.close();
        return g;
    }

    @Override
    public boolean hasEdge(int vertexA, int vertexB) {
        Set<Edge> adjacentEdges = vertices.get(vertexA);
        if (adjacentEdges != null) {
            for (Edge e : adjacentEdges) {
                if (e.isAdjacentTo(vertexB)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPath(int vertexA, int vertexB) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented");
    }

}
