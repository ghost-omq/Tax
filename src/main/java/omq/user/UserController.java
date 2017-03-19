package omq.user;

import omq.model.Complain;

import com.jfinal.core.Controller;

public class UserController extends Controller{
	
	private Complain complain = new Complain().dao();
	
	public void index(){
		renderJsp("listUI.jsp");
	}
	
	public void add(){
	}
	
	public void save(){
		getModel(UserController.class).save();
		redirect("/list");
	}
	
	public void edit(){
		setAttr("edit", complain.findById(getParaToInt()));
	}
	
	public void update(){
		getModel(UserController.class).update();
		redirect("/list");
	}
	
	public void delete(){
		complain.deleteById(getParaToInt());
		redirect("/list");
	}
}
