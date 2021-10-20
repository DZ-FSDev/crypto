package com.dz_fs_dev.crypto.cli;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Performs any Java Security Standard Hash or Bouncy Castle Hashes on UTF-8 Message 
 * and optionally validates provided hash to true or false.
 * 
 * @see <a href=https://docs.oracle.com/javase/9/docs/specs/security/standard-names.html>
 *  		Java SE9 Security Standard Algorithm Names</a>
 * @see <a href=https://www.bouncycastle.org/java.html>
 * 			The Legion of the Bouncy Castle Java Cryptography APIs</a>
 * @author DZ-FSDev
 * @version 0.1.15
 * @since 16.0.1
 */
public class H_MSG {
	public static void main(String[] args) {
		if(args.length==0)System.exit(0);
		Security.addProvider(new BouncyCastleProvider());
		final String ALG = args[0].toUpperCase();
		try {
			final String _H;
			final MessageDigest _MD = MessageDigest.getInstance(ALG);
			System.out.println(_H = new BigInteger(1,
					_MD.digest(args[1].getBytes(StandardCharsets.UTF_8))
						).toString(16));
			if(args.length > 1)System.out.println(args[2].equals(_H));
		} catch (NoSuchAlgorithmException e) {
			System.out.printf("%s unsupported on JVM.%n", ALG);
		}
	}
}
