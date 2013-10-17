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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.dnd.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.dnd.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * The Class LinkMappingHelper is specialization of the link mapping helper for the Class diagram
 */
public class CustomLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		CommonSourceUMLSwitch umlSwitch = new CommonSourceUMLSwitch() {

			public java.util.Collection<?> caseAssociation(org.eclipse.uml2.uml.Association object) {

				java.util.Collection<?> ends = Collections.emptySet();
				
				// Binary associations only in this diagram.
				// Other expectation:
				// - property ends are typed by Classifiers
				// - property ends are type is not null
				
				if(object.getMemberEnds().size() == 2) {
					
					Property semanticTarget = object.getMemberEnds().get(1);
					
					// The proposed graphical target is a representation of the type of
					// the semantic source.
					Type sourceType = semanticTarget.getType();
					if ((sourceType != null) && (sourceType instanceof Classifier)) {
						ends = Arrays.asList(new EObject[]{sourceType});
					}
					
				} else {
					// TODO: log warning here - can only drop binary associations in this diagram...
				}
				
				return ends;
			};

			//			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
			//				return object.getEndTypes();
			//			};

			//			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
			//				return object.getGeneralizations();
			//			};

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
	public Collection<?> getTarget(Element link) {
		CommonTargetUMLSwitch umlSwitch = new CommonTargetUMLSwitch() {

			public java.util.Collection<?> caseAssociation(org.eclipse.uml2.uml.Association object) {
				
				java.util.Collection<?> ends = Collections.emptySet();
				
				// Binary associations only in this diagram.
				// Other expectation:
				// - property ends are typed by Classifiers
				// - property ends are type is not null
				
				if(object.getMemberEnds().size() == 2) {
					
					Property semanticSource = object.getMemberEnds().get(0);
					
					// The proposed graphical target is a representation of the type of
					// the semantic source.
					Type sourceType = semanticSource.getType();
					if ((sourceType != null) && (sourceType instanceof Classifier)) {
						ends = Arrays.asList(new EObject[]{sourceType});
					}
										
				} else {
					// TODO: log warning here - can only drop binary associations in this diagram...
				}
				
				return ends;
			};

			//			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
			//				return object.getEndTypes();
			//			};

			//			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
			//				return object.getGeneralizations();
			//			};

			public java.util.Collection<?> caseInterfaceRealization(org.eclipse.uml2.uml.InterfaceRealization object) {
				ArrayList<EObject> result = new ArrayList<EObject>();
				result.add(object.getContract());
				return result;
			};

		};
		return umlSwitch.doSwitch(link);
	}
}
