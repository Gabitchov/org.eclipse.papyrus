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
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.emf.converter.ConverterNotfoundException;
import org.eclipse.papyrus.infra.extendedtypes.emf.converter.ConverterRegistry;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.util.SetValuesActionConfigurationSwitch;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.ValueSpecification;


/**
 * Utility class to get values from a {@link FeatureValue}
 */
public class FeatureValueUtils {

	protected FeatureValueUtils() {
		// no instanciation, helper class
	}

	/**
	 * Returns the value to set for a given feature of a given element 
	 * @param elementToConfigure eobject for which feature is set. This must not be <code>null</code>
	 * @param feature {@link EStructuralFeature} to set. This must not be <code>null</code>
	 * @param valueModel configuration of the value, stored in the model
	 * @return the real value that will be set to the object or <code>null</code> if none could be computed
	 */
	public static Object getValue(final EObject elementToConfigure, final EStructuralFeature feature, final FeatureValue featureValue) {
		
		Object result = new SetValuesActionConfigurationSwitch<Object>() {
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
					EClassifier type = feature.getEType();
					if(type instanceof EEnum) {
						String value = ((InstanceValue)valueSpecification).getInstance().getName();
						return ((EEnum)type).getEEnumLiteral(value).getInstance();
						// return ConverterRegistry.getSingleton().convert(EEnum.class, valueSpecification);
					} else if(type instanceof EDataType) {
						final EDataType pType = (EDataType)type;
						final String name = pType.getName();
						if("Boolean".equals(name)) {
							return ConverterRegistry.getSingleton().convert(boolean.class, valueSpecification);
						} else if("Integer".equals(name)) {
							return ConverterRegistry.getSingleton().convert(int.class, valueSpecification);
						} else if("Real".equals(name)) {
							return ConverterRegistry.getSingleton().convert(double.class, valueSpecification);
						} else if("String".equals(name)) {
							return ConverterRegistry.getSingleton().convert(String.class, valueSpecification);
						} else if("UnlimitedNatural".equals(name)) {
							return ConverterRegistry.getSingleton().convert(int.class, valueSpecification);
						} else { //custom PrimitiveType
							return ConverterRegistry.getSingleton().convert(String.class, valueSpecification);
						}
					} else if(type instanceof DataType) {//FIXME manage the data type
						return ConverterRegistry.getSingleton().convert(String.class, valueSpecification);
					} 
					return ConverterRegistry.getSingleton().convert(feature.getEType().getInstanceClass(), valueSpecification);
				} catch (ConverterNotfoundException e) {
					Activator.log.error("Impossible to convert "+valueSpecification+ " to fit feature type :"+feature, e);
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
					Object singleResult = getValue(elementToConfigure, feature, value);
					results.add(singleResult);
				}
				return results;
			};
			
		}.doSwitch(featureValue);
		return result;
	}
	
	
}
