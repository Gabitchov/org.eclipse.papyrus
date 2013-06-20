/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.common.editpolicies;



import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.PropertyLabelEditPolicy;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;


public class CustomPropertyLabelEditPolicy extends PropertyLabelEditPolicy {


	public final static int DEFAULT_ROBOTML_PROPERTY = ICustomAppearence.DISP_NAME | ICustomAppearence.DISP_TYPE;

	@Override
	public int getDefaultDisplayValue() {
		// TODO Auto-generated method stub
		return DEFAULT_ROBOTML_PROPERTY;
	}

	//	@Override
	//	public int getCurrentDisplayValue() {
	//		// TODO Auto-generated method stub
	//		 return DEFAULT_ROBOTML_PROPERTY;
	//	}



}
