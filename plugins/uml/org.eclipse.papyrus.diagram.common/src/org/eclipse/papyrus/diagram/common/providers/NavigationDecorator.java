/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigationHelper;
import org.eclipse.papyrus.core.navigation.NavigableElement.NavigationType;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.diagram.common.draw2d.ManuallyDrawnShortcutDecorationFigure;


public class NavigationDecorator extends AbstractDecorator implements Adapter {

	private Set<Resource> listenedNotationResources = new HashSet<Resource>();

	private ManuallyDrawnShortcutDecorationFigure shortcutFigure = new ManuallyDrawnShortcutDecorationFigure();

	private IGraphicalEditPart gep = null;

	public NavigationDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		shortcutFigure.setVisible(false);
	}

	@Override
	public void deactivate() {
		removeListenerFromAllResources();
		super.deactivate();
	}

	public void activate() {
		EditPart editPart = (EditPart)getDecoratorTarget().getAdapter(EditPart.class);
		if(editPart instanceof IGraphicalEditPart) {
			gep = (IGraphicalEditPart)editPart;


			if(editPart instanceof ShapeEditPart) {
				setDecoration(getDecoratorTarget().addShapeDecoration(shortcutFigure, IDecoratorTarget.Direction.NORTH_EAST, 0, false));
			} else if(editPart instanceof ConnectionEditPart) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(shortcutFigure, 20, false));
			}
		}
		refresh();
	}

	public void refresh() {
		if (gep != null) {
			View view = gep.getNotationView();
			EObject element = gep.resolveSemanticElement();

			Diagram currentDiagram = null;
			if(view != null) {
				currentDiagram = view.getDiagram();
			}

			boolean structuralNavigable = false;
			boolean behavioralNavigable = false;

			removeListenerFromAllResources();
			List<NavigableElement> navElements = NavigationHelper.getInstance().getAllNavigableElements(element);

			for(NavigableElement navElement : navElements) {
				if(navElement instanceof ExistingNavigableElement) {
					EObject eObj = navElement.getElement();
					Resource res = eObj.eResource();
					if (res != null && res.getResourceSet() instanceof DiResourceSet) {
						DiResourceSet diResourceSet = (DiResourceSet)res.getResourceSet();

						addResourceListener(diResourceSet.getAssociatedNotationResource(eObj));

						List<Diagram> associatedDiagrams = DiagramsUtil.getAssociatedDiagrams(eObj, diResourceSet);

						if(associatedDiagrams != null) {
							for(Diagram diag : associatedDiagrams) {
								addResourceListener(diag.eResource());
								if(!diag.equals(currentDiagram)) {
									if(NavigationType.BEHAVIORAL.equals(navElement.getNavigationType())) {
										behavioralNavigable = true;
									} else {
										structuralNavigable = true;
									}
								}
							}
						}
					}
				}
			}

			if(!structuralNavigable && !behavioralNavigable) {
				shortcutFigure.setVisible(false);
			} else {
				shortcutFigure.setVisible(true);
				if (structuralNavigable && behavioralNavigable) {
					shortcutFigure.setBackgroundColor(ColorConstants.white);
				} else if(structuralNavigable) {
					shortcutFigure.setBackgroundColor(ColorConstants.lightGreen);
				} else {
					shortcutFigure.setBackgroundColor(ColorConstants.lightBlue);
				}
			}
		}
	}

	private void addResourceListener(Resource r) {
		synchronized(listenedNotationResources) {
			if(listenedNotationResources.add(r)) {
				r.eAdapters().add(this);
			}
		}
	}

	private void removeListenerFromAllResources() {
		synchronized(listenedNotationResources) {
			for(Resource r : listenedNotationResources) {
				r.eAdapters().remove(this);
			}
			listenedNotationResources.clear();
		}
	}

	public void notifyChanged(Notification notification) {
		if(!notification.isTouch() && notification.getFeatureID(Resource.class) == Resource.RESOURCE__CONTENTS) {
			refresh();
		}
	}

	Notifier notifier;

	public Notifier getTarget() {
		return notifier;
	}

	public void setTarget(Notifier newTarget) {
		notifier = newTarget;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

}
