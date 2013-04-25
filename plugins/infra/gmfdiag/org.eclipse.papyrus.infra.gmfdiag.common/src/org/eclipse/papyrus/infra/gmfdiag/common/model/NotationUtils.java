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
package org.eclipse.papyrus.infra.gmfdiag.common.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;

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
	@Deprecated
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
	public static Diagram getAssociatedDiagram(Resource notationResource, EObject eObject) {
		if(notationResource != null) {
			for(EObject obj : notationResource.getContents()) {
				if(obj instanceof Diagram) {
					Diagram diagram = (Diagram)obj;
					if(eObject != null && eObject.equals(diagram.getElement())) {
						return diagram;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets the direct associated diagram of the specified eObject.
	 * 
	 * @param eObject
	 * @param notationResource
	 * @param resolve
	 *        the resource if true
	 * 
	 * @return the associated diagram
	 */
	public static Diagram getAssociatedDiagram(Resource notationResource, EObject eObject, boolean resolve) {
		if(notationResource != null && resolve) {
			EcoreUtil.resolveAll(notationResource);
		}
		return getAssociatedDiagram(notationResource, eObject);
	}

	/**
	 * Gets the all the diagrams contained in the specified ancestor eObject
	 * 
	 * @param notationResource
	 * @param eObject
	 * 
	 * @return all the contained diagrams
	 * 
	 */
	public static List<Diagram> getDiagrams(Resource notationResource, EObject eObject) {
		List<Diagram> diagrams = new LinkedList<Diagram>();
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

	/**
	 * Gets the all the diagrams contained in the specified ancestor eObject
	 * 
	 * @param notationResource
	 * @param eObject
	 * @param resolve
	 *        the resource if true
	 * 
	 * @return all the contained diagrams
	 */
	public static List<Diagram> getDiagrams(Resource notationResource, EObject eObject, boolean resolve) {
		if(notationResource != null && resolve) {
			EcoreUtil.resolveAll(notationResource);
		}
		return getDiagrams(notationResource, eObject);
	}

	/**
	 * Helper to retrieve the Notation resource associated to a ModelSet. May be null.
	 * 
	 * @param from
	 * @return
	 */
	public static Resource getNotationResource(ModelSet from) {
		IModel notationModel = from.getModel(NotationModel.MODEL_ID);
		if(notationModel instanceof NotationModel) {
			return ((NotationModel)notationModel).getResource();
		}
		return null;
	}

	/**
	 * Helper to retrieve the Notation resource associated to a ServicesRegistry. May be null.
	 * 
	 * @param from
	 * @return
	 */
	public static Resource getNotationResource(ServicesRegistry registry) {
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(registry);
			return getNotationResource(modelSet);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}
	
	/**
	 * Gets the loaded associated diagrams of the specified eObject.
	 * This method uses the cross referencer to compute them.
	 * 
	 * @param eObject
	 * @param notationResource
	 * 
	 * @return the associated diagram
	 */
	public static List<Diagram> getLoadedAssociatedDiagrams(EObject eObject) {
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {

			public boolean apply(EStructuralFeature.Setting setting) {
				return setting.getEObject() instanceof Diagram && NotationPackage.Literals.VIEW__ELEMENT.equals(setting.getEStructuralFeature());
			}
		};
		Function<EStructuralFeature.Setting, Diagram> f = new Function<EStructuralFeature.Setting, Diagram>() {

			public Diagram apply(EStructuralFeature.Setting setting) {
				return (Diagram)setting.getEObject();
			}

		};
		return Lists.newArrayList(Iterables.transform(Iterables.filter(EMFHelper.getUsages(eObject), p), f));
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
