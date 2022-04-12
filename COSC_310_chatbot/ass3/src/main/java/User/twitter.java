package User;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;



public class twitter {

    // To set your environment variables in your terminal run the following line:
    // export 'BEARER_TOKEN'='<your_bearer_token>'
    public static void main(String[] args) throws IOException, URISyntaxException {

        final String bearerToken = "AAAAAAAAAAAAAAAAAAAAADhCbQEAAAAAtXvr4HdOoCEKjZh%2FUWxngV1cEiY%3DLvGz6FsT35gxmSk53fdLiQhpKoAOGOlJGeEoDmEM1CgveSOCYu";
        if (null != bearerToken) {
            // Replace with user ID below
            String response = getTweets("403614288");
            System.out.println(response);
        } else {
            System.out.println("There was a problem getting your bearer token. Please make sure you set the BEARER_TOKEN environment variable");
        }
    }

    /*
     * This method calls the v2 User Tweet timeline endpoint by user ID
     * */
    public static String getTweets(String userId) throws IOException, URISyntaxException {
        String bearerToken="AAAAAAAAAAAAAAAAAAAAADhCbQEAAAAAtXvr4HdOoCEKjZh%2FUWxngV1cEiY%3DLvGz6FsT35gxmSk53fdLiQhpKoAOGOlJGeEoDmEM1CgveSOCYu";
        String tweetResponse = null;

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();

        URIBuilder uriBuilder = new URIBuilder(String.format("https://api.twitter.com/2/users/%s/tweets", userId));
        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("tweet.fields", "created_at"));
        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            tweetResponse = EntityUtils.toString(entity, "UTF-8");
        }
        System.out.println(tweetResponse);
        String splitres = tweetResponse;
        String[] split1 = splitres.split("data |text");


        String out="here are some tweets from linus tech tips";
        for (int i = 0; i< split1.length; i++) {
            split1[i] = split1[i].replaceFirst("\":\"", "");
            split1[i] = split1[i].replace("\\n", " ");
            split1[i] = (split1[i].substring(0, split1[i].length() -72));
        }
        split1[0]=" ";
        split1[split1.length-1]="";
        split1[split1.length-2]="";
        for (String s : split1){
           out=out+"\n"+s;
        }


        return out;
    }

}