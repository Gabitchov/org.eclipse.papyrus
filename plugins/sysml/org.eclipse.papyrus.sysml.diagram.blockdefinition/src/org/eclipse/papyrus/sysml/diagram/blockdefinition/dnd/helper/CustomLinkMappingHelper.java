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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - 
 *  	refactor common behavior between diagrams, define only specific behavior
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.dnd.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.dnd.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.dnd.helper.LinkMappingHelper.CommonTargetUMLSwitch;

/**
 * The Class LinkMappingHelper is specialization of the link mapping helper for the Class diagram
 */
public class CustomLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(EObject link) {
		CommonSourceUMLSwitch umlSwitch = new CommonSourceUMLSwitch() {

			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
				return object.getGeneralizations();
			};

			public java.util.Collection<?> caseInterfaceRealization(org.eclipse.uml2.uml.InterfaceRealization object) {
				ArrayList<EObject> result = new ArrayList<EObject>();
				result.add(object.getImplementingClassifier());
				return result;
			};

		};
		return umlSwitch.doSwitch(link);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(EObject link) {
		CommonTargetUMLSwitch umlSwitch = new CommonTargetUMLSwitch() {

			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
				return object.getGeneralizations();
			};

			public java.util.Collection<?> caseInterfaceRealization(org.eclipse.uml2.uml.InterfaceRealization object) {
				ArrayList<EObject> result = new ArrayList<EObject>();
				result.add(object.getContract());
				return result;
			};

		};
		return umlSwitch.doSwitch(link);
	}
}
