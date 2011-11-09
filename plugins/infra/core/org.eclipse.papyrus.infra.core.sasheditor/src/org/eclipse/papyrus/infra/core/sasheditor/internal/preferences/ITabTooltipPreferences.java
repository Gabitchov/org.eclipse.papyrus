package org.eclipse.papyrus.infra.core.sasheditor.internal.preferences;



public interface ITabTooltipPreferences {

	/**
	 * Constant used in Eclipse preferences
	 */
	public String isTooltipEnable = "isTooltipEnable";
	public String isTooltipForCurrentTabShown = "isTooltipForCurrentTabShown";
	public String scaledFactor = "scaledFactor";
	public String tooltipAutoCloseDelay = "tooltipAutoCloseDelay";
	
	
	/**
	 * Is the tooltip Enable ?
	 * If true, tooltip are displayed.
	 * If false, they are not displayed.
	 * 
	 * @return
	 */
	public abstract boolean isTooltipEnable();

	/**
	 * Is an tooltip shown when the flied tabs is the tab for the cuurently shown diagram ?
	 * If true, the tooltip is shown.
	 * If false, the tooltip is not shown.
	 * 
	 * @return
	 */
	public abstract boolean isTooltipForCurrentTabShown();

	/**
	 * 
	 * @return
	 */
	public abstract float getScaledFactor();

	/**
	 * 
	 * @return
	 */
	public int getIntScaledFactor();
	
	/**
	 * Return the delay used to close automatically the tooltip.
	 * @return The delay in millisecond or -1 if there is no delay.
	 */
	public abstract int getTooltipAutoCloseDelay();

}
