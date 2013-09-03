package dtool.resolver;

import java.util.ArrayList;

import melnorme.utilbox.misc.ArrayUtil;
import descent.core.ddoc.Ddoc;
import dtool.ast.definitions.IntrinsicDefUnit;
import dtool.util.ArrayView;

/** 
 * A module like class, contained all primitive defunits. 
 */
public class NativesScope implements IScopeProvider {
	
	public static final NativesScope nativesScope = new NativesScope();
	
	public final ArrayView<IntrinsicDefUnit> intrinsics;
	
	public NativesScope() {
		ArrayList<IntrinsicDefUnit> intrincsList = new ArrayList<>();
	    
		intrincsList.add(new PrimitiveDefUnit("bool"));
		intrincsList.add(new PrimitiveDefUnit("byte"));
		intrincsList.add(new PrimitiveDefUnit("ubyte"));
		intrincsList.add(new PrimitiveDefUnit("short"));
		intrincsList.add(new PrimitiveDefUnit("ushort"));
		intrincsList.add(new PrimitiveDefUnit("int"));
		intrincsList.add(new PrimitiveDefUnit("uint"));
		intrincsList.add(new PrimitiveDefUnit("long"));
		intrincsList.add(new PrimitiveDefUnit("ulong"));
		intrincsList.add(new PrimitiveDefUnit("char"));
		intrincsList.add(new PrimitiveDefUnit("wchar"));
		intrincsList.add(new PrimitiveDefUnit("dchar"));
		intrincsList.add(new PrimitiveDefUnit("float"));
		intrincsList.add(new PrimitiveDefUnit("double"));
		intrincsList.add(new PrimitiveDefUnit("real"));
		
		intrincsList.add(new PrimitiveDefUnit("void"));
		
		intrincsList.add(new PrimitiveDefUnit("ifloat"));
		intrincsList.add(new PrimitiveDefUnit("idouble"));
		intrincsList.add(new PrimitiveDefUnit("ireal"));
		intrincsList.add(new PrimitiveDefUnit("cfloat"));
		intrincsList.add(new PrimitiveDefUnit("cdouble"));
		intrincsList.add(new PrimitiveDefUnit("creal"));
		
		IntrinsicDefUnit[] createFrom = ArrayUtil.createFrom(intrincsList, IntrinsicDefUnit.class);
		intrinsics = ArrayView.create(createFrom);
	}
	
	@Override
	public void resolveSearchInScope(CommonDefUnitSearch search) {
		ReferenceResolver.findInNamedElementList(search, intrinsics);
	}
	
	public static class PrimitiveDefUnit extends IntrinsicDefUnit {
		
		public PrimitiveDefUnit(String name) {
			super(name);
		}
		
		@Override
		public Ddoc resolveDDoc() {
			return null;
		}
		
		@Override
		public void resolveSearchInMembersScope(CommonDefUnitSearch search) {
		}
		
	}
	
}