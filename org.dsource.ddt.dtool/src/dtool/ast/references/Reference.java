package dtool.ast.references;

import java.util.Collection;

import dtool.ast.definitions.INamedElement;
import dtool.ast.expressions.Resolvable;
import dtool.resolver.CommonDefUnitSearch;
import dtool.resolver.IResolvable;
import dtool.resolver.LanguageIntrinsics;
import dtool.resolver.api.DefUnitDescriptor;
import dtool.resolver.api.IModuleResolver;

/**
 * Common class for entity references.
 */
public abstract class Reference extends Resolvable {
	
	public abstract boolean canMatch(DefUnitDescriptor defunit);
	
	public static void resolveSearchInMultipleContainers(Collection<INamedElement> containers, 
		CommonDefUnitSearch search, boolean isDotQualified) {
		if(containers == null)
			return;
		
		boolean hasTypeContainer = false;
		for (INamedElement container : containers) {
			if(search.isFinished())
				return;
			container.resolveSearchInMembersScope(search);
			
			if(container.getArcheType().isType()) {
				hasTypeContainer = true;
			}
		}
		/*BUG here with hasTypeContainer*/
		if(isDotQualified && hasTypeContainer) { 
			LanguageIntrinsics.d_2_063_intrinsics.resolveSearchInTypePropertiesScope(search);
		}
	}
	
	public static void resolveSearchInReferredContainer(CommonDefUnitSearch search, IResolvable resolvable) {
		if(resolvable == null) {
			return;
		}
		
		IModuleResolver mr = search.getModuleResolver();
		Collection<INamedElement> containers = resolvable.findTargetDefElements(mr, true);
		resolveSearchInMultipleContainers(containers, search, true);
	}
	
	// TODO: review this method
	public static void resolveSearchInReferedMembersScope(CommonDefUnitSearch search, IResolvable reference) {
		if(reference == null) {
			return;
		}
		
		IModuleResolver moduleResolver = search.getModuleResolver();
		Collection<INamedElement> containers = reference.findTargetDefElements(moduleResolver, true);
		if(containers == null)
			return;
		
		if(containers.isEmpty())
			return;
		// if several defUnits found, search in first only
		INamedElement resolvedType = containers.iterator().next();
		resolvedType.resolveSearchInMembersScope(search);
	}
	
}