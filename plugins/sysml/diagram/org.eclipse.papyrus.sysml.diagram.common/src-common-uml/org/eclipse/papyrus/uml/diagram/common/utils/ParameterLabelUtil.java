package org.eclipse.papyrus.uml.diagram.common.utils;

import java.util.Collection;

import org.eclipse.papyrus.gmf.diagram.common.parser.IMaskManagedSemanticParser;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ValueSpecification;


public class ParameterLabelUtil {

	/** The String format for displaying a {@link Parameter} with direction */
	protected static final String DIRECTION_FORMAT = "%s %s";

	/** The String format for displaying a {@link Parameter} label with its name */
	protected static final String NAME_FORMAT = "%s%s";

	/** The String format for displaying a {@link Parameter} label with its type */
	protected static final String TYPE_FORMAT = "%s: %s";

	/** The String format for displaying a {@link Parameter} label with its multiplicity */
	protected static final String MULTIPLICITY_FORMAT = "%s [%s..%s]";

	/** The String format for displaying a {@link Parameter} label with its default value */
	protected static final String DEFAULT_VALUE_FORMAT = "%s= %s";

	/** The String format for displaying a {@link Parameter} label with its modifiers */
	protected static final String MODIFIER_FORMAT = "%s{%s}";

	public static String getPrintString(Parameter parameter, Collection<String> displayValue) {
		if(displayValue.isEmpty()) {
			return IMaskManagedSemanticParser.MaskedLabel;
		}

		String result = "";

		if(parameter != null) {

			// manage direction
			if(displayValue.contains(ILabelPreferenceConstants.DISP_DIRECTION) || displayValue.contains(ILabelPreferenceConstants.DISP_PARAMETER_DIRECTION)) {
				String direction;
				switch(parameter.getDirection().getValue()) {
				case ParameterDirectionKind.IN:
					direction = "in";
					break;
				case ParameterDirectionKind.OUT:
					direction = "out";
					break;
				case ParameterDirectionKind.INOUT:
					direction = "inout";
					break;
				case ParameterDirectionKind.RETURN:
					direction = "return";
					break;
				default:
					direction = "in";
					break;
				}
				result = String.format(DIRECTION_FORMAT, direction, result);
			}

			// manage name
			if((displayValue.contains(ILabelPreferenceConstants.DISP_NAME) || displayValue.contains(ILabelPreferenceConstants.DISP_PARAMETER_NAME)) && (parameter.isSetName())) {
				String name = parameter.getName();
				result = String.format(NAME_FORMAT, result, name);
			}

			// manage type
			if(displayValue.contains(ILabelPreferenceConstants.DISP_TYPE) || displayValue.contains(ILabelPreferenceConstants.DISP_PARAMETER_TYPE)) {
				String type = "<Undefined>";
				if(parameter.getType() != null) {
					type = parameter.getType().getName();
				}

				// If type is undefined only show "<Undefined>" when explicitly asked.
				if(displayValue.contains(ILabelPreferenceConstants.DISP_UNDEFINED_TYPE) || (!"<Undefined>".equals(type))) {
					result = String.format(TYPE_FORMAT, result, type);
				}
			}

			// manage multiplicity
			String lower = (parameter.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(parameter.getLowerValue()) : "1";
			String upper = (parameter.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(parameter.getUpperValue()) : "1";
			if((displayValue.contains(ILabelPreferenceConstants.DISP_PARAMETER_MULTIPLICITY) || displayValue.contains(ILabelPreferenceConstants.DISP_MULTIPLICITY)) && !("1".equals(lower) && "1".equals(upper))) {
				result = String.format(MULTIPLICITY_FORMAT, result, lower, upper);
			}

			// manage default value
			if((displayValue.contains(ILabelPreferenceConstants.DISP_PARAMETER_DEFAULT) || displayValue.contains(ILabelPreferenceConstants.DISP_DEFAULT_VALUE)) && ((parameter.getDefaultValue() != null))) {
				ValueSpecification valueSpecification = parameter.getDefaultValue();
				if((valueSpecification instanceof InstanceValue && parameter.getType().equals(valueSpecification.getType())) || !(valueSpecification instanceof InstanceValue)) {
					result = String.format(DEFAULT_VALUE_FORMAT, result, ValueSpecificationUtil.getSpecificationValue(valueSpecification));
				}
			}

			// manage modifier
			if(displayValue.contains(ILabelPreferenceConstants.DISP_PARAMETER_MODIFIERS) || displayValue.contains(ILabelPreferenceConstants.DISP_MODIFIERS)) {
				StringBuffer sb = new StringBuffer();
				if(parameter.isOrdered()) {
					sb.append(sb.length() == 0 ? "ordered" : ", ordered");
				}
				if(parameter.isUnique()) {
					sb.append(sb.length() == 0 ? "unique" : ", unique");
				}
				if(parameter.isStream()) {
					sb.append(sb.length() == 0 ? "stream" : ", stream");
				}
				if(parameter.isException()) {
					sb.append(sb.length() == 0 ? "exception" : ", exception");
				}
				if(sb.length() != 0) {
					result = String.format(MODIFIER_FORMAT, result, sb.toString());
				}
			}

		}
		return result;
	}

}
