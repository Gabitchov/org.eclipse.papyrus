/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.papyrus.core.listenerservice.ModelListenerManager;
import org.eclipse.papyrus.core.multidiagram.SashDiagramModelUtil;
import org.eclipse.papyrus.di.DiFactory;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.di.Uml1SemanticModelBridge;
import org.eclipse.papyrus.di.provider.DiItemProviderAdapterFactory;
import org.eclipse.papyrus.di.util.DiSwitch;
import org.eclipse.uml2.common.edit.domain.UML2AdapterFactoryEditingDomain;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * ResourceSet Manager for UML and DI files, and also other loaded models.
 * 
 * @author Cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiResourceSet {

	/** debug channel */
	protected static final int channel = 25;

	/**
	 * File extension used for DI.
	 */
	public String diFileExtension;

	/**
	 * File extension used for Model.
	 */
	public String modelFileExtension;

	/**
	 * The UML model resource.
	 */
	protected Resource modelResource;

	/**
	 * The DI resource.
	 */
	protected Resource diResource;

	/**
	 * File extension used for Model. TODO: change following and pass it throw constructor ?
	 */
	public String notationFileExtension = "notation";

	/**
	 * URI of the notation file.
	 */
	protected URI notationURI;

	/**
	 * The DI resource.
	 */
	protected Resource notationResource;

	/**
	 * 
	 */
	private IProject theProject; // opened eclipse project

	/**
	 * URI of the model file.
	 */
	protected URI modelUri;

	/**
	 * URI of the di file.
	 */
	protected URI diUri;

	/**
	 * 
	 */
	protected IPath umlIpath;

	/** The filter used to get diagram elements */
	protected static IFilter diagramFilter = new DiagramFilter();

	/** Provider used to get the collection of elements from the diResource */
	protected DiAllContentsProvider diAllContentsProvider = new DiAllContentsProvider();

	/**
	 * this is the editing domain to load and apply EMF command on the repository
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * this is the editing domain to load and apply EMF command on the repository
	 */
	protected TransactionalEditingDomain transactionalEditingDomain;

	public static String EditingDomainID = "com.cea.papyrus.core.PapyrusEditingDomainID";

	/** This is the one adapter factory used for providing views of the model */
	protected AdapterFactory adapterFactory;

	/**
	 * Creates a new DiResourceSet, with specified extensions for di2 files and model files
	 * 
	 * @param diFileExtension
	 *            extension for di files
	 * @param modelFileExtension
	 *            extension for model files
	 */
	public DiResourceSet(String diFileExtension, String modelFileExtension, AdapterFactory adapterFactory) {
		this.diFileExtension = diFileExtension;
		this.modelFileExtension = modelFileExtension;

		// init the ResourceSet that manages di and uml
		// resourceSet = new ResourceSetImpl();
		// this.initStandAlone(resourceSet);

		// init EMF environment
		this.initEMFTool(adapterFactory);
	}

	/**
	 *this method allows initializing EMF environment. To do this we copy code of the Di2 editor.
	 */
	public void initEMFTool(AdapterFactory adapterFactory) {
		// adpater was not initialized (example: wizards)
		if (adapterFactory == null) {
			List<ComposeableAdapterFactory> factories = new ArrayList<ComposeableAdapterFactory>();
			// factories.add(new UMLExtendedItemProviderAdapterFactory());
			factories.add(new UMLItemProviderAdapterFactory());
			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new DiItemProviderAdapterFactory());
			factories.add(new EcoreItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());

			this.adapterFactory = new ComposedAdapterFactory(factories);
		} else {
			this.adapterFactory = adapterFactory;
		}

		// Create the command stack that will notify this editor as commands are
		// executed.
		BasicCommandStack commandStack = new BasicCommandStack();

		// Create the editing domain
		createEditingDomain();
	}

	protected void createEditingDomain() {
		// Create the editing domain with a special command stack
		// a "default" ResourceSet is created by this Editing domain, no need to
		// create a new one
		// Create the command stack that will notify this editor as commands are
		// executed.
		BasicCommandStack commandStack = new BasicCommandStack();
		editingDomain = new UML2AdapterFactoryEditingDomain(this.adapterFactory, commandStack, new HashMap());

		transactionalEditingDomain = DiagramEditingDomainFactory.getInstance().createEditingDomain(editingDomain.getResourceSet());
		transactionalEditingDomain.setID("org.eclipse.uml2.diagram.clazz.EditingDomain"); //$NON-NLS-1$
		TransactionalEditingDomain.Registry.INSTANCE.add("org.eclipse.uml2.diagram.clazz.EditingDomain", transactionalEditingDomain);

		// transactionalEditingDomain =
		// (TransactionalEditingDomainImpl)DiagramEditingDomainFactory
		// .getInstance().createEditingDomain(editingDomain.getResourceSet());
		// transactionalEditingDomain.setID( EditingDomainID );

		// Map<String, Boolean> options = new HashMap<String, Boolean>();
		// options.put(Transaction.OPTION_NO_NOTIFICATIONS, Boolean.TRUE);
		// options.put(Transaction.OPTION_NO_VALIDATION, Boolean.TRUE);
		// options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		// transactionalEditingDomain.setDefaultTransactionOptions(options);

	}

	/**
	 * Creates a new DiResourceSet, using default for file extensions.
	 */
	public DiResourceSet() {
		this("di2", UMLResource.FILE_EXTENSION, null);
	}

	/**
	 * Creates a new DiResourceSet, using default for file extensions.
	 */
	public DiResourceSet(AdapterFactory adapterFactory) {
		this("di2", UMLResource.FILE_EXTENSION, adapterFactory);
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public IFile getUMLifile() {
		IFile umlFile = theProject.getFile(umlIpath.lastSegment());
		return umlFile;
	}

	/**
	 * 
	 */
	public void loadUMLResource(URI uri) {
		this.modelUri = uri;
		modelResource = getResourceSet().getResource(modelUri, true);
	}

	/**
	 * Load both files (DI and UML) from an handle on one of the two files.
	 * 
	 * @param file
	 */
	public void loadResources(IFile file) {
		theProject = file.getProject();// setProject File

		// Extract file name, without extension
		IPath fullPath = file.getFullPath().removeFileExtension();

		// Load UML file
		umlIpath = fullPath.addFileExtension(UMLResource.FILE_EXTENSION);
		URI uri = URI.createURI("platform:/resource" + fullPath.addFileExtension(modelFileExtension).toString());
		loadUMLResource(uri);

		// TODO move next line away from DiResourceSet ? Define a place
		// where Resource initialisation can take place.
		modelResource.eAdapters().add(new ModelListenerManager());

		// Debug.debug(this, "Uml resource loaded from '" +modelUri+ "'",
		// channel);

		// load DI2
		diUri = URI.createURI("platform:/resource" + fullPath.addFileExtension(diFileExtension).toString());
		diResource = getResourceSet().getResource(diUri, true);
		// Debug.debug(this, "DI resource loaded from '" +diUri+ "'", channel);
		validateFile();

		// load notation
		notationURI = URI.createPlatformResourceURI(fullPath.addFileExtension(notationFileExtension).toString(), true);
		notationResource = getResourceSet().getResource(notationURI, true);
		// Debug.debug(this, "Notation resource loaded from '" +notationURI+
		// "'", channel);

		// Check resources versions. Update if needed
		chechResourceVersions();

	}

	// /**
	// * Create Di2 files.
	// *
	// * @param newfile
	// * a file that gives the path for the new Di File
	// */
	// public void createDi2Resources(IFile newfile) {
	// Package topPackage = null;
	//
	// // Extract file name, without extension
	// IPath fullPath = newfile.getFullPath().removeFileExtension();
	//
	// // Load UML file
	// modelUri = URI.createURI("platform:/resource" +
	// fullPath.addFileExtension(modelFileExtension).toString());
	// modelResource = getResourceSet().getResource(modelUri, true);
	// // Debug.debug(this, "Uml resource loaded from '" +modelUri+ "'",
	// channel);
	// topPackage = getTopPackageFromUMLResource();
	//
	// // Get a resource
	// diUri = URI.createURI("platform:/resource" +
	// fullPath.addFileExtension(diFileExtension).toString()); // creation of
	// the ressource Di2
	// diResource = getResourceSet().createResource(diUri);
	//
	// createClassDiagram(topPackage, "DefaultDiagram"); // add default diagram
	//
	// try {
	// saveResources();
	// } catch (Exception e) {
	// // Debug.log(e);
	// }
	// }

	/**
	 * Check versions of the resources. UIpdate if needed.
	 */
	private void chechResourceVersions() {

		// Check PI to PII sash
		if (!SashDiagramModelUtil.isAppropriateModelForSashEditor(diResource)) { // convert
			transactionalconvertPapyrusIDiModelToPapyrusIIDiModel();
		}
	}

	/**
	 * Convert a Papyrus I Di Model to a Papyrus II Di Model. Papyrus II Di Model must contain Sash window model Conversion create such model and initialize it with a TabFolder referencing the PI
	 * Diagrams.
	 * 
	 * @param diagramResource
	 * @return
	 */
	private void convertPapyrusIDiModelToPapyrusIIDiModel() {

		// First, create the sashwindow model
		SashDiagramModelUtil.createSimpleSashWindowsRootModel(diResource);

		// Add each diagram.
		for (Object cur : diResource.getContents()) {
			if (cur instanceof Diagram) {
				Diagram curDiagram = (Diagram) cur;
				String type = curDiagram.getType();
				if (SashDiagramModelUtil.isSashDiagramNode(cur)) {
					// skip. This is the newly created model :-)
				}
				if ("diagram.gmf".equals(type)) { // gmf diagram
				// EObject realDiagram = (EObject)((CoreSemanticModelBridge)curDiagram.getSemanticModel()).getElement();
				// SashDiagramModelUtil.openDiagram(realDiagram);
					SashDiagramModelUtil.openDiagram(diResource, curDiagram);
					// Remove old node.
					// diResource.getContents().remove(curDiagram);
				} else { // PI Diagram
					SashDiagramModelUtil.openDiagram(diResource, curDiagram);
				}
			}
		}

	}

	/**
	 * Transactional version of the method.
	 * 
	 * @param file
	 */
	private void transactionalconvertPapyrusIDiModelToPapyrusIIDiModel() {
		// Check for a transactional domain.
		if (transactionalEditingDomain == null) {
			convertPapyrusIDiModelToPapyrusIIDiModel();
		} else {
			// found : use it.
			RecordingCommand command = new RecordingCommand(getTransactionalEditingDomain()) {

				@Override
				protected void doExecute() {
					convertPapyrusIDiModelToPapyrusIIDiModel();
				}
			};
			getTransactionalEditingDomain().getCommandStack().execute(command);
		}
	}

	/**
	 * Create both files (DI and UML) from a filename.
	 * 
	 * @param newFile
	 *            the file from which path is extracted to create the new files
	 */
	public void createModelResources(IFile newFile) {
		// Get a resource
		diUri = URI.createURI("platform:/resource" + newFile.getFullPath().toString()); // creation of the
		// ressource Di2
		diResource = getResourceSet().createResource(diUri);

		// Add the diagram to the opened diagrams
		SashDiagramModelUtil.createSimpleSashWindowsRootModel(diResource);

		IPath filenameWithoutExtension = newFile.getFullPath().removeFileExtension();
		// Apply UML Standard profile
		// if the uml model is not loaded, create resource
		if (modelResource == null) {
			String name = (newFile.getLocation().removeFileExtension().lastSegment()); // create UML Model
			Model umlModel = createUmlModel(name);

			// add primitive Types
			// create import package to primitiveType
			// PackageImport pi =
			// getModelLibraryImportFromURI(URI.createURI(UMLResource
			// .UML_PRIMITIVE_TYPES_LIBRARY_URI));
			// umlModel.getPackageImports().add(pi);

			// Retrieve standard profile
			Profile umlStdProfile = (Profile) contentload(URI.createURI(UMLResource.STANDARD_PROFILE_URI));
			// Apply to new model
			umlModel.applyProfile(umlStdProfile);

			// umlUri to save the UML2 file
			modelUri = URI.createURI("platform:/resource" + filenameWithoutExtension.addFileExtension(UMLResource.FILE_EXTENSION).toString());

			modelResource = getResourceSet().createResource(modelUri); // creation
			// of
			// the
			// UML
			// resource
			modelResource.getContents().add(umlModel); // add default model
		}

		// Add gmf notation resource
		notationURI = URI.createPlatformResourceURI(filenameWithoutExtension.addFileExtension(notationFileExtension).toString(), true);
		notationResource = getResourceSet().createResource(notationURI);
		try {
			saveResources();
		} catch (Exception e) {
			// Debug.log(e);
		}
	}

	/**
	 * apply the stereotype to the given package.
	 * 
	 * @param modelLibrary
	 *            the package to stereotype
	 */
	private void applyModelLibraryStereotype(Package modelLibrary) {
		// find stereotype "ModelLibrary" in applied profiles
		Iterator it = modelLibrary.getApplicableStereotypes().iterator();
		while (it.hasNext()) {
			Stereotype st = (Stereotype) it.next();
			if (st.getQualifiedName().equalsIgnoreCase("Standard::ModelLibrary")) {
				modelLibrary.applyStereotype(st);
			}
		}
	}

	public void removeLastdefintion(Package thepackage) {

		// he wants to define
		if (thepackage instanceof Profile) {
			EPackage pak = ((Profile) thepackage).getDefinition();
			((EAnnotation) pak.eContainer()).getContents().remove(pak);
		}
		Iterator it = thepackage.getNestedPackages().iterator();
		while (it.hasNext()) {
			Package p = (Package) it.next();
			removeLastdefintion(p);
		}
	}

	/**
	 * Once we have defined all profiles, we have all Ecore classes generated. So we can now redefine inter profiles references in order to reference referenced profiles ecore classes instead of local
	 * ones.
	 * 
	 * @param profile
	 * @deprecated this method is not used see {@link ProfileRedefinition#redefineProfile(Package, PapyrusDefinitionAnnotation)}
	 */
	public void redefineProfile(Profile profile) {
		// get profile definition
		EPackage profileDefinition = profile.getDefinition();

		ArrayList<EClassifier> tempList = new ArrayList<EClassifier>();
		for (int i = 0; i < profileDefinition.getEClassifiers().size(); i++) {
			tempList.add((EClassifier) profileDefinition.getEClassifiers().get(i));
		}

		Iterator<EClassifier> eClassIter = tempList.iterator();
		while (eClassIter.hasNext()) {
			EClassifier currentEClass = eClassIter.next();

			// transform aggregation into simple associations
			if (currentEClass instanceof EClass)
				transformContainment((EClass) currentEClass);

			EAnnotation eClassAnnotation = (EAnnotation) currentEClass.getEAnnotations().get(0);

			// The Eclassifier references a stereotype
			if (eClassAnnotation.getReferences().get(0) instanceof Stereotype) {
				EClassifier distantRef = ((Stereotype) (eClassAnnotation.getReferences().get(0))).getDefinition();
				if (distantRef != null) {

					// case where distant profile reference is regenerated in
					// local profile
					if (!currentEClass.equals(distantRef)) {
						/*
						 * look for all elements in this profile definition referencing currentEClass and change these references to distantRef instead. References to look for are EProperties types
						 * and ESuperTypes of EClasses.
						 */

						Iterator<EClassifier> internIter = tempList.iterator();
						while (internIter.hasNext()) {
							EClassifier currentInternEClass = internIter.next();
							/* look for stereotypes super typed by currentEClass */
							if (currentInternEClass instanceof EClass) {
								/** super types handling **/
								EList eSuperTypes = ((EClass) currentInternEClass).getESuperTypes();

								/* copy in order to avoid concurrent access */
								ArrayList<EClass> tempSuperTypes = new ArrayList<EClass>();
								for (int j = 0; j < eSuperTypes.size(); j++) {
									tempSuperTypes.add((EClass) eSuperTypes.get(j));
								}

								Iterator<EClass> superIter = tempSuperTypes.iterator();
								while (superIter.hasNext()) {
									EClass currentSuper = superIter.next();
									if (currentSuper.equals(currentEClass)) {
										((EClass) profileDefinition.getEClassifier(currentInternEClass.getName())).getESuperTypes().remove(currentSuper);
										((EClass) profileDefinition.getEClassifier(currentInternEClass.getName())).getESuperTypes().add((EClass) distantRef);
									}
								}

								/** property types handling **/
								EList eRefs = ((EClass) currentInternEClass).getEReferences();

								/* copy in order to avoid concurrent access */
								ArrayList<EReference> tempERef = new ArrayList<EReference>();
								for (int k = 0; k < eRefs.size(); k++) {
									tempERef.add((EReference) eRefs.get(k));
								}

								Iterator<EReference> eRefIter = tempERef.iterator();
								while (eRefIter.hasNext()) {
									EReference currentERef = eRefIter.next();
									if (currentERef.getEType() != null) {
										if (currentERef.getEType().equals(currentEClass)) {
											currentERef.setEType(distantRef);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		/** DataTypes handling **/

		/* new copy to explore */
		tempList = new ArrayList<EClassifier>();
		for (int i = 0; i < profileDefinition.getEClassifiers().size(); i++) {
			tempList.add((EClassifier) profileDefinition.getEClassifiers().get(i));
		}

		eClassIter = tempList.iterator();

		while (eClassIter.hasNext()) {
			EClassifier currentEClass = eClassIter.next();
			EAnnotation eClassAnnotation = (EAnnotation) currentEClass.getEAnnotations().get(0);

			/* look for stereotypes */
			if (eClassAnnotation.getReferences().get(0) instanceof Stereotype) {

				/*
				 * look for properties of the stereotype that are typed by a DataType
				 */
				Stereotype umlStereo = (Stereotype) eClassAnnotation.getReferences().get(0);

				Iterator<Property> umlPropIter = umlStereo.getAttributes().iterator();
				while (umlPropIter.hasNext()) {
					Property currentUmlProp = umlPropIter.next();
					Type currentUmlType = currentUmlProp.getType();
					if (currentUmlType instanceof DataType && !(currentUmlType instanceof Enumeration)) {

						if (!(currentUmlType instanceof PrimitiveType) || !(isUMLPrimitiveType(currentUmlType))) {
							/*
							 * find the corresponding definition of this property
							 */
							/* primitivetypes are generated with EAttributes */
							Iterator<EAttribute> eProps = ((EClass) currentEClass).getEAttributes().iterator();

							while (eProps.hasNext()) {
								EAttribute currentEProp = eProps.next();
								if (currentEProp.getName().equals(currentUmlProp.getName())) {

									// removes old dataType definition
									removeOldPrimitiveTypeDef(profileDefinition, currentUmlType);
									// creates new dataType definition
									EDataType dataTypeDef = createDataTypeDefinition(profileDefinition, currentUmlType);

									/* type the EAttribute */
									currentEProp.setEType(dataTypeDef);
								}
							}

							/* datatypes are generated with eReferences */

							ArrayList<EReference> tempRefs = new ArrayList<EReference>();
							for (int i = 0; i < ((EClass) currentEClass).getEReferences().size(); i++) {
								tempRefs.add((EReference) ((EClass) currentEClass).getEReferences().get(i));
							}

							EReference ref = null;
							Iterator<EReference> eRefs = tempRefs.iterator();
							while (eRefs.hasNext()) {
								EReference currentERef = eRefs.next();
								if (currentERef.getName().equals(currentUmlProp.getName())) {

									removeOldDataTypeDef(profileDefinition, currentUmlType);
									EDataType dataTypeDef = createDataTypeDefinition(profileDefinition, currentUmlType);

									/* create a new EAttribute for this property */
									EAttribute newDataTypeProp = EcoreFactory.eINSTANCE.createEAttribute();
									newDataTypeProp.setName(currentUmlProp.getName());

									ref = currentERef;
									/*
									 * remove ERef from stereotype's definition: currentEClass
									 */
									((EClass) currentEClass).getEStructuralFeatures().remove(currentERef);

									/*
									 * type the created EAttribute with dataTypeDef
									 */
									newDataTypeProp.setEType(dataTypeDef);

									/* add the eAttribute to currentEClass */
									((EClass) currentEClass).getEStructuralFeatures().add(newDataTypeProp);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Checks whether type is a UML PrimitiveType or not
	 * 
	 * @param type
	 * @return
	 */
	private Boolean isUMLPrimitiveType(Type type) {
		String typeQName = type.getQualifiedName();
		String umlBoolean = "UMLPrimitiveTypes::Boolean";
		String umlString = "UMLPrimitiveTypes::String";
		String umlInteger = "UMLPrimitiveTypes::Integer";
		String umlUnlimitedNatural = "UMLPrimitiveTypes::UnlimitedNatural";

		if (umlBoolean.equals(typeQName) || umlInteger.equals(typeQName) || umlString.equals(typeQName) || umlUnlimitedNatural.equals(typeQName))
			return true;
		else
			return false;
	}

	private void transformContainment(EClass eClass) {
		ArrayList<EReference> tempRefs = new ArrayList<EReference>();
		for (int i = 0; i < eClass.getEReferences().size(); i++) {
			tempRefs.add(eClass.getEReferences().get(i));
		}

		Iterator<EReference> iter = tempRefs.iterator();
		while (iter.hasNext()) {
			EReference currentERef = iter.next();
			if (currentERef.isContainment()) {
				currentERef.setContainment(false);
			}
		}
	}

	/**
	 * 
	 * @param profileDefinition
	 * @param currentUmlType
	 * @return EDatatype
	 */
	private EDataType createDataTypeDefinition(EPackage profileDefinition, Type currentUmlType) {

		/* if eDataType already exists */
		Iterator<EClassifier> iter = profileDefinition.getEClassifiers().iterator();
		while (iter.hasNext()) {
			EClassifier current = iter.next();
			if (current instanceof EDataType) {
				if (current.getName().equals(currentUmlType.getName()))
					return (EDataType) current;
			}
		}

		/* else */

		EDataType dataTypeDef = EcoreFactory.eINSTANCE.createEDataType();
		dataTypeDef.setName(currentUmlType.getName());
		dataTypeDef.setInstanceClassName("java.lang.String");
		dataTypeDef.setSerializable(true);

		EAnnotation umlAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		umlAnnotation.setSource("http://www.eclipse.org/uml2/2.0.0/UML");
		umlAnnotation.getReferences().add(currentUmlType);

		dataTypeDef.getEAnnotations().add(umlAnnotation);

		profileDefinition.getEClassifiers().add(dataTypeDef);

		return dataTypeDef;
	}

	/**
	 * 
	 * @param profileDefinition
	 * @param currentUmlType
	 * @return
	 */
	private void removeOldDataTypeDef(EPackage profileDefinition, Type currentUmlType) {

		EClassifier eDataType = profileDefinition.getEClassifier(currentUmlType.getName());
		if (eDataType != null && !(eDataType instanceof EDataType))
			profileDefinition.getEClassifiers().remove(eDataType);
	}

	/**
	 * Used to remove a primitive type definition and to replace it by a simple string (see createDataTypeDefinition)
	 * 
	 * @param profileDefinition
	 * @param currentUmlType
	 * @return
	 */
	private void removeOldPrimitiveTypeDef(EPackage profileDefinition, Type currentUmlType) {

		EClassifier eDataType = profileDefinition.getEClassifier(currentUmlType.getName());
		if (eDataType != null) {
			if (eDataType instanceof EDataType) {
				String expectedInstanceName = "java.lang.String";
				EDataType eDT = (EDataType) eDataType;
				String currentInstanceName = eDT.getInstanceClassName();

				// Remove if current instance name does not match expected name
				if (!expectedInstanceName.equals(currentInstanceName)) {
					profileDefinition.getEClassifiers().remove(eDataType);
				}
			}
		}
	}

	/**
	 * Is used to add primitive Type in the model.
	 * 
	 * @param package_
	 *            in which the primitive types will be added
	 */
	protected void importPrimitiveType(org.eclipse.uml2.uml.Package package_) {

		Model uml2Library = (Model) contentload(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));
		List primitiveTypelist = uml2Library.getOwnedTypes();
		Iterator it = primitiveTypelist.iterator();
		while (it.hasNext()) {
			package_.createElementImport((PackageableElement) it.next());
		}
	}

	/**
	 * 
	 * 
	 * @param uri
	 * 
	 * @return
	 */
	protected org.eclipse.uml2.uml.Package contentload(URI uri) {
		org.eclipse.uml2.uml.Package package_ = null;

		try {
			Resource resource = getResourceSet().getResource(uri, true);
			package_ = (org.eclipse.uml2.uml.Package) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.eINSTANCE.getPackage());
		} catch (WrappedException we) {
			// Debug.log(we);
		}

		return package_;
	}

	/**
	 * The resources are already loaded, but we want to save them under another name.
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void saveAs(IPath path) throws IOException {
		IPath nameWithoutExt = path.removeFileExtension();
		IPath modelPath = nameWithoutExt.addFileExtension(modelFileExtension);
		IPath diPath = nameWithoutExt.addFileExtension(diFileExtension);

		// Set model URI
		modelUri = URI.createURI("platform:/resource" + modelPath.toString());
		modelResource.setURI(modelUri);

		// set di uri
		diUri = URI.createURI("platform:/resource" + diPath.toString());
		diResource.setURI(diUri);

		// save model file
		// modelResource.save( Collections.EMPTY_MAP);
		modelResource.save(null);
		// Debug.debug(this, "Model resource saved as '" +modelUri+ "'",
		// channel);
		// save DI2
		// diResource.save(Collections.EMPTY_MAP);
		diResource.save(null);
		// Debug.debug(this, "DI resource saved as '" +diUri+ "'", channel);
	}

	/**
	 * @throws IOException
	 */
	public void saveResources() throws IOException {
		validateFile();
		// save associated resources
		modelResource.save(null);
		diResource.save(null);
		if (notationResource != null)
			notationResource.save(null);
		// Debug.debug(this, "Save done...", channel);
	}

	public void saveResources(IProgressMonitor monitor) throws IOException {
		monitor.beginTask("Saving resources", 3);
		validateFile();
		// save associated resources
		monitor.worked(1);
		modelResource.save(null);
		monitor.worked(1);
		diResource.save(null);
		if (notationResource != null) {
			notationResource.save(null);
		}
		monitor.worked(1);
		// Debug.debug(this, "Save done...", channel);
		monitor.done();
	}

	/**
	 * Force initialization of EmfPackage for stand-alone applications.
	 * 
	 * @param resourceSet
	 */
	private void initStandAlone(ResourceSet resourceSet) {
		// Register the default resource factory -- only needed for
		// stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.Factory.Registry.DEFAULT_EXTENSION, UMLResource.Factory.INSTANCE);
	}

	/**
	 * 
	 * 
	 * @return the diFileExtension
	 */
	public String getDiFileExtension() {
		return diFileExtension;
	}

	/**
	 * 
	 * 
	 * @param diFileExtension
	 *            the diFileExtension to set
	 */
	public void setDiFileExtension(String diFileExtension) {
		this.diFileExtension = diFileExtension;
	}

	/**
	 * 
	 * 
	 * @return the modelFileExtension
	 */
	public String getModelFileExtension() {
		return modelFileExtension;
	}

	/**
	 * 
	 * 
	 * @param modelFileExtension
	 *            the modelFileExtension to set
	 */
	public void setModelFileExtension(String modelFileExtension) {
		this.modelFileExtension = modelFileExtension;
	}

	/**
	 * 
	 * 
	 * @return the diResource
	 */
	public Resource getDiResource() {
		return diResource;
	}

	/**
	 * 
	 * 
	 * @return the modelResource
	 */
	public Resource getUMLModelResource() {
		return modelResource;
	}

	public List<Resource> getAllLoadedUMLRessource() {
		ArrayList<Resource> ressourceList = new ArrayList<Resource>();
		Iterator<Resource> iter = editingDomain.getResourceSet().getResources().iterator();
		while (iter.hasNext()) {
			Resource r = iter.next();
			if (r.getContents().get(0) instanceof Element) {
				ressourceList.add(r);
			}
		}
		return ressourceList;
	}

	/**
	 * 
	 * 
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return editingDomain.getResourceSet();
	}

	/**
	 * Return an iterator on all the diagrams in the model.
	 * 
	 * @return
	 */
	// public Collection<Diagram> getDiagrams()
	// {
	// if (new FilteredCollectionViewFromIterator(diAllContentsProvider,
	// diagramFilter).size() == 0) {
	//
	// // No diagram, create default diagram
	// createClassDiagram(getTopPackageFromUMLResource(), "DefaultDiagram");
	// }
	//
	// return new FilteredCollectionViewFromIterator(diAllContentsProvider,
	// diagramFilter);
	// }
	/**
	 * Inner class allowing access to the contents of the DI resource.
	 * 
	 * @author dumoulin
	 */
	public class DiAllContentsProvider implements FilteredCollectionViewFromIterator.IteratorProvider {

		/**
		 * 
		 * 
		 * @return
		 */
		public Iterator iterator() {
			return diResource.getAllContents();
		}

	}

	/**
	 * inner class.
	 * 
	 * @author dumoulin
	 */
	public static class DiagramFilter implements IFilter {

		/**
		 * 
		 * 
		 * @param object
		 * 
		 * @return
		 */
		public boolean isAllowed(Object object) {
			return object instanceof Diagram;
		}
	}

	/**
	 * Remove the diagram from the model.
	 * 
	 * @param diagram
	 */
	public void removeDiagram(Diagram diagram) {
		// Detach the diagram from its container
		diagram.setContainer(null);
		// Remove from the resource.
		diResource.getContents().remove(diagram);
		// Something else to do ??
	}

	/**
	 * get the root element (of type Model or Profile) of the uml model.
	 * 
	 * @return
	 */
	public Package getTopPackageFromUMLResource() {
		return (Package) getUMLModelResource().getContents().get(0);
	}

	/**
	 * Create a new class diagram at the root of the uml model.
	 * 
	 * @return
	 */
	public Diagram createClassDiagram() {
		return createClassDiagram(getTopPackageFromUMLResource());
	}

	/**
	 * Create a new class diagram.
	 * 
	 * @param umlOwner
	 * @param owner
	 *            The future parent of the created diagram.
	 * @return
	 */
	public Diagram createClassDiagram(Element umlOwner) {
		// create diagram
		Diagram diagram = DiFactory.eINSTANCE.createDiagram();
		diagram.setIsVisible(true);
		// create associated node
		Uml1SemanticModelBridge semantic = DiFactory.eINSTANCE.createUml1SemanticModelBridge();
		semantic.setElement(umlOwner);

		diagram.setOwner(semantic);

		// Add it to resource, so that it will be saved.
		diResource.getContents().add(diagram);

		return diagram;
	}

	/**
	 * Create a new class diagram. Use getUmlModel() to create it in the uml root.
	 * 
	 * @param umlOwner
	 * @param owner
	 *            The future parent of the created diagram.
	 * @param name
	 * 
	 * @return
	 */
	// public Diagram createClassDiagram(Element umlOwner, String name) {
	// // create diagram
	// Diagram diagram = Di2Factory.eINSTANCE.createDiagram();
	// diagram.setIsVisible(true);
	// // create associated node
	// Uml1SemanticModelBridge semantic =
	// Di2Factory.eINSTANCE.createUml1SemanticModelBridge();
	// semantic.setElement(umlOwner);
	//
	// diagram.setPosition(new Point(0, 0));
	// diagram.setFontFamily("Arial");
	// diagram.setBackgroundColor(new RGB(255, 255, 255));// white
	// diagram.setBorderColor(new RGB(255, 255, 255));// white
	// diagram.setFontColor(new RGB(255, 255, 255));// white
	// diagram.setFontSize(10);
	// diagram.setLineStyle("solid");
	// diagram.setLineThickness(1);
	// diagram.setForegroundColor(new RGB(255, 255, 255));// white
	//
	// diagram.setName(name);
	// diagram.setOwner(semantic);
	//
	// // Add it to resource, so that it will be saved.
	// diResource.getContents().add(diagram);
	//
	// return diagram;
	// }
	/**
	 * Create a uml mode in the uml ressource.
	 * 
	 * @param name
	 *            of the model
	 * 
	 * @return the created model
	 */
	public Model createUmlModel(String name) {

		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(name);

		return model;
	}

	/**
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 */
	public Profile createProfile(String name) {

		Profile model = UMLFactory.eINSTANCE.createProfile();
		model.setName(name);

		return model;
	}

	/**
	 * Crfeates a package, with the given name.
	 * 
	 * @param name
	 *            the name of the new package to create
	 * 
	 * @return the newly created package
	 */
	public Package createModelLibrary(String name) {

		Package package_ = UMLFactory.eINSTANCE.createPackage();
		package_.setName(name);

		return package_;
	}

	/**
	 * @return the adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * this class is used to validate files
	 */
	public boolean validateFile() {// validate all diagrams
		// validate uml file
		// boolean
		// b=Validation.validate(getTopPackageFromUMLResource(),adapterFactory);
		//
		// //validate diagrams
		// Object[] diagramArray=getDiagrams().toArray();
		// int index=0;
		// while(index<diagramArray.length){
		//
		// b=b&&Validation.validate((EObject)diagramArray[index],adapterFactory);
		// index++;
		// }
		// return b;
		return true;
	}

	/**
	 * Returns the collection of visible diagrams for this model
	 * 
	 * @return the collection of visible diagrams for this model
	 */
	public List<Diagram> getVisibleDiagrams() {
		List<Diagram> visibleDiagrams = new ArrayList<Diagram>();

		List<Diagram> allDiagrams = getDiagrams();
		Iterator<Diagram> it = allDiagrams.iterator();
		while (it.hasNext()) {
			Diagram diagram = it.next();
			if (diagram.isIsVisible()) {
				visibleDiagrams.add(diagram);
			}
		}

		if (visibleDiagrams.isEmpty()) {
			if (getDiagrams().size() > 0) {
				visibleDiagrams.add(allDiagrams.get(0));
			}
		}
		return visibleDiagrams;
	}

	/**
	 * Returns all diagrams in the model
	 * 
	 * @return all diagrams in the model
	 */
	public List<Diagram> getDiagrams() {
		final List<Diagram> diagrams = new ArrayList<Diagram>();

		Iterator<EObject> it = getDiResource().getAllContents();
		while (it.hasNext()) {
			new DiSwitch<Diagram>() {

				/*
				 * (non-Javadoc)
				 * 
				 * @seecom.cea.papyrus.diagraminterchange2.di2.util.Di2Switch# caseDiagram(com.cea.papyrus.diagraminterchange2.di2.Diagram)
				 */
				@Override
				public Diagram caseDiagram(Diagram object) {
					diagrams.add(object);
					return object;
				}
			}.doSwitch(it.next());
		}

		return diagrams;
	}

	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @return the notationResource
	 */
	public Resource getNotationResource() {
		return notationResource;
	}

	/**
	 * @return the transactionalEditingDomain
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return transactionalEditingDomain;
	}

	/**
	 * Transactional version of the method.
	 * 
	 * @param file
	 */
	public void transactionalCreateModelResources(final IFile file) {
		// Check for a transactional domain.
		if (transactionalEditingDomain == null) {
			createModelResources(file);
		} else {
			// found : use it.
			RecordingCommand command = new RecordingCommand(getTransactionalEditingDomain()) {

				@Override
				protected void doExecute() {
					createModelResources(file);
				}
			};
			getTransactionalEditingDomain().getCommandStack().execute(command);
		}
	}

}
