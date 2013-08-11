package org.eclipse.papyrus.facade.codegen.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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


public class FacadeCodegenUtils {

	protected static String UML_GEN_MODEL = "platform:/plugin/org.eclipse.uml2.uml/model/UML.genmodel";

	static List<Mapping> allMappings = null;


	public static String findMappingModel(GenModel genModel) {

		if(!genModel.getForeignModel().isEmpty()) {
			String metamodel = genModel.getForeignModel().get(0);
			metamodel = metamodel.replaceAll(".ecore", ".facademapping");

			URI ecoreURI = genModel.eResource().getURI();
			ecoreURI = ecoreURI.trimSegments(1);
			ecoreURI = ecoreURI.appendSegment(metamodel);

			return ecoreURI.toString();
		}
		return null;

	}

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

	protected static List<Mapping> getAllMappings(GenModel specificGenModel) {

		if(allMappings == null) {
			allMappings = new ArrayList<Mapping>();

			String mappingModel = findMappingModel(specificGenModel);
			if(mappingModel != null) {
				if(specificGenModel.eResource() != null) {
					if(specificGenModel.eResource().getResourceSet() != null) {
						ResourceSet resourceSet = specificGenModel.eResource().getResourceSet();
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
		}
		return allMappings;
	}

	public static String getAllStereotypeQualifiedNames(EObject specificMetaElement, GenModel specificGenModel) {

		Set<String> result = new HashSet<String>();


		for(Mapping mapping : getAllMappings(specificGenModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), specificMetaElement)) {
				if(mapping instanceof StereotypedMapping) {

					for(EObject stereotype : ((StereotypedMapping)mapping).getAppliedStereotypes()) {
						if(stereotype instanceof Stereotype) {
							result.add("\"" + ((Stereotype)stereotype).getQualifiedName() + "\"");
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

		return "";
	}

	public static String getNonAssociationStereotypeQualifiedNames(EObject specificMetaElement, GenModel specificGenModel) {

		Set<String> result = new HashSet<String>();


		for(Mapping mapping : getAllMappings(specificGenModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), specificMetaElement)) {
				if(mapping instanceof StereotypedMapping) {

					if(((StereotypedMapping)mapping).getKind() != ExtensionDefinitionKind.ASSOCIATION) {
						for(EObject stereotype : ((StereotypedMapping)mapping).getAppliedStereotypes()) {
							if(stereotype instanceof Stereotype) {
								result.add("\"" + ((Stereotype)stereotype).getQualifiedName() + "\"");
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

		return "";
	}

	public static String findUMLGetAccessor(EObject specificMetaFeature, GenModel specificGenModel) {

		EObject umlMetaFeature = findUMLMetaElement(specificMetaFeature, specificGenModel);

		if(umlMetaFeature != null) {
			if(umlMetaFeature instanceof EStructuralFeature) {
				ResourceSet resourceSet = new ResourceSetImpl();
				EObject umlGenModel = resourceSet.getResource(URI.createURI(UML_GEN_MODEL, true), true).getContents().get(0);

				if(umlGenModel != null) {
					if(umlGenModel instanceof org.eclipse.uml2.codegen.ecore.genmodel.GenModel) {

						return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)umlGenModel).findGenFeature((EStructuralFeature)umlMetaFeature).getGetAccessor();
					}
				}
			} else if(umlMetaFeature instanceof Property) {

				if(umlMetaFeature.eResource() != null) {
					if(!umlMetaFeature.eResource().getContents().isEmpty()) {
						EObject root = umlMetaFeature.eResource().getContents().get(0);
						if(root instanceof Profile) {

							GenModel profileGen = getGenModel(umlMetaFeature);
							EObject umlMetaFeatureDefinition = ((Profile)root).getDefinition((NamedElement)umlMetaFeature);
							if(umlMetaFeatureDefinition instanceof EStructuralFeature) {
								return ((org.eclipse.uml2.codegen.ecore.genmodel.GenModel)profileGen).findGenFeature((EStructuralFeature)umlMetaFeatureDefinition).getGetAccessor();
							}

						}
					}
				}




			}
		}

		return "FAILED_TO_FIND_MAPPED_GET_ACCESSOR";
	}

	protected static GenModel getGenModel(EObject element) {
		Map<String, URI> map = EcorePlugin.getEPackageNsURIToGenModelLocationMap(true);



		if(element.eResource() != null) {
			if(!element.eResource().getContents().isEmpty()) {
				EObject root = element.eResource().getContents().get(0);
				if(root instanceof Profile) {
					Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage");
					if(ePackageStereotype != null) {
						Object nsURI = ((Profile)root).getValue(ePackageStereotype, "nsURI");
						if(nsURI instanceof String) {
							URI genModelURI = map.get(nsURI);
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

	public static String findUMLAccessorName(EObject specificMetaFeature, GenModel specificGenModel) {
		EObject umlMetaFeature = findUMLMetaElement(specificMetaFeature, specificGenModel);

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

		return "FAILED_TO_FIND_MAPPED_GET_ACCESSOR_NAME";
	}

	public static List<? extends Mapping> getAllMetaclassMappings(GenModel specificGenModel) {

		ArrayList<Mapping> result = new ArrayList<Mapping>();

		String mappingModel = findMappingModel(specificGenModel);
		if(mappingModel != null) {

			if(specificGenModel.eResource() != null) {
				if(specificGenModel.eResource().getResourceSet() != null) {
					ResourceSet resourceSet = specificGenModel.eResource().getResourceSet();
					EObject root = resourceSet.getResource(URI.createURI(mappingModel, true), true).getContents().get(0);

					if(root != null) {
						if(root instanceof FacadeMappping) {
							FacadeMappping facadeMappping = (FacadeMappping)root;

							for(Mapping mapping : facadeMappping.getMappings()) {
								if(!(mapping instanceof StereotypedMapping)) {
									if(mapping.getSpecificDomainElement() instanceof EClassifier) {
										if(mapping.getUmlElement() != TypesPackage.eINSTANCE.getBoolean() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getString() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getReal() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getInteger() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getUnlimitedNatural()) {
											if(!(mapping.getUmlElement() instanceof Stereotype)) {
												if(mapping.getSpecificDomainElement() instanceof EClass) {
													if(!((EClass)mapping.getSpecificDomainElement()).isAbstract()) {
														result.add(mapping);
													}
												} else {
													result.add(mapping);
												}
											}
										}
									}
								} else {
									if(((StereotypedMapping)mapping).getKind() == ExtensionDefinitionKind.ASSOCIATION) {
										result.add(mapping);
									}
								}
							}
						}
					}
				}
			}

		}

		return result;
	}

	public static List<? extends Mapping> getAllEnumLiteralMappings(GenModel specificGenModel) {

		ArrayList<Mapping> result = new ArrayList<Mapping>();

		String mappingModel = findMappingModel(specificGenModel);
		if(mappingModel != null) {

			if(specificGenModel.eResource() != null) {
				if(specificGenModel.eResource().getResourceSet() != null) {
					ResourceSet resourceSet = specificGenModel.eResource().getResourceSet();
					EObject root = resourceSet.getResource(URI.createURI(mappingModel, true), true).getContents().get(0);

					if(root != null) {
						if(root instanceof FacadeMappping) {
							FacadeMappping facadeMappping = (FacadeMappping)root;

							for(Mapping mapping : facadeMappping.getMappings()) {
								if(mapping.getSpecificDomainElement() instanceof EEnumLiteral) {
									if(mapping.getUmlElement() != TypesPackage.eINSTANCE.getBoolean() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getString() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getReal() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getInteger() && mapping.getUmlElement() != TypesPackage.eINSTANCE.getUnlimitedNatural()) {
										result.add(mapping);
									}
								}
							}
						}
					}
				}
			}

		}

		return result;
	}

	public static List<? extends Mapping> getAllFeatureMappings(GenModel specificGenModel) {

		ArrayList<Mapping> result = new ArrayList<Mapping>();

		String mappingModel = findMappingModel(specificGenModel);
		if(mappingModel != null) {

			if(specificGenModel.eResource() != null) {
				if(specificGenModel.eResource().getResourceSet() != null) {
					ResourceSet resourceSet = specificGenModel.eResource().getResourceSet();
					EObject root = resourceSet.getResource(URI.createURI(mappingModel, true), true).getContents().get(0);

					if(root != null) {
						if(root instanceof FacadeMappping) {
							FacadeMappping facadeMappping = (FacadeMappping)root;

							for(Mapping mapping : facadeMappping.getMappings()) {
								if(!isExtensionStereotypePropertyFromSpecific(mapping.getSpecificDomainElement(), specificGenModel)) {
									if(mapping.getSpecificDomainElement() instanceof EStructuralFeature) {

										result.add(mapping);
									}
									if(mapping.getSpecificDomainElement() instanceof Property) {

										if(((Property)mapping.getSpecificDomainElement()).getClass_() instanceof Stereotype) {
											result.add(mapping);
										}
									}
								}
							}
						}
					}
				}
			}

		}

		return result;
	}

	public static EObject findUMLMetaElement(EObject specificMetaElement, GenModel genModel) {
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
								if(EcoreUtil.equals(mapping.getSpecificDomainElement(), specificMetaElement)) {

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

		return "FAILED_TO_FIND_MAPPED_UML_FEATURE";
	}


	public static String getPackagePathFromMapping(Mapping mapping) {
		EObject UMLMetaElement = getUMLElement(mapping);

		return getPackagePathFromUML(UMLMetaElement);
	}

	public static String getPackagePathFromUML(EObject UMLMetaElement) {

		EObject root = UMLMetaElement.eResource().getContents().get(0);
		if(root instanceof Profile) {
			Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage");
			if(ePackageStereotype != null) {
				Object packageName = ((Profile)root).getValue(ePackageStereotype, "packageName");
				Object basePackage = ((Profile)root).getValue(ePackageStereotype, "basePackage");
				if(packageName instanceof String && basePackage instanceof String) {
					if(UMLMetaElement instanceof NamedElement) {
						return basePackage + "." + packageName;
					}
				}
			}

		} else {

			return "org.eclipse.uml2.uml";

		}

		return "FAILED_TO_FIND_MAPPED_UML_PACKAGE_PATH";
	}

	public static String getUMLPackageName(Mapping mapping) {

		EObject UMLMetaElement = getUMLElement(mapping);

		EObject root = UMLMetaElement.eResource().getContents().get(0);
		if(root instanceof Profile) {
			Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage");
			if(ePackageStereotype != null) {
				Object packageName = ((Profile)root).getValue(ePackageStereotype, "packageName");
				if(packageName instanceof String) {
					if(UMLMetaElement instanceof NamedElement) {
						return getPackagePathFromMapping(mapping) + "." + packageName + "Package";
					}
				}
			}

		} else {

			return getPackagePathFromMapping(mapping) + ".UMLPackage";

		}

		return "FAILED_TO_FIND_MAPPED_UML_PACKAGE_NAME";
	}


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

		return "FAILED_TO_FIND_MAPPED_UML_ACCESSOR_NAME";
	}

	public static String getClassifierAccessorName(GenModel genModel, Mapping mapping) {
		return genModel.findGenClassifier((EClassifier)mapping.getSpecificDomainElement()).getClassifierAccessorName();
	}

	public static String getFeatureAccessorName(GenModel genModel, Mapping mapping) {
		return genModel.findGenFeature((EStructuralFeature)mapping.getSpecificDomainElement()).getFeatureAccessorName();
	}

	public static String getUMLMetaElement(EObject specificMetaElement, GenModel genModel) {

		for(Mapping mapping : getAllMappings(genModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), specificMetaElement)) {
				EObject UMLMetaElement = getUMLElement(mapping);

				if(UMLMetaElement instanceof ENamedElement) {
					return ((ENamedElement)UMLMetaElement).getName();
				} else if(UMLMetaElement instanceof NamedElement) {
					return ((NamedElement)UMLMetaElement).getName();
				}

			}
		}

		return "FAILED_TO_FIND_MAPPED_UML_METACLASS";
	}

	public static String getUMLFactory(EObject specificMetaElement, GenModel genModel) {

		for(Mapping mapping : getAllMappings(genModel)) {
			if(EcoreUtil.equals(mapping.getSpecificDomainElement(), specificMetaElement)) {

				EObject UMLMetaElement = getUMLElement(mapping);

				if(UMLMetaElement != null) {
					EObject root = UMLMetaElement.eResource().getContents().get(0);
					if(root instanceof Profile) {
						Stereotype ePackageStereotype = ((Profile)root).getAppliedStereotype("Ecore::EPackage");
						if(ePackageStereotype != null) {
							Object packageName = ((Profile)root).getValue(ePackageStereotype, "packageName");
							if(packageName instanceof String) {
								if(UMLMetaElement instanceof NamedElement) {
									return getPackagePathFromUML(UMLMetaElement) + "." + packageName + "Factory";
								}
							}
						}
					} else {
						return getPackagePathFromUML(UMLMetaElement) + ".UMLFactory";
					}
				}

			}
		}




		return "FAILED_TO_FIND_MAPPED_UML_FACTORY";
	}

	public static String getAppropriateQualifiedTypeName(GenClassifier genClassifier) {
		if(genClassifier instanceof GenClass) {

			return ((GenClass)genClassifier).getQualifiedInterfaceName();

		} else if(genClassifier instanceof GenDataType) {

			return ((GenDataType)genClassifier).getQualifiedInstanceClassName();

		} else {

			return "FAILED_TO_FIND_QUALIFIED_TYPE_NAME";
		}
	}

	public static String getUMLEnumElementFromMapping(Mapping mapping) {
		if(mapping.getUmlElement() instanceof EEnumLiteral) {
			return ((EEnumLiteral)mapping.getUmlElement()).getEEnum().getName() + ".get(" + ((EEnumLiteral)mapping.getUmlElement()).getValue() + ")";
		} else if(mapping.getUmlElement() instanceof EnumerationLiteral) {
			return ((EnumerationLiteral)mapping.getUmlElement()).getEnumeration().getName() + ".get(\"" + ((EnumerationLiteral)mapping.getUmlElement()).getName() + "\")";
		}

		return "FAILED_TO_FIND_MAPPED_UML_ENUM_ELEMENT";
	}

	public static String getSpecificEnumElementFromMapping(Mapping mapping) {
		if(mapping.getUmlElement() instanceof EEnumLiteral) {
			return ((EEnumLiteral)mapping.getUmlElement()).getEEnum().getName() + ".get(" + ((EEnumLiteral)mapping.getUmlElement()).getValue() + ")";
		} else if(mapping.getUmlElement() instanceof EnumerationLiteral) {
			return ((EnumerationLiteral)mapping.getUmlElement()).getEnumeration().getName() + ".get(\"" + ((EnumerationLiteral)mapping.getUmlElement()).getName() + "\")";
		}

		return "FAILED_TO_FIND_MAPPED_SPECIFIC_ENUM_ELEMENT";
	}

	protected static boolean isExtensionStereotypePropertyFromSpecific(EObject specificElement, GenModel genModel) {
		EObject umlElement = findUMLMetaElement(specificElement, genModel);

		if(umlElement instanceof Property) {
			if(((Property)umlElement).getAssociation() instanceof Extension) {
				if(((Property)umlElement).getName().startsWith(Extension.STEREOTYPE_ROLE_PREFIX)) {
					return Boolean.TRUE;
				}

			}
		}
		return Boolean.FALSE;
	}

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

	public static boolean isExtensionProperty(GenFeature genFeature) {
		EObject umlElement = findUMLMetaElement(genFeature.getEcoreFeature(), genFeature.getGenModel());

		if(umlElement instanceof Property) {
			if(((Property)umlElement).getAssociation() instanceof Extension) {

				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

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

	public static String getStereotypeQualifiedName(GenFeature genFeature) {
		EObject umlElement = findUMLMetaElement(genFeature.getEcoreFeature(), genFeature.getGenModel());

		if(umlElement instanceof Property) {
			if(((Property)umlElement).getClass_() instanceof Stereotype) {
				return ((Property)umlElement).getClass_().getQualifiedName();
			}
		}
		return "FAILED_TO_FIND_STEREOTYPE_QUALIFIEDNAME";
	}

	public static String getCorrespondingStereotypeMapping(org.eclipse.papyrus.facademapping.Mapping mapping, GenModel genModel, GenPackage genPackage) {
		String result = "";

		if(!(mapping instanceof StereotypedMapping)) {
			List<Mapping> allMappings = getAllMappings(genModel);

			List<StereotypedMapping> correspondingStereotypeMappings = new ArrayList<StereotypedMapping>();
			List<StereotypedMapping> correspondingAssocationStereotypeMappings = new ArrayList<StereotypedMapping>();

			for(Mapping toProcessMapping : allMappings) {
				if(mapping != toProcessMapping) {
					if(toProcessMapping instanceof StereotypedMapping) {


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
								if(toProcessMapping.getUmlElement() instanceof EClass) {
									List candidates = new ArrayList<>();
									candidates.add((EClass)toProcessMapping.getUmlElement());
									candidates.addAll(((EClass)toProcessMapping.getUmlElement()).getEAllSuperTypes());

									if(candidates.contains(toProcessMapping.getUmlElement()))
										correspondingAssocationStereotypeMappings.add((StereotypedMapping)toProcessMapping);
								}

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
						for(StereotypedMapping stereotypedAssocationMapping : correspondingAssocationStereotypeMappings) {
							combination.addAll((Collection<? extends Stereotype>)stereotypedAssocationMapping.getAppliedStereotypes());
							if(stereotypedAssocationMapping.getSpecificDomainElement() instanceof ENamedElement) {
								name += "_" + ((ENamedElement)stereotypedAssocationMapping.getSpecificDomainElement()).getName().toLowerCase();
							} else {
								System.err.println("Problem with : " + stereotypedAssocationMapping.getSpecificDomainElement());
							}
						}
						result += addWrappingStereotypeMapping(combination, name, genPackage, genModel, correspondingStereotypeMapping);
					}

				} else {
					System.err.println("Problem with : " + correspondingStereotypeMapping.getSpecificDomainElement());
				}

			}

		}

		return result;

	}

	protected static String addWrappingStereotypeMapping(List<Stereotype> combination, String name, GenPackage genPackage, GenModel genModel, StereotypedMapping correspondingStereotypeMapping) {

		String result = "";

		result += "java.util.List<org.eclipse.uml2.uml.Stereotype> " + name + "_Stereotypes = new java.util.ArrayList<org.eclipse.uml2.uml.Stereotype>();\n";

		result += addStereotypes(combination, name);
		result += "if(((org.eclipse.uml2.uml.Element)umlElement).getAppliedStereotypes().size() ==  " + name + "_Stereotypes.size()) {\n";
		result += "if(((org.eclipse.uml2.uml.Element)umlElement).getAppliedStereotypes().containsAll(" + name + "_Stereotypes)) {\n";
		result += "return " + genPackage.getImportedPackageInterfaceName() + ".eINSTANCE.get" + getClassifierAccessorName(genModel, correspondingStereotypeMapping) + "();\n";
		result += "}\n";
		result += "}\n";

		return result;

	}

	protected static String addStereotypes(List<Stereotype> combination, String name) {
		String result = "";

		for(EObject stereotype : combination) {
			if(stereotype instanceof Stereotype) {
				result += "if(((org.eclipse.uml2.uml.Element)umlElement).getApplicableStereotype(\"" + ((Stereotype)stereotype).getQualifiedName() + "\") != null) {\n";
				result += name + "_Stereotypes.add(((org.eclipse.uml2.uml.Element)umlElement).getApplicableStereotype(\"" + ((Stereotype)stereotype).getQualifiedName() + "\"));\n";
				result += "}\n";
			}
		}

		return result;
	}

	public static boolean isPrimtiveList(GenFeature genFeature) {
		if(CodeGenUtil.isJavaDefaultType(genFeature.getListItemType())) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public static void copyEcore(GenPackage genPackage) {


		GenModel genModel = genPackage.getGenModel();
		EModelElement ecoreModelElement = genPackage.getEcoreModelElement();
		if(ecoreModelElement != null) {

			URI originalURI = ecoreModelElement.eResource().getURI();
			String modelDirectory = genModel.getModelDirectory();
			String implPackage = genPackage.getClassPackageName().replaceAll("\\.", "/");
			if(!implPackage.startsWith("/") && !modelDirectory.endsWith("/")) {
				implPackage = "/" + implPackage;
			}
			String filePath = modelDirectory + implPackage;
			if(!filePath.endsWith("/")) {
				filePath += "/";
			}
			filePath += originalURI.lastSegment();
			URI destURI = URI.createURI("platform:/resource" + filePath, true);
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
