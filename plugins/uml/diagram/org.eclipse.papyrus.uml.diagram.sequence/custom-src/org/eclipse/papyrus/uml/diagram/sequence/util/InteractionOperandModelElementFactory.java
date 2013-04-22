/*****************************************************************************
 * Copyright (c) 2010 CEA
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

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.emf.databinding.AnnotationObservableValue;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.preferences.CustomInteractionOperandPreferencePage;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.AnnotationModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;

/**
 * Add the possibility to display or hide the guard of Operand
 * 
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=402966
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class InteractionOperandModelElementFactory implements ModelElementFactory {

	public static final String GUARD_VISIBILITY_KEY = "guard.visibility";

	/**
	 * @see org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory#createFromSource(java.lang.Object,
	 *      org.eclipse.papyrus.views.properties.contexts.DataContextElement)
	 * 
	 * @param sourceElement
	 * @param context
	 * @return
	 */
	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		View source = NotationHelper.findView(sourceElement);
		if(source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}
		EditingDomain domain = EMFHelper.resolveEditingDomain(source);
		return new AnnotationModelElement(source, domain, GUARD_VISIBILITY_KEY) {

			@Override
			public IObservable doGetObservable(String propertyPath) {
				return new AnnotationObservableValue(source, domain, GUARD_VISIBILITY_KEY, GUARD_VISIBILITY_KEY) {

					@Override
					protected Command getCommand(final Object value) {
						return new CreateEAnnotationCommand((TransactionalEditingDomain)domain, source, GUARD_VISIBILITY_KEY) {

							@Override
							protected void doExecute() {
								EAnnotation annotation = createEAnnotation();
								replaceEannotation(annotation, getObject());
								replaceEntry(annotation, GUARD_VISIBILITY_KEY, value == null ? "" : value.toString());
							}
						};
					}

					@Override
					protected Object doGetValue() {
						Object value = super.doGetValue();
						if(value == null) {
							//By default, return preference string value (The converter can not read boolean directly).
							return UMLDiagramEditorPlugin.getInstance().getPreferenceStore().getString(CustomInteractionOperandPreferencePage.GUARD_VISIBILITY);
						}
						return value;
					}
				};
			}
		};
	}

	public static final boolean isGuardVisibilityChanged(Notification msg) {
		if(msg == null || !(msg.getNewValue() instanceof EAnnotation)) {
			return false;
		}
		EAnnotation anno = (EAnnotation)msg.getNewValue();
		return GUARD_VISIBILITY_KEY.equals(anno.getSource());
	}

	public static final boolean isGuardVisible(View view) {
		if(view != null) {
			EAnnotation anno = view.getEAnnotation(GUARD_VISIBILITY_KEY);
			if(anno != null) {
				return "true".equalsIgnoreCase(anno.getDetails().get(GUARD_VISIBILITY_KEY));
			}
		}
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(CustomInteractionOperandPreferencePage.GUARD_VISIBILITY);
	}
}
