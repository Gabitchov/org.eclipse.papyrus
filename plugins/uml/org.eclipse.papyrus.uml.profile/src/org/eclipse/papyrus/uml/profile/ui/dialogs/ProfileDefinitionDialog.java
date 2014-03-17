/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.papyrus.uml.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.uml.profile.definition.Version;
import org.eclipse.papyrus.uml.profile.preference.ProfileDefinitionPreferenceConstants;
import org.eclipse.papyrus.uml.profile.utils.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Profile;


public class ProfileDefinitionDialog extends TitleAreaDialog {

	/** path to the banner image */
	public final static String PROFILE_DEFINITION = ImageManager.IMAGE_PATH + "wizban/NewDefinition.gif"; //$NON-NLS-1$

	/** Text area that displays previous version of the profile definition */
	protected Text oldVersionText;

	/** button to select the new version number (dev) */
	protected Button devVersionButton;

	/** button to select the new version number (release) */
	protected Button releaseVersionButton;

	/** button to select the new version number (major release) */
	protected Button majorReleaseVersionButton;

	/** button to select the new version number (custom version) */
	protected Button customVersionButton;

	/** Text area where custom version number can be entered */
	protected Text customVersionText;

	/** Profile which is redefined */
	protected Profile profileToDefine;

	/** development version */
	private Version devVersionValue;

	/** release version */
	private Version releaseVersionValue;

	/** major release version */
	private Version majorReleaseVersionValue;

	/** oldVersion Value */
	private Version oldVersionValue;

	/** custom Version Value */
	private Version customReleaseVersionValue;

	/** custom Version Value */
	private Version newVersionValue;

	/** Definition information */
	protected PapyrusDefinitionAnnotation papyrusDefinitionAnnotation;

	/** Comment text area */
	private Text commentText;

	/** Copyright text area */
	private Text copyrightText;

	/** Author text area */
	private Text authorText;

	/** Date text Area */
	private Text dateText;

	/** check button for preference store */
	private Button savePreferencesButton;
	protected boolean saveConstraint=false;

	/** list of previous definition annotations */
	List<PapyrusDefinitionAnnotation> oldVersionAnnotations = new ArrayList<PapyrusDefinitionAnnotation>();

	/** Combo that displays the history of comments */
	Combo commentHistory;

	/** list of comments history */
	final List<String> availableComments = new ArrayList<String>();

	private Button constraintCheck;


	/**
	 * Creates a new ProfileDefinitionDialog
	 * 
	 * @param parentShell
	 *        the parent shell for this dialog
	 */
	public ProfileDefinitionDialog(Shell parentShell, Profile profileToDefine) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.profileToDefine = profileToDefine;

