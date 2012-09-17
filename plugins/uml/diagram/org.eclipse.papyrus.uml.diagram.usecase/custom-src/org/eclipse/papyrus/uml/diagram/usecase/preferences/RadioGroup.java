package org.eclipse.papyrus.uml.diagram.usecase.preferences;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


public class RadioGroup extends AbstractGroup {

	/** The toolbar. */
	protected Group toolbar;
	
	public RadioGroup(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
		createContent(parent);
	}
	
	/**
	 * Gets the toolbar.
	 * 
	 * @return the group that contains editors
	 */
	protected Group getToolbar() {
		return toolbar;
	}
	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *        the parent
	 */
	protected void createContent(Composite parent) {
		toolbar = new Group(parent, SWT.SHADOW_NONE);
		toolbar.setText("Metaclass for the Subject");
		toolbar.setLayout(new GridLayout(3, false));

		Composite SubjectCompo = getEncapsulatedCompo(toolbar);
		RadioGroupFieldEditor radio=new RadioGroupFieldEditor(getKey(), "PossibleSubject", 1, new String[][]{ 
			{ "Class","org.eclipse.papyrus.uml.Class" },
			{ "Interface","org.eclipse.papyrus.uml.Interface" },
			{ "Component","org.eclipse.papyrus.uml.Component"  },
			{ "StateMachine","org.eclipse.papyrus.uml.StateMachine" },
			{"Signal", "org.eclipse.papyrus.uml.Signal" },
			{"None",""}
			}, SubjectCompo);
		
			 radio.setPage(dialogPage);


		addFieldEditor(radio);
	}

}
