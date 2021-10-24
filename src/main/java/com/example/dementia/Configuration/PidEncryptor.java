package com.example.dementia.Configuration;

import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;

@Component
public class PidEncryptor implements AttributeConverter<String,String> {

    private static final String Algorithm = "AES";
    private static final String SECRET = "dementia-secret-key-2021";

    private final Key key;
    private final Cipher cipher;

    public PidEncryptor() throws Exception {
        key = new SecretKeySpec(SECRET.getBytes(), Algorithm);
        cipher = Cipher.getInstance(Algorithm);
    }

    @Override
    public String convertToDatabaseColumn(String pid) {
        try {

            cipher.init(Cipher.ENCRYPT_MODE, key);
            String enc = Base64.getEncoder().encodeToString(cipher.doFinal(pid.getBytes()));
            System.out.println("encryption:"+enc);
            return enc;
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new IllegalStateException(e);
        }
    }
}
