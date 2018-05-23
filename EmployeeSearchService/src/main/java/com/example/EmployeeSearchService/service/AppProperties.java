/**
 * 
 */
package com.example.EmployeeSearchService.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Sirshendu
 *
 */
@Component
@ConfigurationProperties("director")
public class AppProperties {

	private String name;
	//private List<Menu> menus = new ArrayList<Menu>();
	private Map<String,String> compiler = new HashMap<String,String>();
	
	/*private static class Menu{
		private String name;
        private String path;
        private String title;
        
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		@Override
		public String toString() {
			return "Menu [name=" + name + ", path=" + path + ", title=" + title + "]";
		}
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
*/
	public Map<String, String> getCompiler() {
		return compiler;
	}

	public void setCompiler(Map<String, String> compiler) {
		this.compiler = compiler;
	}

	@Override
	public String toString() {
		return "AppProperties [name=" + name + /*", movies=" + movies + */", compiler=" + compiler + "]";
	}
	
}
