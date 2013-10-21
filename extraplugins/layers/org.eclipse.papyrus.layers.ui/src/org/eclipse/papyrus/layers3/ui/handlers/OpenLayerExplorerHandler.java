/**
 * 
 */
package org.eclipse.papyrus.layers3.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers3.ui.view.LayersExplorerViewUtils;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Open Layer Explorer ui handler.
 * 
 * @author cedric dumoulin
 *
 */
public class OpenLayerExplorerHandler extends AbstractHandler {

	/**
	 * 
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		LayersExplorerViewUtils.openView(event);
		
		return null;
	}
	
	
	@Override
	public void setEnabled(Object evaluationContext) {
		
		// 
		if(evaluationContext==null) {
			setBaseEnabled(false);
			return;
			
		}
		
		LayersExplorerViewUtils.isViewOpened((IEvaluationContext)evaluationContext);
		setBaseEnabled(true);
		super.setEnabled(evaluationContext);
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 * @throws NotFoundException
	 */
	protected IEvaluationContext getIEvaluationContext(ExecutionEvent event) throws NotFoundException {
		try {
			return (IEvaluationContext)event.getApplicationContext();
		} catch (ClassCastException e) {
			throw new NotFoundException("IEvaluationContext can't be found.");
		}
		
	}


}
