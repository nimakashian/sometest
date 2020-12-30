import java.util.ArrayList;
import java.util.List;

public class longpagination {
    public static void main(String[] args) {
        List<String> messageList = new ArrayList<>();
        for(int i=0; i<12; i++){
            messageList.add(i+"");
        }
        int toIndex = 0;
        int fromIndex = 0;
        int maxBlockSize = 10;
        int messageSize = messageList.size();
        while (fromIndex < messageSize) {
            toIndex = ((fromIndex + maxBlockSize) > messageSize) ? messageSize : (fromIndex + maxBlockSize);
            String[] messageBlock = messageList
                    .subList(fromIndex, toIndex)
                    .toArray(new String[0]);
            fromIndex = toIndex;
        }
    }
}
