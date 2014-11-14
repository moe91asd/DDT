/*******************************************************************************
 * Copyright (c) 2014, 2014 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package melnorme.lang.tooling.ast_actual;

import melnorme.lang.tooling.symbols.INamedElement;
import descent.core.ddoc.Ddoc;
import dtool.ast.definitions.EArcheType;

public interface ILangNamedElement extends INamedElement {
	
	/** Gets the archetype (the kind) of this DefElement. */
	EArcheType getArcheType();
	
	/** Resolve the underlying element and return its DDoc. See {@link #resolveUnderlyingNode()}.
	 * Can be null. */
	Ddoc resolveDDoc();
	
}