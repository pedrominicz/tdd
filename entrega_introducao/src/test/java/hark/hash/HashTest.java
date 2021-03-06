package hark.hash;

import org.junit.Test;
import static org.junit.Assert.*;

public class HashTest {

    private final Hash hash = new HashImpl();
    
    private final String message = "Hello, world!";

    // Test generated with GNU core utility `md5sum`
    @Test
    public void testMd5() {
        final String expected = "6cd3556deb0da54bca060b4c39479839";
        final String returned = hash.hashMessage(Hash.Type.MD5, message);

        assertEquals("Test MD5 hash", expected, returned);
    }

    // Test generated with GNU core utility `sha1sum`
    @Test
    public void testSha1() {
        final String expected = "943a702d06f34599aee1f8da8ef9f7296031d699";
        final String returned = hash.hashMessage(Hash.Type.SHA1, message);

        assertEquals("Test SHA1 hash", expected, returned);
    }

    // Test generated with GNU core utility `sha256sum`
    @Test
    public void testSha256() {
        final String expected = "315f5bdb76d078c43b8ac0064e4a0164612b1fce77c869345bfc94c75894edd3";
        final String returned = hash.hashMessage(Hash.Type.SHA256, message);

        assertEquals("Test SHA256 hash", expected, returned);
    }

}
