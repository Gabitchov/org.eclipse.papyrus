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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmt.modisco.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.validation.ValidationTool;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * the label provider that inherits of modisco label provider
 * 
 */
public class MoDiscoLabelProvider extends CustomizableModelLabelProvider {
		
	private IPageIconsRegistry editorRegistry;

	public MoDiscoLabelProvider() {
		super(Activator.getDefault().getCustomizationManager());
	}

	
	public String getMarkerMessage(Object element) {
		
		ValidationTool vt = new ValidationTool (element);
		IMarker markers[] = vt.getMarkers();
		if (markers != null) {
			boolean examineChilds = true;
			String message = "";
			for (IMarker marker : markers) {
				EObject eObjectOfMarker = vt.eObjectOfMarker(marker);
				if (eObjectOfMarker == vt.getEObject()) {
					if (message.length() > 0) {
						message += "\n";
					}
					// vt.getWrappedMessage (marker);
					try {
						message += "- " + WordUtils.wrap ((String) marker.getAttribute(IMarker.MESSAGE), 100, "\n  ", true);
					}
					catch (CoreException e) {
					}
				}
				if (examineChilds) {
					eObjectOfMarker = eObjectOfMarker.eContainer();
					while (eObjectOfMarker != null) {
						if (eObjectOfMarker == vt.getEObject ()) {
							if (message.length() > 0) {
								message += "\n";
							}
							message += "- Problem marker in (at least) one of the children";
							examineChilds = false;
							break;
						}
						// navigate to parents, since parent folder is contaminated as well
						eObjectOfMarker = eObjectOfMarker.eContainer();
					}
				}
			}
			return (message.length() > 0) ? message : null; 
		}
		return null;
	}
	
	// A virer (??)
	@Override
	/**
	 * return the image of an element in the model browser
	 * evaluates error markers.
	 */
	public Image getImage(Object element) {
	      
		ValidationTool vt = new ValidationTool (element);
		vt.tryChildIfEmpty();
		int severity = 0;
		IMarker markers[] = vt.getMarkers();
		if (markers != null) {
			for (IMarker marker : markers) {
				EObject eObjectOfMarker = vt.eObjectOfMarker(marker);
				while (eObjectOfMarker != null) {
					if (eObjectOfMarker == vt.getEObject()) {
						try {
							Integer severityI = (Integer) marker.getAttribute(IMarker.SEVERITY);
							if (severityI.intValue () > severity) {
								severity = severityI.intValue();
							}
						}
						catch (CoreException e) {
						}
					}
					// navigate to parents, since parent folder is contaminated as well
					eObjectOfMarker = eObjectOfMarker.eContainer();
				}
			}
		}
		if(element instanceof Diagram) {
			return getDecoratedImage (getEditorRegistry().getEditorIcon(element), severity);
		}
		
		return getDecoratedImage (super.getImage(element), severity);
	}

	/**
	 * Return a DecoratedImage, thanks to Torkild U. Resheim (Trondheim, Norway)
	 * @param registry
	 * @param baseImageId
	 * @param status
	 * @return
	 */
	private Image getDecoratedImage(Image baseImage, int severity) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();		
		ImageDescriptor overlay = null;
		switch (severity) {
			case IMarker.SEVERITY_ERROR:
				overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_ERROR);
				break;
			case IMarker.SEVERITY_WARNING:
				overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING);
				break;
			default:
				return baseImage;
		}
		// Construct a new image identifier
		String decoratedImageId = baseImage.toString().concat(String.valueOf(severity));
		// Return the stored image if we have one
		if (registry.get(decoratedImageId) == null) {
			// Otherwise create a new image and store it
			DecorationOverlayIcon decoratedImage = new DecorationOverlayIcon(
				baseImage, new ImageDescriptor[] { null, null, null,
					overlay, null }, size16) {
			};
			registry.put(decoratedImageId, decoratedImage);
		}
		return registry.get(decoratedImageId);
	}
	
	private static final Point size16  = new Point (16, 16);
	
	private static final ImageRegistry registry = new ImageRegistry ();
	
	/**
	 * Get the EditorRegistry used to create editor instances. This default
	 * implementation return the singleton eINSTANCE. This method can be
	 * subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 * @throws ServiceException
	 */
	protected IPageIconsRegistry getEditorRegistry() {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * @throws ServiceException
	 */
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			return EditorUtils.getServiceRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// Not found, return an empty one which return null for each
			// request.
			return new PageIconsRegistry();
		}
	}

	/**
	 * @see org.eclipse.gmt.modisco.infra.browser.uicore.CustomizableModelLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		String text = null;
		if(element instanceof Diagram) {
			Diagram diagram = (Diagram)element;
			text = diagram.getName();
		} else if(element instanceof IAdaptable) {
			EObject obj = (EObject)((IAdaptable)element).getAdapter(EObject.class);
			if(obj.eIsProxy()) {
				InternalEObject internal = (InternalEObject)obj;
				text = "unreachable " + obj.getClass().getSimpleName() + " in " + internal.eProxyURI().trimFragment();;
			} else {
				text = super.getText(element);
			}
		} else {
			text = super.getText(element);
		}
		return text;
	}	
}
