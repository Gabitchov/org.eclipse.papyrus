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
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Element;

/**
 * The Class LinkMappingHelper is specialization of the link mapping helper for the Class diagram
 */
public class ClassLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * SingletonHolder is loaded at the first execution of getInstance() method
	 */
	private static class SingletonHolder {

		private final static ClassLinkMappingHelper instance = new ClassLinkMappingHelper();
	}

	/**
	 * Gets the single instance of ClassLinkMappingHelper.
	 * 
	 * @return single instance of ClassLinkMappingHelper
	 */
	public static ClassLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private ClassLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseElementImport(org.eclipse.uml2.uml.ElementImport object) {
				ArrayList result = new ArrayList();
				result.add(object.getImportingNamespace());
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
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			public java.util.Collection<?> caseElementImport(org.eclipse.uml2.uml.ElementImport object) {
				ArrayList result = new ArrayList();
				result.add(object.getImportedElement());
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

			public java.util.Collection<?> caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication object) {
				ArrayList result = new ArrayList();
				result.add(object.getAppliedProfile());
				return result;
			};

			public java.util.Collection<?> caseTemplateBinding(org.eclipse.uml2.uml.TemplateBinding object) {
				ArrayList result = new ArrayList();
				result.add(object.getSignature().getOwner());
				return result;
			};
		});
	}
}
