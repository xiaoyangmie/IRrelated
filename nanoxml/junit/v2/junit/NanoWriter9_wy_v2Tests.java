

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.n3.nanoxml.*;

public class NanoWriter9_wy_v2Tests extends TestCase {

	public void test0() throws Exception {
		//writer17.out
		String result;
		ByteArrayOutputStream byteBuffer;

		byteBuffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteBuffer));
		Writer9_wy_v2.main(new String[] {"inputs/simple.xml"});
		result = new String(byteBuffer.toByteArray());
		assertEquals(result, "<FOO><BAR/><BAR x=\"1\"/><BAR x=\"1\" y=\"2\"/><BAR><BAR/><BARBAR/><BA/><FOO/></BAR><BAR>blah</BAR><BAR x=\"1\">blah</BAR><BAR>&lt;&amp;&gt;&apos;&quot;</BAR><BAR>abc</BAR>\n&#x9;&lt;&amp;&gt;&quot;&apos;!:&#x2030;\n</FOO>");
	}

}
