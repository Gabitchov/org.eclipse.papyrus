/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this class is used to help design to code the managment of Association
 * 
 * 
 */
public class AssociationHelper {

	public static int source = 0;

	public static int target = 1;

	/**
	 * use to change the type of the end with the new type
	 * 
	 * @param end
	 *        source or target?
	 * @param association
	 *        the association that is reconnected
	 * @param newType
	 *        the new source or the new target
	 * @return the CommandResult
	 */
	public static CommandResult reconnect(int end, Association association, Type newType) {
		((Property)association.getMemberEnds().get(end)).setType(newType);

		return CommandResult.newOKCommandResult(association);
	}

	/**
	 * Creates a new aggregation kind modification command
	 * 
	 * @param property
	 *        the property to modify
	 * @param aggregationKind
	 *        the new {@link AggregationKind} to set
	 * @return an {@link IUndoableOperation} that will perform the modification
	 */
	public static IUndoableOperation createSetAggregationCommand(Property property, AggregationKind aggregationKind) {
		EStructuralFeature feature = UMLPackage.eINSTANCE.getProperty_Aggregation();
		SetRequest setRequest = new SetRequest(property, feature, aggregationKind);
		SetValueCommand setValueCommand = new SetValueCommand(setRequest);
		return setValueCommand;
	}

	/**
	 * Creates the command to set the owner of a given property in an
	 * association
	 * 
	 * @param association
	 *        the association to modify
	 * @param property
	 *        the property to modify
	 * @param belongsToClass
	 *        boolean set to <code>true</code> if the property belongs to
	 *        the class, <code>false</code> if it belongs to the association
	 * @return the command that will perform modifications or <code>null</code>!
	 */
	public static IUndoableOperation createSetOwnerCommand(Association association, Property property, boolean belongsToClass) {
		Type owner = null;
		if(belongsToClass) {
			// it already belongs to the right component, does not change...
			if(!(property.getOwner() instanceof Association)) {
				return null;
			} else {
				// look for the owner of the property to Set
				List<Type> ownerList = association.getEndTypes();
				if(ownerList.get(0).equals(property.getType()) && ownerList.size() > 1) {
					owner = (Type)ownerList.get(1);
				} else {
					owner = (Type)ownerList.get(0);
				}
			}
			// this is a classifier , construct and run the command
			EStructuralFeature feature = UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
			if(owner instanceof org.eclipse.uml2.uml.Class) {
				List<Property> attributeList = new ArrayList<Property>();
				attributeList.addAll(((org.eclipse.uml2.uml.Class)owner).getAttributes());
				attributeList.add(property);
				SetRequest setRequest = new SetRequest(owner, feature, attributeList);
				SetValueCommand setValueCommand = new SetValueCommand(setRequest);
				return setValueCommand;
			}
			return UnexecutableCommand.INSTANCE;
		} else {
			EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_OwnedEnd();
			List<Property> attributeList = new ArrayList<Property>();
			attributeList.addAll(property.getAssociation().getOwnedEnds());
			attributeList.add(property);
			SetRequest setRequest = new SetRequest(property.getAssociation(), feature, attributeList);
			SetValueCommand setValueCommand = new SetValueCommand(setRequest);
			return setValueCommand;
		}
	}

	/**
	 * Creates the command to set the multiplicity of the given property
	 * 
	 * @param property
	 *        the property to modify
	 * @param lower
	 *        the value of the lower bound
	 * @param upper
	 *        the value of the upper bound
	 * @return the command that sets the multiplicity of the property
	 */
	public static IUndoableOperation createSetMultiplicityCommand(Property property, int lower, int upper) {
		EStructuralFeature lowerFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Lower();
		EStructuralFeature upperFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Upper();

		CompositeCommand compositeCommand = new CompositeCommand("Set Multiplicity");

		// creates and adds the lower feature set command
		SetRequest setLowerRequest = new SetRequest(property, lowerFeature, lower);
		compositeCommand.compose(new SetValueCommand(setLowerRequest));

		// idem with the upper feature
		SetRequest setUpperRequest = new SetRequest(property, upperFeature, upper);
		compositeCommand.compose(new SetValueCommand(setUpperRequest));

		return compositeCommand;

	}

	/**
	 * Creates the command to set the navigation of the given property
	 * 
	 * @param association
	 *        the association that has the property as member end
	 * @param property
	 *        the property to modify
	 * @param isNavigable
	 *        <code>true</code> if the property should be navigable
	 * @return the command that sets the navigation of the property
	 */
	public static IUndoableOperation createSetNavigableCommand(Association association, Property property, boolean isNavigable) {
		EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd();
		List<Property> attributeList = new ArrayList<Property>();
		attributeList.addAll(property.getAssociation().getNavigableOwnedEnds());
		if(isNavigable) {
			attributeList.add(property);
		} else {
			attributeList.remove(property);
		}
		SetRequest setRequest = new SetRequest(property.getAssociation(), feature, attributeList);
		return new SetValueCommand(setRequest);
	}

}
