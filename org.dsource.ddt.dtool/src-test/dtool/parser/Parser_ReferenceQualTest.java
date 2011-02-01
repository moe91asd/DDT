package dtool.parser;

import static melnorme.utilbox.core.Assert.AssertNamespace.assertTrue;

import org.junit.Test;

import dtool.ast.references.RefQualified;
import dtool.ast.references.Reference;


public class Parser_ReferenceQualTest extends Parser_Reference_CommonTest {
	
	@Test
	public void testParseBasic() {
		runCommonTest("pack.foo");
		runCommonTest("pack.subpack.foo");
	}
	
	@Test
	public void testExpQualifier() throws Exception { testExpQualifier$(); }
	public void testExpQualifier$() throws Exception {
		checkToStringAsElement = false;
		runCommonTest("(blah).foo", RefFragmentDesc.EXP);
		runCommonTest("(1+2).foo", RefFragmentDesc.EXP);
		runCommonTest("__LINE__.stringof", RefFragmentDesc.EXP);
		runCommonTest("__FILE__.stringof", RefFragmentDesc.EXP);
	}
	
	@Override
	protected void checkReference(Reference ref, String nodeCode) {
		super.checkReference(ref, nodeCode);
		assertTrue(ref instanceof RefQualified);
	}
	
	@Test
	public void test_Combined() {
		String[] qualifieds = array("qual", "sub.qual");
		for (String qualifiedNames : qualifieds) {
			for (String refString : Parser_Reference_AllTest.sampleStaticRefs) {
				runCommonTest(refString + "." + qualifiedNames);
			}
		}
	}
	
	
	@Test
	public void testInvalid() throws Exception { testInvalid$(); }
	public void testInvalid$() throws Exception {
		runCommonTestForInvalidFragment("foo.");
		runCommonTestForInvalidFragment("pack.foo.");
		runCommonTestForInvalidFragment("pack..foo.");
		runCommonTestForInvalidFragment("pack.subpack.foo.");
	}
	
}
