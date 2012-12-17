package com.irusist.commons.collections.util;

import org.apache.commons.collections.Transformer;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpURL;
import org.apache.commons.httpclient.methods.GetMethod;

import java.net.URL;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午3:59
 */
public class StockQuoteTransformer implements Transformer {

    protected URL quoteURL;
    protected long timeout;

    public Object transform(Object input) {
        QuoteRetriever retriever = new QuoteRetriever((String) input);
        try {
            Thread retrieveThread = new Thread(retriever);
            retrieveThread.start();
            retrieveThread.join(timeout);
        } catch (InterruptedException e) {
            System.out.println("Quote request timed out.");
        }

        return retriever.getResult();
    }

    public URL getQuoteURL() {
        return quoteURL;
    }

    public void setQuoteURL(URL quoteURL) {
        this.quoteURL = quoteURL;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public class QuoteRetriever implements Runnable {
        private String symbol;
        private Float result = Float.NaN;

        public QuoteRetriever(String symbol) {
            this.symbol = symbol;
        }

        public Float getResult() {
            return result;
        }

        public void run() {
            org.apache.commons.httpclient.HttpClient client = new HttpClient();
            try {
                HttpURL url = new HttpURL(quoteURL.toString());
                url.setQuery("symbol", symbol);

                GetMethod getMethod = new GetMethod(url.toString());
                client.executeMethod(getMethod);
                String reponse = getMethod.getResponseBodyAsString();

                result = new Float(reponse);
            } catch (Exception e) {
                System.out.println("Error retrieving quote");
            }
        }
    }
}
