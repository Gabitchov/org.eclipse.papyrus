package org.eclipse.papyrus.qompass.designer.cpp;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.preferences.QompassPreferenceConstants;

/**
 * C language support (largely untested)
 * 
 * @author ansgar
 */
public class CLanguageSupport extends C_CppLanguageSupport implements ILangSupport {

	@Override
	public void setProject(IProject project) {
		super.setProject(project);
		
		IPreferenceStore store = org.eclipse.papyrus.qompass.designer.core.Activator.getDefault().getPreferenceStore();
		String prefix = store.getString(QompassPreferenceConstants.P_CODE_GEN_PREFIX) + "\n\n";
		// creator = new CModelElementsCreator(project, prefix);
	}

}
