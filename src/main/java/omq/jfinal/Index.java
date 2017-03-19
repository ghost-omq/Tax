package omq.jfinal;

import java.util.Date;

import omq.model.Complain;

import com.jfinal.core.Controller;

public class Index extends Controller{
	public void index(){
		Complain complain = new Complain();
	/*
		complain.setComp_id("2");
		complain.setComp_company("A");
		complain.setComp_name("Jack");
		complain.setComp_mobile("123");
		complain.setIs_NM(1);
		complain.setComp_time(new Date());
		complain.setComp_title("comp");
		complain.setTo_comp_name("Tom");
		complain.setTo_comp_dept("D");
		complain.setComp_content("content");
		complain.setState("1");
		complain.save();
	*/
		
	
		complain = complain.findById("2");
		String comp_name = complain.getComp_name();
		complain.setComp_name("jerry");
		boolean update = complain.update();
		System.out.println(update);
		
	/*
		boolean deleteById = complain.deleteById("3");		
		
	*/
		render("index.html");
		
		
	}
}
