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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.InstanceSpecificationLinkHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.NamedElementHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.ui.AssociationSelectionDialog;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InstanceSpecificationLinkCreateCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * use to construct the instance specification link between two instance
 * 
 */
public class CInstanceSpecificationLinkCreateCommand extends InstanceSpecificationLinkCreateCommand {

	protected HashSet<Association> commonAssociations;

	public CInstanceSpecificationLinkCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	@Override
	public boolean canExecute() {
		if(source != null && target == null) {
			//test if is an instanceSpecification
			if(source instanceof InstanceSpecification) {
				InstanceSpecification instance = (InstanceSpecification)source;
				//Is it associated to a classifier?
				if(instance.getClassifiers().size() > 0) {
					HashSet<Association> assoSource = new HashSet<Association>();
					Iterator<Classifier> iterator = instance.getClassifiers().iterator();
					while(iterator.hasNext()) {
						Classifier classifier = (Classifier)iterator.next();
						assoSource.addAll(classifier.getAssociations());
					}
					//how many association it linked?
					if(assoSource.size() > 0) {
						return true;
					}
				}
			}
			return false;
		}
		//source and target != null 
		//look for if it exist at least a common association between classifiers referenced between these instances
		if(source != null && target != null) {
			if(!(source instanceof InstanceSpecification)) {
				return false;
			}
			if(!(target instanceof InstanceSpecification)) {
				return false;
			}
			if(((InstanceSpecification)source).getClassifiers().size() == 0 || ((InstanceSpecification)target).getClassifiers().size() == 0) {
				return false;
			}
			HashSet<Association> assoSource = new HashSet<Association>();
			Iterator<Classifier> iterator = ((InstanceSpecification)source).getClassifiers().iterator();
			while(iterator.hasNext()) {
				Classifier classifier = (Classifier)iterator.next();
				assoSource.addAll(classifier.getAssociations());
			}
			HashSet<Association> assoTarget = new HashSet<Association>();
			iterator = ((InstanceSpecification)target).getClassifiers().iterator();
			while(iterator.hasNext()) {
				Classifier classifier = (Classifier)iterator.next();
				assoTarget.addAll(classifier.getAssociations());
			}
			assoSource.retainAll(assoTarget);
			commonAssociations = new HashSet<Association>();
			commonAssociations.addAll(assoSource);
			return (commonAssociations.size() > 0);
		}
		return false;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		AssociationSelectionDialog associationSelectionDialog;
		Association selectedAssociation = null;
		if(((InstanceSpecification)source).getClassifiers().size() > 0 && ((InstanceSpecification)target).getClassifiers().size() > 0) {
			//look for the good association
			associationSelectionDialog = new AssociationSelectionDialog(new Shell(), SWT.NATIVE, commonAssociations);
			associationSelectionDialog.open();
			selectedAssociation = associationSelectionDialog.getSelectedAssociation();
			//creation of the instance specification link
			// with a name a container, and set the source and target
			InstanceSpecification instanceSpecification = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInstanceSpecification();
			getContainer().getPackagedElements().add(instanceSpecification);
			instanceSpecification.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(instanceSpecification.getOwner(), instanceSpecification.eClass()));
			instanceSpecification.getClassifiers().add(selectedAssociation);
			InstanceSpecificationLinkHelper.addEnd(instanceSpecification, ((InstanceSpecification)source));
			InstanceSpecificationLinkHelper.addEnd(instanceSpecification, ((InstanceSpecification)target));
			//Creation of slots into the good instance by taking in account the  association
			Iterator<Property> proIterator = selectedAssociation.getMemberEnds().iterator();
			while(proIterator.hasNext()) {
				Property property = (Property)proIterator.next();
				Slot slot = UMLFactory.eINSTANCE.createSlot();
				slot.setDefiningFeature(property);
				if(((InstanceSpecification)source).getClassifiers().contains(property.getOwner())) {
					((InstanceSpecification)source).getSlots().add(slot);
					associateValue(((InstanceSpecification)target), slot, property.getType());
				} else if(((InstanceSpecification)target).getClassifiers().contains(property.getOwner())) {
					((InstanceSpecification)target).getSlots().add(slot);
					associateValue(((InstanceSpecification)source), slot, property.getType());
				} else {
					instanceSpecification.getSlots().add(slot);
					if(((InstanceSpecification)source).getClassifiers().contains(property.getType())) {
						associateValue(((InstanceSpecification)source), slot, property.getType());
					} else {
						associateValue(((InstanceSpecification)target), slot, property.getType());
					}
				}
			}
			return CommandResult.newOKCommandResult(instanceSpecification);
		}
		return CommandResult.newCancelledCommandResult();
	}

	/**
	 * create an instanceValue for the slot (owner) with the reference to InstanceSpecification and the good type
	 * 
	 * @param instanceSpecification
	 *        that is referenced by the instanceValue
	 * @param owner
	 *        of the instance value
	 * @param type
	 *        of the instanceValue
	 * @return a instanceValue
	 */
	protected InstanceValue associateValue(InstanceSpecification instanceSpecification, Slot owner, Type type) {
		InstanceValue iv = UMLFactory.eINSTANCE.createInstanceValue();
		iv.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(owner, iv.eClass()));
		iv.setType(type);
		iv.setInstance(instanceSpecification);
		owner.getValues().add(iv);
		return iv;
	}
}
