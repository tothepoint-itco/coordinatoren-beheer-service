package company.tothepoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@SpringBootApplication
@EnableDiscoveryClient
public class BeheerApplication {
    private static final String BEHEER_QUEUE = "beheer-queue";
    private static final String BUSINESSUNIT_EXCHANGE = "businessunit-exchange";
    private static final String BUSINESSUNIT_ROUTING = "businessunit-routing";
    private static final String BEHEER_EXCHANGE = "beheer-exchange";
    private static final String BEHEER_ROUTING = "beheer-routing";

    public static void main(String[] args) {
        SpringApplication.run(BeheerApplication.class, args);
    }

    @Bean
    String queueName() {
        return BEHEER_QUEUE;
    }

    @Bean
    Queue queue() {
        return new Queue(BEHEER_QUEUE, true, false, false);
    }

//    @EnableAuthorizationServer
//    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//        @Autowired
//        private AuthenticationManager authenticationManager;
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints.authenticationManager(authenticationManager);
//        }
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients)
//                throws Exception {
//            clients.inMemory()
//                    .withClient("acme")
//                    .secret("acmesecret")
//                    .authorizedGrantTypes("authorization_code","implicit",
//                            "refresh_token", "password").scopes("openid");
//
//        }
//    }



    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        jackson2JsonMessageConverter.setJsonObjectMapper(objectMapper);
        return jackson2JsonMessageConverter;
    }

    @Bean
    TopicExchange beheerTopicExchange() {
        return new TopicExchange(BEHEER_EXCHANGE, true, false);
    }

//    @Bean
//    TopicExchange businessUnitTopicExchange() {
//        return new TopicExchange(BUSINESSUNIT_EXCHANGE, true, false);
//    }

//    @Bean
//    Binding businessUnitBinding(Queue queue, TopicExchange businessUnitTopicExchange) {
//        return BindingBuilder.bind(queue).to(businessUnitTopicExchange).with(BUSINESSUNIT_ROUTING);
//    }
    @Bean
    Binding beheerBinding(Queue queue, TopicExchange beheerTopicExchange) {
        return BindingBuilder.bind(queue).to(beheerTopicExchange).with(BEHEER_ROUTING);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jackson2JsonMessageConverter, Receiver receiver) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(BEHEER_QUEUE);
        container.setMessageConverter(jackson2JsonMessageConverter);
        container.setMessageListener(receiver);
        return container;
    }

    @Bean
    Receiver receiver() {
        return new Receiver();
    }
}