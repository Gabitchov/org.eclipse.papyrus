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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.constraints;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.utils.DataTypeUtil;

/**
 * Matches EObjects which are instances of UML Datatype
 * (e.g. instances of DataTypes used in Profile Definition)
 * 
 * @author Camille Letavernier
 */
public class IsUMLDatatypeInstance extends AbstractConstraint {

	@Override
	protected boolean equivalent(Constraint constraint) {
		return constraint instanceof IsUMLDatatypeInstance;
	}

	@Override
	protected boolean match(Object selection) {
		EObject selectedElement = EMFHelper.getEObject(selection);

		if(selectedElement == null) {
			return false;
		}

		EClass definition = selectedElement.eClass();
		if(definition == null) {
			return false;
		}

		return DataTypeUtil.isDataTypeDefinition(definition);
	}

}
