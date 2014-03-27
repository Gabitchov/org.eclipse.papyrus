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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.NamedElementHelper;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * The Class ConstraintParser.
 */
public class ConstraintParser implements IParser, ISemanticParser {

	protected static final String OPAQUE_EXPRESSION_BEGIN_LANGUAGE = "{";
	protected static final String OPAQUE_EXPRESSION_END_LANGUAGE = "} ";

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getEditString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 */

	public String getEditString(IAdaptable element, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null || constraint.getSpecification() == null) {
			return "<NULL Constraint>"; //$NON-NLS-1$
		}
		if(constraint.getSpecification() instanceof LiteralString) {
			return ((LiteralString)constraint.getSpecification()).getValue();
		}
		if(constraint.getSpecification() instanceof DurationInterval) {
			if((((DurationInterval)constraint.getSpecification()).getMin())!=null && (((DurationInterval)constraint.getSpecification()).getMax()!=null)){
				return ((DurationInterval)constraint.getSpecification()).getMin().stringValue()+".."+((DurationInterval)constraint.getSpecification()).getMax().stringValue();
			}
			else{
				return "0..0";}
		}

		if(constraint.getSpecification() instanceof TimeInterval) {
			if((((TimeInterval)constraint.getSpecification()).getMin())!=null && (((TimeInterval)constraint.getSpecification()).getMax()!=null)){
				return ((TimeInterval)constraint.getSpecification()).getMin().stringValue()+".."+((TimeInterval)constraint.getSpecification()).getMax().stringValue();
			}
			else{
				return "0..0";}
		}
		if(constraint.getSpecification() instanceof Interval) {
			if((((Interval)constraint.getSpecification()).getMin())!=null && (((Interval)constraint.getSpecification()).getMax()!=null)){
				return ((Interval)constraint.getSpecification()).getMin().stringValue()+".."+((Interval)constraint.getSpecification()).getMax().stringValue();
			}
			else{
				return "0..0";}
		}
		if(constraint.getSpecification() instanceof OpaqueExpression) {
			OpaqueExpression opaqueExpression = (OpaqueExpression)constraint.getSpecification();
			if(opaqueExpression.getBodies().size() > 0) {
				StringBuilder b = new StringBuilder();
				if (opaqueExpression.getLanguages().size() > 0) {
					b.append(OPAQUE_EXPRESSION_BEGIN_LANGUAGE);
					b.append(opaqueExpression.getLanguages().get(0));
					b.append(OPAQUE_EXPRESSION_END_LANGUAGE);
				}
				b.append(opaqueExpression.getBodies().get(0));
				return b.toString();
				}
			else{return OPAQUE_EXPRESSION_BEGIN_LANGUAGE+"NATURAL"+OPAQUE_EXPRESSION_END_LANGUAGE;}
		}
		return "";
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isValidEditString(org.eclipse.core.runtime.IAdaptable, java.lang.String)
	 * 
	 */

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getParseCommand(org.eclipse.core.runtime.IAdaptable, java.lang.String, int)
	 * 
	 */

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null || constraint.getSpecification() == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(constraint);
		if(editingDomain == null || constraint.getSpecification() == null) {
			return UnexecutableCommand.INSTANCE;
		}
		ICommand command=UnexecutableCommand.INSTANCE;
		if(constraint.getSpecification() instanceof LiteralString) {
			LiteralString specif = (LiteralString)constraint.getSpecification();
			command = new CompositeTransactionalCommand(editingDomain, "Set Value Constraint"); //$NON-NLS-1$
			SetRequest request = new SetRequest(specif, UMLPackage.eINSTANCE.getLiteralString_Value(), newString);
			command.compose(new SetValueCommand(request));
		}
		if(constraint.getSpecification() instanceof OpaqueExpression) {
			OpaqueExpression specif = (OpaqueExpression)constraint.getSpecification();
			command = new CompositeTransactionalCommand(editingDomain, "Set Value Constraint"); //$NON-NLS-1$
			ArrayList<String> stringBodyList=new ArrayList<String>();
			ArrayList<String> stringLanguageList=new ArrayList<String>();
			stringLanguageList.add(newString.substring(1, newString.indexOf(OPAQUE_EXPRESSION_END_LANGUAGE)).toUpperCase());
			stringBodyList.add( newString.substring(newString.indexOf(OPAQUE_EXPRESSION_END_LANGUAGE)+2,newString.length()));
			SetRequest request = new SetRequest(specif, UMLPackage.eINSTANCE.getOpaqueExpression_Body(), stringBodyList);
			command.compose(new SetValueCommand(request));
			request = new SetRequest(specif, UMLPackage.eINSTANCE.getOpaqueExpression_Language(), stringLanguageList);
			command.compose(new SetValueCommand(request));
			return  command;
		}

