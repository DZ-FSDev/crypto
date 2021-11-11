package com.dz_fs_dev.crypto.compress.test;

import com.dz_fs_dev.crypto.compress.Compress;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CompressTest {
	@Test
	public void burrowsWheeler_encode() {
		assertEquals("19iiippppssssssssmmmmi   ppppiiiissssssssiiiiiiii",
				Compress.burrowsWheeler_encode("mississippi mississippi mississippi mississippi"));
	}
	
	@Test
	public void burrowsWheeler_decode() {
		assertEquals("mississippi mississippi mississippi mississippi",
				Compress.burrowsWheeler_decode("19iiippppssssssssmmmmi   ppppiiiissssssssiiiiiiii"));
	}
}
