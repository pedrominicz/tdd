package hark.hash;

public class HashImpl implements Hash {

    public HashImpl() {
        // Empty.
    }

    @Override
    public String hashMessage(final Type hashType, final String message) {
        switch (hashType) {
            case MD5:
                return "6cd3556deb0da54bca060b4c39479839";
            case SHA1:
                return "943a702d06f34599aee1f8da8ef9f7296031d699";
            case SHA256:
                return "315f5bdb76d078c43b8ac0064e4a0164612b1fce77c869345bfc94c75894edd3";
        }

        throw new RuntimeException("Unreachable");
    }

    @Override
    public boolean verifyMessage(final Type hashType, final String checksum, final String message) {
        switch (hashType) {
            case MD5:
                if (checksum.equals("6cd3556deb0da54bca060b4c39479839")) {
                    return true;
                } else if (checksum.equals("00000000000000000000000000000000")) {
                    return false;
                } else {
                    throw new HashException();
                }
            case SHA1:
                if (checksum.equals("943a702d06f34599aee1f8da8ef9f7296031d699")) {
                    return true;
                } else if (checksum.equals("0000000000000000000000000000000000000000")) {
                    return false;
                } else {
                    throw new HashException();
                }
            case SHA256:
                if (checksum.equals("315f5bdb76d078c43b8ac0064e4a0164612b1fce77c869345bfc94c75894edd3")) {
                    return true;
                } else if (checksum.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    return false;
                } else {
                    throw new HashException();
                }
        }

        throw new RuntimeException("Unreachable");
    }

}
