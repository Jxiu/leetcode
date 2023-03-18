package com.github.jxiu;

import java.util.*;
import java.util.stream.Collectors;
//TODO 复习

/**
 * 332. 重新安排行程
 */
public class ReconstructItinerary {

    /**
     * DFS 深度优先
     * @param tickets
     * @return
     */
    public List<String> findItineraryDFS(List<List<String>> tickets) {
        // 假设没有重复票，转换map
        Map<String,List<String>> graph = tickets.stream().collect(Collectors.groupingBy((List<String> ticket)->ticket.get(0),
                Collectors.mapping((List<String> ticket)-> ticket.get(1),Collectors.toCollection(LinkedList::new))));
        String start = "JFK";
        List<String> ans = new ArrayList();
        findNext(graph,start, ans);
        return ans;
    }

    /**
     * 但是上一个例子我们提到了，优先访问字典顺序小的顶点，那么我们第一次肯定是先到 KUL，这就走不通了，那怎么解决呢？
     * 当我们采用 DFS 方式遍历图时，需要将访问到的节点逆序插入到结果集。因此第一个访问到的节点将出现在结果集最后面，
     * 而我们是以顺序的方式来查看结果。如果第一个访问的节点是 “孤岛节点”，他会出现在结果集的最后。
     * 当我们顺序读取结果集时，这种 “孤岛节点” 是最后遇到的，是图遍历的终点，这样就没有问题了。
     *
     * 作者：pwrliang
     * 链接：https://leetcode.cn/problems/reconstruct-itinerary/solution/javadfsjie-fa-by-pwrliang/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param graph
     * @param start
     * @param ans
     */
    private void findNext(Map<String, List<String>> graph,
                                  String start,
                                  List<String> ans) {
        // set空
        List<String> nbr = graph.get(start);
//        if (nbr==null || nbr.isEmpty()){
//            return ;
//        }
//        for (String end: nbr) {
//            ans.add(end);
//            findNext(graph, end,ans);
//            if (ans.size()==times){
//                break;
//            }else {
//                ans.lastIndexOf()
//            }
//        }
        while (nbr != null && nbr.size() > 0){
            String dest = nbr.remove(0); // 取出目的地
            findNext(graph,dest,ans);
        }
        ans.add(0,start); // 逆序插入
    }

    /**
     * 回溯
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null) return Collections.emptyList();
        LinkedList<String> ans = new LinkedList<>();
        if (tickets.isEmpty()){
            return ans;
        }
        // 可能存在多个重复值
        Map<String,LinkedList<String>> map = tickets.stream().collect(Collectors.groupingBy((List<String> ticket)->ticket.get(0),
        Collectors.mapping((List<String> ticket)-> ticket.get(1),Collectors.toCollection(LinkedList::new))));
        // 排序values
        map.forEach((k,v)->{
            Collections.sort(v);
        });
        System.out.println(map);
        Stack<String> s = new Stack();
        s.push("JFK");
        while (!s.empty()){
            String next = s.peek();
            LinkedList<String> ends = map.get(next);
            if (ends == null || ends.isEmpty()){
                // 路径走完了，保存走过的路径
                ans.add(next);
                s.pop();
            }else {
                s.push(ends.removeFirst());
            }
            System.out.println(map);
            System.out.println("栈: " + s);
        }
        Collections.reverse(ans);
        return ans;
    }
}
