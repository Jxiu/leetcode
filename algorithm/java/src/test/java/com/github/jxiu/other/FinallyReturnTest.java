package com.github.jxiu.other;

public class FinallyReturnTest {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        int i;
        try{
           i = 2/0;
           return i;
        }catch (Exception e){
            i = 3;
//            return i;
        }finally {
            i=4;
        }
        return i;
    }
}
