/*******************************************************************************
 * Copyright (c) 2008, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package mmrnmhrm.tests;


import mmrnmhrm.tests.utils.ErrorLogListener;

import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.junit.After;
import org.junit.Before;

import dtool.tests.DeeTestUtils;

/** Base Test class that adds an exception listener to the platform log. 
 * The ErrorLogListener was the only way I found to detect UI exceptions in SafeRunnable's 
 * when running as plugin test. 
 */
public abstract class BaseDeeCoreTest extends DeeTestUtils {
	
	protected ErrorLogListener logErrorListener;
	
	@Before
	public void setUpExceptionListener() throws Exception {
		logErrorListener = ErrorLogListener.createAndInstall();
	}
	
	@After
	public void checkLogErrorListener() throws Throwable {
		logErrorListener.checkErrorsAndUninstall();
	}
	
	/* -------------- */
	
	protected static IModuleSource moduleToIModuleSource(final ISourceModule srcModule) {
		return new IModuleSource() {
			@Override
			public String getFileName() {
				return srcModule.getPath().toString();
			}
			
			@Override
			public String getSourceContents() {
				try {
					return srcModule.getSource();
				} catch(ModelException e) {
					throw melnorme.utilbox.core.ExceptionAdapter.unchecked(e);
				}
			}
			
			@Override
			public IModelElement getModelElement() {
				return srcModule;
			}
			
			@Override
			public char[] getContentsAsCharArray() {
				try {
					return srcModule.getSourceAsCharArray();
				} catch(ModelException e) {
					throw melnorme.utilbox.core.ExceptionAdapter.unchecked(e);
				}
			}
		};
	}
	
}