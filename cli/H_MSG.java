/*  Original Licensing Copyright
 * 
 *  Performs any Java Security Standard Hash or Bouncy Castle Hashes on UTF-8 Message 
 *  and optionally validates provided hash.
 *  Copyright (C) 2021  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
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
 *			Java SE9 Security Standard Algorithm Names</a>
 * @see <a href=https://www.bouncycastle.org/java.html>
 *			The Legion of the Bouncy Castle Java Cryptography APIs</a>
 * @author DZ-FSDev
 * @version 0.1.15
 * @since 17.0.1
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
