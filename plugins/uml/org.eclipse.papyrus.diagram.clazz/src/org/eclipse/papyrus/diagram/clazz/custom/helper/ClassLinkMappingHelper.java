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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * The Class LinkMappingHelper is specialization of the link mapping helper for the Class diagram
 */
public class ClassLinkMappingHelper extends LinkMappingHelper {

	/**
	 * Gets the source.
	 * 
	 * @param link
	 *            the link
	 * 
	 * @return the source
	 */
	public static Collection<?> getSource(Element link) {
		return new UMLSwitch<Collection<?>>() {

			public java.util.Collection<?> caseAssociation(org.eclipse.uml2.uml.Association object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseComment(org.eclipse.uml2.uml.Comment object) {
				ArrayList result = new ArrayList();
				result.add(object);
				return result;
			};

			public Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
				return object.getClients();
			};

			public java.util.Collection<?> caseElementImport(org.eclipse.uml2.uml.ElementImport object) {
				ArrayList result = new ArrayList();
				result.add(object.getImportingNamespace());
				return result;
			};

			public java.util.Collection<?> caseGeneralization(org.eclipse.uml2.uml.Generalization object) {
				ArrayList result = new ArrayList();
				result.add(object.getOwner());
				return result;
			};

			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
				return object.getGeneralizations();
			};

			public java.util.Collection<?> caseInterfaceRealization(org.eclipse.uml2.uml.InterfaceRealization object) {
				ArrayList result = new ArrayList();
				result.add(object.getImplementingClassifier());
				return result;

			};

			public java.util.Collection<?> casePackageMerge(org.eclipse.uml2.uml.PackageMerge object) {
				ArrayList result = new ArrayList();
				result.add(object.getReceivingPackage());
				return result;
			};

			public java.util.Collection<?> caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication object) {
				ArrayList result = new ArrayList();
				result.add(object.getApplyingPackage());
				return result;
			};

			public java.util.Collection<?> caseTemplateBinding(org.eclipse.uml2.uml.TemplateBinding object) {
				ArrayList result = new ArrayList();
				result.add(object.getBoundElement());
				return result;
			};

			public Collection<?> defaultCase(org.eclipse.emf.ecore.EObject object) {
				return Collections.EMPTY_LIST;
			};
		}.doSwitch(link);
	}

	/**
	 * Gets the target.
	 * 
	 * @param link
	 *            the link
	 * 
	 * @return the target
	 */
	public static Collection<?> getTarget(Element link) {
		return new UMLSwitch<Collection<?>>() {

			public java.util.Collection<?> caseAssociation(org.eclipse.uml2.uml.Association object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseComment(org.eclipse.uml2.uml.Comment object) {
				return object.getAnnotatedElements();
			};

			public Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
				return object.getSuppliers();
			};

			public java.util.Collection<?> caseElementImport(org.eclipse.uml2.uml.ElementImport object) {
				ArrayList result = new ArrayList();
				result.add(object.getImportedElement());
				return result;
			};

			public java.util.Collection<?> caseGeneralization(org.eclipse.uml2.uml.Generalization object) {
				ArrayList result = new ArrayList();
				result.add(object.getGeneral());
				return result;
			};

			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
				return object.getGeneralizations();
			};

			public java.util.Collection<?> caseInterfaceRealization(org.eclipse.uml2.uml.InterfaceRealization object) {
				ArrayList result = new ArrayList();
				result.add(object.getContract());
				return result;

			};

			public java.util.Collection<?> casePackageMerge(org.eclipse.uml2.uml.PackageMerge object) {
				ArrayList result = new ArrayList();
				result.add(object.getMergedPackage());
				return result;
			};

			public java.util.Collection<?> caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication object) {
				ArrayList result = new ArrayList();
				result.add(object.getAppliedProfile());
				return result;
			};

			public java.util.Collection<?> caseTemplateBinding(org.eclipse.uml2.uml.TemplateBinding object) {
				return object.getTargets();
			};

			public Collection<?> defaultCase(org.eclipse.emf.ecore.EObject object) {
				return Collections.EMPTY_LIST;
			};
		}.doSwitch(link);
	}
}
