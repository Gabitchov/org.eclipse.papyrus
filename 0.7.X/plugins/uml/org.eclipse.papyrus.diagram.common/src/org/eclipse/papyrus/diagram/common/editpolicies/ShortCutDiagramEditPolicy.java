/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editpolicies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.OpenDiagramCommand;

/**
 * This class is used to open a new diagram when the double click is detected. It is dependent of
 * papyrus environment
 */
public class ShortCutDiagramEditPolicy extends OpenEditPolicy {

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		if(((GraphicalEditPart)getHost()).getNotationView().getElement() instanceof Diagram && ((GraphicalEditPart)getHost()).getNotationView().getElement().eResource() != null) {
			Diagram diagram = (Diagram)((GraphicalEditPart)getHost()).getNotationView().getElement();
			DiResourceSet diResourceSet = EditorUtils.getDiResourceSet();
			if (diResourceSet != null) {
				OpenDiagramCommand openDiagramCommand = new OpenDiagramCommand(diResourceSet.getTransactionalEditingDomain(), diagram);
				return new ICommandProxy(openDiagramCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

}
