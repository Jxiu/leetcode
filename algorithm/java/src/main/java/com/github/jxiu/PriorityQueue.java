package com.github.jxiu;

import java.util.ArrayList;

/**
 * 构建一个最大堆的优先队列
 */
public class PriorityQueue {

    private ArrayList<Integer> heap;

    public PriorityQueue (){
        heap = new ArrayList<>();
    }

    /**
     * 返回最大值
     */
    public Integer top(){
        if (heap.isEmpty()){
            return null;
        }
        return  heap.get(0);
    }

    /**
     * 添加一个元素: 把数字放入最后一位，然后上浮
     * @param k
     */
    public void push(Integer k){
        heap.add(k);
        swim(heap.size() -1);
    }

    /**
     * 上浮
     * @param index
     */
    private void swim(int index) {
        // 父节点比子
        while(index >= 1 && heap.get(index/2) < heap.get(index)){
            swap(index, index/2);
            index = index/2;
        }
    }

    private void swap(int i, int j) {
         Integer temp = heap.get(i);
         heap.set(i, heap.get(j));
         heap.set(j, temp);
    }

    /**
     * 删除最大值：把最后的一个数字放入队列头部下沉
     */
    public void pop(){
        if (heap.isEmpty()){
            return;
        }
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        sink(0);
    }

    /**
     * 下沉
     * @param idx
     */
    private void sink(int idx) {
        int N = heap.size() -1;
        while (2*idx <= N){
            // 找到子节点中较大的一个的下标
            // 两个子节点分别是 2i 和 2i +1
            int maxIdx = 2 * idx;
            if ( maxIdx < N && heap.get(maxIdx) < heap.get(maxIdx+1)){
                maxIdx++;
            }
            // 小于最大子节点，则交换,否则则停止
            if (heap.get(idx) >= heap.get(maxIdx)){
                break;
            }
            swap(maxIdx,idx);
            idx = maxIdx;
        }
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
