/*
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Ansgar Radermacher (CEA LIST) - added support for EMF validation
 *    	bug fix and re-factoring (separating common class)
 *      specific version for Papyrus
 */
 package org.eclipse.papyrus.diagram.common.providers;

import static org.eclipse.papyrus.core.Activator.log;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.validation.ValidationUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Generic validation decorator provider (for the case application == null)
 */
public abstract class ValidationDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	protected static final String KEY = "validationStatus";  //$NON-NLS-1$
	
	/**
	 * generic marker for GMF validation (currently not used)
	 */
	private static final String MARKER_TYPE = "org.eclipse.papyrus.diagram.common.diagnostic"; //$NON-NLS-1$

	/**
	 * global map of fileObserver par editing domain
	 */
	private static Map<TransactionalEditingDomain, MarkerObserver> fileObservers = new HashMap<TransactionalEditingDomain, MarkerObserver>();

	private static Map<String, IDecorator> allDecorators = new HashMap<String, IDecorator> ();

	/**
	 * Refined by generated class
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 *
	 * @param decoratorTarget
	 */
	public abstract void createDecorators (IDecoratorTarget decoratorTarget);

	/**
	 * Refined by generated class
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 *
	 * @param operation
	 * @return
	 */
	public abstract boolean provides(IOperation operation);

	/**
	 * Refresh the decorators of a specific view
	 * @param view
	 */
	public static void refreshDecorators(View view) {
		refreshDecorators(ViewUtil.getIdStr(view), TransactionUtil.getEditingDomain(view));
	}

	/**
	 * Refresh the decorators of a specific view
	 */
	private static void refreshDecorators(String viewId, final TransactionalEditingDomain domain) {
		final IDecorator decorator = viewId != null ? allDecorators.get(viewId) : null;
		if (decorator == null || domain == null) {
			return;
		}
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			public void run() {
				try {
					domain.runExclusive(new Runnable() {

						public void run() {
							decorator.refresh();
						}
					});
				} catch (Exception e) {
					log.error("Decorator refresh failure", e); //$NON-NLS-1$
				}
			}
		});
	}

	public static class StatusDecorator extends AbstractDecorator {

		/**
		 * The ID of the view
		 */
		private String viewId;

		/**
		 * @generated
		 */
		public StatusDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			try {
				final View view = (View)getDecoratorTarget().getAdapter(View.class);
				TransactionUtil.getEditingDomain(view).runExclusive(new Runnable() {

					public void run() {
						StatusDecorator.this.viewId = view != null ? ViewUtil.getIdStr(view) : null;
					}
				});
			} catch (Exception e) {
				log.error("ViewID access failure", e); //$NON-NLS-1$			
			}
		}

		/**
		 * Refresh the decorators of a view
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#refresh()
		 */
		public void refresh() {
			removeDecoration();
			View view = (View)getDecoratorTarget().getAdapter(View.class);
			if(view == null || view.eResource() == null) {
				return;
			}
			EditPart editPart = (EditPart)getDecoratorTarget().getAdapter(EditPart.class);
			if(editPart == null || editPart.getViewer() == null) {
				return;
			}

			// query for all the validation markers of the current resource
			String elementId = ViewUtil.getIdStr(view);
			if(elementId == null) {
				return;
			}
			int severity = IMarker.SEVERITY_INFO;
			IMarker foundMarker = null;
			IResource gmfResource = WorkspaceSynchronizer.getFile(view.eResource());
			if(gmfResource == null || !gmfResource.exists()) {
				return;
			}
			IResource emfResource = null;
			if(view.getElement() != null) {
				emfResource = WorkspaceSynchronizer.getFile(view.getElement().eResource());
				// allow emfResource being empty, since there might be gmf views without an EObject behind;
			}

			IMarker[] gmfMarkers = null;
			IMarker[] emfMarkers = new IMarker[0];
			try {
				gmfMarkers = gmfResource.findMarkers(MARKER_TYPE, true, IResource.DEPTH_INFINITE);
				if(emfResource != null) {
					emfMarkers = emfResource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				}
			} catch (CoreException e) {
				log.error("Validation markers refresh failure", e); //$NON-NLS-1$
			}
			if(gmfMarkers == null) {
				// indicates an exception, findMarkers returns an empty array, if there are no markers
				return;
			}
			Label toolTip = null;
			// look for GMF markers
			for(int i = 0; i < gmfMarkers.length + emfMarkers.length; i++) {
				IMarker marker;
				boolean markerIsForMe = false;
				if(i < gmfMarkers.length) {
					// get marker from GMF list
					marker = gmfMarkers[i];
					String attribute = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, ""); //$NON-NLS-1$
					markerIsForMe = attribute.equals(elementId);
				} else {
					// get marker from EMF list
					marker = emfMarkers[i - gmfMarkers.length];
					EObject eObjectOfMarker = ValidationUtils.eObjectFromMarkerOrMap(marker, null, TransactionUtil.getEditingDomain(view));
					markerIsForMe = (eObjectOfMarker == view.getElement());
				}
				if(markerIsForMe) {
					int nextSeverity = marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
					Image nextImage = getImage(nextSeverity);
					if(foundMarker == null) {
						foundMarker = marker;
						toolTip = new Label(marker.getAttribute(IMarker.MESSAGE, ""), //$NON-NLS-1$
						nextImage);
					} else {
						if(toolTip.getChildren().isEmpty()) {
							Label comositeLabel = new Label();
							FlowLayout fl = new FlowLayout(false);
							fl.setMinorSpacing(0);
							comositeLabel.setLayoutManager(fl);
							comositeLabel.add(toolTip);
							toolTip = comositeLabel;
						}
						toolTip.add(new Label(marker.getAttribute(IMarker.MESSAGE, ""), //$NON-NLS-1$
						nextImage));
					}
					severity = (nextSeverity > severity) ? nextSeverity : severity;
				}
			}
			if(foundMarker == null) {
				return;
			}

			// add decoration
			if(editPart instanceof org.eclipse.gef.GraphicalEditPart) {
				if(view instanceof Edge) {
					setDecoration(getDecoratorTarget().addConnectionDecoration(getImage(severity), 50, true));
				} else {
					int margin = -1;
					if(editPart instanceof org.eclipse.gef.GraphicalEditPart) {
						margin = MapModeUtil.getMapMode(((org.eclipse.gef.GraphicalEditPart)editPart).getFigure()).DPtoLP(margin);
					}
					setDecoration(getDecoratorTarget().addShapeDecoration(getImage(severity), IDecoratorTarget.Direction.NORTH_EAST, margin, true));
				}
				getDecoration().setToolTip(toolTip);
			}
		}

		
		/**
		 * Get the image for a given severity
		 * @param severity
		 * @return
		 */
		private Image getImage(int severity) {
			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch(severity) {
			case IMarker.SEVERITY_ERROR:
				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case IMarker.SEVERITY_WARNING:
				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			default:
				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageName);
		}

		/**
		 * activate the decorators of this view.
		 * Register a listener for editing domain of the view
		 */
		public void activate() {
			if(viewId == null) {
				return;
			}

			// add self to global decorators registry
			IDecorator decorator = allDecorators.get(viewId);
			if (decorator == null) {
				allDecorators.put(viewId, this);
			}
		
			// start listening to changes in resources
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if(view == null) {
				return;
			}
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(view);
			if(domain == null) {
				return;
			}
			// stop listening to changes in resources if there are no more decorators
			MarkerObserver fileObserver = fileObservers.get(domain);
			if (fileObserver == null) {
				fileObserver = new MarkerObserver(domain);
				fileObservers.put(domain, fileObserver);
				FileChangeManager.getInstance().addFileObserver(fileObserver);
			}
			if (!fileObserver.views.contains(view)) {
				fileObserver.views.add(view); 
			}
		}

		/**
		 * deactivate the decorators of this view
		 */
		public void deactivate() {
			if(viewId == null) {
				return;
			}

			// remove self from global decorators registry
			allDecorators.remove(viewId);
			
			View view = (View)getDecoratorTarget().getAdapter(View.class);
			if(view == null) {
				return;
			}
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(view);
			if(domain == null) {
				return;
			}

			// stop listening to changes in resources if there are no more decorators
			MarkerObserver fileObserver = fileObservers.get(domain);
			if (fileObserver != null) {
				fileObserver.views.remove(view);
				if (fileObserver.views.isEmpty()) {
					// no more views registered for the listener => remove observer
					FileChangeManager.getInstance().removeFileObserver(fileObserver);
					fileObservers.remove(domain);
				}
			}

			super.deactivate();
		}
	}

	/**
	 * @generated
	 */
	static class MarkerObserver implements IFileObserver {

		/**
		 * store editing domain
		 */
		private TransactionalEditingDomain domain;

		/**
		 * store a list of all views for which the observer is responsible
		 */
		private EList<View> views = new BasicEList<View>();
	
		/**
		 * Constructor.
		 *
		 * @param domain
		 */
		private MarkerObserver(TransactionalEditingDomain domain) {
			this.domain = domain;
		}

		/**
		 * handle changes of file name
		 */
		public void handleFileRenamed(IFile oldFile, IFile file) {
		}

		public void handleFileMoved(IFile oldFile, IFile file) {
		}

		public void handleFileDeleted(IFile file) {
		}

		public void handleFileChanged(IFile file) {
		}

		/**
		 * A marker has been added, treat as change
		 */
		public void handleMarkerAdded(IMarker marker) {
			handleMarkerChanged(marker);
		}

		/**
		 * A marker has been deleted. Need to treat separately from change, since old values are not stored in
		 * marker, but in attribute map
		 */
		public void handleMarkerDeleted(IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {
			String viewId = (String)attributes.get(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID);
			if(viewId != null) {
				refreshDecorators(viewId, domain);
			} else {
				// no viewID => assume EMF validation marker
				EObject eObjectFromMarker = ValidationUtils.eObjectFromMarkerOrMap(null, attributes, domain);

				if(eObjectFromMarker != null) {
					// loop over all views that reference the eObject from the marker
					for(View view : CrossReferencerUtil.getCrossReferencingViews(eObjectFromMarker, null)) {
						refreshDecorators(view);
					}
				}
			}
		}

		/**
		 * A marker has changed
		 */
		public void handleMarkerChanged(IMarker marker) {
			try {
				if(getType(marker).equals(MARKER_TYPE)) {
					String viewId = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, ""); //$NON-NLS-1$
					refreshDecorators(viewId, domain);
				} else if(marker.isSubtypeOf((EValidator.MARKER))) {
					EObject eObjectFromMarker = ValidationUtils.eObjectFromMarkerOrMap(marker, null, domain);

					if(eObjectFromMarker != null) {
						// loop over all views that reference the eObject from the marker
						for(View view : CrossReferencerUtil.getCrossReferencingViews(eObjectFromMarker, null)) {
							refreshDecorators(view);
						}
					}
				}
			} catch (CoreException e) {
				// only reason: marker does not exist (ignore, should not happen)
			}
		}

		/**
		 * Return the type of a marker
		 */
		private String getType(IMarker marker) {
			try {
				return marker.getType();
			} catch (CoreException e) {
				log.error("Validation marker refresh failure", e); //$NON-NLS-1$
				return ""; //$NON-NLS-1$
			}
		}
	}
}
