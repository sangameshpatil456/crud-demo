package com.crud.demo.controller;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.*;
import javax.xml.parsers.*;
import java.io.*;
import java.math.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class PublicKeyGeneration {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, SignatureException {
        String xmlString = "<RSAKeyValue><Modulus>68CObYbcjNqXUL7v8qZu1g+Oamh1197Fo02XhhzUpkIXvahzMvwnrKrnfhOGXv9WIuvRrXh7fHz7DtjMj/xx+Q==</Modulus><Exponent>AQAB</Exponent><P>9yvKj5U9EmjcapWs9UnDeYOgdgkA4ALPmJkZ12SFsIU=</P><Q>9CxY5sO3T6iJLWA9H+iJ4Ce/CEhCcXxYL7A/LYUiz+U=</Q><DP>cFopg0bVMe8UciaDLiRPhIa+g6joCut8LeM6CdyZoHk=</DP><DQ>co0joA+NvmdZA9q0knWryWecLayIz2kAjk7nNNnS/Sk=</DQ><InverseQ>rFQ+P6U+WPh+lAPJJzSwiYX9KxsAJPHNldiF7HUdBzg=</InverseQ><D>TlGt/1zqMDD+S+jite3srFiGq3sAizKK3fGNARTa4FA5b5B6n8QtNaQVA9sgqgSHJwALQXq39F01fL8yiGMiwQ==</D></RSAKeyValue>";
        String inputString = "xyz";
        System.out.println(encryptStringRSA(inputString,xmlString));
    }

    public static String encryptStringRSA(String inputString, String xmlString) throws ParserConfigurationException, IOException, SAXException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, SignatureException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Element element = documentBuilder.parse(new ByteArrayInputStream(xmlString.getBytes())).getDocumentElement();
        String[] names = {"Modulus", "Exponent", "D", "P", "Q", "DP", "DQ", "InverseQ"};
        BigInteger[] valsArray = new BigInteger [names.length];
        for( int i = 0; i < names.length; i++ ){
            String values = element.getElementsByTagName(names[i]).item(0).getTextContent();
            byte[] modulusBytes = Base64.getDecoder().decode(values);
            valsArray[i] = new BigInteger(1, modulusBytes);
        }

        Signature signature = Signature.getInstance("SHA1withRSA");
        KeyFactory factorye = KeyFactory.getInstance("RSA");
        RSAPrivateKeySpec privateKeySpecs = new RSAPrivateKeySpec(valsArray[0], valsArray[1]);
        PrivateKey privateKeya = factorye.generatePrivate(privateKeySpecs);
        signature.initSign(privateKeya);
        signature.update(inputString.getBytes("UTF-8"));
        byte[] SignedByteData = signature.sign();
        System.out.println("decrypted: " + Base64.getEncoder().encodeToString(SignedByteData));




        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(valsArray[0], valsArray[1]);
        RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(pubSpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(inputString.getBytes(StandardCharsets.UTF_8));
        String encrpt= Base64.getEncoder().encodeToString(encrypted);
        System.out.println("decrypted: " + new String(encrpt));


        KeyFactory factory = KeyFactory.getInstance("RSA");
        RSAPrivateKeySpec privSpec = new RSAPrivateKeySpec(valsArray[0], valsArray[7]);
        PrivateKey privateKey = factory.generatePrivate(privSpec);
        Cipher cipherd = Cipher.getInstance("RSA");
        cipherd.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encrpt));
        System.out.println("decrypted: " + Base64.getEncoder().encodeToString(decrypted));
        return "";

    }
}
