/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime;

import static org.eclipse.papyrus.views.properties.runtime.preferences.Preferences.CURRENT_VERSION;

import java.lang.reflect.Method;
import java.util.Locale;

import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor;
import org.eclipse.papyrus.views.properties.runtime.preferences.Preferences;


/**
 * A migration handler for the preferences model in workspace upgrade.
 */
class PreferencesMigrator {

	private final ConfigurationManager manager;

	PreferencesMigrator(ConfigurationManager manager) {
		super();

		this.manager = manager;
	}

	/**
	 * Processes the {@code preferences} to apply any required data migration.
	 * 
	 * @param preferences
	 *        the preferences to migrate, if necessary
	 * 
	 * @return whether any changes were made to the preferences that need to be saved
	 */
	public boolean process(Preferences preferences) {
		int version = preferences.getVersion();

		if((version < 1) || (version > CURRENT_VERSION)) {
			Activator.log.warn(NLS.bind("Unknown version number {0} in Properties View preferences.  Properties view preferences may function erratically or not at all.", version));
			return false;
		}

		boolean result = false;

		// step-by-step migration in case user missed any intermediate versions
		for(int i = version; i < CURRENT_VERSION; i++) {
			migrate(preferences, i, i + 1);
			preferences.setVersion(i + 1);
			result = true;
		}

		return result;
	}

	private void migrate(Preferences preferences, int fromVersion, int toVersion) {
		try {
			// would use Locale.ROOT, except it is new in JDK1.6
			Method method = getClass().getDeclaredMethod(String.format(Locale.ENGLISH, "migrateFrom%dTo%d", fromVersion, toVersion), Preferences.class);
			method.invoke(this, preferences);
		} catch (Exception e) {
			Activator.log.error("Failed to invoke migration step.", e);
		}
	}

	void migrateFrom1To2(Preferences preferences) {
		// new in version 2 is the concept of a "missing" context that is just temporarily inaccessible
		// and wasn't explicitly deleted.  So, we scan for profiles that are missing and mark them
		// deleted because that's the only way they should have gone missing in version 1

		// iterate a copy in case the migration step or the ConfigurationManager changes the list
		for(ContextDescriptor next : new java.util.ArrayList<ContextDescriptor>(preferences.getContexts())) {
			// sanity check:  if it has a prototype, then somebody created it after this capability
			// was introduced but before we added the version number and migration semantics
			if(next.getPrototype() == null) {
				// if the context doesn't exist and it was unapplied, assume that it was deleted because
				// deletion unapplied the context
				if(!next.isApplied() && manager.getContext(next.getName()) == null) {
					next.setDeleted(true);
				}
			}
		}
	}
}
