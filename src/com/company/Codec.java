package com.company;

import java.util.Base64;

/**
 *     Note: This is a companion problem to the System Design problem: Design TinyURL.
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 *
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 * Implement the Solution class:
 *
 *     Solution() Initializes the object of the system.
 *     String encode(String longUrl) Returns a tiny URL for the given longUrl.
 *     String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 */
public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String[] urlToArray = longUrl.split("/");
        String tcpConnectionType = urlToArray[0];
        String newUrl = tcpConnectionType+"//%1$s/%2$s";
        // Getting encoder
        Base64.Encoder encoder = Base64.getEncoder();
        String mainDomain = urlToArray[2];
        System.out.println("Base domain " + mainDomain);
        // Encoding string
        String encodeMainDomainStr = encoder.encodeToString(mainDomain.getBytes());
        String domain = tcpConnectionType + "//" + mainDomain +"/";
        String subDomainPath = longUrl.replace(domain,"");
        System.out.println("subDomainPath  " + subDomainPath);
        String encodeSubDomainStr = encoder.encodeToString(subDomainPath.getBytes());
        return String.format(newUrl, encodeMainDomainStr, encodeSubDomainStr);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        String[] urlToArray = shortUrl.split("/");
        String tcpConnectionType = urlToArray[0];
        String longUrl = tcpConnectionType+"//%1$s/%2$s";
        // Getting decoder
        Base64.Decoder decoder = Base64.getDecoder();
        String encodeMainDomain = urlToArray[2];
        System.out.println("encodeMainDomain Base domain " + encodeMainDomain);
        // Decoding string
        String decodedMainDomainStr = new String(decoder.decode(encodeMainDomain));
        System.out.println("decodedMainDomainStr Base domain " + decodedMainDomainStr);
        String domain = tcpConnectionType + "//" + encodeMainDomain +"/";
        System.out.println("domain encoded value   " + domain);
        String encodedSubDomainPath = shortUrl.replace(domain,"");
        System.out.println("encodedSubDomainPath  " + encodedSubDomainPath);
        String decodedSubDomainStr = new String(decoder.decode(encodedSubDomainPath));
        System.out.println("decodedSubDomainStr  " + decodedSubDomainStr);
        return String.format(longUrl, decodedMainDomainStr, decodedSubDomainStr);
    }

    public static void main(String [] args) {
        String url3 = "https://leetcode.com/problems/design-tinyurl";
        String url2 = "http://www.leetcode.com/faq/?id=10";
        String url1 = "https://bone.example.net/?brother=agreement&beds=bird";
        Codec codec = new Codec();
        String encodedUrl = codec.encode(url3);
        System.out.println("Encoded short url " + encodedUrl);
        String decodedUrl = codec.decode(encodedUrl);
        System.out.println("Encoded short url " + decodedUrl);
    }
}
