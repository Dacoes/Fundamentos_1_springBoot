package com.springboot.fundamentos.Service;

import com.springboot.fundamentos.Repository.UserRepository;
import com.springboot.fundamentos.entity.User;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepository userRepository;


    @Transactional //si ocurre un error no se registran en la BD
    public void saveTransactional(List<User> users){
        users.stream().
                peek(user -> LOG.info("Usuario insertado "+user)).
                forEach(userRepository::save);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }



}