		if(constraint.getSpecification() instanceof DurationInterval) {
			Interval specif = (Interval)constraint.getSpecification();
			command = new CompositeTransactionalCommand(editingDomain, "Set Value Constraint"); //$NON-NLS-1$
			Duration durationMin= UMLFactory.eINSTANCE.createDuration();
			durationMin.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(constraint, durationMin.eClass()));
			Duration durationMax= UMLFactory.eINSTANCE.createDuration();
			durationMax.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(constraint, durationMax.eClass()));

			LiteralString exp1 =UMLFactory.eINSTANCE.createLiteralString();
			LiteralString exp2 =UMLFactory.eINSTANCE.createLiteralString();
			exp1.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(durationMin, exp1.eClass()));
			exp1.setValue(newString.substring(0, newString.indexOf("..")));
			exp2.setValue( newString.substring(newString.indexOf("..")+2,newString.length()));
			exp2.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(durationMax, exp2.eClass()));
			durationMin.setExpr(exp1);
			durationMax.setExpr(exp2);
			SetRequest request = new SetRequest(specif, UMLPackage.eINSTANCE.getInterval_Min(),durationMin);
			command.compose(new SetValueCommand(request));
			request = new SetRequest(specif, UMLPackage.eINSTANCE.getInterval_Max(), durationMax);
			command.compose(new SetValueCommand(request));
			return  command;
		}

		if(constraint.getSpecification() instanceof TimeInterval) {
			TimeInterval specif = (TimeInterval)constraint.getSpecification();
			command = new CompositeTransactionalCommand(editingDomain, "Set Value Constraint"); //$NON-NLS-1$
			TimeExpression timeMin= UMLFactory.eINSTANCE.createTimeExpression();
			timeMin.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(constraint, timeMin.eClass()));
			TimeExpression timeMax= UMLFactory.eINSTANCE.createTimeExpression();
			timeMax.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(constraint, timeMax.eClass()));

			LiteralString exp1 =UMLFactory.eINSTANCE.createLiteralString();
			LiteralString exp2 =UMLFactory.eINSTANCE.createLiteralString();
			exp1.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(timeMin, exp1.eClass()));
			exp1.setValue(newString.substring(0, newString.indexOf("..")));
			exp2.setValue( newString.substring(newString.indexOf("..")+2,newString.length()));
			exp2.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(timeMax, exp2.eClass()));
			timeMin.setExpr(exp1);
			timeMax.setExpr(exp2);
			SetRequest request = new SetRequest(specif, UMLPackage.eINSTANCE.getInterval_Min(),timeMin);
			command.compose(new SetValueCommand(request));
			request = new SetRequest(specif, UMLPackage.eINSTANCE.getInterval_Max(), timeMax);
			command.compose(new SetValueCommand(request));
			return  command;
		}

		if(constraint.getSpecification() instanceof Interval) {

			Interval specif = (Interval)constraint.getSpecification();
			command = new CompositeTransactionalCommand(editingDomain, "Set Value Constraint"); //$NON-NLS-1$
			LiteralInteger min = UMLFactory.eINSTANCE.createLiteralInteger();
			LiteralInteger max = UMLFactory.eINSTANCE.createLiteralInteger();
			min.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(min, min.eClass()));
			max.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(max, max.eClass()));
			Integer minInt= new Integer(newString.substring(0, newString.indexOf("..")));
			Integer maxInt= new Integer( newString.substring(newString.indexOf("..")+2,newString.length()));
			min.setValue(minInt.intValue());
			max.setValue( maxInt.intValue());

			SetRequest request = new SetRequest(specif, UMLPackage.eINSTANCE.getInterval_Min(),min);
			command.compose(new SetValueCommand(request));
			request = new SetRequest(specif, UMLPackage.eINSTANCE.getInterval_Max(), max);
			command.compose(new SetValueCommand(request));
			return  command;
		}
		return command;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getPrintString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 */

	public String getPrintString(IAdaptable element, int flags) {
		return getEditString(element, flags);
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isAffectingEvent(java.lang.Object, int)
	 * 
	 */

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getCompletionProcessor(org.eclipse.core.runtime.IAdaptable)
	 * 
	 */

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * used to obtain the constraint element.
	 * 
	 * @param element
	 *        the given IAdaptable
	 * @return the constraint or null if it can't be found.
	 */
	protected Constraint doAdapt(IAdaptable element) {
		Object obj = EMFHelper.getEObject(element);
		if(obj instanceof Constraint) {
			return (Constraint)obj;
		}
		return null;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#getSemanticElementsBeingParsed(org.eclipse.emf.ecore.EObject)
	 * 
	 */

	public List getSemanticElementsBeingParsed(EObject element) {
		Element umlElement = (Element)element;
		List<EObject> result = new LinkedList<EObject>();
		if(umlElement instanceof Constraint) {
			Constraint constraint = (Constraint)umlElement;
			if(constraint.getSpecification() != null) {
				ValueSpecification value = constraint.getSpecification();
				result.add(value);
			}
		}
		return result;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#areSemanticElementsAffected(org.eclipse.emf.ecore.EObject,
	 *      java.lang.Object)
	 * 
	 */

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

}
