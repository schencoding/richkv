package exam;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;

import org.apache.cassandra.utils.ByteBufferUtil;

public class TestType {
	
	public static void main(String args[]) throws ClassNotFoundException, IOException{
      TestType test = new TestType();
//      test.testType();
      Integer i = 100;
      Long l = 10L;
      Object obj = l;
      if(obj instanceof Integer){
    	  System.out.println(obj.getClass().getName());
      }else{
    	  System.out.println(obj.toString());
      }
      
      
	}
	
	
	
	public void testType() throws IOException, ClassNotFoundException{
		byte b = (byte)'a';
		System.out.println(b);
		String str = "1234567777777777777999999999999999999999999999999999999999999999999999999999999999999999999999";
		int i = 100;
		ByteBuffer b1 = ByteBufferUtil.getByteBuffer(i);
//		System.out.println(b1.getLong());
		Object obj = getObject(b1);
		System.out.println(obj);
	}
	
    public static Object getObject(ByteBuffer byteBuffer) throws ClassNotFoundException, IOException {
    	
        InputStream input = ByteBufferUtil.inputStream(byteBuffer);
        ObjectInputStream oi = new ObjectInputStream(input);  
        Object obj = null;
		obj = oi.readObject();
		input.close();     
	    oi.close();    
		return obj;   
          
    }  

}
