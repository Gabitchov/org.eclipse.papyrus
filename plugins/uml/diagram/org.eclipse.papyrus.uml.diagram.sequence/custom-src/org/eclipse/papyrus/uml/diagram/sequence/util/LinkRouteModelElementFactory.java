/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.emf.databinding.AnnotationObservableValue;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.AnnotationModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;

public class LinkRouteModelElementFactory implements ModelElementFactory {

	public static final String STYLE = "style";

	public static final String ROUTING = "routing";

	public static final String MANUAL = "Manual";

	public static final String AUTOMATIC = "Automatic";

	public static final Map<Object, LinkRouteModelElement> elements = new HashMap<Object, LinkRouteModelElement>();

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		View view = NotationHelper.findView(sourceElement);
		if(view != null && view instanceof Edge) {
			EditingDomain domain = EMFHelper.resolveEditingDomain(view);
			LinkRouteModelElement m = new LinkRouteModelElement((Edge)view, domain);
			elements.put(view, m);
			return m;
		}
		return null;
	}

	public static LinkRouteModelElement getElement(Object sourceElement) {
		if(elements.get(sourceElement) == null) {
			View view = NotationHelper.findView(sourceElement);
			EditingDomain domain = EMFHelper.resolveEditingDomain(view);
			LinkRouteModelElement m = new LinkRouteModelElement((Edge)view, domain);
			elements.put(view, m);
		}
		return elements.get(sourceElement);
	}

	public static boolean isRoutingNotification(Notification event) {
		if(event.getNewValue() instanceof EAnnotation && LinkRouteModelElementFactory.ROUTING.equals(((EAnnotation)event.getNewValue()).getSource())) {
			return true;
		}
		return false;
	}

	public static String getRoutingStyle(View view) {
		EAnnotation ea = view.getEAnnotation(ROUTING);
		if(ea != null && ea.getDetails().containsKey(STYLE)) {
			return ea.getDetails().get(STYLE);
		}
		return AUTOMATIC;
	}

	public static boolean isAutomaticRouting(View view) {
		return AUTOMATIC.equalsIgnoreCase(getRoutingStyle(view));
	}

	public static void switchToManualRouting(View edge) {
		if(LinkRouteModelElementFactory.isAutomaticRouting(edge)) {
			LinkRouteModelElement element = LinkRouteModelElementFactory.getElement(edge);
			AnnotationObservableValue observable = (AnnotationObservableValue)element.getObservable(STYLE);
			observable.setValue(LinkRouteModelElementFactory.MANUAL);
		}
	}

	public static class LinkRouteModelElement extends AnnotationModelElement {

		public LinkRouteModelElement(Edge source, EditingDomain domain) {
			super(source, domain, ROUTING);
		}

		public IStaticContentProvider getContentProvider(String propertyPath) {
			if(propertyPath.equals(STYLE)) {
				return new AbstractStaticContentProvider() {

					public Object[] getElements() {
						return new String[]{ AUTOMATIC, MANUAL };
					}

				};
			}
			return EmptyContentProvider.instance;
		}

		public ILabelProvider getLabelProvider(String propertyPath) {
			return new org.eclipse.jface.viewers.LabelProvider();
		}

		public IObservable doGetObservable(String propertyPath) {
			return new AnnotationObservableValue(source, domain, ROUTING, STYLE) {

				@Override
				protected Command getCommand(final Object value) {
					return new CreateEAnnotationCommand((TransactionalEditingDomain)domain, source, ROUTING) {

						@Override
						protected void doExecute() {
							EAnnotation annotation = createEAnnotation();
							replaceEannotation(annotation, getObject());
							replaceEntry(annotation, STYLE, value == null ? "" : value.toString());
						}
					};
				}

				@Override
				protected Object doGetValue() {
					Object value = super.doGetValue();
					if(value == null) {
						return AUTOMATIC;
					}
					return value;
				}

				@Override
				protected void doSetValue(Object value) {
					Object oldValue = doGetValue();

					Command emfCommand = getCommand(value);
					if(emfCommand != null) {
						domain.getCommandStack().execute(emfCommand);
					}
					ValueDiff createValueDiff = Diffs.createValueDiff(oldValue, value);
					fireValueChange(createValueDiff);
				}
			};
		}

		@Override
		public boolean forceRefresh(String propertyPath) {
			return true;
		}
	}
}
