/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.navigation.editpolicy;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.services.navigation.service.NavigableElement;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationService;
import org.eclipse.papyrus.infra.widgets.editors.SelectionMenu;
import org.eclipse.papyrus.views.modelexplorer.Activator;

/**
 * An edit policy to use the {@link NavigationService} on GMF Diagrams
 * 
 * @author Camille Letavernier
 * 
 */
public class NavigationEditPolicy extends GraphicalEditPolicy {

	public static final String EDIT_POLICY_ID = "org.eclipse.papyrus.infra.gmfdiag.navigation.NavigationEditPolicy";

	private ViewerContext viewerContext;

	@Override
	public void activate() {
		super.activate();
		initViewerContext();

		if(viewerContext == null) {
			return;
		}
	}

	private void initViewerContext() {
		if(getHost() == getRoot()) {
			EditPartViewer viewer = getHost().getViewer();
			viewerContext = new ViewerContext(viewer);
		} else {
			EditPolicy rootNavigationEditPolicy = getRoot().getEditPolicy(EDIT_POLICY_ID);
			if(rootNavigationEditPolicy instanceof NavigationEditPolicy) {
				this.viewerContext = ((NavigationEditPolicy)rootNavigationEditPolicy).viewerContext;
			}
		}
	}

	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);

		//Do not install navigation on the root
		if(getRoot() == getHost()) {
			return;
		}

		if(request instanceof SelectionRequest) {
			SelectionRequest selectionRequest = (SelectionRequest)request;
			viewerContext.handleRequest(selectionRequest);
		}
	}

	@Override
	public Command getCommand(Request request) {
		if(request instanceof SelectionRequest) {
			return viewerContext.navigate((SelectionRequest)request);
		}
		return super.getCommand(request);
	}

	private EditPart getRoot() {
		RootEditPart rootEditPart = getHost().getRoot();
		return rootEditPart.getContents();
	}

	//A Single ViewerContext for each diagram (Root EditPartViewer)
	private class ViewerContext {

		private EditPartViewer editPartViewer;

		private EObject currentModel;

		private SelectionMenu selectionMenu;

		private boolean wasUnderlined;

		private WrappingLabel lastWrappingLabel;

		public void handleRequest(SelectionRequest request) {
			if(isExitState(request)) {
				exitItem();
			}

			if(isEnterState(request)) {
				enterItem(currentModel, request);
			}
		}

		public Command navigate(final SelectionRequest request) {
			if(!isAlt(request)) {
				return null;
			}

			final NavigableElement element = getElementToNavigate(request);
			if(element == null) {
				return null;
			}

			return new Command() {

				@Override
				public void execute() {
					try {
						getNavigationService(request).navigate(element);
					} catch (ServiceException ex) {
						Activator.log.error(ex);
					}
					exitItem();
				}
			};
		}

		private NavigableElement getElementToNavigate(SelectionRequest request) {
			try {
				List<NavigableElement> navigableElements = getNavigationService(request).getNavigableElements(getEditPart(request));
				if(navigableElements.isEmpty()) {
					return null;
				}

				for(NavigableElement element : navigableElements) {
					if(element.isEnabled()) {
						return element;
					}
				}
			} catch (ServiceException ex) {
				//Ignore: the service is not available, do nothing
			}
			return null;
		}

		private NavigationService getNavigationService(SelectionRequest request) throws ServiceException {
			return getServicesRegistry().getService(NavigationService.class);
		}

		public ViewerContext(EditPartViewer editPartViewer) {
			this.editPartViewer = editPartViewer;
		}

		private boolean isExitState(SelectionRequest request) {
			if(currentModel == null) {
				return false;
			}

			EObject newModel = getModel(request);
			if(newModel == null) {
				return true;
			}

			if(newModel != currentModel) {
				return true;
			}

			if(!isAlt(request)) {
				return true;
			}

			return false;
		}

		private boolean isEnterState(SelectionRequest request) {
			EObject model = getModel(request);
			if(model == currentModel) {
				return false;
			}

			if(model == null) {
				return false;
			}

			if(!isAlt(request)) {
				return false;
			}

			currentModel = model;

			return true;
		}

		private boolean isAlt(SelectionRequest request) {
			return request.isAltKeyPressed();
		}

		private EObject getModel(SelectionRequest request) {
			return EMFHelper.getEObject(getEditPart(request));

		}

		private EditPart getEditPart(SelectionRequest request) {
			return editPartViewer.findObjectAt(request.getLocation());
		}

		private void disposeCurrentMenu() {
			if(selectionMenu != null) {
				selectionMenu.dispose();
				selectionMenu = null;
			}
		}

		private void exitItem() {
			if(lastWrappingLabel != null) {
				lastWrappingLabel.setTextUnderline(wasUnderlined);
			}
			wasUnderlined = false;
			lastWrappingLabel = null;
			currentModel = null;
			disposeCurrentMenu();
		}

		private void enterItem(EObject model, SelectionRequest request) {
			try {
				EditPart targetEditPart = getEditPart(request);

				final NavigationService navigation = getServicesRegistry().getService(NavigationService.class);
				disposeCurrentMenu();
				selectionMenu = navigation.createNavigationList(targetEditPart, editPartViewer.getControl());
				if(selectionMenu == null) {
					return;
				}

				wasUnderlined = false;
				if(targetEditPart instanceof IGraphicalEditPart) {
					IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)targetEditPart;
					IFigure figure = graphicalEditPart.getFigure();
					if(figure instanceof WrappingLabel) {
						lastWrappingLabel = ((WrappingLabel)figure);
						wasUnderlined = lastWrappingLabel.isTextUnderlined();
						lastWrappingLabel.setTextUnderline(!wasUnderlined);
					}
				}

				selectionMenu.addSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						if(event.getSelection().isEmpty()) {
							return;
						}
						Object selectedElement = ((IStructuredSelection)event.getSelection()).getFirstElement();
						if(selectedElement instanceof NavigableElement) {
							NavigableElement navigableElement = (NavigableElement)selectedElement;
							navigate(navigableElement, navigation);
						}
					}
				});
			} catch (ServiceException ex) {
				Activator.log.error(ex);
			}
		}

		private void navigate(NavigableElement navigableElement, NavigationService navigationService) {
			navigationService.navigate(navigableElement);
			exitItem();
		}

		private ServicesRegistry getServicesRegistry() throws ServiceException {
			return ServiceUtilsForEditPart.getInstance().getServiceRegistry(getHost());
		}

	}
}
