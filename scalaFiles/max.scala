public class Max
{
    def max(a: Int, b: Int, c: Int) : Int = {

        if(a > b) {
            if(a > c) {
                println(a);
            }
            else {
                println(c);
            }
        }
        else {
            if(b > c) {
                println(b);
            }
            else {
                println(c);
            }
        }

        return 1;
    }
}