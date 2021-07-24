import java.lang.Math;
import java.math.BigInteger;
import java.math.BigDecimal;
class HelloWorld {

    public static void main(String[] args) {
        BigInteger x = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");

        BigInteger answer = kasturba(x,y,4);
        System.out.println(answer); 
    }
    
    public static  BigInteger kasturba (BigInteger x, BigInteger y, int digits){

        if(digits == 1)
            return x.multiply(y);
        else{
            BigInteger power = BigDecimal.valueOf(Math.pow(10,digits/2)).toBigInteger();
            BigInteger b = x.remainder(power);
            BigInteger a = (x.subtract(b)).divide(power);
            BigInteger d = y.remainder(power);
            BigInteger c = (y.subtract(d)).divide(power);
            BigInteger ac = kasturba(a,c,digits/2);
            BigInteger bd = kasturba(b,d,digits/2);
            BigInteger ac_bd = kasturba(a.add(b),c.add(d),digits/2).subtract(ac).subtract(bd);
            BigInteger firstterm = ac.multiply(BigDecimal.valueOf(Math.pow(10,digits)).toBigInteger())
             .add(ac_bd.multiply(power)).add(bd);
            return firstterm;
        }
    }
}