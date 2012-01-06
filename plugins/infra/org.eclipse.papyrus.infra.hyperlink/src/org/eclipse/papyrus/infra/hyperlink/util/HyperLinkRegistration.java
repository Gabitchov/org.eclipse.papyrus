package org.eclipse.papyrus.infra.hyperlink.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;

public class HyperLinkRegistration {
	private static final String HYPERLINK_REGISTRATION_ID = "org.eclipse.papyrus.infra.hyperlink.registration";
	private Collection<AbstractHyperLinkHelper> helpers;
	public static final HyperLinkRegistration INSTANCE = new HyperLinkRegistration();

	private HyperLinkRegistration() {

	}

	public Collection<AbstractHyperLinkHelper> getAllRegisteredHyperLinkHelper() {
		SortedMap<Integer, AbstractHyperLinkHelper> map = new TreeMap<Integer, AbstractHyperLinkHelper>();
		if (helpers == null) {
			IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(HYPERLINK_REGISTRATION_ID);

			for (IConfigurationElement e : config) {
				try {
					final Object h = e.createExecutableExtension("helper");
					if (h instanceof AbstractHyperLinkHelper) {
						AbstractHyperLinkHelper helper = (AbstractHyperLinkHelper) h;
						String o = e.getAttribute("position", null);
						Integer order = null;
						try {
							order = Integer.valueOf(o);
						} catch (NumberFormatException exception) {
							Activator.log
									.error(NLS
											.bind("The helper {0} will be ignored because I can't read its position",
													helper), exception);
							continue;
						}
						if (order != null) {
							map.put(order, helper);
						}
					} else {
						Activator.log.info(NLS.bind(
								"{0} is not an instanceof {1}", new Object[] {
										h, AbstractHyperLinkHelper.class }));
					}
				} catch (CoreException ex) {
					Activator.log.error(
							"I can't create the class for an helper", ex);
				}
			}
			// we sort the helper
			//TODO test when the map is empty, helpers should never be null!
			helpers = map.values();
		}
		return helpers;
	}
}
