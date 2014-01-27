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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassImpl;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class WrappingListUtils {

	private static final String UNSUPPORTED_LIST_CONSTRUCTOR = "UNSUPPORTED_LIST_CONSTRUCTOR"; //$NON-NLS-1$

	/**
	 * Gets the list of genFeatures that are subsetted by the genFeature.
	 * 
	 * @param genFeature
	 *        the genFeature
	 * @return the list of subsetted genFeatures
	 */
	protected static List<GenFeature> getSubsetReferenceGenFeature(GenFeature genFeature) {
		List<GenFeature> result = new ArrayList<GenFeature>();
		EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		if(ecoreFeature != null) {
			EAnnotation annotation = ecoreFeature.getEAnnotation("subsets"); //$NON-NLS-1$
			if(annotation != null) {
				EList<EObject> references = annotation.getReferences();
				for(EObject ref : references) {

					if(ref instanceof EReference) {
						GenFeature refGenFeature = genFeature.getGenModel().findGenFeature((EStructuralFeature)ref);
						result.add(refGenFeature);
					}
				}
			}
		}
		return result;
	}


	/**
	 * Gets the wrapping list constructor.
	 * 
	 * @param genClass
	 *        the gen class
	 * @param genFeature
	 *        the gen feature
	 * @param typeArgument
	 *        the type argument
	 * @return the wrapping list constructor
	 */
	public static String getWrappingListConstructor(GenClass genClass, GenFeature genFeature, String typeArgument) {

		boolean isJava5 = isJDK50(genClass.getGenModel());
		if(genClass instanceof GenClassImpl) {

			GenClassImpl genClassImpl = (GenClassImpl)genClass;
			StringBuffer sb = new StringBuffer();

			String unsettable = genFeature.isUnsettable() ? ".Unsettable" : ""; //$NON-NLS-1$ //$NON-NLS-2$
			String offsetCorrectionField = genClassImpl.hasOffsetCorrection() ? " + " + genClassImpl.getOffsetCorrectionField(null) : ""; //$NON-NLS-1$ //$NON-NLS-2$


			if(genFeature.isMapType()) {
				sb.append(UNSUPPORTED_LIST_CONSTRUCTOR + "_MapType"); //$NON-NLS-1$
				//				GenClass mapGenClass = genFeature.getMapEntryTypeGenClass();
				//				sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.emf.ecore.util.EcoreEMap"));
				//				sb.append(unsettable);
				//				if(isJava5) {
				//					sb.append('<');
				//					sb.append(genFeature.getImportedMapKeyType(genClassImpl));
				//					sb.append(',');
				//					sb.append(genFeature.getImportedMapValueType(genClassImpl));
				//					sb.append('>');
				//				}
				//				sb.append("(");
				//				sb.append(mapGenClass.getQualifiedClassifierAccessor());
				//				sb.append(", ");
				//				sb.append(genFeature.getImportedMapEntryType());
				//				sb.append(".class, this, ");
				//				sb.append(genClassImpl.getQualifiedFeatureID(genFeature));
				//				sb.append(offsetCorrectionField);
				//				if(genFeature.isBidirectional() && genClassImpl.getGenModel().getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF27_VALUE) {
				//					sb.append(", ");
				//					sb.append(genFeature.getReverse().getGenClass().getQualifiedFeatureID(genFeature.getReverse()));
				//				}
				//				sb.append(")");
			} else if(genFeature.isFeatureMapType()) {
				sb.append(UNSUPPORTED_LIST_CONSTRUCTOR + "_FeatureMapType"); //$NON-NLS-1$
				//				if(genFeature.isWrappedFeatureMapType()) {
				//					sb.append(genFeature.getImportedEffectiveFeatureMapWrapperClass());
				//					sb.append("(new ");
				//				}
				//				sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.emf.ecore.util.BasicFeatureMap"));
				//				sb.append("(this, ");
				//				sb.append(genClassImpl.getQualifiedFeatureID(genFeature));
				//				sb.append(offsetCorrectionField);
				//				sb.append(")");
				//				if(genFeature.isWrappedFeatureMapType()) {
				//					sb.append(")");
				//				}
			} else {
				EGenericType eGenericType = genFeature.getEcoreFeature().getEGenericType();
				if(genClassImpl.getGenModel().isSuppressNotification()) {

					sb.append(UNSUPPORTED_LIST_CONSTRUCTOR + "_Generic"); //$NON-NLS-1$

					//					sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.emf.ecore.util.BasicInternalEList"));
					//					if(genClassImpl.getGenModel().getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF28_VALUE) {
					//						sb.append(unsettable);
					//					}
					//					if(isJava5) {
					//						sb.append('<');
					//						sb.append(genFeature.getListItemType(genClassImpl));
					//						sb.append('>');
					//					}
					//					sb.append("(");
					//					sb.append(typeArgument);
					//					sb.append(".class)");
				} else if(genFeature.isEffectiveContains()) {
					if(genFeature.isBidirectional()) {
						GenFeature reverseFeature = genFeature.getReverse();
						if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
							sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.subset.WrappingSubsetEObjectContainmentWithInverseEList")); //$NON-NLS-1$
						} else {
							sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectContainmentWithInverseEList")); //$NON-NLS-1$
						}
						sb.append(unsettable);
						if(genFeature.isResolveProxies()) {
							//							sb.append(".Resolving");
							sb.append(UNSUPPORTED_LIST_CONSTRUCTOR + "_Resolving"); //$NON-NLS-1$
						}
						if(isJava5) {
							sb.append('<');
							sb.append(genFeature.getListItemType(genClassImpl));
							sb.append('>');
						}
						sb.append("("); //$NON-NLS-1$
						sb.append(typeArgument);
						sb.append(".class, this, "); //$NON-NLS-1$
						sb.append(genClassImpl.getQualifiedFeatureID(genFeature));
						sb.append(offsetCorrectionField);
						sb.append(", "); //$NON-NLS-1$
						sb.append(reverseFeature.getGenClass().getQualifiedFeatureID(reverseFeature));
						if(reverseFeature.getGenClass().hasOffsetCorrection()) {
							sb.append(" + "); //$NON-NLS-1$
							sb.append(genClassImpl.getOffsetCorrectionField(genFeature));
						}
						sb.append(",(java.util.Collection)umlList"); //$NON-NLS-1$
						if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
							for(GenFeature feature : getSubsetReferenceGenFeature(genFeature)) {
								sb.append(",(" + genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingList") + ")" + feature.getGetAccessor() + "()"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
							}
						}
						sb.append(")"); //$NON-NLS-1$
					} else {
						if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
							sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.subset.WrappingSubsetEObjectContainmentEList")); //$NON-NLS-1$
						} else {
							sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectContainmentEList")); //$NON-NLS-1$
						}
						sb.append(unsettable);
						if(genFeature.isResolveProxies()) {
							//							sb.append(".Resolving");
							sb.append(UNSUPPORTED_LIST_CONSTRUCTOR + "_Resolving"); //$NON-NLS-1$
						}
						if(isJava5) {
							sb.append('<');
							sb.append(genFeature.getListItemType(genClassImpl));
							sb.append('>');
						}
						sb.append("("); //$NON-NLS-1$
						sb.append(typeArgument);
						sb.append(".class, this, "); //$NON-NLS-1$
						sb.append(genClassImpl.getQualifiedFeatureID(genFeature));
						sb.append(offsetCorrectionField);
						sb.append(",(java.util.Collection)umlList"); //$NON-NLS-1$
						if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
							for(GenFeature feature : getSubsetReferenceGenFeature(genFeature)) {
								sb.append(",(" + genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingList") + ")" + feature.getGetAccessor() + "()"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
							}
						}
						sb.append(")"); //$NON-NLS-1$
					}
				} else if(genFeature.isReferenceType()) {
					if(genFeature.isBidirectional()) {
						GenFeature reverseFeature = genFeature.getReverse();
						if(genFeature.isResolveProxies()) {
							//							sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList"));
							if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.subset.WrappingSubsetEObjectWithInverseEList")); //$NON-NLS-1$
							} else {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectWithInverseEList")); //$NON-NLS-1$
							}
						} else {
							if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.subset.WrappingSubsetEObjectWithInverseEList")); //$NON-NLS-1$
							} else {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectWithInverseEList")); //$NON-NLS-1$
							}
						}
						sb.append(unsettable);
						if(reverseFeature.isListType()) {
							if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
								sb.append(".WrappingSubsetManyInverse"); //$NON-NLS-1$
							} else {
								sb.append(".WrappingManyInverse"); //$NON-NLS-1$
							}
						}
						if(isJava5) {
							sb.append('<');
							sb.append(genFeature.getListItemType(genClassImpl));
							sb.append('>');
						}
						sb.append("("); //$NON-NLS-1$
						sb.append(typeArgument);
						sb.append(".class, this, "); //$NON-NLS-1$
						sb.append(genClassImpl.getQualifiedFeatureID(genFeature));
						sb.append(offsetCorrectionField);
						sb.append(", "); //$NON-NLS-1$
						sb.append(reverseFeature.getGenClass().getQualifiedFeatureID(reverseFeature));
						if(reverseFeature.getGenClass().hasOffsetCorrection()) {
							sb.append(" + "); //$NON-NLS-1$
							sb.append(genClassImpl.getOffsetCorrectionField(genFeature));
						}
						sb.append(",(java.util.Collection)umlList"); //$NON-NLS-1$
						if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
							for(GenFeature feature : getSubsetReferenceGenFeature(genFeature)) {
								sb.append(",(" + genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingList") + ")" + feature.getGetAccessor() + "()"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
							}
						}
						sb.append(")"); //$NON-NLS-1$
					} else {
						if(genFeature.isResolveProxies()) {
							//							sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.emf.ecore.util.EObjectResolvingEList"));
							if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.subset.WrappingSubsetEObjectEList")); //$NON-NLS-1$
							} else {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectEList")); //$NON-NLS-1$
							}
						} else {
							if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.subset.WrappingSubsetEObjectEList")); //$NON-NLS-1$
							} else {
								sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectEList")); //$NON-NLS-1$
							}
						}
						sb.append(unsettable);
						if(isJava5) {
							sb.append('<');
							sb.append(genFeature.getListItemType(genClassImpl));
							sb.append('>');
						}
						sb.append("("); //$NON-NLS-1$
						sb.append(typeArgument);
						sb.append(".class, this, "); //$NON-NLS-1$
						sb.append(genClassImpl.getQualifiedFeatureID(genFeature));
						sb.append(offsetCorrectionField);
						sb.append(",(java.util.Collection)umlList"); //$NON-NLS-1$
						if(!getSubsetReferenceGenFeature(genFeature).isEmpty()) {
							for(GenFeature feature : getSubsetReferenceGenFeature(genFeature)) {
								sb.append(",(" + genClassImpl.getGenModel().getImportedName("org.eclipse.papyrus.facade.utils.wrappinglist.WrappingList") + ")" + feature.getGetAccessor() + "()"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
							}
						}
						sb.append(")"); //$NON-NLS-1$
					}
				} else { //data type
					if(genFeature.isUnique()) {
						//						sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.emf.ecore.util.EDataTypeUniqueEList"));
						sb.append(UNSUPPORTED_LIST_CONSTRUCTOR + "_UniqueDatatype"); //$NON-NLS-1$
					} else {
						//						sb.append(genClassImpl.getGenModel().getImportedName("org.eclipse.emf.ecore.util.EDataTypeEList"));
						sb.append(UNSUPPORTED_LIST_CONSTRUCTOR + "_NotUniqueDatatype"); //$NON-NLS-1$
					}
					sb.append(unsettable);
					if(isJava5) {
						sb.append('<');
						sb.append(genFeature.getListItemType(genClassImpl));
						sb.append('>');
					}
					sb.append("("); //$NON-NLS-1$
					sb.append(isPrimitiveType(eGenericType.getERawType()) ? genFeature.getRawListItemType() : typeArgument);
					sb.append(".class, this, "); //$NON-NLS-1$
					sb.append(genClassImpl.getQualifiedFeatureID(genFeature));
					sb.append(offsetCorrectionField);
					sb.append(")"); //$NON-NLS-1$
				}
			}
			return sb.toString();
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * Checks if the genModel is defined as JDK50 complianceLevel.
	 * 
	 * @param genModel
	 *        the genModel
	 * @return true, if the genModel is defined as JDK50 complianceLevel.
	 */
	public static boolean isJDK50(GenModel genModel) {
		if(genModel != null && genModel.getComplianceLevel() != null)
			return genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
		return false;
	}

	/**
	 * Checks if is primitive type.
	 * 
	 * @param eType
	 *        the eType
	 * @return true, if is primitive type
	 */
	static public boolean isPrimitiveType(EClassifier eType) {
		return eType != null && CodeGenUtil.isJavaPrimitiveType(eType.getInstanceClassName());
	}




}
