package omq.jfinal;

import omq.model.Complain;
import omq.user.User;
import omq.user.UserController;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class TaxConfig extends JFinalConfig{

	public void configConstant(Constants me) {
		//me.setBaseUploadPath("upload");
	}

	public void configRoute(Routes me) {
		me.setBaseViewPath("WEB-INF/jsp");
		me.add("/index",Index.class);
		me.add("/user",UserController.class,"nsfw/user");
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
		arp.addMapping("user", "id",User.class);
	}

	public void configInterceptor(Interceptors me) {
		
	}

	public void configHandler(Handlers me) {
		
	}

}
