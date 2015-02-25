package com.campusconnect.neo4j.tests.unit;

import com.campusconnect.neo4j.da.UserDao;
import com.campusconnect.neo4j.tests.TestBase;
import com.campusconnect.neo4j.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

import static com.campusconnect.neo4j.tests.functional.base.DataBrewer.*;

/**
 * Created by sn1 on 1/18/15.
 */
public class UserTest extends TestBase {


    @Autowired
    private UserDao userDao;

    User createdUser;

    @Test
    public void createTest(){
        createdUser = userDao.createUser(getFakeUser());
    }

    @Test(dependsOnMethods = "createTest")
    public void getUser(){
        User resultUser = userDao.getUser(createdUser.getId());
        System.err.println(resultUser);
    }

    @Test(dependsOnMethods = "getUser")
    public void updateUser(){
        User resultUser = userDao.getUser(createdUser.getId());

        System.out.println(resultUser);
        resultUser.setName("abc");
        userDao.updateUser(resultUser);

        User updatedUser = userDao.getUser(createdUser.getId());
        updatedUser.getName();
    }
    
    @Test
    public void createUserWithAddress() {
        createdUser = userDao.createUser(getFakeUserWithAddress());
        User resultUser = userDao.getUser(createdUser.getId());
        System.err.println(resultUser);
    }

    @Test
    public void addFollowerToFixedIdUser(){
        User fixedIdUser = userDao.getUser("8318f66b-c836-4c89-888b-97dc72927e78");
        User secondUser = userDao.createUser(getFakeUser());
        userDao.createFollowingRelation(fixedIdUser, secondUser);
    }

    @Test
    public void addFollowingToFixedIdUser(){
        User fixedIdUser = userDao.getUser("8318f66b-c836-4c89-888b-97dc72927e78");
        User secondUser = userDao.createUser(getFakeUser());
        userDao.createFollowingRelation(secondUser, fixedIdUser);
    }

    @Test(dependsOnMethods = "getUser")
    public void addFollower(){
        User secondUser = userDao.createUser(getFakeUser());
        userDao.createFollowingRelation(createdUser, secondUser);
    }

    @Test(dependsOnMethods = "getUser")
    public void addFollowing(){
        User secondUser = userDao.createUser(getFakeUser());
        userDao.createFollowingRelation(secondUser, createdUser);
    }

    @Test
    public void getFollowers(){
        User fixedIdUser = userDao.getUser("8318f66b-c836-4c89-888b-97dc72927e78");
        List<User> users = userDao.getFollowers(fixedIdUser);
        System.out.println(users);
    }

    @Test
    public void getFollowing(){
        User fixedIdUser = userDao.getUser("8318f66b-c836-4c89-888b-97dc72927e78");
        List<User> users = userDao.getFollowers(fixedIdUser);
        System.out.println(users);
    }
}
