public class Max
{
    def max(a: Int, b: Int, c: Int) : Int = {
        val maxVal = a;

        if(a > b) {
            if(a > c) {
                maxVal = a;
            }
            else {
                maxVal = c;
            }
        }
        else {
            if(b > c) {
                maxVal = b;
            }
            else {
                maxVal = c;
            }
        }

        return maxVal;
    }
}