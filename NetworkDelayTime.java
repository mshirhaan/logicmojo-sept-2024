/**
 * @param {number[][]} times
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
class Node {
    constructor(name) {
        this.name = name;
    }
}

 class PriorityQueue1 {
  constructor(){
    this.values = [];
  }
  enqueue(val, priority) {
    this.values.push({val, priority});
    this.sort();
  };
  dequeue() {
    return this.values.shift();
  };
  sort() {
    this.values.sort((a, b) => a.priority - b.priority);
  };
}

var networkDelayTime = function(times, n, k) {

    let edges = {};
    let nodes = new Set();

    for(let [source, target, weight] of times) {
        nodes.add(new Node(source));
        nodes.add(new Node(target));
        if(!edges[source]) edges[source] = [];
        edges[source].push({name: target, weight: weight});
    }
   
    let distances = Dijkstra(k, nodes, edges);
    let max = -1;
    console.log(distances)
    for(let distance of Object.values(distances)) {
        if(distance == Infinity) return -1;
        if(distance > max) max = distance;
    }
    return max;
};


function Dijkstra(source, nodes, edges) {
        let distances = {};

        for(let node of nodes) {
            distances[node.name] = Infinity;
        }

        distances[source] = 0;

        let queue = new PriorityQueue1();
        queue.enqueue(source, 0)

        while(queue.values.length) {
            let next = queue.dequeue();
            if(!edges[next.val]) continue;
            for(let edge of edges[next.val]) {
                if(edge.name == source) {
                    distances[9999] = true;
                }
                if(edge.name == source) continue;

                if((next.priority + edge.weight) < distances[edge.name]) {
                    distances[edge.name] = next.priority + edge.weight;
                    queue.enqueue(edge.name, next.priority + edge.weight)
                }
            }
            
        }
        return distances;
    }
