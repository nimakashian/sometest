import java.util.Arrays;

public class M4 {
    public static void main(String[] args) {

        Integer[] infos = null;

        Arrays.sort(infos);

        StringBuilder result = new StringBuilder();
        for (Integer ci: infos) {
            result.append(ci).append('\n');
        }
    }
}
