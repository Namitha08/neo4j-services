package com.campusconnect.neo4j.akka.goodreads;

import com.campusconnect.neo4j.util.StringUtils;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

/**
 * Created by sn1 on 3/8/15.
 */
public class XmlToJson {
    public static void main(String[] args) {
        String data = "<GoodreadsResponse>\n" +
                "<Request>\n" +
                "<authentication>true</authentication>\n" +
                "<key>\n" +
                "<![CDATA[ QLM3lL2nqXe4LujHQt12A ]]>\n" +
                "</key>\n" +
                "<method>\n" +
                "<![CDATA[ review_list ]]>\n" +
                "</method>\n" +
                "</Request>\n" +
                "<reviews start=\"1\" end=\"5\" total=\"36\">\n" +
                "<review>\n" +
                "<id>1225244316</id>\n" +
                "<book>\n" +
                "<id type=\"integer\">11554729</id>\n" +
                "<isbn nil=\"true\"/>\n" +
                "<isbn13 nil=\"true\"/>\n" +
                "<text_reviews_count type=\"integer\">8</text_reviews_count>\n" +
                "<title>ಕಾನೂರು ಹೆಗ್ಗಡಿತಿ</title>\n" +
                "<image_url>\n" +
                "https://d.gr-assets.com/books/1307368184m/11554729.jpg\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "https://d.gr-assets.com/books/1307368184s/11554729.jpg\n" +
                "</small_image_url>\n" +
                "<large_image_url/>\n" +
                "<link>https://www.goodreads.com/book/show/11554729</link>\n" +
                "<num_pages/>\n" +
                "<format/>\n" +
                "<edition_information/>\n" +
                "<publisher/>\n" +
                "<publication_day/>\n" +
                "<publication_year/>\n" +
                "<publication_month/>\n" +
                "<average_rating>4.32</average_rating>\n" +
                "<ratings_count>196</ratings_count>\n" +
                "<description/>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>11251574</id>\n" +
                "<name>ಕುವೆಂಪು</name>\n" +
                "<role/>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/user/u_200x266-e183445fd1a1b5cc7075bb1cf7043306.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/user/u_50x66-632230dc9882b4352d753eedf9396530.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<link>\n" +
                "<![CDATA[ https://www.goodreads.com/author/show/11251574._ ]]>\n" +
                "</link>\n" +
                "<average_rating>4.29</average_rating>\n" +
                "<ratings_count>607</ratings_count>\n" +
                "<text_reviews_count>39</text_reviews_count>\n" +
                "</author>\n" +
                "</authors>\n" +
                "<published/>\n" +
                "</book>\n" +
                "<rating>0</rating>\n" +
                "<votes>0</votes>\n" +
                "<spoiler_flag>false</spoiler_flag>\n" +
                "<spoilers_state>none</spoilers_state>\n" +
                "<shelves>\n" +
                "<shelf name=\"read\" exclusive=\"true\"/>\n" +
                "</shelves>\n" +
                "<recommended_for/>\n" +
                "<recommended_by/>\n" +
                "<started_at/>\n" +
                "<read_at/>\n" +
                "<date_added>Wed Mar 11 23:45:12 -0700 2015</date_added>\n" +
                "<date_updated>Wed Mar 11 23:45:19 -0700 2015</date_updated>\n" +
                "<read_count/>\n" +
                "<body></body>\n" +
                "<comments_count>0</comments_count>\n" +
                "<url>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1225244316 ]]>\n" +
                "</url>\n" +
                "<link>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1225244316 ]]>\n" +
                "</link>\n" +
                "<owned>0</owned>\n" +
                "</review>\n" +
                "<review>\n" +
                "<id>1197407186</id>\n" +
                "<book>\n" +
                "<id type=\"integer\">19288043</id>\n" +
                "<isbn>0307588378</isbn>\n" +
                "<isbn13>9780307588371</isbn13>\n" +
                "<text_reviews_count type=\"integer\">12708</text_reviews_count>\n" +
                "<title>Gone Girl</title>\n" +
                "<image_url>\n" +
                "https://d.gr-assets.com/books/1397056917m/19288043.jpg\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "https://d.gr-assets.com/books/1397056917s/19288043.jpg\n" +
                "</small_image_url>\n" +
                "<large_image_url/>\n" +
                "<link>\n" +
                "https://www.goodreads.com/book/show/19288043-gone-girl\n" +
                "</link>\n" +
                "<num_pages>422</num_pages>\n" +
                "<format>Paperback</format>\n" +
                "<edition_information/>\n" +
                "<publisher>Broadway Books</publisher>\n" +
                "<publication_day>22</publication_day>\n" +
                "<publication_year>2014</publication_year>\n" +
                "<publication_month>4</publication_month>\n" +
                "<average_rating>3.97</average_rating>\n" +
                "<ratings_count>908709</ratings_count>\n" +
                "<description>\n" +
                "On a warm summer morning in North Carthage, Missouri, it is Nick and Amy Dunne’s fifth wedding anniversary. Presents are being wrapped and reservations are being made when Nick’s clever and beautiful wife disappears. Husband-of-the-Year Nick isn’t doing himself any favors with cringe-worthy daydreams about the slope and shape of his wife’s head, but passages from Amy's diary reveal the alpha-girl perfectionist could have put anyone dangerously on edge<strong>.</strong> Under mounting pressure from the police and the media—as well as Amy’s fiercely doting parents—the town golden boy parades an endless series of lies, deceits, and inappropriate behavior. Nick is oddly evasive, and he’s definitely bitter—but is he really a killer?\n" +
                "</description>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>2383</id>\n" +
                "<name>Gillian Flynn</name>\n" +
                "<role/>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1232123231p5/2383.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1232123231p2/2383.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<link>\n" +
                "<![CDATA[\n" +
                "https://www.goodreads.com/author/show/2383.Gillian_Flynn\n" +
                "]]>\n" +
                "</link>\n" +
                "<average_rating>3.95</average_rating>\n" +
                "<ratings_count>1257375</ratings_count>\n" +
                "<text_reviews_count>138721</text_reviews_count>\n" +
                "</author>\n" +
                "</authors>\n" +
                "<published>2014</published>\n" +
                "</book>\n" +
                "<rating>0</rating>\n" +
                "<votes>0</votes>\n" +
                "<spoiler_flag>false</spoiler_flag>\n" +
                "<spoilers_state>none</spoilers_state>\n" +
                "<shelves>\n" +
                "<shelf name=\"currently-reading\" exclusive=\"true\" review_shelf_id=\"909744230\" sortable=\"false\"/>\n" +
                "</shelves>\n" +
                "<recommended_for/>\n" +
                "<recommended_by/>\n" +
                "<started_at>Wed Feb 11 00:38:42 -0800 2015</started_at>\n" +
                "<read_at/>\n" +
                "<date_added>Wed Feb 11 00:38:42 -0800 2015</date_added>\n" +
                "<date_updated>Wed Feb 11 00:38:42 -0800 2015</date_updated>\n" +
                "<read_count/>\n" +
                "<body></body>\n" +
                "<comments_count>0</comments_count>\n" +
                "<url>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1197407186 ]]>\n" +
                "</url>\n" +
                "<link>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1197407186 ]]>\n" +
                "</link>\n" +
                "<owned>0</owned>\n" +
                "</review>\n" +
                "<review>\n" +
                "<id>1175503896</id>\n" +
                "<book>\n" +
                "<id type=\"integer\">1768603</id>\n" +
                "<isbn>1416562591</isbn>\n" +
                "<isbn13>9781416562597</isbn13>\n" +
                "<text_reviews_count type=\"integer\">5799</text_reviews_count>\n" +
                "<title>The White Tiger</title>\n" +
                "<image_url>\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "</small_image_url>\n" +
                "<large_image_url/>\n" +
                "<link>\n" +
                "https://www.goodreads.com/book/show/1768603.The_White_Tiger\n" +
                "</link>\n" +
                "<num_pages>320</num_pages>\n" +
                "<format>Hardcover</format>\n" +
                "<edition_information/>\n" +
                "<publisher>Free Press</publisher>\n" +
                "<publication_day>22</publication_day>\n" +
                "<publication_year>2008</publication_year>\n" +
                "<publication_month>4</publication_month>\n" +
                "<average_rating>3.69</average_rating>\n" +
                "<ratings_count>95535</ratings_count>\n" +
                "<description>\n" +
                "The white tiger of this novel is Balram Halwai, a poor Indian villager whose great ambition leads him to the zenith of Indian business culture, the world of the Bangalore entrepreneur. On the occasion of the president of China’s impending trip to Bangalore, Balram writes a letter to him describing his transformation and his experience as driver and servant to a wealthy Indian family, which he thinks exemplifies the contradictions and complications of Indian society.<br><br>The White Tiger recalls The Death of Vishnu and Bangkok 8 in ambition, scope, and narrative genius, with a mischief and personality all its own. Amoral, irreverent, deeply endearing, and utterly contemporary, this novel is an international publishing sensation—and a startling, provocative debut.\n" +
                "</description>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>810254</id>\n" +
                "<name>Aravind Adiga</name>\n" +
                "<role/>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1315250024p5/810254.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1315250024p2/810254.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<link>\n" +
                "<![CDATA[\n" +
                "https://www.goodreads.com/author/show/810254.Aravind_Adiga\n" +
                "]]>\n" +
                "</link>\n" +
                "<average_rating>3.67</average_rating>\n" +
                "<ratings_count>103016</ratings_count>\n" +
                "<text_reviews_count>7736</text_reviews_count>\n" +
                "</author>\n" +
                "</authors>\n" +
                "<published>2008</published>\n" +
                "</book>\n" +
                "<rating>4</rating>\n" +
                "<votes>0</votes>\n" +
                "<spoiler_flag>false</spoiler_flag>\n" +
                "<spoilers_state>none</spoilers_state>\n" +
                "<shelves>\n" +
                "<shelf name=\"read\" exclusive=\"true\"/>\n" +
                "</shelves>\n" +
                "<recommended_for/>\n" +
                "<recommended_by/>\n" +
                "<started_at>Wed Jan 21 02:01:55 -0800 2015</started_at>\n" +
                "<read_at>Sun Jan 25 10:28:26 -0800 2015</read_at>\n" +
                "<date_added>Wed Jan 21 02:01:55 -0800 2015</date_added>\n" +
                "<date_updated>Sun Jan 25 10:28:26 -0800 2015</date_updated>\n" +
                "<read_count/>\n" +
                "<body></body>\n" +
                "<comments_count>0</comments_count>\n" +
                "<url>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1175503896 ]]>\n" +
                "</url>\n" +
                "<link>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1175503896 ]]>\n" +
                "</link>\n" +
                "<owned>0</owned>\n" +
                "</review>\n" +
                "<review>\n" +
                "<id>1175503814</id>\n" +
                "<book>\n" +
                "<id type=\"integer\">10854908</id>\n" +
                "<isbn>1848875169</isbn>\n" +
                "<isbn13>9781848875166</isbn13>\n" +
                "<text_reviews_count type=\"integer\">406</text_reviews_count>\n" +
                "<title>Last Man in Tower</title>\n" +
                "<image_url>\n" +
                "https://d.gr-assets.com/books/1328165348m/10854908.jpg\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "https://d.gr-assets.com/books/1328165348s/10854908.jpg\n" +
                "</small_image_url>\n" +
                "<large_image_url/>\n" +
                "<link>\n" +
                "https://www.goodreads.com/book/show/10854908-last-man-in-tower\n" +
                "</link>\n" +
                "<num_pages>422</num_pages>\n" +
                "<format>Hardcover</format>\n" +
                "<edition_information/>\n" +
                "<publisher>Atlantic Books</publisher>\n" +
                "<publication_day/>\n" +
                "<publication_year>2011</publication_year>\n" +
                "<publication_month>9</publication_month>\n" +
                "<average_rating>3.48</average_rating>\n" +
                "<ratings_count>3986</ratings_count>\n" +
                "<description>\n" +
                "A tale of one man refusing to leave his home in the face of property development. Tower A is a relic from a co-operative housing society established in the 1950s. When a property developer offers to buy out the residents for eye-watering sums, the principled yet arrogant teacher is the only one to refuse the offer, determined not to surrender his sentimental attachment to his home and his right to live in it, in the name of greed. His neighbours gradually relinquish any similar qualms they might have and, in a typically blunt satirical premise take matters into their own hands, determined to seize their slice of the new Mumbai as it transforms from stinky slum to silvery skyscrapers at dizzying, almost gravity-defying speed.\n" +
                "</description>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>810254</id>\n" +
                "<name>Aravind Adiga</name>\n" +
                "<role/>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1315250024p5/810254.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1315250024p2/810254.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<link>\n" +
                "<![CDATA[\n" +
                "https://www.goodreads.com/author/show/810254.Aravind_Adiga\n" +
                "]]>\n" +
                "</link>\n" +
                "<average_rating>3.67</average_rating>\n" +
                "<ratings_count>103016</ratings_count>\n" +
                "<text_reviews_count>7736</text_reviews_count>\n" +
                "</author>\n" +
                "</authors>\n" +
                "<published>2011</published>\n" +
                "</book>\n" +
                "<rating>0</rating>\n" +
                "<votes>0</votes>\n" +
                "<spoiler_flag>false</spoiler_flag>\n" +
                "<spoilers_state>none</spoilers_state>\n" +
                "<shelves>\n" +
                "<shelf name=\"to-read\" exclusive=\"true\" review_shelf_id=\"890774579\" sortable=\"true\"/>\n" +
                "</shelves>\n" +
                "<recommended_for/>\n" +
                "<recommended_by/>\n" +
                "<started_at/>\n" +
                "<read_at/>\n" +
                "<date_added>Wed Jan 21 02:01:39 -0800 2015</date_added>\n" +
                "<date_updated>Wed Jan 21 02:01:40 -0800 2015</date_updated>\n" +
                "<read_count/>\n" +
                "<body></body>\n" +
                "<comments_count>0</comments_count>\n" +
                "<url>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1175503814 ]]>\n" +
                "</url>\n" +
                "<link>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/1175503814 ]]>\n" +
                "</link>\n" +
                "<owned>0</owned>\n" +
                "</review>\n" +
                "<review>\n" +
                "<id>983784578</id>\n" +
                "<book>\n" +
                "<id type=\"integer\">6442769</id>\n" +
                "<isbn>014241493X</isbn>\n" +
                "<isbn13>9780142414934</isbn13>\n" +
                "<text_reviews_count type=\"integer\">10329</text_reviews_count>\n" +
                "<title>Paper Towns</title>\n" +
                "<image_url>\n" +
                "https://d.gr-assets.com/books/1349013610m/6442769.jpg\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "https://d.gr-assets.com/books/1349013610s/6442769.jpg\n" +
                "</small_image_url>\n" +
                "<large_image_url/>\n" +
                "<link>\n" +
                "https://www.goodreads.com/book/show/6442769-paper-towns\n" +
                "</link>\n" +
                "<num_pages>305</num_pages>\n" +
                "<format>Paperback</format>\n" +
                "<edition_information/>\n" +
                "<publisher>Speak</publisher>\n" +
                "<publication_day>22</publication_day>\n" +
                "<publication_year>2009</publication_year>\n" +
                "<publication_month>9</publication_month>\n" +
                "<average_rating>4.03</average_rating>\n" +
                "<ratings_count>334860</ratings_count>\n" +
                "<description>\n" +
                "<strong>Who is the real Margo?</strong><br><br>Quentin Jacobsen has spent a lifetime loving the magnificently adventurous Margo Roth Spiegelman from afar. So when she cracks open a window and climbs into his life—dressed like a ninja and summoning him for an ingenious campaign of revenge—he follows. After their all-nighter ends, and a new day breaks, Q arrives at school to discover that Margo, always an enigma, has now become a mystery. But Q soon learns that there are clues—and they're for him. Urged down a disconnected path, the closer he gets, the less Q sees the girl he thought he knew...\n" +
                "</description>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>1406384</id>\n" +
                "<name>John Green</name>\n" +
                "<role/>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1353452301p5/1406384.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/authors/1353452301p2/1406384.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<link>\n" +
                "<![CDATA[\n" +
                "https://www.goodreads.com/author/show/1406384.John_Green\n" +
                "]]>\n" +
                "</link>\n" +
                "<average_rating>4.21</average_rating>\n" +
                "<ratings_count>2664434</ratings_count>\n" +
                "<text_reviews_count>208916</text_reviews_count>\n" +
                "</author>\n" +
                "</authors>\n" +
                "<published>2009</published>\n" +
                "</book>\n" +
                "<rating>0</rating>\n" +
                "<votes>0</votes>\n" +
                "<spoiler_flag>false</spoiler_flag>\n" +
                "<spoilers_state>none</spoilers_state>\n" +
                "<shelves>\n" +
                "<shelf name=\"to-read\" exclusive=\"true\" review_shelf_id=\"730010907\" sortable=\"true\"/>\n" +
                "</shelves>\n" +
                "<recommended_for/>\n" +
                "<recommended_by/>\n" +
                "<started_at/>\n" +
                "<read_at/>\n" +
                "<date_added>Tue Jul 01 23:47:04 -0700 2014</date_added>\n" +
                "<date_updated>Tue Jul 01 23:47:04 -0700 2014</date_updated>\n" +
                "<read_count/>\n" +
                "<body></body>\n" +
                "<comments_count>0</comments_count>\n" +
                "<url>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/983784578 ]]>\n" +
                "</url>\n" +
                "<link>\n" +
                "<![CDATA[ https://www.goodreads.com/review/show/983784578 ]]>\n" +
                "</link>\n" +
                "<owned>0</owned>\n" +
                "</review>\n" +
                "</reviews>\n" +
                "</GoodreadsResponse>";


                XMLSerializer xmlSerializer = new XMLSerializer();
                JSON json = xmlSerializer.read(StringUtils.cleanEmptyTags(data));
                System.out.println( json.toString(2) );


    }
}
