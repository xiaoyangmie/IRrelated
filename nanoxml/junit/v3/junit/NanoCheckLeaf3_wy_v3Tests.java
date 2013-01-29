

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoCheckLeaf3_wy_v3Tests extends TestCase {

	public void test0() throws Exception {
		//checkleaf3.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		CheckLeaf3_wy_v3.main(new String[] {"inputs/file1_wy.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "The child element named BAR3 is a leaf element.\r\n");
	}

}
