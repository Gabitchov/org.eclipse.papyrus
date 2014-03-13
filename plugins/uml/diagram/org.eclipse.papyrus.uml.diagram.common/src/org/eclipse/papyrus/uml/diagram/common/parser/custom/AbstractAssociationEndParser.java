/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 ****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.parser.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * A specific parser to manage the property of association end.
 * 
 * @author tlandre
 */
public abstract class AbstractAssociationEndParser implements IParser {

	private final int memberEndIndex;

	public AbstractAssociationEndParser(int memberEndIndex) {
		this.memberEndIndex = memberEndIndex;
	}

	/**
	 * Get the EStructuralFeature of the given notification
	 * 
	 * @param notification
	 *        the notification
	 * @return the EStructuralFeature
	 */
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

	/**
	 * {@inheritDoc}
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get the property associated with the given IAdaptable and the
	 * memberEndIndex .
	 * 
	 * @param element
	 *        the given IAdaptable
	 * @return the property associated or null if it can't be found.
	 */
	protected Property doAdapt(IAdaptable element) {
		Object obj = EMFHelper.getEObject(element);
		Property property = null;
		if(obj instanceof Association) {
			Association association = (Association)obj;
			if(association.getMemberEnds() != null && association.getMemberEnds().size() > memberEndIndex)
				property = association.getMemberEnds().get(memberEndIndex);
		}
		return property;
	}

}
