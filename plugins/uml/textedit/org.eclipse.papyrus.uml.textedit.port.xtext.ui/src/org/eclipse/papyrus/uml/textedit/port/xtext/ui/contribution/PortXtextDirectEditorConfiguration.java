/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.port.xtext.ui.contribution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.uml.alf.naming.ALFIDConverter;
import org.eclipse.papyrus.uml.textedit.port.xtext.ui.internal.UmlPortActivator;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point
 *         DirectEditor. It is used for the integration of an xtext generated
 *         editor, for properties of UML classifiers.
 * 
 */
public class PortXtextDirectEditorConfiguration extends DefaultXtextDirectEditorConfiguration {

	private Port port;

	private boolean newIsDerived;

	private boolean isConjugated;

	private boolean newIsReadOnly;

	private boolean newIsUnique;

	private boolean newIsUnion;

	private boolean newIsOrdered;

	private int newLowerBound;

	private int newUpperBound;

	private String newDefault;

	private String newName;

	private Classifier newType;

	private org.eclipse.uml2.uml.VisibilityKind newVisibility;

	private List<Port> newRedefines = new ArrayList<Port>();

	private List<Port> newSubsets = new ArrayList<Port>();

	public void init(EObject semanticObject) {
	}

	@Override
	public Injector getInjector() {
		return UmlPortActivator.getInstance().getInjector(
				UmlPortActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_PORT_XTEXT_UMLPORT);
	}

	@Override
	protected ICommand getParseCommand(EObject modelObject, EObject xtextObject) {

		port = (Port) modelObject;
		// first: retrieves / determines if the xtextObject is a
		// portRule object
		EObject modifiedObject = xtextObject;
		if (!(modelObject instanceof Port)) {
			return UnexecutableCommand.INSTANCE;
		}
		while (xtextObject != null && !(xtextObject instanceof PortRule)) {
			modifiedObject = modifiedObject.eContainer();
		}
		if (modifiedObject == null) {
			return UnexecutableCommand.INSTANCE;
		}
		PortRule portRuleObject = (PortRule) xtextObject;

		// Retrieves the information to be populated in modelObject
		newIsDerived = portRuleObject.getIsDerived() != null && portRuleObject.getIsDerived().equals("/");
		isConjugated = portRuleObject.getIsConjugated() != null && portRuleObject.getIsConjugated().equals("~");
		newIsReadOnly = false;
		newIsUnique = false;
		newIsUnion = false;
		newIsOrdered = false;
		newRedefines = new ArrayList<Port>();
		newSubsets = new ArrayList<Port>();
		if (portRuleObject.getModifiers() != null) {
			for (ModifierSpecification modifier : portRuleObject.getModifiers().getValues()) {
				if (modifier.getRedefines() == null && modifier.getSubsets() == null) {
					switch (modifier.getValue()) {
					case ORDERED:
						newIsOrdered = true;
						break;
					case READ_ONLY:
						newIsReadOnly = true;
						break;
					case UNION:
						newIsUnion = true;
						break;
					case UNIQUE:
						newIsUnique = true;
						break;
					default:
						break;
					}
				}
			}
			for (ModifierSpecification modifier : portRuleObject.getModifiers().getValues()) {
				if (modifier.getRedefines() != null) {
					newRedefines.add(modifier.getRedefines().getPort());
				} else if (modifier.getSubsets() != null) {
					newSubsets.add(modifier.getSubsets().getPort());
				}
			}
		}
		newLowerBound = 1;
		newUpperBound = 1;
		if (portRuleObject.getMultiplicity() != null) {
			if (portRuleObject.getMultiplicity().getBounds().size() == 1) {
				String tempBound = portRuleObject.getMultiplicity().getBounds().get(0).getValue();
				if (tempBound.equals("*")) {
					newLowerBound = 0;
					newUpperBound = -1;
				} else {
					newLowerBound = new Integer(tempBound).intValue();
					newUpperBound = new Integer(tempBound).intValue();
				}
			} else { // size == 2
				String tempBound = portRuleObject.getMultiplicity().getBounds().get(0).getValue();
				newLowerBound = new Integer(tempBound).intValue();
				tempBound = portRuleObject.getMultiplicity().getBounds().get(1).getValue();
				if (tempBound.equals("*")) {
					newUpperBound = -1;
				} else {
					newUpperBound = new Integer(tempBound).intValue();
				}
			}
		}

		if (portRuleObject.getDefault() != null) {
			newDefault = portRuleObject.getDefault().getDefault();
		} else {
			newDefault = null;
		}

		newName = "" + ALFIDConverter.IDtoName(portRuleObject.getName());

		TypeRule typeRule = portRuleObject.getType();
		if (typeRule == null) {
			newType = null;
		} else {
			newType = typeRule.getType();
		}

		newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

		switch (portRuleObject.getVisibility()) {
		case PUBLIC:
			newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;
			break;
		case PACKAGE:
			newVisibility = org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL;
			break;
		case PRIVATE:
			newVisibility = org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL;
			break;
		case PROTECTED:
			newVisibility = org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL;
			break;
		default:
			break;
		}
		return getUpdateCommand(port);
	}

