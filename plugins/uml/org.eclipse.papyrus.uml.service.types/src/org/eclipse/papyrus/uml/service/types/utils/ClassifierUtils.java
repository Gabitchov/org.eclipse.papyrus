/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * Utility class for Classifiers.
 */
public class ClassifierUtils {

	/**
	 * This method provides a switch to ease the addition of a new Property in a Classifier.
	 * 
	 * @param classifier
	 *        the parent classifier.
	 * @param property
	 *        the contained property.
	 * @return false if the addition fails.
	 */
	public static boolean addOwnedAttribute(Classifier classifier, Property property) {
		AddOwnedAttributeSwitch classifierSwitch = new AddOwnedAttributeSwitch(property);
		return classifierSwitch.doSwitch(classifier);
	}

	/**
	 * This method provides a switch to ease the addition of a new Property in a Classifier.
	 * 
	 * @param classifier
	 *        the parent classifier.
	 * @param property
	 *        the contained property.
	 * @return false if the addition fails.
	 */
	public static List<Property> getOwnedAttributes(Classifier classifier) {
		GetOwnedAttributesSwitch classifierSwitch = new GetOwnedAttributesSwitch();
		return classifierSwitch.doSwitch(classifier);
	}

	/**
	 * Switch implementation for Property addition.
	 */
	private static class AddOwnedAttributeSwitch extends UMLSwitch<Boolean> {

		private final Property property;

		public AddOwnedAttributeSwitch(Property property) {
			super();

			this.property = property;
		}

		@Override
		public Boolean caseArtifact(Artifact object) {
			object.getOwnedAttributes().add(property);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseDataType(DataType object) {
			object.getOwnedAttributes().add(property);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseInterface(Interface object) {
			object.getOwnedAttributes().add(property);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseSignal(Signal object) {
			object.getOwnedAttributes().add(property);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseStructuredClassifier(StructuredClassifier object) {
			object.getOwnedAttributes().add(property);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseClass(Class object) {
			object.getOwnedAttributes().add(property);
			return Boolean.TRUE;
		}

		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.FALSE;
		}
	};

	/**
	 * Switch implementation for Property addition.
	 */
	private static class GetOwnedAttributesSwitch extends UMLSwitch<List<Property>> {

		public GetOwnedAttributesSwitch() {
			super();
		}

		@Override
		public List<Property> caseArtifact(Artifact object) {
			return object.getOwnedAttributes();
		}

		@Override
		public List<Property> caseDataType(DataType object) {
			return object.getOwnedAttributes();
		}

		@Override
		public List<Property> caseInterface(Interface object) {
			return object.getOwnedAttributes();
		}

		@Override
		public List<Property> caseSignal(Signal object) {
			return object.getOwnedAttributes();
		}

		@Override
		public List<Property> caseStructuredClassifier(StructuredClassifier object) {
			return object.getOwnedAttributes();
		}

		@Override
		public List<Property> caseClass(Class object) {
			return object.getOwnedAttributes();
		}

		@Override
		public List<Property> defaultCase(EObject object) {
			return new ArrayList<Property>();
		}
	};

}
