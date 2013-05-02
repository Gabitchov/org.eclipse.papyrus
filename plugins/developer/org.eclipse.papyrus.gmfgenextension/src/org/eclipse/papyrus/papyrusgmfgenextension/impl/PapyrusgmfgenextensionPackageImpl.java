/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode;
import org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement;
import org.eclipse.papyrus.papyrusgmfgenextension.CompartmentTitleVisibilityPreference;
import org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference;
import org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService;
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView;
import org.eclipse.papyrus.papyrusgmfgenextension.ExternalElementTypesLibrary;
import org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook;
import org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType;
import org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint;
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand;
import org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference;
import org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionFactory;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class PapyrusgmfgenextensionPackageImpl extends EPackageImpl implements PapyrusgmfgenextensionPackage {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedGenViewEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentedElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyRefreshHookEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalHookEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificLocatorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusExtensionRootNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternateCanvasEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternateGenTopLevelNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternateGenLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutatingCanvasEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ownedEditpartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificDiagramUpdaterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genNodeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificLocatorExternalLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additionalEditPartCandiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editPartUsingDeleteServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editPartUsingReorientServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelVisibilityPreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compartmentVisibilityPreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compartmentTitleVisibilityPreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constrainedByReferenceCompartmentItemSemanticEditPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalElementTypesLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalMetamodelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generateUsingElementTypeCreationCommandEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrusgmfgenextensionPackageImpl() {
		super(eNS_URI, PapyrusgmfgenextensionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PapyrusgmfgenextensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrusgmfgenextensionPackage init() {
		if (isInited) return (PapyrusgmfgenextensionPackage)EPackage.Registry.INSTANCE.getEPackage(PapyrusgmfgenextensionPackage.eNS_URI);

		// Obtain or create and register package
		PapyrusgmfgenextensionPackageImpl thePapyrusgmfgenextensionPackage = (PapyrusgmfgenextensionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrusgmfgenextensionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrusgmfgenextensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DomaincontextcodegenPackage.eINSTANCE.eClass();
		GMFGenPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrusgmfgenextensionPackage.createPackageContents();

		// Initialize created meta-data
		thePapyrusgmfgenextensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrusgmfgenextensionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrusgmfgenextensionPackage.eNS_URI, thePapyrusgmfgenextensionPackage);
		return thePapyrusgmfgenextensionPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedGenView() {
		return extendedGenViewEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedGenView_GenView() {
		return (EReference)extendedGenViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedGenView_IsAbstract() {
		return (EAttribute)extendedGenViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedGenView_SuperGenViews() {
		return (EReference)extendedGenViewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedGenView_PropRefreshHook() {
		return (EReference)extendedGenViewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedGenView_Name() {
		return (EAttribute)extendedGenViewEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedGenView_SuperOwnedEditPart() {
		return (EAttribute)extendedGenViewEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommentedElement() {
		return commentedElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommentedElement_Comment() {
		return (EAttribute)commentedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyRefreshHook() {
		return propertyRefreshHookEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyRefreshHook_TriggeringCondition() {
		return (EAttribute)propertyRefreshHookEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyRefreshHook_Action() {
		return (EAttribute)propertyRefreshHookEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalHook() {
		return externalHookEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalHook_Classpath() {
		return (EAttribute)externalHookEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificLocator() {
		return specificLocatorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificLocator_GenChildSideAffixedNode() {
		return (EReference)specificLocatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusExtensionRootNode() {
		return papyrusExtensionRootNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusExtensionRootNode_ExtensionNodes() {
		return (EReference)papyrusExtensionRootNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternateCanvas() {
		return alternateCanvasEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_DomainDiagramElement() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_AlternateTopLevelNodes() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_AlternateLinkNodes() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_Diagram() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternateGenTopLevelNode() {
		return alternateGenTopLevelNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenTopLevelNode_GenTopLevelNode() {
		return (EReference)alternateGenTopLevelNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenTopLevelNode_TypeModelFacet() {
		return (EReference)alternateGenTopLevelNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternateGenLink() {
		return alternateGenLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenLink_GenLinkNode() {
		return (EReference)alternateGenLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenLink_TypeModelFacet() {
		return (EReference)alternateGenLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutatingCanvas() {
		return mutatingCanvasEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatingCanvas_AlternateCanvases() {
		return (EReference)mutatingCanvasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOwnedEditpart() {
		return ownedEditpartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOwnedEditpart_Name() {
		return (EAttribute)ownedEditpartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificDiagramUpdater() {
		return specificDiagramUpdaterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificDiagramUpdater_GenNode() {
		return (EReference)specificDiagramUpdaterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenNodeConstraint() {
		return genNodeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenNodeConstraint_GenNode() {
		return (EReference)genNodeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenNodeConstraint_GenConstraint() {
		return (EReference)genNodeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificLocatorExternalLabel() {
		return specificLocatorExternalLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificLocatorExternalLabel_GenExternalNodeLabel() {
		return (EReference)specificLocatorExternalLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditionalEditPartCandies() {
		return additionalEditPartCandiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdditionalEditPartCandies_BaseEditHelperPackage() {
		return (EAttribute)additionalEditPartCandiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditPartUsingDeleteService() {
		return editPartUsingDeleteServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditPartUsingDeleteService_Name() {
		return (EAttribute)editPartUsingDeleteServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditPartUsingDeleteService_GenView() {
		return (EReference)editPartUsingDeleteServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditPartUsingReorientService() {
		return editPartUsingReorientServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditPartUsingReorientService_Name() {
		return (EAttribute)editPartUsingReorientServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditPartUsingReorientService_GenView() {
		return (EReference)editPartUsingReorientServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabelVisibilityPreference() {
		return labelVisibilityPreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabelVisibilityPreference_Role() {
		return (EAttribute)labelVisibilityPreferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabelVisibilityPreference_IconPathRole() {
		return (EAttribute)labelVisibilityPreferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabelVisibilityPreference_LinkLabels() {
		return (EReference)labelVisibilityPreferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabelVisibilityPreference_ExternalNodeLabels() {
		return (EReference)labelVisibilityPreferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabelVisibilityPreference_VisibleByDefault() {
		return (EAttribute)labelVisibilityPreferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompartmentVisibilityPreference() {
		return compartmentVisibilityPreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartmentVisibilityPreference_VisibleByDefault() {
		return (EAttribute)compartmentVisibilityPreferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompartmentVisibilityPreference_Compartments() {
		return (EReference)compartmentVisibilityPreferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompartmentTitleVisibilityPreference() {
		return compartmentTitleVisibilityPreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartmentTitleVisibilityPreference_VisibleByDefault() {
		return (EAttribute)compartmentTitleVisibilityPreferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompartmentTitleVisibilityPreference_Compartments() {
		return (EReference)compartmentTitleVisibilityPreferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstrainedByReferenceCompartmentItemSemanticEditPolicy() {
		return constrainedByReferenceCompartmentItemSemanticEditPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstrainedByReferenceCompartmentItemSemanticEditPolicy_GenView() {
		return (EReference)constrainedByReferenceCompartmentItemSemanticEditPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalElementTypesLibrary() {
		return externalElementTypesLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalMetamodelType() {
		return externalMetamodelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalMetamodelType_ElementTypeRef() {
		return (EReference)externalMetamodelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenerateUsingElementTypeCreationCommand() {
		return generateUsingElementTypeCreationCommandEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusgmfgenextensionFactory getPapyrusgmfgenextensionFactory() {
		return (PapyrusgmfgenextensionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		extendedGenViewEClass = createEClass(EXTENDED_GEN_VIEW);
		createEReference(extendedGenViewEClass, EXTENDED_GEN_VIEW__GEN_VIEW);
		createEAttribute(extendedGenViewEClass, EXTENDED_GEN_VIEW__IS_ABSTRACT);
		createEReference(extendedGenViewEClass, EXTENDED_GEN_VIEW__SUPER_GEN_VIEWS);
		createEReference(extendedGenViewEClass, EXTENDED_GEN_VIEW__PROP_REFRESH_HOOK);
		createEAttribute(extendedGenViewEClass, EXTENDED_GEN_VIEW__NAME);
		createEAttribute(extendedGenViewEClass, EXTENDED_GEN_VIEW__SUPER_OWNED_EDIT_PART);

		commentedElementEClass = createEClass(COMMENTED_ELEMENT);
		createEAttribute(commentedElementEClass, COMMENTED_ELEMENT__COMMENT);

		propertyRefreshHookEClass = createEClass(PROPERTY_REFRESH_HOOK);
		createEAttribute(propertyRefreshHookEClass, PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION);
		createEAttribute(propertyRefreshHookEClass, PROPERTY_REFRESH_HOOK__ACTION);

		externalHookEClass = createEClass(EXTERNAL_HOOK);
		createEAttribute(externalHookEClass, EXTERNAL_HOOK__CLASSPATH);

		specificLocatorEClass = createEClass(SPECIFIC_LOCATOR);
		createEReference(specificLocatorEClass, SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE);

		papyrusExtensionRootNodeEClass = createEClass(PAPYRUS_EXTENSION_ROOT_NODE);
		createEReference(papyrusExtensionRootNodeEClass, PAPYRUS_EXTENSION_ROOT_NODE__EXTENSION_NODES);

		alternateCanvasEClass = createEClass(ALTERNATE_CANVAS);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__ALTERNATE_LINK_NODES);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__DIAGRAM);

		alternateGenTopLevelNodeEClass = createEClass(ALTERNATE_GEN_TOP_LEVEL_NODE);
		createEReference(alternateGenTopLevelNodeEClass, ALTERNATE_GEN_TOP_LEVEL_NODE__GEN_TOP_LEVEL_NODE);
		createEReference(alternateGenTopLevelNodeEClass, ALTERNATE_GEN_TOP_LEVEL_NODE__TYPE_MODEL_FACET);

		alternateGenLinkEClass = createEClass(ALTERNATE_GEN_LINK);
		createEReference(alternateGenLinkEClass, ALTERNATE_GEN_LINK__GEN_LINK_NODE);
		createEReference(alternateGenLinkEClass, ALTERNATE_GEN_LINK__TYPE_MODEL_FACET);

		mutatingCanvasEClass = createEClass(MUTATING_CANVAS);
		createEReference(mutatingCanvasEClass, MUTATING_CANVAS__ALTERNATE_CANVASES);

		ownedEditpartEClass = createEClass(OWNED_EDITPART);
		createEAttribute(ownedEditpartEClass, OWNED_EDITPART__NAME);

		specificDiagramUpdaterEClass = createEClass(SPECIFIC_DIAGRAM_UPDATER);
		createEReference(specificDiagramUpdaterEClass, SPECIFIC_DIAGRAM_UPDATER__GEN_NODE);

		genNodeConstraintEClass = createEClass(GEN_NODE_CONSTRAINT);
		createEReference(genNodeConstraintEClass, GEN_NODE_CONSTRAINT__GEN_NODE);
		createEReference(genNodeConstraintEClass, GEN_NODE_CONSTRAINT__GEN_CONSTRAINT);

		specificLocatorExternalLabelEClass = createEClass(SPECIFIC_LOCATOR_EXTERNAL_LABEL);
		createEReference(specificLocatorExternalLabelEClass, SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL);

		additionalEditPartCandiesEClass = createEClass(ADDITIONAL_EDIT_PART_CANDIES);
		createEAttribute(additionalEditPartCandiesEClass, ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE);

		editPartUsingDeleteServiceEClass = createEClass(EDIT_PART_USING_DELETE_SERVICE);
		createEAttribute(editPartUsingDeleteServiceEClass, EDIT_PART_USING_DELETE_SERVICE__NAME);
		createEReference(editPartUsingDeleteServiceEClass, EDIT_PART_USING_DELETE_SERVICE__GEN_VIEW);

		editPartUsingReorientServiceEClass = createEClass(EDIT_PART_USING_REORIENT_SERVICE);
		createEAttribute(editPartUsingReorientServiceEClass, EDIT_PART_USING_REORIENT_SERVICE__NAME);
		createEReference(editPartUsingReorientServiceEClass, EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW);

		labelVisibilityPreferenceEClass = createEClass(LABEL_VISIBILITY_PREFERENCE);
		createEAttribute(labelVisibilityPreferenceEClass, LABEL_VISIBILITY_PREFERENCE__ROLE);
		createEAttribute(labelVisibilityPreferenceEClass, LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE);
		createEReference(labelVisibilityPreferenceEClass, LABEL_VISIBILITY_PREFERENCE__LINK_LABELS);
		createEReference(labelVisibilityPreferenceEClass, LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS);
		createEAttribute(labelVisibilityPreferenceEClass, LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT);

		compartmentVisibilityPreferenceEClass = createEClass(COMPARTMENT_VISIBILITY_PREFERENCE);
		createEAttribute(compartmentVisibilityPreferenceEClass, COMPARTMENT_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT);
		createEReference(compartmentVisibilityPreferenceEClass, COMPARTMENT_VISIBILITY_PREFERENCE__COMPARTMENTS);

		compartmentTitleVisibilityPreferenceEClass = createEClass(COMPARTMENT_TITLE_VISIBILITY_PREFERENCE);
		createEAttribute(compartmentTitleVisibilityPreferenceEClass, COMPARTMENT_TITLE_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT);
		createEReference(compartmentTitleVisibilityPreferenceEClass, COMPARTMENT_TITLE_VISIBILITY_PREFERENCE__COMPARTMENTS);

		constrainedByReferenceCompartmentItemSemanticEditPolicyEClass = createEClass(CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY);
		createEReference(constrainedByReferenceCompartmentItemSemanticEditPolicyEClass, CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW);

		externalElementTypesLibraryEClass = createEClass(EXTERNAL_ELEMENT_TYPES_LIBRARY);

		externalMetamodelTypeEClass = createEClass(EXTERNAL_METAMODEL_TYPE);
		createEReference(externalMetamodelTypeEClass, EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF);

		generateUsingElementTypeCreationCommandEClass = createEClass(GENERATE_USING_ELEMENT_TYPE_CREATION_COMMAND);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GMFGenPackage theGMFGenPackage = (GMFGenPackage)EPackage.Registry.INSTANCE.getEPackage(GMFGenPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GenModelPackage theGenModelPackage = (GenModelPackage)EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);
		DomaincontextcodegenPackage theDomaincontextcodegenPackage = (DomaincontextcodegenPackage)EPackage.Registry.INSTANCE.getEPackage(DomaincontextcodegenPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extendedGenViewEClass.getESuperTypes().add(this.getCommentedElement());
		propertyRefreshHookEClass.getESuperTypes().add(this.getExternalHook());
		externalHookEClass.getESuperTypes().add(this.getCommentedElement());
		specificLocatorEClass.getESuperTypes().add(this.getExternalHook());
		papyrusExtensionRootNodeEClass.getESuperTypes().add(this.getCommentedElement());
		alternateCanvasEClass.getESuperTypes().add(this.getCommentedElement());
		alternateGenTopLevelNodeEClass.getESuperTypes().add(this.getCommentedElement());
		alternateGenLinkEClass.getESuperTypes().add(this.getCommentedElement());
		mutatingCanvasEClass.getESuperTypes().add(this.getCommentedElement());
		ownedEditpartEClass.getESuperTypes().add(this.getExternalHook());
		specificDiagramUpdaterEClass.getESuperTypes().add(this.getExternalHook());
		genNodeConstraintEClass.getESuperTypes().add(this.getCommentedElement());
		specificLocatorExternalLabelEClass.getESuperTypes().add(this.getExternalHook());
		additionalEditPartCandiesEClass.getESuperTypes().add(this.getCommentedElement());
		editPartUsingDeleteServiceEClass.getESuperTypes().add(this.getCommentedElement());
		editPartUsingReorientServiceEClass.getESuperTypes().add(this.getCommentedElement());
		labelVisibilityPreferenceEClass.getESuperTypes().add(this.getCommentedElement());
		compartmentVisibilityPreferenceEClass.getESuperTypes().add(this.getCommentedElement());
		compartmentTitleVisibilityPreferenceEClass.getESuperTypes().add(this.getCommentedElement());
		constrainedByReferenceCompartmentItemSemanticEditPolicyEClass.getESuperTypes().add(this.getCommentedElement());
		externalElementTypesLibraryEClass.getESuperTypes().add(theGMFGenPackage.getGenNode());
		externalElementTypesLibraryEClass.getESuperTypes().add(this.getCommentedElement());
		externalMetamodelTypeEClass.getESuperTypes().add(theGMFGenPackage.getMetamodelType());
		generateUsingElementTypeCreationCommandEClass.getESuperTypes().add(this.getCommentedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(extendedGenViewEClass, ExtendedGenView.class, "ExtendedGenView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendedGenView_GenView(), theGMFGenPackage.getGenCommonBase(), null, "genView", null, 1, -1, ExtendedGenView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtendedGenView_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, ExtendedGenView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtendedGenView_SuperGenViews(), theGMFGenPackage.getGenCommonBase(), null, "superGenViews", null, 0, -1, ExtendedGenView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtendedGenView_PropRefreshHook(), this.getPropertyRefreshHook(), null, "propRefreshHook", null, 0, 1, ExtendedGenView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtendedGenView_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ExtendedGenView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedGenView_SuperOwnedEditPart(), theEcorePackage.getEString(), "superOwnedEditPart", null, 0, 1, ExtendedGenView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentedElementEClass, CommentedElement.class, "CommentedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommentedElement_Comment(), ecorePackage.getEString(), "comment", null, 1, 1, CommentedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyRefreshHookEClass, PropertyRefreshHook.class, "PropertyRefreshHook", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyRefreshHook_TriggeringCondition(), ecorePackage.getEString(), "triggeringCondition", null, 1, 1, PropertyRefreshHook.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropertyRefreshHook_Action(), ecorePackage.getEString(), "action", null, 1, 1, PropertyRefreshHook.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(externalHookEClass, ExternalHook.class, "ExternalHook", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalHook_Classpath(), ecorePackage.getEString(), "classpath", null, 0, 1, ExternalHook.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(specificLocatorEClass, SpecificLocator.class, "SpecificLocator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificLocator_GenChildSideAffixedNode(), theGMFGenPackage.getGenChildSideAffixedNode(), null, "genChildSideAffixedNode", null, 0, -1, SpecificLocator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(papyrusExtensionRootNodeEClass, PapyrusExtensionRootNode.class, "PapyrusExtensionRootNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPapyrusExtensionRootNode_ExtensionNodes(), this.getCommentedElement(), null, "extensionNodes", null, 0, -1, PapyrusExtensionRootNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternateCanvasEClass, AlternateCanvas.class, "AlternateCanvas", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternateCanvas_DomainDiagramElement(), theGenModelPackage.getGenClass(), null, "domainDiagramElement", null, 1, 1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateCanvas_AlternateTopLevelNodes(), this.getAlternateGenTopLevelNode(), null, "alternateTopLevelNodes", null, 0, -1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateCanvas_AlternateLinkNodes(), this.getAlternateGenLink(), null, "alternateLinkNodes", null, 0, -1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateCanvas_Diagram(), theGMFGenPackage.getGenDiagram(), null, "diagram", null, 1, 1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternateGenTopLevelNodeEClass, AlternateGenTopLevelNode.class, "AlternateGenTopLevelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternateGenTopLevelNode_GenTopLevelNode(), theGMFGenPackage.getGenTopLevelNode(), null, "genTopLevelNode", null, 1, 1, AlternateGenTopLevelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateGenTopLevelNode_TypeModelFacet(), theGMFGenPackage.getTypeModelFacet(), null, "typeModelFacet", null, 1, 1, AlternateGenTopLevelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternateGenLinkEClass, AlternateGenLink.class, "AlternateGenLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternateGenLink_GenLinkNode(), theGMFGenPackage.getGenLink(), null, "genLinkNode", null, 1, 1, AlternateGenLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateGenLink_TypeModelFacet(), theGMFGenPackage.getTypeModelFacet(), null, "typeModelFacet", null, 1, 1, AlternateGenLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutatingCanvasEClass, MutatingCanvas.class, "MutatingCanvas", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMutatingCanvas_AlternateCanvases(), this.getAlternateCanvas(), null, "alternateCanvases", null, 0, -1, MutatingCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ownedEditpartEClass, OwnedEditpart.class, "OwnedEditpart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOwnedEditpart_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OwnedEditpart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specificDiagramUpdaterEClass, SpecificDiagramUpdater.class, "SpecificDiagramUpdater", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificDiagramUpdater_GenNode(), theGMFGenPackage.getGenCommonBase(), null, "genNode", null, 0, 1, SpecificDiagramUpdater.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genNodeConstraintEClass, GenNodeConstraint.class, "GenNodeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenNodeConstraint_GenNode(), theGMFGenPackage.getGenNode(), null, "genNode", null, 0, -1, GenNodeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenNodeConstraint_GenConstraint(), theGMFGenPackage.getGenConstraint(), null, "genConstraint", null, 0, 1, GenNodeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specificLocatorExternalLabelEClass, SpecificLocatorExternalLabel.class, "SpecificLocatorExternalLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificLocatorExternalLabel_GenExternalNodeLabel(), theGMFGenPackage.getGenExternalNodeLabel(), null, "genExternalNodeLabel", null, 0, -1, SpecificLocatorExternalLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additionalEditPartCandiesEClass, AdditionalEditPartCandies.class, "AdditionalEditPartCandies", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdditionalEditPartCandies_BaseEditHelperPackage(), theEcorePackage.getEString(), "baseEditHelperPackage", null, 0, 1, AdditionalEditPartCandies.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editPartUsingDeleteServiceEClass, EditPartUsingDeleteService.class, "EditPartUsingDeleteService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEditPartUsingDeleteService_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EditPartUsingDeleteService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditPartUsingDeleteService_GenView(), theGMFGenPackage.getGenCommonBase(), null, "genView", null, 0, -1, EditPartUsingDeleteService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(editPartUsingReorientServiceEClass, EditPartUsingReorientService.class, "EditPartUsingReorientService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEditPartUsingReorientService_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EditPartUsingReorientService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditPartUsingReorientService_GenView(), theGMFGenPackage.getGenLink(), null, "genView", null, 0, -1, EditPartUsingReorientService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(labelVisibilityPreferenceEClass, LabelVisibilityPreference.class, "LabelVisibilityPreference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabelVisibilityPreference_Role(), theEcorePackage.getEString(), "role", null, 1, 1, LabelVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLabelVisibilityPreference_IconPathRole(), ecorePackage.getEString(), "iconPathRole", null, 0, 1, LabelVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLabelVisibilityPreference_LinkLabels(), theGMFGenPackage.getGenLinkLabel(), null, "linkLabels", null, 0, -1, LabelVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLabelVisibilityPreference_ExternalNodeLabels(), theGMFGenPackage.getGenExternalNodeLabel(), null, "externalNodeLabels", null, 0, -1, LabelVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLabelVisibilityPreference_VisibleByDefault(), theEcorePackage.getEBoolean(), "visibleByDefault", "true", 0, 1, LabelVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compartmentVisibilityPreferenceEClass, CompartmentVisibilityPreference.class, "CompartmentVisibilityPreference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompartmentVisibilityPreference_VisibleByDefault(), theEcorePackage.getEBoolean(), "visibleByDefault", "true", 0, 1, CompartmentVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompartmentVisibilityPreference_Compartments(), theGMFGenPackage.getGenCompartment(), null, "compartments", null, 0, -1, CompartmentVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compartmentTitleVisibilityPreferenceEClass, CompartmentTitleVisibilityPreference.class, "CompartmentTitleVisibilityPreference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompartmentTitleVisibilityPreference_VisibleByDefault(), theEcorePackage.getEBoolean(), "visibleByDefault", "true", 0, 1, CompartmentTitleVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompartmentTitleVisibilityPreference_Compartments(), theGMFGenPackage.getGenCompartment(), null, "compartments", null, 0, -1, CompartmentTitleVisibilityPreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constrainedByReferenceCompartmentItemSemanticEditPolicyEClass, ConstrainedByReferenceCompartmentItemSemanticEditPolicy.class, "ConstrainedByReferenceCompartmentItemSemanticEditPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrainedByReferenceCompartmentItemSemanticEditPolicy_GenView(), theGMFGenPackage.getGenCommonBase(), null, "genView", null, 0, -1, ConstrainedByReferenceCompartmentItemSemanticEditPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalElementTypesLibraryEClass, ExternalElementTypesLibrary.class, "ExternalElementTypesLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMetamodelTypeEClass, ExternalMetamodelType.class, "ExternalMetamodelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalMetamodelType_ElementTypeRef(), theDomaincontextcodegenPackage.getElementType(), null, "elementTypeRef", null, 0, 1, ExternalMetamodelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generateUsingElementTypeCreationCommandEClass, GenerateUsingElementTypeCreationCommand.class, "GenerateUsingElementTypeCreationCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // PapyrusgmfgenextensionPackageImpl
