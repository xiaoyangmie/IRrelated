

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoCheckAttr4_wy_v1Tests extends TestCase {

	public void test0() throws Exception {
		//checkattr4.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		CheckAttr4_wy_v1.main(new String[] {"inputs/file1_wy.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "The checked result of attr age is: true\r\n");
	}

}
