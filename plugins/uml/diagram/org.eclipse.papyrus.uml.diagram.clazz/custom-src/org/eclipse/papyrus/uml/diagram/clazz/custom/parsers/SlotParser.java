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

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * this is a parser to display a slot in the diagram
 * 
 */
public class SlotParser implements IParser {

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getCompletionProcessor(org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param element
	 * @return
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getEditString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 * @param element
	 * @param flags
	 * @return
	 */
	public String getEditString(IAdaptable element, int flags) {
		// TODO Auto-generated method stub
		return getPrintString(element, flags);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getParseCommand(org.eclipse.core.runtime.IAdaptable, java.lang.String, int)
	 * 
	 * @param element
	 * @param newString
	 * @param flags
	 * @return
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getPrintString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 * @param element
	 * @param flags
	 * @return
	 */
	public String getPrintString(IAdaptable element, int flags) {
		if(element instanceof EObjectAdapter) {
			final Slot slot = ((Slot)((EObjectAdapter)element).getRealObject());
			if(slot.getDefiningFeature() == null) {
				return "<UNDEFINED>";
			}
			StructuralFeature feature = slot.getDefiningFeature();
			String result = slot.getDefiningFeature().getName();
			if(feature.getType() != null) {
				result += " : " + feature.getType().getName();
			}
			if(slot.getValues().isEmpty()) {
				return result;
			} else {
				result = result + " = ";
				Iterator<ValueSpecification> iter = slot.getValues().iterator();
				while(iter.hasNext()) {
					ValueSpecification currentSpecification = iter.next();
					if(currentSpecification instanceof InstanceValue && ((InstanceValue)currentSpecification).getInstance() != null) {
						result = result + ((InstanceValue)currentSpecification).getInstance().getName() + ", ";
					} else {
						result = result + currentSpecification.stringValue() + ", ";
					}
				}
				result = result.substring(0, result.length() - 2);
				return result;
			}
		}
		return "<UNDEFINED>";
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isAffectingEvent(java.lang.Object, int)
	 * 
	 * @param event
	 * @param flags
	 * @return
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isValidEditString(org.eclipse.core.runtime.IAdaptable, java.lang.String)
	 * 
	 * @param element
	 * @param editString
	 * @return
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.CANCEL, "");
	}
}
