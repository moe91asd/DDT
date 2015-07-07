/*******************************************************************************
 * Copyright (c) 2014, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package mmrnmhrm.core.build;

import static melnorme.utilbox.core.Assert.AssertNamespace.assertFail;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import melnorme.lang.ide.core.operations.LangProjectBuilder;
import melnorme.lang.ide.core.operations.build.BuildOperationCreator;
import melnorme.lang.ide.core.operations.build.IBuildTargetOperation;
import melnorme.utilbox.core.CommonException;
import mmrnmhrm.core.DeeCore;


public class DubProjectBuilder extends LangProjectBuilder {
	
	/* ----------------- clean ----------------- */
	
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		IFolder dubCacheFolder = getProject().getFolder(".dub");
		if(dubCacheFolder.exists()) {
			dubCacheFolder.delete(true, monitor);
		}
		deleteProjectBuildMarkers();
	}
	
	@Override
	protected ProcessBuilder createCleanPB() throws CoreException, CommonException {
		throw assertFail();
	}
	
	/* ----------------- Build ----------------- */
	
	@Override
	protected BuildOperationCreator createBuildOperationCreator(boolean fullBuild) {
		return new BuildOperationCreator(getProject(), workspaceOpInfo, fullBuild) {
			@Override
			protected IBuildTargetOperation newMessageOperation(IProject project, String msg, boolean clearConsole) {
				return new BuildMessageOperation(parentOpInfo.createSubOperation(project, clearConsole, msg)) {
					@Override
					protected void executeDo() {
						// Run message output in dub process manager
						DeeCore.getDubProcessManager().submitDubCommand(this);
					}
				};
			}
		};
	}
	
}