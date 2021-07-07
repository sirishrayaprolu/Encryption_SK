/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ec;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author SIRISH KUMAR
 */
public class AESAlgorithm {
    public static String algo="AES";
    static Object aesAlgo;
    public byte[] keyValue;
    
    String d=null;
    public AESAlgorithm(byte key[])
    {
        keyValue=key;

    }

    


    public Key generateKey() throws Exception{
        Key key=new SecretKeySpec(keyValue,algo);
        return key;
    }
    public String encrypt(String msg) throws Exception {
        Key key= generateKey();
        Cipher c=Cipher.getInstance(algo);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal=c.doFinal(msg.getBytes());
        String encryptedValue=new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
    public String Decrypt(String msg1) throws Exception{
         
         Key key= generateKey();
        Cipher c=Cipher.getInstance(algo);
        c.init(Cipher.DECRYPT_MODE,key);
        byte[] decordedValue=new BASE64Decoder().decodeBuffer(msg1);
        byte[] decValue=c.doFinal(decordedValue);
        String decryptedValue=new String(decValue);
       
        return decryptedValue;

    }


}
