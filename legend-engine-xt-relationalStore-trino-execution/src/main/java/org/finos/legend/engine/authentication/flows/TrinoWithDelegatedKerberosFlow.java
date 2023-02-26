package org.finos.legend.engine.authentication.flows;

import org.finos.legend.engine.authentication.DatabaseAuthenticationFlow;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.DatabaseType;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.authentication.DelegatedKerberosAuthenticationStrategy;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.specification.TrinoDatasourceSpecification;
import org.finos.legend.engine.shared.core.identity.Credential;
import org.finos.legend.engine.shared.core.identity.Identity;
import org.finos.legend.engine.shared.core.identity.credential.LegendKerberosCredential;

import java.util.Optional;

public class TrinoWithDelegatedKerberosFlow
        implements DatabaseAuthenticationFlow<TrinoDatasourceSpecification, DelegatedKerberosAuthenticationStrategy>
{
    @Override
    public Class<TrinoDatasourceSpecification> getDatasourceClass()
    {
        return TrinoDatasourceSpecification.class;
    }

    @Override
    public Class<DelegatedKerberosAuthenticationStrategy> getAuthenticationStrategyClass()
    {
        return DelegatedKerberosAuthenticationStrategy.class;
    }

    @Override
    public DatabaseType getDatabaseType()
    {
        return DatabaseType.Trino;
    }

    @Override
    public Credential makeCredential(Identity identity, TrinoDatasourceSpecification trinoDatasourceSpecification, DelegatedKerberosAuthenticationStrategy delegatedKerberosAuthenticationStrategy)
            throws Exception
    {
        Optional<LegendKerberosCredential> credentialHolder = identity.getCredential(LegendKerberosCredential.class);
        if (!credentialHolder.isPresent()) {
            throw new Exception("Identity does not contain expected credential of type : " + LegendKerberosCredential.class);
        }
        return credentialHolder.get();
    }
}
