package org.cocons.uml.ccl;

/**
 * Interface definining ccl-language spezific constants (e.g. ranges).
 * Unfortunatly the constants from org.cocons.uml.ccl.ccldata.types does
 * fit into the schema.
 * Creation date: (08.02.2002 00:16:53)
 * @author: Fadi Chabarek
 */
public interface CCLConstants {

	/**
	 * Constant describing the name of the sterotype a buisness type
	 * can assume.
	 */
	public static final String TYPE = "type";

	/**
	 * Another Constant describing the name of the sterotype a buisness type
	 * can assume.
	 */
	public static final String INFO_TYPE = "info type";

	/**
	 * Constant describing the name of the sterotype a component
	 * can assume.
	 */
	public static final String COMP_SPEC = "comp spec";

	/**
	 * Constant describing the range for direct binding from
	 * a Cocon's set to a model element.
	 */
	public static final String DIRECT_RANGE = "THE";

	/**
	 * Constant describing the range for indirect binding from
	 * a Cocon's set to a model element. Specifically it's the
	 * range 'all'.
	 */
	public static final String INDIRECT_RANGE_ALL = "ALL";







}