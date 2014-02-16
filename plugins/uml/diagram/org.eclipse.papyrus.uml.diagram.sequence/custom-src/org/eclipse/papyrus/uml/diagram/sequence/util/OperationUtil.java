package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.tools.util.StringHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.ParameterUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.papyrus.uml.tools.utils.TypedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ValueSpecification;

public class OperationUtil {

	public static String getCustomLabel(Message e, int paramIndex, Parameter parameter, Collection<String> displayValue) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		if(displayValue.contains(ICustomAppearance.DISP_VISIBILITY)) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(parameter));
		}
		// direction property
		if(displayValue.contains(ICustomAppearance.DISP_PARAMETER_DIRECTION)) {
			buffer.append(" ");
			buffer.append(parameter.getDirection().getLiteral());
		}
		boolean showEqualMark = false;
		// name
		if(displayValue.contains(ICustomAppearance.DISP_PARAMETER_NAME)) {
			buffer.append(" ");
			String name = StringHelper.trimToEmpty(parameter.getName());
			if(name.trim().length() > 0) {
				showEqualMark = true;
			}
			buffer.append(name);
		}
		if(displayValue.contains(ICustomAppearance.DISP_PARAMETER_TYPE)) {
			// type
			if(parameter.getType() != null) {
				buffer.append(": " + StringHelper.trimToEmpty(parameter.getType().getName()));
			} else {
				buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
			}
			showEqualMark = true;
		}
		if(displayValue.contains(ICustomAppearance.DISP_PARAMETER_MULTIPLICITY)) {
			// multiplicity -> do not display [1]
			String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(parameter);
			buffer.append(multiplicity);
		}
		if(displayValue.contains(ICustomAppearance.DISP_DERIVE)) {
			String value = getValue(e, paramIndex, parameter);
			if(value != null) {
				if(showEqualMark) {
					buffer.append(" = ");
				}
				buffer.append(value);
			}
		} else if(displayValue.contains(ICustomAppearance.DISP_PARAMETER_DEFAULT)) {
			// default value
			if(parameter.getDefault() != null) {
				if(showEqualMark) {
					buffer.append(" = ");
				}
				buffer.append(parameter.getDefault());
			}
		}
		if(displayValue.contains(ICustomAppearance.DISP_MODIFIERS)) {
			boolean multiLine = displayValue.contains(ICustomAppearance.DISP_MULTI_LINE);
			// property modifiers
			String modifiers = ParameterUtil.getModifiersAsString(parameter, multiLine);
			if(!modifiers.equals("")) {
				if(multiLine) {
					buffer.append("\n");
				}
				buffer.append(modifiers);
			}
		}
		return buffer.toString();
	}

	private static String getValue(Message e, int paramIndex, Parameter parameter) {
		try {
			EList<ValueSpecification> arguments = e.getArguments();
			if(arguments.size() > paramIndex) {
				return ValueSpecificationUtil.getSpecificationValue(arguments.get(paramIndex));
			}
		} catch (Exception e1) {
		}
		return null;
	}

	public static String getCustomLabel(Message message, Operation operation, Collection<String> displayValue) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" "); // adds " " first for correct display considerations
		// visibility
		if(displayValue.contains(ICustomAppearance.DISP_VISIBILITY)) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(operation));
		}
		// name
		if(displayValue.contains(ICustomAppearance.DISP_NAME)) {
			buffer.append(" ");
			buffer.append(StringHelper.trimToEmpty(operation.getName()));
		}
		//
		// parameters : '(' parameter-list ')'
		buffer.append("(");
		buffer.append(getParametersAsString(message, operation, displayValue));
		buffer.append(")");
		// return type
		if(displayValue.contains(ICustomAppearance.DISP_RT_TYPE) || displayValue.contains(ICustomAppearance.DISP_TYPE)) {
			buffer.append(getReturnTypeAsString(operation, displayValue));
		}
		// modifiers
		if(displayValue.contains(ICustomAppearance.DISP_MODIFIERS)) {
			String modifiers = getModifiersAsString(operation);
			if(!modifiers.equals("")) {
				buffer.append("{");
				buffer.append(modifiers);
				buffer.append("}");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns operation modifiers as string, separated with comma.
	 * 
	 * @return a string containing the modifiers
	 */
	private static String getModifiersAsString(Operation operation) {
		StringBuffer buffer = new StringBuffer();
		boolean needsComma = false;
		// Return parameter modifiers
		Parameter returnParameter = OperationUtil.getReturnParameter(operation);
		if(returnParameter != null) {
			// non unique parameter
			if(!returnParameter.isUnique()) {
				buffer.append("nonunique");
				needsComma = true;
			}
			// return parameter has ordered values
			if(returnParameter.isOrdered()) {
				if(needsComma) {
					buffer.append(", ");
				}
				buffer.append("ordered");
				needsComma = true;
			}
		}
		// is the operation a query ?
		if(operation.isQuery()) {
			if(needsComma) {
				buffer.append(", ");
			}
			buffer.append("query");
			needsComma = true;
		}
		// is the operation redefining another operation ?
		Iterator<Operation> it = operation.getRedefinedOperations().iterator();
		while(it.hasNext()) {
			Operation currentOperation = it.next();
			if(needsComma) {
				buffer.append(", ");
			}
			buffer.append("redefines ");
			buffer.append(currentOperation.getName());
			needsComma = true;
		}
		// has the operation a constraint ?
		Iterator<Constraint> it2 = operation.getOwnedRules().iterator();
		while(it2.hasNext()) {
			Constraint constraint = it2.next();
			if(needsComma) {
				buffer.append(", ");
			}
			if(constraint.getSpecification() != null) {
				buffer.append(constraint.getSpecification().stringValue());
			}
			needsComma = true;
		}
		return buffer.toString();
	}

	/**
	 * Returns return parameter label as a string, string parametrized with a style mask.
	 * 
	 * @param style
	 *        the mask that indicates which element to display
	 * @return a string containing the return parameter type
	 */
	private static String getReturnTypeAsString(Operation operation, Collection<String> displayValue) {
		boolean displayType = displayValue.contains(ICustomAppearance.DISP_RT_TYPE) || displayValue.contains(ICustomAppearance.DISP_TYPE);
		boolean displayMultiplicity = displayValue.contains(ICustomAppearance.DISP_RT_MULTIPLICITY) || displayValue.contains(ICustomAppearance.DISP_MULTIPLICITY);
		StringBuffer label = new StringBuffer("");
		// Retrieve the return parameter (assume to be unique if defined)
		Parameter returnParameter = getReturnParameter(operation);
		// Create the string for the return type
		if(returnParameter == null) {
			// no-operation: label = ""
		} else if(!displayType && !displayMultiplicity) {
			// no-operation: label = ""
		} else {
			label.append(": ");
			if(displayType) {
				label.append(TypedElementUtil.getTypeAsString(returnParameter));
			}
			if(displayMultiplicity) {
				label.append(MultiplicityElementUtil.getMultiplicityAsString(returnParameter));
			}
		}
		return label.toString();
	}

	/**
	 * Gives the return parameter for this operation, or <code>null</code> if none exists.
	 * 
	 * @return the return parameter of the operation or <code>null</code>
	 */
	private static Parameter getReturnParameter(Operation operation) {
		// Retrieve the return parameter (assume to be unique if defined)
		Parameter returnParameter = null;
		Iterator<Parameter> it = operation.getOwnedParameters().iterator();
		while((returnParameter == null) && (it.hasNext())) {
			Parameter parameter = it.next();
			if(parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
				returnParameter = parameter;
			}
		}
		return returnParameter;
	}

	/**
	 * Returns operation parameters as a string, the label is customized using a bit mask
	 * 
	 * @param e
	 * 
	 * @return a string containing all parameters separated by commas
	 */
	private static String getParametersAsString(Message e, Operation operation, Collection<String> displayValue) {
		StringBuffer paramString = new StringBuffer();
		Iterator<Parameter> paramIterator = operation.getOwnedParameters().iterator();
		boolean firstParameter = true;
		int paramIndex = 0;
		while(paramIterator.hasNext()) {
			Parameter parameter = paramIterator.next();
			// Do not include return parameters
			if(!parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
				// get the label for this parameter
				String parameterString = getCustomLabel(e, paramIndex, parameter, displayValue).trim();
				paramIndex++;
				if(!parameterString.equals("")) {
					if(!firstParameter) {
						paramString.append(", ");
					}
					paramString.append(parameterString);
					firstParameter = false;
				}
			}
		}
		return paramString.toString();
	}
}
