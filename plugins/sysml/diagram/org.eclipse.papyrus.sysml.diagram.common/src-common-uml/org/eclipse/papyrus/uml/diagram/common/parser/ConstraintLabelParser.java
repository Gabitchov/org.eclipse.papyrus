/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Semantic Parser for {@link Constraint}.
 */
public class ConstraintLabelParser extends NamedElementLabelParser {

	/** The String format for displaying a Property label with derived modifier */
	protected static final String NAME_FORMAT = "%s";

	/** The String format for displaying a Property with visibility */
	protected static final String SPECIFICATION_FORMAT = "%s{%s}";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEditString(IAdaptable element, int flags) {

		Collection<String> maskValues = getMaskValues(element);

		if(maskValues.isEmpty()) {
			return MaskedLabel;
		}

		String editString = "";

		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if((eObject != null) && (eObject instanceof Constraint)) {
			Constraint semElement = (Constraint)eObject;

			// edit name
			if((maskValues.contains(ILabelPreferenceConstants.DISP_NAME))) {
				if(semElement.isSetName()) {
					editString = semElement.getName();
				}

				// (try to) edit constraint specification
			} else if((maskValues.contains(ILabelPreferenceConstants.DISP_SPECIFICATION))) {
				if(semElement.getSpecification() != null) {
					editString = ValueSpecificationUtil.getSpecificationValue(semElement.getSpecification());
					if(editString == null) {
						editString = "";
					}
				}
			}
		}
		return editString;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {
		Collection<String> maskValues = getMaskValues(element);

		if(maskValues.isEmpty()) {
			return MaskedLabel;
		}

		String result = "";
		EObject eObject = (EObject)element.getAdapter(EObject.class);

		if((eObject != null) && (eObject instanceof Constraint)) {

			Constraint semElement = (Constraint)eObject;

			// manage name
			if((maskValues.contains(ILabelPreferenceConstants.DISP_NAME)) && (semElement.isSetName())) {
				String name = semElement.getName();
				result = String.format(NAME_FORMAT, name);
			}

			// manage specification
			if((maskValues.contains(ILabelPreferenceConstants.DISP_SPECIFICATION))) {
				String spec = "<Undefined>";
				if(semElement.getSpecification() != null) {
					spec = ValueSpecificationUtil.getSpecificationValue(semElement.getSpecification());
					if(spec == null || "".equals(spec)) {
						spec = "<Undefined>";
					}
				}
				result = String.format(SPECIFICATION_FORMAT, result, spec);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {

		Collection<String> maskValues = getMaskValues(element);

		ICommand command = UnexecutableCommand.INSTANCE;
		SetRequest updateRequest = null;

		Constraint constraint = (Constraint)element.getAdapter(EObject.class);
		if(constraint == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// prepare set name request
		if((maskValues.contains(ILabelPreferenceConstants.DISP_NAME))) {
			updateRequest = new SetRequest(constraint, UMLPackage.eINSTANCE.getNamedElement_Name(), newString);
			updateRequest.setLabel("Update Constraint Label");

			// prepare set specification request
		} else if((maskValues.contains(ILabelPreferenceConstants.DISP_SPECIFICATION))) {
			ValueSpecification spec = constraint.getSpecification();
			if(spec == null) {
				return UnexecutableCommand.INSTANCE;
			}

			ValueSpecification specCopy = EcoreUtil.copy(spec);
			ValueSpecificationUtil.restoreSpecificationValue(specCopy, newString);

			updateRequest = new SetRequest(constraint, UMLPackage.eINSTANCE.getConstraint_Specification(), specCopy);
			updateRequest.setLabel("Update Constraint Label");
		}

		try {
			if(updateRequest != null) {
				command = ElementEditServiceUtils.getEditServiceProvider().getEditService(constraint).getEditCommand(updateRequest);
			}

		} catch (ServiceException e) {
			Activator.log.error(e);
		}


		return command;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAffectingEvent(Object event, int flags) {

		if(event instanceof Notification) {
			Object feature = ((Notification)event).getFeature();
			if(feature instanceof EStructuralFeature) {
				return UMLPackage.eINSTANCE.getValueSpecification__BooleanValue().equals(feature) || UMLPackage.eINSTANCE.getValueSpecification__IntegerValue().equals(feature) || UMLPackage.eINSTANCE.getValueSpecification__StringValue().equals(feature) || UMLPackage.eINSTANCE.getValueSpecification__UnlimitedValue().equals(feature) || UMLPackage.eINSTANCE.getOpaqueExpression_Body().equals(feature) || UMLPackage.eINSTANCE.getOpaqueExpression_Language().equals(feature) || super.isAffectingEvent(event, flags);
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = new ArrayList<EObject>();

		if((element != null) && (element instanceof Constraint)) {
			Constraint semElement = (Constraint)element;

			semanticElementsBeingParsed.add(semElement);
			if(semElement.getSpecification() != null) {
				semanticElementsBeingParsed.add(semElement.getSpecification());
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>(2);
		masks.put(ILabelPreferenceConstants.DISP_NAME, "Name");
		masks.put(ILabelPreferenceConstants.DISP_SPECIFICATION, "Specification");
		return masks;
	}

	@Override
	public Collection<String> getDefaultValue(IAdaptable element) {
		return Arrays.asList(ILabelPreferenceConstants.DISP_SPECIFICATION);
	}
}
