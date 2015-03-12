package com.campusconnect.neo4j.akka.goodreads.worker;

import akka.actor.UntypedActor;
import com.campusconnect.neo4j.akka.goodreads.client.GoodreadsOauthClient;
import com.campusconnect.neo4j.akka.goodreads.task.GetBooksTask;
import com.sun.jersey.api.uri.UriBuilderImpl;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.UriBuilder;

/**
 * Created by sn1 on 3/12/15.
 */
public class GetBooksWorker extends UntypedActor {
    
    @Autowired
    private GoodreadsOauthClient goodreadsOauthClient;
    
    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof GetBooksTask) {
            GetBooksTask getBooksTask = (GetBooksTask) message;
            UriBuilder uriBuilder = new UriBuilderImpl();
            uriBuilder.path("https://www.goodreads.com");
            uriBuilder.path("review/list.xml");
            uriBuilder.queryParam("v", "2");
            uriBuilder.queryParam("id", getBooksTask.getUserId());
            uriBuilder.queryParam("key", goodreadsOauthClient.getsApiKey());
            uriBuilder.queryParam("page", getBooksTask.getPage());
            Token sAccessToken = new Token(getBooksTask.getAccessToken(), getBooksTask.getAccessTokenSecret());
            OAuthRequest getBooksRequest = new OAuthRequest(Verb.GET, uriBuilder.build().toString());
            goodreadsOauthClient.getsService().signRequest(sAccessToken, getBooksRequest);
            Response response = getBooksRequest.send();

            System.out.println(response);
        }
    }
}
