### Hark: listen!

Hark é um flexível gerador e verificador de checksum. É possível gerar checksums MD5, SHA1 ou SHA256 para qualquer string.

A criação de checksums é feita através da função [`hashMessage`][1].

```java
// Hash with a specifig algorithm.
public String hashMessage(final Type hashType, final String message);
```

Dividimos os testes da função `hashMessage` em três partições, uma para cada algoritmo: [MD5][2], [SHA1][3] e [SHA256][4].

A verificação de hashes é feita pela função [`verifyMessage`][5].

```java
// Verify with a specifig algorithm.
public boolean verifyMessage(final Type hashType, final String checksum, final String message);
```

Qualquer sequência de 128-bits é um hash MD5 válido, qualquer sequência de 160-bits é um hash SHA1 válido e, finalmente, qualquer sequência de 256-bits é um hash SHA256 válido. Para simplicidade, a função `verifyMessage` espera que o checksum esteja codificado em hexadecimal (podendo conter letras maiúsculas ou minúsculas). A função deve falhar quando o checksum for inválido.

Sendo assim, dividimos os testes da função `verifyMessage` em nove partições de equivalência, correspondendo à tabela abaixo:

|            | **Hash correta**                   | **Hash incorreta**                   | **Hash inválida**          |
|:----------:|------------------------------------|--------------------------------------|----------------------------|
| **MD5**    | [Hash MD5 válida e correta][6]     | [Hash MD5 válida e incorreta][7]     | [Hash MD5 inválida][8]     |
| **SHA1**   | [Hash SHA1 válida e correta][9]    | [Hash SHA1 válida e incorreta][10]   | [Hash SHA1 inválida][11]   |
| **SHA256** | [Hash SHA256 válida e correta][12] | [Hash SHA256 válida e incorreta][13] | [Hash SHA256 inválida][14] |

A função `verifyMessage` não fez parte da primeira entrega. A adicionei pois julguei necessário prover um exemplo com mais partições de equivalência.

[1]: src/main/java/hark/hash/HashImpl.java#L15
[2]: src/test/java/hark/hash/HashTest.java#L30
[3]: src/test/java/hark/hash/HashTest.java#L38
[4]: src/test/java/hark/hash/HashTest.java#L46
[5]: src/main/java/hark/hash/HashImpl.java#L49
[6]: src/test/java/hark/hash/HashTest.java#L69
[7]: src/test/java/hark/hash/HashTest.java#L76
[8]: src/test/java/hark/hash/HashTest.java#L84
[9]: src/test/java/hark/hash/HashTest.java#L94
[10]: src/test/java/hark/hash/HashTest.java#L101
[11]: src/test/java/hark/hash/HashTest.java#L109
[12]: src/test/java/hark/hash/HashTest.java#L119
[13]: src/test/java/hark/hash/HashTest.java#L126
[14]: src/test/java/hark/hash/HashTest.java#L134
