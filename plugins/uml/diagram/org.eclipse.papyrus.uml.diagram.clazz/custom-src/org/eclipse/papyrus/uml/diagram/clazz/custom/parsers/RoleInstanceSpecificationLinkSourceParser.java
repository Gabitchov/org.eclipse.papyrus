/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;


public class RoleInstanceSpecificationLinkSourceParser implements IParser {

	public String getEditString(IAdaptable element, int flags) {
		InstanceSpecification instanceSpecification = ((InstanceSpecification)((EObjectAdapter)element).getRealObject());
		if(instanceSpecification.getClassifiers().size() > 0) {
			if(instanceSpecification.getClassifiers().get(0) instanceof Association) {
				Association association = (Association)instanceSpecification.getClassifiers().get(0);
				Slot slotSource = instanceSpecification.getSlots().get(0);
				return slotSource.getValues().get(0).getType().getName();


			}
		}
		return "<UNSPECIFIED>";
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {
		InstanceSpecification instanceSpecification = ((InstanceSpecification)((EObjectAdapter)element).getRealObject());
		if(instanceSpecification.getClassifiers().size() > 0) {
			if(instanceSpecification.getClassifiers().get(0) instanceof Association) {
				Association association = (Association)instanceSpecification.getClassifiers().get(0);
				Slot slotSource = instanceSpecification.getSlots().get(0);
				return slotSource.getValues().get(0).getType().getName();
			}
		}
		return "<UNSPECIFIED>";
	}

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return true;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

}
