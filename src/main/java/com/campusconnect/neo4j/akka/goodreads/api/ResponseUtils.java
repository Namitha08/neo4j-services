package com.campusconnect.neo4j.akka.goodreads.api;

import com.campusconnect.neo4j.akka.goodreads.types.GetBookResponse;
import com.campusconnect.neo4j.util.StringUtils;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by sn1 on 3/10/15.
 */
public class ResponseUtils {
    public static <T> T getEntity(String xmlData, Class<T> clazz) throws IOException {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(StringUtils.cleanEmptyTags(xmlData));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T response = objectMapper.readValue(json.toString(), clazz);
        return response;
    }
}
