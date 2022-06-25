package greedy;

import java.util.*;

public class JumpGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(canJump(arr));
    }

    private static boolean canJump(int[] arr) {
        int n = arr.length;

//         for(int i=0;i<n;){
//             int cur=arr[i];

//             if(i+cur>=n-1){
//                 return true;
//             }

//             if(cur==0){
//                 return false;
//             }
//             int max=arr[i+1]+i+1,pos=i+1;

//             for(int j=pos+1;j<=i+cur;j++){
//                 if(arr[j]+j>max && arr[j]!=0){
//                     max=arr[j]+j;
//                     pos=j;
//                 }else if(arr[j]+j==max && arr[j]!=0){
//                     pos=Math.max(pos, j);
//                 }
//             }

//             i=pos;
//         }

//         return false;

        int goal = n - 1;


        for (int i = n - 2; i >= 0; i--) {
            if (i + arr[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
