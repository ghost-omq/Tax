package omq.user;

import java.util.UUID;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class UserController extends Controller{
	
	private User user = new User().dao();
	
	public void index(){
		Page<User> paginate = User.me.paginate(getParaToInt(0, 1), 10);
		Controller setAttr = setAttr("userPage",paginate);
		render("listUI.html");
		
	}
	
	public void add(){
		render("addUI.html");
	}
	
	public void save(){
		User model = getModel(User.class);
		String id = UUID.randomUUID().toString().replace("-", "");
		model.setId(id);
		model.save();
		redirect("/user");
	}
	
	public void edit(){
		String para = getPara();
		User findById = user.findById(para);
		setAttr("user", findById);
		render("editUI.html");
		
	}
	
	public void update(){
		User model = getModel(User.class);
		model.update();
		redirect("/user");
	}
	
	public void delete(){
		String para = getPara();
		boolean deleteById = user.deleteById(para);
		redirect("/user");
	}
}
