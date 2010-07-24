/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.parser.custom;

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
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.common.commands.SetValueSpecificationValueCommand;
import org.eclipse.papyrus.umlutils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A specific parser for displaying the joinSpec of a Join Node. This parser refreshes the text
 * displayed for the Join Node.
 */
public class JoinSpecParser extends MessageFormatParser implements ISemanticParser {

	/** The format for displaying the join spec */
	private static final String JOIN_SPEC_FORMAT = "{joinSpec = %s}";

	public JoinSpecParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public JoinSpecParser(EAttribute[] features) {
		super(features);
	}

	public JoinSpecParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	protected EStructuralFeature getEStructuralFeature(Object notification) {
		EStructuralFeature featureImpl = null;
		if(notification instanceof Notification) {
			Object feature = ((Notification)notification).getFeature();
			if(feature instanceof EStructuralFeature) {
				featureImpl = (EStructuralFeature)feature;
			}
		}
		return featureImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.diagram.sequence.parsers.AbstractParser#isAffectingEvent(java.lang.Object
	 * , int)
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);

	}

	@Override
	public String getEditString(IAdaptable adapter, int flags) {
		// ensure valueLabel is never null
		String valueLabel = "";
		Object obj = adapter.getAdapter(EObject.class);
		if(obj instanceof JoinNode) {
			JoinNode join = (JoinNode)obj;
			ValueSpecification valueSpec = join.getJoinSpec();
			if(valueSpec != null) {
				String value = ValueSpecificationUtil.getSpecificationValue(valueSpec);
				if(value != null) {
					valueLabel = value;
				}
			}
		}
		return valueLabel;
	}

	@Override
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		Object obj = adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(obj);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(obj instanceof JoinNode) {
			JoinNode join = (JoinNode)obj;
			ValueSpecification valueSpec = join.getJoinSpec();
			if(valueSpec != null) {
				CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
				command.compose(new CommandProxy(new SetValueSpecificationValueCommand(valueSpec, newString)));
				return command;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser#getPrintString(org.eclipse
	 * .core.runtime.IAdaptable, int)
	 */
	public String getPrintString(IAdaptable element, int flags) {
		// ensure valueLabel is never null
		String valueLabel = getEditString(element, flags);
		if(valueLabel.length() == 0) {
			valueLabel = " ";
		} else {
			valueLabel = String.format(JOIN_SPEC_FORMAT, valueLabel);
		}
		return valueLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#areSemanticElementsAffected
	 * (org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		EStructuralFeature feature = getEStructuralFeature(notification);
		return isValidFeature(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#getSemanticElementsBeingParsed
	 * (org.eclipse.emf.ecore.EObject)
	 */
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(element instanceof JoinNode) {
			JoinNode join = (JoinNode)element;
			semanticElementsBeingParsed.add(join);
			ValueSpecification valueSpec = join.getJoinSpec();
			if(valueSpec != null) {
				semanticElementsBeingParsed.add(valueSpec);
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * Determines if the given feature has to be taken into account in this parser
	 * 
	 * @param feature
	 *        the feature to test
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidFeature(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getJoinNode_JoinSpec().equals(feature) || ValueSpecification.class.isAssignableFrom(feature.getContainerClass());
	}
}
