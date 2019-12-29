package allfailedtest;

public class Main{
    public static void main(String[] args) {
        boolean allAuthenticated=false;
        boolean[] all={true, true, true, true};
        for (boolean mtData: all) {
            if (!mtData) {

                allAuthenticated=allAuthenticated || false;

            }else{
                allAuthenticated=allAuthenticated || true;
            }
        }
        System.out.println(allAuthenticated);
    }
}
