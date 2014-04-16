/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.utils;

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


/**
 * Utility class for tests
 */
public class EditorUtils {

	/**
	 * Retrieves current active editor
	 * 
	 * @return current active editor
	 * @throws Exception
	 *         exception thrown in case of issue
	 */
	public static IEditorPart getEditor() throws Exception {
		RunnableWithResult<IEditorPart> runnable;

		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<IEditorPart>() {

			public void run() {
				IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				setResult(editor);
			}
		});

		return runnable.getResult();
	}

	public static DiagramEditor getDiagramEditor() throws Exception {

		ServicesRegistry serviceRegistry = (ServicesRegistry)getEditor().getAdapter(ServicesRegistry.class);
		try {
			return (DiagramEditor)ServiceUtils.getInstance().getNestedActiveIEditorPart(serviceRegistry);

		} catch (ServiceException e) {
			throw new Exception("Unable to retrieve service.", e); //$NON-NLS-1$
		} catch (ClassCastException e) {
			throw new Exception("Active diagram is not a DiagramEditor." + e.getMessage(), e); //$NON-NLS-1$
		}
	}

	public static DiagramEditPart getDiagramEditPart() throws Exception {

		try {
			return getDiagramEditor().getDiagramEditPart();

		} catch (NullPointerException e) {
			throw new Exception("Could not find diagram edit part.", e); //$NON-NLS-1$
		}
	}

}
