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
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.PortUtil;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;


public class PortLabelHelper extends PropertyLabelHelper {
	
	// Einstance
		private static PortLabelHelper labelHelper;

		public static PortLabelHelper getInstance() {
			if(labelHelper == null) {
				labelHelper = new PortLabelHelper();
			}
			return labelHelper;
		}
		protected PortLabelHelper(){
			super();
			masks.put(ICustomAppearence.DISP_CONJUGATED, "Conjugated");
		}
		
		/**
		 * Computes the label that should be displayed by the figure managed by this
		 * edit part.
		 * 
		 * @param editPart
		 *        the edit part that controls the {@link Property} to be
		 *        displayed
		 * @return the label corresponding to the specific display of the property
		 *         ("default" display given by preferences or specific display given
		 *         by eAnnotation).
		 */
		protected String elementLabel(GraphicalEditPart editPart) {
			int displayValue = ICustomAppearence.DEFAULT_UML_PORT;

			IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
			if(policy != null) {
				displayValue = policy.getCurrentDisplayValue();
			}
			Port elem = getUMLElement(editPart);
			if(elem != null) {
				return PortUtil.getCustomLabel(elem, displayValue);
			}
			return "";
		}


		/**
		 * {@inheritDoc}
		 */
		public Port getUMLElement(GraphicalEditPart editPart) {
			if(editPart.getModel() instanceof View) {
				View view = (View)editPart.getModel();
				if(view.getElement() instanceof Port) {
					return (Port)view.getElement();
				}
			}
			return null;
		}
}
