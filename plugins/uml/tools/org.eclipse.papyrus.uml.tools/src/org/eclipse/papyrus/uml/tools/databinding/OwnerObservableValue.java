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
package org.eclipse.papyrus.uml.tools.databinding;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StructuredClassifier;
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
public class OwnerObservableValue extends AbstractObservableValue implements IChangeListener, AggregatedObservable, CommandBasedObservableValue {

	private Property memberEnd;

	private EditingDomain domain;

	private String currentValue;

	private final IObservableList navigableEndsObservableList;

	/**
	 * Owned by classifier
	 */
	public static String CLASSIFIER = "Classifier"; //$NON-NLS-1$

	/**
	 * Owned by association
	 */
	public static String ASSOCIATION = "Association"; //$NON-NLS-1$

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
		navigableEndsObservableList = EMFProperties.list(UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd()).observe(memberEnd.getAssociation());
		navigableEndsObservableList.addChangeListener(this);
	}

	public void handleChange(ChangeEvent event) {
		fireValueChange(Diffs.createValueDiff(currentValue, doGetValue()));
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
		Command command = getCommand(value);
		domain.getCommandStack().execute(command);
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		navigableEndsObservableList.removeChangeListener(this);
		navigableEndsObservableList.dispose();
	}

	public Command getCommand(Object value) {
		if(value instanceof String) {
			String owner = (String)value;
			boolean isOwnedByAssociation = ASSOCIATION.equals(owner);

			Association association = memberEnd.getAssociation();

			if(association.getMemberEnds().size() > 2) {
				Activator.log.warn("Cannot change End owner for n-ary associations"); //$NON-NLS-1$
				return UnexecutableCommand.INSTANCE;
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

				EStructuralFeature ownedAttributeFeature = getFeatureForType(ownerType);
				if(ownedAttributeFeature != null) {

					List<Property> attributeList = new ArrayList<Property>();
					attributeList.addAll((EList<Property>)ownerType.eGet(ownedAttributeFeature));
					attributeList.add(memberEnd);

					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(ownerType);
					if(provider != null) {
						SetRequest request = new SetRequest(ownerType, ownedAttributeFeature, memberEnd);

						ICommand createGMFCommand = provider.getEditCommand(request);

						command = new GMFtoEMFCommandWrapper(createGMFCommand);
					}
				}
			}

			if(command != null) {
				this.currentValue = owner;
			} else {
				Activator.log.warn("Cannot modify the memberEnd owner");
			}
			return command;
		}

		return UnexecutableCommand.INSTANCE;
	}

	private EStructuralFeature getFeatureForType(Type type) {
		if(type instanceof StructuredClassifier) {
			return UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
		}
		if(type instanceof Interface) {
			return UMLPackage.eINSTANCE.getInterface_OwnedAttribute();
		}
		if(type instanceof DataType) {
			return UMLPackage.eINSTANCE.getDataType_OwnedAttribute();
		}
		if(type instanceof Artifact) {
			return UMLPackage.eINSTANCE.getArtifact_OwnedAttribute();
		}
		if(type instanceof Signal) {
			return UMLPackage.eINSTANCE.getSignal_OwnedAttribute();
		}

		//Unknown type : we try to find the feature reflexively
		Activator.log.warn("Unknown type : " + type.eClass().getName());
		EStructuralFeature feature = type.eClass().getEStructuralFeature("ownedAttribute"); //$NON-NLS-1$
		if(feature == null) {
			Activator.log.warn("Cannot find a valid feature for type " + type.eClass().getName());
		}
		return feature;
	}

	public AggregatedObservable aggregate(IObservable observable) {
		try {
			return new AggregatedPapyrusObservableValue(domain, this, observable);
		} catch (IllegalArgumentException ex) {
			return null; //The observable cannot be aggregated
		}
	}

	public boolean hasDifferentValues() {
		return false;
	}
}
