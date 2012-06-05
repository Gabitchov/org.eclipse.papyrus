/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.graphics.Image;


public abstract class SetValueDropStrategy extends TransactionalDropStrategy {

	protected EStructuralFeature feature;

	public String getLabel() {
		return "Set value";
	}

	public String getDescription() {
		return "Change a propertie's value on the target element";
	}

	public Image getImage() {
		return null;
	}

	@Override
	public Command doGetCommand(Request request, EditPart targetEditPart) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTargetFeature(EStructuralFeature targetFeature) {
		this.feature = targetFeature;
	}

	protected EStructuralFeature getTargetFeature(Request request, EditPart targetEditPart) {
		return feature;
	}

}
