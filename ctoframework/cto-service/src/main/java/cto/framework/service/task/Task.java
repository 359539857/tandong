/**
 * 
 */
package cto.framework.service.task;

/**
 * @author PeterTan
 * @param <V>
 * 
 */
public interface Task extends Runnable {

	public void execute() throws Exception;
}
