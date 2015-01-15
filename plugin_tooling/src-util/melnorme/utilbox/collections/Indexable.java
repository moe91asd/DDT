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
package melnorme.utilbox.collections;

import java.util.RandomAccess;

/**
 * interface for a read-only view of a random access collection
 */
public interface Indexable<E> extends Collection2<E>, RandomAccess {
	
	/** @return the element at given index. */
	E get(int index);
	
}