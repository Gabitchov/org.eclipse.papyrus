/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.providers;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;


public class DiagramPropertyTester extends PropertyTester {

	/** property to test if the selected element are open in the editor */
	public static final String IS_DIAGRAM = "isDiagram"; //$NON-NLS-1$

	/**
	 * property to test if a diagram has the required edit policy
	 */
	public static final String DIAGRAM_HAS_REQUIRED_EDIT_POLICY = "hasRequiredEditPolicy";  //$NON-NLS-1$

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_DIAGRAM.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isDiagram((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		} else if(DIAGRAM_HAS_REQUIRED_EDIT_POLICY.equals(property) && receiver instanceof IStructuredSelection && args.length == 1 && args[0] instanceof String) {
			boolean answer = hasRequiredEditPolicy((IStructuredSelection)receiver, (String)args[0]);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 *        the selection
	 * @param wantedEditPolicy
	 *        the wanted edit policy
	 * @return
	 *         <code>true</code> if the diagram edit part has the wanted selection
	 */
	protected boolean hasRequiredEditPolicy(final IStructuredSelection selection, final String wantedEditPolicy) {
		boolean answer = false;
		if(selection.size() != 0) {
			final Object first = selection.getFirstElement();
			if(first instanceof EditPart) {
				EditPart parent = (EditPart)first;
				final DiagramEditPart diagramEP = DiagramEditPartsUtil.getDiagramEditPart(parent);
				if(diagramEP != null) {
					answer = diagramEP.getEditPolicy(wantedEditPolicy) != null;
				}
			}
		}
		return answer;
	}

	/**
	 * Tests the selection in order to know if it contains only {@link Diagram}
	 * 
	 * @param selection
	 * @return
	 *         <code>true</code> if the selection is composed by {@link Diagram}
	 */
	private boolean isDiagram(IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				if(!(iter.next() instanceof Diagram)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
