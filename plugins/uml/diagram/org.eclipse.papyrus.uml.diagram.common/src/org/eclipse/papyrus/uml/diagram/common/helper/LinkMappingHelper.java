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
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * The Class LinkMappingHelper is used as a declaration of contract. This class
 * is used to express the mapping of link at semantic level. for a semantic what
 * is the source what is the target?
 */
public class LinkMappingHelper {

	/**
	 * Gets the source.
	 * 
	 * @param link
	 *        the link
	 * 
	 * @return the source
	 */
	// @unused
	public static Collection<?> getSource(Element link) {
		return getSource(link, new CommonSourceUMLSwitch());
	}

	/**
	 * Gets the source.
	 * 
	 * @param link
	 *        the link
	 * @param umlSwitch
	 *        the uml switch
	 * 
	 * @return the source
	 */
	public static Collection<?> getSource(Element link, CommonSourceUMLSwitch umlSwitch) {
		return umlSwitch.doSwitch(link);
	}

	/**
	 * Gets the source.
	 * 
	 * @param link
	 *        the link
	 * 
	 * @return the source
	 */
	// @unused
	public static Collection<?> getTarget(Element link) {
		return getTarget(link, new CommonTargetUMLSwitch());
	}

	/**
	 * Gets the source.
	 * 
	 * @param link
	 *        the link
	 * @param umlSwitch
	 *        the uml switch
	 * 
	 * @return the source
	 */
	public static Collection<?> getTarget(Element link, CommonTargetUMLSwitch umlSwitch) {
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
			ArrayList result = new ArrayList();
			result.add(object);
			return result;
		};

		@Override
		public Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
			return object.getClients();
		};

		@Override
		public java.util.Collection<?> caseGeneralization(org.eclipse.uml2.uml.Generalization object) {
			ArrayList result = new ArrayList();
			result.add(object.getOwner());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageMerge(org.eclipse.uml2.uml.PackageMerge object) {
			ArrayList result = new ArrayList();
			result.add(object.getReceivingPackage());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageImport(org.eclipse.uml2.uml.PackageImport object) {
			ArrayList result = new ArrayList();
			result.add(object.getImportingNamespace());
			return result;
		};

		@Override
		public Collection<?> caseInformationFlow(org.eclipse.uml2.uml.InformationFlow object) {
			return object.getInformationSources();
		};

		@Override
		public Collection<?> caseConnector(final Connector object) {
			final List<EObject> sources = new ArrayList<EObject>();
			for(final ConnectorEnd current : object.getEnds()) {
				final ConnectableElement role = current.getRole();
				if(role != null) {
					sources.add(role);
				}
			}
			return sources;
		}

		@Override
		public Collection<?> caseConstraint(Constraint object) {
			return Collections.singletonList(object);
		}

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
			ArrayList result = new ArrayList();
			result.add(object.getGeneral());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageMerge(org.eclipse.uml2.uml.PackageMerge object) {
			ArrayList result = new ArrayList();
			result.add(object.getMergedPackage());
			return result;
		};

		@Override
		public java.util.Collection<?> casePackageImport(org.eclipse.uml2.uml.PackageImport object) {
			ArrayList result = new ArrayList();
			result.add(object.getImportedPackage());
			return result;
		};

		@Override
		public Collection<?> caseInformationFlow(org.eclipse.uml2.uml.InformationFlow object) {
			return object.getInformationTargets();
		};

		@Override
		public Collection<?> caseConnector(final Connector object) {
			final List<EObject> targets = new ArrayList<EObject>();
			for(final ConnectorEnd current : object.getEnds()) {
				final ConnectableElement role = current.getRole();
				if(role != null) {
					targets.add(role);
				}
			}
			return targets;
		}

		@Override
		public Collection<?> caseConstraint(Constraint object) {
			final List<EObject> targets = new ArrayList<EObject>();
			targets.addAll(object.getConstrainedElements());
			return targets;
		}

		@Override
		public Collection<?> caseInterfaceRealization(InterfaceRealization object) {
			final List<EObject> targets = new ArrayList<EObject>();
			targets.addAll(object.getSuppliers());
			return targets;
		}
		@Override
		public Collection<?> defaultCase(org.eclipse.emf.ecore.EObject object) {
			return Collections.EMPTY_LIST;
		};
	}

}
