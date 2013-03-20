/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.designer.bundle;

import java.util.ArrayList;

import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Stereotype;
import org.osgi.framework.Constants;


public abstract class AbstractBundleDescriptionDesigner implements IBundleDescriptionDesigner {
	/**
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#getBundleValue(java.lang.Object, java.lang.String)
	 *
	 * @param bundleProject
	 * @param key
	 * @return
	 */
	
	public abstract String  getBundleValue( Object bundleProject, String key);
	
	/**
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#fillPluginProperties(org.eclipse.uml2.uml.Component, org.osgi.framework.Bundle)
	 *
	 * @param bundleComponent
	 * @param bundleProject
	 */
	
	public void fillPluginProperties(Component bundleComponent,Object bundleProject ){
		Stereotype pluginStereotype= bundleComponent.getAppliedStereotype(IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE);
		//bundleProject.getHeader(Constants.BUNDLE_ACTIVATIONPOLICY);
		String activationPolicy=getBundleValue( bundleProject, Constants.BUNDLE_ACTIVATIONPOLICY);
		if("lazy".equals(activationPolicy)){
			bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_HASLAZYACTIVATIONPOLICY_ATT, true);
		}
		else if(activationPolicy==null){
			bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_HASLAZYACTIVATIONPOLICY_ATT, null);
		}
		else{
			bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_HASLAZYACTIVATIONPOLICY_ATT, null);
		}

		//Constants.BUNDLE_ACTIVATOR;
		String activator=getBundleValue( bundleProject, Constants.BUNDLE_ACTIVATOR);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_ACTIVATOR_ATT, activator);
		// BUNDLE_CATEGORY
		String category=getBundleValue( bundleProject, Constants.BUNDLE_CATEGORY);
		if(category==null){
			bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_CATEGORY_ATT, category);
		}
		//Constants.BUNDLE_CLASSPATH
		String class_path=getBundleValue( bundleProject, Constants.BUNDLE_CLASSPATH);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_CLASSPATH_ATT, class_path);

		//Constants.BUNDLE_CONTACTADDRESS
		String contactAdress=getBundleValue( bundleProject, Constants.BUNDLE_CONTACTADDRESS);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_CONTACTADDRESS_ATT, contactAdress);

		// Constants.BUNDLE_COPYRIGHT
		String copyright=getBundleValue( bundleProject, Constants.BUNDLE_COPYRIGHT);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_COPYRIGHT_ATT, copyright);
		//BUNDLE_DESCRIPTION
		String description=getBundleValue( bundleProject, Constants.BUNDLE_DESCRIPTION);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_DESCRIPTION_ATT, description);

		//BUNDLE_DOCURL
		String docurl=getBundleValue( bundleProject, Constants.BUNDLE_DOCURL);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_DOCURL_ATT, docurl);

		//BUNDLE_LOCALIZATION
		String localization=getBundleValue( bundleProject, Constants.BUNDLE_LOCALIZATION);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_LOCALIZATION_ATT, localization);
		//Constants.BUNDLE_MANIFESTVERSION
		String manisfestVerion=getBundleValue( bundleProject, Constants.BUNDLE_MANIFESTVERSION);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_NAME_ATT, manisfestVerion);
		//BUNDLE_NAME
		String name=getBundleValue( bundleProject, Constants.BUNDLE_NAME);
		//String buddypolicy=getBundleValue( bundleProject, BUDDY_LOADER);
		if (name!=null && name.toLowerCase().contains("incubation")){
			bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_ISINCUBATION_ATT, true);}
		else{
			bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_ISINCUBATION_ATT, false);
		}

		name=name.replace("(Incubation)", "");
		name=name.replace("(incubation)", "");
		name=name.replace("Incubation", "");
		name=name.replace("incubation", "");

		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_NAME_ATT, name.trim());
		//BUNDLE_NATIVECODE
		String nativeCode=getBundleValue( bundleProject, Constants.BUNDLE_NATIVECODE);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_NATIVECODE_ATT, nativeCode);
		//	String nativeCodeLanguage=getBundleValue( bundleProject, Constants.BUNDLE_NATIVECODE_LANGUAGE);
		//String activator=getBundleValue( bundleProject, Constants.BUNDLE_NATIVECODE_OSNAME);
		//String activator=getBundleValue( bundleProject, Constants.BUNDLE_NATIVECODE_OSVERSION);
		//String activator=getBundleValue( bundleProject, Constants.BUNDLE_NATIVECODE_PROCESSOR);

		//BUNDLE_REQUIREDEXECUTIONENVIRONMENT
		String requiredExecutionEnv=getBundleValue( bundleProject, Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_REQUIREDEXECUTIONENVIRONMENT_ATT, requiredExecutionEnv);
		//BUNDLE_SYMBOLICNAME
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_SYMBOLICNAME_ATT,getSymbolicName(bundleProject));

		//Constants.BUNDLE_UPDATELOCATION
		String updateLocation=getBundleValue( bundleProject, Constants.BUNDLE_UPDATELOCATION);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_UPDATELOCATION_ATT, updateLocation);

		//String activator=getBundleValue( bundleProject, Constants.BUNDLE_VENDOR);
		String vendor=getBundleValue( bundleProject, Constants.BUNDLE_VENDOR);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_VENDOR_ATT, vendor);

		//String activator=getBundleValue( bundleProject, Constants.BUNDLE_VERSION);
		String version=getBundleValue( bundleProject, Constants.BUNDLE_VERSION);
		bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_VERSION_ATT, version);
		//String activator=getBundleValue( bundleProject, Constants.BUNDLE_VERSION_ATTRIBUTE);

		//PLUGIN ATTRIBUTE
		//http://help.eclipse.org/juno/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fmisc%2Fbundle_manifest.html
		//Eclipse-LazyStart ::= ( 'true' | 'false' ) ( ';' 'exceptions' '=' '"' exceptions-list '"' ) ?
		//	exceptions-list ::= a comma ',' separated list of packages
		String lazystartExpression=getBundleValue( bundleProject, ECLIPSE_LAZYSTART);
		if (lazystartExpression!=null){
			boolean lazyStartValue;
			if( lazystartExpression.contains(";")){
				String lazyStartString= lazystartExpression.substring(0, lazystartExpression.indexOf(";"));
				lazyStartValue= Boolean.valueOf(lazyStartString);
				String lazyStartException= lazystartExpression.substring(lazystartExpression.indexOf(";"));
				//TODO: lazystartExpression
				//bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTARTEXCEPTION_ATT,lazyStartException );
			}
			else{
				lazyStartValue= Boolean.valueOf(lazystartExpression);
				bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTART_ATT,lazyStartValue );
				bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTARTEXCEPTION_ATT,new ArrayList()  );
			}
		}else{
			bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTART_ATT,null );
			bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTARTEXCEPTION_ATT, new ArrayList() );
		}



		//IADL4ECLIPSE_Stereotype.PLUGIN_BUDDYPOLICY_ATT
		String buddypolicy=getBundleValue( bundleProject, ECLIPSE_BUDDY_LOADER);
		//bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_BUDDYPOLICY_ATT, buddypolicy);
		//IADL4ECLIPSE_Stereotype.PLUGIN_BUNDLESHAPE_ATT
		String bundleShape=getBundleValue( bundleProject, ECLIPSE_BUNDLE_SHAPE);
		//bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_BUDDYPOLICY_ATT, buddypolicy);
		//IADL4ECLIPSE_Stereotype.PLUGIN_CAPABILITY_ATT
		String capability=getBundleValue( bundleProject, ECLIPSE_GENERICCAPABILITY);
		//bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_CAPABILITY_ATT, capability);
		//IADL4ECLIPSE_Stereotype.PLUGIN_EXTENSIBLEAPI_ATT
		//String buddypolicy=getBundleValue( bundleProject, BUDDY_LOADER);
		//bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_BUDDYPOLICY_ATT, buddypolicy);
		//IADL4ECLIPSE_Stereotype.PLUGIN_GENERICCAPABILITYALIAS_ATT
		//String capabilityAlias=getBundleValue( bundleProject, ECLIPSE_GENERICCAPABILITY);
		//bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_BUDDYPOLICY_ATT, buddypolicy);
		//IADL4ECLIPSE_Stereotype.PLUGIN_ISINCUBATION_ATT

		//IADL4ECLIPSE_Stereotype.PLUGIN_PLATFORMFILTER_ATT
		String platformFilter=getBundleValue( bundleProject, ECLIPSE_PLATFORMFILTER);
		bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_PLATFORMFILTER_ATT, platformFilter);
		//IADL4ECLIPSE_Stereotype.PLUGIN_REQUIRECAPABILITY_ATT
		//String buddypolicy=getBundleValue( bundleProject, ECLIPSE_);
		//bundleComponent.setValue(pluginStereotype, IADL4ECLIPSE_Stereotype.PLUGIN_BUDDYPOLICY_ATT, buddypolicy);


	}
	
	
	
}
