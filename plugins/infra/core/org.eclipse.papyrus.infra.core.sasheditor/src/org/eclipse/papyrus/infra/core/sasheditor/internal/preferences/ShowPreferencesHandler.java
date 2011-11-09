/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.internal.preferences;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;


/**
 * An handler getting the selected element and reporting them in console.
 * 
 * @author Cedric dumoulin
 * 
 */
public class ShowPreferencesHandler extends AbstractHandler implements IHandler {


	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @param event
	 * @return
	 * @throws ExecutionException
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		

		ITabTooltipPreferences settings = new TabTooltipPreferences();
		
		showPreferences(settings);

		
		return null;
	}

	private void showPreferences(ITabTooltipPreferences settings) {
		
		System.out.println( ITabTooltipPreferences.isTooltipEnable + "=" + settings.isTooltipEnable());
		System.out.println( ITabTooltipPreferences.isTooltipForCurrentTabShown + "=" + settings.isTooltipForCurrentTabShown());
		System.out.println( ITabTooltipPreferences.scaledFactor + "=" + settings.getScaledFactor());
		System.out.println( ITabTooltipPreferences.scaledFactor + "(int)=" + settings.getIntScaledFactor());
		System.out.println( ITabTooltipPreferences.tooltipAutoCloseDelay + "=" + settings.getTooltipAutoCloseDelay());
		
	}

	/**
	 * Get the name used in the {@link RecordingCommand}. This name will be visible in 
	 * undo/redo.
	 * 
	 * @return The command name to show.
	 */
	public String getCommandName() {
		return "Read Preferences";
	}


}
