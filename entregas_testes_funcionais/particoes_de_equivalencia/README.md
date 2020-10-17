### Hark: listen!

Hark é um flexível gerador e verificador de _checksum_. É possível gerar _checksums_ MD5, SHA1 ou SHA256 para qualquer _string_.

A criação de _checksums_ é feita através da função `hashMessage`.

    // Hash with a specifig algorithm.
    public String hashMessage(final Type hashType, final String message);

Dividimos os testes da função `hashMessage` em três partições, uma para cada algoritmo: MD5, SHA1 e SHA256.

A verificação de _hashs_ é feita pela função `verifyMessage`.

    // Verify with a specifig algorithm.
    public String verifyMessage(final Type hashType, final String checksum, final String message);

Qualquer sequência de 128-bits é um _hash_ MD5 válido, qualquer sequência de 160-bits é um _hash_ SHA1 válido e, finalmente, qualquer sequência de 256-bits é um _hash_ SHA256 válido. Para simplicidade, a função `verifyMessage` espera que o _checksum_ esteja codificado em hexadecimal (podendo conter letras maiúsculas ou minúsculas). A função deve falhar quando o _checksum_ for inválido, informando ao usuário se ele é longo ou curto demais e se contém caracteres inválidos.

<!-- Sendo assim, dividimos... -->

A função `verifyMessage` não fez parte da primeira entrega. A adicionei pois julguei necessário prover um exemplo com mais partições de equivalência.

**TODO:**
- Adicionar paragrafo explicando as partições da função `verifyMessage`
- Estado vermelho
- Estado verde
- Estado azul
- Adicionar _links_ para as funções `hashMessage` e `verifyMessage`
