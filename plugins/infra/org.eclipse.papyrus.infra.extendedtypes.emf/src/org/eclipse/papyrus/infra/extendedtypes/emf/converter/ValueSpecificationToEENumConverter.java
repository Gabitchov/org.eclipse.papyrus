/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.emf.converter;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;


/**
 * @author RS211865
 */
public class ValueSpecificationToEENumConverter extends Converter implements IConverter {

	/**
	 * @param fromType
	 * @param toType
	 */
	public ValueSpecificationToEENumConverter() {
		super(ValueSpecification.class, EEnum.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object convert(Object fromObject) {
		if(fromObject instanceof InstanceValue) {
			InstanceSpecification instanceSpecification = ((InstanceValue)fromObject).getInstance();
			if(instanceSpecification instanceof EnumerationLiteral) {
				
				System.err.println(VisibilityKind.PRIVATE_LITERAL);
				Class<?> eclass = ((EnumerationLiteral)instanceSpecification).getEnumeration().eClass().getInstanceClass();
				System.err.println(eclass.getEnumConstants());
				System.err.println(eclass);
				
				
				
				
				
				
//				final EEnumLiteral literal = eenum.getEEnumLiteral(umlLiteral.getName());
//				if(literal != null) {
//					return literal.getInstance();
//				}
//				return null;
//				
				System.err.println(instanceSpecification);
				
				
				//return ((EnumerationLiteral)instanceSpecification).;
			}
		}
		
		return fromObject;
	}
}
