package br.com.refeitorio.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class CryptUtil {

	
	private static byte[] textEncripted;
	private static byte[] texts;
	private static byte[] textoDecriptografados;

	public static byte[] cryptPass(String password){
		
		KeyGenerator keygenerator;
		try {
			keygenerator = KeyGenerator.getInstance("DES");
			SecretKey chaveDES = keygenerator.generateKey(); 
			
			Cipher cifraDES; 
			// Cria a cifra 
			cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding"); 
			
			// Inicializa a cifra para o processo de encriptação 
			cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES); 
			
			texts = password.getBytes();  
			
			textEncripted = cifraDES.doFinal(texts); 
			System.out.println("Texto Encriptado : " + textEncripted); 
			
			// Inicializa a cifra também para o processo de decriptação 
			cifraDES.init(Cipher.DECRYPT_MODE, chaveDES); 
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return textEncripted;	
		
	}
	
	public static String decryptPass(byte[] pass){
		
		KeyGenerator keygenerator;
		Cipher cifraDES; 
		try {
			keygenerator = KeyGenerator.getInstance("DES");
			SecretKey chaveDES = keygenerator.generateKey();
			
			cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cifraDES.init(Cipher.DECRYPT_MODE, chaveDES); 
			
			
			textoDecriptografados = cifraDES.doFinal(pass); 
			 
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return textoDecriptografados.toString();
	}
}
