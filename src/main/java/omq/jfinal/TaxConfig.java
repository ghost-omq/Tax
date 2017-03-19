package omq.jfinal;

import omq.model.Complain;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;

public class TaxConfig extends JFinalConfig{

	public void configConstant(Constants me) {
		
	}

	public void configRoute(Routes me) {
		me.add("/index",Index.class);
	}

	public void configEngine(Engine me) {
		
	}

	public void configPlugin(Plugins me) {
		loadPropertyFile("sql.txt");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
		getProperty("user"), getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("complain","comp_id", Complain.class);
	}

	public void configInterceptor(Interceptors me) {
		
	}

	public void configHandler(Handlers me) {
		
	}

}