	private CompositeCommand getUpdateCommand(EObject editedObject) {
		org.eclipse.gmf.runtime.common.core.command.CompositeCommand updateCommand = new CompositeCommand("port update");

		SetRequest setIsDerivedRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getProperty_IsDerived(),
				newIsDerived);
		ICommand setIsDerivedCommand = new SetValueCommand(setIsDerivedRequest);
		updateCommand.add(setIsDerivedCommand);
		SetRequest setIsConjugatedRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getPort_IsConjugated(),
				isConjugated);
		ICommand setIsConjugatedCommand = new SetValueCommand(setIsConjugatedRequest);
		updateCommand.add(setIsConjugatedCommand);

		SetRequest setIsReadOnlyRequest = new SetRequest(editedObject,
				UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), newIsReadOnly);
		ICommand setIsReadOnlyCommand = new SetValueCommand(setIsReadOnlyRequest);
		updateCommand.add(setIsReadOnlyCommand);

		SetRequest setIsUniqueRequest = new SetRequest(editedObject,
				UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), newIsUnique);
		ICommand setIsUniqueCommand = new SetValueCommand(setIsUniqueRequest);
		updateCommand.add(setIsUniqueCommand);

		SetRequest setIsDerivedUnionRequest = new SetRequest(editedObject,
				UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), newIsUnion);
		ICommand setIsDerivedUnionCommand = new SetValueCommand(setIsDerivedUnionRequest);
		updateCommand.add(setIsDerivedUnionCommand);

		SetRequest setIsOrderedRequest = new SetRequest(editedObject,
				UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), newIsOrdered);
		ICommand setIsOrderedCommand = new SetValueCommand(setIsOrderedRequest);
		updateCommand.add(setIsOrderedCommand);

		SetRequest setLowerRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(),
				newLowerBound);
		ICommand setLowerCommand = new SetValueCommand(setLowerRequest);
		updateCommand.add(setLowerCommand);

		SetRequest setUpperRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(),
				newUpperBound);
		ICommand setUpperCommand = new SetValueCommand(setUpperRequest);
		updateCommand.add(setUpperCommand);

		SetRequest setNameRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getNamedElement_Name(), newName);
		ICommand setNameCommand = new SetValueCommand(setNameRequest);
		updateCommand.add(setNameCommand);

		SetRequest setTypeRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getTypedElement_Type(), newType);
		ICommand setTypeCommand = new SetValueCommand(setTypeRequest);
		updateCommand.add(setTypeCommand);

		SetRequest setVisibilityRequest = new SetRequest(editedObject,
				UMLPackage.eINSTANCE.getNamedElement_Visibility(), newVisibility);
		ICommand setVisibilityCommand = new SetValueCommand(setVisibilityRequest);
		updateCommand.add(setVisibilityCommand);

		SetRequest setDefaultValueRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getProperty_Default(),
				newDefault);
		ICommand setDefaultValueCommand = new SetValueCommand(setDefaultValueRequest);
		updateCommand.add(setDefaultValueCommand);

		SetRequest setRedefinedPropertiesRequest = new SetRequest(editedObject,
				UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), newRedefines);
		ICommand setRedefinedPropertiesCommand = new SetValueCommand(setRedefinedPropertiesRequest);
		updateCommand.add(setRedefinedPropertiesCommand);

		SetRequest setSubsettedPropertiesRequest = new SetRequest(editedObject,
				UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), newSubsets);
		ICommand setSubsettedPropertiesCommand = new SetValueCommand(setSubsettedPropertiesRequest);
		updateCommand.add(setSubsettedPropertiesCommand);

		return updateCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java
	 * .lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof Port) {
			return UMLPortEditorPropertyUtil.getLabel((Port) editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "not a Port";
	}
}
