/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.clazz.custom.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class GeneralizationSetConstraintParser used to display internal constraint
 */
public class GeneralizationSetConstraintParser implements IParser {

	/**
	 * {@inheritDoc}
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		if(element instanceof EObjectAdapter) {
			if(((EObjectAdapter)element).getRealObject() instanceof GeneralizationSet) {
				GeneralizationSet generalizationSet = ((GeneralizationSet)((EObjectAdapter)element).getRealObject());
				String out = "{";
				if(generalizationSet.isCovering()) {
					out = out + "complete, ";
				} else {
					out = out + "incomplete, ";
				}
				if(generalizationSet.isDisjoint()) {
					out = out + "disjoint}";
				} else {
					out = out + "overlapping}";
				}
				return out;
			}
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if(event instanceof org.eclipse.emf.common.notify.Notification) {
			Object source = ((org.eclipse.emf.common.notify.Notification)event).getFeature();
			if(source instanceof EAttribute) {
				if(source.equals(UMLPackage.eINSTANCE.getGeneralizationSet_IsCovering()) || (source.equals(UMLPackage.eINSTANCE.getGeneralizationSet_IsDisjoint()))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}
}
