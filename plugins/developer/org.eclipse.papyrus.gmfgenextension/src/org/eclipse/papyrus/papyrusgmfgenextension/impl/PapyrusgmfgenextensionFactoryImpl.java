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
			PapyrusgmfgenextensionFactory thePapyrusgmfgenextensionFactory = (PapyrusgmfgenextensionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/2009/papyrusgmfgenextension"); 
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
			case PapyrusgmfgenextensionPackage.EXTENDED_GEN_NODE: return createExtendedGenNode();
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
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedGenNode createExtendedGenNode() {
		ExtendedGenNodeImpl extendedGenNode = new ExtendedGenNodeImpl();
		return extendedGenNode;
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
