/*****************************************************************************
 * Copyright (c) 2010-2011 Atos Origin.
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
package org.eclipse.papyrus.infra.gmfdiag.navigation.decorator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
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
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.DiagramsUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigableElement;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigationHelper;
import org.eclipse.papyrus.infra.gmfdiag.navigation.preference.INavigationPreferenceConstant;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;
import org.eclipse.papyrus.infra.widgets.toolbox.draw2d.ManuallyDrawnShortcutDecorationFigure;
import org.eclipse.swt.graphics.Color;

public class NavigationDecorator extends AbstractDecorator implements Adapter {

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.gmfdiag.navigation.navigationColorProviders";

	private static final String COLORPROVIDER_ID = "navigationColorProvider";

	private static final String PROVIDER_ID = "provider";

	private static List<IColorProvider> navigationColorProviders = new LinkedList<IColorProvider>();

	static {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for(IConfigurationElement configElement : configElements) {
			if(COLORPROVIDER_ID.equals(configElement.getName())) {
				try {
					Object obj = configElement.createExecutableExtension(PROVIDER_ID);
					if(obj instanceof IColorProvider) {
						navigationColorProviders.add((IColorProvider)obj);
					}
				} catch (CoreException e) {
				}
			}
		}
	}

	private Set<Resource> listenedNotationResources = new HashSet<Resource>();

	private ManuallyDrawnShortcutDecorationFigure shortcutFigure = new ManuallyDrawnShortcutDecorationFigure();

	private IGraphicalEditPart gep = null;

	private boolean displayOnly;

	public NavigationDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		decoratorTarget.installDecorator("navigationDecorator", this);
		shortcutFigure.setVisible(false);

		String decoratorVisibility = Activator.getDefault().getPreferenceStore().getString(INavigationPreferenceConstant.PAPYRUS_NAVIGATION_DECORATOR_VISIBILITY);
		displayOnly = INavigationPreferenceConstant.DISPLAY_ONLY.equals(decoratorVisibility);
	}

	@Override
	public void deactivate() {
		super.deactivate();
		removeListenerFromAllResources();
	}

	public void activate() {
		EditPart editPart = (EditPart)getDecoratorTarget().getAdapter(EditPart.class);
		if(editPart instanceof IGraphicalEditPart) {
			gep = (IGraphicalEditPart)editPart;

			if(editPart instanceof ShapeEditPart) {
				setDecoration(getDecoratorTarget().addShapeDecoration(shortcutFigure, IDecoratorTarget.Direction.NORTH_EAST, -5, displayOnly));
			} else if(editPart instanceof ConnectionEditPart) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(shortcutFigure, 20, displayOnly));
			}
		}
		refresh();
	}

	public void refresh() {
		if(gep != null) {
			View view = gep.getNotationView();
			EObject element = gep.resolveSemanticElement();

			removeListenerFromAllResources();

			Diagram currentDiagram = null;
			if(view != null) {
				currentDiagram = view.getDiagram();
			}

			if(currentDiagram != null) {
				addResourceListener(currentDiagram.eResource());
			}

			List<NavigableElement> navElements = NavigationHelper.getInstance().getAllNavigableElements(element);

			Color shortcutColor = null;

			for(NavigableElement navElement : navElements) {
				if(navElement instanceof ExistingNavigableElement) {
					EObject eObj = navElement.getElement();
					Resource res = eObj.eResource();
					if(res != null && res.getResourceSet() instanceof ModelSet) {
						Resource notationResource = NotationUtils.getNotationResource(((ModelSet)res.getResourceSet()));

						addResourceListener(notationResource);

						List<Diagram> associatedDiagrams = DiagramsUtil.getAssociatedDiagramsFromNotationResource(eObj, notationResource);

						if(associatedDiagrams != null) {
							for(Diagram diag : associatedDiagrams) {
								addResourceListener(diag.eResource());
								if(!diag.equals(currentDiagram)) {
									for(IColorProvider provider : navigationColorProviders) {
										Color color = provider.getBackground(navElement);
										if(color != null) {
											if(shortcutColor == null) {
												shortcutColor = color;
											} else if(!shortcutColor.equals(color)) {
												// more than one color for this
												// element :
												// just use white in this case
												shortcutColor = ColorConstants.white;
											}
											break;
										}
									}
								}
							}
						}
					}
				}
			}

			if(shortcutColor == null) {
				shortcutFigure.setVisible(false);
			} else {
				shortcutFigure.setVisible(true);
				shortcutFigure.setBackgroundColor(shortcutColor);
			}
		}
	}

	private void addResourceListener(Resource r) {
		if(r != null) {
			synchronized(listenedNotationResources) {
				if(listenedNotationResources.add(r)) {
					r.eAdapters().add(this);
				}
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
