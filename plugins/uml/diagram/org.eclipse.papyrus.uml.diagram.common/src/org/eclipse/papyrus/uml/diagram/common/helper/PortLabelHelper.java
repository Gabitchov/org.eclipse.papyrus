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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.PortUtil;
import org.eclipse.uml2.uml.Port;


public class PortLabelHelper extends PropertyLabelHelper {

	// Einstance
	private static PortLabelHelper labelHelper;

	public static PortLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new PortLabelHelper();
		}
		return labelHelper;
	}

	protected PortLabelHelper() {
		super();
		masks.put(ICustomAppearence.DISP_CONJUGATED, "Conjugated");
	}

	@Override
	protected String parseString(GraphicalEditPart editPart, int displayValue) {
		Port port = getUMLElement(editPart);

		if(port != null) {
			return PortUtil.getCustomLabel(port, displayValue);
		}

		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Port getUMLElement(GraphicalEditPart editPart) {
		if(editPart.getModel() instanceof View) {
			View view = (View)editPart.getModel();
			if(view.getElement() instanceof Port) {
				return (Port)view.getElement();
			}
		}
		return null;
	}

	@Override
	public int getDefaultValue() {
		return super.getDefaultValue() | ICustomAppearence.DISP_CONJUGATED;
	}
}
