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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.property.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.alf.naming.ALFIDConverter;
import org.eclipse.papyrus.uml.textedit.property.xtext.ui.internal.UmlPropertyActivator;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.EcoreUtil2;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point
 *         DirectEditor. It is used for the integration of an xtext generated
 *         editor, for properties of UML classifiers.
 * 
 */
public class PropertyXtextDirectEditorConfiguration extends DefaultXtextDirectEditorConfiguration implements
		ICustomDirectEditorConfiguration {


	@Override
	public Injector getInjector() {
		return UmlPropertyActivator.getInstance().getInjector(
				UmlPropertyActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_PROPERTY_XTEXT_UMLPROPERTY);
	}

	public ICommand getParseCommand(EObject modelObject, EObject xtextObject) {
		Property property = (Property) modelObject;
		xtextObject = EcoreUtil2.getContainerOfType(xtextObject, PropertyRule.class);
		PropertyRule propertyRuleObject = (PropertyRule) xtextObject;

		// Retrieves the information to be populated in modelObject
		boolean newIsDerived = propertyRuleObject.getIsDerived() != null
				&& propertyRuleObject.getIsDerived().equals("/");
		boolean newIsReadOnly = false;
		boolean newIsUnique = false;
		boolean newIsUnion = false;
		boolean newIsOrdered = false;
		List<Property> newRedefines = new ArrayList<Property>();
		List<Property> newSubsets = new ArrayList<Property>();
		if (propertyRuleObject.getModifiers() != null) {
			for (ModifierSpecification modifier : propertyRuleObject.getModifiers().getValues()) {
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
			for (ModifierSpecification modifier : propertyRuleObject.getModifiers().getValues()) {
				if (modifier.getRedefines() != null) {
					newRedefines.add(modifier.getRedefines().getProperty());
				} else if (modifier.getSubsets() != null) {
					newSubsets.add(modifier.getSubsets().getProperty());
				}
			}
		}
		int newLowerBound = 1;
		int newUpperBound = 1;
		if (propertyRuleObject.getMultiplicity() != null) {
			if (propertyRuleObject.getMultiplicity().getBounds().size() == 1) {
				String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
				if (tempBound.equals("*")) {
					newLowerBound = 0;
					newUpperBound = -1;
				} else {
					newLowerBound = new Integer(tempBound).intValue();
					newUpperBound = new Integer(tempBound).intValue();
				}
			} else { // size == 2
				String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
				newLowerBound = new Integer(tempBound).intValue();
				tempBound = propertyRuleObject.getMultiplicity().getBounds().get(1).getValue();
				if (tempBound.equals("*")) {
					newUpperBound = -1;
				} else {
					newUpperBound = new Integer(tempBound).intValue();
				}
			}
		}

		String newDefault;
		if (propertyRuleObject.getDefault() != null) {
			newDefault = propertyRuleObject.getDefault().getDefault();
		} else {
			newDefault = null;
		}
		String newName = ALFIDConverter.IDtoName(propertyRuleObject.getName());
		Classifier newType;
		TypeRule typeRule = propertyRuleObject.getType();
		if (typeRule == null) {
			newType = null;
		} else {
			newType = typeRule.getType();
		}

		org.eclipse.uml2.uml.VisibilityKind newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

		switch (propertyRuleObject.getVisibility()) {
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

		org.eclipse.gmf.runtime.common.core.command.CompositeCommand updateCommand = new CompositeCommand(
				"Property update");
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(property);

		SetRequest setIsDerivedRequest = new SetRequest(property, UMLPackage.eINSTANCE.getProperty_IsDerived(),
				newIsDerived);
		ICommand setIsDerivedCommand = provider.getEditCommand(setIsDerivedRequest);
		updateCommand.add(setIsDerivedCommand);

		SetRequest setIsReadOnlyRequest = new SetRequest(property,
				UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), newIsReadOnly);
		ICommand setIsReadOnlyCommand = provider.getEditCommand(setIsReadOnlyRequest);
		updateCommand.add(setIsReadOnlyCommand);

		SetRequest setIsUniqueRequest = new SetRequest(property,
				UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), newIsUnique);
		ICommand setIsUniqueCommand = provider.getEditCommand(setIsUniqueRequest);
		updateCommand.add(setIsUniqueCommand);

		SetRequest setIsDerivedUnionRequest = new SetRequest(property,
				UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), newIsUnion);
		ICommand setIsDerivedUnionCommand = provider.getEditCommand(setIsDerivedUnionRequest);
		updateCommand.add(setIsDerivedUnionCommand);

		SetRequest setIsOrderedRequest = new SetRequest(property,
				UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), newIsOrdered);
		ICommand setIsOrderedCommand = provider.getEditCommand(setIsOrderedRequest);
		updateCommand.add(setIsOrderedCommand);

		SetRequest setLowerRequest = new SetRequest(property, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(),
				newLowerBound);
		ICommand setLowerCommand = provider.getEditCommand(setLowerRequest);
		updateCommand.add(setLowerCommand);

		SetRequest setUpperRequest = new SetRequest(property, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(),
				newUpperBound);
		ICommand setUpperCommand = provider.getEditCommand(setUpperRequest);
		updateCommand.add(setUpperCommand);

		SetRequest setNameRequest = new SetRequest(property, UMLPackage.eINSTANCE.getNamedElement_Name(), newName);
		ICommand setNameCommand = provider.getEditCommand(setNameRequest);
		updateCommand.add(setNameCommand);

		SetRequest setTypeRequest = new SetRequest(property, UMLPackage.eINSTANCE.getTypedElement_Type(), newType);
		ICommand setTypeCommand = provider.getEditCommand(setTypeRequest);
		updateCommand.add(setTypeCommand);

		SetRequest setVisibilityRequest = new SetRequest(property, UMLPackage.eINSTANCE.getNamedElement_Visibility(),
				newVisibility);
		ICommand setVisibilityCommand = provider.getEditCommand(setVisibilityRequest);
		updateCommand.add(setVisibilityCommand);
		
		if (newDefault == null && property.getDefaultValue() != null) {
			DestroyElementRequest destroyDefaultValueRequest = new DestroyElementRequest(property.getDefaultValue(), false) ;
			ICommand destroyDefaultValueCommand = provider.getEditCommand(destroyDefaultValueRequest) ;
			updateCommand.add(destroyDefaultValueCommand);
		}
		else {
			SetRequest setDefaultValueRequest = new SetRequest(property, UMLPackage.eINSTANCE.getProperty_Default(), newDefault);
			ICommand setDefaultValueCommand = provider.getEditCommand(setDefaultValueRequest);
			updateCommand.add(setDefaultValueCommand);
		}

		SetRequest setRedefinedPropertiesRequest = new SetRequest(property,
				UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), newRedefines);
		ICommand setRedefinedPropertiesCommand = provider.getEditCommand(setRedefinedPropertiesRequest);
		updateCommand.add(setRedefinedPropertiesCommand);

		SetRequest setSubsettedPropertiesRequest = new SetRequest(property,
				UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), newSubsets);
		ICommand setSubsettedPropertiesCommand = provider.getEditCommand(setSubsettedPropertiesRequest);
		updateCommand.add(setSubsettedPropertiesCommand);
		return updateCommand;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration
	 * #getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof Property) {
			return UMLPropertyEditorPropertyUtil.getLabel((Property) editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "not a Property";
	}

}
