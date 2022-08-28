//leetcode704号问题 用二分查找法查找
//用递归的方法实现
public class Solutin704 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] data, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (data[mid] == target)
            return mid;
        if (data[mid] < target)
            return search(data, mid + 1, r, target);
        // if(data[mid].compareTo(target) >0)
        return search(data, l, mid - 1, target);
    }

    public int search2(int[] data, int target) {
        int l = 0, r = data.length ;
        //在data[l,r）的范围中查找target
        while (l < r) {
            int mid = l + (r- l) / 2;
            if (data[mid] == target)
                return mid;
            if (data[mid] < target)
                l = mid + 1;    //继续在data[mid+1,r]范围内求解
            else
                r = mid ;      //继续在data[l,mid)范围内求解
        }
        return -1;
    }
}
