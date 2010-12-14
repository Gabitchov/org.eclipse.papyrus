/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.domaincontextcodegen.Advice;
import org.eclipse.papyrus.domaincontextcodegen.AdviceBinding;
import org.eclipse.papyrus.domaincontextcodegen.Binding;
import org.eclipse.papyrus.domaincontextcodegen.Command;
import org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypes;
import org.eclipse.papyrus.domaincontextcodegen.GenHandlers;
import org.eclipse.papyrus.domaincontextcodegen.GenHelper;
import org.eclipse.papyrus.domaincontextcodegen.GenMatcher;
import org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration;
import org.eclipse.papyrus.domaincontextcodegen.MetaClassType;
import org.eclipse.papyrus.domaincontextcodegen.SpecializationType;
import org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper;
import org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage
 * @generated
 */
public class DomaincontextcodegenSwitch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static DomaincontextcodegenPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomaincontextcodegenSwitch() {
		if(modelPackage == null) {
			modelPackage = DomaincontextcodegenPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if(theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT:
		{
			DomainContext domainContext = (DomainContext)theEObject;
			T result = caseDomainContext(domainContext);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.ELEMENT_TYPES:
		{
			ElementTypes elementTypes = (ElementTypes)theEObject;
			T result = caseElementTypes(elementTypes);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.ELEMENT_TYPE:
		{
			ElementType elementType = (ElementType)theEObject;
			T result = caseElementType(elementType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.META_CLASS_TYPE:
		{
			MetaClassType metaClassType = (MetaClassType)theEObject;
			T result = caseMetaClassType(metaClassType);
			if(result == null)
				result = caseElementType(metaClassType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE:
		{
			SpecializationType specializationType = (SpecializationType)theEObject;
			T result = caseSpecializationType(specializationType);
			if(result == null)
				result = caseElementType(specializationType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.ADVICE:
		{
			Advice advice = (Advice)theEObject;
			T result = caseAdvice(advice);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS:
		{
			ElementTypeBindings elementTypeBindings = (ElementTypeBindings)theEObject;
			T result = caseElementTypeBindings(elementTypeBindings);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.BINDING:
		{
			Binding binding = (Binding)theEObject;
			T result = caseBinding(binding);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDING:
		{
			ElementTypeBinding elementTypeBinding = (ElementTypeBinding)theEObject;
			T result = caseElementTypeBinding(elementTypeBinding);
			if(result == null)
				result = caseBinding(elementTypeBinding);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.ADVICE_BINDING:
		{
			AdviceBinding adviceBinding = (AdviceBinding)theEObject;
			T result = caseAdviceBinding(adviceBinding);
			if(result == null)
				result = caseBinding(adviceBinding);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.GEN_HANDLERS:
		{
			GenHandlers genHandlers = (GenHandlers)theEObject;
			T result = caseGenHandlers(genHandlers);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.GEN_MATCHER:
		{
			GenMatcher genMatcher = (GenMatcher)theEObject;
			T result = caseGenMatcher(genMatcher);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.GEN_HELPER:
		{
			GenHelper genHelper = (GenHelper)theEObject;
			T result = caseGenHelper(genHelper);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER:
		{
			StereotypedElementMatcher stereotypedElementMatcher = (StereotypedElementMatcher)theEObject;
			T result = caseStereotypedElementMatcher(stereotypedElementMatcher);
			if(result == null)
				result = caseGenMatcher(stereotypedElementMatcher);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_HELPER:
		{
			StereotypedElementHelper stereotypedElementHelper = (StereotypedElementHelper)theEObject;
			T result = caseStereotypedElementHelper(stereotypedElementHelper);
			if(result == null)
				result = caseGenHelper(stereotypedElementHelper);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.MENU_DECLARATION:
		{
			MenuDeclaration menuDeclaration = (MenuDeclaration)theEObject;
			T result = caseMenuDeclaration(menuDeclaration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.COMMAND_DECLARATION:
		{
			CommandDeclaration commandDeclaration = (CommandDeclaration)theEObject;
			T result = caseCommandDeclaration(commandDeclaration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DomaincontextcodegenPackage.COMMAND:
		{
			Command command = (Command)theEObject;
			T result = caseCommand(command);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainContext(DomainContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Types</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Types</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypes(ElementTypes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementType(ElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaClassType(MetaClassType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specialization Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specialization Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializationType(SpecializationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdvice(Advice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type Bindings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type Bindings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypeBindings(ElementTypeBindings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advice Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advice Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdviceBinding(AdviceBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinding(Binding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypeBinding(ElementTypeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Handlers</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Handlers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenHandlers(GenHandlers object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenMatcher(GenMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenHelper(GenHelper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotyped Element Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotyped Element Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypedElementMatcher(StereotypedElementMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotyped Element Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotyped Element Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypedElementHelper(StereotypedElementHelper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuDeclaration(MenuDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandDeclaration(CommandDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //DomaincontextcodegenSwitch
