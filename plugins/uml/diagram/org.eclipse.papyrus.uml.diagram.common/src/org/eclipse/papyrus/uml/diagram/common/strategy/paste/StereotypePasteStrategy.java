/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.strategy.paste;

import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.TransactionalPasteStrategy;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * 
 */
public class StereotypePasteStrategy implements IPasteStrategy {

	public String getLabel() {
		return "StereotypeStrategy"; //$NON-NLS-1$
	}

	public String getID() {
		return Activator.ID + ".StereotypeStrategy"; //".ClassifierToStructureCompDrop"; //$NON-NLS-1$
	}

	public String getDescription() {
		return "Paste stereotype elements"; //$NON-NLS-1$
	}

	public String getCategoryID() {
		return "org.eclipse.papyrus.strategy.paste"; //$NON-NLS-1$
	}

	public String getCategoryLabel() {
		return "Paste all copied elements"; //$NON-NLS-1$
	}		
	
	public Image getImage() {
		return null;
	}

	public int getPriority() {
		return 0;
	}

	public void setOptions(Map<String, Object> options) {
		//Nothing
	}

	@Override
	public Command getCommand(Request request, EditPart targetEditPart) {
		// TODO Auto-generated method stub
		return null;
	}



}
