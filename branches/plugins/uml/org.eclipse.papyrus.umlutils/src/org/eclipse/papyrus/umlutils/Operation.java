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
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.Operation</code><BR>
 * 
 */
public class Operation extends NamedElement {

	public static final String PARAM_UNDEFINED_NAME = "<undefined>";

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Operation uml2Operation;

	/**
	 * 
	 */
	private final String PARAMETER_SEPARATOR = "#";

	/**
	 * 
	 */
	protected final static String PUBLIC_STRING = "+";

	/**
	 * 
	 */
	protected final static String PROTECTED_STRING = "#";

	/**
	 * 
	 */
	protected final static String PRIVATE_STRING = "-";

	/**
	 * 
	 */
	protected final static String PACKAGE_STRING = "~";

	/**
	 * 
	 */
	protected final static String REDEFINES_STRING = "redefines";

	/**
	 * 
	 */
	protected final static String QUERY_STRING = "query";

	/**
	 * 
	 */
	protected final static String ORDERED_STRING = "ordered";

	/**
	 * 
	 */
	protected final static String UNIQUE_STRING = "unique";

	/**
	 * 
	 * 
	 * @param uml2Operation
	 */
	public Operation(org.eclipse.uml2.uml.Operation uml2Operation) {
		super(uml2Operation);
		this.uml2Operation = uml2Operation;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Operation.
	 */
	public org.eclipse.uml2.uml.Operation getUml2Operation() {
		return uml2Operation;
	}

	/**
	 * Gives the return parameter for this operation, or <code>null</code> if none exists.
	 * 
	 * @return the return parameter of the operation or <code>null</code>
	 */
	public Parameter getReturnParameter() {
		Parameter returnParameter = null;

		Iterator parametersIterator = uml2Operation.getOwnedParameters().iterator();
		boolean found = false;
		org.eclipse.uml2.uml.Parameter currentParameter;
		while (!found && parametersIterator.hasNext()) {
			currentParameter = (org.eclipse.uml2.uml.Parameter) parametersIterator.next();
			if (currentParameter.getDirection().getValue() == ParameterDirectionKind.RETURN) {
				found = true;
				returnParameter = new Parameter(currentParameter);
			}
		}
		return returnParameter;
	}

	/**
	 * Gives the return type of the operation.
	 * 
	 * @return the return type of the '<code>Operation</code>'
	 */
	public Type getReturnType() {
		Parameter returnParameter = this.getReturnParameter();
		return (returnParameter != null) ? returnParameter.getType() : null;
	}

	/**
	 * Give the visibility of the operation.
	 * 
	 * @return An integer representing the visibility of the operation. Possible values:
	 *         <ul>
	 *         <li> <code>com.cea.papyrus.umlutils.Visibility.PUBLIC</code>
	 *         <li> <code>com.cea.papyrus.umlutils.Visibility.PRIVATE</code>
	 *         <li> <code>com.cea.papyrus.umlutils.Visibility.PROTECTED</code>
	 *         <li> <code>com.cea.papyrus.umlutils.Visibility.PACKAGE</code>
	 *         </ul>
	 */
	public int getVisibility() {
		return uml2Operation.getVisibility().getValue();
	}

	/**
	 * Give the visibility of the operation as a string, as defined in the UML2 standard.
	 * 
	 * @return A String representing the visibility of the operation. Possible values:
	 *         <ul>
	 *         <li>public: <code>"+"</code>
	 *         <li>private: <code>"-"</code>
	 *         <li>protected: <code>"#"</code>
	 *         <li>package: <code>"~"</code>
	 *         </ul>
	 */
	@Override
	public String getVisibilityAsString() {
		String visibility = PUBLIC_STRING;

		VisibilityKind vis = uml2Operation.getVisibility();
		switch (vis.getValue()) {
		case VisibilityKind.PACKAGE:
			visibility = PACKAGE_STRING;
			break;
		case VisibilityKind.PROTECTED:
			visibility = PROTECTED_STRING;
			break;
		case VisibilityKind.PRIVATE:
			visibility = PRIVATE_STRING;
			break;
		default:
			visibility = PUBLIC_STRING;
			break;
		}
		return visibility;

	}

	/**
	 * Tells if the operation is abstract.
	 * 
	 * @return
	 */
	public boolean isAbstract() {
		return uml2Operation.isAbstract();
	}

	/**
	 * Get the Full name of the operation (ie the operation name prefixed with the class name if needed).
	 * 
	 * @return The full operation name;
	 */
	@Override
	public String getFullName() {
		String visibilityPrefix = "";

		if ((getVisibility() == VisibilityKind.PROTECTED) && !hasStereotype("noPrefix")) {
			visibilityPrefix = "_PROTECTED_";
		}
		if (uml2Operation.getOwner() instanceof org.eclipse.uml2.uml.Class) {
			Class parent = new Class((org.eclipse.uml2.uml.Class) uml2Operation.getOwner());
			return visibilityPrefix + parent.getFullName() + "_" + getName();
		} else if (uml2Operation.getOwner() instanceof org.eclipse.uml2.uml.Interface) {
			Interface parent = new Interface((org.eclipse.uml2.uml.Interface) uml2Operation.getOwner());
			return visibilityPrefix + parent.getFullName() + "_" + getName();
		} else {
			return getName();
		}
	}

	/**
	 * Get the signature of the operation, ie the operation name, suffixed by the type of its parameters.
	 * 
	 * @return the signature of the operation
	 */
	public String getSignature() {
		String tmp = "";

		Iterator parametersType = getInParameters().iterator();
		while (parametersType.hasNext()) {
			Parameter parameter = (Parameter) parametersType.next();
			tmp = tmp + PARAMETER_SEPARATOR + parameter.getType().getName();
		}

		return this.getName() + tmp;
	}

	/**
	 * Get the full signature of the operation, ie the operation name, prefixed with the class full name and suffixed by the type of its parameters.
	 * 
	 * @return the full signature of the operation
	 */
	public String getFullSignature() {
		String tmp = "";

		Iterator parametersType = getInParameters().iterator();
		while (parametersType.hasNext()) {
			Parameter parameter = (Parameter) parametersType.next();
			if (parameter.getType() == null) {
				// undefined parameter
				tmp = tmp + PARAMETER_SEPARATOR + Property.UNDEFINED_TYPE_NAME;
			} else {
				tmp = tmp + PARAMETER_SEPARATOR + parameter.getType().getName();
			}
		}
		return this.getQualifiedName() + tmp;
	}

	/**
	 * Create operation label showing parameters
	 * 
	 * @param currentOperation
	 * @return
	 */
	public static String getSignature(org.eclipse.uml2.uml.Operation operation, Boolean withQualifiedName) {
		Operation op = new Operation(operation);
		String label = "";

		if ((withQualifiedName != null) && (withQualifiedName)) {
			label = op.getQualifiedName();
		} else {
			label = op.getName();
		}

		label = label + "(" + op.getParametersAsSignature() + ")";

		if (!op.getReturnTypeAsString().equals("")) {
			label = label + " : " + op.getReturnTypeAsString();
		}

		return label;
	}

	/**
	 * generate the label for the Operation, corresponding to the UML2 notation.
	 * 
	 * @return the label of the operation
	 */
	public String getLabel() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" "); // adds at the begining a " " to display correctly the label

