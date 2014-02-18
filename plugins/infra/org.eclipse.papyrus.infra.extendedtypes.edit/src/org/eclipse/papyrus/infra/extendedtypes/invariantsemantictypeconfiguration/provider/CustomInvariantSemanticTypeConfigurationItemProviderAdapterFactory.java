/**
 * 
 */
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.provider;

import org.eclipse.emf.common.notify.Adapter;

/**
 * @author RS211865
 *
 */
public class CustomInvariantSemanticTypeConfigurationItemProviderAdapterFactory
		extends InvariantSemanticTypeConfigurationItemProviderAdapterFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Adapter createInvariantSemanticTypeConfigurationAdapter() {
		if (invariantSemanticTypeConfigurationItemProvider == null) {
			invariantSemanticTypeConfigurationItemProvider = new CustomInvariantSemanticTypeConfigurationItemProvider(this);
		}

		return invariantSemanticTypeConfigurationItemProvider;
	}
}
