public class VongLap {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Lần thứ: " + i);
        }
        for (int i = 1; i < 10; i++) {
            System.out.println("-----------------------");
            for (int j = 1; j <= 9; j++) {
                System.out.println( i +"x" +j + "=" + i*j);
            }
        }
        int j = 0;
        do {
            System.out.println("Đây là lần thứ "+ j + " của j");
            j++;
            if(j == 5){
                break;
            }
        } while (j < 10);
        int i = 0;
        while (i < 10){
            i++;
            if(i == 5){
                continue;
            };
            System.out.println("Đây là lần thứ "+ i + " của i");
        }
    }
}
