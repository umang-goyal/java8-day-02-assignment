package com.knoldus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;


public class UserUtilities {
    List<User> userList = new ArrayList<>();

    Boolean ifExists(int userId){
        return true;
    }


    List<User> create(User user){
        if(ifExists(user.id) == true ){
            //throw exception
        }
            userList.add(user);
            return userList;

    }

    User userOfId(int id){
        if(ifExists(id)){
            //throw exception
        }
            return userList.stream()
                    .filter(user -> user.id == id).collect(Collectors.toList()).get(0);

        //return user;
    }

    List<User> delete(int id){
        if(ifExists(id)){
            //throws exception
        }
            userList.remove(userOfId(id));
            return userList;
    }



    List<User> update(User user){
        if(ifExists(user.id) == false){
            //throw exception
        }
            delete(user.id);
            userList.add(user);
            return userList;
    }

}

