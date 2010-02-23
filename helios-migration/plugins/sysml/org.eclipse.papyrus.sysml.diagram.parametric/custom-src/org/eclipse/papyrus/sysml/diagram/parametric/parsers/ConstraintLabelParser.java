/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.parsers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.diagram.common.commands.SetValueSpecificationValueCommand;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.umlutils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * The Class ConstraintLabelParser that manages constraint label of a constraintProperty
 */
public class ConstraintLabelParser extends MessageFormatParser implements ISemanticParser {

	/** The String format for displaying a ConstraintProperty with no type */
	private static final String CONSTRAINT_LABEL__FORMAT = "{%s}";

	public ConstraintLabelParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public ConstraintLabelParser(EAttribute[] features) {
		super(features);
	}

	public ConstraintLabelParser() {
		super(new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	/**
	 * Gets the e structural feature.
	 * 
	 * @param notification
	 *            the notification
	 * @return the e structural feature
	 */
	protected EStructuralFeature getEStructuralFeature(Object notification) {
		EStructuralFeature featureImpl = null;
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			if (feature instanceof EStructuralFeature) {
				featureImpl = (EStructuralFeature) feature;
			}
		}
		return featureImpl;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		String result = "";
		Object obj = element.getAdapter(EObject.class);
		if (obj instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty) obj).getBase_Property();
			if (property != null) {
				// manage constraint
				if (property.getDefaultValue() != null) {
					ValueSpecification valueSpecification = property.getDefaultValue();
					String specificationValue = ValueSpecificationUtil.getSpecificationValue(valueSpecification);
					if (specificationValue != null && specificationValue.length() > 0) {
						result = String.format(CONSTRAINT_LABEL__FORMAT, specificationValue);
					}
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		EStructuralFeature feature = getEStructuralFeature(notification);
		return isValidFeature(feature);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if (element instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty) element).getBase_Property();
			if (property != null) {
				semanticElementsBeingParsed.add(property);
				if (property.getDefaultValue() != null) {
					semanticElementsBeingParsed.add(property.getDefaultValue());
				}
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * Determines if the given feature has to be taken into account in this parser
	 * 
	 * @param feature
	 *            the feature to test
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidFeature(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getProperty_DefaultValue().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_DefaultValue().equals(feature);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEditString(IAdaptable adapter, int flags) {
		String result = "";
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		if (element instanceof ConstraintProperty) {
			element = ((ConstraintProperty) element).getBase_Property();
			if (element instanceof Property) {
				ValueSpecification defaultValue = ((Property) element).getDefaultValue();
				result = ValueSpecificationUtil.getSpecificationValue(defaultValue);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		Object obj = adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(obj);

		if (editingDomain != null && obj instanceof ConstraintProperty) {
			obj = ((ConstraintProperty) obj).getBase_Property();
			if (obj instanceof Property) {
				ValueSpecification valueSpec = ((Property) obj).getDefaultValue();
				if (valueSpec != null) {
					CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain,
							"Set Values");
					command.compose(new CommandProxy(new SetValueSpecificationValueCommand(valueSpec, newString)));
					return command;
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

}
