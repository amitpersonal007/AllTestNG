public class Test {

        public static void main(String[]args){
            int rev=0;
            int num=123;
            int t=num;
            while(num>0){
                t=t%10;
                rev=rev*10+t;
                t=t/10;

        }
            System.out.println(num);
            System.out.println(t);

    }



}
