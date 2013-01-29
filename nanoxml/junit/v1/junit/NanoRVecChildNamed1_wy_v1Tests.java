

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoRVecChildNamed1_wy_v1Tests extends TestCase {

	public void test0() throws Exception {
		//rvecchildnamed1.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		RVecChildNamed1_wy_v1.main(new String[] {"inputs/simple.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "Exception in thread \"main\" java.lang.NullPointerException\r\n\tat net.n3.nanoxml.XMLElement.getChildrenNamed(XMLElement.java:316)\r\n\tat RVecChildNamed1_wy_v1.main(RVecChildNamed1_wy_v1.java:48)\r\n");
	}

}
