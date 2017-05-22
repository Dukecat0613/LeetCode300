public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aNums = a.split("\\+");
        String[] bNums = b.split("\\+");
        int intPart = Integer.valueOf(aNums[0]) * Integer.valueOf(bNums[0]);
        String aComplex = aNums[1].substring(0, aNums[1].length() - 1);
        String bComplex = bNums[1].substring(0, bNums[1].length() - 1);
        int intPartComplex = Integer.valueOf(aComplex) * Integer.valueOf(bComplex);
        int intFinal = intPart - intPartComplex;
        int complexPart = Integer.valueOf(aNums[0]) * Integer.valueOf(bComplex) + Integer.valueOf(bNums[0]) * Integer.valueOf(aComplex);
        String res = String.valueOf(intFinal) + "+" + String.valueOf(complexPart) + "i";
        return res;
    }
}
