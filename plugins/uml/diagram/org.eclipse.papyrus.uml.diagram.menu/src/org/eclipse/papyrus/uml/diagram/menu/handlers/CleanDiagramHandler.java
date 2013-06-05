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
package org.eclipse.papyrus.uml.diagram.menu.handlers;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.helper.CleanDiagramHelper;

//FIXME : this class must be moved into oep.infra.gmfdiag.menu, when the editpolicy RemoveOrphanView (used by CleanDiagramHelper will be moved into
//oep.infra.gmfdiag.common
public class CleanDiagramHandler extends AbstractHandler {

	/** The selected element. */
	private DiagramEditPart selectedElement;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(this.selectedElement != null) {
			CleanDiagramHelper.getInstance().run(selectedElement);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		this.selectedElement = null;
		if(evaluationContext instanceof IEvaluationContext) {
			Object defaultVariable = ((IEvaluationContext)evaluationContext).getDefaultVariable();
			if(defaultVariable instanceof Collection<?>) {
				int size = ((Collection<?>)defaultVariable).size();
				if(size != 0) {
					final Iterator<?> iter = ((Collection<?>)defaultVariable).iterator();
					while(iter.hasNext() && this.selectedElement == null) {
						Object current = iter.next();
						if(current instanceof EditPart)
							this.selectedElement = DiagramEditPartsUtil.getDiagramEditPart((EditPart)current);
					}
				}
			}
		}
		setBaseEnabled(this.selectedElement != null);
	}
}
