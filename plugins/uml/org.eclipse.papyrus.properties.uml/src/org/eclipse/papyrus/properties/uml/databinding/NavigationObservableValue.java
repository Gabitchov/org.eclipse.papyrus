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
package org.eclipse.papyrus.properties.uml.databinding;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;


public class NavigationObservableValue extends AbstractObservableValue {

	private Property memberEnd;

	private EditingDomain domain;

	public NavigationObservableValue(EObject source, EditingDomain domain) {
		memberEnd = (Property)source;
		this.domain = domain;
	}

	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Boolean doGetValue() {
		return memberEnd.getAssociation().getNavigableOwnedEnds().contains(memberEnd);
	}

	@Override
	protected void doSetValue(Object value) {
		if(value instanceof Boolean) {
			boolean isNavigable = (Boolean)value;

			Command command = null;

			Association association = memberEnd.getAssociation();

			EStructuralFeature navigableFeature = association.eClass().getEStructuralFeature(UMLPackage.ASSOCIATION__NAVIGABLE_OWNED_END);

			List<Property> navigableEnds = new ArrayList<Property>();
			navigableEnds.addAll(association.getNavigableOwnedEnds());
			if(isNavigable) {
				navigableEnds.add(memberEnd);
			} else {
				navigableEnds.remove(memberEnd);
			}

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(association);
			if(provider != null) {
				SetRequest request = new SetRequest(association, navigableFeature, navigableEnds);

				ICommand createGMFCommand = provider.getEditCommand(request);

				command = new GMFtoEMFCommandWrapper(createGMFCommand);
			}

			domain.getCommandStack().execute(command);
		}
	}
}
