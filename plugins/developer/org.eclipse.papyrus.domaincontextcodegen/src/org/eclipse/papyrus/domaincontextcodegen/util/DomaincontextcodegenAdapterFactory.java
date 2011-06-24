/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage
 * @generated
 */
public class DomaincontextcodegenAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static DomaincontextcodegenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomaincontextcodegenAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = DomaincontextcodegenPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if(object == modelPackage) {
			return true;
		}
		if(object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DomaincontextcodegenSwitch<Adapter> modelSwitch = new DomaincontextcodegenSwitch<Adapter>() {

		@Override
		public Adapter caseDomainContext(DomainContext object) {
			return createDomainContextAdapter();
		}

		@Override
		public Adapter caseElementTypes(ElementTypes object) {
			return createElementTypesAdapter();
		}

		@Override
		public Adapter caseElementType(ElementType object) {
			return createElementTypeAdapter();
		}

		@Override
		public Adapter caseMetaClassType(MetaClassType object) {
			return createMetaClassTypeAdapter();
		}

		@Override
		public Adapter caseSpecializationType(SpecializationType object) {
			return createSpecializationTypeAdapter();
		}

		@Override
		public Adapter caseAdvice(Advice object) {
			return createAdviceAdapter();
		}

		@Override
		public Adapter caseElementTypeBindings(ElementTypeBindings object) {
			return createElementTypeBindingsAdapter();
		}

		@Override
		public Adapter caseBinding(Binding object) {
			return createBindingAdapter();
		}

		@Override
		public Adapter caseElementTypeBinding(ElementTypeBinding object) {
			return createElementTypeBindingAdapter();
		}

		@Override
		public Adapter caseAdviceBinding(AdviceBinding object) {
			return createAdviceBindingAdapter();
		}

		@Override
		public Adapter caseGenHandlers(GenHandlers object) {
			return createGenHandlersAdapter();
		}

		@Override
		public Adapter caseGenMatcher(GenMatcher object) {
			return createGenMatcherAdapter();
		}

		@Override
		public Adapter caseGenHelper(GenHelper object) {
			return createGenHelperAdapter();
		}

		@Override
		public Adapter caseStereotypedElementMatcher(StereotypedElementMatcher object) {
			return createStereotypedElementMatcherAdapter();
		}

		@Override
		public Adapter caseStereotypedElementHelper(StereotypedElementHelper object) {
			return createStereotypedElementHelperAdapter();
		}

		@Override
		public Adapter caseMenuDeclaration(MenuDeclaration object) {
			return createMenuDeclarationAdapter();
		}

		@Override
		public Adapter caseCommandDeclaration(CommandDeclaration object) {
			return createCommandDeclarationAdapter();
		}

		@Override
		public Adapter caseCommand(Command object) {
			return createCommandAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *        the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext <em>Domain Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext
	 * @generated
	 */
	public Adapter createDomainContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes <em>Element Types</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypes
	 * @generated
	 */
	public Adapter createElementTypesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType
	 * @generated
	 */
	public Adapter createElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.MetaClassType <em>Meta Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.MetaClassType
	 * @generated
	 */
	public Adapter createMetaClassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType <em>Specialization Type</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.SpecializationType
	 * @generated
	 */
	public Adapter createSpecializationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Advice
	 * @generated
	 */
	public Adapter createAdviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings
	 * <em>Element Type Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings
	 * @generated
	 */
	public Adapter createElementTypeBindingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding <em>Advice Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding
	 * @generated
	 */
	public Adapter createAdviceBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding
	 * @generated
	 */
	public Adapter createBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding <em>Element Type Binding</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding
	 * @generated
	 */
	public Adapter createElementTypeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers <em>Gen Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers
	 * @generated
	 */
	public Adapter createGenHandlersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.GenMatcher <em>Gen Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenMatcher
	 * @generated
	 */
	public Adapter createGenMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.GenHelper <em>Gen Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHelper
	 * @generated
	 */
	public Adapter createGenHelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher
	 * <em>Stereotyped Element Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher
	 * @generated
	 */
	public Adapter createStereotypedElementMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper
	 * <em>Stereotyped Element Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper
	 * @generated
	 */
	public Adapter createStereotypedElementHelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration <em>Menu Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration
	 * @generated
	 */
	public Adapter createMenuDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration <em>Command Declaration</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration
	 * @generated
	 */
	public Adapter createCommandDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.domaincontextcodegen.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Command
	 * @generated
	 */
	public Adapter createCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DomaincontextcodegenAdapterFactory
