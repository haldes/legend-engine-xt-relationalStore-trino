parser grammar TrinoParserGrammar;

import CoreParserGrammar;

options
{
    tokenVocab = TrinoLexerGrammar;
}

identifier:                                 VALID_STRING
;
trinoDatasourceSpecification:               TRINO
                                                BRACE_OPEN
                                                    (
                                                        trinoHost
                                                        | trinoPort
                                                        //| trinoSSL
                                                        | trinoTrustStorePathVaultReference
                                                        | trinoTustStorePasswordVaultReference
                                                        | trinoKerberosUseCanonicalHostname
                                                        | trinoClientTags
                                                    )*
                                                BRACE_CLOSE
;

trinoHost:                                  HOST COLON STRING SEMI_COLON
;

trinoPort:                                  PORT COLON INTEGER SEMI_COLON
;

trinoKerberosUseCanonicalHostname:          KERBEROS_USE_CANONICAL_HOSTNAME COLON BOOLEAN SEMI_COLON
;

trinoClientTags:                            CLIENT_TAGS COLON STRING SEMI_COLON
;

trinoTrustStorePathVaultReference:          TRUST_STORE_PATH_VAULT_REFERENCE COLON STRING SEMI_COLON
;

trinoTustStorePasswordVaultReference:       TRUST_STORE_PASSWORD_VAULT_REFERENCE COLON STRING SEMI_COLON
;

/*sslField:                                   BRACE_OPEN
                                                (
                                                trinoTrustStorePathVaultReference
                                                | trinoTustStorePasswordVaultReference
                                                )*
                                            BRACE_CLOSE
;

trinoSSL:                                   SSL COLON sslField SEMI_COLON
;*/


