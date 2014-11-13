/*******************************************************************************
 * Copyright (c) 2011, 2014 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package dtool.ast.expressions;

import static melnorme.utilbox.core.Assert.AssertNamespace.assertTrue;

import java.util.Collection;
import java.util.Collections;

import dtool.ast.ASTNode;
import dtool.ast.IASTNode;
import dtool.ast.references.RefQualified;
import dtool.ast.references.Reference;
import dtool.engine.ISemanticResolution;
import dtool.engine.common.IDeeNamedElement;
import dtool.engine.common.IValueNode;
import dtool.engine.common.ResolutionResult;
import dtool.engine.modules.IModuleResolver;
import dtool.resolver.IResolvable;

/**
 * A {@link Resolvable} is either an {@link Reference} or {@link Expression}
 */
public abstract class Resolvable extends ASTNode implements IValueNode, IResolvable {
	
	/** Marker interface for nodes that can appear as qualifier in {@link RefQualified}. 
	 * Must be a {@link Resolvable}. */
	public interface IQualifierNode extends IResolvable, IASTNode { }
	
	/** Marker interface for nodes that can appear as template references in template instance. 
	 * Must be a {@link Reference}.*/
	public interface ITemplateRefNode extends IASTNode { }
	
	public Resolvable() {
		assertTrue(this instanceof Reference || this instanceof Expression);
	}
	
	// TODO: deprecate this method in favor of resolveTargetElement
	public final IDeeNamedElement findTargetDefElement(IModuleResolver moduleResolver) {
		Collection<IDeeNamedElement> namedElems = findTargetDefElements(moduleResolver, true);
		if(namedElems == null || namedElems.isEmpty())
			return null;
		return namedElems.iterator().next();
	}
	
	public ResolutionResult resolveTargetElement(ISemanticResolution sr) {
		return new ResolutionResult(findTargetDefElement(sr));
	}
	
	/** Convenience method for wraping a single defunit as a search result. */
	public static Collection<IDeeNamedElement> wrapResult(IDeeNamedElement elem) {
		if(elem == null)
			return null;
		return Collections.singletonList(elem);
	}
	
	public static Collection<IDeeNamedElement> findTargetElementsForReference(IModuleResolver mr, Resolvable resolvable,
		boolean findFirstOnly) {
		if(resolvable == null) {
			return null;
		}
		return resolvable.findTargetDefElements(mr, findFirstOnly);
	}
	
}