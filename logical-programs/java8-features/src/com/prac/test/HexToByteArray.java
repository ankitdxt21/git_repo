package com.prac.test;

public class HexToByteArray {

	public static void main(String[] args) {
		// Byte Array = 0x00,0x00,0x04,0xD1
		// Hexadecimal = 4D1

		int value = 1233;
		String hexVal = Integer.toHexString(value);
		System.out.println("Hexadecimal Value = " + hexVal);
		char[] chrArr = String.format("%8s", hexVal).replace(' ', '0').toCharArray();
		byte[] arr1 = hexStringToByteArray(new String(chrArr));
		for (byte a : arr1) {
			System.out.println(a);
		}

		byte temp = (byte) 0xd1;
		System.out.println("Value of D1 in byte : " + temp);

	}

	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}

}
