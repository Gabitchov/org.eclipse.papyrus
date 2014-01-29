package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.tools.util.StringHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.ValueSpecification;

public class SignalUtil {

	private static String getCustomPropertyLabel(Message e, Property property, int style) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(property));
		}
		// derived property
		if((style & ICustomAppearence.DISP_DERIVE) != 0) {
			if(property.isDerived()) {
				buffer.append("/");
			}
		}
		boolean showEqualMark = false;
		// name
		if((style & ICustomAppearence.DISP_PARAMETER_NAME) != 0) {
			buffer.append(" ");
			String name = StringHelper.trimToEmpty(property.getName());
			if(name.trim().length() > 0) {
				showEqualMark = true;
			}
			buffer.append(name);
		}
		if((style & ICustomAppearence.DISP_PARAMETER_TYPE) != 0) {
			// type
			if(property.getType() != null) {
				buffer.append(": " + StringHelper.trimToEmpty(property.getType().getName()));
			} else {
				buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
			}
			showEqualMark = true;
		}
		if((style & ICustomAppearence.DISP_MULTIPLICITY) != 0) {
			// multiplicity -> do not display [1]
			String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
			buffer.append(multiplicity);
		}
		if((style & ICustomAppearence.DISP_DERIVE) != 0) {
			String value = getValue(e, property);
			if(value != null) {
				if(showEqualMark) {
					buffer.append(" = ");
				}
				buffer.append(value);
			}
		} else if((style & ICustomAppearence.DISP_PARAMETER_DEFAULT) != 0) {
			// default value
			if(property.getDefault() != null) {
				if(showEqualMark) {
					buffer.append(" = ");
				}
				buffer.append(property.getDefault());
			}
		}
		if((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
			boolean multiLine = ((style & ICustomAppearence.DISP_MULTI_LINE) != 0);
			// property modifiers
			String modifiers = PropertyUtil.getModifiersAsString(property, multiLine);
			if(!modifiers.equals("")) {
				if(multiLine) {
					buffer.append("\n");
				}
				if(!buffer.toString().endsWith(" ")) {
					buffer.append(" ");
				}
				buffer.append(modifiers);
			}
		}
		return buffer.toString();
	}

	private static String getValue(Message e, Property property) {
		try {
			Signal signal = (Signal)property.getOwner();
			int index = signal.getOwnedAttributes().indexOf(property);
			EList<ValueSpecification> arguments = e.getArguments();
			if(arguments.size() > index) {
				return ValueSpecificationUtil.getSpecificationValue(arguments.get(index));
			}
		} catch (Exception e1) {
		}
		return null;
	}

	/**
	 * return the custom label of the signal, given UML2 specification and a custom style.
	 *
	 * @param e
	 *
	 * @param style
	 *        the integer representing the style of the label
	 *
	 * @return the string corresponding to the label of the signal
	 */
	public static String getCustomLabel(Message e, Signal signal, int style) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" "); // adds " " first for correct display considerations
		// visibility
		if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(signal));
		}
		// name
		if((style & ICustomAppearence.DISP_NAME) != 0) {
			buffer.append(" ");
			buffer.append(StringHelper.trimToEmpty(signal.getName()));
		}
		//
		// parameters : '(' parameter-list ')'
		buffer.append("(");
		buffer.append(getPropertiesAsString(e, signal, style));
		buffer.append(")");
		return buffer.toString();
	}

	/**
	 * Returns signal properties as a string, the label is customized using a bit mask
	 *
	 * @return a string containing all properties separated by commas
	 */
	private static String getPropertiesAsString(Message e, Signal signal, int style) {
		StringBuffer propertiesString = new StringBuffer();
		boolean firstProperty = true;
		for(Property property : signal.getOwnedAttributes()) {
			// get the label for this property
			String propertyString = getCustomPropertyLabel(e, property, style).trim();
			if(!propertyString.equals("")) {
				if(!firstProperty) {
					propertiesString.append(", ");
				}
				propertiesString.append(propertyString);
				firstProperty = false;
			}
		}
		return propertiesString.toString();
	}
}
