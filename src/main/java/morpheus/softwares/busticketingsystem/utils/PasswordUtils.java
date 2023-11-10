package morpheus.softwares.busticketingsystem.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author MOPHE
 */
public class PasswordUtils {

    /**
     * Encrypts password string using SHA-256 hashing algorithm.
     *
     * @param password
     * @param salt
     * @return A hexadecimal hashed password
     */
    public static String hashPassword(String password, byte[] salt) {
        try {
            // Returns a MessageDigest object that implements the specified digest algorithm.
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            // Updates the digest using the specified array of bytes.
            messageDigest.update(salt);
            // Encodes this String into a sequence of bytes using the default
            // charset, storing the result into a new byte array.
            byte[] passwordBytes = password.getBytes();

            // Performs a final update on the digest using the specified array of bytes,
            // then completes the digest computation. That is, this method first calls update(input),
            // passing the input array to the update method, then calls digest().
            byte[] digest = messageDigest.digest(passwordBytes);

            return bytesToHexadecimal(digest);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());

            return null;
        }
    }

    /**
     * Generates a salt to be used in hashing Customer password to SHA-256
     *
     * @return Random salt for hashing
     */
    public static byte[] generateSalt() {
        // This class provides a cryptographically strong random number generator (RNG).
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        // Generates a user-specified number of random bytes.
        secureRandom.nextBytes(salt);

        return salt;
    }

    /**
     * Validates Customer password credential
     *
     * @param password
     * @param hashedPassword
     * @return true or false
     */
    public static boolean validatePassword(String password, String hashedPassword) {
        String newHashedPassword = hashPassword(password, generateSalt());

        return newHashedPassword != null && newHashedPassword.equals(hashedPassword);
    }

    private static String bytesToHexadecimal(byte[] bytes) {
        StringBuilder hexadecimalString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexadecimalString.append(String.format("%02x", b));
        }

        return String.valueOf(hexadecimalString);
    }
}
