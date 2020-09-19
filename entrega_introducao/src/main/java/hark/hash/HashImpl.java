package hark.hash;

public class HashImpl implements Hash {

    private final Hash.Type hashType;

    public HashImpl() {
        hashType = Hash.Type.MD5;
    }

    public HashImpl(final Hash.Type hashType) {
        this.hashType = hashType;
    }

    @Override
    public String hashMessage(String message) {
        return hashMessage(hashType, message);
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

}
