/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase;
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
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
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage
 * @generated
 */
public class PapyrusgmfgenextensionSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PapyrusgmfgenextensionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusgmfgenextensionSwitch() {
		if (modelPackage == null) {
			modelPackage = PapyrusgmfgenextensionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PapyrusgmfgenextensionPackage.EXTENDED_GEN_VIEW: {
				ExtendedGenView extendedGenView = (ExtendedGenView)theEObject;
				T result = caseExtendedGenView(extendedGenView);
				if (result == null) result = caseCommentedElement(extendedGenView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.COMMENTED_ELEMENT: {
				CommentedElement commentedElement = (CommentedElement)theEObject;
				T result = caseCommentedElement(commentedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.PROPERTY_REFRESH_HOOK: {
				PropertyRefreshHook propertyRefreshHook = (PropertyRefreshHook)theEObject;
				T result = casePropertyRefreshHook(propertyRefreshHook);
				if (result == null) result = caseExternalHook(propertyRefreshHook);
				if (result == null) result = caseCommentedElement(propertyRefreshHook);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.EXTERNAL_HOOK: {
				ExternalHook externalHook = (ExternalHook)theEObject;
				T result = caseExternalHook(externalHook);
				if (result == null) result = caseCommentedElement(externalHook);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR: {
				SpecificLocator specificLocator = (SpecificLocator)theEObject;
				T result = caseSpecificLocator(specificLocator);
				if (result == null) result = caseExternalHook(specificLocator);
				if (result == null) result = caseCommentedElement(specificLocator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.PAPYRUS_EXTENSION_ROOT_NODE: {
				PapyrusExtensionRootNode papyrusExtensionRootNode = (PapyrusExtensionRootNode)theEObject;
				T result = casePapyrusExtensionRootNode(papyrusExtensionRootNode);
				if (result == null) result = caseCommentedElement(papyrusExtensionRootNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS: {
				AlternateCanvas alternateCanvas = (AlternateCanvas)theEObject;
				T result = caseAlternateCanvas(alternateCanvas);
				if (result == null) result = caseCommentedElement(alternateCanvas);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_TOP_LEVEL_NODE: {
				AlternateGenTopLevelNode alternateGenTopLevelNode = (AlternateGenTopLevelNode)theEObject;
				T result = caseAlternateGenTopLevelNode(alternateGenTopLevelNode);
				if (result == null) result = caseCommentedElement(alternateGenTopLevelNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.ALTERNATE_GEN_LINK: {
				AlternateGenLink alternateGenLink = (AlternateGenLink)theEObject;
				T result = caseAlternateGenLink(alternateGenLink);
				if (result == null) result = caseCommentedElement(alternateGenLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.MUTATING_CANVAS: {
				MutatingCanvas mutatingCanvas = (MutatingCanvas)theEObject;
				T result = caseMutatingCanvas(mutatingCanvas);
				if (result == null) result = caseCommentedElement(mutatingCanvas);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.OWNED_EDITPART: {
				OwnedEditpart ownedEditpart = (OwnedEditpart)theEObject;
				T result = caseOwnedEditpart(ownedEditpart);
				if (result == null) result = caseExternalHook(ownedEditpart);
				if (result == null) result = caseCommentedElement(ownedEditpart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER: {
				SpecificDiagramUpdater specificDiagramUpdater = (SpecificDiagramUpdater)theEObject;
				T result = caseSpecificDiagramUpdater(specificDiagramUpdater);
				if (result == null) result = caseExternalHook(specificDiagramUpdater);
				if (result == null) result = caseCommentedElement(specificDiagramUpdater);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.GEN_NODE_CONSTRAINT: {
				GenNodeConstraint genNodeConstraint = (GenNodeConstraint)theEObject;
				T result = caseGenNodeConstraint(genNodeConstraint);
				if (result == null) result = caseCommentedElement(genNodeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR_EXTERNAL_LABEL: {
				SpecificLocatorExternalLabel specificLocatorExternalLabel = (SpecificLocatorExternalLabel)theEObject;
				T result = caseSpecificLocatorExternalLabel(specificLocatorExternalLabel);
				if (result == null) result = caseExternalHook(specificLocatorExternalLabel);
				if (result == null) result = caseCommentedElement(specificLocatorExternalLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.ADDITIONAL_EDIT_PART_CANDIES: {
				AdditionalEditPartCandies additionalEditPartCandies = (AdditionalEditPartCandies)theEObject;
				T result = caseAdditionalEditPartCandies(additionalEditPartCandies);
				if (result == null) result = caseCommentedElement(additionalEditPartCandies);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_DELETE_SERVICE: {
				EditPartUsingDeleteService editPartUsingDeleteService = (EditPartUsingDeleteService)theEObject;
				T result = caseEditPartUsingDeleteService(editPartUsingDeleteService);
				if (result == null) result = caseCommentedElement(editPartUsingDeleteService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE: {
				EditPartUsingReorientService editPartUsingReorientService = (EditPartUsingReorientService)theEObject;
				T result = caseEditPartUsingReorientService(editPartUsingReorientService);
				if (result == null) result = caseCommentedElement(editPartUsingReorientService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE: {
				LabelVisibilityPreference labelVisibilityPreference = (LabelVisibilityPreference)theEObject;
				T result = caseLabelVisibilityPreference(labelVisibilityPreference);
				if (result == null) result = caseCommentedElement(labelVisibilityPreference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.COMPARTMENT_VISIBILITY_PREFERENCE: {
				CompartmentVisibilityPreference compartmentVisibilityPreference = (CompartmentVisibilityPreference)theEObject;
				T result = caseCompartmentVisibilityPreference(compartmentVisibilityPreference);
				if (result == null) result = caseCommentedElement(compartmentVisibilityPreference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.COMPARTMENT_TITLE_VISIBILITY_PREFERENCE: {
				CompartmentTitleVisibilityPreference compartmentTitleVisibilityPreference = (CompartmentTitleVisibilityPreference)theEObject;
				T result = caseCompartmentTitleVisibilityPreference(compartmentTitleVisibilityPreference);
				if (result == null) result = caseCommentedElement(compartmentTitleVisibilityPreference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY: {
				ConstrainedByReferenceCompartmentItemSemanticEditPolicy constrainedByReferenceCompartmentItemSemanticEditPolicy = (ConstrainedByReferenceCompartmentItemSemanticEditPolicy)theEObject;
				T result = caseConstrainedByReferenceCompartmentItemSemanticEditPolicy(constrainedByReferenceCompartmentItemSemanticEditPolicy);
				if (result == null) result = caseCommentedElement(constrainedByReferenceCompartmentItemSemanticEditPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.EXTERNAL_ELEMENT_TYPES_LIBRARY: {
				ExternalElementTypesLibrary externalElementTypesLibrary = (ExternalElementTypesLibrary)theEObject;
				T result = caseExternalElementTypesLibrary(externalElementTypesLibrary);
				if (result == null) result = caseGenNode(externalElementTypesLibrary);
				if (result == null) result = caseCommentedElement(externalElementTypesLibrary);
				if (result == null) result = caseGenChildContainer(externalElementTypesLibrary);
				if (result == null) result = caseGenLinkEnd(externalElementTypesLibrary);
				if (result == null) result = caseGenContainerBase(externalElementTypesLibrary);
				if (result == null) result = caseGenCommonBase(externalElementTypesLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.EXTERNAL_METAMODEL_TYPE: {
				ExternalMetamodelType externalMetamodelType = (ExternalMetamodelType)theEObject;
				T result = caseExternalMetamodelType(externalMetamodelType);
				if (result == null) result = caseMetamodelType(externalMetamodelType);
				if (result == null) result = caseElementType(externalMetamodelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.GENERATE_USING_ELEMENT_TYPE_CREATION_COMMAND: {
				GenerateUsingElementTypeCreationCommand generateUsingElementTypeCreationCommand = (GenerateUsingElementTypeCreationCommand)theEObject;
				T result = caseGenerateUsingElementTypeCreationCommand(generateUsingElementTypeCreationCommand);
				if (result == null) result = caseCommentedElement(generateUsingElementTypeCreationCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PapyrusgmfgenextensionPackage.CUSTOM_DIAGRAM_UPDATER_SINGLETON: {
				CustomDiagramUpdaterSingleton customDiagramUpdaterSingleton = (CustomDiagramUpdaterSingleton)theEObject;
				T result = caseCustomDiagramUpdaterSingleton(customDiagramUpdaterSingleton);
				if (result == null) result = caseCommentedElement(customDiagramUpdaterSingleton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Gen View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Gen View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedGenView(ExtendedGenView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Commented Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Commented Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommentedElement(CommentedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Refresh Hook</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Refresh Hook</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyRefreshHook(PropertyRefreshHook object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Hook</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Hook</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalHook(ExternalHook object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Locator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Locator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificLocator(SpecificLocator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Papyrus Extension Root Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Papyrus Extension Root Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePapyrusExtensionRootNode(PapyrusExtensionRootNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternate Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternate Canvas</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlternateCanvas(AlternateCanvas object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternate Gen Top Level Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternate Gen Top Level Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlternateGenTopLevelNode(AlternateGenTopLevelNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternate Gen Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternate Gen Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlternateGenLink(AlternateGenLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutating Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutating Canvas</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutatingCanvas(MutatingCanvas object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Owned Editpart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Owned Editpart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOwnedEditpart(OwnedEditpart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Diagram Updater</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Diagram Updater</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificDiagramUpdater(SpecificDiagramUpdater object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Node Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Node Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenNodeConstraint(GenNodeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Locator External Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Locator External Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificLocatorExternalLabel(SpecificLocatorExternalLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additional Edit Part Candies</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additional Edit Part Candies</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditionalEditPartCandies(AdditionalEditPartCandies object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edit Part Using Delete Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edit Part Using Delete Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditPartUsingDeleteService(EditPartUsingDeleteService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edit Part Using Reorient Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edit Part Using Reorient Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditPartUsingReorientService(EditPartUsingReorientService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Visibility Preference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Visibility Preference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabelVisibilityPreference(LabelVisibilityPreference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compartment Visibility Preference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compartment Visibility Preference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompartmentVisibilityPreference(CompartmentVisibilityPreference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compartment Title Visibility Preference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compartment Title Visibility Preference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompartmentTitleVisibilityPreference(CompartmentTitleVisibilityPreference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constrained By Reference Compartment Item Semantic Edit Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constrained By Reference Compartment Item Semantic Edit Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstrainedByReferenceCompartmentItemSemanticEditPolicy(ConstrainedByReferenceCompartmentItemSemanticEditPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Element Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Element Types Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalElementTypesLibrary(ExternalElementTypesLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Metamodel Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Metamodel Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalMetamodelType(ExternalMetamodelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generate Using Element Type Creation Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generate Using Element Type Creation Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenerateUsingElementTypeCreationCommand(GenerateUsingElementTypeCreationCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Diagram Updater Singleton</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Diagram Updater Singleton</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomDiagramUpdaterSingleton(CustomDiagramUpdaterSingleton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Common Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Common Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenCommonBase(GenCommonBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Container Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Container Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenContainerBase(GenContainerBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Child Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Child Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenChildContainer(GenChildContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Link End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Link End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenLinkEnd(GenLinkEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenNode(GenNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementType(ElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metamodel Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metamodel Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodelType(MetamodelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //PapyrusgmfgenextensionSwitch
