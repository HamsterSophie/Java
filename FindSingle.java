package amazonmj;
//Amazon 1.25 phone interview http://www.1point3acres.com/bbs/thread-167192-1-1.html (出处: 一亩三分地论坛)
//改一下在提交
public class FindSingle {
	public static Integer findSingle(int[] arr) {
		if (arr == null) return null;
		if (arr.length == 1) return arr[0];

            int N = arr.length, lo = 0, hi = N-1;
            while(lo < hi-1) { 
                    int mid = lo + ((hi-lo)>>1);
                    if(mid%2==0) { // mid is an even index
                            if(arr[mid]==arr[mid-1]) hi = mid-2; // unique number must be before mid-1
                            else lo = mid; // unique number must not be before mid
                    }
                    else {
                            if(arr[mid]==arr[mid-1]) lo = mid+1; // unique number must be after mid. 鍥磋鎴戜滑@1point 3 acres
                            else hi = mid; // unique number must not be after mid. 1point 3acres 璁哄潧
                    }
            }
            return arr[lo]; // since lo is guaranteed to be even, it must be the unique index when while loop ends
	}
	
	public static Integer findSingleB (int[] arr) {
		int b = arr[0];
		for (int i = 1; i < arr.length; i++) {
			b ^= arr[i]; 
			//System.out.println(b);
		}
		return b;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,4,1,1,2,2,0,5,5};
		System.out.println(findSingleB(arr));
	}

}
