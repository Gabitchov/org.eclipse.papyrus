/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.infra.tools.converter.ConvertedValueContainer;
import org.eclipse.papyrus.infra.tools.converter.MultiConvertedValueContainer;
import org.eclipse.papyrus.infra.tools.converter.StringValueConverterStatus;
import org.eclipse.papyrus.infra.tools.util.BooleanHelper;
import org.eclipse.papyrus.infra.tools.util.TypesConstants;

/**
 * Value solver for EMF
 * 
 * WARNING : incomplete implementations
 * 
 * @author vl222926
 * 
 */

public class EMFStringValueConverter extends AbstractStringValueConverter {



	/**
	 * Context used for the resolution of the string
	 */
	private EObject resolutionContext;

	/**
	 * The separator used for multivalue
	 */
	protected final String multiValueSeparator;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param resolutionContext
	 *        the context used for the resolution of the string
	 */
	public EMFStringValueConverter(final EObject resolutionContext, final String multiValueSeparator) {
		this.resolutionContext = resolutionContext;
		this.multiValueSeparator = multiValueSeparator;
	}


	/**
	 * 
	 * @return
	 *         the context to use for the resolution
	 */
	public EObject getResolutionContext() {
		return resolutionContext;
	}

	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	public void dispose() {
		this.resolutionContext = null;
	}

	/**
	 * 
	 * @param resolutionContext
	 *        the table context
	 * @param feature
	 *        the feature
	 * @param valueAsString
	 *        the pasted string for this feature
	 * @return
	 *         the value for the pasted string or <code>null</code> if not found
	 */
	@Override
	protected ConvertedValueContainer<?> doDeduceValueFromString(final Object feature, final String valueAsString) {
		final EClassifier featureType = getFeatureType(feature);
		if(feature instanceof EStructuralFeature) {
			return deduceValueFromString(feature, featureType, valueAsString);
		}
		return null;
	}

	/**
	 * 
	 * @param feature
	 * @param featureType
	 * @param valueAsString
	 * @return
	 */
	protected ConvertedValueContainer<?> deduceValueFromString(final Object feature, final EClassifier featureType, final String valueAsString) {
		ConvertedValueContainer<?> realValue = null;
		//		if(feature instanceof EStructuralFeature) {
		final int upperbound = getFeatureUpperBound(feature);
		boolean isMany = (upperbound > 1 || upperbound == -1);
		if(featureType instanceof EDataType) {
			if(featureType instanceof EEnum) {
				realValue = deduceEEnumLiteralValue((EEnum)featureType, isMany, valueAsString);
			}
			final String typeName = featureType.getName();
			if(TypesConstants.STRING.equals(typeName) || EMFContants.ESTRING.equals(typeName)) {
				realValue = deduceStringValue(isMany, valueAsString);
			} else if(EMFContants.EBOOLEAN.equals(typeName) || TypesConstants.BOOLEAN.equals(typeName)) {
				realValue = deduceBooleanValue(isMany, valueAsString);
			} else if(EMFContants.EINT.equals(typeName) || TypesConstants.INTEGER.equals(typeName)) {
				realValue = deduceIntValue(isMany, valueAsString);
			} else if(EMFContants.EDOUBLE.equals(typeName)) {
				realValue = deduceDoubleValue(isMany, valueAsString);
			}
		} else if(featureType instanceof EClass) {
			realValue = deduceEObjectValue((EObject)getResolutionContext(), feature, (EClass)featureType, isMany, valueAsString);
		}
		return realValue;
	}

	protected int getFeatureUpperBound(final Object feature) {
		return ((EStructuralFeature)feature).getUpperBound();
	}



