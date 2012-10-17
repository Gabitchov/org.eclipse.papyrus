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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.operation.xtext.validation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.uml.alf.validation.typing.MultiplicityFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.MultiplicityFacadeFactory;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart;

public class OperationEditorMultiplicityFacadeFactory extends MultiplicityFacadeFactory {

	@Override
	public MultiplicityFacade createMultiplicityFacade(EObject multiplicityElement) {
		if (multiplicityElement instanceof InvocationOrAssignementOrDeclarationStatement) {
			InvocationOrAssignementOrDeclarationStatement statement = 
				(InvocationOrAssignementOrDeclarationStatement) multiplicityElement ;
			if (statement.getTypePart_OR_assignedPart_OR_invocationPart().getSequenceConstructionCompletion() != null)
				return super.createMultiplicityFacade(0, -1, false, true) ;
			else
				return super.createMultiplicityFacade(1, 1, true, false) ;
		}
		else if (multiplicityElement instanceof FormalParameter) {
			FormalParameter param = (FormalParameter)multiplicityElement ;
			if (param.getType() != null && param.getType().getMultiplicity() != null && param.getType().getMultiplicity().getRange() != null) {
				MultiplicityRange multiplicityRange = param.getType().getMultiplicity().getRange() ;
				String lower = "" ;
				String upper = "" ;
				if (multiplicityRange.getLower() != null) {
					lower += multiplicityRange.getLower().getValue() ;
				}
				if (multiplicityRange.getUpper() != null) {
					upper += multiplicityRange.getUpper().getValue() ;
				}
				int lowerValue = 1 ;
				int upperValue = 1 ;
				if (!(lower.length() == 0)) {
					if (lower.equals("*"))
						lowerValue = -1 ;
					else {
						try {
							lowerValue = new Integer(lower).intValue() ;
						}
						catch (Exception e) {}
					}
				}
				if (!(upper.length() == 0)) {
					if (upper.equals("*")) {
						upperValue = -1 ;
					}
					else {
						try {
							upperValue = new Integer(upper).intValue() ;
						}
						catch (Exception e) {}
					}
					if (lower.length() == 0)
						lowerValue = upperValue ;
				}
				boolean isOrdered ;
				boolean isUnique ;
				if (param.getType().getMultiplicity().isSequence()) {
					isUnique = false ;
					isOrdered = true ;
				}
				else {
					isOrdered = param.getType().getMultiplicity().isOrdered() ;
					isUnique = ! param.getType().getMultiplicity().isNonUnique() ;
				}
				return super.createMultiplicityFacade(lowerValue, upperValue, isUnique , isOrdered) ;
			}
			else
				return super.createMultiplicityFacade(1, 1, true, false) ;
		}
		else if (multiplicityElement instanceof Multiplicity) {
			Multiplicity multiplicity = (Multiplicity)multiplicityElement ;
			if (multiplicity.getRange() != null) {
				MultiplicityRange multiplicityRange = multiplicity.getRange() ;
				String lower = "" ;
				String upper = "" ;
				if (multiplicityRange.getLower() != null) {
					lower += multiplicityRange.getLower().getValue() ;
				}
				if (multiplicityRange.getUpper() != null) {
					upper += multiplicityRange.getUpper().getValue() ;
				}
				int lowerValue = 1 ;
				int upperValue = 1 ;
				if (!(lower.length() == 0)) {
					if (lower.equals("*"))
						lowerValue = -1 ;
					else {
						try {
							lowerValue = new Integer(lower).intValue() ;
						}
						catch (Exception e) {}
					}
				}
				if (!(upper.length() == 0)) {
					if (upper.equals("*")) {
						upperValue = -1 ;
					}
					else {
						try {
							upperValue = new Integer(upper).intValue() ;
						}
						catch (Exception e) {}
					}
					if (lower.length() == 0)
						lowerValue = upperValue ;
				}
				boolean isUnique ;
				boolean isOrdered ;
				if (multiplicity.isSequence()) {
					isUnique = false ;
					isOrdered = true ;
				}
				else {
					isUnique = ! multiplicity.isNonUnique() ;
					isOrdered = multiplicity.isOrdered() ;
				}
				return super.createMultiplicityFacade(lowerValue, upperValue, isUnique, isOrdered) ;
			}
			else
				return super.createMultiplicityFacade(1, 1, true, false) ;
		}
		else if (multiplicityElement instanceof TypePart) {
			TypePart tp = (TypePart)multiplicityElement ;
			if (tp.getMultiplicity() == null)
				return createMultiplicityFacade() ;
			return createMultiplicityFacade(tp.getMultiplicity()) ;
		}
		else
			return super.createMultiplicityFacade(multiplicityElement);
	}
	
}
