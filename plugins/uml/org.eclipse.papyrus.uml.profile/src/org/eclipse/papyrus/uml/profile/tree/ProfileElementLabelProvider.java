/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.papyrus.uml.profile.Message;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.BooleanValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.DataTypeValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.EnumerationValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.IntegerValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.MetaclassValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.PrimitiveTypeValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypeValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StringValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.UnlimitedNaturalValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.UserPrimitiveTypeValueTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.ValueTreeObject;
import org.eclipse.papyrus.uml.profile.utils.Util;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * The Class ProfileElementLabelProvider.
 */
public class ProfileElementLabelProvider extends LabelProvider {

	/** The Constant TAB. */
	// public static final String TAB = String.valueOf("\u0009");
	public static final String TAB = "    ";

	private LabelProviderService labelProviderService;


	public ProfileElementLabelProvider() {
		try {
			labelProviderService = new LabelProviderServiceImpl();
			labelProviderService.startService();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void dispose() {
		try {
			labelProviderService.disposeService();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * Gets the image.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the image
	 */
	@Override
	public Image getImage(Object object) {
		if(object instanceof AppliedStereotypeTreeObject) {
			return ImageManager.IMG_STEREOTYPE;

		} else if(object instanceof AppliedStereotypePropertyTreeObject) {
			return ImageManager.IMG_PROPERTY;

		} else if(object instanceof BooleanValueTreeObject) {
			return ImageManager.IMG_LITERALBOOLEAN;
		} else if(object instanceof StringValueTreeObject) {
			return ImageManager.IMG_LITERALSTRING;
		} else if(object instanceof IntegerValueTreeObject) {
			return ImageManager.IMG_LITERALINTEGER;
		} else if(object instanceof UnlimitedNaturalValueTreeObject) {
			return ImageManager.IMG_LITERALUNLIMITEDNATURAL;
		} else if(object instanceof UserPrimitiveTypeValueTreeObject) {
			return ImageManager.IMG_PRIMITIVETYPE;
		} else if(object instanceof EnumerationValueTreeObject) {
			return ImageManager.IMG_ENUMERATION;
		} else if(object instanceof DataTypeValueTreeObject) {
			return ImageManager.IMG_DATATYPE;
		} else if(object instanceof StereotypeValueTreeObject) {
			return ImageManager.IMG_STEREOTYPEPROPERTY;
		} else if(object instanceof MetaclassValueTreeObject) {
			return ImageManager.IMG_METACLASS;

		} else {
			return ImageManager.IMG_UNKNOWN;
		}
	}

	/**
	 * Gets the text.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the text
	 */
	@Override
	public String getText(Object object) {

		if(object == null) {
			return "null";
		}

		if(object instanceof AppliedStereotypeTreeObject) {
			Stereotype st = ((AppliedStereotypeTreeObject)object).getStereotype();
			String stName = st.getName();
			String profileName = st.getProfile().getQualifiedName();
			String label = stName + TAB + "(from " + profileName + ")";
			return label;

		} else if(object instanceof AppliedStereotypePropertyTreeObject) {
			AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)object;
			Property prop = pTO.getProperty();
			Type propType = prop.getType();
			Object propValue = pTO.getValue();

			return getPropLabel(prop, propType, propValue);

		} else if(object instanceof ValueTreeObject) {
			return getLabel((ValueTreeObject)object);

		} else {
			return object.toString();
		}
	}

	/**
	 * Returns the label to show for a property.
	 * 
	 * @param currentPropType
	 *        current property type
	 * @param currentProp
	 *        current property
	 * @param currentPropValue
	 *        current property value
	 * 
	 * @return the String label
	 */
	private String getPropLabel(Property currentProp, Type currentPropType, Object currentPropValue) {

		String label = getPropertyShortLabel(currentProp);

		if(currentPropValue == null) {
			label = label + " = null";
			return label;
		}

		// Test property type
		// Various cases possible for property type
		// property is an enumeration
		// property is a metaclass
		// property is a stereotype
		// property is a composite class
		// default case
		if(currentPropType instanceof Enumeration) {
			label = getPropEnumerationLabel(currentProp, currentPropType, currentPropValue);
		} else if(currentPropType instanceof Stereotype) {
			label = getPropStereotypeLabel(currentProp, currentPropType, currentPropValue);
		} else if(currentPropType instanceof Class) {
			label = getPropClassLabel(currentProp, currentPropType, currentPropValue);
		} else {
			label = getPropDefaultLabel(currentProp, currentPropValue);
		}

		return label;
	}

	/**
	 * Returns the label to show for a property with type that is a Enumeration.
	 * 
	 * @param currentPropType
	 *        current property type
	 * @param currentProp
	 *        current property
	 * @param currentPropValue
	 *        current property value
	 * 
	 * @return the String label
	 */
	private String getPropEnumerationLabel(Property currentProp, Type currentPropType, Object currentPropValue) {
		String label = getPropertyShortLabel(currentProp);

		if(currentProp.getUpper() == 1) { // Multiplicity = 1
			if(currentPropValue != null) {
				// Retrieve literal
				if(currentPropValue instanceof EnumerationLiteral) {
					label = label + " = " + ((EnumerationLiteral)currentPropValue).getLabel();
				} else {
					label = label + " = " + currentPropValue;
				}
			}

		} else { // Multiplicity > 1
			label = label + " = " + currentPropValue;
		}

		return label;
	}

	/**
	 * Returns the label to show for a property with type that is a Stereotype.
	 * 
	 * @param currentPropType
	 *        current property type
	 * @param currentProp
	 *        current property
	 * @param currentPropValue
	 *        current property value
	 * 
	 * @return the String label
	 */
	private String getPropStereotypeLabel(Property currentProp, Type currentPropType, Object currentPropValue) {
		String label = getPropertyShortLabel(currentProp);

		if(currentProp.getUpper() == 1) { // Multiplicity = 1

			// retrieve the base element from the stereotype application
			Element baseElement = UMLUtil.getBaseElement((EObject)currentPropValue);
			// display the base element's qualified name
			label = label + " = " + Util.getLabel(baseElement, true);

		} else { // Multiplicity > 1

			// retrieve the base element from the stereotype application
			@SuppressWarnings("unchecked")
			List<Object> values = (List<Object>)currentPropValue;
			ArrayList<String> baseElements = new ArrayList<String>();
			for(Object value : values) {
				// display the base element's qualified name
				Element baseElement = UMLUtil.getBaseElement((EObject)value);
				String name = Util.getLabel(baseElement, true);
				if(name != null) {
					baseElements.add(name);
				}
			}

			label = label + " = " + baseElements;
		}

		return label;
	}

	/**
	 * Returns the label to show for a property with type that is a Metaclass or Composite.
	 * 
	 * @param currentPropType
	 *        current property type
	 * @param currentProp
	 *        current property
	 * @param currentPropValue
	 *        current property value
	 * 
	 * @return the String label
	 */
	private String getPropClassLabel(Property currentProp, Type currentPropType, Object currentPropValue) {
		String label = getPropertyShortLabel(currentProp);

		if(Util.isMetaclass(currentPropType)) {
			if(currentProp.getUpper() == 1) { // Multiplicity = 1
				label = label + " = " + Util.getLabel(currentPropValue, true);

			} else { // Multiplicity > 1

				@SuppressWarnings("unchecked")
				List<Object> values = (List<Object>)currentPropValue;
				ArrayList<String> elementNames = new ArrayList<String>();
				if(values != null) {
					for(int i = 0; i < values.size(); i++) {
						elementNames.add(Util.getLabel(values.get(i), true));
					}
				}

				label = label + " = " + elementNames;
			}
		}

		return label;
	}

	/**
	 * Returns the label to show for a property with type that is neither Metaclass / Composite / Enumeration / Stereotype.
	 * 
	 * @param currentProp
	 *        current property
	 * @param currentPropValue
	 *        current property value
	 * 
	 * @return the String label
	 */
	private String getPropDefaultLabel(Property currentProp, Object currentPropValue) {
		String label = getPropertyShortLabel(currentProp);

		if(currentPropValue != null) {
			label = label + " = " + labelProviderService.getLabelProvider().getText(currentPropValue);
		}

		return label;
	}

	/**
	 * Creates the label based on type + multiplicity for the selected property.
	 * 
	 * @param property
	 *        the property
	 * 
	 * @return the property short label
	 */
	private String getPropertyShortLabel(Property property) {

		String label = "";

		String derived = "";
		if(property.isDerived()) {
			derived = "/";
		}
		int upper = property.getUpper();
		int lower = property.getLower();

		Type type = property.getType();

		String typeName = type.getName();
		String name = property.getName();

		if(upper != -1) {
			label = derived + name + ": " + typeName + " " + "[" + lower + ".." + upper + "]";
		} else {
			label = derived + name + ": " + typeName + " " + "[" + lower + "..*]";
		}

		return label;
	}

	/**
	 * Gets the label.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the label
	 */
	private String getLabel(ValueTreeObject object) {

		if(object instanceof PrimitiveTypeValueTreeObject) {
			return getLabel((PrimitiveTypeValueTreeObject)object);
		} else if(object instanceof EnumerationValueTreeObject) {
			return getLabel((EnumerationValueTreeObject)object);
		} else if(object instanceof DataTypeValueTreeObject) {
			return getLabel((DataTypeValueTreeObject)object);
		} else if(object instanceof StereotypeValueTreeObject) {
			return getLabel((StereotypeValueTreeObject)object);
		} else if(object instanceof MetaclassValueTreeObject) {
			return getLabel((MetaclassValueTreeObject)object);
		} // else
		return object.getValue().toString();
	}

	/**
	 * Gets the label.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the label
	 */
	private String getLabel(PrimitiveTypeValueTreeObject object) {

		Object value = object.getValue();
		if(value != null) {
			return value.toString();
		}

		return "undefined";
	}

	/**
	 * Gets the label.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the label
	 */
	private String getLabel(DataTypeValueTreeObject object) {

		Object value = object.getValue();
		if(value != null) {
			return value.toString();
		}

		return "undefined";
	}

	/**
	 * Gets the label.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the label
	 */
	private String getLabel(EnumerationValueTreeObject object) {
		EnumerationValueTreeObject eTO = object;
		Property property = ((AppliedStereotypePropertyTreeObject)eTO.getParent()).getProperty();
		Object value = eTO.getValue();

		EnumerationLiteral eLiteral = null;
		// Prepare Item data
		if(value instanceof EnumerationLiteral) {
			eLiteral = (EnumerationLiteral)value;

		} else if(value instanceof EEnumLiteral) {
			EEnumLiteral eEnumLiteral = (EEnumLiteral)value;
			Object tmp = Util.getValueObjectFromString(eEnumLiteral.getName(), property.getType());
			eLiteral = ((EnumerationLiteral)tmp);

		} else if(value instanceof String) {
			String literalString = (String)value;
			Object tmp = Util.getValueObjectFromString(literalString, property.getType());
			eLiteral = ((EnumerationLiteral)tmp);

		} else if(value instanceof Enumerator) { // Enumeration in static profile
			String literalString = ((Enumerator)value).getLiteral();
			Object tmp = Util.getValueObjectFromString(literalString, property.getType());
			eLiteral = ((EnumerationLiteral)tmp);

		} else { // Error
			String err = "Value " + value.toString() + " of Property " + property.getName() + " is not an EnumerationLiteral.";
			Message.error(err);
		}

		if(eLiteral != null) {
			return eLiteral.getName();
		} else {
			return "undefined";
		}
	}

	/**
	 * Gets the label.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the label
	 */
	private String getLabel(StereotypeValueTreeObject object) {
		StereotypeValueTreeObject sTO = object;
		Property property = ((AppliedStereotypePropertyTreeObject)sTO.getParent()).getProperty();
		Object value = sTO.getValue();

		Element baseElement = null;

		if(value instanceof EObject) {
			// retrieve the base element from the stereotype application
			baseElement = UMLUtil.getBaseElement((EObject)value);

		} else { // Error
			String err = "Type " + (value != null ? value.toString() : "null") + " of Property " + property.getName() + " is not an EObject.";
			Message.error(err);
		}

		if(baseElement != null) {
			String label = baseElement.toString();
			if(baseElement instanceof ValueSpecification) {
				return Util.getOriginLabel((ValueSpecification)baseElement);

			} else if(baseElement instanceof NamedElement) {
				NamedElement baseNamedElement = (NamedElement)baseElement;
				if(baseNamedElement.isSetName()) {
					label = baseNamedElement.getQualifiedName();
				}
			}

			return label;
		}

		return "undefined";
	}

	/**
	 * Gets the label.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the label
	 */
	private String getLabel(MetaclassValueTreeObject object) {
		MetaclassValueTreeObject sTO = object;
		Object value = sTO.getValue();

		if(value instanceof ValueSpecification) {
			return Util.getOriginLabel((ValueSpecification)value);

		} else if(value instanceof Element) {
			return Util.getLabel(value, false);
		}

		return "undefined";
	}
}
