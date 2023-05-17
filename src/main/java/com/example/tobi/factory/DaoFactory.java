package com.example.tobi.factory;

import com.example.tobi.dao.AccountDao;
import com.example.tobi.dao.MessageDao;
import com.example.tobi.dao.connection.ConnectionMaker;
import com.example.tobi.dao.connection.DConnectionMaker;
import com.example.tobi.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
