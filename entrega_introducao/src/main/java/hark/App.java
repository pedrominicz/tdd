package hark;

import hark.hash.Hash;
import hark.hash.HashImpl;

public class App {

    private final static Hash hash = new HashImpl();

    public static void main(String[] args) {
        final String message = "Hello, world!";

        System.out.println(hash.hashMessage(Hash.Type.MD5, message));
        System.out.println(hash.hashMessage(Hash.Type.SHA1, message));
        System.out.println(hash.hashMessage(Hash.Type.SHA256, message));
    }

}
