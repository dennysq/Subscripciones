/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /*
       <jdbc-connection-pool allow-non-component-callers="false" associate-with-thread="false" connection-creation-retry-attempts="0" connection-creation-retry-interval-in-seconds="10" connection-leak-reclaim="false" connection-leak-timeout-in-seconds="0" connection-validation-method="auto-commit" datasource-classname="com.mysql.jdbc.jdbc2.optional.MysqlDataSource" fail-all-connections="false" idle-timeout-in-seconds="300" is-connection-validation-required="false" is-isolation-level-guaranteed="true" lazy-connection-association="false" lazy-connection-enlistment="false" match-connections="false" max-connection-usage-count="0" max-pool-size="32" max-wait-time-in-millis="60000" name="mysql_suscripciones_rootPool" non-transactional-connections="false" pool-resize-quantity="2" res-type="javax.sql.DataSource" statement-timeout-in-seconds="-1" steady-pool-size="8" validate-atmost-once-period-in-seconds="0" wrap-jdbc-objects="false">
        <property name="serverName" value="localhost"/>
        <property name="portNumber" value="3306"/>
        <property name="databaseName" value="suscripciones"/>
        <property name="User" value="root"/>
        <property name="Password" value="root"/>
        <property name="URL" value="jdbc:mysql://localhost:3306/suscripciones?zeroDateTimeBehavior=convertToNull"/>
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
    </jdbc-connection-pool>
    <jdbc-resource enabled="true" jndi-name="jdbc/suscripcion" object-type="user" pool-name="mysql_suscripciones_rootPool"/>

    
    */
}