	/**
	 * 
	 * @param resolutionContext
	 *        the context used for the resolution
	 * @param feature
	 *        the feature
	 * @param featureType
	 *        the type of the feature
	 * @param isMany
	 *        <code>true</code> if the feature isMany
	 * @param valueAsString
	 *        the string value to resolve
	 * @return
	 *         a value container referencing the eobject represented by the string
	 * @throws StringValueSolverException
	 */
	protected ConvertedValueContainer<?> deduceEObjectValue(EObject resolutionContext, Object feature, EClass featureType, boolean isMany, String valueAsString) {
		if(valueAsString == null || valueAsString.equals("")) {
			return new ConvertedValueContainer<EObject>(null, Status.OK_STATUS);
		}
		final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(THE_STRING_VALUE_X_CANT_BE_RESOLVED, valueAsString));
		return new ConvertedValueContainer<EObject>(null, status);
	}

	/**
	 * 
	 * @param feature
	 *        an object representing a feature
	 * @return
	 *         the type of the feature
	 */
	protected EClassifier getFeatureType(final Object feature) {
		final EClassifier featureType;
		if(feature instanceof EStructuralFeature) {
			return ((EStructuralFeature)feature).getEType();
		} else {
			featureType = null;
		}
		return featureType;
	}

	/**
	 * 
	 * @param eenum
	 *        the enumeration
	 * @param isMany
	 *        <code>true</code> if the feature is many
	 * @param valueAsString
	 *        the value to convert
	 * @return
	 *         the converted value
	 */
	protected ConvertedValueContainer<?> deduceEEnumLiteralValue(final EEnum eenum, final boolean isMany, final String valueAsString) {
		ConvertedValueContainer<?> returnedValue = null;
		IStatus iStatus = Status.OK_STATUS;
		final Collection<String> unresolvedValues = new ArrayList<String>();
		if(isMany) {
			final Collection<EEnumLiteral> values = new ArrayList<EEnumLiteral>();
			for(final String str : valueAsString.split(this.multiValueSeparator)) {
				final EEnumLiteral literal = eenum.getEEnumLiteral(str);
				if(literal != null) {
					values.add(literal);
				} else {
					unresolvedValues.add(str);
				}
			}
			if(!unresolvedValues.isEmpty()) {
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(SOME_STRING_ARE_NOT_VALID_TO_CREATE_X, EMFContants.EENUM_LITERAL), unresolvedValues);
			}
			returnedValue = new MultiConvertedValueContainer<EEnumLiteral>(values, iStatus);
		} else {
			final EEnumLiteral literal = eenum.getEEnumLiteral(valueAsString);
			if(literal != null) {
				returnedValue = new ConvertedValueContainer<EEnumLiteral>(literal, iStatus);
			} else {
				unresolvedValues.add(valueAsString);
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(THE_STRING_X_IS_NOT_VALID_TO_CREATE_Y, valueAsString, EMFContants.EENUM_LITERAL), unresolvedValues);
				returnedValue = new ConvertedValueContainer<Boolean>(null, iStatus);
			}
		}
		return returnedValue;
	}

	/**
	 * 
	 * @param isMany
	 *        <code>true</code> if the feature isMany
	 * @param valueAsString
	 *        the value to parse
	 * @return
	 *         the result of the parsing
	 */
	protected ConvertedValueContainer<?> deduceBooleanValue(final boolean isMany, final String valueAsString) {
		ConvertedValueContainer<?> returnedValue = null;
		IStatus iStatus = Status.OK_STATUS;
		final Collection<String> unresolvedValues = new ArrayList<String>();
		if(isMany) {
			final Collection<Boolean> values = new ArrayList<Boolean>();
			for(final String str : valueAsString.split(this.multiValueSeparator)) {
				if(BooleanHelper.isBoolean(str)) {
					values.add(Boolean.valueOf(valueAsString));
				} else {
					unresolvedValues.add(str);
				}
			}
			if(!unresolvedValues.isEmpty()) {
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(SOME_STRING_ARE_NOT_VALID_TO_CREATE_X, TypesConstants.BOOLEAN), unresolvedValues);
			}
			returnedValue = new MultiConvertedValueContainer<Boolean>(values, iStatus);
		} else {
			if(BooleanHelper.isBoolean(valueAsString)) {
				returnedValue = new ConvertedValueContainer<Boolean>(Boolean.valueOf(valueAsString), iStatus);
			} else {
				unresolvedValues.add(valueAsString);
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(THE_STRING_X_IS_NOT_VALID_TO_CREATE_Y, valueAsString, TypesConstants.BOOLEAN), unresolvedValues);
				returnedValue = new ConvertedValueContainer<Boolean>(null, iStatus);
			}
		}
		return returnedValue;
	}

	/**
	 * 
	 * @param isMany
	 *        <code>true</code> if the feature isMany
	 * @param valueAsString
	 *        the value to parse
	 * @return
	 *         the result of the parsing
	 */
	protected ConvertedValueContainer<?> deduceDoubleValue(final boolean isMany, final String valueAsString) {
		ConvertedValueContainer<?> returnedValue = null;
		IStatus iStatus = Status.OK_STATUS;
		final Collection<String> unresolvedValues = new ArrayList<String>();
		if(isMany) {
			final Collection<Double> values = new ArrayList<Double>();
			for(final String str : valueAsString.split(this.multiValueSeparator)) {
				final Double value = Double.valueOf(str);
				if(value != null) {
					values.add(value);
				} else {
					unresolvedValues.add(str);
				}
			}
			if(!unresolvedValues.isEmpty()) {
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(SOME_STRING_ARE_NOT_VALID_TO_CREATE_X, TypesConstants.DOUBLE), unresolvedValues);
			}
			returnedValue = new MultiConvertedValueContainer<Double>(values, iStatus);
		} else {
			try {
				returnedValue = new ConvertedValueContainer<Double>(Double.valueOf(valueAsString), iStatus);
			} catch (final NumberFormatException e) {
				unresolvedValues.add(valueAsString);
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(THE_STRING_X_IS_NOT_VALID_TO_CREATE_Y, valueAsString, TypesConstants.DOUBLE), unresolvedValues);
				returnedValue = new ConvertedValueContainer<Boolean>(null, iStatus);
			}
		}
		return returnedValue;
	}

	/**
	 * 
	 * @param isMany
	 *        <code>true</code> if the feature isMany
	 * @param valueAsString
	 *        the value to parse
	 * @return
	 *         the result of the parsing
	 */
	protected ConvertedValueContainer<?> deduceIntValue(final boolean isMany, final String valueAsString) {
		ConvertedValueContainer<?> returnedValue = null;
		IStatus iStatus = Status.OK_STATUS;
		final Collection<String> unresolvedValues = new ArrayList<String>();
		if(isMany) {
			final Collection<Integer> values = new ArrayList<Integer>();
			for(final String str : valueAsString.split(this.multiValueSeparator)) {
				try {
					values.add(Integer.valueOf(str));
				} catch (final NumberFormatException e) {
					unresolvedValues.add(str);
				}
			}
			if(!unresolvedValues.isEmpty()) {
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(SOME_STRING_ARE_NOT_VALID_TO_CREATE_X, TypesConstants.INTEGER), unresolvedValues);
			}
			returnedValue = new MultiConvertedValueContainer<Integer>(values, iStatus);
		} else {
			try {
				returnedValue = new ConvertedValueContainer<Integer>(Integer.valueOf(valueAsString), iStatus);
			} catch (final NumberFormatException e) {
				unresolvedValues.add(valueAsString);
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(THE_STRING_X_IS_NOT_VALID_TO_CREATE_Y, valueAsString, TypesConstants.INTEGER), unresolvedValues);
				returnedValue = new ConvertedValueContainer<Boolean>(null, iStatus);
			}
		}
		return returnedValue;
	}


	/**
	 * 
	 * @param isMany
	 *        <code>true</code> if the feature is many
	 * @param valueAsString
	 *        the value as string
	 * @return
	 *         the value container with the real value(s)
	 */
	protected ConvertedValueContainer<?> deduceStringValue(final boolean isMany, final String valueAsString) {
		ConvertedValueContainer<?> returnedValue = null;
		final IStatus iStatus = Status.OK_STATUS;
		if(isMany) {
			final Collection<String> values = new ArrayList<String>();
			for(final String str : valueAsString.split(this.multiValueSeparator)) {
				values.add(str);
			}
			returnedValue = new MultiConvertedValueContainer<String>(values, iStatus);
		} else {
			returnedValue = new ConvertedValueContainer<String>(valueAsString, iStatus);
		}
		return returnedValue;
	}

}
