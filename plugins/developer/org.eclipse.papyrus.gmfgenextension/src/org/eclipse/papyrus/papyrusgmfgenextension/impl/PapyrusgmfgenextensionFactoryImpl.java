/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.papyrusgmfgenextension.*;
import org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode;
import org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService;
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView;
import org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook;
import org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint;
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
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusgmfgenextensionFactoryImpl extends EFactoryImpl implements PapyrusgmfgenextensionFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PapyrusgmfgenextensionFactory init() {
		try {
			PapyrusgmfgenextensionFactory thePapyrusgmfgenextensionFactory = (PapyrusgmfgenextensionFactory)EPackage.Registry.INSTANCE.getEFactory(PapyrusgmfgenextensionPackage.eNS_URI);
			if (thePapyrusgmfgenextensionFactory != null) {
				return thePapyrusgmfgenextensionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PapyrusgmfgenextensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusgmfgenextensionFactoryImpl() {
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
			case PapyrusgmfgenextensionPackage.EXTENDED_GEN_VIEW: return createExtendedGenView();
			case PapyrusgmfgenextensionPackage.COMMENTED_ELEMENT: return createCommentedElement();
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK: return createPropertyRefreshHook();
			case PapyrusgmfgenextensionPackage.EXTERNAL_HOOK: return createExternalHook();
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR: return createSpecificLocator();
			case PapyrusgmfgenextensionPackage.PAPYRUS_EXTENSION_ROOT_NODE: return createPapyrusExtensionRootNode();
			case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS: return createAlternateCanvas();
			case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_TOP_LEVEL_NODE: return createAlternateGenTopLevelNode();
			case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK: return createAlternateGenLink();
			case PapyrusgmfgenextensionPackage.MUTATING_CANVAS: return createMutatingCanvas();
			case PapyrusgmfgenextensionPackage.OWNED_EDITPART: return createOwnedEditpart();
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER: return createSpecificDiagramUpdater();
			case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT: return createGenNodeConstraint();
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR_EXTERNAL_LABEL: return createSpecificLocatorExternalLabel();
			case PapyrusgmfgenextensionPackage.ADDITIONAL_EDIT_PART_CANDIES: return createAdditionalEditPartCandies();
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_DELETE_SERVICE: return createEditPartUsingDeleteService();
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE: return createEditPartUsingReorientService();
			case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE: return createLabelVisibilityPreference();
			case PapyrusgmfgenextensionPackage.COMPARTMENT_VISIBILITY_PREFERENCE: return createCompartmentVisibilityPreference();
			case PapyrusgmfgenextensionPackage.COMPARTMENT_TITLE_VISIBILITY_PREFERENCE: return createCompartmentTitleVisibilityPreference();
			case PapyrusgmfgenextensionPackage.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY: return createConstrainedByReferenceCompartmentItemSemanticEditPolicy();
			case PapyrusgmfgenextensionPackage.EXTERNAL_ELEMENT_TYPES_LIBRARY: return createExternalElementTypesLibrary();
			case PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE: return createExternalMetamodelType();
			case PapyrusgmfgenextensionPackage.GENERATE_USING_ELEMENT_TYPE_CREATION_COMMAND: return createGenerateUsingElementTypeCreationCommand();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedGenView createExtendedGenView() {
		ExtendedGenViewImpl extendedGenView = new ExtendedGenViewImpl();
		return extendedGenView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommentedElement createCommentedElement() {
		CommentedElementImpl commentedElement = new CommentedElementImpl();
		return commentedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyRefreshHook createPropertyRefreshHook() {
		PropertyRefreshHookImpl propertyRefreshHook = new PropertyRefreshHookImpl();
		return propertyRefreshHook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalHook createExternalHook() {
		ExternalHookImpl externalHook = new ExternalHookImpl();
		return externalHook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificLocator createSpecificLocator() {
		SpecificLocatorImpl specificLocator = new SpecificLocatorImpl();
		return specificLocator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusExtensionRootNode createPapyrusExtensionRootNode() {
		PapyrusExtensionRootNodeImpl papyrusExtensionRootNode = new PapyrusExtensionRootNodeImpl();
		return papyrusExtensionRootNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternateCanvas createAlternateCanvas() {
		AlternateCanvasImpl alternateCanvas = new AlternateCanvasImpl();
		return alternateCanvas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternateGenTopLevelNode createAlternateGenTopLevelNode() {
		AlternateGenTopLevelNodeImpl alternateGenTopLevelNode = new AlternateGenTopLevelNodeImpl();
		return alternateGenTopLevelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternateGenLink createAlternateGenLink() {
		AlternateGenLinkImpl alternateGenLink = new AlternateGenLinkImpl();
		return alternateGenLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatingCanvas createMutatingCanvas() {
		MutatingCanvasImpl mutatingCanvas = new MutatingCanvasImpl();
		return mutatingCanvas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OwnedEditpart createOwnedEditpart() {
		OwnedEditpartImpl ownedEditpart = new OwnedEditpartImpl();
		return ownedEditpart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificDiagramUpdater createSpecificDiagramUpdater() {
		SpecificDiagramUpdaterImpl specificDiagramUpdater = new SpecificDiagramUpdaterImpl();
		return specificDiagramUpdater;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenNodeConstraint createGenNodeConstraint() {
		GenNodeConstraintImpl genNodeConstraint = new GenNodeConstraintImpl();
		return genNodeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificLocatorExternalLabel createSpecificLocatorExternalLabel() {
		SpecificLocatorExternalLabelImpl specificLocatorExternalLabel = new SpecificLocatorExternalLabelImpl();
		return specificLocatorExternalLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditionalEditPartCandies createAdditionalEditPartCandies() {
		AdditionalEditPartCandiesImpl additionalEditPartCandies = new AdditionalEditPartCandiesImpl();
		return additionalEditPartCandies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditPartUsingDeleteService createEditPartUsingDeleteService() {
		EditPartUsingDeleteServiceImpl editPartUsingDeleteService = new EditPartUsingDeleteServiceImpl();
		return editPartUsingDeleteService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditPartUsingReorientService createEditPartUsingReorientService() {
		EditPartUsingReorientServiceImpl editPartUsingReorientService = new EditPartUsingReorientServiceImpl();
		return editPartUsingReorientService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelVisibilityPreference createLabelVisibilityPreference() {
		LabelVisibilityPreferenceImpl labelVisibilityPreference = new LabelVisibilityPreferenceImpl();
		return labelVisibilityPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentVisibilityPreference createCompartmentVisibilityPreference() {
		CompartmentVisibilityPreferenceImpl compartmentVisibilityPreference = new CompartmentVisibilityPreferenceImpl();
		return compartmentVisibilityPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentTitleVisibilityPreference createCompartmentTitleVisibilityPreference() {
		CompartmentTitleVisibilityPreferenceImpl compartmentTitleVisibilityPreference = new CompartmentTitleVisibilityPreferenceImpl();
		return compartmentTitleVisibilityPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstrainedByReferenceCompartmentItemSemanticEditPolicy createConstrainedByReferenceCompartmentItemSemanticEditPolicy() {
		ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl constrainedByReferenceCompartmentItemSemanticEditPolicy = new ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl();
		return constrainedByReferenceCompartmentItemSemanticEditPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalElementTypesLibrary createExternalElementTypesLibrary() {
		ExternalElementTypesLibraryImpl externalElementTypesLibrary = new ExternalElementTypesLibraryImpl();
		return externalElementTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalMetamodelType createExternalMetamodelType() {
		ExternalMetamodelTypeImpl externalMetamodelType = new ExternalMetamodelTypeImpl();
		return externalMetamodelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerateUsingElementTypeCreationCommand createGenerateUsingElementTypeCreationCommand() {
		GenerateUsingElementTypeCreationCommandImpl generateUsingElementTypeCreationCommand = new GenerateUsingElementTypeCreationCommandImpl();
		return generateUsingElementTypeCreationCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusgmfgenextensionPackage getPapyrusgmfgenextensionPackage() {
		return (PapyrusgmfgenextensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PapyrusgmfgenextensionPackage getPackage() {
		return PapyrusgmfgenextensionPackage.eINSTANCE;
	}

} //PapyrusgmfgenextensionFactoryImpl
