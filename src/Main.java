
public class Main {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        String test = "ABAABABBAABAABAAAABABBBBBBBB";

        System.out.println("compressed:"+compressor.compress(test));

        String decompressedtext = compressor.decompress(compressor.compress(test));
        System.out.println("decompressed:"+decompressedtext);

        System.out.println(decompressedtext.equals(test));

    }
}