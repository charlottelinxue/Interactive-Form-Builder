/**************************
 * @author Charlotte Lin
 * @date 05/28/2015
 * @description model
 **************************/

package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;


public class Model {
	public ServletConfig config;
	
	public Model(ServletConfig config) throws ServletException {
		this.config = config;
		String jdbcDriver = config.getInitParameter("jdbcDriverName");
		String jdbcURL    = config.getInitParameter("jdbcURL");
		
		ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
	}

}
