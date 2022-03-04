package caesarCipher;

public class EncryptCeaserCipher {

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

	public static void main(String[] args) {
		EncryptCeaserCipher cipher = new EncryptCeaserCipher();
		String encryptedMessage = cipher.encrypt("THE SKY IS BLUE", 10);
		System.out.println("Original Message : 'THE SKY IS BLUE' is encrypted to : " + encryptedMessage);
	}

}
