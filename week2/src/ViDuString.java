public class ViDuString {
    public static void main(String[] args) {
        char[] hello = {'h','e','l','l','o'};
        String name = "manh do";
        String space = " ";
        String fs;
        int tuoi = 24;

        String helloViDuString = new String(hello);
        String sayHello = helloViDuString.concat(space).concat(name);

        fs = String.format("%s, %s \nTuổi của bạn là: %d", helloViDuString.toUpperCase(), name.toUpperCase(), tuoi);
        String[] words = fs.split("\\s");
        StringBuilder hi = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstLetter = word.substring(0,1).toUpperCase();
                String other = word.substring(1).toLowerCase();
                hi.append(firstLetter).append(other).append(" ");
            }
        }
        System.out.println(hi.toString().trim());
    }
}

