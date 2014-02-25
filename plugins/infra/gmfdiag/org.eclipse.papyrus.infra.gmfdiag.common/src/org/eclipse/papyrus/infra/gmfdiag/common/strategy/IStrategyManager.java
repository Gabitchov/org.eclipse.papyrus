package org.eclipse.papyrus.infra.gmfdiag.common.strategy;

import java.util.List;

public interface IStrategyManager {

	boolean isActive(IStrategy strategy);

	void setActive(IStrategy strategy, boolean isActive);

	int findPriority(IStrategy otherStrategy);

	void setPriority(IStrategy strategyToMove, int newPriority);

	List<IStrategy> getAllStrategies();

	void restoreDefaults();

}
