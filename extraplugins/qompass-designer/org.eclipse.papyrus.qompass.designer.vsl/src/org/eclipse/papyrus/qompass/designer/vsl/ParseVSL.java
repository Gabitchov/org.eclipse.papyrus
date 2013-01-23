package org.eclipse.papyrus.qompass.designer.vsl;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.MARTE.utils.MarteUtils;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.DataSizeUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.FrequencyUnitKind;
import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.TimeUnitKind;
import org.eclipse.papyrus.marte.vsl.VSLStandaloneSetupGenerated;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;


public class ParseVSL {

	private Injector injector;

	private static final String SYNTHETIC_SCHEME = "synthetic";


	/**
	 * Parse a VSL expression and return an xtext resource. Users should check for parsing
	 * errors (getErrors). The resulting set of eObjects is available via the getContents
	 * operations (as usual).
	 * 
	 * @param expression
	 *        a VSL expression
	 * @return a resource relating to the expression.
	 */
	public XtextResource getXtextResource(String expression) {
		if(injector == null) {
			VSLStandaloneSetupGenerated setup = new VSLStandaloneSetupGenerated();
			injector = setup.createInjectorAndDoEMFRegistration();
		};
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		IGrammarAccess grammarAccess = injector.getInstance(IGrammarAccess.class);

		XtextResource xtextResource = (XtextResource)resourceFactory.createResource(
			URI.createURI(SYNTHETIC_SCHEME + ":/" + grammarAccess.getGrammar().getName() + ".vsl"));

		try {
			xtextResource.load(new StringInputStream(expression, xtextResource.getEncoding()), Collections.emptyMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return xtextResource;
	}

	/**
	 * test function
	 * 
	 * @param expression
	 *        a VSL expression
	 */
	public static void parseTest(String expression) {
		ParseVSL parseVSL = new ParseVSL();
		XtextResource xtextResource = parseVSL.getXtextResource(expression);
		if(xtextResource.getErrors().size() > 0) {
			for(Resource.Diagnostic error : xtextResource.getErrors()) {
				System.err.println(error);
			}
			return;
		}
		EList<EObject> contents = xtextResource.getContents();
		System.out.println("contents.size: " + contents.size());
	}

	public static int getSizeFromVSL(String nfpDatasize) {
		if(nfpDatasize != null) {
			String unit = MarteUtils.getValueFromTuple(nfpDatasize, "unit");
			String value = MarteUtils.getValueFromTuple(nfpDatasize, "value");
			return Float.valueOf(value).intValue() * getMultiplicatorFromSizeUnit(unit);
		}
		return 0;
	}

	// >>> TODO: from here: ad-hoc functions to retrieve values via simple parser

	/**
	 * Get the duration in micro-seconds
	 * 
	 * 
	 * @param nfpDuration
	 * @return
	 */
	public static long getDurationFromVSL(String nfpDuration) {
		if(nfpDuration != null) {
			String unit = MarteUtils.getValueFromTuple(nfpDuration, "unit");
			String value = MarteUtils.getValueFromTuple(nfpDuration, "value");
			return Float.valueOf(value).intValue() * getMultiplicatorFromTimeUnit(unit);
		}
		return 0;
	}

	/**
	 * Get the frequency in HZ
	 * 
	 * @param
	 * @return
	 */
	public static long getFrequencyFromVSL(String nfpFrequency) {
		if(nfpFrequency != null) {
			String unit = MarteUtils.getValueFromTuple(nfpFrequency, "unit");
			String value = MarteUtils.getValueFromTuple(nfpFrequency, "value");
			return (int)(Float.valueOf(value) * getMultiplicatorFromFrequencyUnit(unit));
		}
		return 0;
	}

	public static long getPeriodFromArrivalPattern(String arrivalPattern) {
		if(arrivalPattern != null) {
			String period = MarteUtils.getValueFromTuple(arrivalPattern, "period");
			return getDurationFromVSL(period);
		}
		return 0;
	}

	public static int getMultiplicatorFromSizeUnit(String unit) {
		DataSizeUnitKind dsuk = DataSizeUnitKind.get(unit);
		if(dsuk == DataSizeUnitKind.BYTE) {
			return 1;
		} else if(dsuk == DataSizeUnitKind.KB) {
			return 1024;
		} else if(dsuk == DataSizeUnitKind.MB) {
			return 1024 * 1024;
		} else if(dsuk == DataSizeUnitKind.GB) {
			return 1024 * 1024 * 1024;
		} else {
			// do not support bits here.
			throw new RuntimeException("Error parsing VSL expression, unexpected size unit (expecting byte, kb, mb, or gb): '" + unit + "'");
		}
	}

	/**
	 * return the time multiplicator based on micro-seconds unit
	 * 
	 * @param unit
	 * @return
	 */
	public static long getMultiplicatorFromTimeUnit(String unit) {
		TimeUnitKind tuk = TimeUnitKind.get(unit);
		if(tuk == TimeUnitKind.US) {
			return 1;
		}
		if(tuk == TimeUnitKind.MS) {
			return 1000;
		} else if(tuk == TimeUnitKind.S) {
			return 1000 * 1000;
		} else if(tuk == TimeUnitKind.MIN) {
			return 60 * 1000 * 1000;
		} else {
			throw new RuntimeException("Error parsing VSL expression, unexpected duration unit (expecting us, ms, s or min): '" + unit + "'");
		}
	}

	public static float getMultiplicatorFromFrequencyUnit(String unit) {
		FrequencyUnitKind fuk = FrequencyUnitKind.get(unit);
		if(fuk == FrequencyUnitKind.HZ) {
			return 1;
		} else if(fuk == FrequencyUnitKind.KHZ) {
			return 1000;
		} else if(fuk == FrequencyUnitKind.MHZ) {
			return 1000 * 1000;
		} else if(fuk == FrequencyUnitKind.GHZ) {
			return 1000 * 1000 * 1000;
		} else if(fuk == FrequencyUnitKind.RPM) {
			return 1 / 60;
		} else {
			// do not support bits here.
			throw new RuntimeException("Error parsing VSL expression, unexpected frequency unit (expecting Hz, KHz, MHz, GHz or rpm: '" + unit + "'");
		}
	}
}
