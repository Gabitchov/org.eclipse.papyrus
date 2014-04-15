/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import java.util.Collection;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.tools.util.WorkbenchPartHelper;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;


public class DiagramPropertyTester extends PropertyTester {

	/** property to test if the selected element are open in the editor */
	public static final String IS_DIAGRAM_EDITOR = "isDiagramEditor"; //$NON-NLS-1$

	/**
	 * property to test if the GMF Diagram context is active
	 */
	public static final String IS_GMF_DIAGRAM_CONTEXT_ACTIVE = "isGmfDiagramContextActive"; //$NON-NLS-1$

	/**
	 * property to test if the focus is on a text zone or an internal xtext editor
	 */	
	public static final String IS_TEXT_ZONE = "isTextZone"; //$NON-NLS-1$	
	
	
	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_DIAGRAM_EDITOR.equals(property) && receiver instanceof IStructuredSelection) {
			//FIXME : we should be able to replace the calls to this test in the plugin.xml by : 
			// activeWhen -> with -> activeEditor -> adapt -> IDiagramWorkbenchPart.  unfortunately, this method doesn't work, the adapt test is correct, but the Eclipse handler system
			//find often several handlers actived in the same time and choose one of them (and never the Papyrus handler...)
			boolean answer = isDiagramEditor((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		} else if(IS_GMF_DIAGRAM_CONTEXT_ACTIVE.equals(property) && receiver instanceof Collection<?>) {
			boolean answer = isDiagramContextActive((Collection<?>)receiver);
			return new Boolean(answer).equals(expectedValue);
		} else if (IS_TEXT_ZONE.equals(property) && receiver instanceof Shell){
			boolean answer = isTextZone((Shell)receiver);
			return new Boolean(answer).equals(expectedValue);			
		}
		return false;
	}

	/**
	 * @param shell
	 * @return <code>true</code> if the focus is on a text zone or an internal xtext editor
	 */
	private boolean isTextZone(Shell shell) {
		Display display = shell.getDisplay();
		if (display != null){
			Control focusControl = display.getFocusControl();
				if (focusControl instanceof StyledText || focusControl instanceof Text){
					return true;
				}
			}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 *         <code>true</code> if the current active part is a Papyrus Diagram
	 */
	private boolean isDiagramEditor(IStructuredSelection selection) {
		final IWorkbenchPart part = WorkbenchPartHelper.getCurrentActiveWorkbenchPart();
		if(part != null) {
			final IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart)part.getAdapter(IDiagramWorkbenchPart.class);
			return diagramPart != null;
		}
		return false;
	}

	/**
	 * 
	 * @param context
	 * 
	 * @return
	 */
	private boolean isDiagramContextActive(final Collection<?> activeContextIds) {
		return activeContextIds.contains("org.eclipse.gmf.runtime.diagram.ui.diagramContext"); //$NON-NLS-1$
	}
}
