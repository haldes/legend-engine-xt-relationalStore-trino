// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.plan.execution.stores.relational.connection.ds.specifications.keys;

import org.finos.legend.engine.plan.execution.stores.relational.connection.ds.DataSourceSpecificationKey;

import java.util.Objects;

public class TrinoDatasourceSpecificationKey
        implements DataSourceSpecificationKey
{
    public String host;
    public int port;
    public String trustStorePathVaultReference;
    public String trustStorePasswordVaultReference;
    public String clientTags;
    public boolean kerberosUseCanonicalHostname;

    public TrinoDatasourceSpecificationKey(String host, int port, String trustStorePathVaultReference, String trustStorePasswordVaultReference, String clientTags, boolean kerberosUseCanonicalHostname)
    {
        this.host = host;
        this.port = port;
        this.trustStorePathVaultReference = trustStorePathVaultReference;
        this.trustStorePasswordVaultReference = trustStorePasswordVaultReference;
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
                ", trustStorePasswordVaultReference:'" + trustStorePasswordVaultReference + "_" +
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

    public String getTrustStorePasswordVaultReference()
    {
        return trustStorePasswordVaultReference;
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
                ", trustStorePasswordVaultReference='" + trustStorePasswordVaultReference + '\'' +
                ", clientTags='" + clientTags + '\'' +
                ", kerberosUseCanonicalHostname=" + kerberosUseCanonicalHostname +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        TrinoDatasourceSpecificationKey that = (TrinoDatasourceSpecificationKey) o;
        return port == that.port && kerberosUseCanonicalHostname == that.kerberosUseCanonicalHostname && Objects.equals(host, that.host) && Objects.equals(trustStorePathVaultReference, that.trustStorePathVaultReference) && Objects.equals(trustStorePasswordVaultReference, that.trustStorePasswordVaultReference) && Objects.equals(clientTags, that.clientTags);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(host, port, trustStorePathVaultReference, trustStorePasswordVaultReference, clientTags, kerberosUseCanonicalHostname);
    }
}
