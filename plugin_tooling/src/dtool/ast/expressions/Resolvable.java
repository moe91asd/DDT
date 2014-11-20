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

import melnorme.lang.tooling.ast_actual.ASTNode;
import melnorme.lang.tooling.bundles.ISemanticContext;
import melnorme.lang.tooling.bundles.ISemanticContext;
import melnorme.lang.tooling.engine.resolver.AbstractResolvableSemantics;
import melnorme.lang.tooling.engine.resolver.IResolvable;
import melnorme.lang.tooling.engine.resolver.IResolvableSemantics;
import melnorme.lang.tooling.engine.resolver.ResolutionResult;
import melnorme.lang.tooling.symbols.INamedElement;
import dtool.ast.references.Reference;

/**
 * A {@link Resolvable} is either an {@link Reference} or {@link Expression}
 */
public abstract class Resolvable extends ASTNode implements IResolvable {
	
	public Resolvable() {
		assertTrue(this instanceof Reference || this instanceof Expression);
	}
	
	protected final IResolvableSemantics defaultResolvableSemantics = new AbstractResolvableSemantics() {
		
		@Override
		public ResolutionResult resolveTargetElement(ISemanticContext sr) {
			return new ResolutionResult(findTargetDefElement(sr));
		}
		
		@Override
		public Collection<INamedElement> findTargetDefElements(ISemanticContext mr, boolean findOneOnly) {
			return Resolvable.this.findTargetDefElements(mr, findOneOnly);
		}
		
	};
	
	@Override
	public IResolvableSemantics getSemantics() {
		return defaultResolvableSemantics;
	}
	
	@Override
	public Collection<INamedElement> resolveTypeOfUnderlyingValue(ISemanticContext mr) {
		return getSemantics().resolveTypeOfUnderlyingValue(mr);
	}
	
	public final INamedElement findTargetDefElement(ISemanticContext moduleResolver) {
		return getSemantics().findTargetDefElement(moduleResolver);
	}
	
	public final ResolutionResult resolveTargetElement(ISemanticContext sr) {
		return getSemantics().resolveTargetElement(sr);
	}
	
	/* ----------------- ----------------- */
	
	/** Convenience method for wraping a single defunit as a search result. */
	public static Collection<INamedElement> wrapResult(INamedElement elem) {
		if(elem == null)
			return null;
		return Collections.singletonList(elem);
	}
	
	public static Collection<INamedElement> findTargetElementsForReference(ISemanticContext mr, Resolvable resolvable,
		boolean findFirstOnly) {
		if(resolvable == null) {
			return null;
		}
		return resolvable.findTargetDefElements(mr, findFirstOnly);
	}
	
}