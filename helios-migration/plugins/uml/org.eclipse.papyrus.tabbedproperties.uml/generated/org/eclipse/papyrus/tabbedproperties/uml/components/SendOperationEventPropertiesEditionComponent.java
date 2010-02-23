/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.papyrus.tabbedproperties.uml.parts.SendOperationEventPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.SendOperationEvent;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class SendOperationEventPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private SendOperationEventPropertiesEditionPart basePart;

	/**
	 * The SendOperationEventBasePropertiesEditionComponent sub component
	 */
	protected SendOperationEventBasePropertiesEditionComponent sendOperationEventBasePropertiesEditionComponent;

	/**
	 * The ElementPropertiesEditionComponent sub component
	 */
	protected ElementPropertiesEditionComponent elementPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param sendOperationEvent
	 *        the EObject to edit
	 */
	public SendOperationEventPropertiesEditionComponent(EObject sendOperationEvent, String editing_mode) {
		super(editing_mode);
		if(sendOperationEvent instanceof SendOperationEvent) {
			sendOperationEventBasePropertiesEditionComponent = new SendOperationEventBasePropertiesEditionComponent(sendOperationEvent, editing_mode);
			addSubComponent(sendOperationEventBasePropertiesEditionComponent);
			elementPropertiesEditionComponent = new ElementPropertiesEditionComponent(sendOperationEvent, editing_mode);
			addSubComponent(elementPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent# getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if("Base".equals(key)) {
			basePart = (SendOperationEventPropertiesEditionPart)sendOperationEventBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent# setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if(UMLViewsRepository.SendOperationEvent.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (SendOperationEventPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent #initPart(java.lang.Class, int,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if(key == UMLViewsRepository.SendOperationEvent.class) {
			super.initPart(key, kind, element, allResource);
		}
		if(key == UMLViewsRepository.Comments.class) {
			super.initPart(key, kind, element, allResource);

		}
	}
}
