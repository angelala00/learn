package cn.jc.todo;

public class ErfenSearch {

    public static void main(String[] args) {
        int[] a = new int[]{5,6,9,11,13,15};
        System.out.println("r:"+new ErfenSearch().sort(a, 15,0,a.length - 1));
    }

    public int sort(int []array,int a,int lo,int hi){
        if(lo<=hi){
            int mid=(lo+hi)/2;
            if(a==array[mid]){
                return mid;
            } else if(a>array[mid]){
                return sort(array,a,mid+1,hi);
            }else{
                return sort(array,a,lo,mid-1);
            }
        }
        return -1;
    }

    public int biSearch1(int []array,int a){
        int n=array.length;
        int low=0;
        int hi=n-1;
        while(low<hi){
            int mid=(low+hi)/2;
            if(array[mid]<a){
                low=mid+1;
            }else{
                hi=mid;
            }
        }
        if(array[low]!=a){
            return -1;
        }else{
            return low;
        }
    }
    public int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }
//    public static void main(String[] args) {
//        int[] a = new int[]{1,2,4,5,6,7,8,9};
//        System.out.println("r:"+new ErfenSearch().efs(a,0,a.length - 1,3));
//        System.out.println("r:"+new ErfenSearch().findK(a,3));
//    }

//    public int efs(int[]a, int start, int end, int k){
//        System.out.println("start:" + start + " end:" + end);
//        int l = end - start + 1;
//        int hf = l/2 + start;
//
//        if (l == 2) {
//
//        }
//
//        if (k > a[hf]){
//            return efs(a,hf,end,k);
//        } else if (k < a[hf]) {
//            return efs(a,start,hf,k);
//        } else {//k == a[hf]
//            return hf;
//        }
//    }
//
//    int findK(int[] a,int k){
//        int l = a.length;
//        int index = efs(a,0, l - 1, k);
//        //找左边，类似于二分查找
//        int indexStart = efsStart(a,0,index,k);
//        //找右边，类似于二分查找
//        int indexEnd = efsEnd(a,index,l - 1,k);
//        return indexEnd - indexStart;
//    }
//
//    private int efsEnd(int[] a, int start, int end, int k) {
//        int l = end - start;
//        int hf = l/2 + start;
//        if (k == a[hf]){
//            //向右继续
//            return efsEnd(a,hf,end,k);
//        } else {//k < a[hf]
//            //向左继续
//            return efsEnd(a,start,hf,k);
//        }
//    }
//
//    private int efsStart(int[] a, int start, int end, int k) {
//        int l = end - start;
//        int hf = l/2 + start;
//        if (k == a[hf]){
//            //向左继续
//            return efsStart(a,start,hf,k);
//        } else {//k > a[hf]
//            //向右继续
//            return efsStart(a,hf,end,k);
//        }
//    }

}
