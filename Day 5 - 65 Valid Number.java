class Solution {
    public boolean isNumber(String s) {
        
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean digitAfterExp = true;

        for (int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                seenDigit = true;
                digitAfterExp = true;
            }
            else if (ch == '+' || ch == '-'){
                if( i!=0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E' )
                return false;
            }
            else if (ch == '.'){
                if (seenDot || seenExp)
                return false;
                seenDot = true;
            }
            else if (ch == 'e' || ch == 'E'){
                if (seenExp || ! seenDigit)
                return false;
                seenExp = true;
                digitAfterExp = false;
            }
            else{
                return false;
            }
        }
        return seenDigit && digitAfterExp;
    }
}
