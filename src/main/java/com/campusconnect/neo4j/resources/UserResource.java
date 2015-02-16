package com.campusconnect.neo4j.resources;

import com.campusconnect.neo4j.da.CollegeDao;
import com.campusconnect.neo4j.da.UserDao;
import com.campusconnect.neo4j.types.College;
import com.campusconnect.neo4j.types.User;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sn1 on 1/22/15.
 */
public class UserResource {

    private UserDao userDao;
    private CollegeDao collegeDao;

    public UserResource() {
        
    }

    public UserResource(UserDao userDao, CollegeDao collegeDao) {
        this.userDao = userDao;
        this.collegeDao = collegeDao;
    }

    public void addCollegeAccess(String userId, String groupId, String role) {

    }

    public void approveCollegeAccess(String userId, String collegeId, String createdBy, String role){
        User user = userDao.getUser(userId);
        College college = collegeDao.getCollege(collegeId);
        userDao.addCollege(college, user, getRequiredHeadersForAccess(createdBy, role));
    }

    private Map<String, Object> getRequiredHeadersForAccess(String createdBy, String role) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("createdBy", createdBy);
        properties.put("createdDate", new DateTime(System.currentTimeMillis()));
        properties.put("role", role);
        return properties;
    }


}
