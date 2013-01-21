

package org.eclipse.papyrus.uml.nattable.generic.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.nattable.common.handlers.AbstractCreateUMLNattableEditorHandler;
import org.eclipse.papyrus.uml.nattable.generic.Activator;
import org.eclipse.papyrus.uml.nattable.generic.editor.GenericUMLNattableEditor;


public class CreateNattableEditorCommand extends AbstractCreateUMLNattableEditorHandler {
	
	private static final String CONFIGURATION_PATH = "/resources/generic.nattableconfiguration";

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateNattableEditorCommand() {
		super(GenericUMLNattableEditor.EDITOR_TYPE, GenericUMLNattableEditor.DEFAULT_NAME);
	}

	protected URI getTableEditorConfigurationURI(){
		final String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		final URI uri = URI.createPlatformPluginURI(symbolicName + CONFIGURATION_PATH, true); //$NON-NLS-1$
		return uri;
	}
}
