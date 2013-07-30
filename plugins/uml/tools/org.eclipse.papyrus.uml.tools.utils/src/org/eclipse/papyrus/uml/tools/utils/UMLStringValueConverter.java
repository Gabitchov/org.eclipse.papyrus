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
package org.eclipse.papyrus.uml.tools.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter;
import org.eclipse.papyrus.infra.tools.converter.ConvertedValueContainer;
import org.eclipse.papyrus.infra.tools.converter.MultiConvertedValueContainer;
import org.eclipse.papyrus.infra.tools.converter.StringValueConverterStatus;
import org.eclipse.papyrus.uml.tools.utils.messages.Messages;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * ULM String converter
 * 
 * @author vl222926
 * 
 */
public class UMLStringValueConverter extends EMFStringValueConverter {

	final protected Map<EClass, NameResolutionHelper> nameResolutionHelpers = new HashMap<EClass, NameResolutionHelper>();

	public static final String THE_ENUMERATION_LITERAL_X_CANT_BE_FOUND = Messages.UMLStringValueConverter_TheEnumerationLiteralXCantBeFound;



	/**
	 * 
	 * Constructor.
	 * 
	 * @param context
	 *        the context used to resolve the value
	 * @param multiValueSeparator
	 *        the string used to seprate values
	 */
	public UMLStringValueConverter(final EObject context, final String multiValueSeparator) {
		super(context, multiValueSeparator);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		nameResolutionHelpers.clear();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter#getFeatureUpperBound(java.lang.Object)
	 * 
	 * @param feature
	 * @return
	 */
	@Override
	protected int getFeatureUpperBound(Object feature) {
		if(feature instanceof Property) {
			return ((Property)feature).getUpper();
		}
		return super.getFeatureUpperBound(feature);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter#getFeatureType(java.lang.Object)
	 * 
	 * @param feature
	 * @return
	 */
	@Override
	protected EClassifier getFeatureType(Object feature) {
		final EClassifier featureType;
		if(feature instanceof Property) {
			final Type type = ((Property)feature).getType();
			if(type instanceof PrimitiveType) {
				final PrimitiveType pType = (PrimitiveType)type;
				final String name = pType.getName();
				if(PrimitivesTypesUtils.UML_BOOLEAN.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEBoolean();
				} else if(PrimitivesTypesUtils.UML_INTEGER.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEInt();
				} else if(PrimitivesTypesUtils.UML_REAL.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEDouble();
				} else if(PrimitivesTypesUtils.UML_STRING.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEString();
				} else if(PrimitivesTypesUtils.UML_UNLIMITED_NATURAL.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEInt();
				} else { //custom PrimitiveType
					featureType = EcorePackage.eINSTANCE.getEString();
				}
			} else if(type instanceof Enumeration) {
				featureType = UMLPackage.eINSTANCE.getEnumeration();
			} else if(type instanceof DataType) {//FIXME manage the data type
				featureType = EcorePackage.eINSTANCE.getEString();
			} else {
				featureType = type.eClass();
			}
		} else {
			featureType = super.getFeatureType(feature);
		}
		return featureType;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter#doDeduceValueFromString(java.lang.Object, java.lang.String)
	 * 
	 * @param feature
	 * @param valueAsString
	 * @return
	 */
	@Override
	protected ConvertedValueContainer<?> doDeduceValueFromString(Object feature, String valueAsString) {
		final EClassifier featureType = getFeatureType(feature);
		if(feature instanceof Property) {
			return deduceValueFromString(feature, featureType, valueAsString);
		}
		return super.doDeduceValueFromString(feature, valueAsString);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter#deduceValueFromString(java.lang.Object, org.eclipse.emf.ecore.EClassifier,
	 *      java.lang.String)
	 * 
	 * @param feature
	 * @param featureType
	 * @param valueAsString
	 * @return
	 */
	@Override
	protected ConvertedValueContainer<?> deduceValueFromString(Object feature, EClassifier featureType, String valueAsString) {
		if(featureType instanceof EClass && feature instanceof Property) {
			final int upperbound = getFeatureUpperBound(feature);
			boolean isMany = (upperbound > 1 || upperbound == -1);
			if(PrimitivesTypesUtils.ENUMERATION.equals(featureType.getName())) {
				return deduceEnumerationLiteralValue(isMany, valueAsString, (Enumeration)((Property)feature).getType());
			}
		}
		return super.deduceValueFromString(feature, featureType, valueAsString);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter#deduceEObjectValue(org.eclipse.emf.ecore.EObject, java.lang.Object,
	 *      org.eclipse.emf.ecore.EClass, boolean, java.lang.String)
	 * 
	 * @param resolutionContext
	 * @param feature
	 * @param featureType
	 * @param isMany
	 * @param valueAsString
	 * @return
	 * @throws StringValueSolverException
	 */
	@Override
	protected ConvertedValueContainer<?> deduceEObjectValue(EObject resolutionContext, Object feature, EClass eClass, boolean isMany, String valueAsString) {
		final Namespace namespace;
		if(resolutionContext instanceof Namespace) {
			namespace = (Namespace)resolutionContext;
		} else if(resolutionContext instanceof Element) {
			namespace = ((Element)resolutionContext).getNearestPackage();
		} else {
			namespace = null;
		}
		if(valueAsString != null && valueAsString.length() != 0 && namespace != null) {
			IStatus iStatus = Status.OK_STATUS;
			final Collection<String> unresolvedValues = new ArrayList<String>();
			ConvertedValueContainer<?> returnedValue = null;
			NameResolutionHelper helper = this.nameResolutionHelpers.get(eClass);
			if(helper == null) {
				helper = new NameResolutionHelper(namespace, eClass);
				this.nameResolutionHelpers.put(eClass, helper);
			}
			if(isMany) {
				final Collection<NamedElement> values = new HashSet<NamedElement>();
				for(final String str : valueAsString.split(this.multiValueSeparator)) {
					final List<NamedElement> elements = helper.getNamedElements(str);
					if(elements.size() == 1) {
						values.add(elements.get(0));
					} else {
						unresolvedValues.add(str);
					}
					if(!unresolvedValues.isEmpty()) {
						iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(SOME_STRING_CANT_BE_RESOLVED_TO_FIND_X, eClass.getName()), unresolvedValues);
					}
					returnedValue = new MultiConvertedValueContainer<NamedElement>(values, iStatus);
				}
			} else {
				final List<NamedElement> elements = helper.getNamedElements(valueAsString);
				if(elements.size() == 1) {
					//it is OK
					returnedValue = new ConvertedValueContainer<NamedElement>(elements.get(0), iStatus);
				} else {
					unresolvedValues.add(valueAsString);
					iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(NO_X_REPRESENTED_BY_Y_HAVE_BEEN_FOUND, eClass.getName(), valueAsString), unresolvedValues);
					returnedValue = new ConvertedValueContainer<EObject>(null, iStatus);
				}
			}
			return returnedValue;
		}
		return super.deduceEObjectValue(resolutionContext, feature, eClass, isMany, valueAsString);
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
	protected ConvertedValueContainer<?> deduceEnumerationLiteralValue(final boolean isMany, final String valueAsString, final Enumeration enumeration) {
		ConvertedValueContainer<?> returnedValue = null;
		IStatus iStatus = Status.OK_STATUS;
		final Collection<String> unresolvedValues = new ArrayList<String>();
		if(isMany) {
			final Collection<EnumerationLiteral> values = new ArrayList<EnumerationLiteral>();
			for(final String str : valueAsString.split(this.multiValueSeparator)) {
				final EnumerationLiteral lit = (EnumerationLiteral)enumeration.getMember(str);
				if(lit != null) {
					values.add(lit);
				} else {
					unresolvedValues.add(str);
				}
			}
			if(!unresolvedValues.isEmpty()) {
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(SOME_STRING_ARE_NOT_VALID_TO_CREATE_X, PrimitivesTypesUtils.ENUMERATION_LITERAL), unresolvedValues);
			}
			returnedValue = new MultiConvertedValueContainer<EnumerationLiteral>(values, iStatus);
		} else {
			final EnumerationLiteral lit = (EnumerationLiteral)enumeration.getMember(valueAsString);
			if(lit == null) {
				unresolvedValues.add(valueAsString);
				iStatus = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(THE_ENUMERATION_LITERAL_X_CANT_BE_FOUND, valueAsString, PrimitivesTypesUtils.ENUMERATION_LITERAL), unresolvedValues);
			}
			returnedValue = new ConvertedValueContainer<EnumerationLiteral>(lit, iStatus);
		}
		return returnedValue;
	}
}
