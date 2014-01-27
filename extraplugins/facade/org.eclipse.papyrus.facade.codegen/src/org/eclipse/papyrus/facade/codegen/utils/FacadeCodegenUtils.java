/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.codegen.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.facade.codegen.FacadeCodeGenPlugin;
import org.eclipse.papyrus.facade.codegen.Messages;
import org.eclipse.papyrus.facade.utils.CombinationGenerator;
import org.eclipse.papyrus.facademapping.ExtensionDefinitionKind;
import org.eclipse.papyrus.facademapping.FacadeMappping;
import org.eclipse.papyrus.facademapping.Mapping;
import org.eclipse.papyrus.facademapping.StereotypedMapping;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The utils class used to generate facade code.
 */
public class FacadeCodegenUtils {

	/** The path to the UML GenModel. */
	protected final static String UML_GEN_MODEL = "platform:/plugin/org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$

	/** A cache of all mappings */
	protected static HashMap<GenModel, List<Mapping>> allMappingsCache = new HashMap<GenModel, List<Mapping>>();

	/** A cache of stereotyped mappings. */
	protected static HashMap<GenModel, List<StereotypedMapping>> stereotypedMappingsCache = new HashMap<GenModel, List<StereotypedMapping>>();

	/** A cache of enum literal mappings. */
	protected static HashMap<GenModel, List<Mapping>> enumLiteralMappingsCache = new HashMap<GenModel, List<Mapping>>();

	/** A cache of feature mappings. */
	protected static HashMap<GenModel, List<Mapping>> featureMappingsCache = new HashMap<GenModel, List<Mapping>>();

	/** A cache of all metaclass mappings. */
	protected static HashMap<GenModel, List<Mapping>> allMetaclassMappingsCache = new HashMap<GenModel, List<Mapping>>();

	private static Set<String> javaDefaultTypes = null;

	private static Set<String> ecoreDefaultTypes;


	/**
	 * Find the mapping model from a genModel. Basically, the mapping model must be in the same folder as the ecoremodel underlying the GenModel and
	 * named with the same filename but the file extension.
	 * 
	 * @param genModel
	 *        the GenModel that will be used to try to find the mapping model
	 * @return the string
	 */
	public static String findMappingModel(GenModel genModel) {

		if(!genModel.getForeignModel().isEmpty()) {
			String metamodel = genModel.getForeignModel().get(0);
			metamodel = metamodel.replaceAll(".ecore", ".facademapping"); //$NON-NLS-1$ //$NON-NLS-2$

			URI ecoreURI = genModel.eResource().getURI();
			ecoreURI = ecoreURI.trimSegments(1);
			ecoreURI = ecoreURI.appendSegment(metamodel);

			return ecoreURI.toString();
		}
		return null;

	}

	/**
	 * Gets the UML element of a mapping.
	 * 
	 * @param mapping
	 *        the mapping to find the UML element for
	 * @return the UML element mapped in the mapping
	 */
	protected static EObject getUMLElement(Mapping mapping) {

		if(mapping instanceof StereotypedMapping) {
			if(((StereotypedMapping)mapping).getKind() == ExtensionDefinitionKind.ASSOCIATION) {
				EList<EObject> appliedStereotypes = ((StereotypedMapping)mapping).getAppliedStereotypes();
				if(appliedStereotypes.size() != 1) {
					return null;
				} else {
					return appliedStereotypes.get(0);
				}
			} else {
				return mapping.getUmlElement();
			}
		} else {
			return mapping.getUmlElement();
		}

	}

	/**
	 * Gets the all the mappings based on a GenModel of a facade
	 * 
	 * @param facadeGenModel
	 *        the GenModel of a facade
	 * @return all the mappings corresponding to a facade GenModel
	 */
	protected static synchronized List<Mapping> getAllMappings(GenModel facadeGenModel) {

		if(!allMappingsCache.containsKey(facadeGenModel)) {

			List<Mapping> allMappings = new ArrayList<Mapping>();

			String mappingModel = findMappingModel(facadeGenModel);
			if(mappingModel != null) {
				if(facadeGenModel.eResource() != null) {
					if(facadeGenModel.eResource().getResourceSet() != null) {
						ResourceSet resourceSet = facadeGenModel.eResource().getResourceSet();
						Resource res = resourceSet.getResource(URI.createURI(mappingModel, true), true);
						if(res != null) {
							if(!res.getContents().isEmpty()) {
								EObject root = res.getContents().get(0);

								if(root instanceof FacadeMappping) {
									FacadeMappping facadeMappping = (FacadeMappping)root;

									for(Mapping mapping : facadeMappping.getMappings()) {
										allMappings.add(mapping);
									}
								}
							}
						}
					}
				}
			}

			allMappingsCache.put(facadeGenModel, allMappings);
		}

		return allMappingsCache.get(facadeGenModel);

	}

	/**
	 * Get the stereotype qualifiedNames that are applied on the UML element represented by the facadeMetaElement
	 * 
	 * @param facadeMetaElement
	 *        the facade metaelement
	 * @param facadeGenModel
	 *        the facade GenModel
	 * @return the stereotype qualifiedNames
	 */
	public static String getAllStereotypeQualifiedNames(EObject facadeMetaElement, GenModel facadeGenModel) {

		Set<String> result = new HashSet<String>();


		for(Mapping mapping : getAllMappings(facadeGenModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), facadeMetaElement)) {
				if(mapping instanceof StereotypedMapping) {

					for(EObject stereotype : ((StereotypedMapping)mapping).getAppliedStereotypes()) {
						if(stereotype instanceof Stereotype) {
							result.add("\"" + ((Stereotype)stereotype).getQualifiedName() + "\""); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
			}
		}

		if(!result.isEmpty()) {
			StringBuilder sb = new StringBuilder();

			for(String s : result) {
				sb.append(s).append(',');
			}

			sb.deleteCharAt(sb.length() - 1); //delete last comma

			return sb.toString();
		}

		return ""; //$NON-NLS-1$
	}

	/**
	 * Get the stereotype qualifiedNames that are applied on the UML element represented by the facadeMetaElement but that are not association kind of
	 * mapping
	 * 
	 * @param facadeMetaElement
	 *        the facade metaelement
	 * @param facadeGenModel
	 *        the facade GenModel
	 * @return the stereotype qualifiedNames
	 */
	public static String getNonAssociationStereotypeQualifiedNames(EObject facadeMetaElement, GenModel facadeGenModel) {

		Set<String> result = new HashSet<String>();


		for(Mapping mapping : getAllMappings(facadeGenModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), facadeMetaElement)) {
				if(mapping instanceof StereotypedMapping) {

					if(((StereotypedMapping)mapping).getKind() != ExtensionDefinitionKind.ASSOCIATION) {
						for(EObject stereotype : ((StereotypedMapping)mapping).getAppliedStereotypes()) {
							if(stereotype instanceof Stereotype) {
								result.add("\"" + ((Stereotype)stereotype).getQualifiedName() + "\""); //$NON-NLS-1$ //$NON-NLS-2$
							}
						}
					}
				}
			}
		}

