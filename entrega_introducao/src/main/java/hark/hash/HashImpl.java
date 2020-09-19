package hark.hash;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

public class HashImpl implements Hash {

    private final Hash.Type hashType;

    public HashImpl() {
        hashType = Hash.Type.MD5;
    }

    public HashImpl(final Hash.Type hashType) {
        this.hashType = hashType;
    }

    @Override
    public String hashMessage(final String message) {
        return hashMessage(hashType, message);
    }

    @Override
    // MD5 hashing is deprecated.
    @SuppressWarnings("deprecation")
    public String hashMessage(final Type hashType, final String message) {
        final HashCode hashCode;

        switch (hashType) {
            case MD5:
                hashCode = Hashing.md5().hashString(message, StandardCharsets.UTF_8);
                break;
            case SHA1:
                hashCode = Hashing.sha1().hashString(message, StandardCharsets.UTF_8);
                break;
            case SHA256:
                hashCode = Hashing.sha256().hashString(message, StandardCharsets.UTF_8);
                break;
            default:
                // The default branch should never be reached.
                throw new RuntimeException("Unreachable");
        }

        return hashCode.toString();
    }

}
