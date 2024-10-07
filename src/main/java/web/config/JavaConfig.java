//package web.config;
//
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.context.annotation.*;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.*;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(value = "web")
//public class JavaConfig {
//
//   @Autowired
//   private Environment env;
//
//   @Bean
//   public DataSource getDataSource() {
//      DriverManagerDataSource dataSource = new DriverManagerDataSource();
//      dataSource.setDriverClassName(env.getProperty("com.mysql.cj.jdbc.Driver"));
//      dataSource.setUrl(env.getProperty("jdbc:mysql://localhost:3306/web"));
//      dataSource.setUsername(env.getProperty("root"));
//      dataSource.setPassword(env.getProperty("root"));
//      return dataSource;
//   }
//
//   @Bean
//   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//      LocalContainerEntityManagerFactoryBean em =
//              new LocalContainerEntityManagerFactoryBean();
//      em.setDataSource(getDataSource());
//      em.setPackagesToScan("Model");
//      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//      em.setJpaVendorAdapter(vendorAdapter);
//      em.setJpaProperties(additionalProperties());
//      return em;
//   }
//
//   @Bean
//   public PlatformTransactionManager transactionManager() {
//      JpaTransactionManager transactionManager = new JpaTransactionManager();
//      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//      return transactionManager;
//   }
//
//   @Bean
//   public Properties additionalProperties() {
//      Properties properties = new Properties();
//      properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//      properties.put("hibernate.show_sql", "true");
//      properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
//      return properties;
//   }
//   @Bean
//   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//      return new PersistenceExceptionTranslationPostProcessor();
//   }
//}
//
