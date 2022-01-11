package Algorithm;

public class BinarySearch {

    public static int integerExistsInArray(int[] nums, int target, int l, int h){
        if(l <= h){
            int mid = ((h-l)/2) + l;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                return integerExistsInArray(nums, target, l, mid - 1);
            else
                integerExistsInArray(nums, target, mid + 1 , h);
        }
        return -1;
    }

    public static int insertTargetAtIfDoesNotExist(int[] nums, int target, int l, int h){
        if(l <= h){
            int mid = ((h-l)/2) + l;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                return insertTargetAtIfDoesNotExist(nums, target, l, mid - 1);
            else
                insertTargetAtIfDoesNotExist(nums, target, mid + 1 , h);
        }
        return l;
    }

    public static int integerExistsInArrayIterative(int[] nums, int target){
        int mid, l = 0, h = nums.length - 1;
        while(l<=h){
            mid = l + ((h-1)/2);
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                h = mid - 1;
            else
                l = mid + 1 ;

        }
        return -1;
    }
}