		computeHistoryAnnotations();
	}

	/**
	 * retrieve version annotation history
	 */
	private void computeHistoryAnnotations() {
		// get all annotations for the given profile
		oldVersionAnnotations = Util.getAllPapyrusDefinitionAnnotation(profileToDefine);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		// save author and copyright in preference store
		if(savePreferencesButton.getSelection()) {
			Activator.getDefault().getPreferenceStore().setValue(ProfileDefinitionPreferenceConstants.PREF_AUTHOR_NAME, authorText.getText());
			Activator.getDefault().getPreferenceStore().setValue(ProfileDefinitionPreferenceConstants.PREF_COPYRIGHT, copyrightText.getText());
		}

		// creates the new Papyrus Definition Annotation
		papyrusDefinitionAnnotation = new PapyrusDefinitionAnnotation(newVersionValue, commentText.getText(), copyrightText.getText(), dateText.getText(), authorText.getText());
		if(constraintCheck!=null){
			saveConstraint= constraintCheck.getSelection();
		}
		
		super.okPressed();
	}

	public boolean saveConstraintInDefinition(){
		return saveConstraint;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// top level composite
		Composite parentComposite = (Composite)super.createDialogArea(parent);

		setTitle("Information about new definition");
		setTitleImage(ImageManager.getImage(PROFILE_DEFINITION));

		// create a composite with standard margins and spacing
		Composite composite = new Composite(parentComposite, SWT.NONE);
		GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setFont(parentComposite.getFont());

		// compute initial values
		computeVersionValues();

		// fill composite with information about new definition:
		// 1. version
		// 2. author
		// 3. comment
		// 4. date
		// 5. copyright
		// 6. save constraint into the definition
		
		GridData gd;

		Composite versionArea = createVersionArea(composite);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		versionArea.setLayoutData(gd);

		Composite infoArea = createInfoArea(composite);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		infoArea.setLayoutData(gd);

		Composite commentArea = createCommentArea(composite);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1);
		commentArea.setLayoutData(gd);

		Composite copyrightArea = createCopyrightArea(composite);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1);
		copyrightArea.setLayoutData(gd);

		Composite advancedArea = createAdvancedArea(composite);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1);
		advancedArea.setLayoutData(gd);
		Composite constraintArea = createSaveConstraintAera(composite);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1);
		constraintArea.setLayoutData(gd);

		applyDialogFont(parentComposite);
		return parentComposite;
	}

	/**
	 * Creates and returns the content of the advanced area.
	 * 
	 * @param composite
	 *        The parent composite to contain the advanced area
	 */
	private Composite createAdvancedArea(Composite composite) {
		Composite parent = new Composite(composite, SWT.CENTER);
		GridLayout layout = new GridLayout();
		parent.setLayout(layout);
		// new copyright area
		savePreferencesButton = new Button(parent, SWT.CHECK);
		savePreferencesButton.setText("Store author and copyright values in preferences.");
		GridData gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, true);
		savePreferencesButton.setLayoutData(gd);
		return parent;
	}

	/**
	 * Creates and returns the content of the copyright area.
	 * 
	 * @param composite
	 *        The parent composite to contain the copyright area
	 */
	private Composite createSaveConstraintAera(Composite composite) {
		Group group = new Group(composite, SWT.CENTER);
		group.setText("Constraints"); //$NON-NLS-1$
		GridLayout layout = new GridLayout();
		group.setLayout(layout);

		// new copyright area
		constraintCheck = new Button(group, SWT.CHECK);
		// Enable button by default, see bug #411256
		constraintCheck.setSelection(true);
		// should look 
		constraintCheck.setText("Save OCL constraints into the definition");	//$NON-NLS-1$
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, true);
		gd.heightHint = 60;
		constraintCheck.setLayoutData(gd);
		return group;
	}
	/**
	 * Creates and returns the content of the copyright area.
	 * 
	 * @param composite
	 *        The parent composite to contain the copyright area
	 */
	private Composite createCopyrightArea(Composite composite) {
		Group group = new Group(composite, SWT.CENTER);
		group.setText("Copyright"); //$NON-NLS-1$
		GridLayout layout = new GridLayout();
		group.setLayout(layout);

		// new copyright area
		copyrightText = new Text(group, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		// should look 
		copyrightText.setText(Activator.getDefault().getPreferenceStore().getString(ProfileDefinitionPreferenceConstants.PREF_COPYRIGHT));
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, true);
		gd.heightHint = 60;
		copyrightText.setLayoutData(gd);
		return group;
	}

	/**
	 * Creates and returns the content of the information area.
	 * 
	 * @param composite
	 *        The parent composite to contain the information area
	 */
	private Composite createInfoArea(Composite composite) {
		Group group = new Group(composite, SWT.CENTER);
		group.setText("Info");
		GridLayout layout = new GridLayout(2, false);
		group.setLayout(layout);

		Label dateLabel = new Label(group, SWT.LEFT);
		dateLabel.setText("Date");
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		dateLabel.setLayoutData(gd);
		dateText = new Text(group, SWT.SINGLE | SWT.BORDER);
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final TimeZone local = TimeZone.getDefault();
		sdf.setTimeZone(local);
		// new Date() gets current date/elapsedTime
		final String dateString = sdf.format(new Date());
		dateText.setText(dateString);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		dateText.setLayoutData(gd);

		Label authorLabel = new Label(group, SWT.LEFT);
		authorLabel.setText("Author");
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		authorLabel.setLayoutData(gd);
		authorText = new Text(group, SWT.SINGLE | SWT.BORDER);
		// should look in preferences...
		authorText.setText(Activator.getDefault().getPreferenceStore().getString(ProfileDefinitionPreferenceConstants.PREF_AUTHOR_NAME));
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		authorText.setLayoutData(gd);

		return group;
	}

	/**
	 * Creates and returns the content of the comment area.
	 * 
	 * @param composite
	 *        The parent composite to contain the comment area
	 */
	private Composite createCommentArea(Composite composite) {
		Group group = new Group(composite, SWT.CENTER);
		group.setText("Comments");
		GridLayout layout = new GridLayout(1, false);
		group.setLayout(layout);

		// new comment area
		commentText = new Text(group, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentText.setText("");
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, true);
		gd.heightHint = 60;
		commentText.setLayoutData(gd);

		commentHistory = new Combo(group, SWT.READ_ONLY | SWT.DROP_DOWN);

		Iterator<PapyrusDefinitionAnnotation> it = oldVersionAnnotations.listIterator();
		while(it.hasNext()) {
			String comment = it.next().getComment();
			if(comment != null && !"".equals(comment)) {
				availableComments.add(comment);
			}
		}

		for(String comment : availableComments) {
			// should be max 80 characters or something like that
			commentHistory.add(comment.substring(0, Math.min(comment.length(), 80)));
		}

		commentHistory.addSelectionListener(new SelectionListener() {

			/** @{inheritedDoc */
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			/** @{inheritedDoc */
			public void widgetSelected(SelectionEvent e) {
				int index = commentHistory.getSelectionIndex();
				if(index == -1) {
					return;
				}
				String text = availableComments.get(index);
				commentText.setText(text);
			}

		});

		gd = new GridData(SWT.FILL, SWT.CENTER, true, true);
		commentHistory.setLayoutData(gd);
		return group;
	}

	/**
	 * Creates and returns the content of the version area.
	 * 
	 * @param composite
	 *        The parent composite to contain the version area
	 */
	private Composite createVersionArea(Composite composite) {
		Group group = new Group(composite, SWT.CENTER);
		group.setText("Version");
		GridLayout layout = new GridLayout(2, false);
		group.setLayout(layout);

		// old version label 
		Label oldVersionLabel = new Label(group, SWT.LEFT);
		oldVersionLabel.setText("Previous Version");
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		oldVersionLabel.setLayoutData(gd);
		final Text oldVersionText = new Text(group, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		oldVersionText.setText(oldVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		oldVersionText.setLayoutData(gd);


		// new version:
		// 1. Development version
		// 2. Release
		// 3. Major release
		// 4. Custom
		devVersionButton = new Button(group, SWT.CHECK);
		devVersionButton.setText("Development Version");
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		devVersionButton.setLayoutData(gd);
		devVersionButton.setSelection(true);
		devVersionButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				developmentVersionButtonPressed();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		final Text devVersionText = new Text(group, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		devVersionText.setText(devVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		devVersionText.setLayoutData(gd);

		// RELEASE AREA
		releaseVersionButton = new Button(group, SWT.CHECK);
		releaseVersionButton.setText("Release Version");
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		releaseVersionButton.setLayoutData(gd);
		releaseVersionButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				releaseVersionButtonPressed();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		final Text releaseVersionText = new Text(group, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		releaseVersionText.setText(releaseVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		releaseVersionText.setLayoutData(gd);

		// MAJOR RELEASE AREA
		majorReleaseVersionButton = new Button(group, SWT.CHECK);
		majorReleaseVersionButton.setText("Major Release");
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		majorReleaseVersionButton.setLayoutData(gd);
		majorReleaseVersionButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				majorReleaseVersionButtonPressed();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		final Text majorReleaseVersionText = new Text(group, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		majorReleaseVersionText.setText(majorReleaseVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		majorReleaseVersionText.setLayoutData(gd);

		// CUSTOM VERSION AREA
		customVersionButton = new Button(group, SWT.CHECK);
		customVersionButton.setText("Custom");
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		customVersionButton.setLayoutData(gd);
		customVersionButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				customVersionButtonPressed();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		customVersionText = new Text(group, SWT.SINGLE | SWT.BORDER);
		customVersionText.setEditable(false); // by default
		customVersionText.setText(customReleaseVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		customVersionText.setLayoutData(gd);
		customVersionText.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				customVersionText.setText(customReleaseVersionValue.toString());
			}

			public void focusLost(FocusEvent e) {
				try {
					customReleaseVersionValue = Version.parseVersion(customVersionText.getText());
					newVersionValue = customReleaseVersionValue;
					setErrorMessage(null);
				} catch (IllegalArgumentException iae) {
					setErrorMessage("Custom version number format should be X.Y.Z, not " + customVersionText.getText());
					customReleaseVersionValue = devVersionValue; // default value
					developmentVersionButtonPressed();
				}
			}
		});

		return group;
	}

	/**
	 * compute the value of the versions
	 */
	private void computeVersionValues() {
		oldVersionValue = Util.getProfileDefinitionVersion(profileToDefine);
		devVersionValue = new Version(oldVersionValue.getMajor(), oldVersionValue.getMinor(), oldVersionValue.getMicro() + 1);
		releaseVersionValue = new Version(oldVersionValue.getMajor(), oldVersionValue.getMinor() + 1, 0);
		majorReleaseVersionValue = new Version(oldVersionValue.getMajor() + 1, 0, 0);
		customReleaseVersionValue = devVersionValue;
		newVersionValue = devVersionValue;
	}

	/**
	 * Action called as the development version button is pressed
	 * 
	 * @param e
	 *        the selection event that triggers this behavior
	 */
	private void developmentVersionButtonPressed() {
		devVersionButton.setSelection(true);
		releaseVersionButton.setSelection(false);
		majorReleaseVersionButton.setSelection(false);
		customVersionButton.setSelection(false);
		newVersionValue = devVersionValue;
		customVersionText.setEditable(false);
	}

	/**
	 * Action called as the release version button is pressed
	 * 
	 * @param e
	 *        the selection event that triggers this behavior
	 */
	private void releaseVersionButtonPressed() {
		devVersionButton.setSelection(false);
		releaseVersionButton.setSelection(true);
		majorReleaseVersionButton.setSelection(false);
		customVersionButton.setSelection(false);
		newVersionValue = releaseVersionValue;
		customVersionText.setEditable(false);
	}

	/**
	 * Action called as the major release version button is pressed
	 * 
	 * @param e
	 *        the selection event that triggers this behavior
	 */
	private void majorReleaseVersionButtonPressed() {
		devVersionButton.setSelection(false);
		releaseVersionButton.setSelection(false);
		majorReleaseVersionButton.setSelection(true);
		customVersionButton.setSelection(false);
		newVersionValue = majorReleaseVersionValue;
		customVersionText.setEditable(false);
	}

	/**
	 * Action called as the release version button is pressed
	 * 
	 * @param e
	 *        the selection event that triggers this behavior
	 */
	private void customVersionButtonPressed() {
		devVersionButton.setSelection(false);
		releaseVersionButton.setSelection(false);
		majorReleaseVersionButton.setSelection(false);
		customVersionButton.setSelection(true);
		newVersionValue = customReleaseVersionValue;
		customVersionText.setEditable(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		shell.setText("Profile Definition"); //$NON-NLS-1$
	}

	/**
	 * Returns the defined PapyrusDefinitionAnnotation
	 * 
	 * @return the papyrusDefinitionAnnotation
	 */
	public PapyrusDefinitionAnnotation getPapyrusDefinitionAnnotation() {
		return papyrusDefinitionAnnotation;
	}
}
