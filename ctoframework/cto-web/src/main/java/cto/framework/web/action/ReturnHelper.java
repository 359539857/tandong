/**
 * 
 */
package cto.framework.web.action;

import cto.framework.web.action.plugin.schema.Return;


/**
 * @author PeterTan
 * 
 */
public class ReturnHelper {

	public static Return newReturn(String code, String text, String info) {
		Return $rturn = new Return();
		$rturn.setCode(code);
		$rturn.setInfo(info);
		$rturn.setText(text);
		return $rturn;
	}

	public static Return newReturnOk() {
		Return $rturn = new Return();
		$rturn.setCode("0");
		$rturn.setInfo("ok");
		$rturn.setText("ok");
		return $rturn;
	}

	public static Return newReturnFail(String text, String info) {
		Return $rturn = new Return();
		$rturn.setCode("-1");
		$rturn.setInfo(info);
		$rturn.setText(text);
		return $rturn;
	}

	public static Return newReturnFail(String text) {
		Return $rturn = new Return();
		$rturn.setCode("-1");
		$rturn.setInfo("");
		$rturn.setText(text);
		return $rturn;
	}

}
