/**
 * 
 */
package cto.framework.service;

import java.util.Map;

import cto.framework.core.CTO;
import cto.framework.core.Constant;

/**
 * @author PeterTan
 * 
 */
public class CTORequest extends CTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -548037585962850064L;

	public CTORequest() {
	}

	public CTORequest(Map<String, Object> map) {
		super(map);
	}

	public CTORequest(String strServiceName, String strTransName) {
		this.setStringValue(Constant.STR_SERVICE_NAME, strServiceName);
		this.setStringValue(Constant.STR_TRANS_NAME, strTransName);
	}
	
	

	@Override
	public String toString() {
		return super.toString();
	}
}
