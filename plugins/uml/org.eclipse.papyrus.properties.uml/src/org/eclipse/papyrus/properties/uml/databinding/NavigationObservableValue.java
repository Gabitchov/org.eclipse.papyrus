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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An ObservableValue for manipulating the UML Navigable property.
 * The navigable property is a virtual property, represented as a Boolean.
 * 
 * @author Camille Letavernier
 */
public class NavigationObservableValue extends AbstractObservableValue {

	private Property memberEnd;

	private EditingDomain domain;

	private boolean currentValue;

	/**
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject (Property) which the navigability is being edited
	 * @param domain
	 *        The Editing Domain on which the commands will be executed
	 */
	public NavigationObservableValue(EObject source, EditingDomain domain) {
		memberEnd = (Property)source;
		this.domain = domain;
		IObservableList ownerObservableList = EMFProperties.list(UMLPackage.eINSTANCE.getAssociation_OwnedEnd()).observe(memberEnd.getAssociation());
		ownerObservableList.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				fireValueChange(Diffs.createValueDiff(currentValue, doGetValue()));
			}

		});
	}

	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Boolean doGetValue() {
		return memberEnd.isNavigable();
	}

	@Override
	protected void doSetValue(Object value) {
		if(value instanceof Boolean) {
			boolean isNavigable = (Boolean)value;
			if(memberEnd.isNavigable() == isNavigable) {
				return;
			}

			Association association = memberEnd.getAssociation();

			List<Property> navigableEnds = new ArrayList<Property>();
			navigableEnds.addAll(association.getNavigableOwnedEnds());

			List<SetRequest> setRequests = new LinkedList<SetRequest>();

			if(isNavigable) {
				navigableEnds.add(memberEnd);
			} else {
				if(memberEnd.getOwningAssociation() == null && memberEnd.getOwner() instanceof Classifier) {
					List<Property> ownedEnds = new LinkedList<Property>();
					ownedEnds.addAll(association.getOwnedEnds());
					ownedEnds.add(memberEnd);
					setRequests.add(new SetRequest(association, UMLPackage.eINSTANCE.getAssociation_OwnedEnd(), ownedEnds));
				}
				if(navigableEnds.contains(memberEnd)) {
					navigableEnds.remove(memberEnd);
				}
			}

			EStructuralFeature navigableFeature = UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd();
			setRequests.add(new SetRequest(association, navigableFeature, navigableEnds));

			CompoundCommand command = null;

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(association);
			if(provider != null) {

				command = new CompoundCommand();

				for(SetRequest request : setRequests) {
					ICommand createGMFCommand = provider.getEditCommand(request);
					command.append(new GMFtoEMFCommandWrapper(createGMFCommand));
				}
			}

			currentValue = isNavigable;
			domain.getCommandStack().execute(command);
		}
	}
}
