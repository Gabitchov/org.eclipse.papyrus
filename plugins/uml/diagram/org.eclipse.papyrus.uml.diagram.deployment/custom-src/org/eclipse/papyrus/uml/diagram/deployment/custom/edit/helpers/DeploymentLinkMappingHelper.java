package org.eclipse.papyrus.uml.diagram.deployment.custom.edit.helpers;

import java.util.Collection;

import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Element;

/**
 * This helper is used to retrieve Link ends for use in drag and drop behavior
 */
public class DeploymentLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * Singleton management
	 */
	private static class SingletonHolder {

		/**
		 * Singleton instance
		 */
		private final static DeploymentLinkMappingHelper instance = new DeploymentLinkMappingHelper();
	}

	/**
	 * Get singleton instance
	 * 
	 * @return the instance
	 */
	public static DeploymentLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private DeploymentLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			@Override
			public java.util.Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
				return object.getSources();
			};

			@Override
			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {
				return object.getEnds();
			};
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			@Override
			public java.util.Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
				return object.getTargets();
			};

			@Override
			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {
				return object.getEnds();
			};
		});
	}

}
