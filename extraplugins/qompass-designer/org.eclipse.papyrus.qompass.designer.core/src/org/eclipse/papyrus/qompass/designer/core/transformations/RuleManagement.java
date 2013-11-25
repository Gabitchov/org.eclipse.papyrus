package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.papyrus.FCM.ConfigOption;
import org.eclipse.papyrus.FCM.Configuration;
import org.eclipse.papyrus.FCM.ContainerRule;

public class RuleManagement {
	private static Configuration m_config;

	public static void setConfiguration(Configuration config) {
		m_config = config;
	}

	/**
	 * check whether a rule is active in a given configuration
	 * 
	 * @param aRule
	 * @return
	 */
	public static boolean isRuleActive(ContainerRule rule) {
		if(m_config != null) {
			for(ConfigOption option : m_config.getConfigOptions()) {
				if(rule.getForConfig().contains(option)) {
					return true;
				}
			}
		}
		// not already true via specific configuration.
		// => Also turn on rules by default that are not for a specific configuration option
		return (rule.getForConfig().size() == 0);
	}
}
