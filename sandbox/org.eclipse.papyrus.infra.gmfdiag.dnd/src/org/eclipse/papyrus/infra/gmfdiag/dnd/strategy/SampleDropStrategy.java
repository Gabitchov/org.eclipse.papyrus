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

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.graphics.Image;


public class SampleDropStrategy extends TransactionalDropStrategy {

	public String getLabel() {
		return "Sample";
	}

	public String getID() {
		return "org.eclipse.papyrus.sample";
	}

	public String getDescription() {
		return "Sample strategy";
	}

	@Override
	public Command doGetCommand(Request request, final EditPart targetEditPart) {
		//Drag_Drop + Creation (Ignore REQ_CREATE)
		String[] types = new String[]{ RequestConstants.REQ_DROP, RequestConstants.REQ_DROP_OBJECTS, RequestConstants.REQ_ADD };

		if(!Arrays.asList(types).contains(request.getType())) {
			System.out.println("Unknow request: " + request.getType());
			return null;
		}

		return new Command() {

			@Override
			public void execute() {
				EObject semantic = EMFHelper.getEObject(targetEditPart);
				EStructuralFeature feature = semantic.eClass().getEStructuralFeature("name");

				semantic.eSet(feature, "Drop on " + targetEditPart.getClass().getSimpleName());
			}
		};
	}

	public Image getImage() {
		return null;
	}

	public int getPriority() {
		return 100;
	}

}
