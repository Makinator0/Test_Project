package org.example;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < testCases; t++) {
            int numCities = scanner.nextInt(); // Number of cities
            Map<String, Integer> cityIndex = new HashMap<>(); // Map to store city names and their indices
            List<List<int[]>> graph = new ArrayList<>(); // Adjacency list to represent the graph

            for (int i = 0; i < numCities; i++) {
                String cityName = scanner.next(); // Name of the city
                cityIndex.put(cityName, i); // Map the city name to its index
                int neighbors = scanner.nextInt(); // Number of neighbors
                graph.add(new ArrayList<>()); // Add a new list for this city

                for (int j = 0; j < neighbors; j++) {
                    int neighborIndex = scanner.nextInt() - 1; // Neighbor index (1-based to 0-based)
                    int cost = scanner.nextInt(); // Cost to this neighbor
                    graph.get(i).add(new int[]{neighborIndex, cost}); // Add the edge to the graph
                }
            }

            int queries = scanner.nextInt(); // Number of queries
            for (int q = 0; q < queries; q++) {
                String source = scanner.next(); // Source city
                String destination = scanner.next(); // Destination city
                System.out.println(dijkstra(graph, cityIndex.get(source), cityIndex.get(destination)));
            }
        }
    }

    // Implementation of Dijkstra's algorithm to find the shortest path
    public static int dijkstra(List<List<int[]>> graph, int start, int end) {
        int[] distances = new int[graph.size()]; // Array to store distances from the start node
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialize all distances to infinity
        distances[start] = 0; // Distance to the start node is 0

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // Min-heap for Dijkstra
        pq.offer(new int[]{start, 0}); // Add the start node to the priority queue

        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // Get the node with the smallest distance
            int currentNode = current[0];
            int currentCost = current[1];

            if (currentNode == end) return currentCost; // If we've reached the destination, return the cost

            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int newCost = currentCost + neighbor[1];

                if (newCost < distances[nextNode]) { // If a shorter path is found
                    distances[nextNode] = newCost; // Update the distance
                    pq.offer(new int[]{nextNode, newCost}); // Add the neighbor to the queue
                }
            }
        }
        return -1; // If the destination is unreachable
    }
}

