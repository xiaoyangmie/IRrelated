

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoWriter4_wy_v2Tests extends TestCase {

	public void test0() throws Exception {
		//writer4.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		Writer4_wy_v2.main(new String[] {"inputs/simple.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "<FOO>\r\n    <BAR/>\r\n    <BAR x=\"1\"/>\r\n    <BAR x=\"1\" y=\"2\"/>\r\n    <BAR>\r\n        <BAR/>\r\n        <BARBAR/>\r\n        <BA/>\r\n        <FOO/>\r\n    </BAR>\r\n    <BAR>blah</BAR>\r\n    <BAR x=\"1\">blah</BAR>\r\n    <BAR>&lt;&amp;&gt;&apos;&quot;</BAR>\r\n    <BAR>abc</BAR>\r\n    &lt;&amp;&gt;&quot;&apos;!:&#x2030;\r\n</FOO>\r\n");
	}

}
