/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.facade.virtualmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage
 * @generated
 */
public class VirtualmetamodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VirtualmetamodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualmetamodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = VirtualmetamodelPackage.eINSTANCE;
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
	protected VirtualmetamodelSwitch<Adapter> modelSwitch =
		new VirtualmetamodelSwitch<Adapter>() {
			@Override
			public Adapter caseVirtualMetamodel(VirtualMetamodel object) {
				return createVirtualMetamodelAdapter();
			}
			@Override
			public Adapter caseVirtualElement(VirtualElement object) {
				return createVirtualElementAdapter();
			}
			@Override
			public Adapter caseVirtualClassifier(VirtualClassifier object) {
				return createVirtualClassifierAdapter();
			}
			@Override
			public Adapter caseVirtualMetaclass(VirtualMetaclass object) {
				return createVirtualMetaclassAdapter();
			}
			@Override
			public Adapter caseVirtualProperty(VirtualProperty object) {
				return createVirtualPropertyAdapter();
			}
			@Override
			public Adapter caseVirtualOperation(VirtualOperation object) {
				return createVirtualOperationAdapter();
			}
			@Override
			public Adapter caseVirtualParameter(VirtualParameter object) {
				return createVirtualParameterAdapter();
			}
			@Override
			public Adapter caseVirtualDatatype(VirtualDatatype object) {
				return createVirtualDatatypeAdapter();
			}
			@Override
			public Adapter caseVirtualEnum(VirtualEnum object) {
				return createVirtualEnumAdapter();
			}
			@Override
			public Adapter caseVirtualLiteral(VirtualLiteral object) {
				return createVirtualLiteralAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel <em>Virtual Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel
	 * @generated
	 */
	public Adapter createVirtualMetamodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement <em>Virtual Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement
	 * @generated
	 */
	public Adapter createVirtualElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier <em>Virtual Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier
	 * @generated
	 */
	public Adapter createVirtualClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass <em>Virtual Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass
	 * @generated
	 */
	public Adapter createVirtualMetaclassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty <em>Virtual Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty
	 * @generated
	 */
	public Adapter createVirtualPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation <em>Virtual Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation
	 * @generated
	 */
	public Adapter createVirtualOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter <em>Virtual Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter
	 * @generated
	 */
	public Adapter createVirtualParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype <em>Virtual Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype
	 * @generated
	 */
	public Adapter createVirtualDatatypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum <em>Virtual Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum
	 * @generated
	 */
	public Adapter createVirtualEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral <em>Virtual Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral
	 * @generated
	 */
	public Adapter createVirtualLiteralAdapter() {
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

} //VirtualmetamodelAdapterFactory
