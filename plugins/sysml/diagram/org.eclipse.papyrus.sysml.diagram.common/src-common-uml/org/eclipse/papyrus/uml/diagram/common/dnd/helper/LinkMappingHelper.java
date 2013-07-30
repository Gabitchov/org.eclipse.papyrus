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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - refactor common behavior between diagrams
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.dnd.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.ILinkMappingHelper;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * Original class {@link org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper} slightly
 * modified to use EObject instead of UML Element in its interface.
 */
public class LinkMappingHelper implements ILinkMappingHelper {

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(EObject link) {
		CommonSourceUMLSwitch umlSwitch = new CommonSourceUMLSwitch();
		return umlSwitch.doSwitch(link);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(EObject link) {
		CommonTargetUMLSwitch umlSwitch = new CommonTargetUMLSwitch();
		return umlSwitch.doSwitch(link);
	}

	/**
	 * Contains diagrams common behavior that need to be redefined
	 * 
	 * @author eperico
	 */
	public static class CommonSourceUMLSwitch extends UMLSwitch<Collection<?>> {

		@Override
		public java.util.Collection<?> caseAssociation(org.eclipse.uml2.uml.Association object) {
			return object.getEndTypes();
		};

		@Override
		public java.util.Collection<?> caseComment(org.eclipse.uml2.uml.Comment object) {
			ArrayList<EObject> result = new ArrayList<EObject>();
			result.add(object);
			return result;
		};

		@Override
		public Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
			return object.getClients();
		};

		@Override
		public java.util.Collection<?> caseGeneralization(org.eclipse.uml2.uml.Generalization object) {
			ArrayList<EObject> result = new ArrayList<EObject>();
			result.add(object.getOwner());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageMerge(org.eclipse.uml2.uml.PackageMerge object) {
			ArrayList<EObject> result = new ArrayList<EObject>();
			result.add(object.getReceivingPackage());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageImport(org.eclipse.uml2.uml.PackageImport object) {
			ArrayList<EObject> result = new ArrayList<EObject>();
			result.add(object.getImportingNamespace());
			return result;
		};

		@Override
		public Collection<?> caseInformationFlow(org.eclipse.uml2.uml.InformationFlow object) {
			return object.getInformationSources();
		};

		@Override
		public Collection<?> defaultCase(org.eclipse.emf.ecore.EObject object) {
			return Collections.EMPTY_LIST;
		};
	}

	/**
	 * Contains diagrams common behavior that need to be redefined
	 * 
	 * @author eperico
	 */
	public static class CommonTargetUMLSwitch extends UMLSwitch<Collection<?>> {

		@Override
		public java.util.Collection<?> caseAssociation(org.eclipse.uml2.uml.Association object) {
			return object.getEndTypes();
		};

		@Override
		public java.util.Collection<?> caseComment(org.eclipse.uml2.uml.Comment object) {
			return object.getAnnotatedElements();
		};

		@Override
		public Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
			return object.getSuppliers();
		};

		@Override
		public java.util.Collection<?> caseGeneralization(org.eclipse.uml2.uml.Generalization object) {
			ArrayList<EObject> result = new ArrayList<EObject>();
			result.add(object.getGeneral());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageMerge(org.eclipse.uml2.uml.PackageMerge object) {
			ArrayList<EObject> result = new ArrayList<EObject>();
			result.add(object.getMergedPackage());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageImport(org.eclipse.uml2.uml.PackageImport object) {
			ArrayList<EObject> result = new ArrayList<EObject>();
			result.add(object.getImportedPackage());
			return result;
		};

		@Override
		public Collection<?> caseInformationFlow(org.eclipse.uml2.uml.InformationFlow object) {
			return object.getInformationTargets();
		};

		@Override
		public Collection<?> defaultCase(org.eclipse.emf.ecore.EObject object) {
			return Collections.EMPTY_LIST;
		};
	}
}
