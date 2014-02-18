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
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.emf.converter.ConverterNotfoundException;
import org.eclipse.papyrus.infra.extendedtypes.emf.converter.ConverterRegistry;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.util.ApplyStereotypeActionConfigurationSwitch;
import org.eclipse.papyrus.uml.tools.utils.PrimitivesTypesUtils;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;


/**
 * Utility class to get values from a {@link FeatureValue}
 */
public class StereotypeFeatureValueUtils {

	protected StereotypeFeatureValueUtils() {
		// no instanciation, helper class
	}

	/**
	 * Returns the value to set for a given feature of a given element 
	 * @param elementToConfigure eobject for which feature is set. This must not be <code>null</code>
	 * @param feature {@link EStructuralFeature} to set. This must not be <code>null</code>
	 * @param valueModel configuration of the value, stored in the model
	 * @return the real value that will be set to the object or <code>null</code> if none could be computed
	 */
	public static Object getValue(final EObject elementToConfigure, final Stereotype stereotype, final Type type, final FeatureValue featureValue) {
		
		Object result = new ApplyStereotypeActionConfigurationSwitch<Object>() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object caseConstantValue(ConstantValue object) {
				ValueSpecification valueSpecification = object.getValueInstance();
				
				if(valueSpecification==null) {
					return null;
				}

				try {
					if(type instanceof PrimitiveType) {
						final PrimitiveType pType = (PrimitiveType)type;
						final String name = pType.getName();
						if(PrimitivesTypesUtils.UML_BOOLEAN.equals(name)) {
							return ConverterRegistry.getSingleton().convert(boolean.class, valueSpecification);
						} else if(PrimitivesTypesUtils.UML_INTEGER.equals(name)) {
							return ConverterRegistry.getSingleton().convert(int.class, valueSpecification);
						} else if(PrimitivesTypesUtils.UML_REAL.equals(name)) {
							return ConverterRegistry.getSingleton().convert(double.class, valueSpecification);
						} else if(PrimitivesTypesUtils.UML_STRING.equals(name)) {
							return ConverterRegistry.getSingleton().convert(String.class, valueSpecification);
						} else if(PrimitivesTypesUtils.UML_UNLIMITED_NATURAL.equals(name)) {
							return ConverterRegistry.getSingleton().convert(int.class, valueSpecification);
						} else { //custom PrimitiveType
							return ConverterRegistry.getSingleton().convert(String.class, valueSpecification);
						}
					} else if(type instanceof Enumeration) {
						return ConverterRegistry.getSingleton().convert(Enumeration.class, valueSpecification);
					} else if(type instanceof DataType) {//FIXME manage the data type
						return ConverterRegistry.getSingleton().convert(String.class, valueSpecification);
					} 
				} catch (ConverterNotfoundException e) {
					Activator.log.error("Impossible to convert "+valueSpecification+ " to fit feature type :"+type, e);
				}
				return super.caseConstantValue(object);
			}
			
			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object caseQueryExecutionValue(QueryExecutionValue object) {
				throw new UnsupportedOperationException("Query execution values resolution has not been implemented yet");
			};
			
			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object caseDynamicValue(DynamicValue object) {
				throw new UnsupportedOperationException("Dynamic values resolution has not been implemented yet");
			};
			
			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object caseListValue(ListValue object) {
				// resolve one by one all features in the values list of this listvalue
				List<Object> results = new ArrayList<Object>();
				for(FeatureValue value : object.getValues()) {
					Object singleResult = getValue(elementToConfigure, stereotype, type, value);
					results.add(singleResult);
				}
				return results;
			};
			
		}.doSwitch(featureValue);
		return result;
	}
	
	
}
