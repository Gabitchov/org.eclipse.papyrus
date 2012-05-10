/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A Factory for building {@link StereotypeModelElement}s
 * 
 * Problem : There may be conflicts when more than one stereotype is applied, when
 * retrieving properties of a common sub-stereotype. There is currently no way to
 * distinguish the two stereotypes, as it is the name of the subtype that is used
 * in such a case.
 * For example, if B inherits A and C inherits A, and A has a property "name", the
 * propertyPath in the XWT File will be : A:name
 * If the UML Element has both stereotypes B and C, we don't know if A:name corresponds
 * to B:name or C:name
 * 
 * TODO : enable the framework to handle B:name and C:name (Currently not possible,
 * as "name" is not directly a property of B nor C)
 * The problem probably comes from the Stereotype generator, which uses the same
 * inheritance mechanism as the Ecore generator, and not from the framework itself
 * 
 * @author Camille Letavernier
 */
public class StereotypeModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object source, DataContextElement context) {
		Element umlElement = UMLUtil.resolveUMLElement(source);

		if(umlElement != null) {
			Stereotype stereotype = UMLUtil.getAppliedStereotype(umlElement, getQualifiedName(context), false);
			EObject stereotypeApplication = umlElement.getStereotypeApplication(stereotype);

			if(stereotypeApplication == null) {
				Activator.log.warn("Stereotype " + getQualifiedName(context) + " is not applied on " + umlElement); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				EditingDomain domain = EMFHelper.resolveEditingDomain(stereotypeApplication);

				return new StereotypeModelElement(stereotypeApplication, stereotype, domain);
			}
		}

		return null;
	}

	/**
	 * Returns the DataContextElement's qualified name (Which should correspond
	 * to the stereotype's qualified name)
	 * 
	 * @param context
	 *        The DataContextElement representing the Stereotype
	 * @return
	 *         The DataContextElement's name, which is also the Stereotype's qualified name
	 */
	protected String getQualifiedName(DataContextElement context) {
		if(context.getPackage() == null) {
			return context.getName();
		} else {
			return getQualifiedName(context.getPackage()) + "::" + context.getName(); //$NON-NLS-1$
		}
	}
}
