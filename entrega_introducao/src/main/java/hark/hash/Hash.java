package hark.hash;

public interface Hash {

    // Hash with the default algorithm.
    public String hashMessage(final String message);

    // Hash with a specifig algorithm.
    public String hashMessage(final String hashType, final String message);

    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String SHA256 = "SHA256";
    
}
