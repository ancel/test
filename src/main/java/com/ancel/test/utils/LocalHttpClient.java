package com.ancel.test.utils;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
 
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * httpclient 请求文件
 * @author Administrator
 *
 */
public class LocalHttpClient {
 
    public static String getHttpResponseByPost(String url, String charset,
            List<NameValuePair> params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String reponseStr = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, charset));
 
            // 开始请求
            System.out.println("executing request " + httpPost.getURI());
            response = httpclient.execute(httpPost);
            // 检查是否已搬搬迁
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY
                    || statusCode == HttpStatus.SC_MOVED_PERMANENTLY
                    || statusCode == HttpStatus.SC_SEE_OTHER
                    || statusCode == HttpStatus.SC_TEMPORARY_REDIRECT) {
 
                Header[] headers = response.getHeaders("location");
 
                if (headers != null) {
                    httpPost.releaseConnection();
                    String newUrl = headers[0].getValue();
                    httpPost.setURI(URI.create(newUrl));
 
                    response = httpclient.execute(httpPost);
                }
            }
            reponseStr = printResponse(response);
            System.out.println(reponseStr);
 
            try {
                httpPost.abort();
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return reponseStr;
    }
 
    public static String getHttpResponseByGet(String url)  throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        String reponseStr = null;
        try {
 
            // 开始请求
            System.out.println("executing request " + httpGet.getURI());
            response = httpclient.execute(httpGet);
 
            // 检查是否已搬搬迁
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY
                    || statusCode == HttpStatus.SC_MOVED_PERMANENTLY
                    || statusCode == HttpStatus.SC_SEE_OTHER
                    || statusCode == HttpStatus.SC_TEMPORARY_REDIRECT) {
 
                Header[] headers = response.getHeaders("location");
 
                if (headers != null) {
                    httpGet.releaseConnection();
                    String newUrl = headers[0].getValue();
                    httpGet.setURI(URI.create(newUrl));
 
                    response = httpclient.execute(httpGet);
                }
            }
            reponseStr = printResponse(response);
            //解析页面内容
            Document doc= Jsoup.parse(reponseStr);   //从字符串中加载
            //直接从URL 中加载页面信息。timeout设置连接超时时间 post提交方式 或者get()
//          Document document = (Document) Jsoup.connect("http://haoma.imobile.com.cn/index.php?mob=18710115102").timeout(3000).post();
 
           //Elements  是 Element 的集合类
            Elements element=doc.select("shop");  //从加载的信息中查找table 标签
 
          //从查找到table属性的Elements集合中获取标签 tr 或者tr[class$=alt] 表示 tr标签内class属性=alt
//          Elements titleName=element.select("tr[class$=alt]");  
            Elements titleName=element.select("name");
            for(Element name : titleName){
               System.out.println(name.text());
           }
            //System.out.println(reponseStr);
 
            try {
                httpGet.abort();
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return reponseStr;
    }
 
    private static String printResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        // print the status line
        System.out.println(response.getStatusLine());
        // print the headers
        System.out.println("========== headers ==========");
        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            System.out.println(header);
        }
        StringBuffer sb = new StringBuffer();
        // print the content length
        if (entity != null) {
            System.out.println("\nResponse content length: "
                    + entity.getContentLength());
        }
        // print the entity content
        System.out.println("\n========== response content ==========");
 
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(
                    entity.getContent()));
            String line = null;
            while ((line = is.readLine()) != null) {
                System.out.println(line);
                //sb.append(line);
            }
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sb.toString();
    }
 
    public static final String SRC_URL = "http://w05.yulore.com:8983/solr/dianhua_bkwd/browse?q=0755-33066049&debugQuery=true";
 
    @SuppressWarnings("unused")
    public static void main(String[] args){
        try {
            String response = LocalHttpClient.getHttpResponseByGet(SRC_URL);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //LocalHttpClient.printResponse(response);
    }
}