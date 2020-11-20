import java.util.ArrayList;

public class BigNumber {
    private ArrayList<Integer> digits;
    private int sign;

    public BigNumber(String num) {
        int i = 0;
        if (num.charAt(0) == '-') {
            sign = 1;
            i = 1;
        } else
            sign = 0;
        digits = new ArrayList<>();

        for (int j = num.length() - 1; j >= 0 + i; j--) {
            digits.add(Character.getNumericValue(num.charAt(j)));
        }
    }

    public BigNumber minimum(BigNumber compared) {
        int comp = this.compareTo(compared);
        if (comp == -1)
            return this;
        else
            return compared;

    }

    public BigNumber maximum(BigNumber compared) {
        int comp = this.compareTo(compared);
        if (comp == 1)
            return this;
        else
            return compared;
    }

    public int compareTo(BigNumber second) {
        if (this.sign == 0 && second.sign == 1)
            return 1;
        else if (this.sign == 1 && second.sign == 0)
            return -1;
        else if (this.sign == 0 && second.sign == 0) {
            if (this.digits.size() > second.digits.size())
                return 1;
            else if (this.digits.size() < second.digits.size())
                return -1;
            else {
                for (int i = this.digits.size() - 1; i >= 0; i--) {
                    if (this.digits.get(i) > second.digits.get(i))
                        return 1;
                    else if (this.digits.get(i) < second.digits.get(i))
                        return -1;
                }
                return 0;
            }
        } else {
            if (this.digits.size() > second.digits.size())
                return -1;
            else if (this.digits.size() < second.digits.size())
                return 1;
            else {
                for (int i = this.digits.size() - 1; i >= 0; i--) {
                    if (this.digits.get(i) > second.digits.get(i))
                        return -1;
                    else if (this.digits.get(i) < second.digits.get(i))
                        return 1;
                }
                return 0;
            }
        }
    }

    public BigNumber add(BigNumber second) {
        //int comp = this.compareTo(second);
        String signed = "";
        ArrayList<Integer> result = new ArrayList<>();
        if (this.sign == second.sign) {
            if (this.sign == 1)
                signed = "-";
            int sum = 0;
            int carry = 0;   // 159 => |9|5|1|
            for (int i = 0; i < Math.max(this.digits.size(), second.digits.size()); i++) {
                if (this.digits.size() > i && second.digits.size() > i) //1000 + 2 = 1002
                    sum = carry + this.digits.get(i) + second.digits.get(i);
                else if (this.digits.size() <= i)
                    sum = carry + second.digits.get(i);       //1119 + 2 = 1121
                else if (second.digits.size() <= i)
                    sum = carry + this.digits.get(i);
                result.add(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0)
                result.add(carry);
            for (int i = result.size() - 1; i >= 0; i--) {
                signed += result.get(i);
            }
            return new BigNumber(signed);
        }else{
            if (this.sign==1){ // -7 + 2 = 2 + (-7) = 2 - 7
                this.sign = 0;
                return second.substract(this);
            }else{ // 7 + (-2) = 7 - 2
                second.sign = 0;
                return this.substract(second);
            }
        }

    }

    public BigNumber substract(BigNumber second) {
        int comp = this.compareTo(second);
        String signed = "";
        ArrayList<Integer> result = new ArrayList<>();
        BigNumber res = new BigNumber("0");
        boolean checkZero = false;
        if (this.sign != second.sign) { // -7 - 2 = -7 + -2 || 7 - (-2) = 7 + 2
            if (this.sign == 1) {
                second.setSign(1);
                return this.add(second);
            } else {
                second.setSign(0);
                return this.add(second);
            }
        } else if (this.sign == 0 && second.sign == 0) {
            BigNumber from = this;
            BigNumber that = second;
            if (comp == 0)
                return new BigNumber("0");
            else if (comp == -1) {
                signed = "-";
                from = second;
                that = this;
            }
            int sub = 0;
            int carry = 0;
            for (int i = 0; i < Math.max(from.digits.size(), that.digits.size()); i++) {
                if (from.digits.size() > i && that.digits.size() > i) {
                    if (from.digits.get(i) > that.digits.get(i)) {//e.g. 9-8
                        sub = from.digits.get(i) - that.digits.get(i) - carry;
                        carry = 0;
                    } else if(from.digits.get(i) < that.digits.get(i)){// e.g. 7-9
                        sub = from.digits.get(i) - that.digits.get(i) + 10 - carry;
                        carry = 1;
                    }else{ //8-8   206 - 89 = 117
                        if (carry == 0) {
                            sub = from.digits.get(i) - that.digits.get(i) - carry;
                            carry = 0;
                        }else{
                            sub = from.digits.get(i) - that.digits.get(i) - carry + 10;
                            carry = 1;
                        }
                    }
                } else {
                    if (carry > from.digits.get(i))//if carry is 1 and digit is 0
                    {
                        sub = 9;
                        carry = 1;
                    } else {
                        sub = from.digits.get(i) - carry;
                        carry = 0;
                    }
                }
                result.add(sub);
            }
        } else { // -x - -y = -x + y = y - x
            this.sign = 0;
            second.sign =0;
            return second.substract(this);
        }
        String sayi = "";
        for (int i = result.size() - 1; i >= 0; i--) { // 0000000007008 => 7008
            if (result.get(i) != 0)
                checkZero = true;
            if (checkZero)
                sayi += result.get(i) + "";
        }
        sayi = signed + sayi;
        res = new BigNumber(sayi);
        return res;
    }

    @Override
    public String toString() {   // 159 == |9|5|1| = [9,5,1] => "159"
        String num = "";
        if (sign == 1)
            num = "-";
        for (int i = this.digits.size() - 1; i >= 0; i--) {
            num += this.digits.get(i);
        }
        return num;  // "Product"+ ProductNo "= " .... BigNumber number1 = new BigNumber("15"); System.out.println(number1.toString());
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}
