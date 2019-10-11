/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author Miguel
 */
public class SecurityHelper {

// The algorithm name
    public static final String KEY_ALGORITHM = "DES";
    // The algorithm name / encryption mode / filling mode
    public static final String CIPHER_ALGORITHM_ECB = "DES/ECB/PKCS5Padding";
    public static final String CIPHER_ALGORITHM_CBC = "DES/CBC/PKCS5Padding";

    /*public static void main(String[] args) throws Exception {


        byte[] key = generateKey();
        byte[] encrypt = encrypt("F gastritis#*(x)".getBytes(), key);
        String passwordEncripted = new String(encrypt);
        System.out.println(passwordEncripted);
        System.out.println(new String(decrypt(encrypt, key)));


        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = factory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(getIV()));
        byte[] enc = cipher.doFinal("A%F#* gastritis(x)".getBytes()); // encryption

        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(getIV()));
        byte[] dec = cipher.doFinal(enc); // Decrypt
        System.out.println(new String(dec));
    }*/
    static byte[] getIV() {
        String iv = "asdfivh7"; //IV length: must be 8 bytes long
        return iv.getBytes();
    }

    /**
     * Key generation
     *
     * @return
     * @throws Exception
     */
    public static byte[] generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(56); //Des must be 56, the initial method does not have to call
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * Reduction of keys
     *
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {
        DESKeySpec des = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(des);
        return secretKey;
    }

    /**
     * Encryption
     *
     * @Param data
     * @param key
     * @Return ciphertext
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data) throws Exception {
        byte[] key = generateKey();
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    /**
     * Decrypt
     *
     * @Param data ciphertext
     * @param key
     * @Return, the original plaintext
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }

}
