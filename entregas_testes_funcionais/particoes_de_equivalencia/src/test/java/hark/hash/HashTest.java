package hark.hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashTest {

    private final Hash hash = null;

    private final String message = "Hello, world!";

    // Generated with GNU core utility `md5sum`.
    private final String checksumMD5 = "6cd3556deb0da54bca060b4c39479839";

    // Generated with GNU core utility `sha1sum`.
    private final String checksumSHA1 = "943a702d06f34599aee1f8da8ef9f7296031d699";

    // Generated with GNU core utility `sha256sum`.
    private final String checksumSHA256 = "315f5bdb76d078c43b8ac0064e4a0164612b1fce77c869345bfc94c75894edd3";

    /**
     * The function `hashMessage` has three equivalence partitions, one for each
     * hashing algorithm. Note that this is the case since every input is valid. The
     * three partitions are tested by `hashMessageMD5`, `hashMessageSHA1`, and
     * `hashMessageSHA256`.
     */

    @Test
    public void hashMessageMD5() {
        final String expected = checksumMD5;
        final String returned = hash.hashMessage(Hash.Type.MD5, message);

        assertEquals(expected, returned, "Hash message (MD5)");
    }

    @Test
    public void hashMessageSHA1() {
        final String expected = checksumSHA1;
        final String returned = hash.hashMessage(Hash.Type.SHA1, message);

        assertEquals(expected, returned, "Hash message (SHA1)");
    }

    @Test
    public void hashMessageSHA256() {
        final String expected = checksumSHA256;
        final String returned = hash.hashMessage(Hash.Type.SHA256, message);

        assertEquals(expected, returned, "Hash message (SHA256)");
    }

    /**
     * The function `verifyMessage` has nine equivalence partitions,
     * corresponding to the following table:
     * 
     * |            | **Hash correta**             | **Hash incorreta**             | **Hash inválida**    |
     * |:----------:|------------------------------|--------------------------------|----------------------|
     * | **MD5**    | Hash MD5 válida e correta    | Hash MD5 válida e incorreta    | Hash MD5 inválida    |
     * | **SHA1**   | Hash SHA1 válida e correta   | Hash SHA1 válida e incorreta   | Hash SHA1 inválida   |
     * | **SHA256** | Hash SHA256 válida e correta | Hash SHA256 válida e incorreta | Hash SHA256 inválida |
     * 
     * Each of the following nine tests correspond to each entry on the table
     * from left to right and top to bottom.
     */

    /** First row (MD5) */
    @Test
    public void verifyMessageMD5Correct() {
        final boolean result = hash.verifyMessage(Hash.Type.MD5, checksumMD5, message);

        assertTrue(result, "Verify correct checksum (MD5)");
    }

    @Test
    public void verifyMessageMD5Inorrect() {
        final String checksum = "00000000000000000000000000000000";
        final boolean result = hash.verifyMessage(Hash.Type.MD5, checksum, message);

        assertFalse(result, "Verify incorrect checksum (MD5)");
    }

    @Test
    public void verifyMessageMD5Invalid() {
        final String checksum = "invalid";

        assertThrows(RuntimeException.class, () -> {
            hash.verifyMessage(Hash.Type.MD5, checksum, message);
        }, "Verify invalid checksum (MD5)");
    }

    /** Second row (SHA1) */
    @Test
    public void verifyMessageSHA1Correct() {
        final boolean result = hash.verifyMessage(Hash.Type.SHA1, checksumSHA1, message);

        assertTrue(result, "Verify correct checksum (SHA1)");
    }

    @Test
    public void verifyMessageSHA1Inorrect() {
        final String checksum = "0000000000000000000000000000000000000000";
        final boolean result = hash.verifyMessage(Hash.Type.SHA1, checksum, message);

        assertFalse(result, "Verify incorrect checksum (SHA1)");
    }

    @Test
    public void verifyMessageSHA1Invalid() {
        final String checksum = "invalid";

        assertThrows(RuntimeException.class, () -> {
            hash.verifyMessage(Hash.Type.SHA1, checksum, message);
        }, "Verify invalid checksum (SHA1)");
    }

    /** Third row (SHA256) */
    @Test
    public void verifyMessageSHA256Correct() {
        final boolean result = hash.verifyMessage(Hash.Type.SHA256, checksumSHA256, message);

        assertTrue(result, "Verify correct checksum (SHA256)");
    }

    @Test
    public void verifyMessageSHA256Inorrect() {
        final String checksum = "0000000000000000000000000000000000000000000000000000000000000000";
        final boolean result = hash.verifyMessage(Hash.Type.SHA256, checksum, message);

        assertFalse(result, "Verify incorrect checksum (SHA256)");
    }

    @Test
    public void verifyMessageSHA256Invalid() {
        final String checksum = "invalid";

        assertThrows(RuntimeException.class, () -> {
            hash.verifyMessage(Hash.Type.SHA256, checksum, message);
        }, "Verify invalid checksum (SHA256)");
    }

}
