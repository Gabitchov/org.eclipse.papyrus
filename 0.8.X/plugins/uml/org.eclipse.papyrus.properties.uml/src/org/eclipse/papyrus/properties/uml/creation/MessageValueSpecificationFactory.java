package org.eclipse.papyrus.properties.uml.creation;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


public class MessageValueSpecificationFactory extends EcorePropertyEditorFactory {

	/**
	 * The message in which the arguments will be created
	 */
	protected Message parent;

	/**
	 * Indicates the liberty we let to the user.
	 * If set to true, he won't be able to instantiate invalid elements,
	 * ie. he cannot instantiate arguments which don't correspond to an
	 * operation's parameter.
	 */
	protected boolean restrictedInstantiation = false;

	protected Set<ParameterDirectionKind> directions;

	public MessageValueSpecificationFactory(EClass type, Message parent, Set<ParameterDirectionKind> directions) {
		super(type);
		this.parent = parent;
		this.directions = directions;
	}

	@Override
	protected List<EClass> getAvailableEClasses() {
		List<EClass> allClasses = EMFHelper.getSubclassesOf(type, true);
		List<EClass> result = new LinkedList<EClass>();
		for(EClass eClass : allClasses) {
			if(isValid(eClass)) {
				result.add(eClass);
			}
		}

		return result;
	}

	@Override
	public Object createObject(Control widget) {
		EClass eClass = chooseEClass(widget);
		if(eClass == null) {
			return null;
		}

		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		if(instance != null && instance instanceof NamedElement) {
			Parameter parameter = getParameter();
			if(parameter != null) {
				((NamedElement)instance).setName(parameter.getName());
			}

			if(instance instanceof InstanceValue) {
				((InstanceValue)instance).setType(parameter.getType());
			}
		}

		return super.createObject(widget, instance);
	}

	protected boolean isValid(EClass eClass) {
		Parameter parameter = getParameter();
		if(parameter == null) {
			return !restrictedInstantiation;
		}

		Type parameterType = parameter.getType();
		if(parameterType instanceof PrimitiveType) {
			return isValidType(eClass, (PrimitiveType)parameterType);
		}

		if(parameterType instanceof Classifier) {
			return eClass == UMLPackage.eINSTANCE.getInstanceValue();
		}

		return !restrictedInstantiation; //The operation has no signature
	}

	protected Operation getOperation() {
		NamedElement namedElement = parent.getSignature();

		if(namedElement instanceof Operation) {
			return (Operation)namedElement;
		}

		return null;
	}

	protected Parameter getParameter() {
		Operation operation = getOperation();
		if(operation == null) {
			return null;
		}

		int index = parent.getArguments().size();

		int i = 0;
		for(Parameter parameter : operation.getOwnedParameters()) {
			ParameterDirectionKind direction = parameter.getDirection();
			if(directions.contains(direction)) {
				if(i++ == index) {
					return parameter;
				}
			}
		}

		return null;
	}

	protected boolean isValidType(EClass eClass, PrimitiveType parameterType) {
		String typeName = parameterType.getName();

		if(eClass == UMLPackage.eINSTANCE.getLiteralInteger() || eClass == UMLPackage.eINSTANCE.getLiteralUnlimitedNatural()) {
			return typeName.equals("Integer") || typeName.equals("int");
		}

		if(eClass == UMLPackage.eINSTANCE.getLiteralString()) {
			return !(typeName.equals("Integer") || typeName.equals("int") || typeName.equals("Boolean") || typeName.equals("boolean"));
		}

		if(eClass == UMLPackage.eINSTANCE.getInstanceValue()) {
			return !(typeName.equals("Integer") || typeName.equals("int") || typeName.equals("Boolean") || typeName.equals("boolean") || typeName.equals("String"));
		}

		if(eClass == UMLPackage.eINSTANCE.getLiteralBoolean()) {
			return typeName.equals("Boolean") || typeName.equals("boolean");
		}

		return false;
	}
}
