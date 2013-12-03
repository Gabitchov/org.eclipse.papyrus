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

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.Util;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.emf.databinding.AnnotationObservableValue;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.AnnotationModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class BehaviorDisplayHelper implements ModelElementFactory {

	private static final String DISPLAY_BEHAVIOR = "displayBehavior";

	/**
	 * @see org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory#createFromSource(java.lang.Object,
	 *      org.eclipse.papyrus.views.properties.contexts.DataContextElement)
	 * 
	 * @param sourceElement
	 * @param context
	 * @return
	 */

	public ModelElement createFromSource(Object sourceElement,
			DataContextElement context) {
		View source = NotationHelper.findView(sourceElement);
		if (source == null) {
			Activator.log
					.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}
		EditingDomain domain = EMFHelper.resolveEditingDomain(source);
		return new AnnotationModelElement(source, domain, DISPLAY_BEHAVIOR) {

			@Override
			public IObservable doGetObservable(String propertyPath) {
				return new BehaviorObservableValue(source, domain,
						DISPLAY_BEHAVIOR, DISPLAY_BEHAVIOR);
			}
		};
	}

	public static Command getChangeDisplayBehaviorCommand(
			TransactionalEditingDomain domain, View source, final Object display) {
		return new CreateEAnnotationCommand(
				(TransactionalEditingDomain) domain, source, DISPLAY_BEHAVIOR) {

			@Override
			protected void doExecute() {
				EAnnotation annotation = createEAnnotation();
				replaceEannotation(annotation, getObject());
				replaceEntry(annotation, DISPLAY_BEHAVIOR, display == null ? ""
						: display.toString());
			}
		};
	}

	public static final boolean isDisplayBehaviorChanged(Notification msg) {
		if (msg == null || !(msg.getNewValue() instanceof EAnnotation)) {
			return false;
		}
		EAnnotation anno = (EAnnotation) msg.getNewValue();
		return DISPLAY_BEHAVIOR.equals(anno.getSource());
	}

	public static final boolean shouldDisplayBehavior(View view) {
		if (view != null) {
			EAnnotation anno = view.getEAnnotation(DISPLAY_BEHAVIOR);
			if (anno != null) {
				return !"false".equalsIgnoreCase(anno.getDetails().get(
						DISPLAY_BEHAVIOR));
			}
		}
		return true;
	}

	private static class BehaviorObservableValue extends
			AnnotationObservableValue {

		private Object cacheValue = "true";
		private Adapter sourceListener;

		public BehaviorObservableValue(EModelElement source,
				EditingDomain domain, String annotationName, String key) {
			super(source, domain, annotationName, key);
			source.eAdapters().add(getSourceListener());
		}

		public Adapter getSourceListener() {
			if (sourceListener == null) {
				sourceListener = new EContentAdapter() {
					@Override
					public void notifyChanged(Notification msg) {
						super.notifyChanged(msg);
						if (msg.getNotifier() instanceof EAnnotation) {
							Object feature = msg.getFeature();
							if (EcorePackage.eINSTANCE.getEAnnotation_Details() == feature
									&& DISPLAY_BEHAVIOR
											.equals(((EAnnotation) msg
													.getNotifier()).getSource())) {
								setValue(shouldDisplayBehavior((View) source));
							}
						}
					}
				};
			}
			return sourceListener;
		}

		@Override
		protected void doSetValue(Object value) {
			Object realValue = doGetValue();
			if (!Util.equals(realValue, value)) {
				source.eAdapters().remove(sourceListener);
				super.doSetValue(value);
				source.eAdapters().add(getSourceListener());
			}
			if (!Util.equals(cacheValue, value)) {
				ValueDiff diff = Diffs.createValueDiff(cacheValue, value);
				fireValueChange(diff);
				cacheValue = value;
			}
		}

		protected Command getCommand(final Object value) {
			return getChangeDisplayBehaviorCommand(
					(TransactionalEditingDomain) domain, (View) source, value);
		}

		@Override
		protected Object doGetValue() {
			Object value = super.doGetValue();
			if (value == null) {
				// By default, return true.
				return "true";
			}
			return value;
		}

		@Override
		public synchronized void dispose() {
			if (source != null) {
				source.eAdapters().remove(sourceListener);
			}
			super.dispose();
		}
	}

}
