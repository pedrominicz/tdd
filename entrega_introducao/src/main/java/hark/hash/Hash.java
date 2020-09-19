package hark.hash;

public interface Hash {

    // Hash with the default algorithm.
    public String hashMessage(final String message);

    // Hash with a specifig algorithm.
    public String hashMessage(final Type hashType, final String message);

    enum Type {
        MD5,
        SHA1,
        SHA256
    }
    
}
