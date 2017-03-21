package omq.user;

import java.util.UUID;

import com.jfinal.core.Controller;

public class UserController extends Controller{
	
	private User user = new User().dao();
	
	public void index(){
		Controller setAttr = setAttr("userPage", User.me.paginate(getParaToInt(0, 1), 10));
		System.out.println(setAttr);
		renderJsp("listUI.jsp");
		
	}
	
	public void add(){
		renderJsp("addUI.jsp");
	}
	
	public void save(){
		User model = getModel(User.class);
		String id = UUID.randomUUID().toString().replace("-", "");
		model.setId(id);
		model.save();
		redirect("/user");
	}
	
	public void edit(){
		setAttr("edit", user.findById(getParaToInt()));
	}
	
	public void update(){
		getModel(UserController.class).update();
		redirect("/list");
	}
	
	public void delete(){
		user.deleteById(getParaToInt());
		redirect("/list");
	}
}
