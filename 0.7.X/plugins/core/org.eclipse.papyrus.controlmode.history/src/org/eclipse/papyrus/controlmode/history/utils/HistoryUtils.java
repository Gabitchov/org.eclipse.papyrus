/**
 * 
 */
package org.eclipse.papyrus.controlmode.history.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.controlmode.history.HistoryModel;
import org.eclipse.papyrus.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelUtils;
import org.eclipse.papyrus.resource.sasheditor.SashModel;


/**
 * Set of utility methods linked to Trace for ControlMode
 * 
 * @author cedric dumoulin
 * 
 */
public class HistoryUtils {


	/**
	 * Gets the HistoryModel for the currently selected editor. <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 * 
	 * 
	 * @return The {@link HistoryModel} of the current editor, or null if not found.
	 */
	public static HistoryModel getHistoryModel() {

		try {
			return (HistoryModel)ModelUtils.getModelSetChecked().getModel(HistoryModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the HistoryModel for the currently selected editor. <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 * 
	 * 
	 * @return The {@link HistoryModel} of the current editor, or null if not found.
	 * @throws ServiceException
	 *         If an error occurs while getting or starting the service.
	 */
	public static HistoryModel getHistoryModelChecked() throws ServiceException {

		return (HistoryModel)ModelUtils.getModelSetChecked().getModel(HistoryModel.MODEL_ID);
	}

	/**
	 * Gets the HistoryModel from the {@link ModelSet}. <br>
	 * 
	 * @param modelsManager
	 *        The modelManager containing the requested model.
	 * 
	 * @return The {@link HistoryModel} registered in modelManager, or null if not found.
	 */
	public static HistoryModel getHistoryModel(ModelSet modelsManager) {

		return (HistoryModel)modelsManager.getModel(HistoryModel.MODEL_ID);
	}

	/**
	 * Gets the HistoryModel from the {@link ServicesRegistry}. <br>
	 * 
	 * @param ServicesRegistry
	 *        The servie registry under which the ModelSet is registered.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not found.
	 */
	public static HistoryModel getHistoryModel(ServicesRegistry servicesRegistry) {

		try {
			return (HistoryModel)ModelUtils.getModelSetChecked(servicesRegistry).getModel(HistoryModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the HistoryModel from the {@link ServicesRegistry}. <br>
	 * 
	 * @param ServicesRegistry
	 *        The servie registry under which the ModelSet is registered.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not found.
	 * @throws ServiceException
	 *         If the service can't be returned.
	 */
	public static HistoryModel getHistoryModelChecked(ServicesRegistry servicesRegistry) throws ServiceException {

		return (HistoryModel)ModelUtils.getModelSetChecked(servicesRegistry).getModel(HistoryModel.MODEL_ID);
	}

	/**
	 * Returns from a string the corresponding uri without the file name
	 * 
	 * @param uri
	 * @return an {@link URI} corresponding of the full path of the string
	 */
	public static URI getURIFullPath(String uri) {
		return URI.createURI(uri.substring(0, uri.lastIndexOf("/") + 1));
	}

	/**
	 * Returns the uri without the file name
	 * 
	 * @param createURI
	 * @return the {@link URI} without the file name
	 */
	public static URI getURIFullPath(URI createURI) {
		return getURIFullPath(createURI.toString());
	}

	/**
	 * Resolve the current URL according to the uri path
	 * 
	 * @param uriPath
	 * @param currentURL
	 * @return the
	 */
	public static String resolve(URI uriPath, String currentURL) {
		URI currentURI = URI.createURI(currentURL);
		return currentURI.deresolve(uriPath).toString();
	}

	/**
	 * Return an absolute URI to a relative according to the uri path
	 * 
	 * @param uriPath
	 * @param currentURI
	 * @return
	 */
	public static String resolve(URI uriPath, URI currentURI) {
		return currentURI == null ? "" : currentURI.deresolve(uriPath).toString();
	}

	/**
	 * Get all the controled resource in the Model Set with the corresponding url
	 * 
	 * @param set
	 * @param url
	 * @return a list of ControledResource
	 */
	public static List<ControledResource> getControledResourcesForURL(ModelSet set, String url) {
		if(url == null || set == null) {
			return Collections.emptyList();
		}
		List<ControledResource> result = new LinkedList<ControledResource>();
		for(Resource r : set.getResources()) {
			if(SashModel.MODEL_FILE_EXTENSION.equals(r.getURI().fileExtension())) {
				for(EObject e : r.getContents()) {
					if(e instanceof ControledResource) {
						addControled(url, (ControledResource)e, result);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Add to the result list the found controledResource corresponding to the given url
	 * 
	 * @param url
	 *        , the searched url
	 * @param controled
	 *        , the controled resource to start with
	 * @param result
	 *        , the list to fill
	 */
	private static void addControled(String url, ControledResource controled, List<ControledResource> result) {
		if(url != null && url.equals(controled.getResourceURL())) {
			result.add(controled);
		}
		for(ControledResource c : controled.getChildren()) {
			addControled(url, c, result);
		}
	}
}
