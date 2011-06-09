/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/


package org.eclipse.papyrus.diagram.profile.custom.policies;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.profile.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.profile.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

/**
 * this class provides the tests to know if an Extension can be created!
 */
public class CUMLBaseItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected CUMLBaseItemSemanticEditPolicy(IElementType elementType) {
		super(elementType);
	}

	public static class LinkConstraints extends UMLBaseItemSemanticEditPolicy.LinkConstraints {

		/**
		 * @generated
		 */
		public static boolean canCreateExtension_1013(Package container, Stereotype source, Class target) {
			return canExistExtension_1013(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistExtension_1013(Package container, Stereotype source, Class target) {
			try {

				//This tests can't be executed in UMLBaseItemSemanticEditPolicy, because the source is a Stereotype and not a Property

				/**
				 * UML doesn't allows to extend the Stereotype metaclass (UML Superstructure Specification, v2.2, p.656)
				 */
				//ExtensionSource
				if(!(source instanceof org.eclipse.uml2.uml.Stereotype)) {
					return false;
				}

				//ExtensionTarget
				if(target != null) {
					if(!(target instanceof org.eclipse.uml2.uml.Class)) {
						return false;
					}
					String metaclassQName = target.getQualifiedName();
					if(metaclassQName.equals("uml::Stereotype")) { //$NON-NLS-1$
						return false;
					}
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}
	}
}
