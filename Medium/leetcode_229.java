// 229. Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Example 1:
// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow up: Could you solve the problem in linear time and in O(1) space?

// SOLUTION : 
//         // if the question is find the element that are appear (n/k) then we can find maximum (k-1) element 

//         // like if (n/2) then we just find one element for example n=7 
//         // (n/2) = 3 so there are one element which will occur 4 times cause we want to find more than (n/2)  


class Solution {
    public List<Integer> majorityElement(int[] nums) {



        int main1=Integer.MAX_VALUE,main2=Integer.MAX_VALUE;
        int vote1=0,vote2=0;


        for(int i=0;i<nums.length;i++){
            if(main1==nums[i]){
                vote1++;
            }else if(main2 == nums[i]){
                vote2++;
            }else if(vote1==0){
                main1=nums[i];
                vote1=1;
            }else if(vote2==0){
                main2=nums[i];
                vote2=1;
            }else{
                vote1--;
                vote2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int maincount1=0,maincount2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==main1){
                maincount1++;
            }
            if(nums[i]==main2){
                maincount2++;
            }
        } 
        if(maincount1>(nums.length/3)){
            ans.add(main1);
        }  
        if(maincount2>(nums.length/3)){
            ans.add(main2);
        }  

        return ans;
    }
}
