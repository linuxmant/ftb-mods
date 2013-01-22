dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "modsdba"
			password = "modpacks"
			url = "jdbc:mysql://localhost:3306/ftbmods_test"
			logSQL = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
    test {
        dataSource {
            dbCreate = "create"
            url = "jdbc:h2:ftbmods-test"
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
        }
    }
    production {
        dataSource {
            dbCreate = "update"
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "modsdba"
			password = "modpacks"
			url = "jdbc:mysql://localhost:3306/ftbmods"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
