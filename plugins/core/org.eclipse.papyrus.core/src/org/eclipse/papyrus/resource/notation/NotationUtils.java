/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.resource.notation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.core.modelsetquery.IModelSetQueryAdapter;
import org.eclipse.papyrus.core.modelsetquery.ModelSetQuery;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.resource.ModelSet;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Utilities method to manage notation models. Should be moved in a more
 * suitable plugin
 */
public class NotationUtils {

	/**
	 * Get the notation Resource.
	 * 
	 * @return
	 * 
	 * @deprecated Usage of the internal Resource is discouraged.
	 */
	public static Resource getNotationResource() {
		return getNotationModel().getResource();
	}

	/**
	 * Gets the NotationModel for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * 
	 * @return The {@link NotationModel} of the current editor, or null if not
	 *         found.
	 */
	public static NotationModel getNotationModel() {

		try {
			return (NotationModel)ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(NotationModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the NotationModel for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * 
	 * @return The {@link NotationModel} of the current editor, or null if not
	 *         found.
	 * @throws ServiceException
	 *         If an error occurs while getting or starting the service.
	 */
	public static NotationModel getNotationModelChecked() throws ServiceException {

		return (NotationModel)ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(NotationModel.MODEL_ID);
	}

	/**
	 * Gets the NotationModel from the {@link ModelSet}. <br>
	 * 
	 * @param modelsManager
	 *        The modelManager containing the requested model.
	 * 
	 * @return The {@link NotationModel} registered in modelManager, or null if
	 *         not found.
	 */
	public static NotationModel getNotationModel(ModelSet modelsManager) {

		return (NotationModel)modelsManager.getModel(NotationModel.MODEL_ID);
	}

	/**
	 * Gets the direct associated diagram of the specified eObject.
	 * 
	 * @param eObject
	 * @param notationResource
	 * 
	 * @return the associated diagram
	 */
	public static List<Diagram> getAssociatedDiagrams(EObject eObject) {
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {
			public boolean apply(EStructuralFeature.Setting setting) {
				return setting.getEObject() instanceof Diagram && NotationPackage.Literals.VIEW__ELEMENT.equals(setting.getEStructuralFeature());
			}
		};
		Function<EStructuralFeature.Setting, Diagram> f = new Function<EStructuralFeature.Setting, Diagram>() {

			public Diagram apply(EStructuralFeature.Setting setting) {
				return (Diagram) setting.getEObject();
			}

		};
		return Lists.newArrayList(Iterables.transform(Iterables.filter(PapyrusEcoreUtils.getUsages(eObject), p), f));
	}

	/**
	 * Gets the all the diagrams contained in the specified ancestor eObject
	 * 
	 * @param eObject
	 * 
	 * @return all the contained diagrams
	 * 
	 */
	public static List<Diagram> getAllDescendantDiagrams(EObject eObject) {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		IModelSetQueryAdapter typeCache = ModelSetQuery.getExistingTypeCacheAdapter(eObject);

		if (typeCache != null) {
			Collection<EObject> allDiagrams = typeCache.getReachableObjectsOfType(eObject, NotationPackage.Literals.DIAGRAM);

			for (EObject obj : allDiagrams) {
				if(obj instanceof Diagram) {
					Diagram diagram = (Diagram)obj;
					if(EcoreUtil.isAncestor(eObject, diagram.getElement())) {
						diagrams.add(diagram);
					}
				}
			}
		}

		return diagrams;
	}

	/**
	 * Gets the all the diagrams contained in the specified ancestor eObject and
	 * currently stored in the specified notation resource.
	 * 
	 * @param notationResource
	 * @param eObject
	 * 
	 * @return all the contained diagrams
	 * 
	 */
	public static List<Diagram> getAllDescendantDiagramsInResource(EObject eObject, Resource notationResource) {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		if(notationResource != null) {
			for(EObject obj : notationResource.getContents()) {
				if(obj instanceof Diagram) {
					Diagram diagram = (Diagram)obj;
					if(EcoreUtil.isAncestor(eObject, diagram.getElement())) {
						diagrams.add(diagram);
					}
				}
			}
		}
		return diagrams;
	}

}
