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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.internal.UmlParameterActivator;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.validation.SemanticValidator;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.inject.Injector;



public class ParameterPopupEditor extends org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration {

	/** the new name for the {@link Parameter} */
	private String newName;

	/** the new type for the {@link Parameter} */
	private Type newType;

	/** the new visibility for the {@link Parameter} */
	private org.eclipse.uml2.uml.VisibilityKind newVisibility;

	/** the managed {@link Parameter} */
	private Parameter parameter;

	/** the new value for isException */
	private boolean newIsException = false;

	/** the new value for isStream */
	private boolean newIsStream = false;

	/** the new value for isOrdered */
	private boolean newIsOrdered = false;

	/** the new value for isUnique */
	private boolean newIsUnique = false;

	/** the new lowerBound */
	private int newLowerBound = 1;

	/** the new upperBound */
	private int newUpperBound = 1;

	/** the new effect for the parameter */
	private ParameterEffectKind newEffect;

	/** the new direction of the parameter */
	private ParameterDirectionKind newDirection;

	//TODO : do an abstract method in the super class to init the validator
	//public abstract initValidator(Element el);
	//with the validator in the super class

	/**
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#createPopupEditorHelper(java.lang.Object)
	 * 
	 * @param editPart
	 * @return
	 */
	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		graphicalEditPart = (IGraphicalEditPart)editPart;

		if(!(graphicalEditPart.resolveSemanticElement() instanceof Parameter)) {
			return null;
		}
		parameter = (Parameter)graphicalEditPart.resolveSemanticElement();

		// retrieves the XText injector
		Injector injector = UmlParameterActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.parameter.xtext.UmlParameter"); //$NON-NLS-1$

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement()); //$NON-NLS-1$
		String fileExtension = "" + ".umlparameter"; //$NON-NLS-1$ //$NON-NLS-2$

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a CollaborationUseRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof Parameter)) {
					return;
				}
				while(xtextObject != null && !(xtextObject instanceof ParameterRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null) {
					return;
				}
				ParameterRule parameterRuleObject = (ParameterRule)xtextObject;

				// Retrieves the information to be populated in modelObject
				if(parameterRuleObject.getModifiers() != null) {
					for(org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification modifier : parameterRuleObject.getModifiers().getValues()) {
						switch(modifier.getValue()) {
						case ORDERED:
							newIsOrdered = true;
							break;
						case UNIQUE:
							newIsUnique = true;
							break;
						case EXCEPTION:
							newIsException = true;
							break;
						case STREAM:
							newIsStream = true;
							break;
						default:
							break;
						}
					}
				}

				if(parameterRuleObject.getMultiplicity() != null) {
					if(parameterRuleObject.getMultiplicity().getBounds().size() == 1) {
						String tempBound = parameterRuleObject.getMultiplicity().getBounds().get(0).getValue();
						if(tempBound.equals("*")) { //$NON-NLS-1$
							newLowerBound = 0;
							newUpperBound = -1;
						} else {
							newLowerBound = new Integer(tempBound).intValue();
							newUpperBound = new Integer(tempBound).intValue();
						}
					} else { //size == 2
						String tempBound = parameterRuleObject.getMultiplicity().getBounds().get(0).getValue();
						newLowerBound = new Integer(tempBound).intValue();
						tempBound = parameterRuleObject.getMultiplicity().getBounds().get(1).getValue();
						if(tempBound.equals("*")) { //$NON-NLS-1$
							newUpperBound = -1;
						} else {
							newUpperBound = new Integer(tempBound).intValue();
						}
					}
				} else {//reset to the default value :
					newLowerBound = 1;
					newUpperBound = 1;
				}

				newName = "" + parameterRuleObject.getName(); //$NON-NLS-1$

				TypeRule typeRule = parameterRuleObject.getType();
				if(typeRule == null) {
					newType = null;
				} else {
					newType = typeRule.getType();
				}

				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

				switch(parameterRuleObject.getVisibility()) {
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

				switch(parameterRuleObject.getDirection()) {
				case IN:
					newDirection = ParameterDirectionKind.IN_LITERAL;
					break;
				case OUT:
					newDirection = ParameterDirectionKind.OUT_LITERAL;
					break;
				case INOUT:
					newDirection = ParameterDirectionKind.INOUT_LITERAL;
					break;
				case RETURN:
					newDirection = ParameterDirectionKind.RETURN_LITERAL;
					break;

				}

				switch(parameterRuleObject.getEffect().getEffectKind()) {
				case CREATE:
					newEffect = ParameterEffectKind.CREATE_LITERAL;
					break;
				case DELETE:
					newEffect = ParameterEffectKind.DELETE_LITERAL;
					break;
				case READ:
					newEffect = ParameterEffectKind.READ_LITERAL;
					break;
				case UPDATE:
					newEffect = ParameterEffectKind.UPDATE_LITERAL;
					break;
				}

				IUndoableOperation updateCommand = getUpdateCommand();

				try {
					CheckedOperationHistory.getInstance().execute(updateCommand, new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					System.err.println(e);
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension, new SemanticValidator());
	}

	/**
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 * 
	 * @param editedObject
	 * @return
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Parameter) {
			return UMLParameterEditorUtil.getLabel((Parameter)editedObject).trim();
		}
		return "not a Parameter"; //$NON-NLS-1$
	}

	/**
	 * Returns the list of requests to update the {@link #parameter}
	 * 
	 * @return
	 *         the list of requests to update the {@link #parameter}
	 */
	protected List<SetRequest> getRequests() {
		List<SetRequest> requests = new ArrayList<SetRequest>();
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getNamedElement_Name(), newName));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getNamedElement_Visibility(), newVisibility));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getTypedElement_Type(), newType));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_IsException(), newIsException));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_IsStream(), newIsStream));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), newIsOrdered));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), newIsUnique));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_Direction(), newDirection));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), newLowerBound));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(), newUpperBound));
		requests.add(new SetRequest(parameter, UMLPackage.eINSTANCE.getParameter_Effect(), newEffect));
		return requests;
	}

	/**
	 * Returns the update command
	 * 
	 * @return
	 *         the update command
	 */
	protected IUndoableOperation getUpdateCommand() {
		CompositeCommand cc = new CompositeCommand("Set values for Parameter"); //$NON-NLS-1$
		org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(parameter);
		if(provider != null) {

			ICommand editCommand = null;
			for(SetRequest current : getRequests()) {
				editCommand = provider.getEditCommand(current);

				if(editCommand != null && editCommand.canExecute()) {
					cc.add(editCommand);
				}
			}
		}
		return cc;
	}
}
