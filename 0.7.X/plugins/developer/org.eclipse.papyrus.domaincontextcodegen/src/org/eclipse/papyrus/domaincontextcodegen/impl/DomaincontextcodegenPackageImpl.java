/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.domaincontextcodegen.Advice;
import org.eclipse.papyrus.domaincontextcodegen.AdviceBinding;
import org.eclipse.papyrus.domaincontextcodegen.Binding;
import org.eclipse.papyrus.domaincontextcodegen.Command;
import org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenFactory;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypes;
import org.eclipse.papyrus.domaincontextcodegen.GenHandlers;
import org.eclipse.papyrus.domaincontextcodegen.GenHelper;
import org.eclipse.papyrus.domaincontextcodegen.GenMatcher;
import org.eclipse.papyrus.domaincontextcodegen.InheritanceKind;
import org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration;
import org.eclipse.papyrus.domaincontextcodegen.MetaClassType;
import org.eclipse.papyrus.domaincontextcodegen.SpecializationType;
import org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper;
import org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DomaincontextcodegenPackageImpl extends EPackageImpl implements DomaincontextcodegenPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass domainContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass metaClassTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass specializationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass adviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypeBindingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass adviceBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass bindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementTypeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass genHandlersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass genMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass genHelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stereotypedElementMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stereotypedElementHelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass menuDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass commandDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum inheritanceKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DomaincontextcodegenPackageImpl() {
		super(eNS_URI, DomaincontextcodegenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link DomaincontextcodegenPackage#eINSTANCE} when that field is accessed. Clients should not invoke it
	 * directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DomaincontextcodegenPackage init() {
		if(isInited)
			return (DomaincontextcodegenPackage)EPackage.Registry.INSTANCE.getEPackage(DomaincontextcodegenPackage.eNS_URI);

		// Obtain or create and register package
		DomaincontextcodegenPackageImpl theDomaincontextcodegenPackage = (DomaincontextcodegenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DomaincontextcodegenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DomaincontextcodegenPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDomaincontextcodegenPackage.createPackageContents();

		// Initialize created meta-data
		theDomaincontextcodegenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomaincontextcodegenPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DomaincontextcodegenPackage.eNS_URI, theDomaincontextcodegenPackage);
		return theDomaincontextcodegenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDomainContext() {
		return domainContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_TypeProjectName() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_HandlerProjectName() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_IClientContextID() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Metamodel() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_SpecializationOf() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_ElementTypeIDPrefix() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_ElementTypeNamePrefix() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_ElementTypes() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_DefaultHelperPath() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Advices() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Bindings() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_GenHandlers() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDomainContext_GeneratedSourceFolder() {
		return (EAttribute)domainContextEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Menu() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDomainContext_Command() {
		return (EReference)domainContextEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementTypes() {
		return elementTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementTypes_Types() {
		return (EReference)elementTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementTypes_Domain() {
		return (EReference)elementTypesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementType() {
		return elementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementType_Name() {
		return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementType_Helper() {
		return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementType_Owner() {
		return (EReference)elementTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementType_Icon() {
		return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMetaClassType() {
		return metaClassTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMetaClassType_MetaClass() {
		return (EReference)metaClassTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSpecializationType() {
		return specializationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSpecializationType_Ref() {
		return (EReference)specializationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSpecializationType_Matcher() {
		return (EAttribute)specializationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSpecializationType_GenMatcher() {
		return (EReference)specializationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSpecializationType_GenHelper() {
		return (EReference)specializationTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAdvice() {
		return adviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdvice_AdviceID() {
		return (EAttribute)adviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAdvice_Ref() {
		return (EReference)adviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdvice_AdvicePath() {
		return (EAttribute)adviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdvice_Inheritance() {
		return (EAttribute)adviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementTypeBindings() {
		return elementTypeBindingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElementTypeBindings_ClientContextID() {
		return (EAttribute)elementTypeBindingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementTypeBindings_Bindings() {
		return (EReference)elementTypeBindingsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAdviceBinding() {
		return adviceBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAdviceBinding_Ref() {
		return (EReference)adviceBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getBinding_Owner() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBinding_Pattern() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementTypeBinding() {
		return elementTypeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementTypeBinding_Ref() {
		return (EReference)elementTypeBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGenHandlers() {
		return genHandlersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_HandlerPackage() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_SuperClass() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_SuperClassPackage() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_ElementTypeEnumerator() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_ElementTypeEnumeratorPackage() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGenHandlers_VisibleCreateChildHandlers() {
		return (EReference)genHandlersEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGenHandlers_ParentDomainCreateChild() {
		return (EReference)genHandlersEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHandlers_CreateChildMenuLocationURI() {
		return (EAttribute)genHandlersEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGenMatcher() {
		return genMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenMatcher_Name() {
		return (EAttribute)genMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGenHelper() {
		return genHelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGenHelper_Name() {
		return (EAttribute)genHelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStereotypedElementMatcher() {
		return stereotypedElementMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementMatcher_StereotypeName() {
		return (EAttribute)stereotypedElementMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementMatcher_StereotypePackage() {
		return (EAttribute)stereotypedElementMatcherEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementMatcher_BaseElementName() {
		return (EAttribute)stereotypedElementMatcherEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementMatcher_BaseElementPackage() {
		return (EAttribute)stereotypedElementMatcherEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStereotypedElementHelper() {
		return stereotypedElementHelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementHelper_StereotypeName() {
		return (EAttribute)stereotypedElementHelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementHelper_StereotypePackage() {
		return (EAttribute)stereotypedElementHelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementHelper_BaseElementName() {
		return (EAttribute)stereotypedElementHelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedElementHelper_BaseElementPackage() {
		return (EAttribute)stereotypedElementHelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMenuDeclaration() {
		return menuDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMenuDeclaration_LocationURI() {
		return (EAttribute)menuDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMenuDeclaration_Commands() {
		return (EReference)menuDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommandDeclaration() {
		return commandDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCommandDeclaration_Commands() {
		return (EReference)commandDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCommand_ElementType() {
		return (EReference)commandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCommand_Icon() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getInheritanceKind() {
		return inheritanceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomaincontextcodegenFactory getDomaincontextcodegenFactory() {
		return (DomaincontextcodegenFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		domainContextEClass = createEClass(DOMAIN_CONTEXT);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__TYPE_PROJECT_NAME);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__HANDLER_PROJECT_NAME);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__METAMODEL);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__SPECIALIZATION_OF);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__ELEMENT_TYPES);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__DEFAULT_HELPER_PATH);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__ADVICES);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__BINDINGS);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__GEN_HANDLERS);
		createEAttribute(domainContextEClass, DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__MENU);
		createEReference(domainContextEClass, DOMAIN_CONTEXT__COMMAND);

		elementTypesEClass = createEClass(ELEMENT_TYPES);
		createEReference(elementTypesEClass, ELEMENT_TYPES__TYPES);
		createEReference(elementTypesEClass, ELEMENT_TYPES__DOMAIN);

		elementTypeEClass = createEClass(ELEMENT_TYPE);
		createEAttribute(elementTypeEClass, ELEMENT_TYPE__NAME);
		createEAttribute(elementTypeEClass, ELEMENT_TYPE__HELPER);
		createEReference(elementTypeEClass, ELEMENT_TYPE__OWNER);
		createEAttribute(elementTypeEClass, ELEMENT_TYPE__ICON);

		metaClassTypeEClass = createEClass(META_CLASS_TYPE);
		createEReference(metaClassTypeEClass, META_CLASS_TYPE__META_CLASS);

		specializationTypeEClass = createEClass(SPECIALIZATION_TYPE);
		createEReference(specializationTypeEClass, SPECIALIZATION_TYPE__REF);
		createEAttribute(specializationTypeEClass, SPECIALIZATION_TYPE__MATCHER);
		createEReference(specializationTypeEClass, SPECIALIZATION_TYPE__GEN_MATCHER);
		createEReference(specializationTypeEClass, SPECIALIZATION_TYPE__GEN_HELPER);

		adviceEClass = createEClass(ADVICE);
		createEAttribute(adviceEClass, ADVICE__ADVICE_ID);
		createEReference(adviceEClass, ADVICE__REF);
		createEAttribute(adviceEClass, ADVICE__ADVICE_PATH);
		createEAttribute(adviceEClass, ADVICE__INHERITANCE);

		elementTypeBindingsEClass = createEClass(ELEMENT_TYPE_BINDINGS);
		createEAttribute(elementTypeBindingsEClass, ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID);
		createEReference(elementTypeBindingsEClass, ELEMENT_TYPE_BINDINGS__BINDINGS);

		bindingEClass = createEClass(BINDING);
		createEReference(bindingEClass, BINDING__OWNER);
		createEAttribute(bindingEClass, BINDING__PATTERN);

		elementTypeBindingEClass = createEClass(ELEMENT_TYPE_BINDING);
		createEReference(elementTypeBindingEClass, ELEMENT_TYPE_BINDING__REF);

		adviceBindingEClass = createEClass(ADVICE_BINDING);
		createEReference(adviceBindingEClass, ADVICE_BINDING__REF);

		genHandlersEClass = createEClass(GEN_HANDLERS);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__HANDLER_PACKAGE);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__SUPER_CLASS);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__SUPER_CLASS_PACKAGE);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE);
		createEReference(genHandlersEClass, GEN_HANDLERS__VISIBLE_CREATE_CHILD_HANDLERS);
		createEReference(genHandlersEClass, GEN_HANDLERS__PARENT_DOMAIN_CREATE_CHILD);
		createEAttribute(genHandlersEClass, GEN_HANDLERS__CREATE_CHILD_MENU_LOCATION_URI);

		genMatcherEClass = createEClass(GEN_MATCHER);
		createEAttribute(genMatcherEClass, GEN_MATCHER__NAME);

		genHelperEClass = createEClass(GEN_HELPER);
		createEAttribute(genHelperEClass, GEN_HELPER__NAME);

		stereotypedElementMatcherEClass = createEClass(STEREOTYPED_ELEMENT_MATCHER);
		createEAttribute(stereotypedElementMatcherEClass, STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME);
		createEAttribute(stereotypedElementMatcherEClass, STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE);
		createEAttribute(stereotypedElementMatcherEClass, STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME);
		createEAttribute(stereotypedElementMatcherEClass, STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE);

		stereotypedElementHelperEClass = createEClass(STEREOTYPED_ELEMENT_HELPER);
		createEAttribute(stereotypedElementHelperEClass, STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_NAME);
		createEAttribute(stereotypedElementHelperEClass, STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_PACKAGE);
		createEAttribute(stereotypedElementHelperEClass, STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_NAME);
		createEAttribute(stereotypedElementHelperEClass, STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_PACKAGE);

		menuDeclarationEClass = createEClass(MENU_DECLARATION);
		createEAttribute(menuDeclarationEClass, MENU_DECLARATION__LOCATION_URI);
		createEReference(menuDeclarationEClass, MENU_DECLARATION__COMMANDS);

		commandDeclarationEClass = createEClass(COMMAND_DECLARATION);
		createEReference(commandDeclarationEClass, COMMAND_DECLARATION__COMMANDS);

		commandEClass = createEClass(COMMAND);
		createEReference(commandEClass, COMMAND__ELEMENT_TYPE);
		createEAttribute(commandEClass, COMMAND__ICON);

		// Create enums
		inheritanceKindEEnum = createEEnum(INHERITANCE_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		metaClassTypeEClass.getESuperTypes().add(this.getElementType());
		specializationTypeEClass.getESuperTypes().add(this.getElementType());
		elementTypeBindingEClass.getESuperTypes().add(this.getBinding());
		adviceBindingEClass.getESuperTypes().add(this.getBinding());
		stereotypedElementMatcherEClass.getESuperTypes().add(this.getGenMatcher());
		stereotypedElementHelperEClass.getESuperTypes().add(this.getGenHelper());

		// Initialize classes and features; add operations and parameters
		initEClass(domainContextEClass, DomainContext.class, "DomainContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainContext_TypeProjectName(), ecorePackage.getEString(), "typeProjectName", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_HandlerProjectName(), ecorePackage.getEString(), "handlerProjectName", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_IClientContextID(), ecorePackage.getEString(), "IClientContextID", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Metamodel(), ecorePackage.getEPackage(), null, "metamodel", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_SpecializationOf(), this.getDomainContext(), null, "specializationOf", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_ElementTypeIDPrefix(), ecorePackage.getEString(), "elementTypeIDPrefix", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_ElementTypeNamePrefix(), ecorePackage.getEString(), "elementTypeNamePrefix", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_ElementTypes(), this.getElementTypes(), this.getElementTypes_Domain(), "elementTypes", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_DefaultHelperPath(), ecorePackage.getEString(), "defaultHelperPath", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Advices(), this.getAdvice(), null, "advices", null, 0, -1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Bindings(), this.getElementTypeBindings(), null, "bindings", null, 0, -1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_GenHandlers(), this.getGenHandlers(), null, "genHandlers", null, 0, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainContext_GeneratedSourceFolder(), ecorePackage.getEString(), "generatedSourceFolder", null, 1, 1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Menu(), this.getMenuDeclaration(), null, "menu", null, 0, -1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainContext_Command(), this.getCommandDeclaration(), null, "command", null, 0, -1, DomainContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypesEClass, ElementTypes.class, "ElementTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTypes_Types(), this.getElementType(), this.getElementType_Owner(), "types", null, 0, -1, ElementTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTypes_Domain(), this.getDomainContext(), this.getDomainContext_ElementTypes(), "domain", null, 0, 1, ElementTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypeEClass, ElementType.class, "ElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementType_Name(), ecorePackage.getEString(), "name", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementType_Helper(), ecorePackage.getEString(), "helper", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementType_Owner(), this.getElementTypes(), this.getElementTypes_Types(), "owner", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementType_Icon(), theEcorePackage.getEString(), "icon", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaClassTypeEClass, MetaClassType.class, "MetaClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaClassType_MetaClass(), ecorePackage.getEClass(), null, "metaClass", null, 1, 1, MetaClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializationTypeEClass, SpecializationType.class, "SpecializationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializationType_Ref(), this.getElementType(), null, "ref", null, 0, 1, SpecializationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecializationType_Matcher(), ecorePackage.getEString(), "matcher", null, 0, 1, SpecializationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationType_GenMatcher(), this.getGenMatcher(), null, "genMatcher", null, 0, 1, SpecializationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationType_GenHelper(), this.getGenHelper(), null, "genHelper", null, 0, 1, SpecializationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adviceEClass, Advice.class, "Advice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdvice_AdviceID(), ecorePackage.getEString(), "adviceID", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvice_Ref(), this.getElementType(), null, "ref", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdvice_AdvicePath(), ecorePackage.getEString(), "advicePath", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdvice_Inheritance(), this.getInheritanceKind(), "inheritance", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypeBindingsEClass, ElementTypeBindings.class, "ElementTypeBindings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementTypeBindings_ClientContextID(), ecorePackage.getEString(), "clientContextID", null, 0, 1, ElementTypeBindings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTypeBindings_Bindings(), this.getBinding(), this.getBinding_Owner(), "bindings", null, 0, -1, ElementTypeBindings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingEClass, Binding.class, "Binding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinding_Owner(), this.getElementTypeBindings(), this.getElementTypeBindings_Bindings(), "owner", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinding_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypeBindingEClass, ElementTypeBinding.class, "ElementTypeBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTypeBinding_Ref(), this.getElementType(), null, "ref", null, 0, 1, ElementTypeBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adviceBindingEClass, AdviceBinding.class, "AdviceBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdviceBinding_Ref(), this.getAdvice(), null, "ref", null, 0, 1, AdviceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genHandlersEClass, GenHandlers.class, "GenHandlers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenHandlers_HandlerPackage(), ecorePackage.getEString(), "handlerPackage", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_SuperClass(), ecorePackage.getEString(), "superClass", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_SuperClassPackage(), ecorePackage.getEString(), "superClassPackage", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_ElementTypeEnumerator(), ecorePackage.getEString(), "elementTypeEnumerator", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_ElementTypeEnumeratorPackage(), ecorePackage.getEString(), "elementTypeEnumeratorPackage", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenHandlers_VisibleCreateChildHandlers(), this.getElementType(), null, "visibleCreateChildHandlers", null, 0, -1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenHandlers_ParentDomainCreateChild(), this.getElementType(), null, "parentDomainCreateChild", null, 0, -1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenHandlers_CreateChildMenuLocationURI(), theEcorePackage.getEString(), "createChildMenuLocationURI", null, 0, 1, GenHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genMatcherEClass, GenMatcher.class, "GenMatcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenMatcher_Name(), ecorePackage.getEString(), "name", null, 0, 1, GenMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genHelperEClass, GenHelper.class, "GenHelper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenHelper_Name(), ecorePackage.getEString(), "name", null, 0, 1, GenHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypedElementMatcherEClass, StereotypedElementMatcher.class, "StereotypedElementMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypedElementMatcher_StereotypeName(), theEcorePackage.getEString(), "stereotypeName", null, 0, 1, StereotypedElementMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypedElementMatcher_StereotypePackage(), theEcorePackage.getEString(), "stereotypePackage", null, 0, 1, StereotypedElementMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypedElementMatcher_BaseElementName(), theEcorePackage.getEString(), "baseElementName", null, 0, 1, StereotypedElementMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypedElementMatcher_BaseElementPackage(), theEcorePackage.getEString(), "baseElementPackage", null, 0, 1, StereotypedElementMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypedElementHelperEClass, StereotypedElementHelper.class, "StereotypedElementHelper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypedElementHelper_StereotypeName(), theEcorePackage.getEString(), "stereotypeName", null, 0, 1, StereotypedElementHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypedElementHelper_StereotypePackage(), theEcorePackage.getEString(), "stereotypePackage", null, 0, 1, StereotypedElementHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypedElementHelper_BaseElementName(), theEcorePackage.getEString(), "baseElementName", null, 0, 1, StereotypedElementHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStereotypedElementHelper_BaseElementPackage(), theEcorePackage.getEString(), "baseElementPackage", null, 0, 1, StereotypedElementHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(menuDeclarationEClass, MenuDeclaration.class, "MenuDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMenuDeclaration_LocationURI(), theEcorePackage.getEString(), "locationURI", null, 0, 1, MenuDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMenuDeclaration_Commands(), this.getCommand(), null, "commands", null, 0, -1, MenuDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandDeclarationEClass, CommandDeclaration.class, "CommandDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommandDeclaration_Commands(), this.getCommand(), null, "commands", null, 0, -1, CommandDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommand_ElementType(), this.getElementType(), null, "elementType", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommand_Icon(), theEcorePackage.getEString(), "icon", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(inheritanceKindEEnum, InheritanceKind.class, "InheritanceKind");
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.NONE);
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.ALL);

		// Create resource
		createResource(eNS_URI);
	}

} //DomaincontextcodegenPackageImpl
