//二分查找法
public class BinarySearch {
    private BinarySearch(){}
    public static<E extends Comparable<E>> int searchR(E[] data,E target){
       return searchR(data,0,data.length-1,target);

    }
    //递归实现
    private static<E extends Comparable<E>> int searchR(E[]data, int l,int r, E target){
        if(l>r) return -1;
        int mid =l+(r-l)/2;
        if(data[mid].compareTo(target) == 0)
            return mid;
        if(data[mid].compareTo(target) <0)
            return searchR(data, mid+1,r,target);
       // if(data[mid].compareTo(target) >0)  为什么递归不需要条件？？
            return searchR(data, l,mid-1,target);
           }
           //非递归实现二分查找
    public static<E extends Comparable<E>> int search(E[] data,E target){
        int l=0, r=data.length-1;
        //在data[l,r]的范围中查找target
        while ( l<=r){
            int mid = l+(r-l)/2;
            if(data[mid].compareTo(target) == 0)
                return mid;
            if(data[mid].compareTo(target) <0)
                l= mid+1;
            else
                r= mid-1;
        }
        return -1;
    }
    //寻找>target的最小值索引
    public static <E extends Comparable<E>> int upper(E[]data, E target){
        int l=0,r=data.length;
        //在data[l,r]中寻找解
        while(l<r){
         int mid = l+(r-l)/2;
         if(data[mid].compareTo(target)<=0)
             //情况一：如果Mid是其中一个解，l=mid，否则l=mid+1
             l=mid+1;
         //情况二：如果Mid是其中一个解，l=mid，否则l=mid-1
         else r=mid;
        }
        return l;
    }
    //如果数组中存在元素，返回最大索引；如果数组中不存在元素，返回upper
    public static<E extends Comparable<E>> int upper_ceil(E[] data, E target){
        int u = upper(data,target);
        if(u-1>0 && data[u-1].compareTo(target) == 0)
            return u-1;
        return u;
    }
    //寻找>=target的最小索引值
    public static <E extends Comparable<E>> int upper2(E[]data, E target){
        int l=0,r=data.length;
        //在data[l,r]中寻找解
        while(l<r){
            int mid = l+(r-l)/2;
            if(data[mid].compareTo(target)<0)
                l=mid+1;
                //可能mid值就是所求解的值
            else r =mid;
        }
        if(l<data.length&&data[l].compareTo(target)==0)
            return l;
        return -1;
    }
    //如果数组中存在元素，返回最小索引；如果数组中不存在元素，返回upper
    public static<E extends Comparable<E>> int lower_ceil(E[] data, E target){
        int u = upper2(data,target);
        if(u-1>0 && data[u-1].compareTo(target) == 0)
            return u-1;
        return u;
    }
    //如果数组中存在元素，返回最小索引；如果数组中不存在元素，返回lower
    public static<E extends Comparable<E>> int lower_floor(E[] data, E target){
        int l = lower(data,target);   //小于target的最大值
        if(l+1<data.length && data[l+1].compareTo(target) == 0)
            return l+1;
        return l;
    }
    //如果数组中存在元素，返回最大索引；如果数组中不存在元素，返回upper
    public static<E extends Comparable<E>> int upper_floor(E[] data, E target){
        int u = lower2(data,target);
        if(u+1<data.length && data[u+1].compareTo(target) == 0)
            return u+1;
        return u;
    }
    //查找小于target的最大值，对应的最大索引
    public static <E extends Comparable<E>> int lower(E[]data, E target){
          //可能没有小于target的值，则返回-1
        int l=-1,r=data.length-1;
        //在data[l,r]中寻找解
        while(l<r){
           // int mid = l+(r-l)/2;
            //当r和l相邻时，向下取整，出现死循环
            int mid = l+(r-l+1)/2;
            if(data[mid].compareTo(target)<0)
                l=mid;
                //可能mid值就是所求解的值
            else r=mid-1;
        }
        return l;
    }
    //查找<=target的最大值，对应的最大索引
    public static <E extends Comparable<E>> int lower2(E[]data, E target){
        //可能没有小于target的值，则返回-1
        int l=-1,r=data.length-1;
        //在data[l,r]中寻找解
        while(l<r){
            // int mid = l+(r-l)/2;
            //当r和l相邻时，向下取整，出现死循环
            int mid = l+(r-l+1)/2;
            if(data[mid].compareTo(target)<=0)
                l=mid;
                //可能mid值就是所求解的值
            else r=mid-1;
        }
        return l;
    }
    public static void main(String[] args){
        Integer[]arr ={1,1,3,3,5,5};
        for(int i=0; i<=6; i++)
           System.out.print( BinarySearch.upper_floor(arr,i) + " ");
        System.out.println();
    }
}
