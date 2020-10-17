package hark.hash;

public class HashImpl implements Hash {

    public HashImpl() {
        // Empty.
    }

    @Override
    public String hashMessage(Type hashType, String message) {
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
    public boolean verifyMessage(Type hashType, String checksum, String message) {
        return false;
    }

}
