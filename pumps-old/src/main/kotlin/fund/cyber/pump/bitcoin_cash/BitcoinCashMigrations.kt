package fund.cyber.pump.bitcoin_cash

import fund.cyber.cassandra.migration.CqlFileBasedMigration
import fund.cyber.cassandra.migration.ElasticHttpMigration
import fund.cyber.node.common.Chain.*
import fund.cyber.pump.cassandra.chainApplicationId


object BitcoinCashMigrations {

    private val applicationId = BITCOIN_CASH.chainApplicationId

    val migrations = listOf(
            CqlFileBasedMigration(0, applicationId, "/migrations/bitcoin_cash/0_initial.cql"),
            ElasticHttpMigration(1, applicationId, "/migrations/bitcoin_cash/1_create-tx-index.json"),
            ElasticHttpMigration(2, applicationId, "/migrations/bitcoin_cash/2_create-tx-type.json"),
            ElasticHttpMigration(3, applicationId, "/migrations/bitcoin_cash/3_create-block-index.json"),
            ElasticHttpMigration(4, applicationId, "/migrations/bitcoin_cash/4_create-block-type.json"),
            ElasticHttpMigration(5, applicationId, "/migrations/bitcoin_cash/5_create-address-index.json"),
            ElasticHttpMigration(6, applicationId, "/migrations/bitcoin_cash/6_create-address-type.json"),
            CqlFileBasedMigration(7, applicationId, "/migrations/bitcoin_cash/7_genesis.cql")
    )
}