		if(!result.isEmpty()) {
			StringBuilder sb = new StringBuilder();

			for(String s : result) {
				sb.append(s).append(',');
			}

			sb.deleteCharAt(sb.length() - 1); //delete last comma

			return sb.toString();
		}

		return ""; //$NON-NLS-1$
	}

	/**
	 * Find UML getAccessor.
	 * 
	 * @param facadeMetaFeature
	 *        the facade metafeature
	 * @param facadeGenModel
	 *        the facade GenModel
	 * @return the getAccessor
	 */
	public static String findUMLGetAccessor(EObject facadeMetaFeature, GenModel facadeGenModel) {

		EObject umlMetaElement = findUMLMetaElement(facadeMetaFeature, facadeGenModel);

		if(umlMetaElement != null) {
			if(umlMetaElement instanceof ETypedElement) {
				ResourceSet resourceSet = new ResourceSetImpl();
				EObject umlGenModel = resourceSet.getResource(URI.createURI(UML_GEN_MODEL, true), true).getContents().get(0);

				if(umlGenModel != null) {
					if(umlGenModel instanceof org.eclipse.uml2.codegen.ecore.genmodel.GenModel) {

						if(umlMetaElement instanceof EStructuralFeature) {
							return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)umlGenModel).findGenFeature((EStructuralFeature)umlMetaElement).getGetAccessor();
						} else if(umlMetaElement instanceof EOperation) {
							return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)umlGenModel).findGenOperation((EOperation)umlMetaElement).getName();
						}
					}
				}
			} else if(umlMetaElement instanceof Property) {
				if(umlMetaElement.eResource() != null) {
					if(!umlMetaElement.eResource().getContents().isEmpty()) {
						EObject root = umlMetaElement.eResource().getContents().get(0);
						if(root instanceof Profile) {

							GenModel profileGen = getGenModel(umlMetaElement);
							EObject umlMetaFeatureDefinition = ((Profile)root).getDefinition((NamedElement)umlMetaElement);
							if(umlMetaFeatureDefinition instanceof EStructuralFeature) {
								return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)profileGen).findGenFeature((EStructuralFeature)umlMetaFeatureDefinition).getGetAccessor();
							}
						}
					}
				}
			}
		}

		return "FAILED_TO_FIND_MAPPED_GET_ACCESSOR"; //$NON-NLS-1$
	}

	/**
	 * Try to get the GenModel from an eObject
	 * 
	 * @param metaElement
	 *        the metaElement to find the GenMdoel for
	 * @return the GenModel
	 */
	protected static GenModel getGenModel(EObject metaElement) {
		Map<String, URI> nsURIToGenModelsMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap(true);



		if(metaElement.eResource() != null) {
			if(!metaElement.eResource().getContents().isEmpty()) {
				EObject root = metaElement.eResource().getContents().get(0);
				if(root instanceof Profile) {
					Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage"); //$NON-NLS-1$
					if(ePackageStereotype != null) {
						Object nsURI = ((Profile)root).getValue(ePackageStereotype, "nsURI"); //$NON-NLS-1$
						if(nsURI instanceof String) {
							URI genModelURI = nsURIToGenModelsMap.get(nsURI);
							String paltformstring = genModelURI.toPlatformString(true);
							URI pluginURI = URI.createPlatformPluginURI(paltformstring, true);
							if(pluginURI != null) {
								ResourceSet resourceSet = new ResourceSetImpl();
								EObject genModel = resourceSet.getResource(pluginURI, true).getContents().get(0);
								if(genModel instanceof GenModel) {
									return (GenModel)genModel;
								}
							}
						}
					}

				}
			}
		}

		return null;
	}

	/**
	 * Find UML accessorName of a facade metaFeature.
	 * 
	 * @param facadeMetaFeature
	 *        the facade metafeature
	 * @param facadeGenModel
	 *        the facade GenModel
	 * @return the string
	 */
	public static String findUMLAccessorName(EObject facadeMetaFeature, GenModel facadeGenModel) {
		EObject umlMetaFeature = findUMLMetaElement(facadeMetaFeature, facadeGenModel);

		if(umlMetaFeature instanceof NamedElement) {

			if(umlMetaFeature.eResource() != null) {
				if(!umlMetaFeature.eResource().getContents().isEmpty()) {
					EObject root = umlMetaFeature.eResource().getContents().get(0);
					if(root instanceof Profile) {

						GenModel profileGen = getGenModel(umlMetaFeature);
						EObject umlMetaFeatureDefinition = ((Profile)root).getDefinition((NamedElement)umlMetaFeature);
						if(umlMetaFeatureDefinition instanceof EStructuralFeature) {
							return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)profileGen).findGenFeature((EStructuralFeature)umlMetaFeatureDefinition).getAccessorName();
						}

					}
				}
			}
		} else {

			if(umlMetaFeature != null) {
				if(umlMetaFeature instanceof EStructuralFeature) {
					ResourceSet resourceSet = new ResourceSetImpl();
					EObject umlGenModel = resourceSet.getResource(URI.createURI(UML_GEN_MODEL, true), true).getContents().get(0);

					if(umlGenModel != null) {
						if(umlGenModel instanceof org.eclipse.uml2.codegen.ecore.genmodel.GenModel) {

							return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)umlGenModel).findGenFeature((EStructuralFeature)umlMetaFeature).getAccessorName();
						}
					}
				}
			}
		}

		return "FAILED_TO_FIND_MAPPED_GET_ACCESSOR_NAME"; //$NON-NLS-1$
	}

	/**
	 * Gets all the metaclass mappings.
	 * 
	 * @param facadeGenModel
	 *        the facade GenModel
	 * @return all mappings that map a metaclass
	 */
	public static synchronized List<? extends Mapping> getAllMetaclassMappings(GenModel facadeGenModel) {

		if(!allMetaclassMappingsCache.containsKey(facadeGenModel)) {

			List<Mapping> allMetaclassMappings = new ArrayList<Mapping>();

			for(Mapping mapping : getAllMappings(facadeGenModel)) {
				if(!(mapping instanceof StereotypedMapping)) {
					if(mapping.getSpecificDomainElement() instanceof EClassifier) {
						if(mapping.getUmlElement() != TypesPackage.eINSTANCE.getBoolean() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getString() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getReal() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getInteger() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getUnlimitedNatural()) {
							if(!(mapping.getUmlElement() instanceof Stereotype)) {
								if(mapping.getSpecificDomainElement() instanceof EClass) {
									if(!((EClass)mapping.getSpecificDomainElement()).isAbstract()) {
										allMetaclassMappings.add(mapping);
									}
								} else {
									allMetaclassMappings.add(mapping);
								}
							}
						}
					}
				} else {
					if(((StereotypedMapping)mapping).getKind() == ExtensionDefinitionKind.ASSOCIATION) {
						allMetaclassMappings.add(mapping);
					}
				}
			}

			allMetaclassMappingsCache.put(facadeGenModel, allMetaclassMappings);
		}

		return allMetaclassMappingsCache.get(facadeGenModel);
	}

	/**
	 * Initializes caches
	 */
	public static void initUtilsCaches() {
		allMappingsCache.clear();
		allMetaclassMappingsCache.clear();
		enumLiteralMappingsCache.clear();
		featureMappingsCache.clear();
		stereotypedMappingsCache.clear();
	}

	/**
	 * Gets all the enumLiteral mappings.
	 * 
	 * @param facadeGenModel
	 *        the facade GenModel
	 * @return all mappings that map an enumLiteral
	 */
	public static synchronized List<? extends Mapping> getAllEnumLiteralMappings(GenModel facadeGenModel) {

		if(!enumLiteralMappingsCache.containsKey(facadeGenModel)) {
			List<Mapping> enumLiteralMappings = new ArrayList<Mapping>();
			synchronized(enumLiteralMappings) {

				for(Mapping mapping : getAllMappings(facadeGenModel)) {
					if(mapping.getSpecificDomainElement() instanceof EEnumLiteral) {
						if(mapping.getUmlElement() != TypesPackage.eINSTANCE.getBoolean() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getString() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getReal() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getInteger() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getUnlimitedNatural()) {
							enumLiteralMappings.add(mapping);
						}
					}
				}
			}
			enumLiteralMappingsCache.put(facadeGenModel, enumLiteralMappings);
		}
		return enumLiteralMappingsCache.get(facadeGenModel);

	}

	/**
	 * Gets all the feature mappings.
	 * 
	 * @param facadeGenModel
	 *        the facade GenModel
	 * @return all mappings that map a feature
	 */
	public static synchronized List<? extends Mapping> getAllFeatureMappings(GenModel facadeGenModel) {

		if(!featureMappingsCache.containsKey(facadeGenModel)) {

			List<Mapping> featureMappings = new ArrayList<Mapping>();

			for(Mapping mapping : getAllMappings(facadeGenModel)) {
				if(!isExtensionStereotypePropertyFromFacade(mapping.getSpecificDomainElement(), facadeGenModel)) {
					if(mapping.getSpecificDomainElement() instanceof EStructuralFeature) {

						featureMappings.add(mapping);
					}
					if(mapping.getSpecificDomainElement() instanceof Property) {

						if(((Property)mapping.getSpecificDomainElement()).getClass_() instanceof Stereotype) {
							featureMappings.add(mapping);
						}
					}
				}
			}
			featureMappingsCache.put(facadeGenModel, featureMappings);
		}

		return featureMappingsCache.get(facadeGenModel);

	}

	/**
	 * Find UML metaElement.
	 * 
	 * @param facadeMetaElement
	 *        the facade metaElement
	 * @param genModel
	 *        the GenModel
	 * @return the UML metaElement
	 */
	public static EObject findUMLMetaElement(EObject facadeMetaElement, GenModel genModel) {
		String mappingModel = findMappingModel(genModel);
		if(mappingModel != null) {

			if(genModel.eResource() != null) {
				if(genModel.eResource().getResourceSet() != null) {
					ResourceSet resourceSet = genModel.eResource().getResourceSet();
					EObject root = resourceSet.getResource(URI.createURI(mappingModel, true), true).getContents().get(0);

					if(root != null) {
						if(root instanceof FacadeMappping) {
							FacadeMappping facadeMappping = (FacadeMappping)root;
							for(Mapping mapping : facadeMappping.getMappings()) {
								if(EcoreUtil.equals(mapping.getSpecificDomainElement(), facadeMetaElement)) {

									return getUMLElement(mapping);


								}
							}
						}
					}
				}
			}



		}

		return null;
	}

	/**
	 * Gets the FeatureAccessorName of a the UML feature from a mapping.
	 * 
	 * @param mapping
	 *        the mapping
	 * @param genModel
	 *        the GenModel
	 * @return the UML feature from mapping
	 */
	public static String getUMLFeatureFromMapping(Mapping mapping, GenModel genModel) {
		EObject UMLMetaElement = mapping.getUmlElement();

		if(UMLMetaElement instanceof NamedElement) {

			if(UMLMetaElement.eResource() != null) {
				if(!UMLMetaElement.eResource().getContents().isEmpty()) {
					EObject root = UMLMetaElement.eResource().getContents().get(0);
					if(root instanceof Profile) {

						GenModel profileGen = getGenModel(UMLMetaElement);
						EObject umlMetaFeatureDefinition = ((Profile)root).getDefinition((NamedElement)UMLMetaElement);
						if(umlMetaFeatureDefinition instanceof EStructuralFeature) {
							return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)profileGen).findGenFeature((EStructuralFeature)umlMetaFeatureDefinition).getFeatureAccessorName();
						}

					}
				}
			}


		} else {

			if(UMLMetaElement instanceof EStructuralFeature) {
				if(UMLMetaElement != null) {
					ResourceSet resourceSet = new ResourceSetImpl();
					EObject umlGenModel = resourceSet.getResource(URI.createURI(UML_GEN_MODEL, true), true).getContents().get(0);

					if(umlGenModel != null) {
						if(umlGenModel instanceof org.eclipse.uml2.codegen.ecore.genmodel.GenModel) {

							return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)umlGenModel).findGenFeature((EStructuralFeature)UMLMetaElement).getFeatureAccessorName();
						}
					}
				}
			}
		}

		return "FAILED_TO_FIND_MAPPED_UML_FEATURE"; //$NON-NLS-1$
	}


	/**
	 * Gets the package path from mapping.
	 * 
	 * @param mapping
	 *        the mapping
	 * @return the package path from mapping
	 */
	public static String getPackagePathFromMapping(Mapping mapping) {
		EObject UMLMetaElement = getUMLElement(mapping);

		return getPackagePathFromUML(UMLMetaElement);
	}

	/**
	 * Gets the EPackage path from UML element mapped by a mapping.
	 * 
	 * @param UMLMetaElement
	 *        the UML metaElement
	 * @return the EPackage path from UML
	 */
	public static String getPackagePathFromUML(EObject UMLMetaElement) {

		EObject root = UMLMetaElement.eResource().getContents().get(0);
		if(root instanceof Profile) {
			Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage"); //$NON-NLS-1$
			if(ePackageStereotype != null) {
				Object packageName = ((Profile)root).getValue(ePackageStereotype, "packageName"); //$NON-NLS-1$
				Object basePackage = ((Profile)root).getValue(ePackageStereotype, "basePackage"); //$NON-NLS-1$
				if(packageName instanceof String && basePackage instanceof String) {
					if(UMLMetaElement instanceof NamedElement) {
						return basePackage + "." + packageName; //$NON-NLS-1$
					}
				}
			}

		} else {

			return "org.eclipse.uml2.uml"; //$NON-NLS-1$

		}

		return "FAILED_TO_FIND_MAPPED_UML_PACKAGE_PATH"; //$NON-NLS-1$
	}

	/**
	 * Gets the full EPackage path from a mapping.
	 * 
	 * @param mapping
	 *        the mapping
	 * @return the Epackage path
	 */
	public static String getUMLPackageName(Mapping mapping) {

		EObject UMLMetaElement = getUMLElement(mapping);

		EObject root = UMLMetaElement.eResource().getContents().get(0);
		if(root instanceof Profile) {
			Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage"); //$NON-NLS-1$
			if(ePackageStereotype != null) {
				Object packageName = ((Profile)root).getValue(ePackageStereotype, "packageName"); //$NON-NLS-1$
				if(packageName instanceof String) {
					if(UMLMetaElement instanceof NamedElement) {
						return getPackagePathFromMapping(mapping) + "." + packageName + "Package"; //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
			}

		} else {

			return getPackagePathFromMapping(mapping) + ".UMLPackage"; //$NON-NLS-1$

		}

		return "FAILED_TO_FIND_MAPPED_UML_PACKAGE_NAME"; //$NON-NLS-1$
	}


	/**
	 * Gets the UML accessorName from a mapping.
	 * 
	 * @param mapping
	 *        the mapping
	 * @param genModel
	 *        the GenModel
	 * @return the UML accessorName
	 */
	public static String getUMLAccessorName(Mapping mapping, GenModel genModel) {

		EObject UMLMetaElement = getUMLElement(mapping);

		EObject root = UMLMetaElement.eResource().getContents().get(0);
		if(root instanceof Profile) {

			if(UMLMetaElement instanceof NamedElement) {
				return ((NamedElement)UMLMetaElement).getName();
			}

		} else {

			if(UMLMetaElement instanceof EClassifier) {

				ResourceSet resourceSet = new ResourceSetImpl();
				EObject umlGenModel = resourceSet.getResource(URI.createURI(UML_GEN_MODEL, true), true).getContents().get(0);

				if(umlGenModel != null) {
					if(umlGenModel instanceof org.eclipse.uml2.codegen.ecore.genmodel.GenModel) {

						return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)umlGenModel).findGenClassifier((EClassifier)UMLMetaElement).getClassifierAccessorName();
					}
				}

			}
		}

		return "FAILED_TO_FIND_MAPPED_UML_ACCESSOR_NAME"; //$NON-NLS-1$
	}

	/**
	 * Gets the ClassifierAccessorName from a mapping.
	 * 
	 * @param genModel
	 *        the GenModel
	 * @param mapping
	 *        the mapping
	 * @return the ClassifierAccessorName
	 */
	public static String getClassifierAccessorName(GenModel genModel, Mapping mapping) {
		return genModel.findGenClassifier((EClassifier)mapping.getSpecificDomainElement()).getClassifierAccessorName();
	}

	/**
	 * Gets the FeatureAccessorName from a mapping.
	 * 
	 * @param genModel
	 *        the GenModel
	 * @param mapping
	 *        the mapping
	 * @return the FeatureAccessorName
	 */
	public static String getFeatureAccessorName(GenModel genModel, Mapping mapping) {
		return genModel.findGenFeature((EStructuralFeature)mapping.getSpecificDomainElement()).getFeatureAccessorName();
	}

	/**
	 * Gets the UML meta element mapped to a facadeElement.
	 * 
	 * @param facadeMetaElement
	 *        the facade meta element
	 * @param genModel
	 *        the GenModel
	 * @return the UML meta element
	 */
	public static String getUMLMetaElement(EObject facadeMetaElement, GenModel genModel) {

		for(Mapping mapping : getAllMappings(genModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), facadeMetaElement)) {
				EObject UMLMetaElement = getUMLElement(mapping);

				if(UMLMetaElement instanceof ENamedElement) {
					return ((ENamedElement)UMLMetaElement).getName();
				} else if(UMLMetaElement instanceof NamedElement) {
					return ((NamedElement)UMLMetaElement).getName();
				}

			}
		}


		return "FAILED_TO_FIND_MAPPED_UML_METACLASS"; //$NON-NLS-1$
	}

	/**
	 * Gets the UML factory.
	 * 
	 * @param facadeMetaElement
	 *        the facade meta element
	 * @param genModel
	 *        the GenModel
	 * @return the UML factory
	 */
	public static String getUMLFactory(EObject facadeMetaElement, GenModel genModel) {

		for(Mapping mapping : getAllMappings(genModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), facadeMetaElement)) {

				EObject UMLMetaElement = getUMLElement(mapping);

				if(UMLMetaElement != null) {
					EObject root = UMLMetaElement.eResource().getContents().get(0);
					if(root instanceof Profile) {
						Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage"); //$NON-NLS-1$
						if(ePackageStereotype != null) {
							Object packageName = ((Profile)root).getValue(ePackageStereotype, "packageName"); //$NON-NLS-1$
							if(packageName instanceof String) {
								if(UMLMetaElement instanceof NamedElement) {
									return getPackagePathFromUML(UMLMetaElement) + "." + packageName + "Factory"; //$NON-NLS-1$ //$NON-NLS-2$
								}
							}
						}
					} else {
						return getPackagePathFromUML(UMLMetaElement) + ".UMLFactory"; //$NON-NLS-1$
					}
				}

			}
		}




		return "FAILED_TO_FIND_MAPPED_UML_FACTORY"; //$NON-NLS-1$
	}

	/**
	 * Gets the appropriate qualified type name.
	 * 
	 * @param genClassifier
	 *        a genClassifier
	 * @return the qualifiedType name
	 */
	public static String getAppropriateQualifiedTypeName(GenClassifier genClassifier) {
		if(genClassifier instanceof GenClass) {

			return ((GenClass)genClassifier).getQualifiedInterfaceName();

		} else if(genClassifier instanceof GenDataType) {

			return ((GenDataType)genClassifier).getQualifiedInstanceClassName();

		} else {

			return "FAILED_TO_FIND_QUALIFIED_TYPE_NAME"; //$NON-NLS-1$
		}
	}

	/**
	 * Gets the UML enum element from mapping.
	 * 
	 * @param mapping
	 *        the mapping
	 * @return the UML enum element from mapping
	 */
	public static String getUMLEnumElementFromMapping(Mapping mapping) {
		if(mapping.getUmlElement() instanceof EEnumLiteral) {
			return ((EEnumLiteral)mapping.getUmlElement()).getEEnum().getName() + ".get(" + ((EEnumLiteral)mapping.getUmlElement()).getValue() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		} else if(mapping.getUmlElement() instanceof EnumerationLiteral) {
			return ((EnumerationLiteral)mapping.getUmlElement()).getEnumeration().getName() + ".get(\"" + ((EnumerationLiteral)mapping.getUmlElement()).getName() + "\")"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		return "FAILED_TO_FIND_MAPPED_UML_ENUM_ELEMENT"; //$NON-NLS-1$
	}

	/**
	 * Gets the facade enum element from mapping.
	 * 
	 * @param mapping
	 *        the mapping
	 * @return the facade enum element from the mapping
	 */
	public static String getFacadeEnumElementFromMapping(Mapping mapping) {
		if(mapping.getUmlElement() instanceof EEnumLiteral) {
			return ((EEnumLiteral)mapping.getUmlElement()).getEEnum().getName() + ".get(" + ((EEnumLiteral)mapping.getUmlElement()).getValue() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		} else if(mapping.getUmlElement() instanceof EnumerationLiteral) {
			return ((EnumerationLiteral)mapping.getUmlElement()).getEnumeration().getName() + ".get(\"" + ((EnumerationLiteral)mapping.getUmlElement()).getName() + "\")"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		return "FAILED_TO_FIND_MAPPED_FACADE_ENUM_ELEMENT"; //$NON-NLS-1$
	}

	/**
	 * Checks if facade element represents a stereotype role for an extension
	 * 
	 * @param facadeElement
	 *        the facade element
	 * @param genModel
	 *        the GenModel
	 * @return true, if facade element represents a stereotype role for an extension
	 */
	protected static boolean isExtensionStereotypePropertyFromFacade(EObject facadeElement, GenModel genModel) {
		EObject umlElement = findUMLMetaElement(facadeElement, genModel);

		if(umlElement instanceof Property) {
			if(((Property)umlElement).getAssociation() instanceof Extension) {
				if(((Property)umlElement).getName().startsWith(Extension.STEREOTYPE_ROLE_PREFIX)) {
					return Boolean.TRUE;
				}

			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Checks if is extention stereotype property.
	 * 
	 * @param genFeature
	 *        the gen feature
	 * @return true, if is extention stereotype property
	 */
	public static boolean isExtentionStereotypeProperty(GenFeature genFeature) {


		EObject umlElement = findUMLMetaElement(genFeature.getEcoreFeature(), genFeature.getGenModel());

		if(umlElement instanceof Property) {
			if(((Property)umlElement).getAssociation() instanceof Extension) {
				if(((Property)umlElement).getName().startsWith(Extension.STEREOTYPE_ROLE_PREFIX)) {
					return Boolean.TRUE;
				}

			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Checks if is extension property.
	 * 
	 * @param genFeature
	 *        the gen feature
	 * @return true, if is extension property
	 */
	public static boolean isExtensionProperty(GenFeature genFeature) {
		EObject umlElement = findUMLMetaElement(genFeature.getEcoreFeature(), genFeature.getGenModel());

		if(umlElement instanceof Property) {
			if(((Property)umlElement).getAssociation() instanceof Extension) {

				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Checks if is stereotype property.
	 * 
	 * @param genFeature
	 *        the gen feature
	 * @return true, if is stereotype property
	 */
	public static boolean isStereotypeProperty(GenFeature genFeature) {
		EClass ecoreClass = genFeature.getGenClass().getEcoreClass();

		boolean isAppropriateMapping = false;
		for(Mapping mapping : getAllMappings(genFeature.getGenModel())) {
			if(EcoreUtil.equals(ecoreClass, mapping.getSpecificDomainElement())) {
				if(mapping instanceof StereotypedMapping) {
					if(((StereotypedMapping)mapping).getKind() != ExtensionDefinitionKind.ASSOCIATION) {
						isAppropriateMapping = true;
					}
				}
			}
		}

		if(isAppropriateMapping) {
			EObject umlElement = findUMLMetaElement(genFeature.getEcoreFeature(), genFeature.getGenModel());

			if(umlElement instanceof Property) {
				if(((Property)umlElement).getClass_() instanceof Stereotype) {
					if(!isExtensionProperty(genFeature)) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Gets the stereotype qualified name.
	 * 
	 * @param genFeature
	 *        the gen feature
	 * @return the stereotype qualified name
	 */
	public static String getStereotypeQualifiedName(GenFeature genFeature) {
		EObject umlElement = findUMLMetaElement(genFeature.getEcoreFeature(), genFeature.getGenModel());

		if(umlElement instanceof Property) {
			if(((Property)umlElement).getClass_() instanceof Stereotype) {
				return ((Property)umlElement).getClass_().getQualifiedName();
			}
		}
		return "FAILED_TO_FIND_STEREOTYPE_QUALIFIEDNAME"; //$NON-NLS-1$
	}



	/**
	 * Gets the stereotyped mappings.
	 * 
	 * @param genModel
	 *        the GenModel
	 * @return the stereotyped mappings
	 */
	public static synchronized List<StereotypedMapping> getStereotypedMappings(GenModel genModel) {

		if(!stereotypedMappingsCache.containsKey(genModel)) {

			List<StereotypedMapping> stereotypedMappings = new ArrayList<StereotypedMapping>();
			for(Mapping mapping : getAllMappings(genModel)) {
				if(mapping instanceof StereotypedMapping) {
					stereotypedMappings.add((StereotypedMapping)mapping);
				}
			}

			stereotypedMappingsCache.put(genModel, stereotypedMappings);
		}

		return stereotypedMappingsCache.get(genModel);
	}

	/**
	 * Generate the wrapper for a mapping considering possible application of stereotype combinations
	 * 
	 * @param mapping
	 *        the mapping
	 * @param genModel
	 *        the GenModel
	 * @param genPackage
	 *        the gen package
	 * @return the corresponding stereotype mapping
	 */
	public static String getCorrespondingStereotypeMapping(org.eclipse.papyrus.facademapping.Mapping mapping, GenModel genModel, GenPackage genPackage) {
		String result = ""; //$NON-NLS-1$

		if(!(mapping instanceof StereotypedMapping)) {

			List<StereotypedMapping> correspondingStereotypeMappings = new ArrayList<StereotypedMapping>();
			List<StereotypedMapping> correspondingAssocationStereotypeMappings = new ArrayList<StereotypedMapping>();

			for(Mapping toProcessMapping : getStereotypedMappings(genModel)) {

				if(mapping != toProcessMapping) {

					boolean isAbstract = false;
					EList<EObject> stereos = ((StereotypedMapping)toProcessMapping).getAppliedStereotypes();
					for(EObject stereo : stereos) {
						if(stereo instanceof Stereotype) {
							if(((Stereotype)stereo).isAbstract()) {
								isAbstract = true;
							}
						}
					}
					if(!isAbstract) {

						if(((StereotypedMapping)toProcessMapping).getKind() == ExtensionDefinitionKind.GENERALIZATION || ((StereotypedMapping)toProcessMapping).getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
							if(toProcessMapping.getUmlElement() == mapping.getUmlElement()) {
								correspondingStereotypeMappings.add((StereotypedMapping)toProcessMapping);
							}
						} else {
							if(mapping.getUmlElement() instanceof EClass) {
								List<EObject> candidates = new ArrayList<EObject>();
								candidates.add((EClass)mapping.getUmlElement());
								candidates.addAll(((EClass)mapping.getUmlElement()).getEAllSuperTypes());

								if(candidates.contains(toProcessMapping.getUmlElement()))
									correspondingAssocationStereotypeMappings.add((StereotypedMapping)toProcessMapping);
							}
						}
					}
				}
			}

			for(StereotypedMapping correspondingStereotypeMapping : correspondingStereotypeMappings) {
				if(correspondingStereotypeMapping.getSpecificDomainElement() instanceof ENamedElement) {

					String name = ((ENamedElement)correspondingStereotypeMapping.getSpecificDomainElement()).getName().toLowerCase();

					//Single stereotype
					List<Stereotype> combination = new ArrayList<Stereotype>();
					combination.addAll((Collection<? extends Stereotype>)correspondingStereotypeMapping.getAppliedStereotypes());
					result += addWrappingStereotypeMapping(combination, name, genPackage, genModel, correspondingStereotypeMapping);

					//Create combination with association stereo
					if(!correspondingAssocationStereotypeMappings.isEmpty()) {

						for(int k = 1; k <= correspondingAssocationStereotypeMappings.size(); k++) {
							CombinationGenerator combinaisonGenerator = new CombinationGenerator(correspondingAssocationStereotypeMappings.size(), k);

							//Process each combination
							while(combinaisonGenerator.hasMore()) {
								int[] indices = combinaisonGenerator.getNext();

								//Single stereotype first
								combination = new ArrayList<Stereotype>();
								combination.addAll((Collection<? extends Stereotype>)correspondingStereotypeMapping.getAppliedStereotypes());
								name = ((ENamedElement)correspondingStereotypeMapping.getSpecificDomainElement()).getName().toLowerCase();

								for(int i = 0; i < indices.length; i++) {
									combination.addAll((Collection<? extends Stereotype>)correspondingAssocationStereotypeMappings.get(indices[i]).getAppliedStereotypes());

									if(correspondingAssocationStereotypeMappings.get(indices[i]).getSpecificDomainElement() instanceof ENamedElement) {
										name += "_" + ((ENamedElement)correspondingAssocationStereotypeMappings.get(indices[i]).getSpecificDomainElement()).getName().toLowerCase(); //$NON-NLS-1$
									} else {
										FacadeCodeGenPlugin.log.warn(Messages.FacadeCodegenUtils_48 + correspondingAssocationStereotypeMappings.get(indices[i]).getSpecificDomainElement());
									}
								}
								result += addWrappingStereotypeMapping(combination, name, genPackage, genModel, correspondingStereotypeMapping);
							}
						}
					}

				} else {
					FacadeCodeGenPlugin.log.warn(Messages.FacadeCodegenUtils_49 + correspondingStereotypeMapping.getSpecificDomainElement());
				}

			}

		}

		return result;

	}

	/**
	 * Generate the actual text for a wrapping of a combination of stereotype application
	 * 
	 * @param combination
	 *        the combination
	 * @param name
	 *        the name
	 * @param genPackage
	 *        the gen package
	 * @param genModel
	 *        the GenModel
	 * @param correspondingStereotypeMapping
	 *        the corresponding stereotype mapping
	 * @return the string
	 */
	protected static String addWrappingStereotypeMapping(List<Stereotype> combination, String name, GenPackage genPackage, GenModel genModel, StereotypedMapping correspondingStereotypeMapping) {

		String result = ""; //$NON-NLS-1$

		result += "java.util.List<org.eclipse.uml2.uml.Stereotype> " + name + "_Stereotypes = new java.util.ArrayList<org.eclipse.uml2.uml.Stereotype>();\n"; //$NON-NLS-1$ //$NON-NLS-2$

		result += addStereotypes(combination, name);
		result += "if(((org.eclipse.uml2.uml.Element)umlElement).getAppliedStereotypes().size() ==  " + name + "_Stereotypes.size()) {\n"; //$NON-NLS-1$ //$NON-NLS-2$
		result += "if(((org.eclipse.uml2.uml.Element)umlElement).getAppliedStereotypes().containsAll(" + name + "_Stereotypes)) {\n"; //$NON-NLS-1$ //$NON-NLS-2$
		result += "return " + genPackage.getImportedPackageInterfaceName() + ".eINSTANCE.get" + getClassifierAccessorName(genModel, correspondingStereotypeMapping) + "();\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		result += "}\n"; //$NON-NLS-1$
		result += "}\n"; //$NON-NLS-1$
		for(int i = 0; i < combination.size(); i++) {
			result += "}\n"; //$NON-NLS-1$
		}

		return result;

	}

	/**
	 * Generate the text for the combination of stereotype application
	 * 
	 * @param combination
	 *        the combination
	 * @param name
	 *        the name
	 * @return the string
	 */
	protected static String addStereotypes(List<Stereotype> combination, String name) {
		String result = ""; //$NON-NLS-1$

		for(EObject stereotype : combination) {
			if(stereotype instanceof Stereotype) {
				result += "if(((org.eclipse.uml2.uml.Element)umlElement).getApplicableStereotype(\"" + ((Stereotype)stereotype).getQualifiedName() + "\") != null) {\n"; //$NON-NLS-1$ //$NON-NLS-2$
				result += name + "_Stereotypes.add(((org.eclipse.uml2.uml.Element)umlElement).getApplicableStereotype(\"" + ((Stereotype)stereotype).getQualifiedName() + "\"));\n"; //$NON-NLS-1$ //$NON-NLS-2$

			}
		}

		return result;
	}

	/**
	 * Checks if is a list of primitive types.
	 * 
	 * @param genFeature
	 *        the genFeature
	 * @return true, if is list of primitive types
	 */
	public static boolean isPrimtiveList(GenTypedElement genTypedElement) {
		if(CodeGenUtil.isJavaDefaultType(genTypedElement.getListItemType())) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	/**
	 * Checks if is primitive type.
	 * 
	 * @param genFeature
	 *        the genFeature
	 * @return true, if is primitive type
	 */
	public static boolean isPrimitive(GenTypedElement genTypedElement) {
		if(isJavaDefaultType(genTypedElement.getType())) {
			return Boolean.TRUE;
		}

		if(isEcoreDefaultType(genTypedElement.getType())) {
			return Boolean.TRUE;
		}

		if(genTypedElement.getType().startsWith("java.util.Map<")) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	/**
	 * Tests whether the given string is the name of a primitive or java.lang type.
	 */
	protected static boolean isEcoreDefaultType(String s) {
		return getEcoreDefaultTypes().contains(s);
	}

	/**
	 * Tests whether the given string is the name of a primitive or java.lang type.
	 */
	protected static boolean isJavaDefaultType(String s) {
		return getJavaDefaultTypes().contains(s);
	}

	/**
	 * Returns the names of the ecore types
	 */
	public static synchronized Set<String> getEcoreDefaultTypes() {
		if(ecoreDefaultTypes == null) {
			Set<String> result = new HashSet<String>(100);
			result.add("org.eclipse.emf.ecore.EAnnotation");
			result.add("org.eclipse.emf.ecore.EAttribute");
			result.add("org.eclipse.emf.ecore.EClass");
			result.add("org.eclipse.emf.ecore.EClassifier");
			result.add("org.eclipse.emf.ecore.EcoreFactory");
			result.add("org.eclipse.emf.ecore.EcorePackage");
			result.add("org.eclipse.emf.ecore.EDataType");
			result.add("org.eclipse.emf.ecore.EEnum");
			result.add("org.eclipse.emf.ecore.EEnumLiteral");
			result.add("org.eclipse.emf.ecore.EFactory");
			result.add("org.eclipse.emf.ecore.EGenericType");
			result.add("org.eclipse.emf.ecore.EModelElement");
			result.add("org.eclipse.emf.ecore.ENamedElement");
			result.add("org.eclipse.emf.ecore.EObject");
			result.add("org.eclipse.emf.ecore.EOperation");
			result.add("org.eclipse.emf.ecore.EPackage");
			result.add("org.eclipse.emf.ecore.EParameter");
			result.add("org.eclipse.emf.ecore.EReference");
			result.add("org.eclipse.emf.ecore.EStructuralFeature");
			result.add("org.eclipse.emf.ecore.ETypedElement");
			result.add("org.eclipse.emf.ecore.ETypeParameter");
			result.add("org.eclipse.emf.ecore.EValidator");
			result.add("org.eclipse.emf.ecore.InternalEObject");

			//ypes not directly EMF but used by EMF
			result.add("org.eclipse.emf.common.util.DiagnosticChain");


			ecoreDefaultTypes = Collections.unmodifiableSet(result);
		}
		return ecoreDefaultTypes;
	}

	/**
	 * Returns the names of the primitives and types
	 */
	public static synchronized Set<String> getJavaDefaultTypes() {
		if(javaDefaultTypes == null) {
			Set<String> result = new HashSet<String>(100);
			result.add("java.lang.AbstractMethodError");
			result.add("java.lang.ArithmeticException");
			result.add("java.lang.ArrayIndexOutOfBoundsException");
			result.add("java.lang.ArrayStoreException");
			result.add("java.lang.Boolean");
			result.add("java.lang.Byte");
			result.add("java.lang.Character");
			result.add("java.lang.Class");
			result.add("java.lang.ClassCastException");
			result.add("java.lang.ClassCircularityError");
			result.add("java.lang.ClassFormatError");
			result.add("java.lang.ClassLoader");
			result.add("java.lang.ClassNotFoundException");
			result.add("java.lang.CloneNotSupportedException");
			result.add("java.lang.Cloneable");
			result.add("java.lang.Comparable");
			result.add("java.lang.Compiler");
			result.add("java.lang.Double");
			result.add("java.lang.Deprecated");
			result.add("java.lang.Enum");
			result.add("java.lang.Error");
			result.add("java.lang.Exception");
			result.add("java.lang.ExceptionInInitializerError");
			result.add("java.lang.Float");
			result.add("java.lang.FloatingDecimal");
			result.add("java.lang.IllegalAccessError");
			result.add("java.lang.IllegalAccessException");
			result.add("java.lang.IllegalArgumentException");
			result.add("java.lang.IllegalMonitorStateException");
			result.add("java.lang.IllegalStateException");
			result.add("java.lang.IllegalThreadStateException");
			result.add("java.lang.IncompatibleClassChangeError");
			result.add("java.lang.IndexOutOfBoundsException");
			result.add("java.lang.InheritableThreadLocal");
			result.add("java.lang.InstantiationError");
			result.add("java.lang.InstantiationException");
			result.add("java.lang.Integer");
			result.add("java.lang.InternalError");
			result.add("java.lang.InterruptedException");
			result.add("java.lang.LinkageError");
			result.add("java.lang.Long");
			result.add("java.lang.Math");
			result.add("java.lang.NegativeArraySizeException");
			result.add("java.lang.NoClassDefFoundError");
			result.add("java.lang.NoSuchFieldError");
			result.add("java.lang.NoSuchFieldException");
			result.add("java.lang.NoSuchMethodError");
			result.add("java.lang.NoSuchMethodException");
			result.add("java.lang.NullPointerException");
			result.add("java.lang.Number");
			result.add("java.lang.NumberFormatException");
			result.add("java.lang.Object");
			result.add("java.lang.Override");
			result.add("java.lang.OutOfMemoryError");
			result.add("java.lang.Package");
			result.add("java.lang.Process");
			result.add("java.lang.Runnable");
			result.add("java.lang.Runtime");
			result.add("java.lang.RuntimeException");
			result.add("java.lang.RuntimePermission");
			result.add("java.lang.SecurityException");
			result.add("java.lang.SecurityManager");
			result.add("java.lang.Short");
			result.add("java.lang.StackOverflowError");
			result.add("java.lang.String");
			result.add("java.lang.StringBuffer");
			result.add("java.lang.StringBuilder");
			result.add("java.lang.StringIndexOutOfBoundsException");
			result.add("java.lang.SuppressWarnings");
			result.add("java.lang.System");
			result.add("java.lang.Thread");
			result.add("java.lang.ThreadDeath");
			result.add("java.lang.ThreadGroup");
			result.add("java.lang.ThreadLocal");
			result.add("java.lang.Throwable");
			result.add("java.lang.UnknownError");
			result.add("java.lang.UnsatisfiedLinkError");
			result.add("java.lang.UnsupportedClassVersionError");
			result.add("java.lang.UnsupportedOperationException");
			result.add("java.lang.VerifyError");
			result.add("java.lang.VirtualMachineError");
			result.add("Void");
			result.add("void");
			result.add("boolean");
			result.add("byte");
			result.add("char");
			result.add("double");
			result.add("float");
			result.add("int");
			result.add("long");
			result.add("short");
			javaDefaultTypes = Collections.unmodifiableSet(result);
		}
		return javaDefaultTypes;
	}

	/**
	 * Copy the original ecore metamodel in the impl source package
	 * 
	 * @param genPackage
	 *        the gen package
	 */
	public static void copyEcore(GenPackage genPackage) {


		GenModel genModel = genPackage.getGenModel();
		EModelElement ecoreModelElement = genPackage.getEcoreModelElement();
		if(ecoreModelElement != null) {

			URI originalURI = ecoreModelElement.eResource().getURI();
			String modelDirectory = genModel.getModelDirectory();
			String implPackage = genPackage.getClassPackageName().replaceAll("\\.", "/"); //$NON-NLS-1$ //$NON-NLS-2$
			if(!implPackage.startsWith("/") && !modelDirectory.endsWith("/")) { //$NON-NLS-1$ //$NON-NLS-2$
				implPackage = "/" + implPackage; //$NON-NLS-1$
			}
			String filePath = modelDirectory + implPackage;
			if(!filePath.endsWith("/")) { //$NON-NLS-1$
				filePath += "/"; //$NON-NLS-1$
			}
			filePath += originalURI.lastSegment();
			URI destURI = URI.createURI("platform:/resource" + filePath, true); //$NON-NLS-1$
			String dest = destURI.toPlatformString(true);

			try {

				if(originalURI.isPlatformResource()) {
					String platformString = originalURI.toPlatformString(true);
					IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
					if(resource instanceof IFile) {

						IPath destPath = new Path(dest);
						if(destPath.segmentCount() >= 2) {
							IFile destFolder = resource.getProject().getFile(destPath.removeLastSegments(1).removeFirstSegments(1));
							IFile destFile = resource.getProject().getFile(destPath.removeFirstSegments(1));

							File destFolderFile = destFolder.getLocation().toFile();
							File destFileFile = destFile.getLocation().toFile();
							destFolderFile.mkdirs();
							destFileFile.createNewFile();
							Files.copy(resource.getLocation().toFile().toPath(), destFileFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

						}

					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}



		}
	}
}
