public class RomanNumbers {

    public static void main(String[] args) {

        try {
            String r = intToRoman(1000);
            System.out.println("numeral = " + r);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String intToRoman(int num) throws Exception {

        if (num < 1 || num > 3999) {
            throw new Exception("The smallest and largest number that can be represented is 1 and 3,999 respectively");
        }

        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};
        return thousands[num / 1000] + hundreds[(num / 100) % 10] + tens[(num / 10) % 10] + ones[num % 10];
    }
}


