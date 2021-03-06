package pers.yibo.algorithms.graph;

import java.util.Arrays;

/**
 * 无环加权有向图中的单点最长路径, 边的权重可正可负
 * <p>
 * 按照拓扑顺序放松顶点，就能在和 E+V 成正比的时间内解决无环加权有向图的单点最 短路径问题。
 * <p>
 * 解决无环加权有向图中的最长路径问题所需的时间与E+V成正比。
 *
 * @author yibo
 * @date 2021-12-06 15:06
 **/
public class AcyclicLongestPaths {

    /**
     * 最短路径中的边，索引为边的重点
     */
    DirectedEdge[] edgeTo;

    /**
     * 到起点的距离
     */
    double[] distTo;

    public AcyclicLongestPaths(WeightedDirectedGraph graph) {
        this.edgeTo = new DirectedEdge[graph.getVertices()];
        this.distTo = new double[graph.getVertices()];
        // 初始化权重为最小值
        Arrays.fill(distTo, Double.MIN_VALUE);

        Topological topological = new Topological(graph);
        for (int v : topological.order()) {
            relax(graph, v);
        }
    }


    /**
     * 顶点的松弛
     * <p>
     * 对于start到任意顶点v，distT[v]表示了s->v的最短路径，其中不可达的点路径为无穷大
     * <p>
     * 顶点的松弛使得，从v->w的任意一条边e，都有：{@code distTo[w] <= distTo[v] + wight ( v -> w )}
     *
     * @param graph {@link WeightedDirectedGraph}
     * @param v     下一个添加到最短路径中的点
     */
    private void relax(WeightedDirectedGraph graph, int v) {
        // 查找该点的邻接节点
        for (DirectedEdge edge : graph.getAdjacencyVertices(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.getWeight()) {
                // w到起点的距离 比 v到起点的距离 + v->w边更远，说明起点到w可以经过v
                distTo[w] = distTo[v] + edge.getWeight();
                edgeTo[w] = edge;
            }
        }
    }
}
