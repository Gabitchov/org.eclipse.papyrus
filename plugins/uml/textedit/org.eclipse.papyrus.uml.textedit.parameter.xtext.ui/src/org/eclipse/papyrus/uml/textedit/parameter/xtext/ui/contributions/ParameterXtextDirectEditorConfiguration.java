package org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.internal.UmlParameterActivator;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.inject.Injector;


public class ParameterXtextDirectEditorConfiguration extends DefaultXtextDirectEditorConfiguration {

	@Override
	public Injector getInjector() {
		return UmlParameterActivator.getInstance().getInjector(UmlParameterActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_PARAMETER_XTEXT_UMLPARAMETER);
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		CompositeCommand cc = new CompositeCommand("Set values for Parameter"); //$NON-NLS-1$
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(umlObject);
		if(provider != null) {

			ICommand editCommand = null;
			for(SetRequest current : getRequests(umlObject, xtextObject)) {
				editCommand = provider.getEditCommand(current);

				if(editCommand != null && editCommand.canExecute()) {
					cc.add(editCommand);
				}
			}
		}
		return cc;
	}

	/**
	 * Returns the list of requests to update the {@link #parameter}
	 * 
	 * @return
	 *         the list of requests to update the {@link #parameter}
	 */
	protected List<SetRequest> getRequests(EObject modelObject, EObject xtextObject) {
		List<SetRequest> requests = new ArrayList<SetRequest>();


		// first: retrieves / determines if the xtextObject is a CollaborationUseRule object
		EObject modifiedObject = xtextObject;
		if(!(modelObject instanceof Parameter)) {
			return requests;
		}
		while(xtextObject != null && !(xtextObject instanceof ParameterRule)) {
			modifiedObject = modifiedObject.eContainer();
		}
		if(modifiedObject == null) {
			return requests;
		}
		ParameterRule parameterRuleObject = (ParameterRule)xtextObject;

		/** the new name for the {@link Parameter} */
		String newName;

		/** the new type for the {@link Parameter} */
		Type newType;

		/** the new visibility for the {@link Parameter} */
		org.eclipse.uml2.uml.VisibilityKind newVisibility;

		/** the new value for isException */
		boolean newIsException = false;

		/** the new value for isStream */
		boolean newIsStream = false;

		/** the new value for isOrdered */
		boolean newIsOrdered = false;

		/** the new value for isUnique */
		boolean newIsUnique = false;

		/** the new lowerBound */
		int newLowerBound = 1;

		/** the new upperBound */
		int newUpperBound = 1;

		/** the new effect for the parameter */
		ParameterEffectKind newEffect = ParameterEffectKind.CREATE_LITERAL;

		/** the new direction of the parameter */
		ParameterDirectionKind newDirection = ParameterDirectionKind.IN_LITERAL;

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

		Parameter parameter = (Parameter)modelObject;

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
	 * {@inheritDoc}
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Parameter) {
			return UMLParameterEditorUtil.getLabel((Parameter)editedObject).trim();
		}
		return "not a Parameter"; //$NON-NLS-1$
	}

}
