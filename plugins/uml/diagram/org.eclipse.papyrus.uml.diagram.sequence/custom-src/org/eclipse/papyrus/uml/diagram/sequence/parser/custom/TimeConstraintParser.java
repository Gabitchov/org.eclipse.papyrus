/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.parser.custom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.uml.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;


/**
 * Specific Parser for the TimeConstraint and DurationConstraint.
 */
public class TimeConstraintParser extends MessageFormatParser implements ISemanticParser {

	/** The String for displaying a line break */
	private static final String LINE_BREAK = System.getProperty("line.separator");

	/** The format for displaying time constraint text */
	private static final String FORMAT = "{%s}";

	public TimeConstraintParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	public TimeConstraintParser(EAttribute[] features) {
		super(features);
	}

	public TimeConstraintParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	/**
	 * Gets the e structural feature.
	 * 
	 * @param notification
	 * @return the structural feature
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
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Object adapter = element.getAdapter(EObject.class);
		if(adapter instanceof TimeConstraint) {
			TimeConstraint constraint = (TimeConstraint)adapter;
			ValueSpecification spec = constraint.getSpecification();
			return String.format(FORMAT, ValueSpecificationUtil.getSpecificationValue(spec));
		} else if(adapter instanceof DurationConstraint) {
			String value = getDurationConstraint((DurationConstraint)adapter);
			return String.format(FORMAT, value);
		} else if(adapter instanceof Message) {
			StringBuffer result = new StringBuffer();
			Message message = (Message)adapter;
			MessageEnd event1 = message.getSendEvent();
			MessageEnd event2 = message.getReceiveEvent();
			List<DurationConstraint> constraints = DurationConstraintHelper.getDurationConstraintsBetween(event1, event2);
			for(DurationConstraint constraint : constraints) {
				if(result.length() > 0) {
					result.append(LINE_BREAK);
				}
				ValueSpecification spec = constraint.getSpecification();
				result.append(String.format(FORMAT, ValueSpecificationUtil.getSpecificationValue(spec)));
			}
			return result.toString();
		}
		return "";
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getSemanticElementsBeingParsed(EObject element) {
		HashSet<Element> semanticElementsBeingParsed = new HashSet<Element>();
		if(element instanceof Constraint) {
			Constraint constraint = (Constraint)element;
			ValueSpecificationUtil.addEnclosedValueSpecificationToCollection(constraint.getSpecification(), semanticElementsBeingParsed);
		} else if(element instanceof Message) {
			Message message = (Message)element;
			semanticElementsBeingParsed.add(message);
			MessageEnd event1 = message.getSendEvent();
			semanticElementsBeingParsed.add(event1);
			MessageEnd event2 = message.getReceiveEvent();
			semanticElementsBeingParsed.add(event2);
			List<DurationConstraint> constraints = DurationConstraintHelper.getDurationConstraintsBetween(event1, event2);
			for(DurationConstraint constraint : constraints) {
				semanticElementsBeingParsed.add(constraint);
				// owner for listening DurationConstraint deletion
				semanticElementsBeingParsed.add(constraint.getOwner());
			}
		}
		return new ArrayList(semanticElementsBeingParsed);
	}

	/**
	 * Determines if the given feature has to be taken into account in this parser
	 * 
	 * @param feature
	 *        the feature to test
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidFeature(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getConstraint_Specification().equals(feature) || ValueSpecification.class.isAssignableFrom(feature.getContainerClass());
	}
	
	@Override
	public String getEditString(IAdaptable adapter, int flags) {
		EObject element = (EObject)adapter.getAdapter(EObject.class);
		if(element instanceof DurationConstraint) {
			return getDurationConstraint((DurationConstraint)element);
		} 
		return super.getEditString(adapter, flags);
	}

	protected String getDurationConstraint(DurationConstraint constraint) {
		ValueSpecification spec = constraint.getSpecification();
		if(spec instanceof Interval){
			Interval interval = (Interval)spec;
			String min = ValueSpecificationUtil.getSpecificationValue(interval.getMin());
			String max = ValueSpecificationUtil.getSpecificationValue(interval.getMax());
			if(min.equals(max))
				return min;
		}			
		String value = ValueSpecificationUtil.getSpecificationValue(spec);
		return value;
	}
	
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		EObject element = (EObject)adapter.getAdapter(EObject.class);
		if(element instanceof DurationConstraint){
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
			if(editingDomain == null) {
				return UnexecutableCommand.INSTANCE;
			}
			Object[] values = parseInterval(newString);
			if(values == null || values.length != 2) {
				return UnexecutableCommand.INSTANCE;
			}
			return new UpdateDurationConstraintCommand(editingDomain, (DurationConstraint)element, values[0], values[1] );
		}
		return super.getParseCommand(adapter, newString, flags);
	}

	private Object[] parseInterval(String newString) {
		int pos = newString.indexOf("..");
		if(pos > -1){
			String[] part = {newString.substring(0, pos), newString.substring(pos + 2)};
			try {
				int min = Integer.parseInt( part[0].trim());
				int max = Integer.parseInt( part[1].trim());
				return new Integer[]{min, max};
			} catch (Exception e) {
			}
			return part;
		}else{
			try {
				int value = Integer.parseInt(newString);
				return new Integer[]{value, value};
			} catch (Exception e) {
			}
			
			// same value for min and max
			return new String[]{newString, newString};
		}
	}
	
	static class UpdateDurationConstraintCommand extends AbstractTransactionalCommand {
		private DurationConstraint constraint;
		private Object min;
		private Object max;
		
		public UpdateDurationConstraintCommand(TransactionalEditingDomain domain, DurationConstraint constraint, Object min, Object max) {
			super(domain, "Set Values", null);
			this.constraint = constraint;
			this.min = min;
			this.max = max;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			ValueSpecification spec = constraint.getSpecification();
			if(spec instanceof Interval){
				Interval interval = (Interval)spec;
				setValue(interval.getMin(), min );
				setValue(interval.getMax(), max );
			}			
			return CommandResult.newOKCommandResult();
		}

		private void setValue(ValueSpecification spec, Object val) {
			if(spec instanceof Duration){
				Duration dur = (Duration)spec;
				if( dur.getExpr() instanceof LiteralInteger && val instanceof Integer){
					((LiteralInteger)dur.getExpr()).setValue((Integer)val);
				}else{
					LiteralString str = UMLFactory.eINSTANCE.createLiteralString();
					str.setValue(val.toString());
					dur.setExpr(str);
				}
			}
		}
	}

}
