package org.eclipse.papyrus.uml.diagram.usecase.preferences;

import org.eclipse.swt.widgets.Composite;

public class SubjectPreferencePage extends ClassifierPreferencePage {

	
	public static final String USE_CASE_SUBJECT_SEMANTIC_HINT = "Subject_SemanticHint";
	
	@Override
	protected void createPageContents(Composite parent) {
		// TODO Auto-generated method stub
		super.createPageContents(parent);
	
		addAbstractGroup( new RadioGroup(parent, USE_CASE_SUBJECT_SEMANTIC_HINT, this));

	}
	
}
