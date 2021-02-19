package hark.hash;

public interface Hash {

    // Hash with a specifig algorithm.
    public String hashMessage(final Type hashType, final String message);
    
    // Verify with a specifig algorithm.
    public boolean verifyMessage(final Type hashType, final String checksum, final String message);

    enum Type {
        MD5,
        SHA1,
        SHA256
    }
    
}
