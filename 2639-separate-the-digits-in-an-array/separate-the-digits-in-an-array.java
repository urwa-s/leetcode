class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> newnum= new ArrayList<>();
        for(int num:nums){
            for(char c:String.valueOf(num).toCharArray()){
                newnum.add(c-'0');
            }
        }
        int[] result= new int[newnum.size()];
        for(int i=0; i<newnum.size(); i++){
            result[i]=newnum.get(i);
        }
        return result;
    }
}