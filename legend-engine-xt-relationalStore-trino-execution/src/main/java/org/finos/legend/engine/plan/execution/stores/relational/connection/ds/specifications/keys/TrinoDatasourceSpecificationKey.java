package org.finos.legend.engine.plan.execution.stores.relational.connection.ds.specifications.keys;

import org.finos.legend.engine.plan.execution.stores.relational.connection.ds.DataSourceSpecificationKey;

import java.util.Objects;

public class TrinoDatasourceSpecificationKey implements DataSourceSpecificationKey
{
    public String host;
    public int port;
    public String trustStorePathVaultReference;
    public String tustStorePasswordVaultReference;
    public String clientTags;
    public boolean kerberosUseCanonicalHostname;

    public TrinoDatasourceSpecificationKey(String host, int port, String trustStorePathVaultReference, String tustStorePasswordVaultReference, String clientTags, boolean kerberosUseCanonicalHostname)
    {
        this.host = host;
        this.port = port;
        this.trustStorePathVaultReference = trustStorePathVaultReference;
        this.tustStorePasswordVaultReference = tustStorePasswordVaultReference;
        this.clientTags = clientTags;
        this.kerberosUseCanonicalHostname = kerberosUseCanonicalHostname;
    }

    @Override
    public String shortId()
    {
        return "TrinoDatasourceSpecificationKey_" +
                "host:'" + host + "_" +
                ", port:" + port + "_" +
                ", trustStorePathVaultReference:'" + trustStorePathVaultReference + "_" +
                ", tustStorePasswordVaultReference:'" + tustStorePasswordVaultReference + "_" +
                ", clientTags:'" + clientTags + "_" +
                ", kerberosUseCanonicalHostname:" + kerberosUseCanonicalHostname;
    }


    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    public String getTrustStorePathVaultReference()
    {
        return trustStorePathVaultReference;
    }

    public String getTustStorePasswordVaultReference()
    {
        return tustStorePasswordVaultReference;
    }

    public String getClientTags()
    {
        return clientTags;
    }

    public boolean getKerberosUseCanonicalHostname()
    {
        return kerberosUseCanonicalHostname;
    }

    @Override
    public String toString()
    {
        return "TrinoDatasourceSpecificationKey{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", trustStorePathVaultReference='" + trustStorePathVaultReference + '\'' +
                ", tustStorePasswordVaultReference='" + tustStorePasswordVaultReference + '\'' +
                ", clientTags='" + clientTags + '\'' +
                ", kerberosUseCanonicalHostname=" + kerberosUseCanonicalHostname +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrinoDatasourceSpecificationKey that = (TrinoDatasourceSpecificationKey) o;
        return port == that.port && kerberosUseCanonicalHostname == that.kerberosUseCanonicalHostname && Objects.equals(host, that.host) && Objects.equals(trustStorePathVaultReference, that.trustStorePathVaultReference) && Objects.equals(tustStorePasswordVaultReference, that.tustStorePasswordVaultReference) && Objects.equals(clientTags, that.clientTags);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(host, port, trustStorePathVaultReference, tustStorePasswordVaultReference, clientTags, kerberosUseCanonicalHostname);
    }
}
