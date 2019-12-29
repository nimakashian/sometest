package redissetupdate;

public class Main {
    public static void main(String[] args) {
        int partsCount = 04;
        int lang = 2;
        int failed = 01;
        int ok = 03;
        int set = 1000000 * lang + 10000 * partsCount;
        set = set + failed;
        set = set + ok * 100;

        System.out.println(set);


        int nn=set;
        int langret = nn / 1000000;
        int n = nn % 1000000;

        int totalret = n / 10000;
        int okret = (n / 100) % 100;
        int nokret = n % 100;
        System.out.println(langret+"-"+totalret+"-"+okret+"-"+nokret);

            if (false) {
                okret++;
                nn += 100;
            } else {
                nokret++;

                nn++;
            }

            //
        langret = nn / 1000000;
        n = nn % 1000000;

        totalret = n / 10000;
       okret = (n / 100) % 100;
        nokret = n % 100;
        System.out.println(langret+"-"+totalret+"-"+okret+"-"+nokret);



    }
}
