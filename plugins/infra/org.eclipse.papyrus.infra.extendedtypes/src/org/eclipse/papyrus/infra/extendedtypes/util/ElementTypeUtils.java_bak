/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.PreActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;

/**
 * Utility class for {@link IElementType}.
 */
public class ElementTypeUtils {

	/**
	 * Tests if two elements types are equivalent
	 * 
	 * @param referenceType
	 *        the reference type for the comparison
	 * @param typeToCompare
	 *        the type that is compared to the reference one
	 * @return <code>true</code> if both types are equivalent semantically
	 */
	public static boolean isSemanticallyEquivalent(IElementType referenceType, IElementType typeToCompare) {
		boolean isEquivalent = true;
		// first : easy test...
		if(typeToCompare.equals(referenceType)) {
			return true;
		}
		// 2. test the kind of element.
		if(referenceType instanceof IMetamodelType) {
			if(!(typeToCompare instanceof IMetamodelType)) {
				return false;
			} else {
				EClass referenceEclass = ((IMetamodelType)referenceType).getEClass();
				EClass eclassToCompare = ((IMetamodelType)typeToCompare).getEClass();
				isEquivalent = isEquivalent && referenceEclass.equals(eclassToCompare);
			}
		} else {
			if((typeToCompare instanceof IMetamodelType)) {
				return false;
			}
		}
		// metaclasses are equivalent. check for extended types now...
		if(referenceType instanceof IExtendedHintedElementType) {
			if(typeToCompare instanceof IExtendedHintedElementType) {
				isEquivalent = isEquivalent && isSemanticallyEquivalent((IExtendedHintedElementType)referenceType, (IExtendedHintedElementType)typeToCompare);
			}
		}
		return isEquivalent;
	}

	/**
	 * Tests if two elements types are equivalent (configuration)
	 * 
	 * @param referenceType
	 *        the reference type for the comparison
	 * @param typeToCompare
	 *        the type that is compared to the reference one
	 * @return <code>true</code> if both types are equivalent semantically
	 */
	public static boolean isSemanticallyEquivalent(IExtendedHintedElementType referenceType, IExtendedHintedElementType typeToCompare) {
		boolean isEquivalent = true;
		// check all pre/post action and validation
		ExtendedElementTypeConfiguration referenceConfiguration = referenceType.getConfiguration();
		ExtendedElementTypeConfiguration configurationToCompare = typeToCompare.getConfiguration();
		List<QueryConfiguration> referencePrevalidation = referenceConfiguration.getPreValidation();
		List<QueryConfiguration> prevalidationToCompare = configurationToCompare.getPreValidation();
		if(referencePrevalidation != null) {
			isEquivalent = isEquivalent && isEquivalent(referencePrevalidation, prevalidationToCompare);
		} else if(prevalidationToCompare != null) {
			isEquivalent = false;
		}
		List<PreActionConfiguration> referencePreaction = referenceConfiguration.getPreAction();
		List<PreActionConfiguration> preactionToCompare = configurationToCompare.getPreAction();
		if(referencePreaction != null) {
			isEquivalent = isEquivalent && isEquivalent(referencePreaction, preactionToCompare);
		} else if(preactionToCompare != null) {
			isEquivalent = false;
		}
		List<PostActionConfiguration> referencePostaction = referenceConfiguration.getPostAction();
		List<PostActionConfiguration> postactionToCompare = configurationToCompare.getPostAction();
		if(referencePostaction != null) {
			isEquivalent = isEquivalent && isEquivalent(referencePostaction, postactionToCompare);
		} else if(postactionToCompare != null) {
			isEquivalent = false;
		}
		return isEquivalent;
	}

	public static boolean isEquivalent(List<? extends EObject> referenceList, List<? extends EObject> listToCompare) {
		boolean isEquivalent = true;
		if(referenceList == null) {
			// only one is null : false
			if(listToCompare != null) {
				return false;
			} else {
				// both are null: true
				return true;
			}
		} else {
			// only one is null: false
			if(listToCompare == null) {
				return false;
			}
		}
		// check emptyness. If both empty : equivalent
		if(referenceList.isEmpty() && listToCompare.isEmpty()) {
			return true;
		}
		// check size. If different, false
		if(referenceList.size() != listToCompare.size()) {
			return false;
		}
		for(int i = 0; i < referenceList.size(); i++) {
			EObject reference = referenceList.get(i);
			EObject compared = listToCompare.get(i);
			isEquivalent = isEquivalent && EcoreUtil.equals(reference, compared);
		}
		return isEquivalent;
	}

	/**
	 * Returns the closest non Extended element type for a given extended type
	 * 
	 * @param requestElementType
	 *        the element type to study
	 * @return the closest non extended element type or <code>null</code> if none was found.
	 */
	public static IElementType findClosestNonExtendedElementType(IExtendedHintedElementType requestElementType) {
		List<IElementType> superTypes = new ArrayList<IElementType>(Arrays.asList(requestElementType.getAllSuperTypes()));
		// reverse order for the list, because super type returns all super types from furthest to closest, we want the other order
		Collections.reverse(superTypes);
		for(IElementType superType : superTypes) {
			if(!(superType instanceof IExtendedHintedElementType)) {
				return superType;
			}
		}
		return null;
	}

	/**
	 * Returns the closest super type which is not an extended type
	 * 
	 * @param elementType
	 *        the element type for which the super type is searched.
	 * @return the closest super type non extended or <code>null</code> if none was found
	 */
	public static IElementType getClosestDiagramType(IElementType elementType) {
		if(!(elementType instanceof IExtendedHintedElementType)) {
			return elementType;
		}
		// this is an extended type
		String diagramElementTypeID = ((IExtendedHintedElementType)elementType).getConfiguration().getSpecializedDiagramTypeID();
		if(diagramElementTypeID != null) {
			return getClosestDiagramType(ElementTypeRegistry.getInstance().getType(diagramElementTypeID));
		} else {
			IElementType[] superTypes = elementType.getAllSuperTypes();
			if(superTypes.length > 1) {
				return getClosestDiagramType(superTypes[superTypes.length - 1]);
			}
		}
		return null;
	}
}
