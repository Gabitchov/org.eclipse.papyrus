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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.dialogs;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * WarningAndCreateParameterDialog warns the user he can not perform an action.
 * It enables him to create a parameter instead after appropriate warnings.
 */
public class WarningAndCreateParameterDialog extends MessageDialog {

	/** Label of the create button */
	private static final String CREATE_LABEL = CustomMessages.CreateParameterDialog_Open;

	/** Start form tag */
	private static final String START_FORM = "<form>";

	/** End form tag */
	private static final String END_FORM = "</form>";

	/** List tag with content format */
	private static final String LIST_FORMAT = "<li>%s</li>";

	/** < symbol to replace */
	private static final String LT = "<";

	/** < symbol escaped replacement */
	private static final String ESC_LT = "&lt;";

	/** > symbol to replace */
	private static final String GT = ">";

	/** > symbol escaped replacement */
	private static final String ESC_GT = "&gt;";

	/** Element owning the parameter if created */
	private NamedElement parameterOwner = null;

	/** Direction to choose as default */
	private ParameterDirectionKind defaultDirection;

	/** Created parameter */
	private Parameter parameter = null;

	/** Label provider to use */
	private ILabelProvider provider = null;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 *        shell
	 * @param dialogTitle
	 *        title of the dialog
	 * @param dialogMessage
	 *        main message of the dialog
	 * @param linkElement
	 *        element to show
	 * @param labelProvider
	 *        label provider
	 * @param preferredDirection
	 *        direction to use as default for parameter creation
	 */
	public WarningAndCreateParameterDialog(Shell parentShell, String dialogTitle, String dialogMessage, NamedElement linkElement, ILabelProvider labelProvider, ParameterDirectionKind preferredDirection) {
		super(parentShell, dialogTitle, null, dialogMessage, WARNING, new String[]{ CREATE_LABEL, IDialogConstants.CLOSE_LABEL }, 0);
		parameterOwner = linkElement;
		defaultDirection = preferredDirection;
		provider = labelProvider;
	}

	/**
	 * Create the deactivated link and the warning message for parameter
	 * creation
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.WarningAndLinkDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
	 * @param parent
	 *        the parent composite
	 * @return hyperlink
	 */
	@Override
	protected Control createCustomArea(Composite parent) {
		Control result = super.createCustomArea(parent);
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		FormText text = toolkit.createFormText(parent, false);
		text.setText(getImpactedElementsText(), true, false);
		text.setBackground(parent.getBackground());
		text.setLayoutData(new GridData(GridData.FILL_BOTH));
		return result;
	}

	/**
	 * Get the text to warn about the impacts of parameter creation
	 * 
	 * @return text
	 */
	private String getImpactedElementsText() {
		StringBuffer completeText = new StringBuffer();
		completeText.append(START_FORM);
		StringBuffer impactText = new StringBuffer();
		// explore referencing elements
		Collection<Setting> references = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(parameterOwner);
		HashSet<EObject> impactedElements = new HashSet<EObject>();
		for(Setting ref : references) {
			EObject referencing = ref.getEObject();
			if(referencing.eContainer() != null && !(referencing instanceof View) && !impactedElements.contains(referencing)) {
				impactedElements.add(referencing);
				String elementText = provider.getText(referencing);
				elementText = elementText.replaceAll(LT, ESC_LT).replaceAll(GT, ESC_GT);
				if(referencing instanceof NamedElement) {
					String qualifiedName = ((NamedElement)referencing).getQualifiedName();
					if(qualifiedName != null && qualifiedName.length() != 0) {
						elementText = elementText + " (" + qualifiedName + ")";
					}
				}
				impactText.append(String.format(LIST_FORMAT, elementText));
			}
		}
		if(impactedElements.size() <= 1) {
			completeText.append(CustomMessages.CreateParameterDialog_WarnNoImpact);
		} else {
			completeText.append(CustomMessages.CreateParameterDialog_WarnImpact);
			completeText.append(impactText.toString());
		}
		completeText.append(END_FORM);
		return completeText.toString();
	}

	/**
	 * Launch create dialog if needed.
	 * 
	 * @see org.eclipse.jface.dialogs.MessageDialog#buttonPressed(int)
	 * @param buttonId
	 *        id of pressed button
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		if(buttonId == OK) {
			// Create button has been pressed
			CreateParameterDialog dialog = new CreateParameterDialog(getShell(), parameterOwner, defaultDirection);
			// close dialog only if parameter has been created
			if(dialog.open() == OK) {
				parameter = dialog.getCreatedParameter();
				super.buttonPressed(buttonId);
			}
		} else {
			super.buttonPressed(buttonId);
		}
	}

	/**
	 * Get the created parameter
	 * 
	 * @return created parameter or null
	 */
	public Parameter getParameter() {
		return parameter;
	}
}
