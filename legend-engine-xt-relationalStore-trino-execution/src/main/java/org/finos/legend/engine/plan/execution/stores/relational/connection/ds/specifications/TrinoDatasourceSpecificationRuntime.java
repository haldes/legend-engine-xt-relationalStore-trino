package org.finos.legend.engine.plan.execution.stores.relational.connection.ds.specifications;

import org.finos.legend.engine.plan.execution.stores.relational.connection.authentication.AuthenticationStrategy;
import org.finos.legend.engine.plan.execution.stores.relational.connection.driver.DatabaseManager;
import org.finos.legend.engine.plan.execution.stores.relational.connection.ds.DataSourceSpecificationKey;
import org.finos.legend.engine.plan.execution.stores.relational.connection.ds.specifications.keys.TrinoDatasourceSpecificationKey;

import java.util.Map;
import java.util.Properties;


public class TrinoDatasourceSpecificationRuntime extends org.finos.legend.engine.plan.execution.stores.relational.connection.ds.DataSourceSpecification
{
    private static final String SSL = "SSL";
    private static final String KERBEROES_REMOTE_SERVICE_NAME = "KerberosRemoteServiceName";
    private static final String SSL_TRUST_STORE_PATH = "SSLTrustStorePath";
    private static final String SSL_TRUST_STORE_PASSWORD = "SSLTrustStorePassword";
    private static final String CLIENT_TAGS = "clientTags";
    private static final String KERBEROS_USE_CANONICAL_HOSTNAME = "KerberosUseCanonicalHostname";
    private final TrinoDatasourceSpecificationKey key;

    protected TrinoDatasourceSpecificationRuntime(TrinoDatasourceSpecificationKey key, DatabaseManager databaseManager, AuthenticationStrategy authenticationStrategy, Properties extraUserProperties)
    {
        super(key, databaseManager, authenticationStrategy, extraUserProperties);
        this.key = key;
        this.extraDatasourceProperties.putAll(getProperties());
    }
    protected TrinoDatasourceSpecificationRuntime(TrinoDatasourceSpecificationKey key, DatabaseManager databaseManager, AuthenticationStrategy authenticationStrategy, Properties extraUserProperties, int maxPoolSize, int minPoolSize)
    {
        super(key, databaseManager, authenticationStrategy, extraUserProperties, maxPoolSize, minPoolSize);
        this.key = key;
        this.extraDatasourceProperties.putAll(getProperties());
    }

    private Properties getProperties()
    {
        Properties properties = new Properties();
        properties.setProperty(KERBEROES_REMOTE_SERVICE_NAME, "HTTP");
        properties.setProperty(SSL, "true");

        properties.setProperty(SSL_TRUST_STORE_PATH,key.getTrustStorePathVaultReference());
        properties.setProperty(SSL_TRUST_STORE_PASSWORD, key.getTustStorePasswordVaultReference());
        properties.setProperty(CLIENT_TAGS, key.getClientTags());
        properties.setProperty(KERBEROS_USE_CANONICAL_HOSTNAME, String.valueOf(key.getKerberosUseCanonicalHostname()));

        return properties;
    }



    @Override
    protected String getJdbcUrl(String host, int port, String databaseName, Properties properties)
    {
        // usually defaults for host, port and databaseName are passed to this method in the original call.
        // This method is supposed to reset to correct values, if required, and construct the jdbc url by relaying to super class, which in turn relays to Driver.
        //TrinoDatasourceSpecificationKey key = (TrinoDatasourceSpecificationKey) this.datasourceKey;
        return super.getJdbcUrl(key.getHost(), key.getPort(), null, properties);
    }
}
