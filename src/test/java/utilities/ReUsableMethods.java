package utilities;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

public class ReUsableMethods {

    public static String encodeToBase64(String string) {
        return Base64.encodeBase64String(string.getBytes());
    }

    public static String encodeToHmacSha384(String base64,
                                            String key_secret) {
        HmacUtils hmacUtils=new HmacUtils((HmacAlgorithms.HMAC_SHA_384), key_secret);
        String hmac=hmacUtils.hmacHex(base64);
        System.out.println(hmac);
        return  hmac;
    }

    public static String generateStringId(){
         long timeinMilisecs=System.currentTimeMillis();

        System.out.println(timeinMilisecs);
        return String.valueOf(timeinMilisecs/10000);
    }


}
