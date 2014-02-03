/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.DISPLAY_PLACE;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.HORIZONTAL;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.ICON;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.SHAPE;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.STEREOTYPE_DISPLAY;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.TEXT;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.TEXT_ALIGNMENT;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.TEXT_AND_ICON;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.VERTICAL;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.internal.databinding.Util;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * An IObservableValue for editing the Stereotype appearance properties
 * 
 * @author Camille Letavernier
 */
public class StereotypeAppearanceObservableValue extends AbstractObservableValue {

	/**
	 * The name of the property being observed
	 */
	protected String propertyPath;

	/**
	 * The UML Element being observed
	 */
	protected Element element;

	/**
	 * The Diagram Element associated to the UML Element
	 */
	protected EModelElement diagramElement;

	/**
	 * The EditingDomain on which the commands will be executed
	 */
	protected TransactionalEditingDomain domain;

	/**
	 * Try to synchronize annotation value from model.
	 */
	private Adapter diagramElementListener;

	/**
	 * Cached set value, and fire an event if this value changed.
	 */
	private String cachedValue;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diagramElement
	 *        The Diagram Element associated to the UML Element
	 * @param element
	 *        The UML Element being observed
	 * @param propertyPath
	 *        The name of the property being observed
	 * @param domain
	 *        The EditingDomain on which the commands will be executed.
	 *        This should be a {@link TransactionalEditingDomain}
	 */
	public StereotypeAppearanceObservableValue(EModelElement diagramElement, Element element, String propertyPath, EditingDomain domain) {
		this.propertyPath = propertyPath;
		this.diagramElement = diagramElement;
		this.element = element;
		this.domain = (TransactionalEditingDomain)domain;
		if(diagramElement != null) {
			diagramElement.eAdapters().add(getDiagramElementListener());
		}
	}

	/**
	 * Create a listener for DiagramElement.
	 */
	private Adapter getDiagramElementListener() {
		if(diagramElementListener == null) {
			diagramElementListener = new AdapterImpl() {

				@Override
				public void notifyChanged(Notification msg) {
					if(!msg.isTouch()) {
						handleStereotypeChanged(msg);
					}
				}
			};
		}
		return diagramElementListener;
	}

	/**
	 * Synchronize value from model. So that, the binded UI would be updated.
	 */
	protected void handleStereotypeChanged(Notification msg) {
		setValue(doGetValue());
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		if(propertyPath.equals(STEREOTYPE_DISPLAY)) {
			return getStereotypeDisplayValue();
		} else if(propertyPath.equals(TEXT_ALIGNMENT)) {
			return getTextAlignmentValue();
		} else if(propertyPath.equals(DISPLAY_PLACE)) {
			return getDisplayPlaceValue();
		}

		return null;
	}

	private String getStereotypeDisplayValue() {
		final String stereotypePresentation = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);

		if(stereotypePresentation != null) {

			Element element = (Element)((View)(diagramElement)).getElement();
			// get the first displayed stereotype
			Stereotype stereotype = AppliedStereotypeHelper.getFirstDisplayedStereotype(diagramElement, element);

			boolean hasIcons = ElementUtil.hasIcons(element, stereotype);
			boolean hasShapes = ElementUtil.hasShapes(element, stereotype);
			if(stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
				return ICON;
			} else if(stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
				return TEXT_AND_ICON;
			} else if(stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION) && hasShapes) {
				return SHAPE;
			} else {
				return TEXT;
			}

		} else {
			return TEXT;
		}
	}

	private String getTextAlignmentValue() {
		final String stereotypePresentation = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);

		if(stereotypePresentation != null) {
			if(stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION)) {
				return HORIZONTAL;
			} else if(stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION)) {
				return VERTICAL;
			} else {
				return HORIZONTAL;
			}

		} else {
			return HORIZONTAL;
		}
	}

	private String getDisplayPlaceValue() {
		if(diagramElement != null) {
			return AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement);
		} else {
			return null;
		}
	}

	@SuppressWarnings("restriction")
	@Override
	protected void doSetValue(Object value) {
		if(value instanceof String) {
			String oldValue = cachedValue;
			String stringValue = (String)value;
			if(diagramElement != null) {
				diagramElement.eAdapters().remove(diagramElementListener);
			}
			String currentValue = doGetValue();
			//Update model with if the real value changed.
			if(!Util.equals(currentValue, stringValue)) {
				if(propertyPath.equals(STEREOTYPE_DISPLAY)) { //Edition of the stereotypeDisplay property
					setStereotypeDisplayValue(stringValue);
				} else if(propertyPath.equals(TEXT_ALIGNMENT)) { //Edition of the textAlignment property
					setTextAlignmentValue(stringValue);
				} else if(propertyPath.equals(DISPLAY_PLACE)) { //Edition of the displayPlace property
					setDisplayPlaceValue(stringValue);
				}
			}
			//Send an event if value changed. We should use the cached value since it was binded with others, and the real value can be changed externally(such as UNDO/REDO).
			if(!Util.equals(oldValue, stringValue) && hasListeners()) {
				fireValueChange(Diffs.createValueDiff(oldValue, stringValue));
			}
			if(diagramElement != null) {
				diagramElement.eAdapters().add(getDiagramElementListener());
			}
			cachedValue = stringValue;
		} else {
			Activator.log.warn("The value " + value + " is invalid for property " + propertyPath); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private void setStereotypeDisplayValue(String stereotypeAppearance) {
		// get the first displayed stereotype
		Stereotype stereotype = AppliedStereotypeHelper.getFirstDisplayedStereotype(diagramElement, element);
		boolean hasIcons = ElementUtil.hasIcons(element, stereotype);
		boolean hasShapes = ElementUtil.hasShapes(element, stereotype);
		String appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;

		if(stereotypeAppearance.equals(TEXT)) {
			appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
		} else if(stereotypeAppearance.equals(ICON) && hasIcons) {
			appliedStereotypeKind = UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION;
		} else if(stereotypeAppearance.equals(TEXT_AND_ICON) && hasIcons) {
			appliedStereotypeKind = UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION;
		} else if(stereotypeAppearance.equals(SHAPE) && hasShapes) {
			appliedStereotypeKind = UMLVisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION;
		}


		String stereotypetoDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement);
		RecordingCommand command = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(domain, diagramElement, stereotypetoDisplay, appliedStereotypeKind);
		domain.getCommandStack().execute(command);

	}

	private void setTextAlignmentValue(String alignment) {
		String appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
		if(alignment.equals(HORIZONTAL)) {
			appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
		} else if(alignment.equals(VERTICAL)) {
			appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION;
		}


		String stereotypetoDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement);
		RecordingCommand command = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(domain, diagramElement, stereotypetoDisplay, appliedStereotypeKind);
		domain.getCommandStack().execute(command);

	}

	private void setDisplayPlaceValue(String stereotypePlacePresentation) {
		RecordingCommand command = AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, diagramElement, stereotypePlacePresentation);
		domain.getCommandStack().execute(command);
	}

	/**
	 * @see org.eclipse.core.databinding.observable.AbstractObservable#dispose()
	 * 
	 */

	@Override
	public synchronized void dispose() {
		if(diagramElement != null && diagramElementListener != null) {
			diagramElement.eAdapters().remove(diagramElementListener);
		}
		super.dispose();
	}
}
