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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.utils;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

public class StereotypeUtils {

	protected static EPackage umlMetamodel = UMLPackage.eINSTANCE;

	protected static EPackage typesPackage = TypesPackage.eINSTANCE;

	/**
	 * Compute all the ecore UML metaclasses on which the stereotype can be applied
	 * 
	 * @param stereotype
	 * @param concreteClassesOnly
	 * @return
	 */
	public static List<EClass> getAllExtendableMetaclasses(Stereotype stereotype, boolean concreteClassesOnly) {
		EList<Class> extendedMetaclasses = stereotype.getAllExtendedMetaclasses();
		Set<EClass> allMetaclasses = new LinkedHashSet<EClass>();
		for(Class extendedMetaclass : extendedMetaclasses) {
			EClassifier UMLEClass = findEClass(extendedMetaclass);
			if(UMLEClass instanceof EClass) {
				allMetaclasses.addAll(getSubclassesOf((EClass)UMLEClass, concreteClassesOnly));
			}
		}

		return new LinkedList<EClass>(allMetaclasses);
	}

	/**
	 * Get the ecore UML metaclass corresponding to an {@link ExtensionDefinition}
	 * 
	 * @param extension
	 * @return
	 */
	public static EClassifier findBase(ExtensionDefinition extension) {
		for(Property member : extension.getExtension().getMemberEnds()) {
			if(!(member instanceof ExtensionEnd)) {
				return findEClass((Classifier)member.getType());
			}
		}
		return null;
	}

	/**
	 * Compute all the ecore UML metaclasses on which the extension applies
	 * 
	 * @param extension
	 * @param concreteClassesOnly
	 * @return
	 */
	public static List<EClass> getAllExtendableMetaclasses(Extension extension, boolean concreteClassesOnly) {
		Class extendedMetaclass = extension.getMetaclass();
		Set<EClass> allMetaclasses = new LinkedHashSet<EClass>();

		EClassifier UMLEClass = findEClass(extendedMetaclass);
		if(UMLEClass instanceof EClass) {
			allMetaclasses.addAll(getSubclassesOf((EClass)UMLEClass, concreteClassesOnly));
		}

		return new LinkedList<EClass>(allMetaclasses);
	}

	/**
	 * Get all the ecore subclasses of a UML metaclass
	 * 
	 * @param UMLEClass
	 * @param concreteClassesOnly
	 * @return
	 */
	protected static Collection<? extends EClass> getSubclassesOf(EClass UMLEClass, boolean concreteClassesOnly) {
		Set<EClass> subs = new LinkedHashSet<EClass>();

		if(UMLEClass != null) {
			if((concreteClassesOnly && !UMLEClass.isAbstract()) || !concreteClassesOnly) {
				subs.add(UMLEClass);
			}

			for(EClassifier classifier : umlMetamodel.getEClassifiers()) {
				if(classifier instanceof EClass) {
					EClass clazz = (EClass)classifier;

					if((concreteClassesOnly && !clazz.isAbstract()) || !concreteClassesOnly) {

						EList<EClass> supers = clazz.getEAllSuperTypes();
						if(supers.contains(UMLEClass)) {
							subs.add(clazz);
						}
					}
				}
			}
		}
		return subs;
	}

	/**
	 * Get the eClass in the UML metamodel from a UML classifier
	 * 
	 * @param type
	 * @return
	 */
	public static EClassifier findEClass(Classifier type) {
		for(EClassifier classifier : umlMetamodel.getEClassifiers()) {
			if(classifier.getName().equals(type.getName())) {
				return classifier;
			}
		}

		for(EClassifier classifier : typesPackage.getEClassifiers()) {
			if(classifier.getName().equals(type.getName())) {
				return classifier;
			}
		}

		return null;
	}

}
