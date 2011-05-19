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

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An ObservableValue for manipulating the UML Owner property.
 * The owner property is a virtual property, represented as an enumeration,
 * which can have two values : Association (Owned by Association) or Classifier
 * (Owned by Classifier)
 * 
 * This value can be determined by the following query :
 * if self.association.ownedEnd->contains(self) then 'Association' else 'Classifier' endif
 * 
 * This value doesn't make sense for n-ary associations, when n > 2.
 * 
 * @author Camille Letavernier
 */
public class OwnerObservableValue extends AbstractObservableValue {

	private Property memberEnd;

	private EditingDomain domain;

	private String currentValue;

	/**
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject (Property) which the ownership is being edited
	 * @param domain
	 *        The Editing Domain on which the commands will be executed
	 */
	public OwnerObservableValue(EObject source, EditingDomain domain) {
		this.memberEnd = (Property)source;
		this.domain = domain;
		IObservableList navigableEndsObservableList = EMFProperties.list(UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd()).observe(memberEnd.getAssociation());
		navigableEndsObservableList.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				fireValueChange(Diffs.createValueDiff(currentValue, doGetValue()));
			}

		});
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		return memberEnd.getAssociation().getOwnedEnds().contains(memberEnd) ? "Association" : "Classifier"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	protected void doSetValue(Object value) {
		if(value instanceof String) {
			String owner = (String)value;
			boolean isOwnedByAssociation = "Association".equals(owner); //$NON-NLS-1$

			Association association = memberEnd.getAssociation();

			if(association.getMemberEnds().size() > 2) {
				Activator.log.warn("Cannot change End owner for n-ary associations"); //$NON-NLS-1$
				return;
			}

			//Classifier classifier = memberEnd.getClass_();
			//EStructuralFeature ownedEndFeature = association.eClass().getEStructuralFeature(UMLPackage.ASSOCIATION__OWNED_END);

			Command command = null;

			if(isOwnedByAssociation) { //Owned by Association
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(association);
				if(provider != null) {
					EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_OwnedEnd();
					List<Property> attributeList = new ArrayList<Property>();
					attributeList.addAll(association.getOwnedEnds());
					attributeList.add(memberEnd);
					//association.eSet(feature, attributeList);

					SetRequest request = new SetRequest(association, feature, attributeList);

					ICommand createGMFCommand = provider.getEditCommand(request);

					command = new GMFtoEMFCommandWrapper(createGMFCommand);
				}
			} else { //Owned by Classifier

				Type ownerType;
				List<Type> ownerList = association.getEndTypes();

				if(ownerList.get(0).equals(memberEnd.getType()) && ownerList.size() > 1) {
					ownerType = ownerList.get(1);
				} else {
					ownerType = ownerList.get(0);
				}

				EStructuralFeature feature = UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
				if(ownerType instanceof org.eclipse.uml2.uml.Class) {
					List<Property> attributeList = new ArrayList<Property>();
					attributeList.addAll(((org.eclipse.uml2.uml.Class)ownerType).getAttributes());
					attributeList.add(memberEnd);

					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(ownerType);
					if(provider != null) {
						SetRequest request = new SetRequest(ownerType, feature, memberEnd);

						ICommand createGMFCommand = provider.getEditCommand(request);

						command = new GMFtoEMFCommandWrapper(createGMFCommand);
					}
				}
			}

			this.currentValue = owner;
			domain.getCommandStack().execute(command);
		}
	}
}
