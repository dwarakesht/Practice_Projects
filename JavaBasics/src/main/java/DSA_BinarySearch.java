public class DSA_BinarySearch {
    public static void main(String[] args) {
        DSA_BinarySearch binarySearch = new DSA_BinarySearch();
//        System.out.println(binarySearch.findCeilingElement(new int[]{98, 34, 23, 9, 8, 3}, 15));
//        System.out.println(binarySearch.findFloorElement(new int[]{13, 45, 33, 44, 55, 66}, 44));
//        System.out.println(binarySearch.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
//        System.out.println(Arrays.toString(binarySearch.searchRange(new int[]{5, 7, 7, 7, 7, 8, 8, 10}, 7)));
//        System.out.println(binarySearch.findElementWithInfiniteLength(new int[]{3, 5, 7, 9, 10, 90,
//                100, 130, 140, 160, 170}, 10));
//        System.out.println(binarySearch.peakIndexInMountainArray(new int[]{0, 3, 5, 12, 2}));
//        System.out.println(binarySearch.searchInSortedRotatedArray(new int[] {3,4,5,6,1,2}, 2));
        System.out.println(binarySearch.rotationCountInRotatedSortedArray(new int[] {3,4,5,6,1,2}));
    }


    //Find Ceiling for the given target element
    private int findCeilingElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return nums[mid];
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }

    //Floor if the  given target number
    private int findFloorElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return nums[mid];
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[end];
    }

    //leetcode-744
    private char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

    //leetcode - 34 - Find first and last index position of the target.
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = getIndex(nums, target, true);
        ans[1] = getIndex(nums, target, false);
        return ans;
    }

    int getIndex(int[] nums, int target, boolean startIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (startIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    // Find the element in the sorted array for infinite length without using 'length' function
    public int findElementWithInfiniteLength(int[] nums, int target) {
        int start = 0;
        int end = 1;
        while (target > nums[end]) {
            int newStart = end + 1;
            end = end + (2 * (end - start + 1));
            start = newStart;
        }
        return binarySearch(nums, target, start, end);
    }

    // Find the peak element's index in array
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    //Search in Rotated Sorted Array
    public int searchInSortedRotatedArray(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        int pivot = findPivot(nums);
        index = binarySearch(nums, target, start, pivot);
        if(index == -1){
            index = binarySearch(nums, target, pivot + 1, end);
        }
        return index;
    }

    public int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            else if(arr[start] <= arr[mid]){
                start = mid + 1;
            }
            else if(arr[start] >= arr[mid]){
                end = mid -1;
            }
        }
        return -1;
    }

    public int rotationCountInRotatedSortedArray(int[] arr) {
        //logic - pivot + 1 times
        int pivot = findPivot(arr);
        return pivot + 1;
    }


    //Search the 
    //Binary Search
    static int binarySearch(int[] arr, int target,
                            int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;

            }
        }
        return -1;
    }

    //Order Agnostic Binary Search
    static int orderAgnosticBinarySearch(int[] mountainArr, int target,
                                         int start, int end) {
        boolean isAsc = mountainArr[start] < mountainArr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == mountainArr[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target < mountainArr[mid]) {
                    end = mid - 1;
                } else if (target > mountainArr[mid]) {
                    start = mid + 1;
                }
            } else {
                if (target > mountainArr[mid]) {
                    end = mid - 1;
                } else if (target < mountainArr[mid]) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
