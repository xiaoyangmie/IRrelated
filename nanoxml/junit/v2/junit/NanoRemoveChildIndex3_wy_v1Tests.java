

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoRemoveChildIndex3_wy_v1Tests extends TestCase {

	public void test0() throws Exception {
		//rmchildindx3.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		RemoveChildIndex3_wy_v1.main(new String[] {"inputs/file4_wy.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "Exception in thread \"main\" java.lang.ArrayIndexOutOfBoundsException: 0 >= 0\r\n\tat java.util.Vector.removeElementAt(Vector.java:518)\r\n\tat net.n3.nanoxml.XMLElement.removeChildAtIndex(XMLElement.java:228)\r\n\tat RemoveChildIndex3_wy_v1.main(RemoveChildIndex3_wy_v1.java:48)\r\n");
	}

	public void test1() throws Exception {
		//rmchildindx4.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		RemoveChildIndex3_wy_v1.main(new String[] {"inputs/simple.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "<FOO>\r\n    <BAR x=\"1\"/>\r\n    <BAR x=\"1\" y=\"2\"/>\r\n    <BAR>\r\n        <BAR/>\r\n        <BARBAR/>\r\n        <BA/>\r\n        <FOO/>\r\n    </BAR>\r\n    <BAR>blah</BAR>\r\n    <BAR x=\"1\">blah</BAR>\r\n    <BAR>&lt;&amp;&gt;&apos;&quot;</BAR>\r\n    <BAR>abc</BAR>\r\n    &lt;&amp;&gt;&quot;&apos;!:&#x2030;\r\n</FOO>\r\n");
	}

}
