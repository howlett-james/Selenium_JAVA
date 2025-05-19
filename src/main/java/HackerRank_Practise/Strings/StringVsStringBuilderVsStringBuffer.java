package HackerRank_Practise.Strings;

public class StringVsStringBuilderVsStringBuffer {
    public static void main(String[] args) {
        // Test with StringBuilder (not synchronized)
        StringBuilder sb = new StringBuilder("Hello");
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append(" World");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append(" World!");
            }
        });
        t1.start();
        t2.start();

        // Using StringBuffer (synchronized)
        StringBuffer sbf = new StringBuffer("Hello");
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sbf.append(" World");
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sbf.append(" World!");
            }
        });
        t3.start();
        t4.start();

        try {
            t1.join(); t2.join(); // Wait for threads to complete for StringBuilder
            t3.join(); t4.join(); // Wait for threads to complete for StringBuffer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print results (not thread-safe StringBuilder might cause issues)
        System.out.println("StringBuilder (no thread-safety): " + sb);
        System.out.println("StringBuffer (thread-safe): " + sbf);
    }
}
