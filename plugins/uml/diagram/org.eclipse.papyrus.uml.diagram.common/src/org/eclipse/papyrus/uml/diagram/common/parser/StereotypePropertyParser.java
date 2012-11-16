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
package org.eclipse.papyrus.uml.diagram.common.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this is a parser to display a slot in the diagram
 * 
 */
public class StereotypePropertyParser implements IParser, ISemanticParser {

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
		if(element instanceof IAdaptable) {
			final Property property = ((Property)((IAdaptable)element).getAdapter(EObject.class));
			final View view=((View)((IAdaptable)element).getAdapter(View.class));
			final EObject stereotypeApplication=((View)view.eContainer()).getElement();
			final Stereotype stereotype=UMLUtil.getStereotype(stereotypeApplication);
			final Element umlElement=UMLUtil.getBaseElement(stereotypeApplication); 


			String result= StereotypeUtil.displayPropertyValue(stereotype, property, umlElement, "");
			if( result.contains("=")){			
				result=result.substring(property.getName().length()+1);
				return result;
			}
			else{return "";}

		}
		return "<UNDEFINED>";
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
	public ICommand getParseCommand(IAdaptable element, final String newString, int flags) {
		if(element instanceof IAdaptable) {
			final Property property = ((Property)((IAdaptable)element).getAdapter(EObject.class));
			final View view=((View)((IAdaptable)element).getAdapter(View.class));
			final EObject stereotypeApplication=((View)view.eContainer()).getElement();
			final Stereotype stereotype=UMLUtil.getStereotype(stereotypeApplication);
			final Element umlElement=UMLUtil.getBaseElement(stereotypeApplication);
			final Object oldValue= umlElement.getValue(stereotype,  property.getName()); 
			ICommand cmd= new AbstractCommand("AppliedStereotypeProperty") {

				@Override
				protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					umlElement.setValue(stereotype, property.getName(), oldValue);
					return null;
				}

				@Override
				protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					umlElement.setValue(stereotype, property.getName(), newString);
					return null;
				}

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					umlElement.setValue(stereotype, property.getName(), newString);
					return null;

				}
			};
			return cmd;
		}
		//TO Modify
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

		if(element instanceof IAdaptable) {
			final Property property = ((Property)((IAdaptable)element).getAdapter(EObject.class));
			final View view=((View)((IAdaptable)element).getAdapter(View.class));
			final EObject stereotypeApplication=((View)view.eContainer()).getElement();
			final Stereotype stereotype=UMLUtil.getStereotype(stereotypeApplication);
			final Element umlElement=UMLUtil.getBaseElement(stereotypeApplication); 
			if(stereotype!=null && property!=null && umlElement!=null){
				return StereotypeUtil.displayPropertyValue(stereotype, property, umlElement, "");
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
		return new ParserEditStatus("Papyrus Edition for property of stereotype", IParserEditStatus.OK, "");
	}

	@SuppressWarnings("rawtypes")
	public List getSemanticElementsBeingParsed(EObject element) {
		return new ArrayList();
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}


}
