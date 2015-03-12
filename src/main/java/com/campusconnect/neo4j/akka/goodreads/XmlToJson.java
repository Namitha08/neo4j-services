package com.campusconnect.neo4j.akka.goodreads;

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
                "<![CDATA[ book_show ]]>\n" +
                "</method>\n" +
                "</Request>\n" +
                "<book>\n" +
                "<id>1768603</id>\n" +
                "<title>The White Tiger</title>\n" +
                "<isbn>\n" +
                "<![CDATA[ 1416562591 ]]>\n" +
                "</isbn>\n" +
                "<isbn13>\n" +
                "<![CDATA[ 9781416562597 ]]>\n" +
                "</isbn13>\n" +
                "<asin>\n" +
                "<![CDATA[ ]]>\n" +
                "</asin>\n" +
                "<image_url>\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "</image_url>\n" +
                "<small_image_url>\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "</small_image_url>\n" +
                "<publication_year>2008</publication_year>\n" +
                "<publication_month>4</publication_month>\n" +
                "<publication_day>22</publication_day>\n" +
                "<publisher>Free Press</publisher>\n" +
                "<language_code>eng</language_code>\n" +
                "<is_ebook>false</is_ebook>\n" +
                "<description>\n" +
                "<![CDATA[\n" +
                "The white tiger of this novel is Balram Halwai, a poor Indian villager whose great ambition leads him to the zenith of Indian business culture, the world of the Bangalore entrepreneur. On the occasion of the president of China’s impending trip to Bangalore, Balram writes a letter to him describing his transformation and his experience as driver and servant to a wealthy Indian family, which he thinks exemplifies the contradictions and complications of Indian society.<br><br>The White Tiger recalls The Death of Vishnu and Bangkok 8 in ambition, scope, and narrative genius, with a mischief and personality all its own. Amoral, irreverent, deeply endearing, and utterly contemporary, this novel is an international publishing sensation—and a startling, provocative debut.\n" +
                "]]>\n" +
                "</description>\n" +
                "<work>\n" +
                "<best_book_id type=\"integer\">1768603</best_book_id>\n" +
                "<books_count type=\"integer\">90</books_count>\n" +
                "<default_chaptering_book_id type=\"integer\" nil=\"true\"/>\n" +
                "<default_description_language_code nil=\"true\"/>\n" +
                "<desc_user_id type=\"integer\">3336310</desc_user_id>\n" +
                "<id type=\"integer\">1766737</id>\n" +
                "<media_type>book</media_type>\n" +
                "<original_language_id type=\"integer\" nil=\"true\"/>\n" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>\n" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>\n" +
                "<original_publication_year type=\"integer\">2008</original_publication_year>\n" +
                "<original_title>The White Tiger</original_title>\n" +
                "<rating_dist>5:19709|4:38782|3:26876|2:7754|1:2329|total:95450</rating_dist>\n" +
                "<ratings_count type=\"integer\">95450</ratings_count>\n" +
                "<ratings_sum type=\"integer\">352138</ratings_sum>\n" +
                "<reviews_count type=\"integer\">133389</reviews_count>\n" +
                "<text_reviews_count type=\"integer\">6829</text_reviews_count>\n" +
                "</work>\n" +
                "<average_rating>3.69</average_rating>\n" +
                "<num_pages>\n" +
                "<![CDATA[ 320 ]]>\n" +
                "</num_pages>\n" +
                "<format>\n" +
                "<![CDATA[ Hardcover ]]>\n" +
                "</format>\n" +
                "<edition_information>\n" +
                "<![CDATA[ ]]>\n" +
                "</edition_information>\n" +
                "<ratings_count>\n" +
                "<![CDATA[ 88459 ]]>\n" +
                "</ratings_count>\n" +
                "<text_reviews_count>\n" +
                "<![CDATA[ 5793 ]]>\n" +
                "</text_reviews_count>\n" +
                "<url>\n" +
                "<![CDATA[\n" +
                "https://www.goodreads.com/book/show/1768603.The_White_Tiger\n" +
                "]]>\n" +
                "</url>\n" +
                "<link>\n" +
                "<![CDATA[\n" +
                "https://www.goodreads.com/book/show/1768603.The_White_Tiger\n" +
                "]]>\n" +
                "</link>\n" +
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
                "<ratings_count>102925</ratings_count>\n" +
                "<text_reviews_count>7729</text_reviews_count>\n" +
                "</author>\n" +
                "</authors>\n" +
                "<reviews_widget>\n" +
                "<![CDATA[\n" +
                "<style> #goodreads-widget { font-family: georgia, serif; padding: 18px 0; width:565px; } #goodreads-widget h1 { font-weight:normal; font-size: 16px; border-bottom: 1px solid #BBB596; margin-bottom: 0; } #goodreads-widget a { text-decoration: none; color:#660; } iframe{ background-color: #fff; } #goodreads-widget a:hover { text-decoration: underline; } #goodreads-widget a:active { color:#660; } #gr_footer { width: 100%; border-top: 1px solid #BBB596; text-align: right; } #goodreads-widget .gr_branding{ color: #382110; font-size: 11px; text-decoration: none; font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif; } </style> <div id=\"goodreads-widget\"> <div id=\"gr_header\"><h1><a href=\"https://www.goodreads.com/book/show/1768603.The_White_Tiger\">The White Tiger Reviews</a></h1></div> <iframe id=\"the_iframe\" src=\"https://www.goodreads.com/api/reviews_widget_iframe?did=DEVELOPER_ID&amp;format=html&amp;isbn=1416562591&amp;links=660&amp;min_rating=&amp;review_back=fff&amp;stars=000&amp;text=000\" width=\"565\" height=\"400\" frameborder=\"0\"></iframe> <div id=\"gr_footer\"> <a href=\"https://www.goodreads.com/book/show/1768603.The_White_Tiger?utm_medium=api&amp;utm_source=reviews_widget\" class=\"gr_branding\" target=\"_blank\">Reviews from Goodreads.com</a> </div> </div>\n" +
                "]]>\n" +
                "</reviews_widget>\n" +
                "<popular_shelves>\n" +
                "<shelf name=\"to-read\" count=\"28712\"/>\n" +
                "<shelf name=\"currently-reading\" count=\"1666\"/>\n" +
                "<shelf name=\"fiction\" count=\"1588\"/>\n" +
                "<shelf name=\"india\" count=\"560\"/>\n" +
                "<shelf name=\"favorites\" count=\"385\"/>\n" +
                "<shelf name=\"book-club\" count=\"327\"/>\n" +
                "<shelf name=\"contemporary\" count=\"180\"/>\n" +
                "<shelf name=\"indian\" count=\"173\"/>\n" +
                "<shelf name=\"booker-prize\" count=\"149\"/>\n" +
                "<shelf name=\"novels\" count=\"137\"/>\n" +
                "</popular_shelves>\n" +
                "<book_links></book_links>\n" +
                "<series_works></series_works>\n" +
                "<similar_books>\n" +
                "<book>\n" +
                "<id>171833</id>\n" +
                "<title>Saville</title>\n" +
                "<isbn>0380018896</isbn>\n" +
                "<isbn13>9780380018895</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1374712336s/171833.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1374712336m/171833.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.32</average_rating>\n" +
                "<ratings_count>345</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>100219</id>\n" +
                "<name>David Storey</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>4449027</id>\n" +
                "<title>Something to Answer For</title>\n" +
                "<isbn>0571243258</isbn>\n" +
                "<isbn13>9780571243259</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.24</average_rating>\n" +
                "<ratings_count>222</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>1238024</id>\n" +
                "<name>P.H. Newby</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>2066739</id>\n" +
                "<title>Holiday</title>\n" +
                "<isbn>0907123430</isbn>\n" +
                "<isbn13>9780907123439</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1374712300s/2066739.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1374712300m/2066739.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.30</average_rating>\n" +
                "<ratings_count>277</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>59002</id>\n" +
                "<name>Stanley Middleton</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>256280</id>\n" +
                "<title>\n" +
                "<![CDATA[ The Siege of Krishnapur (Empire Trilogy, #2) ]]>\n" +
                "</title>\n" +
                "<isbn>159017092X</isbn>\n" +
                "<isbn13>9781590170922</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.90</average_rating>\n" +
                "<ratings_count>2946</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>1417512</id>\n" +
                "<name>J.G. Farrell</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>1565490</id>\n" +
                "<title>The Elected Member</title>\n" +
                "<isbn>0349130221</isbn>\n" +
                "<isbn13>9780349130224</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1421010229s/1565490.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1421010229m/1565490.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.60</average_rating>\n" +
                "<ratings_count>559</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>430857</id>\n" +
                "<name>Bernice Rubens</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>299813</id>\n" +
                "<title>G.</title>\n" +
                "<isbn>0679736549</isbn>\n" +
                "<isbn13>9780679736547</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.51</average_rating>\n" +
                "<ratings_count>1174</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>29919</id>\n" +
                "<name>John Berger</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>239592</id>\n" +
                "<title>Sacred Hunger</title>\n" +
                "<isbn>0393311147</isbn>\n" +
                "<isbn13>9780393311143</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>4.12</average_rating>\n" +
                "<ratings_count>3624</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>3101</id>\n" +
                "<name>Barry Unsworth</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>1523438</id>\n" +
                "<title>Animal's People</title>\n" +
                "<isbn>0743259203</isbn>\n" +
                "<isbn13>9780743259200</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.83</average_rating>\n" +
                "<ratings_count>2078</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>365388</id>\n" +
                "<name>Indra Sinha</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>49742</id>\n" +
                "<title>In a Free State</title>\n" +
                "<isbn>1400030552</isbn>\n" +
                "<isbn13>9781400030552</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1328700259s/49742.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1328700259m/49742.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.50</average_rating>\n" +
                "<ratings_count>1886</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>3989</id>\n" +
                "<name>V.S. Naipaul</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>414824</id>\n" +
                "<title>Staying On</title>\n" +
                "<isbn>0099443198</isbn>\n" +
                "<isbn13>9780099443193</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.92</average_rating>\n" +
                "<ratings_count>2049</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>3119</id>\n" +
                "<name>Paul Scott</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>14431</id>\n" +
                "<title>\n" +
                "<![CDATA[ Rites of Passage (To the Ends of the Earth, #1) ]]>\n" +
                "</title>\n" +
                "<isbn>0571209432</isbn>\n" +
                "<isbn13>9780571209439</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1375876979s/14431.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1375876979m/14431.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.62</average_rating>\n" +
                "<ratings_count>1760</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>306</id>\n" +
                "<name>William Golding</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>3853</id>\n" +
                "<title>Heat and Dust</title>\n" +
                "<isbn>1582430152</isbn>\n" +
                "<isbn13>9781582430157</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.54</average_rating>\n" +
                "<ratings_count>4380</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>2616</id>\n" +
                "<name>Ruth Prawer Jhabvala</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>366427</id>\n" +
                "<title>The Old Devils</title>\n" +
                "<isbn>0099461056</isbn>\n" +
                "<isbn13>9780099461050</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1320448230s/366427.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1320448230m/366427.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.35</average_rating>\n" +
                "<ratings_count>1512</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>13078</id>\n" +
                "<name>Kingsley Amis</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>108615</id>\n" +
                "<title>Offshore</title>\n" +
                "<isbn>0006542565</isbn>\n" +
                "<isbn13>9780006542568</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.65</average_rating>\n" +
                "<ratings_count>1587</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>3222</id>\n" +
                "<name>Penelope Fitzgerald</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>96337</id>\n" +
                "<title>The Conservationist</title>\n" +
                "<isbn>0140047166</isbn>\n" +
                "<isbn13>9780140047165</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.43</average_rating>\n" +
                "<ratings_count>1243</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>55397</id>\n" +
                "<name>Nadine Gordimer</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>130028</id>\n" +
                "<title>Moon Tiger</title>\n" +
                "<isbn>0802135331</isbn>\n" +
                "<isbn13>9780802135339</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.86</average_rating>\n" +
                "<ratings_count>4735</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>9738</id>\n" +
                "<name>Penelope Lively</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>95186</id>\n" +
                "<title>The Inheritance of Loss</title>\n" +
                "<isbn>0802142818</isbn>\n" +
                "<isbn13>9780802142818</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1327909065s/95186.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1327909065m/95186.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.39</average_rating>\n" +
                "<ratings_count>31128</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>31428</id>\n" +
                "<name>Kiran Desai</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "<book>\n" +
                "<id>1330324</id>\n" +
                "<title>\n" +
                "<![CDATA[ Sea of Poppies (Ibis Trilogy, #1) ]]>\n" +
                "</title>\n" +
                "<isbn>071956896X</isbn>\n" +
                "<isbn13>9780719568961</isbn13>\n" +
                "<small_image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1327376395s/1330324.jpg\n" +
                "]]>\n" +
                "</small_image_url>\n" +
                "<image_url>\n" +
                "<![CDATA[\n" +
                "https://d.gr-assets.com/books/1327376395m/1330324.jpg\n" +
                "]]>\n" +
                "</image_url>\n" +
                "<average_rating>3.91</average_rating>\n" +
                "<ratings_count>10725</ratings_count>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>3369</id>\n" +
                "<name>Amitav Ghosh</name>\n" +
                "</author>\n" +
                "</authors>\n" +
                "</book>\n" +
                "</similar_books>\n" +
                "</book>\n" +
                "</GoodreadsResponse>";


                XMLSerializer xmlSerializer = new XMLSerializer();
                JSON json = xmlSerializer.read( data.replaceAll(".*nil=\"true\".*", "") );
                System.out.println( json.toString(2) );


    }
}
