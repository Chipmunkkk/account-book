//package xin.shaozb.accountbook.auth.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
//
///**
// * Description: 配置Oauth2
// * Date: 2019/9/20 23:38
// *
// * @author 1033780702@qq.com
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    public AuthorizationServerConfig() {
//        super();
//    }
//
//    /**
//     * 用来配置令牌端点(Token Endpoint)的安全约束
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                // 开启/oauth/token_key验证端口无权限访问
//                .tokenKeyAccess("permitAll()")
//                // 开启/oauth/check_token验证端口认证权限访问
//                .checkTokenAccess("isAuthenticated()");
//    }
//
//    /**
//     * 用来配置客户端详情服务(ClientDetailsService)
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        super.configure(clients);
//    }
//
//    /**
//     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager)
//                .accessTokenConverter(jwtAccessTokenConverter())
//                .reuseRefreshTokens(false)
//                .userDetailsService();
//    }
//
//    /**
//     * 使用非对称加密算法来对Token进行签名
//     *
//     * @return
//     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//
//        final JwtAccessTokenConverter converter = new JwtAccessToken();
//        // 导入证书
//        KeyStoreKeyFactory keyStoreKeyFactory =
//                new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "mypass".toCharArray());
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
//
//        return converter;
//    }
//}
