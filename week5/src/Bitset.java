import java.util.BitSet;
public class Bitset {
    public static void main(String[] args) {
        BitSet bits1 = new BitSet(20);
        BitSet bits2 = new BitSet(20);

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) bits1.set(i);
            if (i % 5 == 0) bits2.set(i);
        }

        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("Initial pattern in bits2: ");
        System.out.println(bits2);
        bits2.and(bits1);
        System.out.println("AND "+ bits2);
        bits2.or(bits1);
        System.out.println("OR "+ bits2);
        bits2.xor(bits1);
        System.out.println("XOR " + bits2);

    }
}
