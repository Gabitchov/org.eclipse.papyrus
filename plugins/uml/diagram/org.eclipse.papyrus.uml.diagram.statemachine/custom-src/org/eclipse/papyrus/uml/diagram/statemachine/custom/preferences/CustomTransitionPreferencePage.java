package org.eclipse.papyrus.uml.diagram.statemachine.custom.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.statemachine.preferences.TransitionPreferencePage;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CustomTransitionPreferencePage extends TransitionPreferencePage {
	
	/**
	 * Button: if selected, indicate signals/call events with parameters by means of (...)
	 */
	Button bIndicateParameters; 
	
	/**
	 * Button: if selected, add a line/break before a non-empty effect
	 */
	Button bLineBreakBeforeEffector; 

	/**
	 * Cut text of opaque bodies after certain length
	 */
	Text tBodyCutLength;
	
	/**
	 * initialize the preferences
	 * @param store the preference store associated with the state machine diagram.
	 */
	public static void initDefaults(IPreferenceStore store) {
		int cutLength = 1;
		if(cutLength != store.getInt(PreferenceConstants.BODY_CUT_LENGTH)) {
			store.setValue(PreferenceConstants.BODY_CUT_LENGTH, cutLength);
		}
		
		boolean indicateParams = true;
		if(indicateParams != store.getBoolean(PreferenceConstants.INDICATE_PARAMETERS)) {
			store.setValue(PreferenceConstants.INDICATE_PARAMETERS, indicateParams);
		}
		TransitionPreferencePage.initDefaults(store);
		
		boolean lineBreakBeforeEffect = true;
		if(lineBreakBeforeEffect != store.getBoolean(PreferenceConstants.LINEBREAK_BEFORE_EFFECT)) {
			store.setValue(PreferenceConstants.LINEBREAK_BEFORE_EFFECT, lineBreakBeforeEffect);
		}
		TransitionPreferencePage.initDefaults(store);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		// adds the label preferences checkboxes
		createTransitionPreferencesButtons(parent);
		// refreshButtons();
	}
	
	/**
	 * Creates the group and check boxes to choose the kind of display
	 * 
	 * @param parent
	 *        the parent composite that holds the group
	 */
	protected void createTransitionPreferencesButtons(Composite parent) {
		IPreferenceStore store = getPreferenceStore();

		// create group that host the buttons
		Group group = new Group(parent, SWT.SHADOW_NONE);
		group.setText("Transition Display");
		group.setLayout(new FormLayout());
		// group.setLayout(new GridLayout(1, false));

		FormData data;
		
		bIndicateParameters = createCheckButton(group, "Indicate parameters", ICustomAppearence.DISP_VISIBILITY);
		bIndicateParameters.setSelection(store.getBoolean(PreferenceConstants.INDICATE_PARAMETERS));
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		bIndicateParameters.setLayoutData(data);
		
		bLineBreakBeforeEffector = createCheckButton(group, "Line break before effect label", ICustomAppearence.DISP_VISIBILITY);
		bLineBreakBeforeEffector.setSelection(store.getBoolean(PreferenceConstants.LINEBREAK_BEFORE_EFFECT));
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(bIndicateParameters, 0);
		bLineBreakBeforeEffector.setLayoutData(data);
		
		Composite maxLengthComposite = new Composite(group, SWT.NONE);
		maxLengthComposite.setLayout(new GridLayout(2, false));
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(bLineBreakBeforeEffector, 0);
		maxLengthComposite.setLayoutData(data);
		Label l = new Label(maxLengthComposite, SWT.NONE);
		l.setText("Shown number of lines for opaque expressions/behaviors: ");
		tBodyCutLength = new Text(maxLengthComposite, SWT.NONE);
		tBodyCutLength.setText(store.getInt(PreferenceConstants.BODY_CUT_LENGTH) + ""); // $NON-NLS-1$
		final GridData gridData = new GridData();
		gridData.widthHint = 50;		// minimal width to assure entering larger numbers
		tBodyCutLength.setLayoutData(gridData);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void performDefaults() {
		IPreferenceStore store = getPreferenceStore();
		initDefaults(store);
		
		bIndicateParameters.setSelection(store.getBoolean(PreferenceConstants.INDICATE_PARAMETERS));
		bLineBreakBeforeEffector.setSelection(store.getBoolean(PreferenceConstants.LINEBREAK_BEFORE_EFFECT));
		tBodyCutLength.setText("" + store.getInt(PreferenceConstants.BODY_CUT_LENGTH));
		
		super.performDefaults();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		storePreferences();
		return super.performOk();
	}
	
	
	/**
	 * Creates a button with the {@link SWT#CHECK} style.
	 * 
	 * @param parent
	 *        the parent of the button
	 * @param label
	 *        the label of the button
	 * @param mask
	 *        the value controlled by the button
	 * @return the button created
	 */
	protected Button createCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		return button;
	}
	
	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	protected void storePreferences() {
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		boolean lineBreakBeforeEffect = bLineBreakBeforeEffector.getSelection();
		if(lineBreakBeforeEffect != store.getBoolean(PreferenceConstants.LINEBREAK_BEFORE_EFFECT)) {
			store.setValue(PreferenceConstants.LINEBREAK_BEFORE_EFFECT, lineBreakBeforeEffect);
		}

		int cutLength = new Integer(tBodyCutLength.getText().trim());
		if(cutLength != store.getInt(PreferenceConstants.BODY_CUT_LENGTH)) {
			store.setValue(PreferenceConstants.BODY_CUT_LENGTH, cutLength);
		}
		
		boolean indicateParams = bIndicateParameters.getSelection();
		if(indicateParams != store.getBoolean(PreferenceConstants.INDICATE_PARAMETERS)) {
			store.setValue(PreferenceConstants.INDICATE_PARAMETERS, indicateParams);
		}
	}
}
