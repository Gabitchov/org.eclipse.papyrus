package org.eclipse.papyrus.properties.runtime;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.properties.contexts.Context;

/**
 * Represents a conflict in the applied Property view configurations
 * 
 * @author Camille Letavernier
 * 
 */
public class ConfigurationConflict {

	public String sectionID;

	public List<Context> conflictingContexts;

	public ConfigurationConflict(String sectionID) {
		conflictingContexts = new LinkedList<Context>();
		this.sectionID = sectionID;
	}

	public void addContext(Context context) {
		conflictingContexts.add(context);
	}

	@Override
	public String toString() {
		String result = sectionID + " : "; //$NON-NLS-1$
		for(Context context : conflictingContexts) {
			result += context.getName() + ", "; //$NON-NLS-1$
		}
		return result.substring(0, result.length() - 2);
	}


}
