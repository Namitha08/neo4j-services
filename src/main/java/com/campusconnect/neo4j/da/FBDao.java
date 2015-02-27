package com.campusconnect.neo4j.da;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;

/**
 * Created by sn1 on 2/27/15.
 */
public class FBDao {
    
    public void setFacebookConnectionFactory(FacebookConnectionFactory facebookConnectionFactory) {
        this.facebookConnectionFactory = facebookConnectionFactory;
    }

    FacebookConnectionFactory facebookConnectionFactory;
    public FBDao(FacebookConnectionFactory facebookConnectionFactory) {
        this.facebookConnectionFactory = facebookConnectionFactory;
    }    
    
    public void getFriendsOfUser(String accessToken){
        Connection<Facebook> facebook = facebookConnectionFactory.createConnection(new AccessGrant(accessToken));
        final PagedList<Reference> friends = facebook.getApi().friendOperations().getFriends();
        for (Reference reference : friends){

        }
    }

    public FBDao() {
    }

    public static void main(String[] args) {
      FBDao fbDao = new FBDao();
        fbDao.setFacebookConnectionFactory(new FacebookConnectionFactory("136567019835635", "925042e37ac32f1591cc9e18cda99297"));
        fbDao.getFriendsOfUser("CAACEdEose0cBABANF4bglnMTeNNnPlPd0ne3ZBCaQnfkxbYTrd7dkab69wl8GzQeO02UhREqAm5UZBSWiZBC1irCUDtGu79pRfZBn1XZBHYFW7sW2yF42ZAzOuabWKGsZAx2UIcEZA4DWZBir6LqEJTcZBwtgd5Od4r3k1CFYp13fbkIJnyYLsSqiwSrvWZCsIZC4WMZCjY8jIDZCiHC9YdEZA9Gp1KmJma7WVUJErty5I8gWEmkAZDZD");
    }

    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory("136567019835635", "925042e37ac32f1591cc9e18cda99297"));
        return registry;
    }
}
