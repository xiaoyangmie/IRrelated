

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoCheckAttr5_wy_v1Tests extends TestCase {

	public void test0() throws Exception {
		//checkattr5.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		CheckAttr5_wy_v1.main(new String[] {"inputs/file1_wy.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "The checked result of attr imagine is:  false\r\n");
	}

}
