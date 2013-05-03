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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.textedit.property.xtext.ui.internal.UmlPropertyActivator;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.validation.SemanticValidator;
import org.eclipse.papyrus.uml.textedit.property.xtext.validation.UmlPropertyJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.inject.Injector;
//import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFUtils;
//import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.TransactionUtil;


/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for properties of UML classifiers.
 * 
 */
public class PropertyPopupEditorConfigurationContribution extends PopupEditorConfiguration {

	private Property property;

	private boolean newIsDerived;

	private boolean newIsReadOnly;

	private boolean newIsUnique;

	private boolean newIsUnion;

	private boolean newIsOrdered;

	private int newLowerBound;

	private int newUpperBound;

	private String newDefault ;

	private String newName;

	private Classifier newType;

	private org.eclipse.uml2.uml.VisibilityKind newVisibility;

	private List<Property> newRedefines = new ArrayList<Property>() ;

	private List<Property> newSubsets = new ArrayList<Property>() ;

	/**
	 * Default implementation of the constructor for this class
	 */
	public PropertyPopupEditorConfigurationContribution() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#createPopupEditorHelper(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {

		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if(!(graphicalEditPart.resolveSemanticElement() instanceof Property)) {
			return null;
		}
		property = (Property)graphicalEditPart.resolveSemanticElement();

		UmlPropertyJavaValidator.init(property);

		// retrieves the XText injector
		Injector injector = UmlPropertyActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.property.xtext.UmlProperty");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".umlproperty";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a PropertyRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof Property)) {
					return;
				}
				while(xtextObject != null && !(xtextObject instanceof PropertyRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null) {
					return;
				}
				PropertyRule propertyRuleObject = (PropertyRule)xtextObject;

				// Retrieves the information to be populated in modelObject
				newIsDerived = propertyRuleObject.getIsDerived() != null && propertyRuleObject.getIsDerived().equals("/");
				newIsReadOnly = false;
				newIsUnique = false;
				newIsUnion = false;
				newIsOrdered = false;
				newRedefines = new ArrayList<Property>() ;
				newSubsets = new ArrayList<Property>() ;
				if(propertyRuleObject.getModifiers() != null) {
					for(ModifierSpecification modifier : propertyRuleObject.getModifiers().getValues()) {
						if (modifier.getRedefines() == null && modifier.getSubsets()==null) {
							switch(modifier.getValue()) {
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
							newRedefines.add(modifier.getRedefines().getProperty()) ;
						} else if (modifier.getSubsets() != null) {
							newSubsets.add(modifier.getSubsets().getProperty()) ;
						}
					}
				}
				newLowerBound = 1;
				newUpperBound = 1;
				if(propertyRuleObject.getMultiplicity() != null) {
					if(propertyRuleObject.getMultiplicity().getBounds().size() == 1) {
						String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
						if(tempBound.equals("*")) {
							newLowerBound = 0;
							newUpperBound = -1;
						} else {
							newLowerBound = new Integer(tempBound).intValue();
							newUpperBound = new Integer(tempBound).intValue();
						}
					} else { //size == 2
						String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
						newLowerBound = new Integer(tempBound).intValue();
						tempBound = propertyRuleObject.getMultiplicity().getBounds().get(1).getValue();
						if(tempBound.equals("*")) {
							newUpperBound = -1;
						} else {
							newUpperBound = new Integer(tempBound).intValue();
						}
					}
				}

				if (propertyRuleObject.getDefault() != null) {
					newDefault = propertyRuleObject.getDefault().getDefault() ;
				}
				else {
					newDefault = null ;
				}

				newName = "" + propertyRuleObject.getName();

				TypeRule typeRule = propertyRuleObject.getType();
				if(typeRule == null) {
					newType = null;
				} else {
					newType = typeRule.getType();
				}

				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

				switch(propertyRuleObject.getVisibility()) {
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

				org.eclipse.gmf.runtime.common.core.command.CompositeCommand updateCommand = getUpdateCommand(property);
				List<Property> editedObjects = new ArrayList<Property>();
				editedObjects.add(property);
				
				TransactionalEditingDomain editingDomain =org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(property);

				
				if(updateCommand.canExecute()) {// && !(TransactionUtil.isReadTransactionInProgress(editingDomain, true, true))
					editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(updateCommand));
					return;
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension, new SemanticValidator());
	}

	private CompositeCommand getUpdateCommand(EObject editedObject) {
		org.eclipse.gmf.runtime.common.core.command.CompositeCommand updateCommand = new CompositeCommand("Property update");
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(editedObject);

		SetRequest setIsDerivedRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getProperty_IsDerived(), newIsDerived);
		ICommand setIsDerivedCommand = provider.getEditCommand(setIsDerivedRequest);
		updateCommand.add(setIsDerivedCommand);

		SetRequest setIsReadOnlyRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), newIsReadOnly);
		ICommand setIsReadOnlyCommand = provider.getEditCommand(setIsReadOnlyRequest);
		updateCommand.add(setIsReadOnlyCommand);

		SetRequest setIsUniqueRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), newIsUnique);
		ICommand setIsUniqueCommand = provider.getEditCommand(setIsUniqueRequest);
		updateCommand.add(setIsUniqueCommand);

		SetRequest setIsDerivedUnionRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), newIsUnion);
		ICommand setIsDerivedUnionCommand = provider.getEditCommand(setIsDerivedUnionRequest);
		updateCommand.add(setIsDerivedUnionCommand);

		SetRequest setIsOrderedRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), newIsOrdered);
		ICommand setIsOrderedCommand = provider.getEditCommand(setIsOrderedRequest);
		updateCommand.add(setIsOrderedCommand);

		SetRequest setLowerRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), newLowerBound);
		ICommand setLowerCommand = provider.getEditCommand(setLowerRequest);
		updateCommand.add(setLowerCommand);

		SetRequest setUpperRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(), newUpperBound);
		ICommand setUpperCommand = provider.getEditCommand(setUpperRequest);
		updateCommand.add(setUpperCommand);

		SetRequest setNameRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getNamedElement_Name(), newName);
		ICommand setNameCommand = provider.getEditCommand(setNameRequest);
		updateCommand.add(setNameCommand);

		SetRequest setTypeRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getTypedElement_Type(), newType);
		ICommand setTypeCommand = provider.getEditCommand(setTypeRequest);
		updateCommand.add(setTypeCommand);

		SetRequest setVisibilityRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getNamedElement_Visibility(), newVisibility);
		ICommand setVisibilityCommand = provider.getEditCommand(setVisibilityRequest);
		updateCommand.add(setVisibilityCommand);

		SetRequest setDefaultValueRequest = new SetRequest (editedObject, UMLPackage.eINSTANCE.getProperty_Default(), newDefault) ;
		ICommand setDefaultValueCommand = provider.getEditCommand(setDefaultValueRequest) ;
		updateCommand.add(setDefaultValueCommand) ;

		SetRequest setRedefinedPropertiesRequest = new SetRequest (editedObject, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), newRedefines) ;
		ICommand setRedefinedPropertiesCommand = provider.getEditCommand(setRedefinedPropertiesRequest) ;
		updateCommand.add(setRedefinedPropertiesCommand) ;

		SetRequest setSubsettedPropertiesRequest = new SetRequest (editedObject, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), newSubsets) ;
		ICommand setSubsettedPropertiesCommand = provider.getEditCommand(setSubsettedPropertiesRequest) ;
		updateCommand.add(setSubsettedPropertiesCommand) ;

		return updateCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Property) {
			return UMLPropertyEditorPropertyUtil.getLabel((Property)editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "not a Property";
	}

}