		// visibility
		buffer.append(this.getVisibilityAsString());

		// name
		buffer.append(" ");
		buffer.append(this.getName());

		// parameters : '(' parameter-list ')'
		buffer.append("(");
		buffer.append(this.getParametersAsSignature());
		buffer.append(")");

		// return type
		buffer.append(this.getReturnTypeAsString());

		// modifiers
		String modifiers = this.getModifiersAsString();
		if (!modifiers.equals("")) {
			buffer.append("{");
			buffer.append(modifiers);
			buffer.append("}");
		}

		return buffer.toString();
	}

	/**
	 * return the custom label of the operation, given UML2 specification and a custom style.
	 * 
	 * @param style
	 *            the integer representing the style of the label
	 * 
	 * @return the string corresponding to the label of the operation
	 */
	public String getCustomLabel(int style) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" "); // adds at the begining a " " to display correctly the label

		// visibility
		if ((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
			buffer.append(this.getVisibilityAsString());
		}

		// name
		if ((style & ICustomAppearence.DISP_NAME) != 0) {
			buffer.append(" ");
			buffer.append(this.getName());
		}

		// 
		// parameters : '(' parameter-list ')'
		buffer.append("(");
		buffer.append(this.getParametersAsString(style));
		buffer.append(")");

		// return type
		buffer.append(this.getReturnTypeAsString(style));

		// modifiers
		if ((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
			String modifiers = this.getModifiersAsString();
			if (!modifiers.equals("")) {
				buffer.append("{");
				buffer.append(modifiers);
				buffer.append("}");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns a short label for an operation. It returns the name of the operation, with () at the end if the operation has no parameters, and (...) if the operation has parameters
	 * 
	 * @return the short label of the operation
	 */
	public String getShortLabel() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(" ");
		buffer.append(this.getVisibilityAsString());

		buffer.append(this.getName());
		buffer.append("(");
		if (!this.getParameters().isEmpty()) {
			buffer.append("...");
		}
		buffer.append(")");
		return buffer.toString();
	}

	/**
	 * Gives the Owner of this operation.
	 * 
	 * @return A com.cea.papyrus.umlutils.StereotypedElement that can be a c om.cea.utils.Class or a com.cea.papyrus.umlutils.Interface
	 */
	public NamedElement getParent() {
		NamedElement parent = null;
		org.eclipse.uml2.uml.Element owner = uml2Operation.getOwner();
		if (owner instanceof org.eclipse.uml2.uml.Class) {
			parent = new Class((org.eclipse.uml2.uml.Class) owner);
		}
		if (owner instanceof org.eclipse.uml2.uml.Interface) {
			parent = new Interface((org.eclipse.uml2.uml.Interface) owner);
		}
		return parent;
	}

	/**
	 * Retrive the parameters of the operation. The return parameter is not retrived (@see getReturnType()).
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Parameter
	 */
	public Collection<org.eclipse.papyrus.umlutils.Parameter> getParameters() {
		Collection<org.eclipse.papyrus.umlutils.Parameter> params = new ArrayList<org.eclipse.papyrus.umlutils.Parameter>();
		Iterator<org.eclipse.uml2.uml.Parameter> parameterIterator = uml2Operation.getOwnedParameters().iterator();
		org.eclipse.papyrus.umlutils.Parameter currentParameter;
		while (parameterIterator.hasNext()) {
			currentParameter = new Parameter(parameterIterator.next());
			if (!currentParameter.isReturn()) {
				params.add(currentParameter);
			}
		}
		return params;
	}

	/**
	 * Returns operation parameters as a string, the label is customized using a bit mask
	 * 
	 * @return a string containing all parameters separated by commas
	 */
	public String getParametersAsString(int style) {
		StringBuffer paramString = new StringBuffer();
		Iterator<Parameter> paramIterator = getParameters().iterator();
		while (paramIterator.hasNext()) {
			// get the label for this parameter
			paramString.append(paramIterator.next().getCustomLabel(style));

			if (paramIterator.hasNext()) {
				paramString.append(", ");
			}
		}
		return paramString.toString();
	}

	/**
	 * Returns operation parameters as a string.
	 * 
	 * @return a string containing all parameters separated by commas
	 */
	public String getParametersAsString() {
		String paramString = "";
		Collection params = getParameters();
		Iterator paramIterator = params.iterator();
		while (paramIterator.hasNext()) {
			org.eclipse.uml2.uml.Parameter currentUml2Param = ((Parameter) paramIterator.next()).getUml2Parameter();
			if ("".equals(paramString)) {
				if (currentUml2Param.getName() == null) {
					paramString = PARAM_UNDEFINED_NAME;
				} else {
					paramString = currentUml2Param.getName();
				}
			} else {
				if (currentUml2Param.getName() == null) {
					paramString = paramString + ", " + PARAM_UNDEFINED_NAME;
				} else {
					paramString = paramString + ", " + currentUml2Param.getName();
				}
			}
		}
		return paramString;
	}

	/**
	 * Returns operation parameters label as a string.
	 * 
	 * @return a string containing all parameters separated by comas
	 */
	public String getParametersAsFullString() {
		StringBuffer buffer = new StringBuffer();

		Iterator<org.eclipse.papyrus.umlutils.Parameter> paramIterator = this.getParameters().iterator();
		while (paramIterator.hasNext()) {
			org.eclipse.papyrus.umlutils.Parameter currentParam = paramIterator.next();
			buffer.append(currentParam.getLabel());
			if (paramIterator.hasNext()) {
				buffer.append(", ");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns operation parameters label as a string.
	 * 
	 * @return a string containing all parameters separated by comas
	 */
	public String getParametersAsSignature() {
		StringBuffer buffer = new StringBuffer();

		Iterator<org.eclipse.papyrus.umlutils.Parameter> paramIterator = this.getParameters().iterator();
		while (paramIterator.hasNext()) {
			org.eclipse.papyrus.umlutils.Parameter currentParam = paramIterator.next();
			buffer.append(currentParam.getSignatureLabel());
			if (paramIterator.hasNext()) {
				buffer.append(", ");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns return parameter label as a string.
	 * 
	 * @return a string containing the return parameter type
	 */
	public String getReturnTypeAsString() {
		return getReturnTypeAsString(ICustomAppearence.DISP_RT_TYPE);
	}

	/**
	 * Returns return parameter label as a string, string parametrized with a style mask.
	 * 
	 * @param style
	 *            the mask that indicates which element to display
	 * @return a string containing the return parameter type
	 */
	public String getReturnTypeAsString(int style) {
		boolean displayType = ((style & ICustomAppearence.DISP_RT_TYPE) != 0);
		boolean displayMultiplicity = ((style & ICustomAppearence.DISP_RT_MULTIPLICITY) != 0);
		if (!displayType && !displayMultiplicity) {
			return "";
		} else {
			String label = "";
			if (getReturnParameter() != null) {
				label += ": ";
				if (displayType) {
					label += getReturnParameter().getTypeAsString();
				}
				if (displayMultiplicity) {
					label += getReturnParameter().getMultiplicityAsString();
				}
			}
			return label;
		}
	}

	/**
	 * Returns operation modifiers as string, separated with comma.
	 * 
	 * @return a string containing the modifiers
	 */
	@SuppressWarnings("unchecked")
	public String getModifiersAsString() {
		StringBuffer buffer = new StringBuffer();
		boolean needsComma = false;

		// Return parameter modifiers
		Parameter returnParameter = this.getReturnParameter();
		if (returnParameter != null) {
			// non unicity for the return parameter
			if (!returnParameter.getUml2Parameter().isUnique()) {
				buffer.append("nonunique");
				needsComma = true;
			}

			// return parameter has ordered values
			if (returnParameter.getUml2Parameter().isOrdered()) {
				if (needsComma) {
					buffer.append(", ");
				}
				buffer.append("ordered");
				needsComma = true;
			}
		}

		// is the operation a query ?
		if (uml2Operation.isQuery()) {
			if (needsComma) {
				buffer.append(", ");
			}
			buffer.append("query");
			needsComma = true;
		}

		// is the operation redefining another operation ?
		Iterator<org.eclipse.uml2.uml.Operation> it = uml2Operation.getRedefinedOperations().iterator();
		while (it.hasNext()) {
			org.eclipse.uml2.uml.Operation operation = it.next();
			if (needsComma) {
				buffer.append(", ");
			}
			buffer.append("redefines ");
			buffer.append(operation.getName());
			needsComma = true;
		}

		// has the operation a constraint ?
		Iterator<org.eclipse.uml2.uml.Constraint> it2 = uml2Operation.getOwnedRules().iterator();
		while (it2.hasNext()) {
			org.eclipse.uml2.uml.Constraint constraint = it2.next();
			if (needsComma) {
				buffer.append(", ");
			}
			if (constraint.getSpecification() != null) {
				buffer.append(constraint.getSpecification().stringValue());
			}
			needsComma = true;
		}

		return buffer.toString();
	}

	/**
	 * Returns OUT parameters.
	 * 
	 * @return a collection containing all OUT parameters
	 */
	public Collection<Parameter> getOutParameters() {
		Collection<Parameter> outParams = new ArrayList<Parameter>();
		Collection<Parameter> params = getParameters();
		Iterator paramIterator = params.iterator();
		while (paramIterator.hasNext()) {
			org.eclipse.uml2.uml.Parameter currentUml2Param = ((Parameter) paramIterator.next()).getUml2Parameter();
			if (currentUml2Param.getDirection().getValue() == ParameterDirectionKind.OUT) {
				Parameter currentParameter = new Parameter(currentUml2Param);
				outParams.add(currentParameter);
			}
		}
		return outParams;
	}

	/**
	 * Returns IN parameters.
	 * 
	 * @return a collection containing all IN parameters
	 */
	public Collection<Parameter> getInParameters() {
		Collection<Parameter> inParams = new ArrayList<Parameter>();
		Collection<Parameter> params = getParameters();
		Iterator paramIterator = params.iterator();
		while (paramIterator.hasNext()) {
			org.eclipse.uml2.uml.Parameter currentUml2Param = ((Parameter) paramIterator.next()).getUml2Parameter();
			if (currentUml2Param.getDirection().getValue() == ParameterDirectionKind.IN) {
				Parameter currentParameter = new Parameter(currentUml2Param);
				inParams.add(currentParameter);
			}
		}
		return inParams;
	}

	/**
	 * Retrive all the parameters of the operation (including the return parameter).
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Parameter
	 */
	public Collection<Parameter> getAllParameters() {
		Collection<Parameter> params = new ArrayList<Parameter>();
		Iterator parameterIterator = uml2Operation.getOwnedParameters().iterator();
		Parameter currentParameter;
		while (parameterIterator.hasNext()) {
			currentParameter = new Parameter((org.eclipse.uml2.uml.Parameter) parameterIterator.next());
			params.add(currentParameter);
		}
		return params;
	}

	/**
	 * Tells is the operation is public or not.
	 * 
	 * @return true if the operation is public
	 */
	public boolean isPublic() {
		return getVisibility() == VisibilityKind.PUBLIC;
	}

	/**
	 * Tells is the operation is private or not.
	 * 
	 * @return true if the operation is private
	 */
	public boolean isPrivate() {
		return getVisibility() == VisibilityKind.PRIVATE;
	}

	/**
	 * Tells is the operation has the protected visibility or not.
	 * 
	 * @return true if the operation has the protected visibility
	 */
	public boolean isProtected() {
		return getVisibility() == VisibilityKind.PROTECTED;
	}

	/**
	 * Tells is the operation has the package visibility or not.
	 * 
	 * @return true if the operation has the package visibility
	 */
	public boolean isPackage() {
		return getVisibility() == VisibilityKind.PACKAGE;
	}

	/**
	 * Get the body for the given language.
	 * 
	 * @param language
	 *            the body language
	 * 
	 * @return the body of the operation
	 * 
	 * @deprecated
	 * @see getBodyInOpaqueBehavior
	 */
	@Deprecated
	public String getBodyInActivity(String language) {
		String body = null;
		Activity activity = getMethodActivity(language);

		if (activity != null) {
			body = ""; // activity.getBody();
		}

		return body;
	}

	/**
	 * Get the body for the given language.
	 * 
	 * @param language
	 *            the body language
	 * 
	 * @return the body of the operation
	 */
	public String getBodyInOpaqueBehavior(String language) {
		String body = "";
		OpaqueBehavior behavior = getMethodBehavior(language);
		if (behavior != null) {
			body = behavior.getBody(language);
		} else {
			// operation behavior has not been described in this language yet.
			body = "";
		}

		return body;
	}

	/**
	 * Tells if the operation is virtual.
	 * 
	 * @return
	 */
	public boolean isVirtual() {
		return hasStereotype("virtual");
	}

	/**
	 * Give the name of the method, not prefixed by the package name by prefixed by _PROTECTED_ if the operation is protected. This method is used by the C code generator to buid the identifier of the
	 * pointer for this operation in the Virtual Methods Table.
	 * 
	 * @return
	 */
	public String getPointerName() {
		String visibilityPrefix = "";
		if (getVisibility() == VisibilityKind.PROTECTED) {
			visibilityPrefix = "_PROTECTED_";
		}
		return visibilityPrefix + getName();
	}

	/**
	 * Stores the body of an operation in the given language into a method <code>Activity</code>. If the activity doesn't exist creates the activity for the given language.
	 * 
	 * @param language
	 *            the body language
	 * @param body
	 *            the body to set
	 * 
	 * @deprecated
	 * @see setBodyInOpaqueBehavior
	 */
	@Deprecated
	public void setBodyInActivity(String body, String language) {
		Activity activity = getMethodActivity(language);
		if (activity == null) {
			if (getParent() instanceof Class) {
				activity = ((Class) getParent()).createActivity(this, this.getName(), language, false);
			}
		}
		// activity.setBody(body);
	}

	/**
	 * Stores the body of an operation in the given language into a method <code>Activity</code>. If the activity doesn't exist creates the opaquebehavior for the given language.
	 * 
	 * @param language
	 *            the body language
	 * @param body
	 *            the body to set
	 */
	public void setBodyInOpaqueBehavior(String body, String language) {
		OpaqueBehavior behavior = getMethodBehavior(language);
		if (behavior == null) {
			if (getParent() instanceof Class) {

				// Create a new OpaqueBehavior
				org.eclipse.uml2.uml.OpaqueBehavior newBehavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
				newBehavior.setName(uml2Operation.getName());

				// Set the body
				behavior = new org.eclipse.papyrus.umlutils.OpaqueBehavior(newBehavior);
				behavior.setBody(body, language);

				// Add it to the class and set the specification
				((Class) getParent()).getUml2Class().getOwnedBehaviors().add(newBehavior);
				newBehavior.setSpecification(getUml2Operation());
			}
		} else {
			behavior.setBody(body, language);
		}
	}

	/**
	 * Create a parameter,.
	 * 
	 * @param name
	 *            , name of the parameter,
	 * @param parameterDirectionKind
	 *            , kind of direction parameter (in, out ...)
	 * @param type
	 *            kind of type
	 * @param parameterDirectionKind
	 * @param name
	 * 
	 * @return the created parameter
	 */
	public org.eclipse.papyrus.umlutils.Parameter createOwnedParameter(String name, org.eclipse.uml2.uml.Type type, int parameterDirectionKind) {
		org.eclipse.uml2.uml.Parameter parameter = getUml2Operation().createOwnedParameter(name, type);
		parameter.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL);
		parameter.setDirection(ParameterDirectionKind.get(parameterDirectionKind));

		return new org.eclipse.papyrus.umlutils.Parameter(parameter);
	}

	/**
	 * Create a parameter,.
	 * 
	 * @param index
	 * @param name
	 *            , name of the parameter,
	 * @param parameterDirectionKind
	 *            , kind of direction parameter (in, out ...)
	 * @param type
	 *            kind of type
	 * @param parameterDirectionKind
	 * @param name
	 * 
	 * @return the created parameter
	 */
	public org.eclipse.papyrus.umlutils.Parameter createOwnedParameter(String name, org.eclipse.uml2.uml.Type type, int parameterDirectionKind, int index) {

		org.eclipse.uml2.uml.Parameter parameter = UMLFactory.eINSTANCE.createParameter();

		getUml2Operation().getOwnedParameters().add(index, parameter);
		parameter.setName(name);
		parameter.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL);
		parameter.setType(type);
		parameter.setDirection(ParameterDirectionKind.get(parameterDirectionKind));

		return new org.eclipse.papyrus.umlutils.Parameter(parameter);
	}

	/**
	 * Get the list of all methods for an operation.
	 * 
	 * @return the list of <code>Behavior</code> that are methods of the operation
	 */
	public List<org.eclipse.papyrus.umlutils.Behavior> getMethods() {
		ArrayList<org.eclipse.papyrus.umlutils.Behavior> list = new ArrayList<org.eclipse.papyrus.umlutils.Behavior>();
		Iterator<Behavior> it = uml2Operation.getMethods().iterator();
		while (it.hasNext()) {
			list.add(new org.eclipse.papyrus.umlutils.Behavior(it.next()));
		}
		return list;
	}

	/**
	 * Get the activity which stores the body of the operation in the given language.<BR>
	 * 
	 * @param language
	 *            the body language
	 * 
	 * @return the activity that represents the operation for this language
	 * 
	 * @deprecated
	 * @see org.eclipse.papyrus.umlutils.Activity
	 */

	@Deprecated
	public Activity getMethodActivity(String language) {
		Activity activity = null;
		EList activities = uml2Operation.getMethods();
		if (activities != null) {
			Iterator activityIterator = activities.iterator();
			Behavior currentBehavior;
			while (activityIterator.hasNext()) {
				currentBehavior = (Behavior) activityIterator.next();
				if (currentBehavior instanceof org.eclipse.uml2.uml.Activity) {
					activity = new Activity((org.eclipse.uml2.uml.Activity) currentBehavior);
				}
			}
		}
		return activity;
	}

	/**
	 * Get the OpaqueBehavior which stores the body of the operation in the given language.<BR>
	 * 
	 * @param language
	 *            the body language
	 * 
	 * @return the OpaqueBehavior that contains the body
	 * 
	 * @see org.eclipse.papyrus.umlutils.OpaqueBehavior
	 */
	private OpaqueBehavior getMethodBehavior(String language) {
		OpaqueBehavior opaqueBehavior = null;
		boolean isFound = false;

		Collection<OpaqueBehavior> opaqueBehaviors = this.getOpaqueBehaviors();

		Iterator behaviors = opaqueBehaviors.iterator();
		while (behaviors.hasNext() && !isFound) {
			OpaqueBehavior currentBehavior = (OpaqueBehavior) behaviors.next();
			if (currentBehavior.getBodyIndex(language) != -1) {
				opaqueBehavior = currentBehavior;
				isFound = true;
			} else if (opaqueBehavior == null) {
				// this is the first behavior (the defaut one)
				opaqueBehavior = currentBehavior;
			}
		}
		return opaqueBehavior;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String generateDefaultBody() {
		StringBuffer body = new StringBuffer();

		body.append("/**\n * ");
		body.append(this.getSignature());
		body.append("\n */\n");

		// return parameter
		if (this.getReturnType() != null) {
			body.append(this.getReturnType().getName());
			body.append(" ");
		}

		// operation name
		body.append(this.getName());

		// parameters
		body.append("(");
		Iterator it = this.getInParameters().iterator();
		while (it.hasNext()) {
			Parameter parameter = (Parameter) it.next();
			body.append(parameter.getType().getName());
			body.append(" ");
			body.append(parameter.getName());
			if (it.hasNext()) {
				body.append(", ");
			}
		}

		body.append(") {\n");
		body.append("\n}\n");

		return body.toString();
	}

	/**
	 * Get the collection of OpaqueBehaviors that are the methods of this operation<BR>
	 * Behaviors can be OpaqueBehaviors or Activity.
	 * 
	 * @return all OpaqueBehaviors that are method of the operation
	 */
	public Collection<OpaqueBehavior> getOpaqueBehaviors() {
		Collection<OpaqueBehavior> c = new Vector<OpaqueBehavior>();

		Iterator behaviors = uml2Operation.getMethods().iterator();
		while (behaviors.hasNext()) {
			Behavior currentBehavior = (Behavior) behaviors.next();
			if (currentBehavior instanceof org.eclipse.uml2.uml.OpaqueBehavior) {
				c.add(new OpaqueBehavior((org.eclipse.uml2.uml.OpaqueBehavior) currentBehavior));
			}
		}
		return c;
	}

	/**
	 * Indicates if RBox are needed in this operation (i.e. return value or OUT parameter)
	 * 
	 * @return a booelan indicating if RBox are needed
	 */

	public boolean withRBox() {
		boolean withRBox = false;
		Iterator paramIterator = getAllParameters().iterator();
		while (paramIterator.hasNext()) {
			org.eclipse.uml2.uml.Parameter theParam = ((org.eclipse.papyrus.umlutils.Parameter) paramIterator.next()).getUml2Parameter();
			if ((theParam.getDirection().getValue() == org.eclipse.uml2.uml.ParameterDirectionKind.OUT) || (theParam.getDirection().getValue() == org.eclipse.uml2.uml.ParameterDirectionKind.RETURN)) {
				withRBox = true;
			}
		}
		return withRBox;
	}

	/**
	 * Sets if the umlOperation is abstract or not
	 * 
	 * @param b
	 *            <code>true</code> if this operation is abstract.
	 */
	public void setIsAbstract(boolean b) {
		getUml2Operation().setIsAbstract(b);
	}

	/**
	 * Sets if the umlOperation is static or not
	 * 
	 * @param b
	 *            <code>true</code> if this operation is static.
	 */
	public void setIsStatic(boolean b) {
		getUml2Operation().setIsStatic(b);
	}

}
