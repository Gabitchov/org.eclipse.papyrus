/**
 */
package Cpp.util;

import Cpp.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import Cpp.CppArray;
import Cpp.CppConst;
import Cpp.CppConstInit;
import Cpp.CppDefault;
import Cpp.CppExternClass;
import Cpp.CppExternLibrary;
import Cpp.CppFriend;
import Cpp.CppInclude;
import Cpp.CppInit;
import Cpp.CppInline;
import Cpp.CppNoCodeGen;
import Cpp.CppPackage;
import Cpp.CppPtr;
import Cpp.CppRef;
import Cpp.CppRoot;
import Cpp.CppTemplate;
import Cpp.CppTemplateBinding;
import Cpp.CppTemplateParameter;
import Cpp.CppType;
import Cpp.CppVirtual;
import Cpp.CppVisibility;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Cpp.CppPackage
 * @generated
 */
public class CppAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CppPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CppPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppSwitch<Adapter> modelSwitch =
		new CppSwitch<Adapter>() {
			@Override
			public Adapter caseCppPtr(CppPtr object) {
				return createCppPtrAdapter();
			}
			@Override
			public Adapter caseCppInclude(CppInclude object) {
				return createCppIncludeAdapter();
			}
			@Override
			public Adapter caseManualGeneration(ManualGeneration object) {
				return createManualGenerationAdapter();
			}
			@Override
			public Adapter caseCppArray(CppArray object) {
				return createCppArrayAdapter();
			}
			@Override
			public Adapter caseCppConst(CppConst object) {
				return createCppConstAdapter();
			}
			@Override
			public Adapter caseCppDefault(CppDefault object) {
				return createCppDefaultAdapter();
			}
			@Override
			public Adapter caseCppRef(CppRef object) {
				return createCppRefAdapter();
			}
			@Override
			public Adapter caseCppExternClass(CppExternClass object) {
				return createCppExternClassAdapter();
			}
			@Override
			public Adapter caseCppExternLibrary(CppExternLibrary object) {
				return createCppExternLibraryAdapter();
			}
			@Override
			public Adapter caseCppRoot(CppRoot object) {
				return createCppRootAdapter();
			}
			@Override
			public Adapter caseCppNoCodeGen(CppNoCodeGen object) {
				return createCppNoCodeGenAdapter();
			}
			@Override
			public Adapter caseCppConstInit(CppConstInit object) {
				return createCppConstInitAdapter();
			}
			@Override
			public Adapter caseCppFriend(CppFriend object) {
				return createCppFriendAdapter();
			}
			@Override
			public Adapter caseCppInline(CppInline object) {
				return createCppInlineAdapter();
			}
			@Override
			public Adapter caseCppVirtual(CppVirtual object) {
				return createCppVirtualAdapter();
			}
			@Override
			public Adapter caseCppType(CppType object) {
				return createCppTypeAdapter();
			}
			@Override
			public Adapter caseCppVisibility(CppVisibility object) {
				return createCppVisibilityAdapter();
			}
			@Override
			public Adapter caseCppInit(CppInit object) {
				return createCppInitAdapter();
			}
			@Override
			public Adapter caseCppTemplate(CppTemplate object) {
				return createCppTemplateAdapter();
			}
			@Override
			public Adapter caseCppTemplateBinding(CppTemplateBinding object) {
				return createCppTemplateBindingAdapter();
			}
			@Override
			public Adapter caseCppTemplateParameter(CppTemplateParameter object) {
				return createCppTemplateParameterAdapter();
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
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppArray
	 * @generated
	 */
	public Adapter createCppArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppConst
	 * @generated
	 */
	public Adapter createCppConstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppDefault
	 * @generated
	 */
	public Adapter createCppDefaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppPtr <em>Ptr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppPtr
	 * @generated
	 */
	public Adapter createCppPtrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppRef
	 * @generated
	 */
	public Adapter createCppRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppExternClass <em>Extern Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppExternClass
	 * @generated
	 */
	public Adapter createCppExternClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppExternLibrary <em>Extern Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppExternLibrary
	 * @generated
	 */
	public Adapter createCppExternLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppInclude
	 * @generated
	 */
	public Adapter createCppIncludeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.ManualGeneration <em>Manual Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.ManualGeneration
	 * @generated
	 */
	public Adapter createManualGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppRoot
	 * @generated
	 */
	public Adapter createCppRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppNoCodeGen <em>No Code Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppNoCodeGen
	 * @generated
	 */
	public Adapter createCppNoCodeGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppConstInit <em>Const Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppConstInit
	 * @generated
	 */
	public Adapter createCppConstInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppFriend <em>Friend</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppFriend
	 * @generated
	 */
	public Adapter createCppFriendAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppInline <em>Inline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppInline
	 * @generated
	 */
	public Adapter createCppInlineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppVirtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppVirtual
	 * @generated
	 */
	public Adapter createCppVirtualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppType
	 * @generated
	 */
	public Adapter createCppTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppVisibility
	 * @generated
	 */
	public Adapter createCppVisibilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppInit
	 * @generated
	 */
	public Adapter createCppInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppTemplate
	 * @generated
	 */
	public Adapter createCppTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppTemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppTemplateBinding
	 * @generated
	 */
	public Adapter createCppTemplateBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Cpp.CppTemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Cpp.CppTemplateParameter
	 * @generated
	 */
	public Adapter createCppTemplateParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CppAdapterFactory
