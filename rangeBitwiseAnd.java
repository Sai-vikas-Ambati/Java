public class rangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int result;
        for(int i=left;i<right;i++){
            result = i&i++;
        }
        return result;
    }
} {
    
}
