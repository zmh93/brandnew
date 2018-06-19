import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
/**
 * Title: AESEncrypt
 * Description:
 *  AES加密算法即密码学中的高级加密标准（Advanced Encryption Standard，AES），又称Rijndael加密法，
 *  是美国联邦政府采用的一种区块加密标准。这个标准用来替代原先的DES，已经被多方分析且广为全世界所使用.
 *  AES算法基于排列和置换运算。排列是对数据重新进行安排，置换是将一个数据单元替换为另一个。AES 使用几种不同的方法来执行排列和置换运算。
 *  AES是一个迭代的、对称密钥分组的密码，它可以使用128、192 和 256 位密钥，并且用 128 位（16字节）分组加密和解密数据。
 *  与公共密钥密码使用密钥对不同，对称密钥密码使用相同的密钥加密和解密数据。通过分组密码返回的加密数据的位数与输入数据相同。
 *  迭代加密使用一个循环结构，在该循环中重复置换和替换输入数据。
 * @author zhaomenghui93@163.com
 * @createDate 2018/6/19
 */
public class AESEncrypt {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String content="hello";
        String key="aaaaaaaa";
        String iv="abcdefghijklmnop";

        System.out.println("加密前："+byteToHexString(content.getBytes()));
        byte[ ] encrypted=AES_CBC_Encrypt(content.getBytes(), key.getBytes(), iv.getBytes());
        System.out.println("加密后："+byteToHexString(encrypted));
        byte[ ] decrypted=AES_CBC_Decrypt(encrypted, key.getBytes(), iv.getBytes());
        System.out.println("解密后："+byteToHexString(decrypted));
    }

    public static byte[] AES_CBC_Encrypt(byte[] content, byte[] keyBytes, byte[] iv){

        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(keyBytes));
            SecretKey key=keyGenerator.generateKey();
            Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
            byte[] result=cipher.doFinal(content);
            return result;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    public static byte[] AES_CBC_Decrypt(byte[] content, byte[] keyBytes, byte[] iv){

        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(keyBytes));//key长可设为128，192，256位，这里只能设为128
            SecretKey key=keyGenerator.generateKey();
            Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            byte[] result=cipher.doFinal(content);
            return result;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
}
