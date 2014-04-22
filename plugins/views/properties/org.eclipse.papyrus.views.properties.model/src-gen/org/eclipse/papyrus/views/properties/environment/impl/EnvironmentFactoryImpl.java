/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.views.properties.environment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.views.properties.environment.*;
import org.eclipse.papyrus.views.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.views.properties.environment.Environment;
import org.eclipse.papyrus.views.properties.environment.EnvironmentFactory;
import org.eclipse.papyrus.views.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.views.properties.environment.LayoutType;
import org.eclipse.papyrus.views.properties.environment.MiscClass;
import org.eclipse.papyrus.views.properties.environment.ModelElementFactoryDescriptor;
import org.eclipse.papyrus.views.properties.environment.Namespace;
import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.views.properties.environment.StandardWidgetType;
import org.eclipse.papyrus.views.properties.environment.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentFactoryImpl extends EFactoryImpl implements EnvironmentFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnvironmentFactory init() {
		try {
			EnvironmentFactory theEnvironmentFactory = (EnvironmentFactory)EPackage.Registry.INSTANCE.getEFactory(EnvironmentPackage.eNS_URI);
			if (theEnvironmentFactory != null) {
				return theEnvironmentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EnvironmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EnvironmentPackage.ENVIRONMENT: return createEnvironment();
			case EnvironmentPackage.PROPERTY_EDITOR_TYPE: return createPropertyEditorType();
			case EnvironmentPackage.COMPOSITE_WIDGET_TYPE: return createCompositeWidgetType();
			case EnvironmentPackage.LAYOUT_TYPE: return createLayoutType();
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR: return createModelElementFactoryDescriptor();
			case EnvironmentPackage.STANDARD_WIDGET_TYPE: return createStandardWidgetType();
			case EnvironmentPackage.NAMESPACE: return createNamespace();
			case EnvironmentPackage.MISC_CLASS: return createMiscClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EnvironmentPackage.TYPE:
				return createTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EnvironmentPackage.TYPE:
				return convertTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment createEnvironment() {
		EnvironmentImpl environment = new EnvironmentImpl();
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyEditorType createPropertyEditorType() {
		PropertyEditorTypeImpl propertyEditorType = new PropertyEditorTypeImpl();
		return propertyEditorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeWidgetType createCompositeWidgetType() {
		CompositeWidgetTypeImpl compositeWidgetType = new CompositeWidgetTypeImpl();
		return compositeWidgetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutType createLayoutType() {
		LayoutTypeImpl layoutType = new LayoutTypeImpl();
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementFactoryDescriptor createModelElementFactoryDescriptor() {
		ModelElementFactoryDescriptorImpl modelElementFactoryDescriptor = new ModelElementFactoryDescriptorImpl();
		return modelElementFactoryDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardWidgetType createStandardWidgetType() {
		StandardWidgetTypeImpl standardWidgetType = new StandardWidgetTypeImpl();
		return standardWidgetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace createNamespace() {
		NamespaceImpl namespace = new NamespaceImpl();
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiscClass createMiscClass() {
		MiscClassImpl miscClass = new MiscClassImpl();
		return miscClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createTypeFromString(EDataType eDataType, String initialValue) {
		Type result = Type.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentPackage getEnvironmentPackage() {
		return (EnvironmentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EnvironmentPackage getPackage() {
		return EnvironmentPackage.eINSTANCE;
	}

} //EnvironmentFactoryImpl
