import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Writing {

    public static void main(String[] args) {
        try {
            new Writing().exe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exe() throws Exception {

        try (PrintWriter writer = new PrintWriter(
                new FileOutputStream("text1.txt"))) {
            writer.println("Hello, world");
        }

        try (PrintWriter writer = new PrintWriter(
                new FileOutputStream("text2.txt"))) {
            for (int n = 0; n < 999; n++) {
                writer.print(randomNum(-500, 650) + " ");
            }
            writer.print(randomNum(-500, 650));
        }

        try (PrintWriter writer = new PrintWriter(
                new FileOutputStream("text3.txt"))) {
            for (int n = 0; n < 999; n++) {
                writer.print(randomNum(-500, 650) + ", ");
            }
            writer.print(randomNum(-500, 650));
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream("Contacts.txt"))) {
            writer.println("""
                    John | Smith | +380669821322 | 25.01.1995
                    Michael | Kors | +380502233322 | 15.05.1971
                    Jerrome | K.Jerrome | +3805087588543 | 05.03.1955
                    Walt | Whitman | +380934875990 | 10.06.1969
                    Max | Rockatansky | +380998436367 | 31.11.1978
                    Paul | Stanley | +3804488523390 | 25.08.1966
                    Thandie | Newton | +380508288769 | 17.02.1980
                    Mike | Myers | +380419658737 | 02.04.1973
                    Norman | Reedus | +380957627778 | 06.08.1975
                    Jack | Black | +380638949900 | 24.07.1967""");
        }
    }
    public int randomNum(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }
}