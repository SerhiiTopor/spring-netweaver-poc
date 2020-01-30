# spring-netweaver-poc

artifact deploy undeploy command:

**deploy:** deploy D:\spring-netweaver-poc-ear-0.0.1-SNAPSHOT.ear on_prerequisite_error=stop version_rule=all**

**undeploy:** undeploy  vendor=JavaEE name=spring-netweaver-poc

**application path:** localhost:50000/spring-poc define in ear pom.xml maven-ear-plugin

**DataConfig** class defines DataSource and JPA provider implementation

**Attention** property SCHEMA_GENERATION_DATABASE_ACTION: "drop-and-create" drops schema when app restarts

**WebConfig** class defines ViewResolver bean for jsp processing

**application-j2ee-engine.xml** 
<reference-target provider-name="sap.com" target-type="library">javax~persistence~api~20</reference-target> is mandatory for ORM systems
