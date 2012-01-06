package org.eclipse.papyrus.infra.hyperlink.object;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.hyperlink.Activator;

public abstract class AbstractHyperLinkEditor extends HyperLinkObject {

	@Override
	public void executeSelectPressed() {
			IPageMngr pageMngr=getPageManager();
			try {
				pageMngr.openPage(getObject());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * 
	 * @return
	 * the IPageManager
	 */
	protected IPageMngr getPageManager() {
		IPageMngr pageMngr = null;
		try {
			pageMngr = org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers.getInstance().getIPageMngr();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return pageMngr;
	}
	
	
}
