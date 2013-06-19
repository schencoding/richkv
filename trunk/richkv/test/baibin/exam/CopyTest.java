package exam;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.Random;

import org.apache.cassandra.utils.ByteBufferUtil;

public class CopyTest {

	public static void main(String args[]) {
		Random r = new Random();
		for(int i=0;i<30;i++){
		int key = r.nextInt(10);
		System.out.println(key);
		}
		
		CopyTest ct = new CopyTest();
		int t_len = 100000;
		int e_len = 1000;
		long time = 0;
		try {
			 time = ct.test(t_len);
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double dbe = (double)time/(t_len/e_len);
		System.out.println(dbe);
	}

	public long test(int len) throws CharacterCodingException {

		StringBuilder sbu = new StringBuilder();
		StringBuilder sbu1 = new StringBuilder();
		String s = "0000000000";
		for (int i = 0; i <= len / 10; i++) {
			sbu.append(s);
			sbu1.append(s);
		}

		ByteBuffer bf1 = ByteBufferUtil.bytes(sbu.toString());
		ByteBuffer bf2 = ByteBufferUtil.bytes(sbu1.toString());
		long start = System.currentTimeMillis();
		this.merge(bf1, bf2);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return end - start;

	}

	public ByteBuffer merge(ByteBuffer bf1, ByteBuffer bf2)
			throws CharacterCodingException {

		String str1 = ByteBufferUtil.string(bf1);
		String str2 = ByteBufferUtil.string(bf2);
		str1.substring(0,str2.length());
		
		str1 += str2;
		return ByteBufferUtil.bytes(str1);

	}

}
