package caesarCipher;

public class EncryptAndDecrypt {

	private String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public String encrypt(String plaintext, int key) {
		String cipherText = "";
		plaintext = plaintext.toUpperCase();
		for (int i = 0; i < plaintext.length(); i++) {
			char character = plaintext.charAt(i);
			int charIndex = ALPHABETS.indexOf(character);
			int encryptedIndex = (charIndex + key) % ALPHABETS.length();
			cipherText += ALPHABETS.charAt(encryptedIndex);
		}
		return cipherText;
	}

	public String decrypt(String ciphertext, int key) {
		String plaintext = "";
		ciphertext = ciphertext.toUpperCase();
		for (int i = 0; i < ciphertext.length(); i++) {
			char character = ciphertext.charAt(i);
			int charIndex = ALPHABETS.indexOf(character);
			//Math.floor is used as modulus of a negative value cannot be calculated
			int decryptedIndex = Math.floorMod((charIndex - key),ALPHABETS.length());
			plaintext+= ALPHABETS.charAt(decryptedIndex);
		}
		return plaintext;
	}

	public static void main(String[] args) {
		EncryptAndDecrypt enAndDe = new EncryptAndDecrypt();
		String encryptedMessage = enAndDe.encrypt("TOPGUN", 10);
		System.out.println("Encrypted Message is : " + encryptedMessage);
		String originalMessage = enAndDe.decrypt(encryptedMessage, 10);
		System.out.println("Original Message is : " + originalMessage);
	}
}
