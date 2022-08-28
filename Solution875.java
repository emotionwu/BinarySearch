import java.util.Arrays;

public class Solution875 {
    //二分查找法
    public int minEatingSpeed(int[] piles, int H){
        int l=1,r= Arrays.stream(piles).max().getAsInt();
        while(l<r){
            int mid= l+(r-l)/2;   //下取整
            if(eatingTime(piles,mid)<=H)
                //吃的时间比要求少，降低速度
                r=mid;
            else l = mid+1;
        }
        return l;
    }
    private int eatingTime(int[]piles,int K){
        int res=0;
        for(int pile:piles)
           res+= pile / K + (pile% K>0?1:0);
        return res;
    }
}
