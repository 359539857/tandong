/**
 * 
 */
package cto.framework.service.task;

/**
 * @author PeterTan
 * 
 */
public abstract class AbstractTask implements Task {

	public void run() {
		try {
			execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void execute() throws Exception;

}
