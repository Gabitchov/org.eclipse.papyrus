package org.eclipse.papyrus.infra.hyperlink.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.swt.custom.CTabFolder;


public abstract class AbstractHyperLinkTab {

	private String tabId;

	protected AbstractHyperLinkHelper hyperLinkHelper;

	protected List<HyperLinkObject> hyperlinkObjects;

	protected CTabFolder cTabFolder;

	protected EObject element;

	//TODO can not be used!
	@Deprecated
	public AbstractHyperLinkTab(final String tabId, CTabFolder cTabFolder, AbstractHyperLinkHelper hyperLinkHelper, List<HyperLinkObject> hyperlinkObjects, final EObject element) {
		this.tabId = tabId;
		this.cTabFolder = cTabFolder;
		this.hyperLinkHelper = hyperLinkHelper;
		this.hyperlinkObjects = hyperlinkObjects;
		this.element = element;
	}

	public AbstractHyperLinkTab(final String tabId) {
		this.tabId = tabId;
	}
	
	public AbstractHyperLinkTab(){
		//nothing to do
		//used to create the tab from the extension point
	}

	public final String getTabId() {
		return this.tabId;
	}

	public abstract void setInput(final List<HyperLinkObject> hyperLinkObjectList);

	public void setTabId(String tabId){
		if(this.tabId == null) {
			this.tabId = tabId;
		}
	}
	

	public void init(final CTabFolder cTabFolder, List<HyperLinkObject> hyperlinkObjects, final EObject element) {
		if(cTabFolder == null) {
			this.cTabFolder = cTabFolder;
		}
//		if(this.hyperLinkHelper == null) {
//			this.hyperLinkHelper = hyperLinkHelper;
//		}
		if(this.hyperlinkObjects == null) {
			this.hyperlinkObjects = hyperlinkObjects;
		}
		if(this.element == null) {
			this.element = element;
		}

	}
	//	public void refresh(){
	//		
	//	}
	
	public List<HyperLinkObject> getHyperlinkObjects(){
		return this.hyperlinkObjects;
	}
}
