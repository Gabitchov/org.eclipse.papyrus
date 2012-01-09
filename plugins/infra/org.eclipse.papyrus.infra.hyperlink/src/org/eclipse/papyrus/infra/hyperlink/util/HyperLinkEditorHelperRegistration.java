package org.eclipse.papyrus.infra.hyperlink.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkEditorHelper;


public class HyperLinkEditorHelperRegistration {

	private static final String HYPERLINK_EDITOR_HELPER_REGISTRATION_ID = "org.eclipse.papyrus.infra.hyperlink.editor.registration";

	private Collection<AbstractHyperLinkEditorHelper> helpers;

	public static final HyperLinkEditorHelperRegistration INSTANCE = new HyperLinkEditorHelperRegistration();

	private HyperLinkEditorHelperRegistration() {
		//nothing to do
	}

	public Collection<AbstractHyperLinkEditorHelper> getAllRegisteredHyperLinkEditorHelper() {
		if(helpers == null) {
			helpers = new ArrayList<AbstractHyperLinkEditorHelper>();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(HYPERLINK_EDITOR_HELPER_REGISTRATION_ID);

			for(IConfigurationElement e : config) {
				try {
					final Object h = e.createExecutableExtension("helper");
					if(h instanceof AbstractHyperLinkEditorHelper) {
						helpers.add((AbstractHyperLinkEditorHelper)h);
					} else {
						Activator.log.info(NLS.bind("{0} is not an instanceof {1}", new Object[]{ h, AbstractHyperLinkEditorHelper.class }));
					}
				} catch (CoreException ex) {
					Activator.log.error("I can't create the class for an helper", ex);
				}
			}
		}
		return helpers;
	}

}
