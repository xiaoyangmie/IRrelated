

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoRAttrVal1_wy_v1Tests extends TestCase {

	public void test0() throws Exception {
		//rattrval1.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		RAttrVal1_wy_v1.main(new String[] {"inputs/file1_wy.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "The value of attr null is:    null\r\n");
	}

}
