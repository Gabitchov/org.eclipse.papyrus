package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.FCM.ContainerRule;

/**
 * Return a label for ContainerRules. Since the name of the rule itself, is not
 * really interesting for the user, the returned name is based on the interceptor
 * (or extension)
 * 
 * @author ansgar
 * 
 */
public class RuleLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if(element instanceof ContainerRule) {
			ContainerRule rule = (ContainerRule)element;
			// TODO? Add information about contained parts?
			return rule.getBase_Class().getName();
		}
		return null;
	}
};
