package hark.hash;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

public class HashImpl implements Hash {

    public HashImpl() {
        // Empty.
    }

    @Override
    public String hashMessage(final Type hashType, final String message) {
        switch (hashType) {
            case MD5:
                return Hashing.md5().hashString(message, StandardCharsets.UTF_8).toString();
            case SHA1:
                return Hashing.sha1().hashString(message, StandardCharsets.UTF_8).toString();
            case SHA256:
                return Hashing.sha256().hashString(message, StandardCharsets.UTF_8).toString();
        }

        throw new RuntimeException("Unreachable");
    }

    /**
     * Qualquer sequência de 128-bits é um hash MD5 válido, qualquer sequência
     * de 160-bits é um hash SHA1 válido e, finalmente, qualquer sequência de
     * 256-bits é um hash SHA256 válido. Para simplicidade, esperamos que o
     * checksum esteja codificado em hexadecimal (podendo conter letras
     * maiúsculas ou minúsculas).
     */
    private boolean verifyChecksum(final Type hashType, final String checksum) {
        switch (hashType) {
            case MD5:
                return checksum.matches("^[0-9A-Fa-f]{32}$");
            case SHA1:
                return checksum.matches("^[0-9A-Fa-f]{40}$");
            case SHA256:
                return checksum.matches("^[0-9A-Fa-f]{64}$");
        }

        throw new RuntimeException("Unreachable");
    }

    @Override
    public boolean verifyMessage(final Type hashType, final String checksum, final String message) {
        if (!verifyChecksum(hashType, checksum)) {
            throw new HashException();
        }

        return hashMessage(hashType, message).equals(checksum);
    }

}
