import com.sun.javafx.image.BytePixelSetter;

import java.util.Arrays;

public class Solution1011 {
   public int shipWithinDays(int [] weights,int D){
       //最低取值为最重货物的weight
       int l= Arrays.stream(weights).max().getAsInt();
       //最大取值为所有weight的总和
       int r = Arrays.stream(weights).sum();
       while(l<r){
           int mid =l+(r-l)/2;
           if(days(weights,mid)<=D)
               //mid可能为其中一个解
               r= mid;
           else
               l=mid+1;
       }
       return l;
   }
    private int days(int[] weights, int k){
        //cur为当前传送带的载重，res为最终的返回结果
        int cur=0,res=0;
        //遍历weights中的每一个元素
        for(int weight:weights)
            //如果当前重量加上当前的货物没有超过k
            //则吧当前货物重量加在cur上
            if(cur+weight<=k)
                cur +=weight;
            //否则，需要新的一天运输，res++,同时cur更新为当前的重量
        else{
            res++;
            cur =weight;
            }
        //最后还要做一次res++，因为在这里cur不为零，还需要记录最后一天需要运送的货物重量
        //最后一天，要加到res中,所以res++
        res++;
        return res;
    }
}
