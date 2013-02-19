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
 *      Amine EL KOUHEN (CEA LIST) - Added decoration Service
 */
package org.eclipse.papyrus.uml.diagram.common.providers;

import static org.eclipse.papyrus.uml.diagram.common.Activator.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.decoration.DecorationChange;
import org.eclipse.papyrus.infra.services.decoration.DecorationChange.DecorationChangeKind;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF;
import org.eclipse.ui.PlatformUI;

/**
 * Generic validation decorator provider (for the case application == null)
 */
public abstract class ValidationDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	protected static final String KEY = "validationStatus"; //$NON-NLS-1$

	private static Map<String, IDecorator> allDecorators = new HashMap<String, IDecorator>();

	/**
	 * Refined by generated class
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 * 
	 * @param decoratorTarget
	 */
	public abstract void createDecorators(IDecoratorTarget decoratorTarget);

	/**
	 * Refined by generated class
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 * 
	 * @param operation
	 * @return
	 */
	public abstract boolean provides(IOperation operation);

	/**
	 * Refresh the decorators of a specific view
	 * 
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
		if(decorator == null || domain == null) {
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

	public static class StatusDecorator extends AbstractDecorator implements Observer {

		/**
		 * The ID of the view
		 */
		private String viewId;

		/**
		 * Store a copy of the editingDomain;
		 */
		private TransactionalEditingDomain editingDomain;

		/**
		 * Decoration Service (there is a unique instance of this service, use static variable)
		 */
		private static DecorationService decorationService;

		private Object element;

		/**
		 * Diagram Decorator
		 */
		private final DiagramDecorationAdapter diagramDecorationAdapter;

		/**
		 * @generated
		 */
		public StatusDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			diagramDecorationAdapter = new DiagramDecorationAdapter(decoratorTarget);
			try {
				final View view = (View)getDecoratorTarget().getAdapter(View.class);
				element = view.getElement();
				EditPart editPart = (EditPart)getDecoratorTarget().getAdapter(EditPart.class);
				IDiagramEditDomain domain = (IDiagramEditDomain)editPart.getViewer().getEditDomain();
				ServicesRegistry serviceRegistry = ServiceUtilsForGMF.getInstance().getServiceRegistry(domain);
				decorationService = serviceRegistry.getService(DecorationService.class);
				//Register As an Decoration service customer
				decorationService.addListener(this);
				TransactionUtil.getEditingDomain(view).runExclusive(new Runnable() {

					public void run() {
						StatusDecorator.this.viewId = view != null ? ViewUtil.getIdStr(view) : null;
						StatusDecorator.this.editingDomain = TransactionUtil.getEditingDomain(view);
					}
				});
			} catch (Exception e) {
				log.error("ViewID access failure", e); //$NON-NLS-1$
			}
		}

		/**
		 * Completely refresh the decorators of a view
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#refresh()
		 */
		public void refresh() {
			View view = (View)getDecoratorTarget().getAdapter(View.class);
			if(view == null || view.eResource() == null) {
				return;
			}
			if(view.getElement() != null) {
				diagramDecorationAdapter.removeDecorations();
				List<IPapyrusDecoration> decorations = decorationService.getDecorations(view.getElement(), false);
				if(view instanceof Edge) {
					diagramDecorationAdapter.setDecorationsEdge(decorations, 50, true);
				}
				else {
					diagramDecorationAdapter.setDecorationsNode(decorations, 0, true);
				}
			}
		}

		/**
		 * Refresh the decorators of a view when given a DecorationChange information.
		 * 
		 * @param change
		 *        A decoration change, e.g. addition or removal
		 */
		public void refresh(DecorationChange change) {

			if(change.getChangeKind() == DecorationChangeKind.DecorationRemoved ||
				change.getChangeKind() == DecorationChangeKind.RefreshAll) {
				// always recreate all decorations, in case of a deletion (would require recalculation of positions) or
				// if all decorations should be refreshed
				refresh();
				return;
			}
			View view = (View)getDecoratorTarget().getAdapter(View.class);
			if(view == null || view.eResource() == null) {
				return;
			}
			if(view instanceof Edge) {
				// always recreate all decorations for an edge (since the position of all changes, if one is added or removed)
				refresh();
				return;
			}
			// add decoration
			if(view.getElement() != null) {
				if(change.getChangeKind() == DecorationChangeKind.DecorationAdded) {
					diagramDecorationAdapter.addDecorationNode(change.getDecoration(), -1, true);
				}
			}
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
			if(decorator == null) {
				allDecorators.put(viewId, this);
			}
		}

		/**
		 * deactivate the decorators of this view
		 */
		@Override
		public void deactivate() {
			if(viewId == null) {
				return;
			}

			diagramDecorationAdapter.removeDecorations();
			decorationService.deleteListener(this);
			// remove self from global decorators registry
			allDecorators.remove(viewId);

			View view = (View)getDecoratorTarget().getAdapter(View.class);
			if((view == null) || (editingDomain == null)) {
				// should not happen
				super.deactivate();
				return;
			}
			super.deactivate();
		}

		//Refresh when the decoration service add a decoration
		public void update(Observable o, Object arg) {
			// check whether update is for this view
			if(arg instanceof DecorationChange) {
				DecorationChange change = (DecorationChange)arg;
				if((change.getChangeKind() == DecorationChangeKind.RefreshAll) ||
					(change.getDecoration().getElement() == element)) {
					refresh(change);
				}
			}
		}
	}

}
