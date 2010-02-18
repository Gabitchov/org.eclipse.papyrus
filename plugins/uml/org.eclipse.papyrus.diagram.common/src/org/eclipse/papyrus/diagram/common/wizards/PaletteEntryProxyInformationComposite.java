/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.wizards;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.diagram.common.service.AspectCreationEntry;
import org.eclipse.papyrus.diagram.common.wizards.LocalPaletteContentPage.EntryType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Profile;


/**
 * Class in charge of the composite in the {@link LocalPaletteContentPage}
 */
public class PaletteEntryProxyInformationComposite {

	/** current selected entry proxy */
	protected PaletteEntryProxy selectedEntryProxy;

	/** proxy name text */
	protected Text nameText;

	/** proxy description text */
	protected Text descriptionText;

	/** proxy icon text */
	protected Text iconText;

	/** referenced proxy text */
	protected Text referencedText;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	public Composite createComposite(Composite parent, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.widthHint = 260;
		data.horizontalIndent = 10;
		composite.setLayoutData(data);

		Label entryInformationLabel = new Label(composite, SWT.NONE);
		entryInformationLabel.setText(Messages.Local_Palette_Entry_Information);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.horizontalSpan = 2;
		entryInformationLabel.setLayoutData(data);

		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setText(Messages.Local_Palette_Entry_Name);
		data = new GridData(SWT.FILL, SWT.FILL, false, false);
		nameLabel.setLayoutData(data);
		nameText = new Text(composite, SWT.LEAD | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		nameText.setLayoutData(data);
		nameText.addFocusListener(new NameFocusListener());

		Label referencedLabel = new Label(composite, SWT.NONE);
		referencedLabel.setText(Messages.Local_Palette_Entry_Reference);
		data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		referencedLabel.setLayoutData(data);
		referencedText = new Text(composite, SWT.LEAD | SWT.BORDER | SWT.READ_ONLY);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		referencedText.setLayoutData(data);

		Label descriptionLabel = new Label(composite, SWT.NONE);
		descriptionLabel.setText(Messages.Local_Palette_Entry_Description);
		data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		descriptionLabel.setLayoutData(data);
		descriptionText = new Text(composite, SWT.WRAP | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.widthHint = 160;
		descriptionText.setLayoutData(data);
		descriptionText.addFocusListener(new DescriptionFocusListener());

		Label iconLabel = new Label(composite, SWT.NONE);
		iconLabel.setText(Messages.Local_Palette_Entry_Icon);
		data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		iconLabel.setLayoutData(data);
		iconText = new Text(composite, SWT.LEAD | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		iconText.setLayoutData(data);
		iconText.addFocusListener(new IconFocusListener());

		return composite;
	}

	/**
	 * Updates the name field in the information area
	 */
	protected void updateNameEntryField() {
		EntryType type = selectedEntryProxy.getType();
		switch(type) {
		case STACK:
		case SEPARATOR:
			nameText.setText("");
			nameText.setEnabled(false);
			break;
		case DRAWER:
			String drawerName = selectedEntryProxy.getLabel();
			nameText.setText((drawerName != null) ? drawerName : "");
			nameText.setEnabled(false);
			break;
		case TOOL:
		case ASPECT_TOOL:
			// the fields describing information about entry should be updated
			String name = selectedEntryProxy.getLabel();
			nameText.setText((name != null) ? name : "");
			nameText.setEnabled(true);
			break;
		}
	}

	/**
	 * Updates the reference field in the information area
	 */
	protected void updateReferencedEntryField() {
		if(selectedEntryProxy instanceof PaletteAspectToolEntryProxy) {
			CombinedTemplateCreationEntry entry = ((PaletteAspectToolEntryProxy)selectedEntryProxy).getEntry().getReferencedEntry();
			EClass eClass = PaletteUtil.getToolMetaclass(entry);
			referencedText.setText((eClass != null) ? eClass.getInstanceTypeName() : "");
		} else if(selectedEntryProxy instanceof PaletteEntryProxy) {
			PaletteEntry entry = selectedEntryProxy.getEntry();
			if(entry instanceof CombinedTemplateCreationEntry) {
				EClass eClass = PaletteUtil.getToolMetaclass((CombinedTemplateCreationEntry)entry);
				referencedText.setText((eClass != null) ? eClass.getInstanceTypeName() : "");
			} else {
				referencedText.setText("");
			}
		} else {
			// should never happen
			referencedText.setText("");
		}
	}

	/**
	 * Updates the description field in the information area
	 */
	protected void updateDescriptionEntryField() {
		EntryType type = selectedEntryProxy.getType();
		switch(type) {
		case STACK:
		case SEPARATOR:
		case DRAWER:
			descriptionText.setText("");
			descriptionText.setEnabled(false);
			break;
		case TOOL:
		case ASPECT_TOOL:
			// the fields describing information about entry should be updated
			String name = selectedEntryProxy.getDescription();
			descriptionText.setText((name != null) ? name : "");
			descriptionText.setEnabled(true);
			break;
		}
	}

	/**
	 * Updates the icon field in the information area
	 */
	protected void updateIconEntryField() {
		EntryType type = selectedEntryProxy.getType();
		switch(type) {
		case STACK:
		case SEPARATOR:
		case TOOL:
			iconText.setText("");
			iconText.setEnabled(false);
			break;
		case DRAWER:
			String drawerIcon = selectedEntryProxy.getImagePath();
			iconText.setText((drawerIcon != null) ? drawerIcon : "");
			iconText.setEnabled(false);
			break;
		case ASPECT_TOOL:
			String icon = selectedEntryProxy.getImagePath();
			iconText.setText((icon != null) ? icon : "");
			iconText.setEnabled(true);
			break;
		}
	}


	/**
	 * Sets the new Selected entry
	 * 
	 * @param selectedEntryProxy
	 *        the selectedEntryProxy to set
	 */
	public void setSelectedEntryProxy(PaletteEntryProxy selectedEntryProxy) {
		this.selectedEntryProxy = selectedEntryProxy;

		updateNameEntryField();
		updateIconEntryField();
		updateReferencedEntryField();
		updateDescriptionEntryField();
	}

	/**
	 * focus listener for the name text field
	 */
	protected class NameFocusListener implements FocusListener {

		/**
		 * @{inheritDoc
		 */
		public void focusGained(FocusEvent e) {
		}

		/**
		 * @{inheritDoc
		 */
		public void focusLost(FocusEvent e) {
			if(selectedEntryProxy != null && selectedEntryProxy.getEntry() != null) {
				selectedEntryProxy.getEntry().setLabel(nameText.getText().trim());
			}
		}

	}

	/**
	 * focus listener for the name text field
	 */
	protected class DescriptionFocusListener implements FocusListener {

		/**
		 * @{inheritDoc
		 */
		public void focusGained(FocusEvent e) {
		}

		/**
		 * @{inheritDoc
		 */
		public void focusLost(FocusEvent e) {
			if(selectedEntryProxy != null && selectedEntryProxy.getEntry() != null) {
				selectedEntryProxy.getEntry().setDescription(descriptionText.getText().trim());
			}
		}
	}

	/**
	 * focus listener for the name text field
	 */
	protected class IconFocusListener implements FocusListener {

		/**
		 * @{inheritDoc
		 */
		public void focusGained(FocusEvent e) {
		}

		/**
		 * @{inheritDoc
		 */
		public void focusLost(FocusEvent e) {
			if(selectedEntryProxy != null && iconText.getText() != null) {
				selectedEntryProxy.getEntry().setSmallIcon(Activator.getImageDescriptor(iconText.getText().trim()));
				selectedEntryProxy.getEntry().setLargeIcon(Activator.getImageDescriptor(iconText.getText().trim()));
				if(selectedEntryProxy.getEntry() instanceof AspectCreationEntry) {
					((AspectCreationEntry)selectedEntryProxy.getEntry()).setIconPath(iconText.getText().trim());
				}
			}
		}
	}

}
